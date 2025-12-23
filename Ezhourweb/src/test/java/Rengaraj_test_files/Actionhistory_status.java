package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Actionhistory_status_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Actionhistory_status extends launchezhour{

	
	// Action history verify for user, leave tracker page
	
	
	
@Test

public void action_history_status() throws InterruptedException {
	
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


//action history
		Actionhistory_status_object action_hitory=new Actionhistory_status_object(driver);

action_hitory.liststatus_text();
action_hitory.click_list();
action_hitory.scroll();
//status.firstlevel_status();

action_hitory.userlevel_status();
action_hitory.firstlevel_status();//first level
action_hitory.secondlevel_status(); //second level
action_hitory.two_level_condition();



}
}
