package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Apply_leave_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.leavecancellation;
import page_object_rengaraj.loginpage_object;

public class Multiple_days_leave_apply extends launchezhour
{
	
// Multiple days leave apply
	
	@Test
	
public void multiple_day_leave_apply() throws InterruptedException
{
		Tenant_object tenant_choose=new Tenant_object(driver);
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(2000);
		tenant_choose.urlupdate();
		
		//login
		loginpage_object login=new loginpage_object(driver);
		login.mail(proporty.getProperty("usermail_2"));
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
		leaveapply.From_date_click(); //click from field input box
		leaveapply.From_date_select(proporty.getProperty("multiple_fromdate"));
		leaveapply.To_date_click();
		leaveapply.To_date_select(proporty.getProperty("multiple_todate"));
		leaveapply.handleOptionalPopup();
		leaveapply.total_leave_display();
		leaveapply.reasonleave("Went to friend marriage");
		leaveapply.Page_scroll();;
		leaveapply.applybutton();
		leaveapply.leaveapply_success_tostmessage();
		leaveapply.lastrequest_gettext();	
}
	
	@Test(dependsOnMethods = "multiple_day_leave_apply")
	public void multipledays_leave_cancellation() throws InterruptedException
	{
		
		Thread.sleep(3000);
//		Tenant_object tenant_choose=new Tenant_object(driver);
//		tenant_choose.tenant(proporty.getProperty("tenant_name"));
//		tenant_choose.tenant_continue();
//		Thread.sleep(2000);
//		tenant_choose.urlupdate();
//
//	//login
//	loginpage_object login=new loginpage_object(driver);
//	login.mail(proporty.getProperty("usermail"));
//	login.password(proporty.getProperty("password"));
//	login.submit();
//
//	//Dashboard
//			Dashboard_object dashboard=new Dashboard_object(driver);
//			dashboard.leavetrackerclick();
//			dashboard.leavedetailsclick();


	
leavecancellation Leave_Cancellation=new leavecancellation(driver);

Leave_Cancellation.Leavestatus_gettext();
Thread.sleep(2000);
Leave_Cancellation.navigate_leavedetails_page();
Leave_Cancellation.leave_cancellation_success_toast();
	}
	
}