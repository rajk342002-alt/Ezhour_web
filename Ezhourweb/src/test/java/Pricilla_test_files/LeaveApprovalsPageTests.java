package Pricilla_test_files;

import java.io.File;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_object_pricilla.DashboardPageObjects;
import Page_object_pricilla.LeaveApprovalsPageObjects;
import Page_object_pricilla.LeaveTrackerPageObjects;
import Page_object_pricilla.LoginPageObjects;
import ezhourweb.testComponents.BaseTestEmployee;

public class LeaveApprovalsPageTests extends BaseTestEmployee {
	
	public void applyLeave() throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();		
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage));	
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.applyLeaveBtn)).click();
		Thread.sleep(5000);
		leaveTracker.selectLeaveType("Casual ", wait);
		leaveTracker.fromDate.click();
		Thread.sleep(2000);
		leaveTracker.nextBtnCal.click();
		Thread.sleep(2000);
		leaveTracker.selectDate("24");
		Thread.sleep(2000);
		leaveTracker.toDate.click();
		Thread.sleep(2000);
		leaveTracker.selectDate("24");
		leaveTracker.leaveReason.sendKeys("Fever");
		String filePath = System.getProperty("user.dir") 
                + File.separator + "TestData" 
                + File.separator + "LeaveAttachment.jpg";
		leaveTracker.attachment.sendKeys(filePath);	
		leaveTracker.apply.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));
	}
	
	public void logOut() throws InterruptedException {
		LoginPageObjects login = new LoginPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(login.logoutArrow));
		wait.until(ExpectedConditions.elementToBeClickable(login.logoutArrow)).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(login.logoutBtn));
		wait.until(ExpectedConditions.elementToBeClickable(login.logoutBtn)).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(login.username));
	}
	
	public void loginWithEmployeeCredentials() {
	    LoginPageObjects login = new LoginPageObjects(driver);
	    wait.until(ExpectedConditions.visibilityOf(login.username)).clear();
	    login.username.sendKeys("pricilla.a@rubixtek.com");
	    wait.until(ExpectedConditions.visibilityOf(login.password)).clear();
	 	login.password.sendKeys("123qwe");
	 	login.login_btn.click();
	 	DashboardPageObjects dashboard = new DashboardPageObjects(driver);
	 	WebElement user = wait.until(ExpectedConditions.visibilityOf(dashboard.logged_user));
	 	String name = user.getText();
	 	Assert.assertEquals(name, "Hi, PersisPricilla");
	}
	
	public void loginWithAdminCredentials() {
    	LoginPageObjects login = new LoginPageObjects(driver);
    	wait.until(ExpectedConditions.visibilityOf(login.username)).clear();
    	login.username.sendKeys("admin");
    	wait.until(ExpectedConditions.visibilityOf(login.password)).clear();
    	login.password.sendKeys("123qwe");
    	login.login_btn.click();
    	DashboardPageObjects dashboard = new DashboardPageObjects(driver);
 		WebElement user = wait.until(ExpectedConditions.visibilityOf(dashboard.logged_user));
 		String name = user.getText();
 		Assert.assertEquals(name, "Hi, admin admin");		
    }
	
	public void approveLeaveAdmin() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leave_MyApproval)).click();
		LeaveApprovalsPageObjects leaveApprovals = new LeaveApprovalsPageObjects(driver);
		leaveApprovals.clickPendingApproval(wait);
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.comments)).sendKeys("Approved");
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.approveBtn)).click();	
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveApprovals.leaveListApproved));
		String leaveStatus = leaveApprovals.leaveListApproved.get(0).getText();
		Assert.assertEquals(leaveStatus, "Approved");
	}
	
	public void rejectLeaveAdmin() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leave_MyApproval)).click();
		LeaveApprovalsPageObjects leaveApprovals = new LeaveApprovalsPageObjects(driver);
		leaveApprovals.clickPendingApproval(wait);
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.comments)).sendKeys("Rejected");
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.rejectBtn)).click();	
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveApprovals.leaveListRejected));
		String leaveStatus = leaveApprovals.leaveListRejected.get(0).getText();
		Assert.assertEquals(leaveStatus, "Rejected");
	}
	
	public void cancelApprovedLeave()
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.leaveStatusRow));
		leaveTracker.leaveStatusRow.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.cancelLeaveBtn));
		wait.until(ExpectedConditions.elementToBeClickable(leaveTracker.cancelLeaveBtn));
		leaveTracker.cancelLeaveBtn.click();
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.areYouSurePopup));
		leaveTracker.yesBtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.leaveStatusRow));
		String leaveStatus = leaveTracker.leaveStatusRow.get(0).getText();
		Assert.assertEquals(leaveStatus, "CancellationPending");
	}
	
	public void rejectLeaveCancellation() throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leave_MyApproval)).click();
		LeaveApprovalsPageObjects leaveApprovals = new LeaveApprovalsPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveApprovals.leaveListCancellationPending)).get(0).click();
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.comments)).sendKeys("Rejected");
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.rejectBtn)).click();	
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveApprovals.leaveListApproved));
		String leaveStatus = leaveApprovals.leaveListApproved.get(0).getText();
		Assert.assertEquals(leaveStatus, "Approved");
		Thread.sleep(5000);
	}
	
	public void approveLeaveCancellation()
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leave_MyApproval)).click();
		LeaveApprovalsPageObjects leaveApprovals = new LeaveApprovalsPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveApprovals.leaveListCancellationPending)).get(0).click();
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.comments)).sendKeys("Approved");
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.approveBtn)).click();	
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveApprovals.leaveListCancelled));
		String leaveStatus = leaveApprovals.leaveListCancelled.get(0).getText();
		Assert.assertEquals(leaveStatus, "Cancelled");
	}
	
	@Test(priority = 0)
	public void applyLeave_EmployeeID() throws InterruptedException
	{		
		applyLeave();
		logOut();
	}
	
	@Test(priority = 1)
	public void rejectLeave_AdminID() throws InterruptedException
	{
		loginWithAdminCredentials();	
		rejectLeaveAdmin();
		logOut();
	}
	
	@Test(priority = 2)
	public void loginWithEmployeeID_CheckRejectedLeaveStatus() throws InterruptedException
	{
		loginWithEmployeeCredentials();
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.leaveStatusRow));
		String leaveStatus = leaveTracker.leaveStatusRow.get(0).getText();
		Assert.assertEquals(leaveStatus, "Rejected");
		logOut();
	}
	
	@Test(priority = 3)
	public void applyLeaveOnRejectedDate_EmployeeID() throws InterruptedException
	{	
		loginWithEmployeeCredentials();
		applyLeave();
		logOut();
	}
	
	@Test(priority = 4)
	public void approveLeave_AdminID() throws InterruptedException
	{
		loginWithAdminCredentials();	
		approveLeaveAdmin();
		logOut();
	}
	
	@Test(priority = 5)
	public void loginWithEmployeeID_CheckApprovedLeaveStatus() throws InterruptedException
	{
		loginWithEmployeeCredentials();
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.leaveStatusRow));
		String leaveStatus = leaveTracker.leaveStatusRow.get(0).getText();
		Assert.assertEquals(leaveStatus, "Approved");
		logOut();
	}
	
	@Test(priority = 6)
	public void loginWithEmployeeID_CancelApprovedLeaveStatus() throws InterruptedException
	{
		loginWithEmployeeCredentials();
		cancelApprovedLeave();
		logOut();
	}
	
	@Test(priority = 7)
	public void approveCanceledLeave_AdminID() throws InterruptedException
	{
		loginWithAdminCredentials();	
		approveLeaveCancellation();
		logOut();
	}
	
	@Test(priority = 8)
	public void cancelCanceledLeaveRqst_AdminID() throws InterruptedException
	{
		loginWithEmployeeCredentials();
		applyLeave();
		logOut();
		loginWithAdminCredentials();	
		approveLeaveAdmin();
		logOut();
		loginWithEmployeeCredentials();
		cancelApprovedLeave();
		logOut();
		loginWithAdminCredentials();
		rejectLeaveCancellation();
		logOut();
	}
	
}
