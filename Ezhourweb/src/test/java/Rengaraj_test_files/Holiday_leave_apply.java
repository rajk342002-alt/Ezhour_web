package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Apply_leave_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Holiday_leave_apply extends launchezhour {

	@Test
	public void Holiday_leave_apply_warning_message() throws InterruptedException
	{
		Tenant_object tenant_choose=new Tenant_object(driver);
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(2000);
		tenant_choose.urlupdate();
		
		//login
		loginpage_object login=new loginpage_object(driver);
		login.mail(proporty.getProperty("usermail"));
		login.password(proporty.getProperty("password"));
		login.submit();
		
		//Dashboard
		Dashboard_object dashboard=new Dashboard_object(driver);
		dashboard.leavetrackerclick();
		dashboard.leavedetailsclick();
		
		
		
		//Leave tracker
		Leavetracker_object leavetracker=new Leavetracker_object(driver);
		leavetracker.applyleave_button();
		
		//leave apply
		Apply_leave_object leaveapply=new Apply_leave_object(driver);
		Thread.sleep(3000);
		leaveapply.leavetype("LOP"); //leavetype
		Thread.sleep(2000);
		leaveapply.Holiday_FromDate_leave_Apply(proporty.getProperty("Holiday_month"),proporty.getProperty("Holiday_from_date"));
		Thread.sleep(2000);
		leaveapply.To_date_click();
		leaveapply.To_date_select(proporty.getProperty("Holiday_To_date"));
		leaveapply.holiday_warning_popup();
		Thread.sleep(2000);
	}
	
	
}
