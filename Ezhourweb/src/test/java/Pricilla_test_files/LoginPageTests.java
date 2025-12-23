package Pricilla_test_files;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page_object_pricilla.DashboardPageObjects;
import Page_object_pricilla.LoginPageObjects;
import utils.PropertiesUtil;

public class LoginPageTests {
	
	public WebDriver driver;
    public WebDriverWait wait;
    
    protected String tenantUserKey = "tenant1";
	
	@BeforeMethod
	public void setup() {   	
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));  
        driver.manage().window().maximize();
        driver.get("https://qa.ezhour.com");        
        tenant(tenantUserKey);
    }

    public void tenant(String tenantUserKey) {  	
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
	
    @DataProvider(name = "validUsers")
    public Object[][] ValidData(){
    	
    	return new Object[][] {
    		{"pricilla.a@rubixtek.com", "123qwe", "PersisPricilla"},
    		{"rengaraj.k@rubixtek.com", "123qwe", "Rengaraj Kumaravel"},
    		{"madhankumar.m@rubixtek.com", "123qwe", "Madhankumar Murugan"},
    		{"bharath.gurumoorthy@rubixtek.com", "123qwe", "BharathKumar"},
    		{"kausarfathima.parveez@rubixtek.com", "123qwe", "KausarFathima"},
    	};
    }
	@Test(dataProvider = "validUsers")
	public void loginWithValidCredentials(String username, String password, String fullName) {
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
	
	@DataProvider(name = "invalidUsers")
	public Object[][] InvalidData(){
	    	return new Object[][] {
	    		{"pricilla-a@rubixtek.com", "123qwe"},
	    		{"rengaraj#k@rubixtek.com", "123qwe"},
	    		{"$madhankumar@rubixtek.com", "123qwe"},
	    		{"bharath@rubixtek.com", "123qwe"},
	    		{"kausarfathima.parveez@rubix.com", "123qwe"},
	    	};
	    }
	@Test(dataProvider = "invalidUsers")	
	public void loginWithInValidCredentials(String username, String password) {	
		LoginPageObjects login = new LoginPageObjects(driver);
	    wait.until(ExpectedConditions.visibilityOf(login.username)).sendKeys(username);
	    login.password.sendKeys(password);
	    login.login_btn.click();
		WebElement invalidError = wait.until(ExpectedConditions.visibilityOf(login.invalid_error));
		String message = invalidError.getText();
		Assert.assertEquals(message, "Invalid user name or password");
		System.out.println("Login failed with invalid credentials");
		login.ok_btn.click();
	}
	
	@DataProvider(name = "longInvalidEmail")
	public Object[][] longInvalidEmailID(){
	    	return new Object[][] {
	    		{"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz@gmail.com", "123qwe"},
	    		{"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl@gmail.com", "123qwe"},
	    		{"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef@gmail.com", "123qwe"},
	    	};
	    }
	@Test(dataProvider = "longInvalidEmail")
	public void verifyUsernameAccepts256Char(String username, String password) {
		LoginPageObjects login = new LoginPageObjects(driver);
	    wait.until(ExpectedConditions.visibilityOf(login.username)).sendKeys(username);
	    login.password.sendKeys(password);
		login.login_btn.click();
		if(username.length() > 256)
		{
			WebElement invalidErrorTitle = wait.until(ExpectedConditions.visibilityOf(login.maxCharErrorTitle));
			String errorTitle = invalidErrorTitle.getText();
			Assert.assertEquals(errorTitle, "Your request is not valid!");
			WebElement invalidErrorMsg = wait.until(ExpectedConditions.visibilityOf(login.maxCharErrorMsg));
			String errorMsg = invalidErrorMsg.getText();
			Assert.assertEquals(errorMsg, "The following errors were detected during validation. - The field UserNameOrEmailAddress must be a string or array type with a maximum length of '256'.");
			login.ok_btn.click();	
			int count = username.length();
			System.out.println("Validation Error. Maximum 256 chars accepted but String length is "+ count);
		}
		else
		{
			WebElement invalidError = wait.until(ExpectedConditions.visibilityOf(login.invalid_error));
			String message = invalidError.getText();
			Assert.assertEquals(message, "Invalid user name or password");
			int count = username.length();
			System.out.println("String length is " + count + " but login failed with invalid credentials");
			login.ok_btn.click();
		}
	}

	@Test
	public void loginWithBlankUsername() {	
		LoginPageObjects login = new LoginPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(login.username)).sendKeys("");
		wait.until(ExpectedConditions.visibilityOf(login.password));
	    login.password.sendKeys("123qwe");
	    boolean result = login.isLoginButtonClickable();
		if(result==true)
		{
			System.out.println("Login Button is not enabled");
		}
	    Assert.assertTrue(login.isLoginButtonClickable(), "Login button should be enabled");
	}
	
	@DataProvider(name = "validusernames")
    public Object[][] Validusernames(){
    	
    	return new Object[][] {
    		{"pricilla.a@rubixtek.com"},
    		{"rengaraj.k@rubixtek.com"},
    		{"madhankumar.m@rubixtek.com"},
    		{"bharath.gurumoorthy@rubixtek.com"},
    		{"kausarfathima.parveez@rubixtek.com"},
    	};
    }
	@Test(dataProvider = "validusernames")
	public void loginWithBlankPassword(String username) {	
		LoginPageObjects login = new LoginPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(login.username));
	    login.username.sendKeys(username);
	    wait.until(ExpectedConditions.visibilityOf(login.password)).sendKeys("");
	    boolean result = login.isLoginButtonClickable();
		if(result==true)
		{
			System.out.println("Login Button is not enabled");
		}
	    Assert.assertTrue(login.isLoginButtonClickable(), "Login button should be enabled");
	}
	
	@Test	
	public void loginWithBlankUsernamePassword() {	
		LoginPageObjects login = new LoginPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(login.username)).sendKeys("");
		wait.until(ExpectedConditions.visibilityOf(login.password)).sendKeys("");
		boolean result = login.isLoginButtonClickable();
		if(result==true)
		{
			System.out.println("Login Button is not enabled");
		}
	    Assert.assertTrue(login.isLoginButtonClickable(), "Login button should be enabled");
	}
	
	@Test	
	public void validateRememberMe() {	
		LoginPageObjects login = new LoginPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(login.rememberMe)).click();
	    Assert.assertTrue(login.isRememberMeEnabled(), "Checkbox is disabled");
	}
	
	@Test	
	public void clickForgotPassword() {	
		LoginPageObjects login = new LoginPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(login.forgotPassword)).click();
	    Assert.assertTrue(login.isForgotPasswordPageVisible(wait), "Forgot Password page is not visible to the user");
	}
	
	@DataProvider(name = "validUsernames")
    public Object[][] ValidUsernames(){
    	
    	return new Object[][] {
    		{"pricilla.a@rubixtek.com"},
    		{"rengaraj.k@rubixtek.com"},
    		{"madhankumar.m@rubixtek.com"},
    		{"bharath.gurumoorthy@rubixtek.com"},
    		{"kausarfathima.parveez@rubixtek.com"},
    	};
    }
	@Test(dataProvider = "validUsernames")
	public void ResetPasswordAndVerifySubmit(String username) {	
		LoginPageObjects login = new LoginPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(login.forgotPassword)).click();
		wait.until(ExpectedConditions.visibilityOf(login.forgotPasswordUsername)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(login.forgotPasswordSubmit)).click();
		boolean result = wait.until(ExpectedConditions.visibilityOf(login.mailSent)).isDisplayed();
		Assert.assertTrue(result, "Mail was not sent");
		wait.until(ExpectedConditions.visibilityOf(login.mailSentOk)).click();
	}
	
	@Test(dataProvider = "validUsernames")
	public void ResetPasswordAndVerifyBack(String username) {	
		LoginPageObjects login = new LoginPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(login.forgotPassword)).click();
		wait.until(ExpectedConditions.visibilityOf(login.forgotPasswordUsername)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(login.forgotPasswordBack)).click();
		boolean result = wait.until(ExpectedConditions.visibilityOf(login.login_btn)).isDisplayed();
		Assert.assertTrue(result, "Login Page is not displayed");
	}
	
	@Test	
	public void leaveForgotPasswordUsernameBlank() {	
		LoginPageObjects login = new LoginPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(login.forgotPassword)).click();
		wait.until(ExpectedConditions.visibilityOf(login.forgotPasswordUsername)).sendKeys("");
		boolean result = login.isSubmitButtonDisabled();
		if(result==true)
		{
			System.out.println("Submit button is disabled");
		}
	    Assert.assertTrue(login.isSubmitButtonDisabled(), "Submit button is enabled");
	}
	
	@DataProvider(name = "invalidUsers_ResetPassword")
    public Object[][] InValidDataResetPassword(){
    	
    	return new Object[][] {
    		{"pricilla"},
    		{"kausarfathima"},
    	};
    }
	@Test(dataProvider = "invalidUsers_ResetPassword")
	public void verifyForgotPasswordInvalidUsername(String username) {
		LoginPageObjects login = new LoginPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(login.forgotPassword)).click();
	    wait.until(ExpectedConditions.visibilityOf(login.forgotPasswordUsername)).sendKeys(username);
		WebElement invalidErrorTitle = wait.until(ExpectedConditions.visibilityOf(login.invalidForgotPasswordUsername));
		String errorTitle = invalidErrorTitle.getText();
		Assert.assertEquals(errorTitle, "Invalid email address");
	}
	
    @DataProvider(name = "inactiveUser")
    public Object[][] inactiveUserData(){
    	
    	return new Object[][] {
    		{"vigneshwaran@rubixtek.com", "123qwe"},
    		{"ajithkumar.m@rubixtek.com", "123qwe"},
    	};
    }
	@Test(dataProvider = "inactiveUser")
	public void loginWithInactiveUser(String username, String password)
	{
		LoginPageObjects login = new LoginPageObjects(driver);
	    wait.until(ExpectedConditions.visibilityOf(login.username)).sendKeys(username);
	    login.password.sendKeys(password);
	    login.login_btn.click();
	    wait.until(ExpectedConditions.visibilityOf(login.errorPopup));
	    Assert.assertTrue(login.errorPopup.isDisplayed(), "Popup is not displayed");
	    String expectedErrorMsg = "User " + username + " is not active and can not log in.";
	    Assert.assertEquals(login.errorPopupMsg.getText(), expectedErrorMsg);
	    System.out.println(expectedErrorMsg);    	
	}
	
	@AfterMethod       
    public void tearDown() {     
    	if(driver != null) {
        driver.quit();
    	}
    }
}
