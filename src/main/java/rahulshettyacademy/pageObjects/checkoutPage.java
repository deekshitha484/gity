package rahulshettyacademy.pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshetttyacademy.AbstractComponents.AbstractComponent;

public class checkoutPage extends AbstractComponent{
	
	
	
	WebDriver driver;
	public checkoutPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//intialize driver object in contructor to standalone driver and then come out of this method.
		
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement SelectCountry;
	@FindBy(css="span[class='ng-star-inserted']")
	List<WebElement> countryoptions;
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement placeOrder;
	
	public void countryTypo(String countryN) {
	
	SelectCountry.sendKeys(countryN);

	}
	public WebElement getCountryOptions(String countryName)
	{
		
		WebElement country=countryoptions.stream().filter(s->s.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
		return country;
	
		
	}
	public void clickOnCountry(String countryName )
	{
		WebElement location=getCountryOptions(countryName);
		location.click();
		
	}
	public confirmationpage placeOrder() {
		placeOrder.click();
		confirmationpage confirmpage=new confirmationpage(driver);
		return confirmpage;
	}
	
}