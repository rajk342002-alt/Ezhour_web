
package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Apply_leave_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class Apply_leave extends launchezhour{
	
//	Apply leave single days
//  Apply same date again
	
      @Test
	public void Leave_Apply() throws InterruptedException
	{
    	  logger.info("Ezhour apply leave page testing started");
		
		
		
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
		
		//leave apply
		Apply_leave_object leaveapply=new Apply_leave_object(driver);
		Thread.sleep(3000);
		leaveapply.leavetype("LOP"); //leavetype
		leaveapply.From_date_click(); //click from field input box
		leaveapply.From_date_select(proporty.getProperty("Fromdate"));
		leaveapply.To_date_click();
		leaveapply.To_date_select(proporty.getProperty("Todate"));;

		
		leaveapply.total_leave_display();
		leaveapply.reasonleave("Went to friend marriage");
		leaveapply.Page_scroll();;
		leaveapply.applybutton();
		leaveapply.leaveapply_success_tostmessage();
		leaveapply.lastrequest_gettext();
	}
      
      @Test(dependsOnMethods ="Leave_Apply",enabled = true)
      public void Already_Leave_apply_date
      () throws InterruptedException
  	{

   		//Leave tracker
  		Leavetracker_object leavetracker=new Leavetracker_object(driver);
  		leavetracker.applyleave_button();
  		
  		//leave apply
  		Apply_leave_object leaveapply=new Apply_leave_object(driver);
  		Thread.sleep(3000);
  		leaveapply.leavetype("LOP"); //leavetype
  		leaveapply.From_date_click(); //click from field input box
  		leaveapply.From_date_select(proporty.getProperty("Fromdate"));
  		leaveapply.To_date_click();
  		leaveapply.To_date_select(proporty.getProperty("Todate"));;
  		leaveapply.reasonleave("Went to friend marriage");
  		leaveapply.Page_scroll();
  		
  		leaveapply.applybutton();
  		leaveapply.leaveapply_already_taken_days();
  		
  		logger.info("Ezhour apply leave scenario completed");

  	}
      
     
      

}
