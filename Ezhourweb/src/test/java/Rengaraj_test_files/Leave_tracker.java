
package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.leave_tracker_all_content_verify_object;
import page_object_rengaraj.loginpage_object;

public class Leave_tracker extends launchezhour {

	
// Leave tracker all content verify
// leave tracker search filter verify
// Leave tracker pagination verify --enabled, disabled, next, previous button
	
	
	
	@Test
	public void leave_tracker_content() throws InterruptedException {
		
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
		
		leave_tracker_all_content_verify_object leave_tracker=new leave_tracker_all_content_verify_object(driver);
		leave_tracker.leave_tracker_verify();
		leave_tracker.leave_details_verify();
		leave_tracker.leave_tracker_title_verify();
		leave_tracker.apply_button_verify();
		leave_tracker.leave_count_box_verify();
		leave_tracker.search_box_verify();
	
		leave_tracker.leave_tracker_filter();
		leave_tracker.page_refresh();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = "leave_tracker_content")
	public void Leave_tracker_paginaton() throws InterruptedException
	{
		leave_tracker_all_content_verify_object leave_tracker=new leave_tracker_all_content_verify_object(driver);
		leave_tracker.total_count_verify();
		leave_tracker.pagination_button_verify();
		leave_tracker.pagination_middle_verify();
		leave_tracker.pagination_enable_disable_verify();
	}
	
}
