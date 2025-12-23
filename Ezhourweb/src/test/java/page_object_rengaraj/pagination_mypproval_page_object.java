package page_object_rengaraj;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class pagination_mypproval_page_object extends comman_methods {
WebDriver driver;



@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/span[1]")
WebElement total_count;

@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/button[1]")
WebElement overall_previous_button;

@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/button[2]")
WebElement previous_button;

@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/button[3]")
WebElement next_button;

@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/button[4]")
WebElement overall_next_button;

@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div/p-paginator/div/span[2]/button")
List<WebElement> count_size;

@FindBy(xpath = "//button[text()=1]")
WebElement first_number_pagination_box;

@FindBy(xpath = " //span[@class=\"p-paginator-pages ng-star-inserted\"]//button[last()]")
WebElement last_number_pagination_box;

@FindBy(xpath = "//button[contains(@class,\"p-ripple p-element p-paginator-page p-paginator-element p-link\")] ")
List<WebElement> pagination_count;

@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/button[3]")
WebElement next;

	
	
	
	public pagination_mypproval_page_object(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
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
		Thread.sleep(2000);
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
	
	
}
