package Pricilla_test_files;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_object_pricilla.DashboardPageObjects;
import Page_object_pricilla.LeaveTrackerPageObjects;
import ezhourweb.testComponents.BaseTestEmployee;
import utils.PropertiesUtil;

public class DashboardPageTests extends BaseTestEmployee {
	
	@Test
	public void verifytheSectionsinOverviewTab() throws InterruptedException {		
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);		
		WebElement[] sections = {
				dashboard.overview,
				dashboard.myProfile,
				dashboard.update,
				dashboard.goToWork,
				dashboard.newHire,
				dashboard.pendingRequests,
				dashboard.leaveType,
				dashboard.myDesk,
				dashboard.announcements,
				dashboard.upcomingHolidays
		};
						
		for (WebElement dashboardSections : sections) {
			wait.until(ExpectedConditions.visibilityOf(dashboardSections));
			String sectionName = dashboardSections.getText();
			System.out.println(sectionName + " is visible successfully");			
		}
		
		String[] expectedSectionNames = {"Overview","My Profile", "Update","Let's get to work", "New Hire", "Pending Approvals", "Leave Type", "My Desk", "Announcement","Upcoming Holidays"};
		
		for (int i = 0; i < sections.length; i++) {
			wait.until(ExpectedConditions.visibilityOf(sections[i]));
			String actualSectionNames = sections[i].getText();
			Assert.assertEquals(actualSectionNames, expectedSectionNames[i]);
		}		
	}	
	
	@Test
	public void verifyMyProfile() throws InterruptedException {	
		String empName = PropertiesUtil.get(userKey + ".fullName");
        String empID = PropertiesUtil.get(userKey + ".userID");
        String jobTitle = PropertiesUtil.get(userKey + ".designation");
        String dateOfJoining = PropertiesUtil.get(userKey + ".joiningDate");
        
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Thread.sleep(3000);
		String user = wait.until(ExpectedConditions.visibilityOf(dashboard.userName)).getText();
		Assert.assertEquals(user, empName, "Username doesn't match");
		String id = dashboard.employeeID.getText();
		Assert.assertEquals(id, empID, "Employee ID doesn't match");
		String jobName = dashboard.designationName.getText();
		Assert.assertEquals(jobName, jobTitle, "Designation doesn't match");
		boolean designationLabel = dashboard.designationTitle.isDisplayed();
		Assert.assertTrue(designationLabel, "Designation label is not visible");
		String joiningDate = dashboard.dateOfJoining.getText();
		Assert.assertEquals(joiningDate, dateOfJoining, "Date of Joing doesn't match");
		boolean DOJLabel = dashboard.DOJ.isDisplayed();
		Assert.assertTrue(DOJLabel,  "DOJ label is not visible");
		System.out.println("Profile Section Verified");
	}
	
	@Test
	public void verifyBillableHoursInUpdateSection() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.billableSection)).isDisplayed(), "Billable Section is not displayed");
		String billableHours = wait.until(ExpectedConditions.visibilityOf(dashboard.billableHrs)).getText();
		Assert.assertEquals(billableHours, "0.00 Hrs");
	}
	
	@Test
	public void verifyNonBillableHoursInUpdateSection() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.nonBillableSection)).isDisplayed(), "Non Billable Section is not displayed");
		String nonBillableHours = wait.until(ExpectedConditions.visibilityOf(dashboard.nonBillableHrs)).getText();
		Assert.assertEquals(nonBillableHours, "0.00 Hrs");
	}
	
	@Test
	public void verifyDateInLetsGoToWorkSection() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.letsGetToWorkDate)).isDisplayed(), "Current Date is not displayed");
		String date = wait.until(ExpectedConditions.visibilityOf(dashboard.letsGetToWorkDate)).getText();
		Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        String currentDate = formatter.format(today);		
        Assert.assertEquals(date, currentDate);	
	}
	
	@Test
	public void verifyGeneralShiftTiming() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.generalShiftTime)).isDisplayed(), "General shift timing is not displayed");
		WebElement[] actualGeneralShift = { dashboard.generalShiftTime};
		String[] expectedGeneralShift = {"09:00 AM", "General", "06:00 PM"};		
		
		for (int i = 0; i < actualGeneralShift.length; i++) {
			wait.until(ExpectedConditions.visibilityOf(actualGeneralShift[i]));
			String actualSectionNames = actualGeneralShift[i].getText();
			Assert.assertEquals(actualSectionNames, expectedGeneralShift[i]);
		}			
	}
	
	@Test
	public void verifyPendingApprovalsSections() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.pendingApprovalsSections)).isDisplayed(), "Pending requests and approvals are not displayed");
	}
	
	@Test
	public void verifyViewAllButton_PendingApprovals() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.pendingapprovals_viewAll)).isDisplayed(), "View all button is not displayed in Pending approvals section");
		dashboard.pendingapprovals_viewAll.click();
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.timesheetMyRequestsPage)).isDisplayed(), "Timesheet pending approvals list is not displayed");
		driver.navigate().back();	
	}
	
	@Test
	public void verifyViewAllButton_LeaveTpes() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.leaveType_viewAll)).isDisplayed(), "View all button is not displayed in Leave types section");
		dashboard.leaveType_viewAll.click();
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage)).isDisplayed(), "Leave requests list is not displayed");
		driver.navigate().back();	
	}
	
	@Test
	public void verifyViewAllButton_Announcements() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.announcement_viewAll)).isDisplayed(), "View all button is not displayed in Announcements section");
		dashboard.announcement_viewAll.click();
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.allAnnouncementsPage)).isDisplayed(), "Announcements are not displayed");
		driver.navigate().back();	
	}
	
	@Test
	public void verifyViewAllButton_UpcomingHolidays() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.upcomingholidays_viewAll)).isDisplayed(), "View all button is not displayed in Upcoming holidays section");
		dashboard.upcomingholidays_viewAll.click();
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.holidayListPage)).isDisplayed(), "Holidays list is not displayed");
		driver.navigate().back();	
	}
	
	@Test
	public void verifyLeaveTypesAvailable() {
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTypes)).isDisplayed(), "Leave types are not displayed");
		WebElement[] actualLeaveTypes = { dashboard.leaveTypes};
		String[] expectedLeaveTypes = {"LOP", "Casual", "Sick", "OPH"};		
		
		for (int i = 0; i < actualLeaveTypes.length; i++) {
			wait.until(ExpectedConditions.visibilityOf(actualLeaveTypes[i]));
			String actualLeaveNames = actualLeaveTypes[i].getText();
			Assert.assertEquals(actualLeaveNames, expectedLeaveTypes[i]);
		}	
	}
	
	@Test	
	public void clickApplyLeaveFromDashboard()
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.applyLeave)).click();
		String leaveTitle = wait.until(ExpectedConditions.visibilityOf(dashboard.addRequest)).getText();
		Assert.assertEquals(leaveTitle, "Add Request", "User is not able to view add request page");
		driver.navigate().back();
	}
	
	@Test
	public void verifyRemainingLeaveDays()
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTypes)).isDisplayed(), "Leave Types are not displayed");
		List<String> remainingHrs_dashboard = new ArrayList<>();		
		for (WebElement webElement : dashboard.leaveTakenDaysList) {
			String value = webElement.getText();
			remainingHrs_dashboard.add(value);
		}				
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveRequests)).click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveDetails)).click();		
		wait.until(ExpectedConditions.visibilityOf(dashboard.leaveTrackerPage));		
		List<String> remainingHrs_leaveTracker = new ArrayList<>();		
		LeaveTrackerPageObjects leaveTracker = new LeaveTrackerPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveTracker.takenDaysList));
		for (WebElement webElement : leaveTracker.takenDaysList) {
			String value = webElement.getText().split("/")[0].trim();
			remainingHrs_leaveTracker.add(value);
		}	
		System.out.println(remainingHrs_dashboard.size());
		System.out.println(remainingHrs_leaveTracker.size());
		driver.navigate().back();
		Assert.assertEquals(remainingHrs_dashboard, remainingHrs_leaveTracker, "Mismatch between Dashboard and Leave Tracker values");		
	}
	
	@Test
	public void noNewHires()
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		String message = wait.until(ExpectedConditions.visibilityOf(dashboard.noNewJoinee)).getText();
		Assert.assertEquals(message, "No New Joinees in past 15 days.");
	}
	
	@Test
	public void noAnnouncements()
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		String message = wait.until(ExpectedConditions.visibilityOf(dashboard.noAnnouncements)).getText();
		Assert.assertEquals(message, "No Announcement Posted by admin");
	}
	
	@Test
	public void verifyMyDesk()
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.IT)).isDisplayed(), "IT is not visible");
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.task)).isDisplayed(), "Task is not visible");
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.performance)).isDisplayed(), "Performance is not visible");
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboard.appointment)).isDisplayed(), "Appointment is not visible");
	}

}
