package page_object_rengaraj;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Weekend_leave_apply_object extends comman_methods {
WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"kt_body\"]/div/div")
	WebElement Weekend_alert_box;
	
	@FindBy(xpath = "//*[@id=\"swal2-html-container\"]")
	WebElement Weekend_alert_message;
	
	@FindBy(xpath="//*[@id=\"kt_body\"]/div/div/div[6]/button[1]")
	WebElement Alert_box_ok;
	
	public Weekend_leave_apply_object(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public void Weekend_choose_alertbox()
	{
		waitforElementVisible(Weekend_alert_box);
		assertTrue(Weekend_alert_box.isDisplayed());
		String alert_message=Weekend_alert_message.getText().trim();
		assertEquals(alert_message,"Weekend dates selected" );
		Alert_box_ok.click();
	}
}
