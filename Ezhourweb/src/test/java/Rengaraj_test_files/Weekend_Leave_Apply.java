package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Apply_leave_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.Weekend_leave_apply_object;
import page_object_rengaraj.loginpage_object;

public class Weekend_Leave_Apply extends launchezhour {

// Weekend leave apply
	
	@Test
	public void Weekend_Leave_Apply_Verify() throws InterruptedException
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
		leaveapply.From_date_select(proporty.getProperty("weekend_fromdate"));;
		leaveapply.To_date_click();
		leaveapply.To_date_select(proporty.getProperty("Weekend_todate"));
		
		
		Weekend_leave_apply_object weekend_choose=new Weekend_leave_apply_object(driver);
		weekend_choose.Weekend_choose_alertbox();
	
}}
