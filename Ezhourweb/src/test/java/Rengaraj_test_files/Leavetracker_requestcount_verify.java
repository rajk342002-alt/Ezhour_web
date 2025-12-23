package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leavetracker_requescount_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;


public class Leavetracker_requestcount_verify extends launchezhour {

//leave tracker page request count verify --> set count	
	
	
	@Test
	public void Leavetracker_request_count() throws InterruptedException {
		//tenant
Tenant_object tenant_choose=new Tenant_object(driver);


		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(2000);
		tenant_choose.urlupdate();
	
	//login
	loginpage_object login=new loginpage_object(driver);  //login
	    login.mail(proporty.getProperty("usermail"));
		login.password(proporty.getProperty("password"));
		login.submit();
		
	//Dashboard
	Dashboard_object dashboard=new Dashboard_object(driver);
	dashboard.leavetrackerclick();
	dashboard.leavedetailsclick();

		//Leave tracker page request list count 
		Leavetracker_requescount_object list_count=new Leavetracker_requescount_object(driver);  //request date
		list_count.scroll();
		list_count.listcount();
		
		
		
	}
}
