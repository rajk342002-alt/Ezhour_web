package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Apply_leave_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Halfday_leave_apply_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Halfday_leave_apply extends launchezhour {

	//Half day leave apply
	
	
	@Test
	public void halfdayleavetracker() throws InterruptedException
	{
		logger.info("Ezhour half day take leave sceanrio started");
		
		
		//tenant
Tenant_object tenant_choose=new Tenant_object(driver);
		
//tenant
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
		Thread.sleep(1000);
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

		//navigating apply leave page
		Apply_leave_object leavepage=new Apply_leave_object(driver);
		Halfday_leave_apply_object halfday=new Halfday_leave_apply_object(driver);
		Thread.sleep(3000);
		leavepage.leavetype("LOP");
		
		
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
		
//		leavepage.applybutton();
		
		
		logger.info("Ezhour half day leave sceanior testing is completed");

	}
}
