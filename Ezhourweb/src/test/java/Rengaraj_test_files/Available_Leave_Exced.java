package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Apply_leave_object;
import page_object_rengaraj.Available_Leave_Exceed_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Available_Leave_Exced extends launchezhour {

	
// Available leave exceed for causal and sick, optional
	
	
	@Test
	public void causal_leave_exceed() throws InterruptedException
	{
		Tenant_object tenant_choose=new Tenant_object(driver);
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(2000);
		tenant_choose.urlupdate();
		
		//login
		loginpage_object login=new loginpage_object(driver);
		login.mail("bharath.gurumoorthy@rubixtek.com");
		login.password("123qwe");
		login.submit();
		
		//Dashboard
		Dashboard_object dashboard=new Dashboard_object(driver);
		dashboard.leavetrackerclick();
		dashboard.leavedetailsclick();
		
		
		//Leave tracker
		Leavetracker_object leavetracker=new Leavetracker_object(driver);
		leavetracker.applyleave_button();
		
		//leave apply
		Apply_leave_object leaveapply=new Apply_leave_object(driver);
		Thread.sleep(3000);
		leaveapply.leavetype("Casual"); //leavetype
		leaveapply.From_date_click(); //click from field input box
		leaveapply.From_date_select(proporty.getProperty("Fromdate"));
		leaveapply.To_date_click();
		leaveapply.To_date_select(proporty.getProperty("Todate"));;
		leaveapply.reasonleave("Went to friend marriage");
		leaveapply.Page_scroll();;
		leaveapply.applybutton();
		
		Available_Leave_Exceed_object warning=new Available_Leave_Exceed_object(driver);
		warning.Leave_exceed_warning_message();
		warning.warning_click_ok_button();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = "causal_leave_exceed")
	public void sick_leave_exceed() throws InterruptedException
	{
		Apply_leave_object leaveapply=new Apply_leave_object(driver);
		Thread.sleep(3000);
		leaveapply.leavetype("Sick"); //leavetype
		leaveapply.From_date_click(); //click from field input box
		leaveapply.From_date_select(proporty.getProperty("Fromdate"));
		leaveapply.To_date_click();
		leaveapply.To_date_select(proporty.getProperty("Todate"));;
		leaveapply.reasonleave("Went to friend marriage");
		leaveapply.Page_scroll();;
		leaveapply.applybutton();
		
		Available_Leave_Exceed_object warning=new Available_Leave_Exceed_object(driver);
		warning.Leave_exceed_warning_message();
		warning.warning_click_ok_button();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = "sick_leave_exceed")
	public void optional_leave_exceed() throws InterruptedException
	{
		
		Apply_leave_object leaveapply=new Apply_leave_object(driver);
		Thread.sleep(3000);
		leaveapply.leavetype("OPH"); //leavetype
		leaveapply.From_date_click(); //click from field input box
		leaveapply.From_date_select(proporty.getProperty("Fromdate"));
		leaveapply.To_date_click();
		leaveapply.To_date_select(proporty.getProperty("Todate"));;
		leaveapply.reasonleave("Went to friend marriage");
		leaveapply.Page_scroll();;
		leaveapply.applybutton();
		
		Available_Leave_Exceed_object warning=new Available_Leave_Exceed_object(driver);
		warning.Leave_exceed_warning_message();
		warning.warning_click_ok_button();
		Thread.sleep(2000);
	}
}
