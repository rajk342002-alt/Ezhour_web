package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.Total_count_myapproval_page_object;
import page_object_rengaraj.Two_levelapprovalforleave;
import page_object_rengaraj.loginpage_object;
import page_object_rengaraj.pagination_mypproval_page_object;

public class Total_Count_My_Approval_page extends launchezhour{

	
	@Test
	public void Pagination_Approval_page() throws InterruptedException
	{
		pagination_mypproval_page_object leave_tracker=new pagination_mypproval_page_object(driver);

		Tenant_object tenant_choose=new Tenant_object(driver);
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(2000);
		tenant_choose.urlupdate();
		
		loginpage_object login=new loginpage_object(driver);
		login.mail(proporty.getProperty("tlusermail"));
		login.password(proporty.getProperty("tlpassword"));
		login.submit();
		
		//Dashboard
		Dashboard_object dashboard=new Dashboard_object(driver);
		dashboard.leavetrackerclick();
		
		Two_levelapprovalforleave leave_myapproval=new Two_levelapprovalforleave(driver);
		leave_myapproval.leave_myapproval_navigating();
		Thread.sleep(2000);
		leave_tracker.total_count_verify();
	
		
Total_count_myapproval_page_object total_count=new Total_count_myapproval_page_object(driver);
		
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
