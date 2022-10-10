package rahulshettyacademy.pageObjects;





import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshetttyacademy.AbstractComponents.AbstractComponent;

public class orderPage extends AbstractComponent{
	
	
	
	WebDriver driver;
	public orderPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//intialize driver object in contructor to standalone driver and then come out of this method.
		
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	public Boolean verifyProductDisplay(String product)
	{
		
		Boolean match=productNames.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		return match;
	}
	
}
