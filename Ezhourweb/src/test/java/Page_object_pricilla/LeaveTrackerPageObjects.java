package Page_object_pricilla;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LeaveTrackerPageObjects  {
	
	WebDriver driver;
	WebDriverWait wait;

    public LeaveTrackerPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
    @FindBy(xpath = "//h1[text()=' Leave Tracker ']")
	public WebElement leaveTrackerPage;
    
	@FindBy(xpath = "//p[text()='Approved']")
	public WebElement approvedReq;
	
	@FindBy(xpath = "//strong")
	public List<WebElement> takenDaysList;
	
	@FindBy(id = "btn_create_leave")
	public WebElement applyLeaveBtn;
	
	@FindBy(name = "leaveTypeId")
	public WebElement leaveTypeDropdown;
	
	@FindBy(name = "leaveTypeId")
	public WebElement selectLeaveType;
	
	@FindBy(id = "fromDate")
	public WebElement fromDate;
	
	@FindBy(id = "toDate")
	public WebElement toDate;
	
	@FindBy(xpath = "//button[@type='button' and @class= 'next']")
	public WebElement nextBtnCal;
	
	@FindBy(id = "Leave_Reason")
	public WebElement leaveReason;
	
	@FindBy(id = "Leave_Attachment")
	public WebElement attachment;
	
	@FindBy(xpath = "//button[@type='submit']//span[contains(text(), 'Apply')]")
	public WebElement apply;
	
	@FindBy(id = "leaveModeSelect")
	public WebElement selectLeaveMode;
	
	@FindBy(xpath = "//button[contains(@style,'background-color: #D9D9D9') and text()= ' Cancel ']")
	public WebElement cancelBtn;
	
	@FindBy(xpath = "//span[@class='text-white']")
	public WebElement errorMsg;
	
	@FindBy(xpath = "//table[@role='table']//following::tbody//tr//p[text()='Pending']")
	public List<WebElement> pendingLeaves;
	
	@FindBy(xpath = "//table[@role='table']//following::tbody//tr//p[text()='Cancelled']")
	public List<WebElement> cancelledLeaves;
	
	@FindBy(xpath = "//button[contains(@class,'btn-danger')]")
	public WebElement cancelLeaveBtn;
	
	@FindBy(xpath = "//div[contains(@class,'leavedays')]")
	public WebElement availableDays;
	
	@FindBy(xpath = "//h6[normalize-space()='Employee']/parent::div/following-sibling::div//span[1]")
	public WebElement employeeName;
	
	@FindBy(xpath = "//h6[normalize-space()='Leave Type']/parent::div/following-sibling::div//span[1]")
	public WebElement leaveType;
	
	@FindBy(xpath = "//h6[normalize-space()='Date']/parent::div/following-sibling::div//span[1]")
	public WebElement leaveRequestDate;
	
	@FindBy(xpath = "//h6[normalize-space()='Reason For Leave']/parent::div/following-sibling::div//span[1]")
	public WebElement reasonForLeave;
	
	@FindBy(xpath = "//a[contains(@class, 'float-end')]//img")
	public WebElement closeBtn;
	
	@FindBy(xpath = "//button[text()='Yes']")
	public WebElement yesBtn;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	public WebElement cancelBtn_SurePopup;
	
	@FindBy(xpath = "//h2[text()='Are You Sure to Cancel']")
	public WebElement areYouSurePopup;
	
	@FindBy(xpath = "//span[contains(@class,'username')]")
	public WebElement usernameRow;
	
	@FindBy(xpath = "//td//span[normalize-space(text())='Leave Type']/parent::td")
	public WebElement leaveTypeRow;
	
	@FindBy(xpath = "//td//span[normalize-space(text())='Days Taken']//following-sibling::span")
	public WebElement daysTakenRow;
	
	@FindBy(xpath = "//td//span[normalize-space(text())='Date of Request']/parent::td")
	public WebElement dateOfRequestRow;
	
	@FindBy(xpath = "//td//span[normalize-space(text())='Status']/parent::td/p")
	public List<WebElement> leaveStatusRow;

	@FindBy(xpath = "//button[text()=' Approve ']")
	public WebElement approveBtn;
	
	@FindBy(xpath = "//button[text()=' Reject ']")
	public WebElement rejectBtn;
	
	@FindBy(id = "LeaveApproval_Comments")
	public WebElement comments;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	public WebElement weekendDateError;
	
	@FindBy(xpath = "//button[text()='Ok']")
	public WebElement okBtn;
	
	public void clickRecentlyAppliedLeave(WebDriverWait wait) {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(pendingLeaves));
		if (!pendingLeaves.isEmpty()) {
	        pendingLeaves.get(0).click();
	    } 
		else {
	        throw new RuntimeException("No pending leaves found");
	    }				
	}

	public void getPendingListAndCancelAll(WebDriverWait wait) throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(pendingLeaves));		
		int count = pendingLeaves.size();		
		System.out.println(count);		
		for(int i=0; i<count; i++)
		{
			if(count!=0)
			{
				pendingLeaves.get(0).click();
				wait.until(ExpectedConditions.visibilityOf(cancelLeaveBtn));
				cancelLeaveBtn.click();
				Assert.assertTrue(areYouSurePopup.isDisplayed(), "Are you sure to Cancel popup is not displayed");
				yesBtn.click();
				wait.until(ExpectedConditions.visibilityOfAllElements(takenDaysList));	
			}
			else
			{
				System.out.println("Pending requests list is empty");
			}
		}		
	}

	public void selectLeaveMode(String leaveMode, WebDriverWait wait) {
		
		Select selectMode = new Select(wait.until(ExpectedConditions.visibilityOf(selectLeaveMode)));
		selectMode.selectByVisibleText(leaveMode);		
	}

	public void selectLeaveType(String leaveType, WebDriverWait wait) {
		
		Select selectType = new Select(wait.until(ExpectedConditions.visibilityOf(leaveTypeDropdown)));
		selectType.selectByVisibleText(leaveType);		
	}
	
	public void selectDate(String day) {
		String dateXpath = "//td[@role = 'gridcell']//span[contains(text(), '" + day + "')]";
		WebElement date = driver.findElement(By.xpath(dateXpath));
	    date.click();
	}

	public void uploadAttachment() {
		String filePath = System.getProperty("user.dir") 
                + File.separator + "TestData" 
                + File.separator + "LeaveAttachment.jpg";
		attachment.sendKeys(filePath);	
		
	}

	public void getLeaveDetailsRow() {
		
		cancelledLeaves.get(0);
		String empName = usernameRow.getText(), 
						leaveType = leaveTypeRow.getText(), 
						daysTaken = daysTakenRow.getText(),
						dateOfRequest = dateOfRequestRow.getText(),
						leaveStatus = leaveStatusRow.get(0).getText();
		List<String> leaveDetailsRow = new ArrayList<>();
		leaveDetailsRow.add(empName);
		leaveDetailsRow.add(leaveType);
		leaveDetailsRow.add(daysTaken);
		leaveDetailsRow.add(dateOfRequest);
		leaveDetailsRow.add(leaveStatus);
		System.out.println(leaveDetailsRow);
	}

	public void getLeaveDetailsPage(WebDriverWait wait) throws InterruptedException {
		
		Thread.sleep(5000);
		String empName = employeeName.getText(),
		leaveTypeDetails = leaveType.getText(), 
		leaveReqDate = leaveRequestDate.getText();
		List<String> leaveDetailsPage = new ArrayList<>();
		leaveDetailsPage.add(empName);
		leaveDetailsPage.add(leaveTypeDetails);
		leaveDetailsPage.add(leaveReqDate);
		System.out.println(leaveDetailsPage);
		
	}
	
}
