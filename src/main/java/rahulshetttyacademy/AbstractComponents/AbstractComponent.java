package rahulshetttyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageObjects.cartPage;
import rahulshettyacademy.pageObjects.orderPage;

public class AbstractComponent<OrderPage> {
	WebDriver driver;
	public AbstractComponent(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderheader;

	public void waitForElementToAppear(By FindBy){
		
	
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(7));
	w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FindBy));
	}
	public void waitForElementToDisppear(WebElement ele)  {
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(7));
		w.until(ExpectedConditions.invisibilityOf(ele));
		//return type is not By bcz there was driver.find element
		
	}
	public void waitForWebElementToAppear(WebElement ele){
		
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(7));
		w.until(ExpectedConditions.visibilityOf(ele));
		}
	public cartPage goToCart()
	{
		cart.click();
		cartPage cartpage=new cartPage(driver);
		return cartpage;
	}
	public orderPage goToOrderPage()
	{
		orderheader.click();
		orderPage orderpage =new orderPage(driver);
		return orderpage;
	}

}
