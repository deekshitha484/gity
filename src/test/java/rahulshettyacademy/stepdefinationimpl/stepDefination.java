package rahulshettyacademy.stepdefinationimpl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.pageObjects.LandingPage;
import rahulshettyacademy.pageObjects.ProductCatalog;
import rahulshettyacademy.pageObjects.cartPage;
import rahulshettyacademy.pageObjects.checkoutPage;
import rahulshettyacademy.pageObjects.confirmationpage;
import rahulshettyacademy.testcomponent.BaseTest;

public class stepDefination extends BaseTest {
	public LandingPage landingpage;
	public ProductCatalog productcatlog;
	public confirmationpage confirmpage;
	
	
	@Given("I landed on Ecommerce site")
	public void I_landed_on_Ecommerce_site()throws IOException
	{
		landingpage=launchingApplication();
	}
	
	@Given("^login with username (.+) and password (.+)$")
	public void login_with_username_and_password (String username,String password)
	{
		productcatlog=landingPage.loginApplication(username,password);
	}
	
	@When("^I add product (.+) in to the cart$")
	public void I_add_product_in_to_the_cart(String productName) throws InterruptedException {
		List<WebElement>products=productcatlog.getProductList();
		productcatlog.addToCart(productName);
		
	}
	
	@And("^checkout with product (.+)$")
	public void checkout_with_product(String product)
	{
		cartPage cartpage=productcatlog.goToCart();
		Boolean match=cartpage.verifyProductDisplay(product);
		Assert.assertTrue(match);
		checkoutPage checkoutpage=cartpage.goToCheckOut();
		checkoutpage.countryTypo("ind");
		checkoutpage.clickOnCountry("india");
	 confirmpage=checkoutpage.placeOrder();
	}
	
	@Then("{string} is displayed on confirmation page")
	public void message_is_displayed_on_confirmation_page(String string)
	{
		String confirmmessage=confirmpage.verifyConfirmMessage();
		Assert.assertTrue(confirmmessage.equalsIgnoreCase(string));
		
	}
	
	@Then("{string} is displayed on login page")
	public void error_message_is_dispalyed_on_login_page(String string) {
	//login data comes from errorvalidations.feature from examples table
		
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.close();
	}
	
}
