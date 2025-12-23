package Madhan_test_files;

 
import static org.testng.Assert.assertEquals;
 
import java.io.IOException;

import java.util.concurrent.TimeUnit;
 


import org.openqa.selenium.InvalidElementStateException;

import org.testng.annotations.Test;

import Page_object_madhan.Tenant_login_object;
import Page_object_madhan.Timesheet_object;
import baseclass.Baseclass;

 
public class Timesheet_test_file extends Baseclass {
 
	 @Test

	    public void TImesheetDetailpage() throws InterruptedException {
		 
		 
		Tenant_login_object tenent= new Tenant_login_object(driver);
			tenent.clicksigninbutton();
	 
			tenent.Entertenentname("mobiletest");
			tenent.clickcotinuebutton();
			String oldurl = driver.getCurrentUrl();
			System.out.println(oldurl);
			String url1 = "https://dev.ezhour.com/account/login";
			String updaterul = oldurl.replace("mobiletest.", "");
			driver.get(updaterul);
			Thread.sleep(4000);

	        Timesheet_object login=new Timesheet_object(driver);

	        login.enterUserEmail("Madhankumar.m@rubixtek.com");

	        login.enterUserPassword("123qwe");

	        login.Loginbutton();

	        login.clicktimetracker();

	        login.clickTimesheetdetails();

	        login.clickdate();

	        login.clickmaymonth();

	        login.clicknextmonth();

	        login.clickpreviosmonth();  

	        login.clickhomebutton();

	        Thread.sleep(4000);

	        login.verifycurrentmonth();

	        String Actualtext = login.verifybillablehrstext();

		  assertEquals("Billable Project Hrs", Actualtext,"Text did not match");

		  login.Verifynonbillabletext();

		  login.Verifytimeoffholidaystext();

		  login.Verifytotalhrstext();

	    }

//	 

	 @Test

	 public void Verifytimesheetentrypage() throws InterruptedException, IOException {

		 Tenant_login_object tenent= new Tenant_login_object(driver);
			tenent.clicksigninbutton();
	 
			tenent.Entertenentname("mobiletest");
			tenent.clickcotinuebutton();
			String oldurl = driver.getCurrentUrl();
			System.out.println(oldurl);
			String url1 = "https://dev.ezhour.com/account/login";
			String updaterul = oldurl.replace("mobiletest.", "");
			driver.get(updaterul);
			Thread.sleep(4000);
		 
		 
	        Timesheet_object login=new Timesheet_object(driver);

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        login.enterUserEmail("yugapriya@rubixtek.com");

	        login.enterUserPassword("123qwe");

	        login.Loginbutton();

	        login.clicktimetracker();

	        login.clickTimesheetdetails();

	        Thread.sleep(4000);

	        login.click1stweek();

		      Thread.sleep(5000);

		    //  login.exitfromtimesheet();

		    //    Thread.sleep(5000);

		      login.Verifyselectprojecttext();

		      login.selectproject();

		      Thread.sleep(5000);

		   //   login.verifyselecttasktext();

		      login.selecttask();

		      Thread.sleep(2000);

		      login.firstdayhours();

		      login.seconddayhours();

		      login.thirddayhours();

		      login.fourthdayhours();

		      login.fifthdayhours();

		      login.Verifyhoursexceederrorpopup();

		      login.verifysubmitbutton();

		      login.seconddayhour();

		      login.cliksubmitbutton();

		      login.submitpopupmessage();

		      Taksescreenshot();

		      Thread.sleep(5000);


	 }

//	 

	 @Test

	 public void timesheetapprove() throws InterruptedException {

		 Tenant_login_object tenent= new Tenant_login_object(driver);
			tenent.clicksigninbutton();
	 
			tenent.Entertenentname("mobiletest");
			tenent.clickcotinuebutton();
			String oldurl = driver.getCurrentUrl();
			System.out.println(oldurl);
			String url1 = "https://dev.ezhour.com/account/login";
			String updaterul = oldurl.replace("mobiletest.", "");
			driver.get(updaterul);
			Thread.sleep(4000);
		 
		 
		 
	        Timesheet_object login = new Timesheet_object(driver);

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        login.enterUserEmail("meenakshi.b@rubixtek.com");

	        login.enterUserPassword("123qwe");

	        login.Loginbutton();

	        login.clicktimetracker();

	        login.clicktimesheetmyapproval();

	        login.timesheetrequestclick();

	        Thread.sleep(4000);

            login.verifyEachHourValue();

	        login.Verifytotalhours();

	       Thread.sleep(5000);

 
}

//

