package Rengaraj_test_files;

import java.io.IOException;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Imagevalidation_apply_leavepage_blank_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Imagevalidation_apply_leavepage_blank  extends launchezhour{

	//Imagevalidation_apply_leavepage
	
	@Test
	public void applyleave_button_image() throws InterruptedException, IOException
	{
		
		//tenant
Tenant_object tenant_choose=new Tenant_object(driver);
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(2000);
		tenant_choose.urlupdate();
		
		//login
		loginpage_object login=new loginpage_object(driver);
		login.mail("abirami.s@rubixtek.com");
		login.password("123qwe");
		login.submit();
		
		//Dashboard
		Dashboard_object dashboard=new Dashboard_object(driver);
		dashboard.leavetrackerclick();
		dashboard.leavedetailsclick();

		
		//Leave tracker
		Leavetracker_object leavetracker=new Leavetracker_object(driver);
		leavetracker.applyleave_button();
		
		Imagevalidation_apply_leavepage_blank_object imagevalidation=new Imagevalidation_apply_leavepage_blank_object(driver);
		imagevalidation.leavepage_imagevalidation();
	
	}
}
