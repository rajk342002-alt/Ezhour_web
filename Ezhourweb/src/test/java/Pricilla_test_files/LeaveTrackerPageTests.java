package Pricilla_test_files;

import java.io.File;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_object_pricilla.DashboardPageObjects;
import Page_object_pricilla.LeaveTrackerPageObjects;
import ezhourweb.testComponents.BaseTestEmployee;

public class LeaveTrackerPageTests extends BaseTestEmployee {
	
	@Test(priority = 5)
	public void applyLeaveForAlreadyAppliedFullDayAndCheckAlertMsg() throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();		
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage));	
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.applyLeaveBtn)).click();
		Thread.sleep(5000);
		leaveTracker.selectLeaveType("Sick ", wait);
		leaveTracker.fromDate.click();
		leaveTracker.nextBtnCal.click();
		leaveTracker.selectDate("15");
		leaveTracker.toDate.click();
		leaveTracker.selectDate("15");
		leaveTracker.leaveReason.sendKeys("Fever");
		String filePath = System.getProperty("user.dir") 
                + File.separator + "TestData" 
                + File.separator + "LeaveAttachment.jpg";
		leaveTracker.attachment.sendKeys(filePath);	
		leaveTracker.apply.click();		
		Assert.assertEquals(leaveTracker.errorMsg.getText(), "Leave already applied for the same date.");
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.cancelBtn)).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));
	}
	
	@Test(priority = 2)
	public void fillLeaveFormForSingleFullDayAndClickCancel() throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();		
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage));	
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.applyLeaveBtn)).click();
		Thread.sleep(5000);
		leaveTracker.selectLeaveType("Sick ", wait);
		leaveTracker.fromDate.click();
		leaveTracker.nextBtnCal.click();
		leaveTracker.selectDate("15");
		leaveTracker.toDate.click();
		leaveTracker.selectDate("15");
		leaveTracker.leaveReason.sendKeys("Fever");
		String filePath = System.getProperty("user.dir") 
                + File.separator + "TestData" 
                + File.separator + "LeaveAttachment.jpg";
		leaveTracker.attachment.sendKeys(filePath);	
		leaveTracker.cancelBtn.click();	
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));
	}

	@Test(priority = 3)
	public void applyLeaveForSingleFirstHalfDayAndClickApply() throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();		
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage));	
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.applyLeaveBtn)).click();
		Thread.sleep(5000);
		leaveTracker.selectLeaveType("Sick ", wait);
		leaveTracker.fromDate.click();
		leaveTracker.nextBtnCal.click();
		leaveTracker.selectDate("15");
		leaveTracker.toDate.click();
		leaveTracker.selectDate("15");
		leaveTracker.selectLeaveMode(" HalfDay FirstHalf", wait);
		leaveTracker.leaveReason.sendKeys("Fever");
		String filePath = System.getProperty("user.dir") 
                + File.separator + "TestData" 
                + File.separator + "LeaveAttachment.jpg";
		leaveTracker.attachment.sendKeys(filePath);	
		leaveTracker.apply.click();		
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));
	}
	
	@Test(priority = 0)
	public void applyLeaveForSingleFirstHalfDayAndClickCancel() throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();		
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage));	
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.applyLeaveBtn)).click();
		Thread.sleep(5000);
		leaveTracker.selectLeaveType("Sick ", wait);
		leaveTracker.fromDate.click();
		leaveTracker.nextBtnCal.click();
		leaveTracker.selectDate("15");
		leaveTracker.toDate.click();
		leaveTracker.selectDate("15");
		leaveTracker.selectLeaveMode(" HalfDay FirstHalf", wait);
		leaveTracker.leaveReason.sendKeys("Fever");
		String filePath = System.getProperty("user.dir") 
                + File.separator + "TestData" 
                + File.separator + "LeaveAttachment.jpg";
		leaveTracker.attachment.sendKeys(filePath);	
		leaveTracker.cancelBtn.click();		
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));
	}
	
	@Test(priority = 4)
	public void applyLeaveForSingleSecondHalfDayAndClickApply() throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();		
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage));	
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.applyLeaveBtn)).click();
		Thread.sleep(5000);
		leaveTracker.selectLeaveType("Sick ", wait);
		leaveTracker.fromDate.click();
		leaveTracker.nextBtnCal.click();
		leaveTracker.selectDate("15");
		leaveTracker.toDate.click();
		leaveTracker.selectDate("15");
		leaveTracker.selectLeaveMode(" HalfDay SecondHalf", wait);		
		leaveTracker.leaveReason.sendKeys("Fever");
		String filePath = System.getProperty("user.dir") 
                + File.separator + "TestData" 
                + File.separator + "LeaveAttachment.jpg";
		leaveTracker.attachment.sendKeys(filePath);	
		leaveTracker.apply.click();		
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));
	}
	
	@Test(priority = 1)
	public void applyLeaveForSingleSecondHalfDayAndClickCancel() throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();		
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage));	
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.applyLeaveBtn)).click();
		Thread.sleep(5000);
		leaveTracker.selectLeaveType("Sick ", wait);
		leaveTracker.fromDate.click();
		leaveTracker.nextBtnCal.click();
		leaveTracker.selectDate("15");
		leaveTracker.toDate.click();
		leaveTracker.selectDate("15");
		leaveTracker.selectLeaveMode(" HalfDay FirstHalf", wait);
		leaveTracker.leaveReason.sendKeys("Fever");
		String filePath = System.getProperty("user.dir") 
                + File.separator + "TestData" 
                + File.separator + "LeaveAttachment.jpg";
		leaveTracker.attachment.sendKeys(filePath);		
		leaveTracker.cancelBtn.click();		
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));
	}
	
	@Test(priority = 6)
	public void applyLeaveForSingleFullDay() throws InterruptedException
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
		leaveTracker.nextBtnCal.click();
		leaveTracker.selectDate("8");
		leaveTracker.toDate.click();
		leaveTracker.selectDate("8");
		leaveTracker.leaveReason.sendKeys("Fever");
		String filePath = System.getProperty("user.dir") 
                + File.separator + "TestData" 
                + File.separator + "LeaveAttachment.jpg";
		leaveTracker.attachment.sendKeys(filePath);	
		leaveTracker.apply.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));
	}
	
	@Test(priority = 7)
	public void verifyRecentlyAppliedLeaveDetails() throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();		
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage));
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		leaveTracker.clickRecentlyAppliedLeave(wait);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.availableDays));
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(leaveTracker.employeeName)).getText(), "RBX10147 PersisPricilla");
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(leaveTracker.leaveType)).getText(), "Casual");
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(leaveTracker.leaveRequestDate)).getText(), "08-Sep-2025");
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(leaveTracker.reasonForLeave)).getText(), "Fever");
		leaveTracker.closeBtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));				
	}
	
	@Test(priority = 8)
	public void cancelRecentlyAppliedLeaveRequestAndClickCancel() throws InterruptedException
	{	
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		leaveTracker.clickRecentlyAppliedLeave(wait);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.cancelLeaveBtn)).click();
		Assert.assertTrue(leaveTracker.areYouSurePopup.isDisplayed(), "Are you sure to Cancel popup is not displayed");
		leaveTracker.cancelBtn_SurePopup.click();
		leaveTracker.closeBtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));				
	}
	
	@Test(priority = 9)
	public void cancelRecentlyAppliedLeaveRequestAndClickYes() throws InterruptedException
	{	
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		leaveTracker.clickRecentlyAppliedLeave(wait);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.cancelLeaveBtn)).click();
		Assert.assertTrue(leaveTracker.areYouSurePopup.isDisplayed(), "Are you sure to Cancel popup is not displayed");
		leaveTracker.yesBtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));				
	}
	
	@Test(priority = 10)
	public void cancelAllPendingLeaveRequests() throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();		
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage));
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		leaveTracker.getPendingListAndCancelAll(wait);			
	}
	
	@Test(priority = 11)
	public void verifyCancelledLeaveDetails() throws InterruptedException
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
		leaveTracker.nextBtnCal.click();
		leaveTracker.selectDate("17");
		leaveTracker.toDate.click();
		leaveTracker.selectDate("17");
		leaveTracker.leaveReason.sendKeys("Fever");
		leaveTracker.uploadAttachment();		
		leaveTracker.apply.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));
		leaveTracker.clickRecentlyAppliedLeave(wait);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.cancelLeaveBtn)).click();
		Assert.assertTrue(leaveTracker.areYouSurePopup.isDisplayed(), "Are you sure to Cancel popup is not displayed");
		leaveTracker.yesBtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));	
		leaveTracker.getLeaveDetailsRow();	
		leaveTracker.cancelledLeaves.get(0).click();
		leaveTracker.getLeaveDetailsPage(wait);		
	}
	
	@Test(priority = 12)
	public void applyLeaveForWeekendDatesyAndCheckAlertMsg() throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();		
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage));	
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.applyLeaveBtn)).click();
		Thread.sleep(5000);
		leaveTracker.selectLeaveType("Sick ", wait);
		leaveTracker.fromDate.click();
		leaveTracker.nextBtnCal.click();
		leaveTracker.selectDate("18");
		leaveTracker.toDate.click();
		leaveTracker.selectDate("18");
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.weekendDateError));
		Assert.assertEquals(leaveTracker.weekendDateError.getText(), "Weekend dates selected");
		leaveTracker.okBtn.click();
		wait.until(ExpectedConditions.visibilityOf(leaveTracker.cancelBtn)).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));
	}
}
