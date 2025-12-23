package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Leavetracker_leavedays_verify extends launchezhour{
	
	
//leave count box verify available and total leave	
	
	@Test
	public void Leave_count_box_available_totaldays() throws InterruptedException
	{
		
		//tenant 
Tenant_object tenant_choose=new Tenant_object(driver);
		
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(2000);
		tenant_choose.urlupdate();

		
		
		loginpage_object login=new loginpage_object(driver);
		login.mail(proporty.getProperty("usermail"));
		login.password(proporty.getProperty("password"));
		login.submit();
		//login
	
		
		
		
		//Dashboard
		Dashboard_object dashboard=new Dashboard_object(driver);
		dashboard.leavetrackerclick();
		dashboard.leavedetailsclick();
		
		
		//ezhour leave count comparasion
		Leavetracker_object leavetracker=new Leavetracker_object(driver);
		leavetracker.causalleave_available_total();
		leavetracker.sickleavebox_available_total();;
		leavetracker.optionalholiday_available_total();;
		logger.info("Ezhour leave tracker available and total leave count comparision is completed");
	}
	
	
	
	
}
