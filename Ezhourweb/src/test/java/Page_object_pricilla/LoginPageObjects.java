package Page_object_pricilla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObjects {
	
	WebDriver driver;

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(linkText = "Sign In")
	public WebElement sign_in;
	
	@FindBy(id = "tenancyNameInput")
	public WebElement tenant;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	public WebElement continuebtn_tenant;
	
	@FindBy(xpath = "//input[@name='userNameOrEmailAddress']")
	public WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement login_btn;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	public WebElement invalid_error;
	
	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	public WebElement ok_btn;
	
	@FindBy(xpath = "//h2[@id='swal2-title']")
	public WebElement maxCharErrorTitle;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	public WebElement maxCharErrorMsg;
	
	@FindBy(xpath = "//input[@name='rememberMe']")
	public WebElement rememberMe;
	
	@FindBy(id = "forget-password")
	public WebElement forgotPassword;
	
	@FindBy(xpath = "//h3[text()=' Forgot password? ']")
	public WebElement forgotPasswordPage;
	
	@FindBy(xpath = "//input[@placeholder='Email address *']")
	public WebElement forgotPasswordUsername;
	
	@FindBy(xpath = "//button[@type='submit' and text()=' Submit ']")
	public WebElement forgotPasswordSubmit;
	
	@FindBy(xpath = "//div[text()=' Invalid email address ']")
	public WebElement invalidForgotPasswordUsername;
	
	@FindBy(xpath = "//h2[@id='swal2-title' and text()='Mail sent']")
	public WebElement mailSent;
	
	@FindBy(xpath = "//button[@type='button' and text()='Ok']")
	public WebElement mailSentOk;
	
	@FindBy(xpath = "//button[@routerlink='/account/login']")
	public WebElement forgotPasswordBack;
	
//**************************************************LOGOUT PAGE OBJECTS*********************************************************
	
	@FindBy(xpath = "//div[contains(@class,'img-circle')]")
	public WebElement logoutArrow;
	
	@FindBy(xpath = "//span[text() = ' Logout ']")
	public WebElement logoutBtn;
	
	@FindBy(xpath = "//div[contains(@class, 'swal2-error')]")
	public WebElement errorPopup;

	@FindBy(xpath = "//div[contains(@class, 'swal2-html-container')]")
	public WebElement errorPopupMsg;
	
	public boolean isLoginButtonClickable() {
		
		boolean result = !login_btn.isEnabled();
		return result;		
	}

	public boolean isRememberMeEnabled() {
		
		boolean result = rememberMe.isEnabled();
		return result;
	}

	public boolean isForgotPasswordPageVisible(WebDriverWait wait) {
		
		boolean result = wait.until(ExpectedConditions.visibilityOf(forgotPasswordPage)).isDisplayed();
		return result;
	}

	public boolean isSubmitButtonDisabled() {
		
		boolean result = !login_btn.isEnabled();
		return result;
	}

}
