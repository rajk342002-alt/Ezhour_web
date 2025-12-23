package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Leave_tracker {

	AndroidDriver driver;
	
	@AndroidFindBy(accessibility = "Apply Leave")
	WebElement Apply_leave_button;
	
	@AndroidFindBy(accessibility = "Leave Type")
	WebElement Leavetype;
	
	@AndroidFindBy(accessibility = "Casual Leave")
	WebElement leave_choose;
	
	@AndroidFindBy(accessibility = "From Date")
	WebElement from_date;
	
	@AndroidFindBy(accessibility = "To Date")
	WebElement To_date;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"Add Attachment\"]\r\n"
			+ "/preceding-sibling::android.widget.EditText\r\n"
			+ "")
	WebElement reason;
	
	@AndroidFindBy(accessibility = "Add Attachment")
	WebElement Add_attachment;
	
	@AndroidFindBy(accessibility = "Apply")
	WebElement apply_button;
	
	
	public Leave_tracker(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver=driver;
	}
	
	
	
	public void click_apply_leave_button()
	{
		Apply_leave_button.click();
	}
	
	public void Select_Leave_type()
	{
		Leavetype.click();
		leave_choose.click();
	}
	
	
	public void fromdate(String from)
	{
		from_date.click();
		driver.findElement(AppiumBy.accessibilityId(from)).click();;
	}
	
	public void todate(String to_date)
	{
		To_date.click();
		driver.findElement(AppiumBy.accessibilityId(to_date)).click();
	}
	
	public void reason()
	{
		reason.click();
		reason.sendKeys("personal reason");
		driver.hideKeyboard();
	}
	
	
	public void apply_button()
	{
		apply_button.click();
	}
	
	
	
}
