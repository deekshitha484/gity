package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageObjects.LandingPage;
import rahulshettyacademy.pageObjects.ProductCatalog;
import rahulshettyacademy.pageObjects.cartPage;
import rahulshettyacademy.pageObjects.checkoutPage;
import rahulshettyacademy.pageObjects.confirmationpage;
import rahulshettyacademy.testcomponent.BaseTest;
import rahulshettyacademy.testcomponent.RetryAnalyzer;

public class ErrorValidationsLogin extends BaseTest{
	String productName="ZARA COAT 3";
	
	@Test(groups={"error"},retryAnalyzer=RetryAnalyzer.class)
	public void loginErrorValidation() throws InterruptedException {
		
		ProductCatalog productcatlog=landingPage.loginApplication("deeksitha200@gmail.com", "DeeRan@2122");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
}
@Test
public void productErrorValidation() throws InterruptedException {
    

     String productName="ZARA COAT 3";
	
	ProductCatalog productcatlog=landingPage.loginApplication("deekshitha484@gmail.com", "DeeRan@2122");
	//wait and product catalog
    List<WebElement>products=productcatlog.getProductList();
	productcatlog.addToCart(productName);
	cartPage cartpage=productcatlog.goToCart();
	Boolean match=cartpage.verifyProductDisplay("zaraaa");
	Assert.assertFalse(match);
		
		
		
		
		 
		

		
		
		
		}
	

}
