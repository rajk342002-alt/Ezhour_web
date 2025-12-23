package Pricilla_test_files;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page_object_pricilla.LoginPageObjects;
import Page_object_pricilla.TenantPageObjects;


public class TenantPageTests {
	
	public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup() {   	
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));  
        driver.manage().window().maximize();
        driver.get("https://qa.ezhour.com"); 
        LoginPageObjects login = new LoginPageObjects(driver);
        wait.until(ExpectedConditions.elementToBeClickable(login.sign_in)).click();
    }

    @DataProvider(name = "invalid_tenants")
    public Object[][] invalidData(){
    	
    	return new Object[][] {
    		{"rubixweb"},
    		{"ezhour.qa"},
    		{"qas_ample"},
    		{"mobile-dev"},
    	};
    }
    
    @Test(dataProvider = "invalid_tenants")
    public void invalidTenants(String tenantName) {
    	
    	TenantPageObjects tenants = new TenantPageObjects(driver);        
        wait.until(ExpectedConditions.visibilityOf(tenants.tenant)).click();
        tenants.tenant.clear();
        tenants.tenant.sendKeys(tenantName);
        tenants.continuebtn_tenant.click();
        boolean result = wait.until(ExpectedConditions.visibilityOf(tenants.warningPopup)).isDisplayed();
        if(result==true)
        {
            String error = tenants.invalidError.getText();
            Assert.assertEquals(error, "There is no tenant defined with name "+ tenantName);
            System.out.println("Wrong tenant name entered. "+"There is no tenant defined with name "+ tenantName);
            tenants.okBtn.click();
        }
    }
    
    @DataProvider(name = "valid_tenants")
    public Object[][] validData(){
    	
    	return new Object[][] {
    		{"qarubixtek"},
    	};
    }
    
    @Test(dataProvider = "valid_tenants")
    public void tenant(String tenantName) {
    	
    	TenantPageObjects tenants = new TenantPageObjects(driver);
        wait.until(ExpectedConditions.visibilityOf(tenants.tenant)).click();
        tenants.tenant.clear();
        tenants.tenant.sendKeys(tenantName);
        tenants.continuebtn_tenant.click();       
        wait.until(ExpectedConditions.urlContains("https://"+tenantName+".qa.ezhour.com/account/login"));
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);
        String updatedURL = currentURL.replace(tenantName+".", "");
        driver.get(updatedURL);
        System.out.println("Updated URL: " + updatedURL);
        LoginPageObjects login = new LoginPageObjects(driver);
    	wait.until(ExpectedConditions.visibilityOf(login.username));
    	wait.until(ExpectedConditions.visibilityOf(login.password));
    	wait.until(ExpectedConditions.visibilityOf(login.login_btn));
    	System.out.println("Valid tenant entered. Login page is visible");
    }

    @AfterMethod
    
    public void tearDown() {     
    	if(driver != null) {
        driver.quit();
    	}
    }
}
