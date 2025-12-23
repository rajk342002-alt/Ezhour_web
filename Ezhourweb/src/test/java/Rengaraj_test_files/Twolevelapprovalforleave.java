package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Actionhistory_status_approval_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.Two_levelapprovalforleave;
import page_object_rengaraj.loginpage_object;

public class Twolevelapprovalforleave extends launchezhour {

	
	
	
	
//	My approval details page approve and reject button verify -enabled and disable
//  My approval page action history verify
	
	@Test
	public void verify_approve_reject_button() throws InterruptedException
	{
		Tenant_object tenant_choose=new Tenant_object(driver);
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(2000);
		tenant_choose.urlupdate();
		
		
		
		
		loginpage_object login=new loginpage_object(driver);
		login.mail("ramesh.p@rubixtek.com");
		login.password("123qwe");
		login.submit();
		
		
		
		//Dashboard
		Dashboard_object dashboard=new Dashboard_object(driver);
		dashboard.leavetrackerclick();
		
		Two_levelapprovalforleave leave_myapproval=new Two_levelapprovalforleave(driver);
		leave_myapproval.leave_myapproval_navigating();
		leave_myapproval.navigate_myapproval_detailspage();
		leave_myapproval.scroll();
		leave_myapproval.verify_button();
		leave_myapproval.check_buttonis_disabled();
		leave_myapproval.check_buttonis_enabled(proporty.getProperty("comment"));
		leave_myapproval.back_page();
	}
	
	@Test(dependsOnMethods = "verify_approve_reject_button")
	public void my_approval_action_history() throws InterruptedException
	{
		Actionhistory_status_approval_object action_hitory=new Actionhistory_status_approval_object(driver);

	action_hitory.liststatus_text();
		action_hitory.click_list();
		Thread.sleep(2000);
		action_hitory.scroll();
		//status.firstlevel_status();

		action_hitory.userlevel_status();
		action_hitory.firstlevel_status(); //first level
		action_hitory.secondlevel_status(); //second level
		action_hitory.two_level_condition();
		
		
		
	}
}
