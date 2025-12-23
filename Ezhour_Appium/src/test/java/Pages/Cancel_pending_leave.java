package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Cancel_pending_leave {

	AndroidDriver driver;
	String status;
	
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView//android.widget.ImageView[1]")
	WebElement leave_first_request;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc][3]")
	WebElement Leave_request_Status;
	
	@AndroidFindBy(accessibility = "Cancel Leave")
	WebElement Cancel_leave;
	
	@AndroidFindBy(accessibility = "Yes")
	WebElement Confirmation_Yes;
	
	public Cancel_pending_leave(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void click_first_leave_request()
	{
		leave_first_request.click();
	}
	
	
	public void get_leave_Status()
	{
	 status=Leave_request_Status.getAttribute("content-desc");
	System.out.println("Leave status: " +status);
	}
	
	public void click_cancel_leave() throws InterruptedException
	{
		
		if(status.equalsIgnoreCase("Pending"))
		{
		Thread.sleep(2000);
		Cancel_leave.click();
		Thread.sleep(3000);
		Confirmation_Yes.click();
		} 
		else {
			System.out.println("Request is not pending status");
		}
	}
	
	
	
	
	
}
