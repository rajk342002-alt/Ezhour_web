package Rengaraj_test_files;

import java.io.IOException;
import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Loginpage extends launchezhour{
   
	@Test
	public void correct_login_test() throws InterruptedException, IOException
	{
		//tenant
Tenant_object tenant_choose=new Tenant_object(driver);
//		tenant_choose.sigin();
//		Thread.sleep(3000);
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(3000);
		tenant_choose.urlupdate();
		logger.info("Ezhour login is started");
		
		
		//login
		loginpage_object login=new loginpage_object(driver);
//		login.imagevalidation();
		login.mail(proporty.getProperty("usermail"));
		login.password(proporty.getProperty("password"));
		login.submit();
		login.dashboard_verify();
		logger.info("Ezhour login is completed");
		
	}
	  

}
