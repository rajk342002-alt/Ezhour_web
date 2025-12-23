package page_object_rengaraj;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Two_levelapprovalforleave extends comman_methods {
WebDriver driver;
String status;
	
	@FindBy(xpath = "//*[@id=\"#kt_app_sidebar_menu\"]/div[3]/div/div/div[2]/a/span[2]")
	WebElement leave_myapproval;
	
	@FindBy(xpath="//table[@id=\"pr_id_8-table\"]/tbody/tr[1]/td[2]")
	WebElement my_approvalpage_username;
	
	@FindBy(xpath="//table[@id=\"pr_id_8-table\"]/tbody/tr[1]/td[3]")
	WebElement my_approvalpage_leavetype;
	
	@FindBy(xpath = "//table[@id=\"pr_id_8-table\"]/tbody/tr[1]/td[4]")
	WebElement my_approvalpage_leaveperiod;
	
	@FindBy(xpath="//table[@id=\"pr_id_8-table\"]/tbody/tr[1]/td[5]")
	WebElement my_approvalpage_daycount;
	
	@FindBy(xpath="//table[@id=\"pr_id_8-table\"]/tbody/tr[1]/td[6]")
	WebElement my_approvalpage_daterequest;
	
	@FindBy(xpath="//table[@id=\"pr_id_8-table\"]/tbody/tr[1]/td[7]")
	WebElement my_approvalpage_statusbox;
	
//	-----------------------------------------------------------------------
	
	@FindBy(xpath = "//input[@id=\"LeaveApproval_Comments\"]")
	WebElement myapprovalpage_approve_comment;
	
	
	@FindBy(xpath="//button[text()=\" Approve \"]")
	WebElement myapprovalpage_approve_button;
	
	@FindBy(xpath="//button[text()=\" Reject \"]")
	WebElement myapprovalpage_Reject_button;
	
	@FindBy(xpath="//th[text()=\"Status\"]")
	WebElement status_header;
	
	
	public Two_levelapprovalforleave(WebDriver driver) {
		super(driver);
	PageFactory.initElements(driver, this);
	this.driver=driver;
	
	}
	
	
	public void leave_myapproval_navigating()
	{
		waitForElementClickable(leave_myapproval);
		leave_myapproval.click();
	}
	public void navigate_myapproval_detailspage() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForOverlayToDisappear();
		waitforElementVisible(my_approvalpage_statusbox);
		
		 status=my_approvalpage_statusbox.getText();
		 
	Actions action=new Actions(driver);
	waitForElementClickable(my_approvalpage_statusbox);
	action.moveToElement(my_approvalpage_statusbox).click().build().perform();
	}
	
	public void scroll() throws InterruptedException {
	waitforElementVisible(status_header);
		scroll(status_header);
	}
	
	public void verify_button() throws InterruptedException
	{
	
		Thread.sleep(3000);
		if(status.equalsIgnoreCase("Pending"))
		{
			
			waitforElementVisible(myapprovalpage_approve_button);
	        waitforElementVisible(myapprovalpage_Reject_button);

	        assertTrue(myapprovalpage_approve_button.isDisplayed());
	        assertTrue(myapprovalpage_Reject_button.isDisplayed());
		}
		else if(status.equalsIgnoreCase("Approved") || status.equalsIgnoreCase("Cancelled") || status.equalsIgnoreCase("Inqueue"))
		{
			   assertFalse(isElementVisible(myapprovalpage_approve_button));
		        assertFalse(isElementVisible(myapprovalpage_Reject_button));
		}

	}
	
public void check_buttonis_disabled()
{
	if(status.equalsIgnoreCase("Pending"))
	{
		waitforElementVisible(myapprovalpage_approve_comment);
	String textbox=myapprovalpage_approve_comment.getAttribute("value");
	if(textbox==null  ||  textbox.trim() .isEmpty() )
	{
	assertFalse(myapprovalpage_approve_button.isEnabled(), "No comments, but approve button is enabled");
	assertFalse	(myapprovalpage_Reject_button.isEnabled(), "Reject button is disabled");
	}
	
	}
	
}

public void check_buttonis_enabled(String comment)
{
	
	if(status.equalsIgnoreCase("Pending"))
	{
		waitforElementVisible(myapprovalpage_approve_comment);
	myapprovalpage_approve_comment.sendKeys(comment);
String filled_comment=	myapprovalpage_approve_comment.getAttribute("value");
if(!filled_comment.isEmpty())
{
	assertTrue(myapprovalpage_approve_button.isEnabled(), "Approve button is enabled");
	assertTrue(myapprovalpage_approve_button.isEnabled(), "Reject button is enabled");
}
else {
	assertFalse(myapprovalpage_approve_button.isEnabled(), "Approve button is enabled");
	assertFalse(myapprovalpage_approve_button.isEnabled(), "Reject button is enabled");
}
	}
	
	else {
		 assertFalse(isElementVisible(myapprovalpage_approve_button));
	        assertFalse(isElementVisible(myapprovalpage_Reject_button));
		
	}
	
}

public void back_page()
{
	driver.navigate().back();
	
}
}
