package Permission_test_file;

import org.testng.annotations.Test;

import Permission_page_object.Warning_Toast_message_object;
import Permission_page_object.permission_page_navigating_object;
import baseclass.launchezhour;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Pemission_totime_greater_then_from_time extends launchezhour {
	
	@Test
	public void Permission_Totime_greater_fromtime() throws InterruptedException
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
				
				permission_page_navigating.from_time_permission("10:00");
				permission_page_navigating.To_time_permission("09:30");
				permission_page_navigating.Reason();
				Warning_Toast_message_object warning_message=new Warning_Toast_message_object(driver);
				
				warning_message.To_time_greater_than_from_time();
				Thread.sleep(2000);
				warning_message.Toast_Message_Ok_button();
				
				Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "Permission_Totime_greater_fromtime")
	public void workfrome_Totime_greater_then_fromtime() throws InterruptedException
	{
		permission_page_navigating_object permission_page_navigating=new permission_page_navigating_object(driver);
		permission_page_navigating.click_workfromhome_type();
		permission_page_navigating.Choosing_permission_date();
		permission_page_navigating.Date_select("10");
		
		permission_page_navigating.from_time_permission("10:00");
		permission_page_navigating.To_time_permission("09:30");
		permission_page_navigating.Reason();
		Warning_Toast_message_object warning_message=new Warning_Toast_message_object(driver);
		
		warning_message.To_time_greater_than_from_time();
		Thread.sleep(2000);
		warning_message.Toast_Message_Ok_button();
		
	}

}
