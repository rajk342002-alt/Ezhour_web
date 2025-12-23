package Rengaraj_test_files;

import org.testng.annotations.Test;
import baseclass.launchezhour;
import page_object_rengaraj.Apply_leave_object;
import page_object_rengaraj.Dashboard_object;
import page_object_rengaraj.Leavetracker_object;
import page_object_rengaraj.Tenant_object;
import page_object_rengaraj.loginpage_object;

public class WithoutLeaveApply_Cancel_Button extends launchezhour {

//Leave page cancel button	
	
	
    @Test
    public void leave_apply_cancel_button() throws InterruptedException {
        
        // Tenant choosing
        Tenant_object tenant_choose = new Tenant_object(driver);
        tenant_choose.tenant(proporty.getProperty("tenant_name"));
        tenant_choose.tenant_continue();
        Thread.sleep(2000);
        tenant_choose.urlupdate();

        // Login
        loginpage_object login = new loginpage_object(driver);
        login.mail(proporty.getProperty("usermail"));
        login.password(proporty.getProperty("password"));
        login.submit();

        // Dashboard
        Dashboard_object dashboard = new Dashboard_object(driver);
        dashboard.leavetrackerclick();
        dashboard.leavedetailsclick();

        // Leave tracker
        Leavetracker_object leavetracker = new Leavetracker_object(driver);
        leavetracker.applyleave_button();

        // Leave apply
        Apply_leave_object leaveapply = new Apply_leave_object(driver);
        leaveapply.leavetype("OPH"); // leave type
        leaveapply.From_date_click();
        leaveapply.From_date_select(proporty.getProperty("Fromdate"));
        leaveapply.To_date_click();
        leaveapply.To_date_select(proporty.getProperty("Todate"));
        leaveapply.total_leave_display();
        leaveapply.reasonleave("Went to friend marriage");
        leaveapply.Page_scroll();

        // 🔹 Cancel button click
        leaveapply.cancel_button();
        Thread.sleep(2000);
        leavetracker.applyleave_button();
        leaveapply.New_apply_leave_page_checking();
        
        
    }
}
