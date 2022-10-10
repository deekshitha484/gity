package rahulshettyacademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetttyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	
	
	WebDriver driver;
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//intialize driver object in contructor to standalone driver and then come out of this method.
		
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//only save locators..not what sud b done
	@FindBy(id="userEmail")
	WebElement Email;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(css="input[value='Login']")
	WebElement submit;
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement errormessage;
	
			
	//no need to write css selector
	//now we have all the locators and now mention what actions sud b done on this locators in seperate class
	
	public ProductCatalog loginApplication(String userEmail,String userPassword){
		Email.sendKeys(userEmail);
		password.sendKeys(userPassword);
		submit.click();
		ProductCatalog productcatlog=new ProductCatalog(driver);
		return productcatlog;
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errormessage );
		return errormessage.getText();
	}
	
}
