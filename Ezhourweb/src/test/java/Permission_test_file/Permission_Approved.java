package Permission_test_file;

import org.testng.annotations.Test;

import Permission_page_object.Permission_approval_page;
import Permission_page_object.permission_page_navigating_object;
import baseclass.launchezhour;
import page_object_rengaraj.Logout_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Permission_Approved extends launchezhour  {

	@Test
	public void Permission_apply_first_level_approved() throws InterruptedException
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
				permission_page_navigating.Date_select("2");
				
				Thread.sleep(2000);
				permission_page_navigating.from_time_permission("09:00");
				Thread.sleep(2000);
				permission_page_navigating.To_time_permission("10:30");
				permission_page_navigating.scroll_reason();
				permission_page_navigating.Reason();
				
				permission_page_navigating.apply_button();
				Thread.sleep(2000);
				 Logout_object logout_object=new Logout_object(driver);
					logout_object.click_username();
					logout_object.click_logout_button();
					
					loginpage_object teamlead_login=new loginpage_object(driver);
					teamlead_login.mail(proporty.getProperty("tlusermail"));
					teamlead_login.password(proporty.getProperty("tlpassword"));
					teamlead_login.submit();
				Permission_approval_page Permission_My_approval_navigating=new Permission_approval_page(driver);
				Permission_My_approval_navigating.Click_Attendance();
				Permission_My_approval_navigating.Click_MyApproval();
				Permission_My_approval_navigating.Click_Permission_Approval();
				Thread.sleep(2000);
				Permission_My_approval_navigating.Click_Permission_Approval_first_request();
				Thread.sleep(2000);
				Permission_My_approval_navigating.scroll();
				Permission_My_approval_navigating.comment_box("Approved");
				Permission_My_approval_navigating.Click_Approve_button();
				
				Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "Permission_apply_first_level_approved")
	public void Second_level_Approval() throws InterruptedException
	{
		Logout_object logout_object=new Logout_object(driver);
		logout_object.click_username();
		logout_object.click_logout_button();
		
		loginpage_object teamlead_login=new loginpage_object(driver);
		teamlead_login.mail(proporty.getProperty("managermail"));
		teamlead_login.password(proporty.getProperty("tlpassword"));
		teamlead_login.submit();
		Thread.sleep(2000);
	Permission_approval_page Permission_My_approval_navigating=new Permission_approval_page(driver);
	Permission_My_approval_navigating.Click_Attendance();
	Permission_My_approval_navigating.Click_MyApproval();
	Permission_My_approval_navigating.Click_Permission_Approval();
	Thread.sleep(2000);
	Permission_My_approval_navigating.Click_Permission_Approval_first_request();
	Thread.sleep(2000);
	Permission_My_approval_navigating.scroll();
	Permission_My_approval_navigating.comment_box("Approved");
	Permission_My_approval_navigating.Click_Approve_button();
	
	Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "Second_level_Approval")
	public void Approved_permission_cancellation() throws InterruptedException
	{
		Logout_object logout_object=new Logout_object(driver);
		logout_object.click_username();
		logout_object.click_logout_button();
		
		loginpage_object teamlead_login=new loginpage_object(driver);
		teamlead_login.mail(proporty.getProperty("usermail"));
		teamlead_login.password(proporty.getProperty("password"));
		teamlead_login.submit();
		
		permission_page_navigating_object permission_page_navigating=new permission_page_navigating_object(driver);
		permission_page_navigating.click_attendance();
		permission_page_navigating.click_my_request();
		permission_page_navigating.click_permission();
		
		Thread.sleep(2000);
		permission_page_navigating.click_first_request();
		Thread.sleep(2000);
		permission_page_navigating.cancel_permission_button_click();
		permission_page_navigating.cancellation_success_toast_message_permission();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = "Approved_permission_cancellation")
	public void  Permission_cancellation_approved_first_level() throws InterruptedException
	{
		Logout_object logout_object=new Logout_object(driver);
		logout_object.click_username();
		logout_object.click_logout_button();
		
		loginpage_object teamlead_login=new loginpage_object(driver);
		teamlead_login.mail(proporty.getProperty("tlusermail"));
		teamlead_login.password(proporty.getProperty("tlpassword"));
		teamlead_login.submit();
	Permission_approval_page Permission_My_approval_navigating=new Permission_approval_page(driver);
	Permission_My_approval_navigating.Click_Attendance();
	Permission_My_approval_navigating.Click_MyApproval();
	Permission_My_approval_navigating.Click_Permission_Approval();
	Thread.sleep(2000);
	Permission_My_approval_navigating.Click_Permission_Approval_first_request();
	Thread.sleep(2000);
	Permission_My_approval_navigating.scroll();
	Permission_My_approval_navigating.comment_box("Approved");
	Permission_My_approval_navigating.Click_Approve_button();
	
	Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "Permission_cancellation_approved_first_level")
	public void  Permission_cancellation_approved_second_level() throws InterruptedException
	{
		Logout_object logout_object=new Logout_object(driver);
		logout_object.click_username();
		logout_object.click_logout_button();
		
		loginpage_object teamlead_login=new loginpage_object(driver);
		teamlead_login.mail(proporty.getProperty("managermail"));
		teamlead_login.password(proporty.getProperty("tlpassword"));
		teamlead_login.submit();
	Permission_approval_page Permission_My_approval_navigating=new Permission_approval_page(driver);
	Permission_My_approval_navigating.Click_Attendance();
	Permission_My_approval_navigating.Click_MyApproval();
	Permission_My_approval_navigating.Click_Permission_Approval();
	Thread.sleep(2000);
	Permission_My_approval_navigating.Click_Permission_Approval_first_request();
	Permission_My_approval_navigating.scroll();
	Permission_My_approval_navigating.comment_box("Approved");
	Permission_My_approval_navigating.Click_Approve_button();
	
	Thread.sleep(3000);
	}
	
}
