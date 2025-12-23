package page_object_rengaraj;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import comman_methods.comman_methods;

public class Apply_leave_object extends comman_methods {
	
public static	String username;
public	static String leavetype;
public	static String fromdate;
	

	
	@FindBy(xpath="//select[@name=\"leaveTypeId\"]")
	WebElement selectleavetype;
	
	@FindBy(id="fromDate")
	WebElement inputfromdate; //from month input field
	
	@FindBy(xpath="//*[@id=\"kt_body\"]/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[4]/span")
	WebElement fromnext; //from month next button
	
	
	
	@FindBy(id="toDate")
	WebElement inputtodate; //to date month input field
	
	@FindBy(xpath="//*[@id=\"kt_body\"]/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[4]")
	WebElement calendarnext; //to calender next button
	
	@FindBy(xpath="//*[@id=\"kt_body\"]/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr[1]/td[7]/span")
	WebElement selectedtodate; //to date click
	
	@FindBy(xpath="//*[@id=\"Leave_Reason\"]")
	WebElement leavereason;
	
	@FindBy(xpath="//button[@type=\"submit\"]//span[text()=\"Apply\"]")
	WebElement leave_apply_button;  // Apply button
	
	
	@FindBy(xpath="( //button[text()=\" Cancel \"])[1]")
	WebElement cancel_button;
	
	@FindBy(xpath = "//div[@id=\"swal2-html-container\"]")
	WebElement leave_apply_success_tostmessage;  //After leave applied success toast message
	
	
	@FindBy(xpath="//*[@id=\"swal2-html-container\"]/span")
	WebElement leave_apply_already_taken_date;
	
	@FindBy(xpath = "//div[@id=\"kt_app_main\"]//tr[1]/td[1]/span[2]/div/div[2]/span")
	WebElement last_applied_username;
	
	@FindBy(xpath="//div[@id=\"kt_app_main\"]//tr[1]/td[2]")
	WebElement last_applied_leavetype;
	
	@FindBy(xpath = "//div[@id=\"kt_app_main\"]//tr[1]/td[3]/span[2]")
	WebElement last_applied_fromdate;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/createoreditleave/div[1]/div/div/div/form/div[3]/div/label[1]/span")
	WebElement total_leaves;
	
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoreditleave/div[1]/div/div/div/form/div[2]/div/ul")
	WebElement lop_leave_details_box;
	
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoreditleave/div[1]/div/div/div/form/div[3]/div/label[2]/span")
	WebElement leave_type_name_inbox;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/createoreditleave/div[1]/div/div/div/form/div[3]/div/label[3]/span")
	WebElement currently_booked;
	
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoreditleave/div[1]/div/div/div/form/div[2]/div/ul/div/div[2]/p")
	WebElement total_day_inbox;
	
	@FindBy(xpath = "//*[@id=\"kt_body\"]/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[4]")
	WebElement next;
	
	
	@FindBy(xpath="//*[@id=\"kt_body\"]/div/div/div[6]/button[1]")
	WebElement weekend_choose_popup;
	
	@FindBy(xpath = "//*[@id=\"swal2-html-container\"]")
	WebElement holiday_popup;
	
