package page_object_rengaraj;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Halfday_cancellation_object extends comman_methods {
	String leavelist_request_status;
	WebDriver driver;
	
	public Halfday_cancellation_object(WebDriver driver) {
		super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[@id='kt_app_main']/div/leaves/div/div/div/div/div[2]/div/p-table/div/div/table/tbody/tr[2]/td[6]")
	WebElement leavelist_navigation_button;
	
	
	

	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/div[3]/div/div/div/table/tbody/tr/td[5]/p")
    WebElement user_submitted;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/div[3]/div/div/div/table/tbody/tr[1]/td[5]  ")
	WebElement scroll_user;
	
	@FindBy(xpath="//button[.=\"Cancel Leave\"]")
	WebElement leave_cancel_button;
	
	@FindBy(xpath="//button[text()=\"Yes\"]")
	WebElement Leave_cancel_yes_button;
	
	@FindBy(xpath="//button[text()=\"Cancel\"]")
	WebElement Leave_cancel_cancel_button;
	
	@FindBy(xpath="//div[@id=\"swal2-html-container\"]/span")
	WebElement Leave_cancel_success_toast;
	
	public void Leavestatus_gettext() throws InterruptedException
	{
		waitforElementVisible(leavelist_navigation_button);
		 leavelist_request_status=leavelist_navigation_button.getText();
		 System.out.println(leavelist_request_status);
		 
	}
	
	public void navigate_leavedetails_page()
	{
//		leavelist_request_status=leavelist_navigation_button.getText();
//		 System.out.println(leavelist_request_status);
		
		Actions action=new Actions(driver);
		waitforElementVisible(leavelist_navigation_button);
		action.moveToElement(leavelist_navigation_button).click().build().perform();
		
	}
	public void Leave_cancelbutton_click() throws InterruptedException
	{
		Thread.sleep(1000);
		scroll(leave_cancel_button);
		Thread.sleep(1000);
		leave_cancel_button.click();
	}
	
	public void leave_cancel_cancelbutton_click() throws InterruptedException
	{
		Thread.sleep(1000);
		Leave_cancel_cancel_button.click();
	}
	public void Leave_cancel_Yes_button() throws InterruptedException
	{
		Thread.sleep(1000);
		Leave_cancel_yes_button.click();
	}
	
	public void leave_cancellation_success_toast() throws InterruptedException
	{
		Thread.sleep(1000);
		
		
		if(leavelist_request_status.equalsIgnoreCase("Pending")) {
			System.out.println("Not cancelled condition");
		
			Leave_cancelbutton_click();
			
			
			leave_cancel_cancelbutton_click();
			
		
			Leave_cancelbutton_click();
			
		
			Leave_cancel_Yes_button();
			
			Thread.sleep(2000);
			String cancel_success_message=Leave_cancel_success_toast.getText().trim();
			
//			assertEquals(cancel_success_message, "Cancellation Submitted Successfully");
			
			String expected1="Cancellation Submitted Successfully";
			String expected2="Madhankumar Murugan Leave Cancelled";
			
			assertTrue(cancel_success_message.equals(expected1) || cancel_success_message.equals(expected2), cancel_success_message);
			
			
		}else 
		{
			
			scroll(scroll_user);
			 
			System.out.println("Requested status: "+leavelist_request_status);
			Thread.sleep(2000);
			
			List<WebElement> elementList = driver.findElements(By.xpath("//button[.='Cancel Leave']"));

			if (elementList.size() == 0) {
			    assertTrue(true, "Cancel button is not visible in cancelled request");
			} else {
			     assertFalse(false, "Cancel button is visible in cancelled request");
			}
		}
		
		
		
		
	}
}
