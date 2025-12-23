package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Apply_leavepage_text_verify_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Apply_leavepage_text_verify extends launchezhour {

//  Apply leave page all text verify 
	
	
	@Test
	public void Apply_leavepage_label_verify() throws InterruptedException
	{
		logger.info("Ezhour apply leave page all text verification is started");
				
		
		
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
		
		
		
		//apply leave page message verify
		
		Apply_leavepage_text_verify_object apply_leave_labels=new Apply_leavepage_text_verify_object(driver);
		apply_leave_labels.Addrequest_label();
		apply_leave_labels.Leavetype_label_text();
		apply_leave_labels.Leavetype_dropdown_options_text();
		apply_leave_labels.leavereason_text();
		apply_leave_labels.Upload_file_text();
		apply_leave_labels.cancel_button_text();
		apply_leave_labels.apply_button_text();
		
		
		
		logger.info("Ezhour apply leave page all text verfication is completed");
	}
	
}
