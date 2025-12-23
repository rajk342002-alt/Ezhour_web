package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Apply_leave_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leave_rejected_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Logout_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.Two_levelapprovalforleave;
import page_object_rengaraj.loginpage_object;

public class Half_day_rejected_scenario extends launchezhour {

	
// Half day - rejected first approver
// Half day 1 level approved -- 2 level rejected
	
	  @Test
			public void Half_day_leave_apply_for_firstlevel_rejected_scenarieo() throws InterruptedException
			{
		    	  logger.info("Ezhour apply leave page testing started");
				
				
				
				//tenant choosing
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
				Thread.sleep(2000);
				leaveapply.leavetype("LOP"); //leavetype
				leaveapply.From_date_click(); //click from field input box
				leaveapply.From_date_select(proporty.getProperty("Fromdate"));
				leaveapply.To_date_click();
				leaveapply.To_date_select(proporty.getProperty("Todate"));;
				leaveapply.reasonleave("Went to friend marriage");
				leaveapply.Page_scroll();;
				logger.info("Ezhour apply leave scenario completed");
				leaveapply.applybutton();
				leaveapply.leaveapply_success_tostmessage();
				leaveapply.lastrequest_gettext();
				
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
					
					
					Thread.sleep(2000);
					Leave_rejected_object leave_reject=new Leave_rejected_object(driver);
					Thread.sleep(2000);
					leave_reject.click_last_leave_request();
					Thread.sleep(2000);
					leave_reject.last_leave_request_reject();
			}
		   
		   @Test(dependsOnMethods = "Half_day_leave_apply_for_firstlevel_rejected_scenarieo",enabled = true)
		   public void Half_day_leave_first_leave_approval_second_leavel_rejected() throws InterruptedException
		   {
			  Thread.sleep(2000);
				Logout_object logout_object_user=new Logout_object(driver);
				
				logout_object_user.click_username();
				logout_object_user.click_logout_button();
				
				
				
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
				Thread.sleep(2000);
				leaveapply.leavetype("LOP"); //leavetype
				leaveapply.From_date_click(); //click from field input box
				leaveapply.From_date_select(proporty.getProperty("Fromdate"));
				leaveapply.To_date_click();
				leaveapply.To_date_select(proporty.getProperty("Todate"));;
				leaveapply.reasonleave("Went to friend marriage");
				leaveapply.Page_scroll();;
				logger.info("Ezhour apply leave scenario completed");
				leaveapply.applybutton();
				leaveapply.leaveapply_success_tostmessage();
				leaveapply.lastrequest_gettext();
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
					
		
					Leave_rejected_object leave_reject=new Leave_rejected_object(driver);
					Thread.sleep(2000);
					leave_reject.click_last_leave_request();
					Thread.sleep(2000);
					leave_reject.last_leave_request_approved();
				
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
				
						Leave_rejected_object leave_reject_2=new Leave_rejected_object(driver);
						Thread.sleep(2000);
						leave_reject_2.click_last_leave_request();
						Thread.sleep(2000);
						leave_reject_2.last_leave_request_reject();
					
					
					
		   }
}
