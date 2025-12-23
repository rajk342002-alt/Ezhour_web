package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.LeaveDetais_comparison_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;


public class Leavedetails_comparison extends launchezhour{
	
// Leave tracker details compare with Leave details page

	
@Test
public void Leavetracker_Leavedetails_comparison() throws InterruptedException
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


//apply leave page and leave tracker page roll no, leave type verify
LeaveDetais_comparison_object leave_details=new LeaveDetais_comparison_object(driver);
Thread.sleep(2000);
leave_details.leavetracker_gettext();
Thread.sleep(2000);
leave_details.navigate_leave_detailspage();
Thread.sleep(2000);
leave_details.leavedetails_gettext();
leave_details.verifyroll_number_leavetracker_leavedetails();
leave_details.verifyleavetype_leavetracker_leavedetails();
}
	
	
}
