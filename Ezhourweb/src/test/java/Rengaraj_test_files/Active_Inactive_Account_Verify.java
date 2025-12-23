package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Active_Inactive_Scenario_object;
import page_object_rengaraj.Logout_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Active_Inactive_Account_Verify extends launchezhour{

	@Test
	public void Active_Inactive_Scenario_Verify() throws InterruptedException
	{
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
		login.mail("admin");
		login.password(proporty.getProperty("password"));
		login.submit();
		login.dashboard_verify();
		
		Active_Inactive_Scenario_object Active_Inactive=new Active_Inactive_Scenario_object(driver);
		Active_Inactive.click_administration();
		Active_Inactive.Click_organization_setup();
		Active_Inactive.Click_user();
		Thread.sleep(2000);
		Active_Inactive.Enter_search_box(proporty.getProperty("Active_Account"));
		Thread.sleep(2000);
		Active_Inactive.verify_userdetails();
		Active_Inactive.In_active_scenario();
		
		Logout_object logout_object=new Logout_object(driver);
		Thread.sleep(2000);
		logout_object.click_username();
		logout_object.click_logout_button();
		
		Thread.sleep(2000);
		loginpage_object teamlead_login=new loginpage_object(driver);
		teamlead_login.mail(proporty.getProperty("Active_Account"));
		teamlead_login.password(proporty.getProperty("password"));
		teamlead_login.submit();
		
		Active_Inactive.login_inactive_Warning_verify();
		
		Active_Inactive.clear_mail_password();
Thread.sleep(2000);
		login.mail("admin");
		login.password(proporty.getProperty("password"));
		login.submit();
		login.dashboard_verify();
		
		Active_Inactive.click_administration();
		Active_Inactive.Click_organization_setup();
		Active_Inactive.Click_user();
		Thread.sleep(2000);
		Active_Inactive.Enter_search_box(proporty.getProperty("Active_Account"));
		Active_Inactive.verify_userdetails();
		Active_Inactive.active_scenario();
		logout_object.click_username();
		logout_object.click_logout_button();
		
		teamlead_login.mail(proporty.getProperty("Active_Account"));
		teamlead_login.password(proporty.getProperty("password"));
		teamlead_login.submit();
		
		
		login.dashboard_verify();

		Thread.sleep(3000);
	}
	
	

	
	
	
}
