package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Apply_leave_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Halfday_cancellation_object;
import page_object_rengaraj.Halfday_leave_apply_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.leavecancellation;
import page_object_rengaraj.loginpage_object;

public class Double_Half_Day extends launchezhour{

//  Single day --first half (causal)--second half (Sick)
//  Same half apply same date
//  Cancellation both half day - one be on
	
	
	@Test
	public void Halfday_Causal_And_Sick() throws InterruptedException
	{
		//tenant
Tenant_object tenant_choose=new Tenant_object(driver);
		
//tenant
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(1000);
		tenant_choose.urlupdate();
		
		//login
		loginpage_object login=new loginpage_object(driver);
		login.mail(proporty.getProperty("usermail_2"));
		login.password(proporty.getProperty("password"));
		login.submit();
		
		
		//Dashboard
		Dashboard_object dashboard=new Dashboard_object(driver);
		dashboard.leavetrackerclick();
		dashboard.leavedetailsclick();
		
		//Leave tracker
		Leavetracker_object leavetracker=new Leavetracker_object(driver);
		leavetracker.applyleave_button();

		//navigating apply leave page
		Apply_leave_object leavepage=new Apply_leave_object(driver);
		Halfday_leave_apply_object halfday=new Halfday_leave_apply_object(driver);
		Thread.sleep(3000);
		leavepage.leavetype("Casual");
		
		
		//Calender
		leavepage.From_date_click(); //click from field input box
		leavepage.From_date_select(proporty.getProperty("Halfday_fromdate"));
		leavepage.To_date_click();
		String dateValue = proporty.getProperty("Halfday_todate");
		System.out.println("To Date value from property: " + dateValue);
	    leavepage.To_date_select(proporty.getProperty("Halfday_todate"));
		
	
		//half day leave apply 
		
		halfday.halfday(1);
		leavepage.reasonleave("fever and personal reason");
		leavepage.Page_scroll();
		
		leavepage.applybutton();
		
		Thread.sleep(2000);
			
	}
	
	@Test(dependsOnMethods = "Halfday_Causal_And_Sick")
	public void Half_Day_Apply_Same_Date_Same_Half() throws InterruptedException
	{
		Thread.sleep(2000);
		//Leave tracker
		Leavetracker_object leavetracker=new Leavetracker_object(driver);
		leavetracker.applyleave_button();

		//navigating apply leave page
		Apply_leave_object leavepage=new Apply_leave_object(driver);
		Halfday_leave_apply_object halfday=new Halfday_leave_apply_object(driver);
		Thread.sleep(3000);
		leavepage.leavetype("Casual");
		
		
		//Calender
		leavepage.From_date_click(); //click from field input box
		leavepage.From_date_select(proporty.getProperty("Halfday_fromdate"));
		leavepage.To_date_click();
		String dateValue = proporty.getProperty("Halfday_todate");
		System.out.println("To Date value from property: " + dateValue);
	    leavepage.To_date_select(proporty.getProperty("Halfday_todate"));
		
	
		//half day leave apply 
		
		halfday.halfday(1);
		leavepage.reasonleave("fever and personal reason");
		leavepage.Page_scroll();
		
		leavepage.applybutton();
		
		Thread.sleep(1000);
		leavepage.leaveapply_already_taken_days();
		Thread.sleep(2000);
		
	}
	
	
	@Test(dependsOnMethods ="Half_Day_Apply_Same_Date_Same_Half" )
	public void Second_Half_Sick_SameDay() throws InterruptedException
	{
		

		//navigating apply leave page
		Apply_leave_object leavepage=new Apply_leave_object(driver);
		Halfday_leave_apply_object halfday_2=new Halfday_leave_apply_object(driver);
		Thread.sleep(3000);
		leavepage.leavetype("Sick");
		
		
		//Calender
		leavepage.From_date_click(); //click from field input box
		leavepage.From_date_select(proporty.getProperty("Halfday_fromdate"));
		leavepage.To_date_click();
		String dateValue_second = proporty.getProperty("Halfday_todate");
		System.out.println("To Date value from property: " + dateValue_second);
	    leavepage.To_date_select(proporty.getProperty("Halfday_todate"));
		
	
		//half day leave apply 
		
		halfday_2.halfday(2);
		leavepage.reasonleave("fever and personal reason");
		leavepage.Page_scroll();
		
		leavepage.applybutton();
		
		Thread.sleep(2000);
	}
	
	
	@Test(dependsOnMethods = "Second_Half_Sick_SameDay",enabled= true)
	public void Second_Half_Leave_cancelled() throws InterruptedException
	{
		Thread.sleep(2000);
		Halfday_cancellation_object leave_cancellation_2=new Halfday_cancellation_object(driver);
		leave_cancellation_2.Leavestatus_gettext();
		Thread.sleep(2000);
		leave_cancellation_2.navigate_leavedetails_page(); 
		
		leave_cancellation_2.leave_cancellation_success_toast();
	}
	
	
	
	
	
	@Test(dependsOnMethods = "Second_Half_Leave_cancelled",enabled = true)
	public void First_Half_Leave_Cancelled() throws InterruptedException
	{
		
		Thread.sleep(2000);
		
		leavecancellation Leave_Cancellation=new leavecancellation(driver);

		Leave_Cancellation.Leavestatus_gettext();
		Thread.sleep(2000);
		Leave_Cancellation.navigate_leavedetails_page();
		Leave_Cancellation.leave_cancellation_success_toast();
		
		Thread.sleep(2000);
	
	}
	

	
	
	
	
}
