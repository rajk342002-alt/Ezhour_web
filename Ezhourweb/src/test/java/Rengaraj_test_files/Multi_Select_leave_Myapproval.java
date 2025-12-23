package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Myapproval_multiselect_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.Two_levelapprovalforleave;
import page_object_rengaraj.loginpage_object;

public class Multi_Select_leave_Myapproval  extends launchezhour{

// Multi select for my approval page
	
	
	@Test
	public void Verify_Pending_Multi_select_myapproval() throws InterruptedException
	{
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
		Myapproval_multiselect_object multiselect=new Myapproval_multiselect_object(driver);
		
		multiselect.click_pending_dropdown();
		multiselect.pending_multiselect(proporty.getProperty("comment"));
	}
	
	//pending multiselect
	
	@Test(dependsOnMethods ="Verify_Pending_Multi_select_myapproval" )
	public void Verify_Approved_Multi_Select_Approval() throws InterruptedException
	{
		Myapproval_multiselect_object multiselect=new Myapproval_multiselect_object(driver);
		multiselect.click_approved_dropdown();
		multiselect.Approved_multiselect();
		
	}
	
	
//	Approved multiselect
	
	@Test(dependsOnMethods ="Verify_Approved_Multi_Select_Approval" )
	public void Verify_Inqueue_Multi_Select_Approval() throws InterruptedException
	{
		Myapproval_multiselect_object multiselect=new Myapproval_multiselect_object(driver);
		multiselect.click_Inqueue_dropdown();
		multiselect.multiselect();
	}
	
	//Inqueue multiselect
	
	@Test(dependsOnMethods = "Verify_Inqueue_Multi_Select_Approval")
	public void Verify_Rejected_Multi_Select_Approval() throws InterruptedException
	{
		Myapproval_multiselect_object multiselect=new Myapproval_multiselect_object(driver);
		multiselect.click_rejected_dropdown();
		multiselect.multiselect();
	}
	
	// Rejected Multiselect
	
	@Test(dependsOnMethods = "Verify_Rejected_Multi_Select_Approval")
	public void Verify_cancelled_Multi_Select_Approval() throws InterruptedException
	{
		Myapproval_multiselect_object multiselect=new Myapproval_multiselect_object(driver);
		multiselect.click_cancelled_dropdown();
		multiselect.multiselect();
	}
//	
	
	//cancelled multiselect
	
	@Test(dependsOnMethods = "Verify_cancelled_Multi_Select_Approval")
	public void Verify_CancellationPending_Multi_Select_Approval() throws InterruptedException
	{
		Myapproval_multiselect_object multiselect=new Myapproval_multiselect_object(driver);
		multiselect.click_cancellation_pending();
		multiselect.pending_multiselect(proporty.getProperty("comments"));;
		multiselect.refresh();
	}
	
}
