package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Rejected_scenario_page{

	AndroidDriver driver;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Leave Tracker\"]/preceding-sibling::android.widget.Button")
	WebElement Leave_tracker_back_button;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"More\"]")
	WebElement More_button;
	
	@AndroidFindBy(xpath="Logout")
	WebElement Logout;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Cancel\"]/following-sibling::android.widget.Button")
	WebElement Lougout_confirm_button;
	
	@AndroidFindBy(xpath="Leave Tracker")
	WebElement Leave_tracker_more;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Leave Tracker\"]/following-sibling::android.view.View[@content-desc=\"My Approvals\"]")
	WebElement Leave_tracker_my_approval;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView//android.widget.ImageView[1]")
	WebElement leave_request_list_first;
	
	public Rejected_scenario_page(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void click_leave_back_trakcer_button()
	{
		Leave_tracker_back_button.click();
	}
	
	public void Logout()
	{
		More_button.click();
		Logout.click();
		Lougout_confirm_button.click();
	}
	
	public void Navigate_leave_my_approval()
	{
		More_button.click();
		Leave_tracker_more.click();
		Leave_tracker_my_approval.click();
	}
}