	public Apply_leave_object(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void leavetype(String leavetype) throws InterruptedException
	{
	
	
		Select dropdown=new Select(selectleavetype);
		dropdown.selectByVisibleText(leavetype);;
		
	}
	
	public void From_date_click()
	{
		waitforElementVisible(inputfromdate);
		inputfromdate.click();
//		fromnext.click();
		
	}
	public void From_date_select(String Fromdate) throws InterruptedException
	{
		String dateValue = Fromdate;  // ithu dynamic-aa eduthukalaamS
	    String FromDateSelectXpath = "//span[@bsdatepickerdaydecorator='' and text()='" + dateValue + "']";
	    WebElement selectedfromdate = driver.findElement(By.xpath(FromDateSelectXpath));
	    waitforElementVisible(selectedfromdate);
	    selectedfromdate.click();
	}

	
	public void To_date_click()
	{	
		waitforElementVisible(inputtodate);
		inputtodate.click();
//		calendarnext.click();
	}
	
	
	public void To_date_select(String Todate)
	{
	
		
		String ToDateValue=Todate;
		String ToDateSelectXpath="//span[@bsdatepickerdaydecorator=''][text()='" + ToDateValue + "']";

		WebElement SelectToDate=driver.findElement(By.xpath(ToDateSelectXpath));
		waitForElementClickable(selectedtodate);
		SelectToDate.click();
	}
	
	public void reasonleave(String reason)
	{
		waitforElementVisible(leavereason);
		leavereason.sendKeys(reason);
	}
	
	public void Page_scroll() {
	
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void applybutton()
	{
	waitForElementClickable(leave_apply_button);
		leave_apply_button.click();
	}
	
	public void cancel_button()
	{
		waitforElementVisible(cancel_button);
		cancel_button.click();
	}
	
	public void leaveapply_success_tostmessage() throws InterruptedException
	
	{
		waitforElementVisible(leave_apply_success_tostmessage);
		String leave_apply_successmessage=leave_apply_success_tostmessage.getText().trim();
		System.out.println(leave_apply_successmessage);
		assertEquals(leave_apply_successmessage, "Submitted successfully.", "leave apply success message is not showing correctly");
	}
	
	public void leaveapply_already_taken_days() throws InterruptedException
	{
		waitforElementVisible(leave_apply_already_taken_date);
		String leave_apply_already_days=leave_apply_already_taken_date.getText().trim();
		System.out.println(leave_apply_already_days);
		assertEquals(leave_apply_already_days, "Leave already applied for the same date.");
	}

	
	public void lastrequest_gettext()
	{
		waitforElementVisible(last_applied_username);
 username=		last_applied_username.getText().trim();
System.out.println(username);
waitforElementVisible(last_applied_leavetype);
		 leavetype=last_applied_leavetype.getText().trim();
		System.out.println(leavetype);
		waitforElementVisible(last_applied_fromdate);
	 fromdate=	last_applied_fromdate.getText().trim();
	System.out.println(fromdate);
	}
	
	public void total_leave_display() {
	    Select dropdown = new Select(selectleavetype);
	    String selectedleavetype = dropdown.getFirstSelectedOption().getText().trim();
	    System.out.println("Selected Leave Type: " + selectedleavetype);
	    
	   
if(selectedleavetype.equalsIgnoreCase("Causal") || selectedleavetype.equalsIgnoreCase("Sick") || selectedleavetype.equalsIgnoreCase("OPH"))
{
	
    String type=leave_type_name_inbox.getText().trim(); //causal,sick,oph

	
	String currently_book=    currently_booked.getText().trim(); //currently booked: 1
    String[]	split_value=    currently_book.split(":");
    String book=split_value[1].trim();
    System.out.println(book);
 
 String total_leave=total_day_inbox.getText().trim(); // total leaves: 1
 String[] total_leave_box= total_leave.split(":");
 String total_leave_count=total_leave_box[1].trim();
 System.out.println("Total Days: "+total_leave_count+ " Currently Booked: " +total_leave_count);
 System.out.println(currently_book+ " "
 		+ "" +total_leave);
	
	
	

	    switch (selectedleavetype) {
	    
	        case "Causal":
	        String	  count_causal = total_leaves.getText().trim();
	  	 	    System.out.println("UI Count: " + count_causal);

	  	
	            assertEquals(count_causal, "Total Leave : 9", "Casual leave count mismatch");
	            assertEquals(type, "Casual Leave");
	            assertEquals(total_leave_count, book);
	            break;

	        case "Sick":
	        	
	        	String  count_sick = total_leaves.getText().trim();
	  	 	    System.out.println("UI Count: " + count_sick);

	            assertEquals(count_sick, "Total Leave : 3", "Sick leave count mismatch");
	            assertEquals(type, "Sick Leave");
	            assertEquals(total_leave_count, book);


	            break;

	        case "OPH":
	        	
	       String  count_oph= total_leaves.getText().trim();
	  	 	    System.out.println("UI Count: " + count_oph);

	        	
	            assertEquals(count_oph, "Total Leave : 1", "OPH leave count mismatch");
	            assertEquals(type, "OPH Leave");
	            assertEquals(total_leave_count, book);


	            break;

	        default:
	            System.out.println("Your selected option is not handled in switch: " + selectedleavetype);
	    }
}
	    else if(selectedleavetype.equalsIgnoreCase("LOP"))
	    {
	      
	        
	            assertTrue(lop_leave_details_box.isDisplayed(), "LOP should not display total leave");
	            
	            
	        	System.out.println("LOP is selected");
	            

	    }
}
	
	public void handleOptionalPopup() {
	    // Check if popup OK button is present
	    List<WebElement> popup = driver.findElements(By.xpath("//button[text()=\"Ok\"]"));
	    if (!popup.isEmpty()) {
	        popup.get(0).click();
	        System.out.println("Popup appeared → OK clicked");
	    } else {
	        System.out.println("Popup not appeared");
	    }
	}
		

public void New_apply_leave_page_checking() throws InterruptedException
{


	Select dropdown=new Select(selectleavetype);
	String option=dropdown.getFirstSelectedOption().getText();
	assertEquals(option, "Select Leave Type");
	assertFalse(driver.findElements(By.id("fromDate")).size() > 0 
            && driver.findElement(By.id("fromDate")).isDisplayed(),
            "From Date field is visible but should not be");

assertFalse(driver.findElements(By.id("toDate")).size() > 0 
            && driver.findElement(By.id("toDate")).isDisplayed(),
            "To Date field is visible but should not be");

}

public void Holiday_FromDate_leave_Apply(String month, String Fromdate) throws InterruptedException {

    String month_xpath = "//bs-datepicker-navigation-view//span[text()='" + month + "']";
    int count = 0;

    inputfromdate.click(); // click once before loop

    while(count < 12) {

        Thread.sleep(1000); // small wait
        
        List<WebElement> choose_month = driver.findElements(By.xpath(month_xpath));

        if (!choose_month.isEmpty() && choose_month.get(0).isDisplayed()) {

            String FromDateSelectXpath = "//span[@bsdatepickerdaydecorator='' and text()='" + Fromdate + "']";
            WebElement selectedfromdate = driver.findElement(By.xpath(FromDateSelectXpath));
            waitforElementVisible(selectedfromdate);
            selectedfromdate.click();

            System.out.println(" Month & Date selected: " + month + " " + Fromdate);
            break;
        }

        fromnext.click();
        count++;
        System.out.println("Next clicked: " + count);
    }

    if(count == 12) {
        System.out.println(" Month not found within 12 clicks: " + month);
    }
}



public void Holiday_ToDate_leave_Apply(String month, String Todate) throws InterruptedException {

    String month_xpath = "//bs-datepicker-navigation-view//span[text()='" + month + "']";
    int count = 0;

    inputtodate.click(); // click once before loop

    while(count < 12) {

        Thread.sleep(1000); // small wait
        
        List<WebElement> choose_month = driver.findElements(By.xpath(month_xpath));

        if (!choose_month.isEmpty() && choose_month.get(0).isDisplayed()) {

        	
            String ToDateSelectXpath = "//span[@bsdatepickerdaydecorator=''][text()='" + Todate + "']";
            Thread.sleep(2000);
            WebElement SelectToDate = driver.findElement(By.xpath(ToDateSelectXpath));
            waitForElementClickable(SelectToDate);
            SelectToDate.click();

            System.out.println(" Month & Date selected: " + month + " " + Todate);
            break;
        }

        calendarnext.click(); // next month
        count++;
        System.out.println("Next clicked: " + count);
    }

    if(count == 12) {
        System.out.println("❌ Month not found within 12 clicks: " + month);
       
    }
}

public void holiday_warning_popup()
{
	assertEquals(holiday_popup.getText().trim(), "Holiday dates selected");
	System.out.println(holiday_popup.getText().trim());
	
}

}


