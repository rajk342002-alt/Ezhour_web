package baseclass;
import org.apache.log4j.Logger; 
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import excel_reader.Readexcel;
import io.github.bonigarcia.wdm.WebDriverManager;


public class launchezhour {
public WebDriver driver;
protected static Properties proporty=null;

public static Logger logger = Logger.getLogger(launchezhour.class);

@DataProvider(name="login")
public String[][] getdata()
{
	Readexcel excel=new Readexcel();
	String[][] exceldata=excel.getexceldata("Sheet2");
	return exceldata;
}



public Properties propertyfile() {
    try {
        FileInputStream fileinputstream = new FileInputStream("configure.properties"); // ✅ spelling fix
        proporty = new Properties();
        proporty.load(fileinputstream);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return proporty;
}


	@BeforeClass
	public void ezhourlaunch()
	{
		
		
		PropertyConfigurator.configure("configure.properties");
		logger.info("Ezhour application launch");
		 proporty = propertyfile();
		 
		 ChromeOptions options = new ChromeOptions();
		    options.addArguments("--remote-allow-origins=*");
		    options.addArguments("--disable-web-security");
		    options.addArguments("--disable-gpu");
		    options.addArguments("--no-sandbox");
		    options.addArguments("--disable-dev-shm-usage");
		 
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		 driver.get("https://dev.ezhour.com/account/login");
//		driver.get("https://qa.ezhour.com/account/select-tenant");
//		driver.get("https://rubixtek.ezhour.com/account/login"); 
	driver.get("http://163.61.28.205/account/select-tenant");
		driver.manage().window().maximize();
		
		}
	
	@AfterClass
	public void teardown()
	{
		logger.info("Ezhour testing is completed");
		driver.quit();
	}
	
	
}
