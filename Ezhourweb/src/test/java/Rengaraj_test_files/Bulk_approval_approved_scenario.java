package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Apply_leave_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Logout_object;
import page_object_rengaraj.Myapproval_multiselect_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.Two_levelapprovalforleave;
import page_object_rengaraj.loginpage_object;

public class Bulk_approval_approved_scenario extends launchezhour

{

	@Test
	public void Apply_leave_In_Bulk_approval_approved() throws InterruptedException
	{
	
		
		
		Tenant_object tenant_choose=new Tenant_object(driver);
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(2000);
		tenant_choose.urlupdate();
		
		//login
		loginpage_object login=new loginpage_object(driver);
		login.mail(proporty.getProperty("usermail_3"));
		login.password(proporty.getProperty("password"));
		login.submit();
		
		//Dashboard
		Dashboard_object dashboard=new Dashboard_object(driver);
		dashboard.leavetrackerclick();
		dashboard.leavedetailsclick();
		
		
		int fromdate=Integer.parseInt(proporty.getProperty("multiiple_request_fromdate"));
//		int todate=Integer.parseInt(proporty.getProperty("Todate"));
		
		for(int i=1;i<=5;i++)
		{
		
			Thread.sleep(2000);
		//Leave tracker
		Leavetracker_object leavetracker=new Leavetracker_object(driver);
		leavetracker.applyleave_button();
		
		//leave apply
		Apply_leave_object leaveapply=new Apply_leave_object(driver);
		Thread.sleep(3000);
		leaveapply.leavetype("LOP"); //leavetype
		leaveapply.From_date_click(); //click from field input box
		leaveapply.From_date_select(String.valueOf(fromdate));
		leaveapply.To_date_click();
		leaveapply.To_date_select(String.valueOf(fromdate));

		
		leaveapply.total_leave_display();
		leaveapply.reasonleave("Went to friend marriage");
		leaveapply.Page_scroll();;
		leaveapply.applybutton();
		leaveapply.leaveapply_success_tostmessage();
		leaveapply.lastrequest_gettext();
		
		fromdate++;
//		todate++;
		Thread.sleep(2000);
	}
	}
	
	@Test(dependsOnMethods = "Apply_leave_In_Bulk_approval_approved")
	public void First_leavel_Bulk_approval_reject() throws InterruptedException
	{
		Thread.sleep(2000);
		
		
		Logout_object logout_object=new Logout_object(driver);
		logout_object.click_username();
		logout_object.click_logout_button();
		
		loginpage_object teamlead_login=new loginpage_object(driver);
		teamlead_login.mail(proporty.getProperty("managermail"));
		teamlead_login.password(proporty.getProperty("tlpassword"));
		teamlead_login.submit();
		
		
		Dashboard_object tl_dashboard=new Dashboard_object(driver);
		tl_dashboard.leavetrackerclick();
		
		
		Two_levelapprovalforleave leave_myapproval=new Two_levelapprovalforleave(driver);
		leave_myapproval.leave_myapproval_navigating();
		
Myapproval_multiselect_object multiselect=new Myapproval_multiselect_object(driver);
		
		multiselect.click_pending_dropdown();
		multiselect.pending_multiselect(proporty.getProperty("comment"));
//		multiselect.multiselect_approve_button_click();
		Thread.sleep(2000);
//		multiselect.Approved_sucess_message();
}
}
