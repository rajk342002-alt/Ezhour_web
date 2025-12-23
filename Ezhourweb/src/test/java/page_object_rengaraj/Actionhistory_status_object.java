package page_object_rengaraj;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Actionhistory_status_object extends comman_methods {
	WebDriver driver;
	String leave_status;
	String firstlevel;
	String secondlevel;
	String userstatus;
	String	myapproval_status;
	
	
	
	public Actionhistory_status_object(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath="//div[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/p-table/div/div/table/tbody/tr[1]/td[6]")
	WebElement request_Status;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/div[3]/div/div/div/table/tbody/tr/td[5]/p")
WebElement user_submitted; //user
	
	@FindBy(xpath="(//*[@id=\"kt_app_main\"]//tbody)[2]//tr[2]/td[5]/p")
	WebElement firstlevel_status; //firstlevel
	
	@FindBy(xpath="(//*[@id=\"kt_app_main\"]//tbody)[2]//tr[3]/td[5]/p")
	WebElement secondlevel_status; //secondlevel
	
	
	
	
	public void liststatus_text()
	{
	  leave_status=request_Status.getText();
		
	}
	
	
	
	public void click_list() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForElementClickable(request_Status);
		Actions action=new Actions(driver);
		action.moveToElement(request_Status).click().build().perform();
	}
	
	 
	
	
	public void scroll() throws InterruptedException
	{
		
		
		 if (!leave_status.equalsIgnoreCase("Cancelled")) {
		
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].scrollIntoView(true);", secondlevel_status);
		 }
		 else {
			 JavascriptExecutor executor=(JavascriptExecutor)driver;
			 waitforElementVisible(user_submitted);
			 executor.executeScript("arguments[0].scrollIntoView(true);", user_submitted);
		 }
		
		  

	}
	
	public void userlevel_status() throws InterruptedException
	{
		
		if (leave_status.equalsIgnoreCase("Cancelled")) {
		userstatus=user_submitted.getText().trim();
		}
	}
	public void firstlevel_status() { 
	    if (!leave_status.equalsIgnoreCase("Cancelled")) {
	        firstlevel = firstlevel_status.getText().trim();
	    } else {
	        System.out.println("Cancelled status — so first level getText() not required.");
	    }
	}

	
	public void secondlevel_status()
	{
		
		 if (!leave_status.equalsIgnoreCase("Cancelled")) {
			 secondlevel=secondlevel_status.getText().trim();
		    } else {
		        System.out.println("Cancelled status — so second level getText() not required.");
		    }
		 
	}
	
	public void one_level_condition() //single level approver condition
	{

		if(leave_status.contains("Approved"))
		{
			if(firstlevel.contains("Approved") )
			{
				assertTrue(true);
				System.out.println("first if pass");
			}
			else {
				assertFalse(false);
			}
		}
		
		
		else if(leave_status.contains("Pending"))
		{
			if(firstlevel.contains("Pending") ) 
			{
				assertTrue(true);
		}
			else {
			assertFalse(false);
		}
			
			
			}
		
		else if(leave_status.contains("Cancelled"))
		{
			if(firstlevel.contains("Cancelled"))
			{
				assertTrue(true);
			}
			else
			{
				assertFalse(false);
			}
			
		}
		
	
		else if(leave_status.contains("Rejected"))
		{
			if(firstlevel.contains("Rejected"))
			{
				assertTrue(true);
			}
			else
			{
				assertFalse(false);
			}
		}
	}
	
	
	public void two_level_condition() throws InterruptedException // two level approver condition
	{
		
		
		if(leave_status.equalsIgnoreCase("Approved"))
		{
			if(firstlevel.equalsIgnoreCase("Approved") && secondlevel.equalsIgnoreCase("Approved"))
			{
				assertTrue(true);
				System.out.println("first if pass");
			}
			else {
				assertFalse(false);
			}
		}
		
		
		else if(leave_status.equals("Pending"))
		{
			if(firstlevel.equalsIgnoreCase("Pending") && secondlevel.equalsIgnoreCase("Inqueue")) 
			{
				assertTrue(true);
		}
			else {
			
		}
			}
		
		
		else if(leave_status.equalsIgnoreCase("Partial Approved"))
		{
				
					if(firstlevel.equalsIgnoreCase("Approved") && secondlevel.equalsIgnoreCase("Pending"))
					{
						assertTrue(true);
				}
					else {
					assertFalse(false);
				}
	}
		else if(leave_status.equalsIgnoreCase("Rejected"))
		{
			if((firstlevel.equalsIgnoreCase("Rejected")|| firstlevel.equalsIgnoreCase("Approved")) && (secondlevel.equalsIgnoreCase("Rejected")))
			{
				assertTrue(true);
			}
			else
			{
				assertFalse(false);
			}
		}
		else if(leave_status.equalsIgnoreCase("Cancelled")) {
			if(userstatus.equalsIgnoreCase("Cancelled"))
			{
//				assertTrue(true);
			}
		}
				
	Thread.sleep(2000);
}
	}
	
