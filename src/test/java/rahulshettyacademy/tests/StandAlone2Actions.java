package rahulshettyacademy.tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.bouncycastle.asn1.dvcs.Data;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageObjects.LandingPage;
import rahulshettyacademy.pageObjects.ProductCatalog;
import rahulshettyacademy.pageObjects.cartPage;
import rahulshettyacademy.pageObjects.checkoutPage;
import rahulshettyacademy.pageObjects.confirmationpage;
import rahulshettyacademy.pageObjects.orderPage;
import rahulshettyacademy.testcomponent.BaseTest;

public class StandAlone2Actions extends BaseTest{
	 String productName="ZARA COAT 3";
@Test(dataProvider= "getData",groups={"purchase"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException {
	    
	
	    
		
		ProductCatalog productcatlog=landingPage.loginApplication(input.get("email"),input.get("password"));
		//wait and product catalog
	    List<WebElement>products=productcatlog.getProductList();
		productcatlog.addToCart(input.get("product"));
		cartPage cartpage=productcatlog.goToCart();
		Boolean match=cartpage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		checkoutPage checkoutpage=cartpage.goToCheckOut();
		checkoutpage.countryTypo("ind");
		checkoutpage.clickOnCountry("india");
		confirmationpage confirmpage=checkoutpage.placeOrder();
		String confirmmessage=confirmpage.verifyConfirmMessage();
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));
		}


@Test(dependsOnMethods={"submitOrder"})
public void OrderHistoryPage() throws InterruptedException{
	ProductCatalog productcatlog=landingPage.loginApplication("deekshitha484@gmail.com","DeeRan@2122");
	orderPage orderPage=productcatlog.goToOrderPage();
	Assert.assertTrue(orderPage.verifyProductDisplay(productName));
	
}
@DataProvider 
public Object[][] getData() throws IOException {
	
//	HashMap<String,String> map=new HashMap<String,String>();
//	map.put("email", "deekshitha484@gmail.com");
//	map.put("password", "DeeRan@2122");
//	map.put("product","ZARA COAT 3" );
//	HashMap<String,String> map1=new HashMap<String,String>();
//	map1.put("email", "deekshitha494@gmail.com");
//	map1.put("password", "DeeRan@2122");
//	map1.put("product","ADIDAS ORIGINAL" );
//	return new Object[][] {{map},{map1}};

	List<HashMap<String,String>> data=getJsconToMap(System.getProperty("user.dir") +"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");


	return new Object[][] {{data.get(0)},{data.get(1)}};
}

	

}
