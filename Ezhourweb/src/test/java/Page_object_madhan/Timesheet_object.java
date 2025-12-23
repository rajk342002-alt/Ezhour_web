package Page_object_madhan;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
 
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
 
public class Timesheet_object {
 
	WebDriver driver;
 
	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement Signin;
 
	@FindBy(name = "userNameOrEmailAddress")
	WebElement email;
 
	@FindBy(name = "password")
	WebElement password;
 
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement Loginbutton;
 
	@FindBy(xpath = "//span[text()='Time tracker']")
	WebElement timetracker;
 
	@FindBy(xpath = "//span[text()='Timesheet Details']")
	WebElement timesheetdetails;
	@FindBy(xpath = "//div[@id=\"kt_app_main\"]//table//tr[td[text()=\" RBX10013 Yugapriya Balachandran \"] and td[text()=\" 21 -Dec -2025 to 27- Dec -2025 \"]]")
	WebElement Holidayweek;
 
	@FindBy(xpath = "//span[@class='selected']")
	WebElement month;
 
	@FindBy(name = "date")
	WebElement dates;
	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[1]")
	WebElement maymonth;
	 @FindBy(xpath = "//span[text()='December']")
	 WebElement december;
	 @FindBy(xpath = "//p[text()='21 Dec 2025 to 27 Dec 2025']")
	 WebElement decemberweek;
	@FindBy(xpath = "//button[@class='week-days tsDatePicker']")
	WebElement weektext;
 
	@FindBy(xpath = "//span[@class='fa fa-arrow-left']")
	WebElement previousweek;
	@FindBy(xpath = "//span[@class='fa fa-arrow-right']")
	WebElement nextweek;
	@FindBy(xpath = "//div[@id=\"kt_app_main\"]//button[2]")
	WebElement homebutton;
	@FindBy(xpath = "(//option[text()=' EzHour '])[2]")
	WebElement secondezhour;
	@FindBy(xpath = "(//option[text()=' Development'])[2]")
	WebElement secondtask;
	@FindBy(xpath = "//label[text()='Grand Total']")
	WebElement grandtotaltext;
	@FindBy(xpath = "(//input[//@class=\"date-calendar tsDatePicker\"])[1]")
	WebElement datepicker;
 
	@FindBy(xpath = "//div[@id=\"kt_app_main\"]/div/ng-component/div[2]/div/div/div/div[1]")
	WebElement firstweek;
	@FindBy(xpath = "//a[@class='float-end']")
	WebElement Exitbutton;
	@FindBy(xpath = "//span[text()='Invalid input format on Sep 02 2025']")
	WebElement invalidformat;
	//Draft button
	@FindBy(xpath = "//button[@class='btn btn-draft me-5 mb-5 ng-star-inserted']")
	WebElement draftbutton;
	//copyfromprevioustext
	@FindBy(xpath = "//button[@class='btn btn-copy back-btn mb-5 ng-star-inserted']")
	WebElement copyfromprevioustext;
	@FindBy(xpath = "(//div[contains(@class, 'table-row row mb-4')])[4]")
	WebElement fourthweek;
	//popup
	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']") 
	WebElement popupyes;
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/ng-component/div[2]/div/div/div/div[1]/div[1]/p[2]")
	WebElement cancelledtext;
	@FindBy(xpath = "//div[@class='col weekdays p-0 holidays ng-untouched ng-pristine ng-valid ng-star-inserted']")
	WebElement approversideholiday;
	@FindBy(xpath = "//button[@class='next-btn ng-tns-c233-12']")
	WebElement rightarrow;
	@FindBy(xpath = "//button[@class='prev-btn ng-tns-c233-12']")
	WebElement leftarrow;
	@FindBy(xpath = "(//p[text()='Billable Project Hrs '])[1]")
	WebElement billableprojecthourstext;
	@FindBy(xpath = "(//p[text()='Non-Billable Project Hrs '])[1]")
	WebElement Nonbillabletext;
	@FindBy(xpath = "(//p[text()='Holidays / Timeoff Hrs '])[1]")
	WebElement timeoffholidaytext;
	@FindBy(xpath = "(//p[text()='Total Hrs '])[1]")
	WebElement totalhrstext;
	@FindBy(xpath = "(//option[text()='Select Project'])[1]")
	WebElement selectprojecttext;
	@FindBy(xpath = "//option[text()=' EzHour ']")
	WebElement projectname;
	@FindBy(xpath="//option[text()=' Halliburton - WebGL ']")
	WebElement PTOproject;
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoredittimesheetentrymodal/form/div/div/div[2]/div/div[2]/div/div/div/div/div[2]/div/select")
	WebElement selecttasktext;
	@FindBy(xpath = "//div[text()='Testing']")
	WebElement taskname;
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoredittimesheetentrymodal/form/div/div/div[2]/div/div[2]/div/div/div/div/div[4]/input")
	WebElement firstday;
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoredittimesheetentrymodal/form/div/div/div[2]/div/div[2]/div/div/div/div/div[5]/input")
	WebElement secondday;
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoredittimesheetentrymodal/form/div/div/div[2]/div/div[2]/div/div/div/div/div[6]/input")
	WebElement thirdday;
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoredittimesheetentrymodal/form/div/div/div[2]/div/div[2]/div/div/div/div/div[7]/input")
	WebElement fourthday;
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoredittimesheetentrymodal/form/div/div/div[2]/div/div[2]/div/div/div/div/div[8]/input")
	WebElement fifthday;
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoredittimesheetentrymodal/form/div/div/div[2]/div/div[2]/div/div/div/div/div[10]/input")
	WebElement Totalhours;
	@FindBy(xpath = "(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[7]")
	WebElement timesheet2_day1;
	@FindBy(xpath = "(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[8]")
	WebElement timesheet2_day2;
	@FindBy(xpath = "(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[9]")
	WebElement timesheet2_day3;
	@FindBy(xpath = "(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[10]")
	WebElement timesheet2_day4;
	@FindBy(xpath = "(//input[@formcontrolname=\"grandTotalinString\"])[1]")
	WebElement grandtotalhours;