	@Test

	public void Verifytimesheetpage() throws InterruptedException {
		
		Tenant_login_object tenent= new Tenant_login_object(driver);
		tenent.clicksigninbutton();
 
		tenent.Entertenentname("mobiletest");
		tenent.clickcotinuebutton();
		String oldurl = driver.getCurrentUrl();
		System.out.println(oldurl);
		String url1 = "https://dev.ezhour.com/account/login";
		String updaterul = oldurl.replace("mobiletest.", "");
		driver.get(updaterul);
		Thread.sleep(4000);

        Timesheet_object login=new Timesheet_object(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		login.enterUserEmail("madhankumar.m@rubixtek.com");

		login.enterUserPassword("123qwe");

		login.Loginbutton();

		login.clicktimetracker();

		login.clickTimesheetdetails();

		Thread.sleep(3000);

		login.click1stweek();

		Thread.sleep(2000);

		login.clickaddtimesheetbutton();

		login.verifysecondtimessheetvisible();

		login.clickminustimesheetbutton();

		Thread.sleep(2000);

		login.verifysecondtimessheetnotvisible();

		Thread.sleep(5000);
 
	}

//	

	@Test

	public void VerifytimesheetEntryPage() throws InterruptedException {
		
		Tenant_login_object tenent= new Tenant_login_object(driver);
		tenent.clicksigninbutton();
 
		tenent.Entertenentname("mobiletest");
		tenent.clickcotinuebutton();
		String oldurl = driver.getCurrentUrl();
		System.out.println(oldurl);
		String url1 = "https://dev.ezhour.com/account/login";
		String updaterul = oldurl.replace("mobiletest.", "");
		driver.get(updaterul);
		Thread.sleep(4000);

        Timesheet_object login=new Timesheet_object(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		login.enterUserEmail("madhankumar.m@rubixtek.com");

		login.enterUserPassword("123qwe");

		login.Loginbutton();

		login.clicktimetracker();

		login.clickTimesheetdetails();

		login.clicknextmonth();

		Thread.sleep(4000);

       login.click1stweek();

       login.verifyweektext();

       login.verifypreviousweektext();

       login.verifynextweektext();

       Thread.sleep(2000);

       login.verifydraftbutton();

       login.verifysubmitbutton();

       login.clickcopyfromprevioustextbutton();

       Thread.sleep(2000);

       login.verifycopyfromprevioustexterrortext();

       login.verifybacktosummarybutton();  

       Thread.sleep(2000);

       login.clickhomebutton();

      // login.clickpopup();

       Thread.sleep(3000);

	}	

//	

	@Test

	public void verifysubmission_without_entries() throws InterruptedException {
		Tenant_login_object tenent= new Tenant_login_object(driver);
		tenent.clicksigninbutton();
 
		tenent.Entertenentname("mobiletest");
		tenent.clickcotinuebutton();
		String oldurl = driver.getCurrentUrl();
		System.out.println(oldurl);
		String url1 = "https://dev.ezhour.com/account/login";
		String updaterul = oldurl.replace("mobiletest.", "");
		driver.get(updaterul);
		Thread.sleep(4000);

        Timesheet_object login=new Timesheet_object(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		login.enterUserEmail("yugapriya@rubixtek.com");

		login.enterUserPassword("123qwe");

		login.Loginbutton();

		login.clicktimetracker();

		login.clickTimesheetdetails();

		login.clicknextmonth();

		 login.click1stweek();

		 login.Verifyselectprojecttext();

	      login.selectproject();

	      Thread.sleep(5000);

	      login.selecttask();

	      Thread.sleep(2000);

	      login.cliksubmitbutton();

	      login.clickpopup();

	      login.verifysubmitbutton();

	      Thread.sleep(4000);    

	}

//	

	@Test

	public void verifytimesheetcancellation() throws InterruptedException {
		Tenant_login_object tenent= new Tenant_login_object(driver);
		tenent.clicksigninbutton();
 
		tenent.Entertenentname("mobiletest");
		tenent.clickcotinuebutton();
		String oldurl = driver.getCurrentUrl();
		System.out.println(oldurl);
		String url1 = "https://dev.ezhour.com/account/login";
		String updaterul = oldurl.replace("mobiletest.", "");
		driver.get(updaterul);
		Thread.sleep(4000);
        Timesheet_object login=new Timesheet_object(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		login.enterUserEmail("yugapriya@rubixtek.com");

		login.enterUserPassword("123qwe");

		login.Loginbutton();

		login.clicktimetracker();

		login.clickTimesheetdetails();

		login.click1stweek();

		login.clickcancelbutton();

		login.clickpopup();

		Thread.sleep(5000);

		login.verifycancelledtimesheet();

		Thread.sleep(5000);

	}


	@Test

	public void verifytimesheetleavedays() throws InterruptedException {
		Tenant_login_object tenent= new Tenant_login_object(driver);
		tenent.clicksigninbutton();
 
		tenent.Entertenentname("mobiletest");
		tenent.clickcotinuebutton();
		String oldurl = driver.getCurrentUrl();
		System.out.println(oldurl);
		String url1 = "https://dev.ezhour.com/account/login";
		String updaterul = oldurl.replace("mobiletest.", "");
		driver.get(updaterul);
		Thread.sleep(4000);

        Timesheet_object login=new Timesheet_object(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		login.enterUserEmail("yugapriya@rubixtek.com");

		login.enterUserPassword("123qwe");

		login.Loginbutton();

		login.clicktimetracker();

		login.clickTimesheetdetails();

		login.clickpreviosmonth();

		login.click1stweek();

		Thread.sleep(3000);

		login.clicknextweek();

		login.selectproject();

		login.selecttask();

		login.verifyleavedays();	

		login.verifyleavedayss();

		Thread.sleep(4000);

		login.verifyleavedaysgrandtotal_is_visible();

	}

	@Test

	public void verifytimesheetleavedays_for_PTO_Project() throws InterruptedException {
		Tenant_login_object tenent= new Tenant_login_object(driver);
		tenent.clicksigninbutton();
 
		tenent.Entertenentname("mobiletest");
		tenent.clickcotinuebutton();
		String oldurl = driver.getCurrentUrl();
		System.out.println(oldurl);
		String url1 = "https://dev.ezhour.com/account/login";
		String updaterul = oldurl.replace("mobiletest.", "");
		driver.get(updaterul);
		Thread.sleep(4000);

        Timesheet_object login=new Timesheet_object(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		login.enterUserEmail("yugapriya@rubixtek.com");

		login.enterUserPassword("123qwe");

		login.Loginbutton();

		login.clicktimetracker();

		login.clickTimesheetdetails();

		login.clickpreviosmonth();

		login.click1stweek();

		Thread.sleep(3000);

		login.clicknextweek();

		login.selectPTOProject();

		login.selecttask();

		login.verifyPTOleavedays();	

		Thread.sleep(2000);

		 login.seconddayhours();

		login.enterloghoursonleaveday();

		Thread.sleep(4000);

	}
 
@Test
	 public void timesheetapprovel() throws InterruptedException {
	Tenant_login_object tenent= new Tenant_login_object(driver);
	tenent.clicksigninbutton();

	tenent.Entertenentname("mobiletest");
	tenent.clickcotinuebutton();
	String oldurl = driver.getCurrentUrl();
	System.out.println(oldurl);
	String url1 = "https://dev.ezhour.com/account/login";
	String updaterul = oldurl.replace("mobiletest.", "");
	driver.get(updaterul);
	Thread.sleep(4000);
    Timesheet_object login=new Timesheet_object(driver);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        login.enterUserEmail("meenakshi.b@rubixtek.com");
	        login.enterUserPassword("123qwe");
	        login.Loginbutton();
	        login.clicktimetracker();
	        login.clicktimesheetmyapproval();
	        Thread.sleep(4000);
	       
}
 
	
	 @Test
	 public void timesheetapprovels() throws InterruptedException {
		 Tenant_login_object tenent= new Tenant_login_object(driver);
			tenent.clicksigninbutton();
	 
			tenent.Entertenentname("mobiletest");
			tenent.clickcotinuebutton();
			String oldurl = driver.getCurrentUrl();
			System.out.println(oldurl);
			String url1 = "https://dev.ezhour.com/account/login";
			String updaterul = oldurl.replace("mobiletest.", "");
			driver.get(updaterul);
			Thread.sleep(4000);
	        Timesheet_object login=new Timesheet_object(driver);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        login.enterUserEmail("meenakshi.b@rubixtek.com");
	        login.enterUserPassword("123qwe");
	        login.Loginbutton();
	        login.clicktimetracker();
	        login.clicktimesheetmyapproval();
	        login.timesheetrequestclick();
	        Thread.sleep(4000);
            login.verifyEachHourValue();
	        login.Verifytotalhours();
	        login.verifyapprovercancellation();
		    Thread.sleep(4000);
		    
	 }
	
	 @Test
		public void Verifytimesheetinvalidinput() throws InterruptedException {
		 Tenant_login_object tenent= new Tenant_login_object(driver);
			tenent.clicksigninbutton();
	 
			tenent.Entertenentname("mobiletest");
			tenent.clickcotinuebutton();
			String oldurl = driver.getCurrentUrl();
			System.out.println(oldurl);
			String url1 = "https://dev.ezhour.com/account/login";
			String updaterul = oldurl.replace("mobiletest.", "");
			driver.get(updaterul);
			Thread.sleep(4000);
	        Timesheet_object login=new Timesheet_object(driver);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        login.enterUserEmail("yugapriya@rubixtek.com");
	        login.enterUserPassword("123qwe");
	        login.Loginbutton();
	        login.clicktimetracker();
	        login.clickTimesheetdetails();
	        Thread.sleep(4000);
	        login.click1stweek();
		      Thread.sleep(5000);
		    //  login.exitfromtimesheet();
		    //    Thread.sleep(5000);
		      login.Verifyselectprojecttext();
		      login.selectproject();
		      Thread.sleep(2000);
		   //   login.verifyselecttasktext();
		      login.selecttask();
		      Thread.sleep(2000);
		      login.firstdayhours();
		      login.seconddayhoursinvalidinput();
		      login.Verifyinvalidformattext();
		      	
	       
 
}
	
	 @Test
		public void VerifytimesheetPTO() throws InterruptedException {
		 Tenant_login_object tenent= new Tenant_login_object(driver);
			tenent.clicksigninbutton();
	 
			tenent.Entertenentname("mobiletest");
			tenent.clickcotinuebutton();
			String oldurl = driver.getCurrentUrl();
			System.out.println(oldurl);
			String url1 = "https://dev.ezhour.com/account/login";
			String updaterul = oldurl.replace("mobiletest.", "");
			driver.get(updaterul);
			Thread.sleep(4000);
	        Timesheet_object login=new Timesheet_object(driver);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        login.enterUserEmail("yugapriya@rubixtek.com");
	        login.enterUserPassword("123qwe");
	        login.Loginbutton();
	        login.clicktimetracker();
	        login.clickTimesheetdetails();
	        Thread.sleep(4000);
	        login.clickdate();
	        login.clickdecembermonth();
	        login.decemberweek();
	        login.selectproject();
		      Thread.sleep(2000);
		   //   login.verifyselecttasktext();
		      login.selecttask();
		      Thread.sleep(2000);
		      login.firstdayhours();
		      login.seconddayhours();
		      login.thirddayhours();
		     
		      try {
		    	  login.fourthdayhours();
		    	} catch ( InvalidElementStateException e) {
		    	    System.out.println("Can't Enterthe Log hours : " + e.getMessage());
		    	}
		      Thread.sleep(2000);
		      login.seconddayhour();
		      Thread.sleep(5000);
		      login.holidattotalhours();
		      login.cliksubmitbutton();
		      login.submitpopupmessage();
		      Thread.sleep(4000);
}
	
 
	 @Test
	 public void timesheetapprovel_Holidaylogs() throws InterruptedException {
		 Tenant_login_object tenent= new Tenant_login_object(driver);
			tenent.clicksigninbutton();
	 
			tenent.Entertenentname("mobiletest");
			tenent.clickcotinuebutton();
			String oldurl = driver.getCurrentUrl();
			System.out.println(oldurl);
			String url1 = "https://dev.ezhour.com/account/login";
			String updaterul = oldurl.replace("mobiletest.", "");
			driver.get(updaterul);
			Thread.sleep(4000);
	        Timesheet_object login=new Timesheet_object(driver);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        login.enterUserEmail("yugapriya@rubixtek.com");
	        login.enterUserPassword("123qwe");
	        login.Loginbutton();
	        login.clicktimetracker();
	        login.clicktimesheetmyapproval();
	        Thread.sleep(3000);
	        login.verifyholidayweekapproverside();
	        Thread.sleep(3000);
	        login.verifyholdayisdisabled();
	        Thread.sleep(4000);
	        
	        
	 }
	
	 @Test
	 public void timesheet_copy_from_previoustext_errormessage() throws InterruptedException {
		 Tenant_login_object tenent= new Tenant_login_object(driver);
			tenent.clicksigninbutton();
	 
			tenent.Entertenentname("mobiletest");
			tenent.clickcotinuebutton();
			String oldurl = driver.getCurrentUrl();
			System.out.println(oldurl);
			String url1 = "https://dev.ezhour.com/account/login";
			String updaterul = oldurl.replace("mobiletest.", "");
			driver.get(updaterul);
			Thread.sleep(4000);
	        Timesheet_object login=new Timesheet_object(driver);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        login.enterUserEmail("meenakshi.b@rubixtek.com");
	        login.enterUserPassword("123qwe");
	        login.Loginbutton();
	        login.clicktimetracker();
	        login.clickTimesheetdetails();
	        Thread.sleep(3000);
	        login.clickfourthweek();
	        Thread.sleep(3000);
	   //     login.verifycopyfromprevioustexterrortext();
	        login.clickcopyfromprevioustextbutton();
	        login.verifycopyfromprevioustexterrortext();
	        Thread.sleep(3000);
	         
	               
	        
}
	
	 @Test
	 public void timesheet_copy_from_previoustext() throws InterruptedException {
		 Tenant_login_object tenent= new Tenant_login_object(driver);
			tenent.clicksigninbutton();
	 
			tenent.Entertenentname("mobiletest");
			tenent.clickcotinuebutton();
			String oldurl = driver.getCurrentUrl();
			System.out.println(oldurl);
			String url1 = "https://dev.ezhour.com/account/login";
			String updaterul = oldurl.replace("mobiletest.", "");
			driver.get(updaterul);
			Thread.sleep(4000);
	        Timesheet_object login=new Timesheet_object(driver);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        login.enterUserEmail("meenakshi.b@rubixtek.com");
	        login.enterUserPassword("123qwe");
	        login.Loginbutton();
	        login.clicktimetracker();
	        login.clickTimesheetdetails();
	        Thread.sleep(3000);
	        login.clickfourthweek();
	        Thread.sleep(3000);
	        login.clickcopyfromprevioustextbutton();
	        login.verifycopyfromprevioustexterrortext();
	        Thread.sleep(3000);
	        
	        
	 }
	
	 @Test
	 public void verify_timesheet_Resetbutton() throws InterruptedException {
		 Tenant_login_object tenent= new Tenant_login_object(driver);
			tenent.clicksigninbutton();
	 
			tenent.Entertenentname("mobiletest");
			tenent.clickcotinuebutton();
			String oldurl = driver.getCurrentUrl();
			System.out.println(oldurl);
			String url1 = "https://dev.ezhour.com/account/login";
			String updaterul = oldurl.replace("mobiletest.", "");
			driver.get(updaterul);
			Thread.sleep(4000);
	        Timesheet_object login=new Timesheet_object(driver);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        login.enterUserEmail("yugapriya@rubixtek.com");
	        login.enterUserPassword("123qwe");
	        login.Loginbutton();
	        login.clicktimetracker();
	        login.clickTimesheetdetails();
	        Thread.sleep(3000);
	        login.clickfourthweek();
	        Thread.sleep(3000);
	        login.verifyresetbutton();
	        login.clickcopyfromprevioustextbutton();
	        Thread.sleep(2000);
	        login.verifysubmitbuttonisenabled();
	        login.clickresetbutton();
	        login.verifysubmitbutton();
	        Thread.sleep(3000);
	        
	 }
	
	
	
	 @Test
	 public void verify_grandtotal_twotimesheet() throws InterruptedException {
		 
	        Timesheet_object login=new Timesheet_object(driver);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        login.enterUserEmail("yugapriya@rubixtek.com");
	        login.enterUserPassword("123qwe");
	        login.Loginbutton();
	        login.clicktimetracker();
	        login.clickTimesheetdetails();
	        Thread.sleep(3000);
	        login.clickfourthweek();
	        Thread.sleep(3000);
	        login.clickcopyfromprevioustextbutton();
	        Thread.sleep(2000);
	        login.grandtotalhours();
	        login.clickaddtimesheetbutton();
	        Thread.sleep(2000);        
	        login.selectezhour();
	        Thread.sleep(2000);
	        login.selecttask_Second();
	        login.second_timesheet_day1();
	        login.second_timesheet_day2();
	        login.second_timesheet_day3();
	   //     login.second_timesheet_day4();
	        login.grandtotalhours();
	        login.clickminustimesheetbutton();
	        login.grandtotalhours();
	        Thread.sleep(3000);
	        
	 }
	
}
 