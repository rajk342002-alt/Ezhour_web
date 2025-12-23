package page_object_rengaraj;

import static org.testng.Assert.assertEquals;

import java.util.List;   // ✅ correct import
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Myapproval_filters {
    WebDriver driver;

    @FindBy(xpath = "//select[@name='filterText']")
    WebElement Leavetype_filter_dropdown;

    @FindBy(xpath = "//div[@id='kt_app_main']//table/tbody/tr/td[3]")
    List<WebElement> leavetype_name;   
    
    
    
//    ----------------------------------------------------
    
    @FindBy(xpath="//*[@id=\"StatusFilterSelect\"]")
    WebElement leave_Status_dropdown;
    
    @FindBy(xpath="//div[@id=\"kt_app_main\"]//table/tbody/tr/td[7]")
    List<WebElement> leavestatus_name;
    
    //-------------------------------------------------------------
    
    @FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/div/div/div[1]")
    WebElement No_data_message;
    
    //------------------------------------------------------------------------------

    
//    Name filter
    
    @FindBy(xpath="//p-dropdown[@optionvalue=\"id\"]")
    WebElement Name_filter;
    
    
    
    
    
    
    
    
    public Myapproval_filters(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void leavetype_dropdown(String leavetype) throws InterruptedException {
    	
        Select select = new Select(Leavetype_filter_dropdown);
        select.selectByVisibleText(leavetype);
        
        Thread.sleep(2000);
        
    int list_count  = leavetype_name.size();
    
    if(list_count==0)
    {
    	assertEquals(No_data_message.getText().trim(), "No data");
    }
    
    else {
        for (WebElement names : leavetype_name) {
            String text = names.getText();
            System.out.println("Leave Type: " + text);
            assertEquals(text, leavetype);
        }
        
        
    }
    }

    public void Back_to_default_leavetype_dropdown()
    {
    	 Select select = new Select(Leavetype_filter_dropdown);
         select.selectByVisibleText("Leave Type");

    }
    
    
    
    
    

    public void leave_status_dropdown_filter(String leave_status) throws InterruptedException {
    	
    	 
    	
        Select select = new Select(leave_Status_dropdown);
        select.selectByVisibleText(leave_status);
        
        Thread.sleep(3000);
        
    int list_count  = leavestatus_name.size();
    
    if(list_count==0)
    {
    	assertEquals(No_data_message.getText().trim(), "No data");
    }
    else {
        
        for (WebElement names : leavestatus_name) {
            String text = names.getText();
            System.out.println("Leave Type: " + text);
            assertEquals(text, leave_status);

        }
    }
    }

  
}
