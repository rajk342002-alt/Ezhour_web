package page_object_rengaraj;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Myapproval_multiselect_object extends comman_methods {
WebDriver driver;
String count;
	
	


@FindBy(xpath="//select[@id=\"StatusFilterSelect\"]")
WebElement status_dropdown;

@FindBy(xpath="//div[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/p-table/div/div/table/thead/tr/th[1]")
WebElement multiselect_checkbox;

@FindBy(xpath="//textarea[@placeholder=\"Enter your comments\"]")
WebElement multiselect_commentbox;

@FindBy(xpath="//button[text()=\" Reject \"]")
WebElement multiselect_reject_button;

@FindBy(xpath="//button[text()=\" Approve \"]")
WebElement multiselect_approve_button;

@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div[1]")
WebElement no_data;

@FindBy(xpath="//*[@id=\"swal2-html-container\"]/span")
WebElement no_pending_records;

@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/span[1]")
WebElement total;
	
@FindBy(xpath="//*[@id=\"swal2-html-container\"]")
WebElement rejected_success_message;

	public Myapproval_multiselect_object(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void click_pending_dropdown() throws InterruptedException
{
		Thread.sleep(1000);
		waitforElementVisible(status_dropdown);
	dropdown(status_dropdown, "Pending");	
		}
	
	public void pending_multiselect(String comments) throws InterruptedException
	{
		
		Thread.sleep(1000);
		
		String total_count = total.getText().trim();  // total = WebElement
		String[] totalArray = total_count.split(" "); // use a different variable name
		System.out.println("Total numbers "+totalArray[1]); 
	String value=	totalArray[1];// print the count (2nd word)

	waitForOverlayToDisappear();
	
	String count=no_data.getText().trim();
	System.out.println("not showing"+count);
	
		
		if(value.equalsIgnoreCase("0"))
		{
			System.out.println("working no data condition");
			multiselect_checkbox.click();
			waitforElementVisible(no_pending_records);
			
		String message=	no_pending_records.getText().trim();
			assertEquals(message, "No pending records available for selection");
		}
		else {
			multiselect_checkbox.click();
			waitforElementVisible(multiselect_commentbox);
			waitforElementVisible(multiselect_reject_button);
			waitforElementVisible(multiselect_approve_button);
			assertTrue(multiselect_commentbox.isDisplayed());
			assertTrue(multiselect_approve_button.isDisplayed());
			assertTrue(multiselect_reject_button.isDisplayed());
			
			assertFalse(multiselect_reject_button.isEnabled());
			assertFalse(multiselect_approve_button.isEnabled());
			multiselect_commentbox.sendKeys(comments);
			assertTrue(multiselect_approve_button.isEnabled());
			assertTrue(multiselect_reject_button.isEnabled());
		}
		
	}
		
		
	
	
	public void refresh()
	{
		driver.navigate().refresh();
	}
	
	
	
	
	public void click_approved_dropdown() {
		waitforElementVisible(status_dropdown);
	dropdown(status_dropdown, "Approved");
	}
	
	public void Approved_multiselect() throws InterruptedException
	{
		Thread.sleep(1000);
	
	String count1=no_data.getText().trim();
	{
		if(count1.equalsIgnoreCase("No data"))
		{
			waitForOverlayToDisappear();
			multiselect_checkbox.click();
			Thread.sleep(2000);
			waitforElementVisible(no_pending_records);
			
		String message=	no_pending_records.getText().trim();
			assertEquals(message, "No pending records available for selection");
		}
		else {
			waitForOverlayToDisappear();
			multiselect_checkbox.click();
			waitforElementVisible(no_pending_records);
			Thread.sleep(2000);
			String message=	no_pending_records.getText().trim();
				assertEquals(message, "No pending records available for selection");
			
		}}
		
		
	}
	

	public void click_Inqueue_dropdown() throws InterruptedException 
	{
		Thread.sleep(1000);
	dropdown(status_dropdown, "Inqueue");
	}
	
	
	public void click_rejected_dropdown()
	{
		
		dropdown(status_dropdown, "Rejected");
		
	}
	
	public void click_cancelled_dropdown()
	{
		dropdown(status_dropdown, "Cancelled");
	}
		
	public void click_cancellation_pending()
	{
		dropdown(status_dropdown, "CancellationPending");
	}
	

	
	
	
	
	
	
	public void multiselect() throws InterruptedException
	{
	
		Thread.sleep(2000);
		
	String count2=no_data.getText().trim();
	{
		if(count2.equalsIgnoreCase("No data"))
		{
			waitForOverlayToDisappear();
			multiselect_checkbox.click();
			Thread.sleep(2000);
			waitforElementVisible(no_pending_records);
			
		String message=	no_pending_records.getText().trim();
			assertEquals(message, "No pending records available for selection");
		}
		else {
			waitForOverlayToDisappear();
			multiselect_checkbox.click();
			waitforElementVisible(no_pending_records);
			Thread.sleep(2000);
			String message=	no_pending_records.getText().trim();
				assertEquals(message, "No pending records available for selection");
			
		}}
		
		
	}
	
	public void multiselect_approve_button_click()
	{
		multiselect_approve_button.click();
		

	}
	
	public void multiselect_reject_button_click()
	{
		multiselect_reject_button.click();
	}
	
	public void rejected_sucess_message()
	{
		assertEquals(rejected_success_message.getText().trim(), "Leave Rejected Successfully");
	}
	
	public void Approved_sucess_message()
	{
		assertEquals(rejected_success_message.getText().trim(), "Leave Approved Successfully");
	}
	
	
	
	



}