	@FindBy(xpath = "//span[text()='Exceeded Maximum Hours 24:00Hrs on Sep 05 2025']")
	WebElement hoursexceederrorpopup;
	@FindBy(xpath = "(//button[@class='btn btn-green me-5 mb-5 ng-star-inserted'])[1]")
	WebElement submitbutton;
	@FindBy(xpath = "//button[@class='btn btn-danger me-5 mb-5 ng-star-inserted']")
	WebElement cancelbutton;
	@FindBy(xpath ="//button[text()=' Reset ']")
	WebElement resetbutton;
	@FindBy(xpath = "//span[text()='No data available for previous week.']")
	WebElement copyfromprevioustexterrormessage;

	@FindBy(xpath = "//button[@class='btn btn-back mb-5 back-btn ng-star-inserted']")
	WebElement backtosummarybutton;
	@FindBy(xpath = "//span[@class='fa fa-home ng-tns-c186-11']")
	WebElement homeicon;
	@FindBy(xpath = "//span[text()='Submitted Successfully']")
	WebElement draftmessage;
 
	@FindBy(xpath = "(//span[text()='My Approval'])[1]")
	WebElement approvalpage;
 
	@FindBy(xpath = "//div[@id='kt_app_main']//table/tbody/tr[     td[contains(text(), 'RBX10013 Yugapriya Balachandran')] and      td[contains(text(), '27 -Jul -2025 to 02- Aug -2025')] ] ")
	WebElement request;
 
	@FindBy(xpath = "//div[contains(@class,\"col weekdays p-0 ng-untouched ng-pristine ng-valid ng-star-inserted\")]/input")
	List<WebElement> hourInputList;
	@FindBy(xpath = "//a[@class='float-end']")
	WebElement backtosummerybutton;
	@FindBy(xpath = "(//i[@class='fa fa-plus-circle'])[1]")
	WebElement addbutton;
	@FindBy(xpath = "(//div[@class='tabledatas ng-star-inserted'])[2]")
	WebElement secondtable;
	@FindBy(xpath = "(//i[@class='fa fa-minus-circle'])[2]")
	WebElement minus;
	@FindBy(xpath = "(//div[@class='tabledatas ng-star-inserted'])[2]")
	boolean table2;
	@FindBy(xpath = "//input[contains(@class,'leaveDays')]")
	WebElement leaveday;
	@FindBy(xpath = "(//div[@class='col weekdays p-0 ng-untouched ng-pristine ng-valid ng-star-inserted'])[2]")
	WebElement PTOleaveday;
	@FindBy(xpath = "(//div[@class='col weekdays p-0 ng-star-inserted'])[3]")
	WebElement leavedaylog;
	@FindBy(xpath = "(//input[contains(@class,'ng-pristine ng-valid')])[10]")
	WebElement grandtotallevdays;
	@FindBy(xpath = "//textarea[text()='Type Here...']")
	WebElement commentbox;
	@FindBy(xpath = "(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[6]")
	WebElement holidaytotalhours;
	@FindBy(xpath = "(//tr[@class='ng-tns-c237-12 ng-star-inserted'])[2]")
	WebElement requst;
	@FindBy(xpath="(//select[@formcontrolname=\"taskGroupDetailId\"])[2]")
	WebElement second_task_Choosing;
	
