package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Apply_leave_object;
import page_object_rengaraj.ApprovedLeaveCancel_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Logout_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.Two_levelapprovalforleave;
import page_object_rengaraj.loginpage_object;

public class ApprovedLeaveCancel extends launchezhour {

	
//	Leave apply user
//  Both level approved	
//  Approved Leave cancellation user
//  Cancellation pending request approved both level
	
	@Test()
	public void apply_leave_then_two_leavel_approved() throws InterruptedException
	{
		//tenant choosing
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
		leaveapply.From_date_click(); //click from field input box
		leaveapply.From_date_select(proporty.getProperty("Fromdate"));
		leaveapply.To_date_click();
		leaveapply.To_date_select(proporty.getProperty("Todate"));;
		leaveapply.reasonleave("Went to friend marriage");
		leaveapply.Page_scroll();;
		leaveapply.applybutton();
		leaveapply.leaveapply_success_tostmessage();
		
		
		Thread.sleep(2000);
		
		
		Logout_object logout_object=new Logout_object(driver);
		logout_object.click_username();
		logout_object.click_logout_button();
		
		loginpage_object teamlead_login=new loginpage_object(driver);
		teamlead_login.mail(proporty.getProperty("tlusermail"));
		teamlead_login.password(proporty.getProperty("tlpassword"));
		teamlead_login.submit();
		
		
		Dashboard_object tl_dashboard=new Dashboard_object(driver);
		tl_dashboard.leavetrackerclick();
		
		
		Two_levelapprovalforleave leave_myapproval=new Two_levelapprovalforleave(driver);
		leave_myapproval.leave_myapproval_navigating();
		
		ApprovedLeaveCancel_object approvedrequest=new ApprovedLeaveCancel_object(driver);
		approvedrequest.approved_leave();
		
		Thread.sleep(2000);
		
		Logout_object logout_object_2=new Logout_object(driver);
		logout_object_2.click_username();
		logout_object_2.click_logout_button();
		
		
		loginpage_object teamlead_login_2=new loginpage_object(driver);
		teamlead_login_2.mail(proporty.getProperty("managermail"));
		teamlead_login_2.password(proporty.getProperty("managerpassword"));
		teamlead_login_2.submit();
		
		Dashboard_object tl_dashboard_2=new Dashboard_object(driver);
		tl_dashboard_2.leavetrackerclick();
		
		Two_levelapprovalforleave leave_myapproval_2=new Two_levelapprovalforleave(driver);
		leave_myapproval_2.leave_myapproval_navigating();
		
		ApprovedLeaveCancel_object approvedrequest_2=new ApprovedLeaveCancel_object(driver);
		approvedrequest_2.approved_leave();
		
		Thread.sleep(2000);
	}
	
	
	
	@Test(dependsOnMethods = "apply_leave_then_two_leavel_approved")
	public void Approved_Leave_cancellation() throws InterruptedException
	{
		
		Logout_object loguout=new Logout_object(driver);
		loguout.click_username();
		loguout.click_logout_button();
	
	//login
	loginpage_object login=new loginpage_object(driver);  //login
	    login.mail(proporty.getProperty("usermail"));
		login.password(proporty.getProperty("password"));
		login.submit();
		
	//Dashboard
	Dashboard_object dashboard=new Dashboard_object(driver);
	dashboard.leavetrackerclick();
	dashboard.leavedetailsclick();

		
		
		ApprovedLeaveCancel_object approvedrequest=new ApprovedLeaveCancel_object(driver);
		Thread.sleep(2000);
		approvedrequest.clickApprovedRequest();
		
	}
	
	@Test(dependsOnMethods = "Approved_Leave_cancellation")
	public void TL_Approved_leave_cancellation_approved() throws InterruptedException
	{
		Thread.sleep(1000);
		Logout_object loguout=new Logout_object(driver);
		loguout.click_username();
		loguout.click_logout_button();
		
		loginpage_object teamlead_login=new loginpage_object(driver);
		teamlead_login.mail(proporty.getProperty("tlusermail"));
		teamlead_login.password(proporty.getProperty("tlpassword"));
		teamlead_login.submit();
		
		Dashboard_object tl_dashboard=new Dashboard_object(driver);
		tl_dashboard.leavetrackerclick();
		
		Two_levelapprovalforleave leave_myapproval=new Two_levelapprovalforleave(driver);
		leave_myapproval.leave_myapproval_navigating();
		
		ApprovedLeaveCancel_object approvedrequest=new ApprovedLeaveCancel_object(driver);
		approvedrequest.tl_approve_approvedcancellation();
		
	}
	
	@Test(dependsOnMethods = "TL_Approved_leave_cancellation_approved")
	public void Manager_Approved_leave_cancellation_approved() throws InterruptedException
	{
		Thread.sleep(2000);

		Logout_object loguout=new Logout_object(driver);
		loguout.click_username();
		loguout.click_logout_button();
		
		loginpage_object teamlead_login=new loginpage_object(driver);
		teamlead_login.mail(proporty.getProperty("managermail"));
		teamlead_login.password(proporty.getProperty("managerpassword"));
		teamlead_login.submit();
		
		Dashboard_object tl_dashboard=new Dashboard_object(driver);
		tl_dashboard.leavetrackerclick();
		Two_levelapprovalforleave leave_myapproval=new Two_levelapprovalforleave(driver);
		leave_myapproval.leave_myapproval_navigating();
		
		ApprovedLeaveCancel_object approvedrequest=new ApprovedLeaveCancel_object(driver);
		approvedrequest.tl_approve_approvedcancellation();
		
		
	}
}
