package Page_object_pricilla;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeaveApprovalsPageObjects {
	
	WebDriver driver;
	WebDriverWait wait;

    public LeaveApprovalsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//table[@role='table']//following::tbody//tr//td//div[contains(@class,'Pending')]")
	public List<WebElement> pendingApprovalList;
	
	@FindBy(xpath = "//table[@role='table']//following::tbody//tr//td//div[contains(@class,'Approved')]")
	public List<WebElement> approvedLeaveList;
	
	@FindBy(xpath = "//table[@role='table']//following::tbody//tr//div[contains(@class,'Approved')][1]")
	public List<WebElement> leaveListApproved;
	
	@FindBy(xpath = "//table[@role='table']//following::tbody//tr//div[contains(@class,'Rejected')][1]")
	public List<WebElement> leaveListRejected;
	
	@FindBy(xpath = "//table[@role='table']//following::tbody//tr//div[contains(@class,'CancelPend')][1]")
	public List<WebElement> leaveListCancellationPending;
	
	@FindBy(xpath = "//table[@role='table']//following::tbody//tr//div[contains(@class,'Cancel')][1]")
	public List<WebElement> leaveListCancelled;
	
	@FindBy(xpath = "//button[text()='Cancel Leave']")
	public WebElement cancelLeaveBtn;
	
	public void clickPendingApproval(WebDriverWait wait) {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(pendingApprovalList));
		if (!pendingApprovalList.isEmpty()) {
			pendingApprovalList.get(0).click();
	    } 
		else {
	        throw new RuntimeException("No pending leaves found");
	    }				
	}

}
