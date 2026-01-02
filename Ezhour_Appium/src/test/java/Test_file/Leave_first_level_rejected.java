package Test_file;

import org.testng.annotations.Test;

import Base_file.Launchezhour;
import Pages.Leave_tracker;
import Pages.Loginpage_page;
import Pages.Rejected_scenario_page;
import Pages.Service_pages;
import Pages.Slider_pages;

public class Leave_first_level_rejected extends Launchezhour {

	@Test
	public void first_level_rejected() throws InterruptedException
	{
		Slider_pages slider=new Slider_pages(driver);
		Thread.sleep(3000);
		slider.click_slider_button();
		Thread.sleep(2000);
		Loginpage_page login=new Loginpage_page(driver);
		login.Usermail();
		Thread.sleep(2000);
		login.usermail_next();
		Thread.sleep(2000);
		login.password();
		login.click_login_button();
		
		Service_pages service=new Service_pages(driver);
		Thread.sleep(2000);
		service.Leave_tracker();
		
		Leave_tracker apply_leave=new Leave_tracker(driver);
		Thread.sleep(2000);
		apply_leave.click_apply_leave_button();
		Thread.sleep(2000);
		apply_leave.Select_Leave_type();
		Thread.sleep(2000);
		apply_leave.fromdate("Friday, December 12, 2025");
		Thread.sleep(2000);
		apply_leave.todate("Friday, December 12, 2025");
		Thread.sleep(2000);
		apply_leave.reason();
		Thread.sleep(2000);
		apply_leave.apply_button();
		Thread.sleep(4000);
		Rejected_scenario_page rejected=new Rejected_scenario_page(driver);
	}
	
	
}
