package rahulshettyacademy.testcomponent;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageObjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	
	
	public WebDriver initializeDriver() throws IOException {
	//properties class in java to read globaldata. properties file	
		Properties prop=new Properties();
		String filePath =System.getProperty("user.dir")+"/src/main/java/rahulshettyacademy/resources/GlobalData.properties";
		FileInputStream fis=new FileInputStream(filePath);
		//to convert file to instream weuse above step
		//prop.load(inStream);
		prop.load(fis);//reading ur file of globaldata.properties in input stream format
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
        //String browserName=prop.getProperty("browser");
		//thus getting browser property like extract value of globaldata where it mentioned what browser and storing that browser name in a variable
		if(browserName.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			
			}
			driver=new ChromeDriver(options);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		      // set size with window.resizeTo() method
		      js.executeScript("window.resizeTo(1440,900);");







			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
			
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	public List<HashMap<String,String>> getJsconToMap(String filePath) throws IOException
	{
		//read and convert jscon to string
		String jsconformat=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsconformat, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
		
	}
	
		@BeforeMethod(alwaysRun=true)
		public LandingPage launchingApplication() throws IOException
		{
			driver=initializeDriver();
			landingPage=new LandingPage(driver);
			landingPage.goTo();
			return landingPage;
			
		}
		@AfterMethod(alwaysRun=true)
		public void tearDown()
		{
			driver.close();
						
		}
	
	}

