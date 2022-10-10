package rahulshettyacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshetttyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent{
	
	WebDriver driver;
	public ProductCatalog(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	By ProductsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	public List<WebElement> getProductList() {
		
		waitForElementToAppear(ProductsBy);
		return products;
		
	}
	public WebElement getProductName(String Productname) {
		WebElement Product=getProductList().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
		return Product;
		
	}
	public void addToCart(String Productname) throws InterruptedException {
		WebElement prod= getProductName(Productname);
		prod.findElement(addToCart).click();
		Thread.sleep(2000);
		
		//w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	}
	
	
	
}
