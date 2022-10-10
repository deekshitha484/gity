package rahulshettyacademy.pageObjects;





import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshetttyacademy.AbstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent{
	
	
	
	WebDriver driver;
	public cartPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//intialize driver object in contructor to standalone driver and then come out of this method.
		
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> productTitles;
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutEle;
	public Boolean verifyProductDisplay(String product)
	{
		
		Boolean match=productTitles.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		return match;
	}
	
	public checkoutPage goToCheckOut() {
		checkoutEle.click();
		checkoutPage checkoutpage=new checkoutPage(driver);
		return checkoutpage;
	}
	
	
}
