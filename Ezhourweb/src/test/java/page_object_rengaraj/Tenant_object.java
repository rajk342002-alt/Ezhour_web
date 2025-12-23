package page_object_rengaraj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Tenant_object extends comman_methods {
WebDriver driver;
	
	public Tenant_object(WebDriver driver) {
		super(driver);
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=\"Sign In\"]")
	WebElement sig_in;
	
	@FindBy(xpath="//input[@id=\"tenancyNameInput\"]")
	WebElement tenant_enter;
	
	@FindBy(xpath="//button[text()=\" Continue \"]")
	WebElement continue_button;
	
	
	
	public void sigin()
	{
		sig_in.click();
	}
	public void tenant(String tenant_name) {
		
		tenant_enter.sendKeys(tenant_name);
	}
	
	public void tenant_continue()
	{
		waitForElementClickable(continue_button);
		continue_button.click();
	}
	public void urlupdate()
	{
		
		String oldurl=driver.getCurrentUrl();
//	String url="https://dev.ezhour.com/account/login";
	String	updaterul=oldurl.replace("mobiletest.","");
	driver.get(updaterul);
	

	}
}
