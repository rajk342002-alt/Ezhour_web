package page_object_rengaraj;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import comman_methods.comman_methods;

public class ApprovedLeaveCancel_object extends comman_methods {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div/p-paginator/div/button[3]")
    WebElement next;

    @FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/button[3]")
    WebElement tl_next_button;

    @FindBy(xpath = "//button[text()=\"Cancel Leave\"]")
    WebElement cancel_leave_button;

    @FindBy(xpath = "//button[text()=\"Yes\"]")
    WebElement Leave_cancel_yes_button;

    @FindBy(xpath = "//div[@id=\"swal2-html-container\"]/span")
    WebElement Leave_cancel_success_toast;

    @FindBy(xpath = "//div[@id='kt_app_main']//tr[td/p[text()='Approved']][1]")
    WebElement approved_list_first;

    @FindBy(xpath = "//div[@id='kt_app_main']//tr[td/div[text()='CancellationPending']]")
    WebElement cancellation_pending_first;
    
    
    @FindBy(xpath = "//div[@id='kt_app_main']//tr[td/div[text()='Pending']]")
    WebElement pending_first;

    @FindBy(xpath = "//input[@id=\"LeaveApproval_Comments\"]")
    WebElement commentbox;

    @FindBy(xpath = "//button[text()=\" Approve \"]")
    WebElement approve_button;

    @FindBy(xpath = "//div[@id=\"swal2-html-container\"]/span")
    WebElement toast_approved;

    public ApprovedLeaveCancel_object(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickApprovedRequest() throws InterruptedException {
        while (true) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", next);
            Thread.sleep(2000);

            List<WebElement> approvedList = driver.findElements(
                    By.xpath("//div[@id='kt_app_main']//tr[td/p[text()='Approved']]")
            );

            if (!approvedList.isEmpty()) {
                System.out.println("Approved request is found");
                Thread.sleep(1000);

                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", approved_list_first);

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(approved_list_first));

                try {
                    approved_list_first.click();
                } catch (ElementClickInterceptedException e) {
                    js.executeScript("arguments[0].click();", approved_list_first);
                }

                System.out.println("Approved leave request is clicked");
                Thread.sleep(1000);

                scroll(cancel_leave_button);
                assertTrue(cancel_leave_button.isDisplayed(), "Cancel button is displayed");
                assertTrue(cancel_leave_button.isEnabled());

                cancel_leave_button.click();
                Thread.sleep(1000);
                Leave_cancel_yes_button.click();

                waitforElementVisible(Leave_cancel_success_toast);
                String toast_message = Leave_cancel_success_toast.getText().trim();
                System.out.println("Toast message: " + toast_message);
                assertEquals(toast_message, "Cancellation Submitted Successfully");
                break;
            }

            try {
                if (!next.isEnabled()) {
                    System.out.println("Next button is disabled. No Approved request found.");
                    break;
                }
            } catch (StaleElementReferenceException e) {
                next = driver.findElement(By.xpath("//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div/p-paginator/div/button[3]"));
            }

            js.executeScript("arguments[0].click();", next);
        }
    }

    public void tl_approve_approvedcancellation() throws InterruptedException {
        while (true) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", tl_next_button);
            Thread.sleep(2000);

            List<WebElement> approvedList = driver.findElements(
                    By.xpath("//div[@id='kt_app_main']//tr[td/div[text()='CancellationPending']]")
            );

            if (!approvedList.isEmpty()) {
                System.out.println("CancellationPending request found");
                Thread.sleep(1000);

                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", cancellation_pending_first);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(cancellation_pending_first));

                try {
                    cancellation_pending_first.click();
                } catch (ElementClickInterceptedException e) {
                    js.executeScript("arguments[0].click();", cancellation_pending_first);
                }
                
                
                
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", commentbox);
                Thread.sleep(1000); // optional small wait
                commentbox.sendKeys("approved");

                WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
                waiting.until(ExpectedConditions.elementToBeClickable(approve_button));
                try {
                    approve_button.click();
                } catch (ElementClickInterceptedException e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", approve_button);
                }


                waitforElementVisible(toast_approved);
                String toast_message = toast_approved.getText().trim();
                System.out.println("Toast message: " + toast_message);
                assertEquals(toast_message, "Approved successfully.");
                break;
            }

            try {
                if (!tl_next_button.isEnabled()) {
                    System.out.println("Next button is disabled. No CancellationPending found.");
                    break;
                }
            } catch (StaleElementReferenceException e) {
                tl_next_button = driver.findElement(By.xpath("//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/button[3]"));
            }

            js.executeScript("arguments[0].click();", tl_next_button);
        }
    }
    
    
//    ----------------------------------------------------------------------
    
    public void approved_leave() throws InterruptedException {
        while (true) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", tl_next_button);
            Thread.sleep(2000);

            List<WebElement> approvedList = driver.findElements(
                    By.xpath("//div[@id='kt_app_main']//tr[td/div[text()='Pending']]")
            );

            if (!approvedList.isEmpty()) {
                System.out.println("CancellationPending request found");
                Thread.sleep(1000);

                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", pending_first);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(pending_first));

                try {
                    pending_first.click();
                } catch (ElementClickInterceptedException e) {
                    js.executeScript("arguments[0].click();", pending_first);
                }
                
                
                
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", commentbox);
                Thread.sleep(1000); // optional small wait
                commentbox.sendKeys("approved");

                WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
                waiting.until(ExpectedConditions.elementToBeClickable(approve_button));
                try {
                    approve_button.click();
                } catch (ElementClickInterceptedException e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", approve_button);
                }


                waitforElementVisible(toast_approved);
                String toast_message = toast_approved.getText().trim();
                System.out.println("Toast message: " + toast_message);
                assertEquals(toast_message, "Approved successfully.");
                break;
            }

            try {
                if (!tl_next_button.isEnabled()) {
                    System.out.println("Next button is disabled. No CancellationPending found.");
                    break;
                }
            } catch (StaleElementReferenceException e) {
                tl_next_button = driver.findElement(By.xpath("//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/button[3]"));
            }

            js.executeScript("arguments[0].click();", tl_next_button);
        }
    }
}
