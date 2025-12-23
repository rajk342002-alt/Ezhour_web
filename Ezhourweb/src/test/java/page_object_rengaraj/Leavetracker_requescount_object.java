package page_object_rengaraj;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Leavetracker_requescount_object extends comman_methods {
    WebDriver driver;
    String listview_request_date;

    public Leavetracker_requescount_object(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(xpath="//div[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[2]/div/p-table/div/div/table/tbody/tr")
    List <WebElement> leavedetails_list_count;
    
    @FindBy(xpath="//span[@id=\"pr_id_9_label\"]")
    WebElement set_count;
   
    
    public void listcount()
    {
    	
    	int count=leavedetails_list_count.size();
    	String count_set_value=set_count.getText();
    	int setcount=Integer.parseInt(count_set_value);
    	System.out.println(setcount);
    	
    	
    System.out.println(count);
    
    if(count<=setcount) {
    	assertTrue(true);
    }
    else {
    	assertFalse(false);
    }
    }
    
    public void scroll()
    {
    	JavascriptExecutor executor=(JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].scrollIntoView(true);", set_count);
    }
    
    
    }

   
