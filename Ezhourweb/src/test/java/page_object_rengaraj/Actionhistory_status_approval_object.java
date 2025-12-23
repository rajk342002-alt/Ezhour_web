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

public class Actionhistory_status_approval_object extends comman_methods{

	WebDriver driver;
	String leave_status = null;
	String firstlevel;
	String secondlevel;
	String userstatus;
	String myapproval_status;

	public Actionhistory_status_approval_object(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/p-table/div/div/table/tbody/tr[1]/td[7]")
	WebElement request_Status;

	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/viewleaveapproval/div/div[3]/div/div/div/table/tbody/tr[1]/td[5]")
	WebElement user_submitted; // user

	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/viewleaveapproval/div/div[3]/div/div/div/table/tbody/tr[2]/td[5]")
	WebElement firstlevel_status; // firstlevel

	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/viewleaveapproval/div/div[3]/div/div/div/table/tbody/tr[3]/td[5]/div")
	WebElement secondlevel_status; // secondlevel
	
	

	public void liststatus_text() throws InterruptedException {
		Thread.sleep(2000);
		waitForOverlayToDisappear();
		leave_status = request_Status.getText();
	}

	public void click_list() {
		waitForOverlayToDisappear();
		waitforElementVisible(request_Status);
		Actions action = new Actions(driver);
		action.moveToElement(request_Status).click().build().perform();
	}

	public void scroll() throws InterruptedException {
		if (!leave_status.equalsIgnoreCase("Cancelled")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			Thread.sleep(2000);
			executor.executeScript("arguments[0].scrollIntoView(true);", secondlevel_status);
		} else {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
//			executor.executeScript("arguments[0].scrollIntoView(true);", user_submitted);
	        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		}
		
	}

	public void userlevel_status() throws InterruptedException {
		
		if (!leave_status.equalsIgnoreCase("Cancelled")) {
			waitforElementVisible(user_submitted);
			userstatus = user_submitted.getText().trim();
		}
	}

	public void firstlevel_status() {
		if (!leave_status.equalsIgnoreCase("Cancelled")) {
			waitforElementVisible(firstlevel_status);
			firstlevel = firstlevel_status.getText().trim();
		} else {
			System.out.println("Cancelled status — so first level getText() not required.");
		}
	}

	public void secondlevel_status() {
		if (!leave_status.equalsIgnoreCase("Cancelled")) {
			waitforElementVisible(secondlevel_status);
			secondlevel = secondlevel_status.getText().trim();
		} else {
			System.out.println("Cancelled status — so first level getText() not required.");
		}
	}

	public void one_level_condition() // single level approver condition
	{
		if (leave_status.contains("Approved")) {
			if (firstlevel.contains("Approved")) {
				assertTrue(true);
				System.out.println("first if pass");
			} else {
				assertFalse(false);
			}
		} else if (leave_status.contains("Pending")) {
			if (firstlevel.contains("Pending")) {
				assertTrue(true);
			} else {
				assertFalse(false);
			}
		} else if (leave_status.contains("Cancelled")) {
			if (firstlevel.contains("Cancelled") || firstlevel.contains("Approved")) {
				assertTrue(true);
			} else {
				assertFalse(false);
			}
		} else if (leave_status.contains("Rejected")) {
			if (firstlevel.contains("Rejected")) {
				assertTrue(true);
			} else {
				assertFalse(false);
			}
		}
	}

	public void two_level_condition() // two level approver condition
	{
		if (leave_status.equalsIgnoreCase("Approved")) {
			if (firstlevel.equalsIgnoreCase("Approved") && secondlevel.equalsIgnoreCase("Approved")) {
				assertTrue(true);
				System.out.println("first if pass");
			} else {
				assertFalse(false);
			}
		}

		else if (leave_status.equals("Pending")) {
			if (firstlevel.equalsIgnoreCase("Pending") && secondlevel.equalsIgnoreCase("Inqueue")) {
				assertTrue(true);
			} else {
				assertFalse(false);
			}
		}

		else if (leave_status.equalsIgnoreCase("Partial Approved")) {
			if (firstlevel.equalsIgnoreCase("Approved") && secondlevel.equalsIgnoreCase("Pending")) {
				assertTrue(true);
			} else {
				assertFalse(false);
			}
		}

		else if (leave_status.equalsIgnoreCase("Rejected")) {
			if ((firstlevel.equalsIgnoreCase("Rejected") || firstlevel.equalsIgnoreCase("Approved"))
					&& (secondlevel.equalsIgnoreCase("Rejected") || secondlevel.equalsIgnoreCase("Pending"))) {
				assertTrue(true);
			} else {
				assertFalse(false);
			}
		}

		else if (leave_status.equalsIgnoreCase("Cancelled")) {
			if (userstatus.equalsIgnoreCase("Cancelled")) {
				
			}
		}
		
		else if(leave_status.equalsIgnoreCase("CancellationPending")){
			if((firstlevel.equalsIgnoreCase("Approved") || firstlevel.equalsIgnoreCase("Cancelled"))&& (secondlevel.equalsIgnoreCase("Approved")|| secondlevel.equalsIgnoreCase("Cancelled")));
			assertTrue(true);
		}
	}
}
