package baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	
	public static WebDriver driver;
	 
	@BeforeMethod
	public void launchApplication() throws Exception {
 
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://qa.ezhour.com/landing");
		driver.manage().window().maximize();
	}
 
	
	
	public void Taksescreenshot() throws IOException {
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 
	        // Save screenshot to a file
	        FileUtils.copyFile(screenshot, new File("./Screeshots/Errorscreenshot.png"));
 
	       
	}
	
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
		
	
	}
	
	
}
