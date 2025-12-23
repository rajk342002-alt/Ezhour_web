package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Service_pages {
	
	AndroidDriver driver;
	
	@AndroidFindBy(accessibility = "Time Tracker")
	WebElement Time_tracker;
	
	@AndroidFindBy(accessibility = "Attendance")
	WebElement Attendance;
	
	@AndroidFindBy(accessibility = "Leave Tracker")
	WebElement Leave_tracker;
	
	@AndroidFindBy(accessibility = "Permissions")
	WebElement permission;
	
	@AndroidFindBy(accessibility = "Reports")
	WebElement Report;
	
	@AndroidFindBy(accessibility = "My Request")
	WebElement myrequest;
	
	public Service_pages(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void click_Time_tracker()
	{
		Time_tracker.click();
	}
	
	public void click_Attendance()
	{
		Attendance.click();
	}
	
	public void Leave_tracker()
	{
		Leave_tracker.click();
	}
	public void permission()
	{
		permission.click();
	}
	public void Report()
	{
		Report.click();
	}

	public void My_request()
	{
		myrequest.click();
	}
	
	
}
