

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

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageObjects.LandingPage;

public class StandAlone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String name="ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage=new LandingPage(driver);
		driver.manage().window().maximize();
		
		/*driver.findElement(By.className("text-reset")).click();
		driver.findElement(By.id("firstName")).sendKeys("lalith");
		driver.findElement(By.id("lastName")).sendKeys("rao");
		driver.findElement(By.id("userEmail")).sendKeys("deekshitha494@gmail.com");
		 
		driver.findElement(By.id("userMobile")).sendKeys("9885004167");
		WebElement Name=driver.findElement(By.cssSelector("[formcontrolname='occupation']"));
		Select dropdowns=new Select(Name);
		dropdowns.selectByVisibleText("Engineer");
		driver.findElement(By.cssSelector("[value='Female']")).click();
		driver.findElement(By.id("userPassword")).sendKeys("DeeRan@2122");
		driver.findElement(By.id("confirmPassword")).sendKeys("DeeRan@2122");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.id("login")).click();
		Thread.sleep(4000);
		*/ //driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.id("userEmail")).sendKeys("deekshitha494@gmail.com");
		
		driver.findElement(By.id("userPassword")).sendKeys("DeeRan@2122");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(7));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		 
		List<WebElement> product2=driver.findElements(By.cssSelector(".mb-3"));
		WebElement Pro2=product2.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().orElse(null);
		Pro2.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//now i have to wait until msg "product added to cart "is dispalyed.
		
		//ng-animating===>this sud become invisible
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cart=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cart.stream().anyMatch(s->s.getText().equalsIgnoreCase(name));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
		List<WebElement> countryAutoSug=driver.findElements(By.cssSelector("span[class='ng-star-inserted']"));
		WebElement country=countryAutoSug.stream().filter(s->s.getText().equalsIgnoreCase("india")).findFirst().orElse(null);
		country.click();
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		driver.findElement(By.cssSelector(".mt-3")).click();
		String confirmmessage=driver.findElement(By.tagName("h1")).getText();
		
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
		
		
		 
		
		
		
		
		
		}
	

}
