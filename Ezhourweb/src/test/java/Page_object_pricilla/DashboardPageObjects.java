package Page_object_pricilla;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageObjects {
	
	WebDriver driver;

    public DashboardPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//*[@id='kt_quick_user_toggle']//following::span[contains(@class, 'logged-user')]")
	public WebElement logged_user;
	
	@FindBy(xpath = "//button[contains(@class,'btn-dashboard1')]")
	public WebElement overview;
	
	@FindBy(xpath = "//div[@class='card-header border-0']/h5[contains(@class, 'card-title row pb-2 pt-3')]")
	public WebElement myProfile;
	
	@FindBy(xpath = "//div[@class='card-header align-items-center border-0']/h3/span[contains(@class, 'text-dark')]")
	public WebElement update;
	
	@FindBy(xpath = "//div[@class='card']//div[@class='card-header border-0']/h5[contains(@class, 'row pb-2 pt-3 card-title')]")
	public WebElement goToWork;
	
	@FindBy(xpath = "//div[@class='card card-custom h-100']//div[@class='card-header align-items-center border-0']/h5[contains(@class, 'card-title pb-2 pt-3 align-items-start flex-column')]/span")
	public WebElement newHire;
	
	@FindBy(xpath = "//div[@class='card card-custom h-100']//div[@class='card-header border-0']/h5[contains(@class, 'card-title pb-2 pt-3 align-items-start flex-column')]")
	public WebElement pendingRequests;
	
	@FindBy(xpath = "//div[@class='card card-custom h-100']//div[@class='card-header border-0']/h5[contains(@class, 'row pb-2 pt-3 card-title')]")
	public WebElement leaveType;
	
	@FindBy(xpath = "//div[@class='card h-100']//div[@class='card-header border-0']/h5[contains(@class, 'pb-2 pt-3 card-title')]")
	public WebElement myDesk;
	
	@FindBy(xpath = "//app-widget-org-announcements[@class='ng-star-inserted']//div[@class='card card-custom h-96']//div[@class='card-header border-0']/h5[contains(@class, 'row pb-2 pt-3 card-title')]")
	public WebElement announcements;
	
	@FindBy(xpath = "//app-widget-upcome-holidays[@class='ng-star-inserted']//div[@class='card card-custom h-96']//div[@class='card-header border-0']/h5[contains(@class, 'row pb-2 pt-3 card-title')]")
	public WebElement upcomingHolidays;
	
	@FindBy(className = "username")
	public WebElement userName;
	
	@FindBy(xpath = "//div[@class='col-9 col-sm-7 text-center prof-det']//preceding::div[@class='userinput']")
	public WebElement employeeID;
	
	@FindBy(xpath = "//div[@class='col-3 col-sm-5 text-center prof-det']//div[@class='userdoj']")
	public WebElement dateOfJoining;
	
	@FindBy(xpath = "//div[@class='col-3 col-sm-5 text-center prof-det']//following::div[@class='userinput']")
	public WebElement DOJ;
	
	@FindBy(xpath = "//div[@class='col-3 col-sm-5 text-center prof-det']//preceding::div[@class='userinput']//following::div[@class='userdoj']")
	public WebElement designationName;
	
	@FindBy(xpath = "//div[@class='userdoj']//preceding::div[@class='col-9 col-sm-7 text-center prof-det']//div[@class='userinput']")
	public WebElement designationTitle;
	
	@FindBy(xpath = "//button[@class='btn-applyleave']")
	public WebElement applyLeave;
	
	@FindBy(xpath = "//h1[contains(text(), 'Add Request')]")
	public WebElement addRequest;
	
	@FindBy(className = "noNewJoinees")
	public WebElement noNewJoinee;
	
	@FindBy(className = "text-noAnnouncements")
	public WebElement noAnnouncements;
	
	@FindBy(xpath = "//span[contains(text(), 'IT')]")
	public WebElement IT;
	
	@FindBy(xpath = "//span[contains(text(), 'Task')]")
	public WebElement task;
	
	@FindBy(xpath = "//span[contains(text(), 'Performance')]")
	public WebElement performance;
	
	@FindBy(xpath = "//span[contains(text(), 'Appointment')]")
	public WebElement appointment;
	
	@FindBy(xpath = "//tbody[contains(@class, 'p-datatable-tbody')]//following::tr[@class='ng-star-inserted']")
	public WebElement holidayList;
	
	@FindBy(xpath = "//span[text()='Leave tracker']")
	public WebElement leaveRequests;
	
	@FindBy(xpath = "//span[text()='Leave Details']")
	public WebElement leaveDetails;
	
	@FindBy(xpath = "//span[text()='Attendance']")
	public WebElement attendance;
	
	@FindBy(xpath = "//span[text()='My Approval']")
	public WebElement myApproval;
	
	@FindBy(xpath = "//span[text()='Administration']")
	public WebElement administration;
	
	@FindBy(xpath = "//a[@href='/app/main/rubixProduct/leaveApprovals']//following-sibling::span[text()='My Approval']")
	public WebElement leave_MyApproval;
	
	@FindBy(xpath = "//span[text()='Permission Approvals']")
	public WebElement permissionapprovals;
	
	@FindBy(xpath = "//span[text()='Projects']")
	public WebElement projects;
	
	@FindBy(xpath = "//h6[text()='Billable']")
	public WebElement billableSection;
	
	@FindBy(xpath = "//h6[text()='Billable']//following::p")
	public WebElement billableHrs;
	
	@FindBy(xpath = "//h6[text()='Non-Billable']")
	public WebElement nonBillableSection;
	
	@FindBy(xpath = "//h6[text()='Non-Billable']//following::p")
	public WebElement nonBillableHrs;
	
	@FindBy(xpath = "//h5[contains(text(), \"Let's get to work\")]/following-sibling::h5")
	public WebElement letsGetToWorkDate;

	@FindBy(xpath = "//div[@class='row shift']//div//span")
	public WebElement generalShiftTime;
	
	@FindBy(xpath = "//h5[contains(text(), \"Pending Approvals\")]//following::h3//span")
	public WebElement pendingApprovalsSections;
	
	@FindBy(xpath = "//h5[contains(text(), \"Leave Type\")]//following::div[@class='leave-data']//h4")
	public WebElement leaveTypes;
	
	@FindBy(xpath = "//h5[contains(text(),\" Announcement \")]//following-sibling::a//h5//u")
	public WebElement announcement_viewAll;
	
	@FindBy(xpath = "//h1[text()=' All Announcements ']")
	public WebElement allAnnouncementsPage;
	
	@FindBy(xpath = "//h5[contains(text(),' Upcoming Holidays  ')]//following-sibling::a//h5//u")
	public WebElement upcomingholidays_viewAll;
	
	@FindBy(xpath = "//h1[text()=' Holiday List ']")
	public WebElement holidayListPage;
	
	@FindBy(xpath = "//h5[contains(text(),' Leave Type ')]//following-sibling::a//h5//u")
	public WebElement leaveType_viewAll;
	
	@FindBy(xpath = "//h1[text()=' Leave Tracker ']")
	public WebElement leaveTrackerPage;
	
	@FindBy(xpath = "//h5[contains(text(),' Pending Approvals ')]//following-sibling::a//h5//u")
	public WebElement pendingapprovals_viewAll;
	
	@FindBy(xpath = "//button[text()=' My Request ']")
	public WebElement timesheetMyRequestsPage;
	
	@FindBy(name = "leaveTypeId")
	public WebElement leaveTypeDropdown;
	
	@FindBy(xpath = "//h5[contains(text(), 'Leave Type')]//following::div[@class='leave-data']//following::h2[contains(@class,'text-takenDays')]")
	public List<WebElement> leaveTakenDaysList;
	
}
