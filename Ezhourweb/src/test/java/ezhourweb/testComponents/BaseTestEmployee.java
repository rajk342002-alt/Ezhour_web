package ezhourweb.testComponents;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Page_object_pricilla.*;
import utils.PropertiesUtil;

public class BaseTestEmployee {
	
	public WebDriver driver;
    public WebDriverWait wait;
    
    protected String userKey = "employee5";
    protected String tenantUserKey = "tenant1";

    @BeforeClass
    public void setup() {   	
//    	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));  
        driver.manage().window().maximize();
        driver.get("https://qa.ezhour.com");        
        tenant(tenantUserKey);
        loginWithEmployeeCredentials(userKey);
    }

    private void tenant(String tenantUserKey) {
    	
    	String tenantName = PropertiesUtil.get(tenantUserKey + ".name");
    	LoginPageObjects login = new LoginPageObjects(driver);
        wait.until(ExpectedConditions.elementToBeClickable(login.sign_in)).click();
        wait.until(ExpectedConditions.visibilityOf(login.tenant)).click();
        login.tenant.sendKeys(tenantName);
        login.continuebtn_tenant.click();
        wait.until(ExpectedConditions.urlContains("https://"+tenantName+".qa.ezhour.com/account/login"));
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);
        String updatedURL = currentURL.replace(tenantName+".", "");
        driver.get(updatedURL);
        System.out.println("Updated URL: " + updatedURL);
    }

    public void loginWithEmployeeCredentials(String userKey) {
    	
    	String username = PropertiesUtil.get(userKey + ".username");
        String password = PropertiesUtil.get(userKey + ".password");
        String fullName = PropertiesUtil.get(userKey + ".fullName");
        
    	LoginPageObjects login = new LoginPageObjects(driver);
    	wait.until(ExpectedConditions.visibilityOf(login.username)).sendKeys(username);
 		login.password.sendKeys(password);
 		login.login_btn.click();
 		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
 		WebElement user = wait.until(ExpectedConditions.visibilityOf(dashboard.logged_user));
 		String name = user.getText();
 		Assert.assertEquals(name, "Hi, "+fullName);
 		System.out.println("User has been logged successfully.");
    }
    
    @AfterClass
    
    public void tearDown() {     
    	if(driver != null) {
        driver.quit();
    	}
    }

}
