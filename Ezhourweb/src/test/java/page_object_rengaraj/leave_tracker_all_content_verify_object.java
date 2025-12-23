package page_object_rengaraj;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class leave_tracker_all_content_verify_object extends comman_methods{
WebDriver driver;
 
@FindBy(xpath="//*[@id=\"#kt_app_sidebar_menu\"]/div[3]/a")
WebElement dashboard_leavetracker;



@FindBy(xpath="//*[@id=\"#kt_app_sidebar_menu\"]/div[3]/div/div/div/a/span[2]")
WebElement dashboard_leavedetails;


@FindBy(xpath="//*[@id=\"kt_app_main\"]//h1")
WebElement leave_tracker_heading_label;

@FindBy(xpath="//*[@id=\"btn_create_leave\"]")
WebElement apply_leave_button;

@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[1]/div")
WebElement leave_count_box;

@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/form/div/div/div/div")
WebElement serach_box;

@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div/p-paginator/div/span[1]")
WebElement total_count;

@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div/p-paginator/div/button[1]")
WebElement overall_previous_button;

@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div/p-paginator/div/button[2]")
WebElement previous_button;

@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div/p-paginator/div/button[3]")
WebElement next_button;

@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div/p-paginator/div/button[4]")
WebElement overall_next_button;

@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div/p-paginator/div/span[2]/button")
List<WebElement> count_size;

@FindBy(xpath = "//button[text()=1]")
WebElement first_number_pagination_box;

@FindBy(xpath = " //span[@class=\"p-paginator-pages ng-star-inserted\"]//button[last()]")
WebElement last_number_pagination_box;

@FindBy(xpath = "//input[@name=\"filterText\"]")
WebElement serch_filter;

@FindBy(xpath = "(//div[@id=\"kt_app_main\"]//table)[1]//tr//td[2]")
List<WebElement> leave_type_before;

@FindBy(xpath = "(//div[@id=\"kt_app_main\"]//table)[1]//tr//td[2]")
List<WebElement> leave_type_after;


@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/form/div/div/div/div/div/button")
WebElement serch_button;


@FindBy(xpath = "//button[contains(@class,\"p-ripple p-element p-paginator-page p-paginator-element p-link\")]")
List<WebElement> pagination_count;

@FindBy(xpath = "//button[@class=\"p-ripple p-element p-paginator-next p-paginator-element p-link\"]")
WebElement next;

public void verify_leave_tracker()
{
	
}

	public leave_tracker_all_content_verify_object(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void leave_tracker_verify()
	{
		waitforElementVisible(dashboard_leavetracker);
		assertTrue(dashboard_leavetracker.isDisplayed(), "Leave tracker is not displayed in dashboard screen");
		dashboard_leavetracker.click();
	}
	
	
	public void leave_details_verify()
	{
waitforElementVisible(dashboard_leavedetails);
		assertTrue(dashboard_leavedetails.isDisplayed(), "Leave details is not displayed in dashboard screen");
		dashboard_leavedetails.click();
	}
	
	public void leave_tracker_title_verify()
	{
		waitforElementVisible(leave_tracker_heading_label);
		assertTrue(leave_tracker_heading_label.isDisplayed());
		String heading_title=leave_tracker_heading_label.getText().trim();
		assertEquals(heading_title, "Leave Tracker");
	}
	
	public void apply_button_verify()
	{
		waitforElementVisible(apply_leave_button);
		assertTrue(apply_leave_button.isDisplayed());
		assertTrue(apply_leave_button.isEnabled());
	}
	
	public void leave_count_box_verify()
	{
		waitforElementVisible(leave_count_box);
		assertTrue(leave_count_box.isDisplayed(), "leave count box is not displayed");
	}
	
	public void search_box_verify()
	{
		waitforElementVisible(serach_box);
		assertTrue(serach_box.isDisplayed(), "search box is not disaplayed");
	}
	
	public void total_count_verify()
	{
		scroll(total_count);
		waitforElementVisible(total_count);
		assertTrue(total_count.isDisplayed());
	}
	
	public void pagination_button_verify()
	{
		
		assertTrue(overall_previous_button.isDisplayed());
		assertTrue(overall_next_button.isDisplayed());
		assertTrue(previous_button.isDisplayed());
		assertTrue(next_button.isDisplayed());
	}
	
	public void pagination_enable_disable_verify() throws InterruptedException
	{

	
		  String firstBtnClass = first_number_pagination_box.getAttribute("class");
		    if(firstBtnClass.contains("p-highlight")) {
		        assertFalse(overall_previous_button.isEnabled(), "Overall Previous button should be disabled on first page");
		        assertFalse(previous_button.isEnabled(), "Previous button should be disabled on first page");
		        assertTrue(overall_next_button.isEnabled(), "Overall next button is enabled");
		        assertTrue(next_button.isEnabled());
		        System.out.println("First page selected -> Previous buttons disabled ✅");
		    }

		    Thread.sleep(2000);
		    overall_next_button.click();
		    Thread.sleep(2000);

		    // last page check
		    String lastBtnClass = last_number_pagination_box.getAttribute("class");
		    if(lastBtnClass.contains("p-highlight")) {
		        assertFalse(next_button.isEnabled(), "Next button should be disabled on last page");
		        assertFalse(overall_next_button.isEnabled(), "Overall Next button should be disabled on last page");
		        assertTrue(overall_previous_button.isEnabled());
		        assertTrue(previous_button.isEnabled());
		        System.out.println("Last page selected -> Next buttons disabled ✅");
		    }
		    
		   
}
	
	public void pagination_middle_verify() throws InterruptedException
	{
	int pagination_size=pagination_count.size();
	System.out.println(pagination_size);
	
	if(pagination_size>=3)
	{
		next.click();
		
		Thread.sleep(2000);
		
		  assertTrue(next_button.isEnabled(), "Next button should be disabled on last page");
	        assertTrue(overall_next_button.isEnabled(), "Overall Next button should be disabled on last page");
	        
	        assertTrue(overall_previous_button.isEnabled(), "Overall Previous button should be disabled on first page");
	        assertTrue(previous_button.isEnabled(), "Previous button should be disabled on first page");
	        
	}
	else
	{
		System.out.println("Pagination is less than 3");
	}
	
	
	}
	
	
	
	public void leave_tracker_filter() throws InterruptedException {
	    
	   
	    String[] filters = {"Casual", "Sick", "LOP", "OPH"};
	    
	    
	    
	    
	    for (String filterValue : filters) {
	        
	        
	        serch_filter.clear();
	        serch_filter.sendKeys(filterValue);
	        
	        Thread.sleep(2000);
	        waitForElementClickable(serch_button);
	        serch_button.click();
	        
	        Thread.sleep(2000);

	        String value = serch_filter.getAttribute("value");
	        System.out.println("\nEntered leave type: " + value);

	    
	      
	        List<WebElement> leaveTypes = driver.findElements(
	            By.xpath("(//div[@id='kt_app_main']//table)[1]//tr//td[2]")
	        );
	        
	        System.out.println(leaveTypes.size());
	        
	        if(leaveTypes.size()==0)
	        	
	        {
	        	Thread.sleep(2000);
	        	WebElement no_data=driver.findElement(By.xpath("//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div[1]"));
	        	assertEquals(no_data.getText().trim(), "No data");
	        
	        } 
	        
	        

	        
	        for (WebElement status : leaveTypes) {
	            String actualText = status.getText().trim();
	            
	            if (!actualText.isEmpty()) {
	                 assertTrue(
	                    actualText.equalsIgnoreCase(value),
	                    "Expected: " + value + " but Found: " + actualText
	                );
	                System.out.println("Matched: " + actualText);
	            }
	            
	            
	        }
	    }
	}
	    public void page_refresh()
	    {
	    	driver.navigate().refresh();
	    }
	

	    
	
	}

