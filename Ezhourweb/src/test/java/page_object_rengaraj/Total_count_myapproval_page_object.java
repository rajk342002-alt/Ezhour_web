package page_object_rengaraj;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.launchezhour;
import comman_methods.comman_methods;

public class Total_count_myapproval_page_object extends comman_methods {

	
WebDriver driver;
	
	public Total_count_myapproval_page_object(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	@FindBy(xpath = "/html/body/app-root/ng-component/div/div/default-layout/div/div/div[2]/div[2]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/p-dropdown/div/span")
	WebElement countset_dropdown;
	
	@FindBy(xpath = "//span[text()=\"500\" and @class=\"ng-star-inserted\" ]")
	WebElement count_500;
	
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div/p-paginator/div/span[1]")
	WebElement total_count_display;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]//table/tbody/tr")
	List<WebElement> list_request_size;
	
	@FindBy(xpath="(//div[@id=\"kt_app_main\"]//table/tbody/tr)[last()]")
	WebElement list_request_size_last;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/div/p-paginator/div/button[3]")
	WebElement nextbutton;
	
	
	
	public void scroll_bottom() throws InterruptedException
	{
		scroll(countset_dropdown);
		
	}
	
	public void count_dropdown_click() throws InterruptedException
	{
		Thread.sleep(2000);
		countset_dropdown.click();
	}
	
	public void click_500()
	{
		scroll(count_500);
		waitForElementClickable(count_500);
		count_500.click();
	}
	
	
	public void total_count_verify() throws InterruptedException
	{
		int count=list_request_size.size();
		System.out.println("List count size" +count);
		
		String total_count=total_count_display.getText().trim();
		String[] split=total_count.split(":");
		
	String total=split[0];
		int total_number=Integer.parseInt(split[1].trim());
		
		if(count>=500)
		{
			nextbutton.click();
			Thread.sleep(3000);
		int count_next=	list_request_size.size();
		int add=count_next+500;
		
		
		Thread.sleep(2000);

		scroll(list_request_size_last);
		assertEquals(total_number, add);
		}
		
		else {
		
			Thread.sleep(2000);
			
			System.out.println("Total request count: "+count+  "  Total: "+total_number);

			scroll(list_request_size_last);
			
		    assertEquals(count, total_number);
		     }
		
	
	}
}
