package rahulshettyacademy.pageObjects;





import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshetttyacademy.AbstractComponents.AbstractComponent;

public class confirmationpage extends AbstractComponent{
	
	
	
	WebDriver driver;
	public confirmationpage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//intialize driver object in contructor to standalone driver and then come out of this method.
		
	}
	@FindBy(tagName="h1")
	WebElement confirmmessage;
	public String verifyConfirmMessage()
	{
		return confirmmessage.getText();
	}
	
}
