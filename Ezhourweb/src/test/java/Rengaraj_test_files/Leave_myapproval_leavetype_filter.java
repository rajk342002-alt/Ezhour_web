package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Myapproval_filters;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.Two_levelapprovalforleave;
import page_object_rengaraj.loginpage_object;

public class Leave_myapproval_leavetype_filter extends launchezhour {

	//  My approval page --> leave type filter and leave status filter
	
	@Test
	public void Myapproval_leavetype_filter() throws InterruptedException
	{
		
		Tenant_object tenant_choose=new Tenant_object(driver);
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(2000);
		tenant_choose.urlupdate();
		
		loginpage_object login=new loginpage_object(driver);
		login.mail(proporty.getProperty("tlusermail"));
		login.password(proporty.getProperty("tlpassword"));
		login.submit();
		
		//Dashboard
		Dashboard_object dashboard=new Dashboard_object(driver);
		dashboard.leavetrackerclick();
		
		Two_levelapprovalforleave leave_myapproval=new Two_levelapprovalforleave(driver);
		leave_myapproval.leave_myapproval_navigating();
		
		Myapproval_filters leavetype_filter=new Myapproval_filters(driver);
		leavetype_filter.leavetype_dropdown("Casual");
		leavetype_filter.leavetype_dropdown("Sick");
		leavetype_filter.leavetype_dropdown("OPH");
		leavetype_filter.leavetype_dropdown("LOP");
		leavetype_filter.leavetype_dropdown("Maternity Leave");
		leavetype_filter.Back_to_default_leavetype_dropdown();

		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = "Myapproval_leavetype_filter")
	public void Myapproval_Leave_status_Filter() throws InterruptedException
	{
	
		
		Thread.sleep(2000);

		Myapproval_filters leavestatus_filter=new Myapproval_filters(driver);
        leavestatus_filter.leave_status_dropdown_filter("Pending");
        leavestatus_filter.leave_status_dropdown_filter("Inqueue");
        leavestatus_filter.leave_status_dropdown_filter("Approved");
        leavestatus_filter.leave_status_dropdown_filter("Rejected");
        leavestatus_filter.leave_status_dropdown_filter("PartialApproved");
        leavestatus_filter.leave_status_dropdown_filter("Cancelled");
        leavestatus_filter.leave_status_dropdown_filter("CancellationPending");
        leavestatus_filter.leave_status_dropdown_filter("CancellationInque");

		
		
	}
	
	
	
}
