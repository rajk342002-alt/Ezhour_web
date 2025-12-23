package page_object_rengaraj;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Available_Leave_Exceed_object  extends comman_methods{

	WebDriver driver;
	
	
	@FindBy (xpath = "//*[@id=\"swal2-html-container\"]")
	WebElement leave_exceed_warning;
	
	@FindBy(xpath = "//*[@id=\"kt_body\"]/div/div/div[6]/button[1]")
	WebElement warning_click_ok_button;
	
	
	
	
	public Available_Leave_Exceed_object(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void Leave_exceed_warning_message()
	{
	String message=	leave_exceed_warning.getText().trim();
	System.out.println(message);
	assertEquals(message, "Leave is Over");
	
	}
	
	public void warning_click_ok_button()
	{
		assertTrue(warning_click_ok_button.isDisplayed());
		warning_click_ok_button.click();
	}
	
	

}
