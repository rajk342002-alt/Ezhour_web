package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.leavecancellation;
import page_object_rengaraj.loginpage_object;

public class LeaveCancellation extends launchezhour {
	
// Leave Cancellation 
	
	@Test()
	public void Leave_Cancellation() throws InterruptedException
	{
		//tenant
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


	
leavecancellation Leave_Cancellation=new leavecancellation(driver);

Leave_Cancellation.Leavestatus_gettext();
Thread.sleep(2000);
Leave_Cancellation.navigate_leavedetails_page();
Leave_Cancellation.leave_cancellation_success_toast();

	}

}
