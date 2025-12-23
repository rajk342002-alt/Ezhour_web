package Permission_page_object;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import comman_methods.comman_methods;

public class permission_page_navigating_object extends comman_methods {
 WebDriver driver;
 
 
	
	
	
	public permission_page_navigating_object(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath = "//span[text()=\"Attendance\"]")
	WebElement attendance_button;
	
	@FindBy(xpath="//span[text()=\"My request\"]")
	WebElement my_request;
	
	@FindBy(xpath="//span[text()=\"Permission\"]")
	WebElement permission;
	
	@FindBy(xpath="//button[@id=\"btn_create_permissionRequest\"]")
	WebElement apply_permission_button;
	
	@FindBy(xpath="//*[@id=\"PermissionRequest_PermissionType\"]")
	WebElement permission_type;
	
	@FindBy(xpath="//select/option[text()=\"Permission\"]")
	WebElement permission_option;
	
	@FindBy(xpath="//input[@id=\"PermissionRequest_PermissionOn\"]")
	WebElement Permission_date;
	
	@FindBy (xpath="//*[@id=\"PermissionRequest_FromTime\"]")
	WebElement from_time;
	
	@FindBy (xpath="//*[@id=\"PermissionRequest_ToTime\"]")
	WebElement To_time;
	
	@FindBy(xpath="//*[@id=\"PermissionRequest_Reason\"]")
	WebElement Reason;
	
	@FindBy(xpath="//button/span[text()=\"Apply\"]")
	WebElement Apply;
	
	@FindBy(xpath="//*[@id=\"swal2-html-container\"]")
	WebElement same_time_warning_message;
	
	@FindBy(xpath="//*[@id=\"kt_body\"]/div/div/div[6]/button[1]")
	WebElement warning_ok;
	
	@FindBy(xpath = "//div[@id=\"kt_app_main\"]//tbody/tr[1]/td[6]")
	WebElement click_first_request;
	
	@FindBy(xpath = "//button[text()=\"Cancel Permission\"]")
	WebElement cancel_permission_button;
	
	@FindBy(xpath = "//*[@id=\"kt_body\"]/div/div/div[6]/button[1]")
	WebElement cancel_yes_button;
	
	@FindBy(xpath = "//*[@id=\"swal2-html-container\"]/span")
	WebElement cancellation_success_message;
	
	
	public void click_attendance()
	{
		attendance_button.click();
	}
	
	public void click_my_request()
	{
		my_request.click();
		
	}
	
	public void click_permission()
	{
		permission.click();
	}
	
	public void click_permission_apply_button()
	{
		apply_permission_button.click();
	}
	
	public void click_permission_type() throws InterruptedException
	{
		
		 WebElement dropdown = driver.findElement(By.id("PermissionRequest_PermissionType"));
		    JavascriptExecutor js = (JavascriptExecutor) driver;


		    // Step 2: Set dropdown value (Angular specific)
		    js.executeScript(
		        "const select = arguments[0];" +
		        "for (let i = 0; i < select.options.length; i++) {" +
		        "  if (select.options[i].text.trim() === 'Permission') {" +
		        "    select.selectedIndex = i;" +
		        "    select.dispatchEvent(new Event('input', { bubbles: true }));" +
		        "    select.dispatchEvent(new Event('change', { bubbles: true }));" +
		        "    select.dispatchEvent(new Event('blur', { bubbles: true }));" +
		        "    break;" +
		        "  }" +
		        "}", dropdown);

		    // Step 3: Wait for next section (From Time) to appear
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//label[contains(text(),'From Time')]")));

		    System.out.println("✅ Angular dropdown 'Permission' selected and section loaded!");
		
	}
	
	public void click_workfromhome_type() throws InterruptedException
	{
		
		 WebElement dropdown = driver.findElement(By.id("PermissionRequest_PermissionType"));
		    JavascriptExecutor js = (JavascriptExecutor) driver;


		    // Step 2: Set dropdown value (Angular specific)
		    js.executeScript(
		        "const select = arguments[0];" +
		        "for (let i = 0; i < select.options.length; i++) {" +
		        "  if (select.options[i].text.trim() === 'Work From Home') {" +
		        "    select.selectedIndex = i;" +
		        "    select.dispatchEvent(new Event('input', { bubbles: true }));" +
		        "    select.dispatchEvent(new Event('change', { bubbles: true }));" +
		        "    select.dispatchEvent(new Event('blur', { bubbles: true }));" +
		        "    break;" +
		        "  }" +
		        "}", dropdown);

		    // Step 3: Wait for next section (From Time) to appear
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//label[contains(text(),'From Time')]")));

		    System.out.println("✅ Angular dropdown 'Permission' selected and section loaded!");
		
	}

	
	public void Choosing_permission_date()
	{
		
		Permission_date.click();
//		fromnext.click();
		
	}
	public void Date_select(String Fromdate) throws InterruptedException
	{
		String dateValue = Fromdate;  // ithu dynamic-aa eduthukalaamS
	    String FromDateSelectXpath = "//span[@bsdatepickerdaydecorator='' and text()='" + dateValue + "']";
	    WebElement selectedfromdate = driver.findElement(By.xpath(FromDateSelectXpath));
	    selectedfromdate.click();
	}
	
	public void from_time_permission(String from_timing)
	{
		from_time.sendKeys(from_timing);
	}
	
	public void To_time_permission(String to_timing)
	{
		To_time.sendKeys(to_timing);
	}
	
	public void scroll_reason()
	{
		scroll(Reason);
	}
	
	
	public void Reason()
	{
		Reason.sendKeys("Personal reason");
	}
	
	public void click_reason_box()
	{
		Reason.click();
	}
	
	public void apply_button()
	{
		Apply.click();
	}
	
	public void same_time_same_date_warning_message() throws InterruptedException
	{
		assertEquals(same_time_warning_message.getText().trim(), "Sorry, you cannot apply permissions to previously applied timings.");
		Thread.sleep(2000);
		warning_ok.click();
		driver.navigate().back();
	}
	
	public void click_first_request()
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	   	 js.executeScript("arguments[0].click();", click_first_request);
	}
	
	public void cancel_permission_button_click()
	{
		cancel_permission_button.click();
		cancel_yes_button.click();
	}
	
	public void cancellation_success_toast_message_permission()
	{
		String actual = cancellation_success_message.getText().trim();

		assertTrue(
		    actual.equals("Cancellation Submitted Successfully") ||
		    actual.equals("Permission Cancelled"),
		    "Unexpected message: " + actual
		);

	}
	
	public void cancellation_success_toast_message_work_from_home()
	{
		String actual = cancellation_success_message.getText().trim();

		assertTrue(
		    actual.equals("Cancellation Submitted Successfully") ||
		    actual.equals("Work Frome Home Cancelled"),
		    "Unexpected message: " + actual
		);

	}
	
	
}
