package page_object_rengaraj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import comman_methods.comman_methods;

public class LeaveDetais_comparison_object extends comman_methods {
	
	WebDriver driver;
	  String UserName_Tracker, LeaveType_Tracker, LeavePeriod_Tracker, 
     LeaveTakenDays_Tracker, DateofRequest_Tracker, 
     RollNumber_Leavetracker, UserFirstName_Tracker, UserSecondName_Tracker;

 String EmployeeName_LeaveDetails, LeaveType_LeaveDetails, 
     LeaveTakenDate_LeaveDetails, Reason_LeaveDetails, 
     RollNumber_LeaveDetails, FirstName_LeaveDetails;
	
	

	@FindBy(xpath="//*[@id=\"pr_id_7-table\"]/tbody/tr[1]/td[1]")
	WebElement UserName_LeaveTracker;  //username leave tracker
	
	@FindBy(xpath="//*[@id=\"pr_id_7-table\"]/tbody/tr[1]/td[2]") 
	WebElement LeaveTypeName_LeaveTracker; //leavetype leave tracker
	
	@FindBy(xpath = "//*[@id=\"pr_id_7-table\"]/tbody/tr[1]/td[3]")
	WebElement LeavePeriod_LeaveTracker; //leaveperiod_leavetracker
	
	@FindBy(xpath="//*[@id=\"pr_id_7-table\"]/tbody/tr[1]/td[4]")
	WebElement LeaveTakenDays_LeaveTracker; //leavetakendays leavetracker
	
	@FindBy(xpath="//*[@id=\"pr_id_7-table\"]/tbody/tr[1]/td[5]")
	WebElement DateOfRequest_LeaveTracker; //date of request leavetracker page
	
	//---------------------------------------------------------------------------------------
	
	//my request page //
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]//span[1]")
	WebElement EmployeeName_LeaveDetailsPage;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/div[2]/div/div[1]/div/div/div[4]/div/span")
	WebElement LeaveType_LeaveDetailsPage;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/div[2]/div/div[1]/div/div/div[6]/div/span")
	WebElement LeaveTakenDate_LeaveDetailsPage;
	
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/ng-component/div/div[2]/div/div[1]/div/div/div[8]/div/span")
	WebElement LeaveReason_LeaveDetailspage;
	
	
	
	
	
	public LeaveDetais_comparison_object(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void leavetracker_gettext() throws InterruptedException
	{
		
		
		Thread.sleep(3000);
	         UserName_Tracker=	       UserName_LeaveTracker.getText().trim();         //Username leavetracker
	         LeaveType_Tracker=  LeaveTypeName_LeaveTracker.getText().trim();           //leavetype leavetracker
	         LeavePeriod_Tracker=     LeavePeriod_LeaveTracker.getText().trim();        //Leaveperiod leavetracker
	         LeaveTakenDays_Tracker=      LeaveTakenDays_LeaveTracker.getText().trim(); //leavetakendays leavetracker
	         DateofRequest_Tracker=  DateOfRequest_LeaveTracker.getText().trim();       //Dateofrequest leavetracker
	         System.out.println("UserName_Tracker          : " + UserName_Tracker);
	         System.out.println("LeaveType_Tracker         : " + LeaveType_Tracker);
	         System.out.println("LeavePeriod_Tracker       : " + LeavePeriod_Tracker);
	         System.out.println("LeaveTakenDays_Tracker    : " + LeaveTakenDays_Tracker);
	         System.out.println("DateofRequest_Tracker     : " + DateofRequest_Tracker);
	String[] split=UserName_Tracker.split(" ");
	
	       RollNumber_Leavetracker=split[0];
	       UserFirstName_Tracker=split[1];
	       UserSecondName_Tracker=split[2];
	System.out.println(RollNumber_Leavetracker);
	System.out.println(UserFirstName_Tracker);
	System.out.println(UserSecondName_Tracker);
	
	}
	
	public void navigate_leave_detailspage()
	{
	
		Actions action=new Actions(driver);
		action.moveToElement(DateOfRequest_LeaveTracker).click().build().perform();
	}
	
	public void leavedetails_gettext() throws InterruptedException
	{
		Thread.sleep(3000);
		      EmployeeName_LeaveDetails=  EmployeeName_LeaveDetailsPage.getText().trim();  
		      //employe name leave details page      
		      waitforElementVisible(LeaveType_LeaveDetailsPage);
		       LeaveType_LeaveDetails    =  LeaveType_LeaveDetailsPage.getText().trim();        //leavetype leave detais page
		       waitforElementVisible(LeaveTakenDate_LeaveDetailsPage);
		       LeaveTakenDate_LeaveDetails=LeaveTakenDate_LeaveDetailsPage.getText().trim(); 
		       //leavetakendate leave details 
		       waitforElementVisible(LeaveReason_LeaveDetailspage);
		       Reason_LeaveDetails=LeaveReason_LeaveDetailspage.getText().trim();               //Leavereason leave details page
		System.out.println(EmployeeName_LeaveDetails);
	
		String[] spit_2=EmployeeName_LeaveDetails.split(" ");
	System.out.println(spit_2.length);
		       RollNumber_LeaveDetails=spit_2[0];
		       FirstName_LeaveDetails =spit_2[1];
		       System.out.println(RollNumber_LeaveDetails);
		       System.out.println(FirstName_LeaveDetails);
	}
	
	public void verifyroll_number_leavetracker_leavedetails()
	{
		Assert.assertEquals( RollNumber_Leavetracker, RollNumber_LeaveDetails);
		System.out.println(RollNumber_Leavetracker +":"+RollNumber_LeaveDetails);
	}
	
	
	public void verifyleavetype_leavetracker_leavedetails()
	{ 
		Assert.assertEquals(LeaveType_Tracker, LeaveType_LeaveDetails);
		 System.out.println("leave type:"+LeaveTypeName_LeaveTracker+ " " +LeaveType_LeaveDetailsPage);
		
	}
	
	
}
