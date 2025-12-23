package Page_object_madhan;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class Tenant_login_object {
 
	 WebDriver driver;
	 
	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement Signin;
	@FindBy(id = "tenancyNameInput")
	WebElement tenantname;
	@FindBy(xpath = "//button[text()=' Continue ']")
	WebElement continuebutton;
	  // Constructor to initialize the driver and web elements
    public Tenant_login_object(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clicksigninbutton() throws InterruptedException {
    	Thread.sleep(3000);
    	Signin.click();
    }
    public void  Entertenentname(String Tenentname)  {
    tenantname.sendKeys("mobiletest");
    }
    public void clickcotinuebutton() throws InterruptedException {
    	continuebutton.click();
    	Thread.sleep(4000);
    }
}