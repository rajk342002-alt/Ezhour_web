package Permission_test_file;

import org.testng.annotations.Test;

import Permission_page_object.permission_page_navigating_object;
import baseclass.launchezhour;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Permission_apply extends launchezhour {

	@Test
	public void Apply_Permission() throws InterruptedException
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
				permission_page_navigating.click_permission_type();
				permission_page_navigating.Choosing_permission_date();
				permission_page_navigating.Date_select("10");
				
				permission_page_navigating.from_time_permission("09:00");
				permission_page_navigating.To_time_permission("10:30");
				permission_page_navigating.Reason();
				permission_page_navigating.apply_button();
				
				Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = "Apply_Permission")
	public void Permission_SameTime_SameDate() throws InterruptedException
	{
	
		permission_page_navigating_object permission_page_navigating=new permission_page_navigating_object(driver);
		permission_page_navigating.click_permission_apply_button();
		permission_page_navigating.click_permission_type();
		permission_page_navigating.Choosing_permission_date();
		permission_page_navigating.Date_select("10");
		
		permission_page_navigating.from_time_permission("09:00");
		permission_page_navigating.To_time_permission("10:30");
		permission_page_navigating.Reason();
		
		Thread.sleep(2000);
		permission_page_navigating.same_time_same_date_warning_message();
		
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "Permission_SameTime_SameDate")
	public void Permission_cancel() throws InterruptedException
	{
		
		permission_page_navigating_object permission_page_navigating=new permission_page_navigating_object(driver);
		permission_page_navigating.click_first_request();
		Thread.sleep(2000);
		permission_page_navigating.cancel_permission_button_click();
		Thread.sleep(2000);
		permission_page_navigating.cancellation_success_toast_message_permission();
	}
}
