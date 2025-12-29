package Base_file;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Launchezhour {
	
	
	public AppiumDriverLocalService service;
	public AndroidDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void launch_application() throws MalformedURLException
	{
	
		 service = new AppiumServiceBuilder()
		        .withAppiumJS(new File(
		            "C:\\Users\\rengaraj\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		        .withIPAddress("127.0.0.1")
		        .usingPort(4723).build();
		
		service.start();
	
		
		UiAutomator2Options options=new UiAutomator2Options();
		 options.setPlatformName("Android");
	     options.setDeviceName("Raj");
	     options.setApp("C:\\Users\\rengaraj\\eclipse-workspace\\Ezhour_Appium\\src\\test\\resources\\ezhour_apk\\Ezhour.apk");
	     options.setCapability("enforceXPath1", true);

				
				 driver=new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@AfterClass
	public void tear_down()
	{
		driver.quit();
		service.stop();
	}
	
}

