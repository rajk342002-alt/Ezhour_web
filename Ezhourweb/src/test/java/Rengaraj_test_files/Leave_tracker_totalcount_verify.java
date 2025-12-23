package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.Totalcount_Verify_object;
import page_object_rengaraj.loginpage_object;

public class Leave_tracker_totalcount_verify extends launchezhour{

// My request total request count verify
	
	
	
	@Test
	public void Total_request_count() throws InterruptedException
	{
		
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
		
		
		Totalcount_Verify_object total_count=new Totalcount_Verify_object(driver);
		
		Thread.sleep(2000);
		total_count.scroll_bottom();
		total_count.count_dropdown_click();
		total_count.click_500();
		Thread.sleep(3000);
		total_count.scroll_bottom();
		Thread.sleep(2000);
		total_count.total_count_verify();
		Thread.sleep(2000);
		
		
		
	}
	
	
	
}
