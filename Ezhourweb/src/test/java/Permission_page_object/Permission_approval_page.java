package Permission_page_object;

import java.awt.Desktop.Action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Permission_approval_page extends comman_methods {
 WebDriver driver;
 
 @FindBy(xpath="//*[@id=\"#kt_app_sidebar_menu\"]/div[4]/a")
 WebElement Attendance_option;
 
 @FindBy(xpath = "//*[@id=\"#kt_app_sidebar_menu\"]/div[4]/div/div/div[2]/a")
 WebElement permission_myapproval;
 
 @FindBy(xpath = "//*[@id=\"#kt_app_sidebar_menu\"]/div[4]/div/div/div[2]/div/div/div/a")
 WebElement permission_approval_option;
 
 @FindBy(xpath = "//div[@id=\"kt_app_main\"]//table//tbody/tr[1]/td[7]")
 WebElement permission_approvalpage_first_request;
 
 @FindBy(xpath="//*[@id=\"PermissionApproval_Comments\"]")
 WebElement comment_box;
 
 @FindBy(xpath = "//button//span[text()=\"Approve\"]")
 WebElement Approve_button;
 
 @FindBy(xpath="//button[text()=\" Reject \"]")
 WebElement Reject_button;
 
 
 
	
	public Permission_approval_page(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void Click_Attendance()
	{
		waitforElementVisible(Attendance_option);
		Attendance_option.click();
	}
	
	public void Click_MyApproval()
	{
		waitforElementVisible(permission_myapproval);
		permission_myapproval.click();
	}
	
	public void Click_Permission_Approval()
	{
		waitforElementVisible(permission_approval_option);
		permission_approval_option.click();
	}
	
	public void Click_Permission_Approval_first_request()
	{
		
        JavascriptExecutor js = (JavascriptExecutor) driver;
   	 js.executeScript("arguments[0].click();", permission_approvalpage_first_request);
	}
	
	public void comment_box(String comment)
	{
		comment_box.sendKeys(comment);
	}
	
	public void scroll()
	{
		waitforElementVisible(comment_box);
		scroll(comment_box);
	}
	
	public void Click_Approve_button()
	{
		Approve_button.click();
	}
	
	public void Click_Reject_button()
	{
		Reject_button.click();
	}
	
	
	
}