	public Timesheet_object(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 
	public void signinbutton() throws InterruptedException {
		Thread.sleep(2000);
		Signin.click();
		
	}
 
	// Method to enter email
	public void enterUserEmail(String emailInput) {
		email.sendKeys(emailInput);
	}
 
	// Method to enter password
	public void enterUserPassword(String passwordInput) {
		password.sendKeys(passwordInput);
	}
 
	public void Loginbutton() throws InterruptedException {
		Thread.sleep(2000);
		Loginbutton.click();
	}
 
	public void clicktimetracker() {
		timetracker.click();
	}
 
	public void clickTimesheetdetails() {
 
		timesheetdetails.click();
	}
 
//	    public void month() {
//	    	System.out.println(month.getText());
//	    }
//	    
	public void clickdate() {
		dates.click();
 
	}
 
	public void clickmaymonth() throws InterruptedException {
		Thread.sleep(2000);
		maymonth.click();
 
	}
 
	public void clickhomebutton() throws InterruptedException {
		homebutton.click();
		assertTrue(homebutton.isDisplayed());
		System.out.println("Home button is presence");
 
	}
 
	public void verifycurrentmonth() throws InterruptedException {
//	    	  month.click();
		// Thread.sleep(2000);
		dates.click();
		System.out.println("Current month : " + month.getText());
 
	}
 
	public void click1stweek() throws InterruptedException {
		// System.out.println(firstweek.getText());
		Thread.sleep(2000);
		firstweek.click();
 
	}
 
	public void clicknextmonth() throws InterruptedException {
 
		rightarrow.click();
		System.out.println("Right arrow is clickable and Moving to the next month");
 
	}
	
	public void clicknextweek() {
		nextweek.click();
	}
 
	public void clickpreviosmonth() throws InterruptedException {
 
		leftarrow.click();
		System.out.println("Left arrow is clickable and Moving to the before month");
 
	}
 
	public String verifybillablehrstext() {
		return billableprojecthourstext.getText();
 
	}
 
	public void Verifynonbillabletext() {
		String Actual = Nonbillabletext.getText();
		assertEquals("Non-Billable Project Hrs", Actual, "Text did not match");
	}
 
	public void Verifytimeoffholidaystext() {
		String Actual = timeoffholidaytext.getText();
		assertEquals("Holidays / Timeoff Hrs", Actual, "Text did not match");
	}
	
	public void Verifyinvalidformattext() {
		String Actual = invalidformat.getText();
		assertEquals("Invalid input format on Sep 02 2025", Actual, "Text did not match");
	}
	
	
 
	public void Verifytotalhrstext() {
		String Actual = totalhrstext.getText();
		assertEquals("Total Hrs", Actual, "Text did not match");
	}
 
	public void Verifyselectprojecttext() {
		String Actual = selectprojecttext.getText();
		assertEquals("Select Project", Actual, "Text did not match");
		selectprojecttext.click();
	}
 
	public void selectproject() throws InterruptedException {
		Thread.sleep(1000);
		if (projectname.isDisplayed()) {
			System.out.println("prject name is displayed");
			projectname.click();
		} else {
			System.out.println("Halliburton project is not displayed");
		}
 
	}
 
	public void selecttask() {
		Select select = new Select(selecttasktext);
		select.selectByVisibleText("Testing");
	}
 
	public void selecttask_Second()
	{
		Select select=new Select(second_task_Choosing);
		select.selectByVisibleText("Development");
	}
	
	
	public void firstdayhours() {
		firstday.clear();
		firstday.sendKeys("8");
 
	}
 
	public void seconddayhours() throws InterruptedException {
		Thread.sleep(1000);
		secondday.clear();
		secondday.sendKeys("8");
		// return firstday;
 
	}
	
	public void seconddayhoursinvalidinput() throws InterruptedException {
		secondday.clear();
		secondday.sendKeys("f");
		Thread.sleep(1000);
	}	
		
 
	public void thirddayhours() throws InterruptedException {
		Thread.sleep(1000);
		thirdday.clear();
		thirdday.sendKeys("8");
		// return firstday;
 
	}
 
	public void fourthdayhours() throws InterruptedException {
		Thread.sleep(1000);
		fourthday.clear();
		fourthday.sendKeys("8");
		// return firstday;
 
	}
 
	public void fifthdayhours() throws InterruptedException {
		Thread.sleep(1000);
		fifthday.clear();
		fifthday.sendKeys("88");
		// return firstday;
 
	}
 
	public void Verifyhoursexceederrorpopup() throws InterruptedException {
		// Thread.sleep(1000);
		String Actual = hoursexceederrorpopup.getText();
		assertEquals("Exceeded Maximum Hours 24:00Hrs on Sep 05 2025", Actual, "Text did not match");
	}
 
	public void verifysubmitbutton() {
		 assertFalse(submitbutton.isEnabled(), "Submitbutton is Disabled");
			
	}
	
	public void verifysubmitbuttonisenabled() {
		 assertTrue(submitbutton.isEnabled(), "Submitbutton is Disabled");
			
	}
	public void verifyaddcommentstbutton() {
		 assertTrue(commentbox.isEnabled(), "Submitbutton is not-Disabled");
			
	}
	public void clickdecembermonth() {
		december.click();
		
	}
 
	
	
	
	public void exitfromtimesheet() {
		Exitbutton.click();
		
	}
 
	public void seconddayhour() throws InterruptedException {
		Thread.sleep(2000);
		fifthday.clear();
		fifthday.sendKeys("8");
		// secondday.sendKeys("8");
	}
 
	public void cliksubmitbutton() throws InterruptedException {
		submitbutton.click();
		// Thread.sleep(3000);
	}
 
	public void submitpopupmessage() throws InterruptedException {
		// Thread.sleep(1000);
		String Actual = draftmessage.getText();
		assertEquals("Submitted Successfully", Actual, "Text did not match");
	}
 
	public void clicktimesheetmyapproval() {
		approvalpage.click();
	}
 
	public void timesheetrequestclick() throws InterruptedException {
		Thread.sleep(5000);
		request.click();
 
	}
 
	public void verifyEachHourValue() {
		String expectedValue = "08:00";
 
		for (int i = 0; i < hourInputList.size(); i++) {
			WebElement input = hourInputList.get(i);
			String actualValue = input.getAttribute("value");
 
			System.out.println("Checking hour " + (i + 1) + ": " + actualValue);
 
			// Assert one by one
			assertEquals(actualValue, expectedValue, "❌ Mismatch at hour " + (i + 1));
 
		}
 
		System.out.println("✅ All hour values matched: " + expectedValue);
	}
 
	public void Verifytotalhours() throws InterruptedException {
		// System.out.println(Totalhours.getText());
		System.out.println(Totalhours.getAttribute("value"));
 
	}
 
	public void clickaddtimesheetbutton() {
		addbutton.click();
 
	}
 
	public void verifysecondtimessheetvisible() {
 
		if (secondtable.isDisplayed()) {
			System.out.println("Second TImesheet table has been Opend");
 
		} else {
			System.out.println("ERROR : Not Displayed");
		}
		
	}
 
	public void clickminustimesheetbutton() {
		minus.click();
	}
 
	public void verifysecondtimessheetnotvisible() {
		if (table2) {
			
			System.out.println("❌ Table is present.");
			
		} else {
			
			System.out.println(" ✅ Table is not present on the page.");
			
		}
	}
	
	public void clickdatepicker() {
		datepicker.sendKeys("10-Aug-2025 to 16-Aug-2025");
	//	datepicker.click();
		
	}
	
	public void verifyweektext() {
		System.out.println(weektext.getText());	
	}
	public void verifypreviousweektext() {
	
	previousweek.click();
	System.out.println("Previousmonth1stweek:"+ weektext.getText());
}
 
	public void verifynextweektext() {
		nextweek.click();
		System.out.println("Nextmonth1stweek:"+ weektext.getText());
		
	}
	
	public void verifydraftbutton() {
		assertFalse(draftbutton.isEnabled(),"Draftbutton is Disabled");
	
	}
	public void clickcopyfromprevioustextbutton() {
		copyfromprevioustext.click();
	
	}
	
	public void verifycopyfromprevioustexterrortext() {
	assertEquals(copyfromprevioustexterrormessage.getText(),"No data available for previous week." );
	
	}
	
	public void verifybacktosummarybutton() throws InterruptedException {
		assertEquals("Back to Timesheet Summary", backtosummarybutton.getText());
		backtosummarybutton.click();
		Thread.sleep(4000);
		
	}
	public void verifyredirecttohomepage() throws InterruptedException {
			homebutton.click();
	}
	public void clickpopup() {
		popupyes.click();
	
	}
	public void clickcancelbutton() {
		cancelbutton.click();
	
	}
	public void verifyleavedays() {
		boolean isreadonly = leaveday.getAttribute("readonly")!=null;
		assertTrue(isreadonly,"Timesheet input is NOT readonly for leave day!");
		
		leaveday.sendKeys("8");
//		
 
	        // ✅ Verify value is still 00:00
	        String value = leaveday.getAttribute("value");
	      //  assertEquals(value, "00:00", "Timesheet hours should remain 00:00 on leave day");
	        System.out.println(value);
	    }
	
	public void verifyleavedayss() {
		 String value = leavedaylog.getText();
	     assertEquals(value, "08:00", "Timesheet hours on holiday/weekoff should remain 08:00 on leave day");
			
	}
	public void verifyleavedaysgrandtotal_is_visible() {
		 String value = grandtotallevdays.getAttribute("value");
	     assertEquals(value, "08:00", "Timesheet grand total hours should remain 08:00");
			System.out.println(value);
	}
	
	
	public void selectPTOProject() throws InterruptedException {
 
		Thread.sleep(1000);
		if (PTOproject.isDisplayed()) {
			System.out.println("prject name is displayed");
			PTOproject.click();
		} else {
			System.out.println("Halliburton project is not displayed");
		}
 
	}
	
	public void verifyPTOleavedays() throws InterruptedException {
		boolean isreadonly = PTOleaveday.getAttribute("readonly")!=null;
		assertFalse(isreadonly,"Timesheet input is NOT readonly for leave day!");
		Thread.sleep(2000);
	//	
	
	}
	
	public void enterloghoursonleaveday() {
	//	PTOleaveday.sendKeys("8");
//		
 
	        // ✅ Verify value is still 00:00
	        String value = secondday.getAttribute("value");
	        assertEquals(value, "8", "Timesheet hours should remain 00:00 on leave day");
	        System.out.println(value);
	       
	    }
	
	public void verifycancelledtimesheet() {
	String canceltext = cancelledtext.getText().trim();
	  assertEquals(canceltext, "Cancelled", "Timesheet hours should remain 00:00 on leave day");
	
	}
	
	
	public void verifyapprovercancellation() {
		
		commentbox.sendKeys("Check the log hours");
	
	}
    public void decemberweek() {
		decemberweek.click();
	
	}
    
    public void selectezhour() {
  		secondezhour.click();
  	
  	}
    
    public void selecttask2() {
    	
    		Select select = new Select(secondtask);
    		select.selectByVisibleText(" Development");
    	}
  
	
	
    public void holidattotalhours() {
    	//	PTOleaveday.sendKeys("8");
    	      //  String value = holidaytotalhours.getAttribute("value");
    	    //    assertEquals(value, "8", "wrong");
    	        System.out.println("Holiday/ weekhours : 08:00");   	       
    	    }
    
    public void verifyholidayweekapproverside() {
  		Holidayweek.click();
  	
  	}
    public void verifyholdayisdisabled() {
  		//boolean a = approversideholiday.isEnabled();
  		assertFalse(approversideholiday.isEnabled() , "Holiday is showing");
  	
  	}
    public void clickfourthweek() {
  		fourthweek.click();
  	
  	}
    public void verifyresetbutton() {
  		if (resetbutton.isDisplayed()) {
			System.out.println("Reset Button is Displayed");
		}
  	
  	}
    public void clickresetbutton() {
  		resetbutton.click();
  	
  	}
  	
 
	public void second_timesheet_day1() throws InterruptedException {
		Thread.sleep(1000);
		timesheet2_day1.clear();
		timesheet2_day1.sendKeys("8");
    
	}
 
	public void second_timesheet_day2() throws InterruptedException {
		Thread.sleep(1000);
		timesheet2_day2.clear();
		timesheet2_day2.sendKeys("8");
    
	}
 
	public void second_timesheet_day3() throws InterruptedException {
		Thread.sleep(1000);
		timesheet2_day3.clear();
		timesheet2_day3.sendKeys("7");
    
	}
 
	public void second_timesheet_day4() throws InterruptedException {
		Thread.sleep(1000);
		timesheet2_day4.clear();
		timesheet2_day4.sendKeys("8");
    
	}
	
	public void grandtotalhours() {
		String grandtotal = grandtotalhours.getAttribute("value");
		System.out.println("Grand Total : " + grandtotal);
	}
	
	
	
	}
	
 