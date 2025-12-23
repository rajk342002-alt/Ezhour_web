package Page_object_pricilla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenantPageObjects {
	
	WebDriver driver;

    public TenantPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(linkText = "Sign In")
	public WebElement sign_in;
	
	@FindBy(id = "tenancyNameInput")
	public WebElement tenant;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	public WebElement continuebtn_tenant;
	
	@FindBy(xpath = "//div[contains(@class, 'swal2-warning')]")
	public WebElement warningPopup;
	
	@FindBy(id = "swal2-html-container")
	public WebElement invalidError;
	
	@FindBy(xpath = "//button[text()='Ok']")
	public WebElement okBtn;
}

