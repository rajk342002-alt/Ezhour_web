package Permission_test_file;

import org.testng.annotations.Test;

import Permission_page_object.permission_page_navigating_object;
import baseclass.launchezhour;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Work_from_home_apply extends launchezhour {

	@Test
	public void work_from_home_apply() throws InterruptedException
	{
		Tenant_object tenant_choose=new Tenant_object(driver);
		tenant_choose.tenant(proporty.getProperty("tenant_name_permission"));
		tenant_choose.tenant_continue();
		Thread.sleep(2000);
		//login
				loginpage_object login=new loginpage_object(driver);
				login.mail(proporty.getProperty("usermail"));
				login.password("123qwe");
				login.submit();
				Thread.sleep(2000);
				
				permission_page_navigating_object permission_page_navigating=new permission_page_navigating_object(driver);
				permission_page_navigating.click_attendance();
				permission_page_navigating.click_my_request();
				permission_page_navigating.click_permission();
				Thread.sleep(5000);
		permission_page_navigating.click_permission_apply_button();
		permission_page_navigating.click_workfromhome_type();
		permission_page_navigating.Choosing_permission_date();
		permission_page_navigating.Date_select("11");
		
		permission_page_navigating.from_time_permission("09:00");
		Thread.sleep(2000);
		permission_page_navigating.To_time_permission("18:00");
		permission_page_navigating.Reason();
		
		Thread.sleep(2000);
		permission_page_navigating.apply_button();
		
		Thread.sleep(3000);
		
	}
	
	@Test(dependsOnMethods = "work_from_home_apply")
	public void Work_From_Home_SameTime_SameDate() throws InterruptedException
	{
	
		permission_page_navigating_object permission_page_navigating=new permission_page_navigating_object(driver);
		permission_page_navigating.click_permission_apply_button();
		permission_page_navigating.click_workfromhome_type();
		permission_page_navigating.Choosing_permission_date();
		permission_page_navigating.Date_select("11");
		
		permission_page_navigating.from_time_permission("09:00");
		Thread.sleep(2000);
		permission_page_navigating.To_time_permission("18:00");
		permission_page_navigating.Reason();
		
		Thread.sleep(2000);
		permission_page_navigating.same_time_same_date_warning_message();
		
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "Work_From_Home_SameTime_SameDate")
	public void Work_From_Home_cancel() throws InterruptedException
	{
		
		permission_page_navigating_object permission_page_navigating=new permission_page_navigating_object(driver);
		permission_page_navigating.click_first_request();
		Thread.sleep(2000);
		permission_page_navigating.cancel_permission_button_click();
		Thread.sleep(2000);
		permission_page_navigating.cancellation_success_toast_message_work_from_home();
	}
	
	
	
}
