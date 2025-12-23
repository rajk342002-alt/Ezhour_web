package page_object_rengaraj;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import comman_methods.comman_methods;

public class Leave_rejected_object  extends comman_methods{

    String name = Apply_leave_object.username;
    String leavetype=Apply_leave_object.leavetype;
    String fromString=Apply_leave_object.fromdate;
    String rejected_list;
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div/p-paginator/div/button[3]")
    WebElement next;
    
    
    @FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/button[3]")
    WebElement tl_next_button;
    
    @FindBy(xpath="//button[text()=\" Reject \"]")
    WebElement reject_button;

    @FindBy(xpath = "//button[text()=\" Approve \"]")
    WebElement approve_button;

    @FindBy(xpath = "//input[@id=\"LeaveApproval_Comments\"]")
    WebElement commentbox;
    
    @FindBy(xpath = "//*[@id=\"swal2-html-container\"]/span")
    WebElement toast_rejected;

    
    
    public Leave_rejected_object(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click_last_leave_request() throws InterruptedException {
    	
         rejected_list = "//div[@id=\"kt_app_main\"]//tr[td[contains(normalize-space(.),'" 
                        + name + "')] and td[contains(normalize-space(.), '"+leavetype+
                        "')] and td[contains(text(), '"+fromString+"')]]";
        
         
        WebElement Approver_reject_list = driver.findElement(By.xpath(rejected_list));
      
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
   	 js.executeScript("arguments[0].click();", Approver_reject_list);
        
      
    }
    
    public void last_leave_request_approved() throws InterruptedException
    {
    	
        scroll(reject_button);
        commentbox.sendKeys("Approved");
       
        approve_button.click();
        waitforElementVisible(toast_rejected);
        String toast=toast_rejected.getText().trim();
        assertEquals(toast, "Approved successfully.");
        
    }
    
    
    public void last_leave_request_reject() throws InterruptedException {
    	
        scroll(reject_button);
        commentbox.sendKeys("Rejected");
       
        reject_button.click();
        waitforElementVisible(toast_rejected);
        String toast=toast_rejected.getText().trim();
        assertEquals(toast, "Rejected successfully.");
        
    }
}
