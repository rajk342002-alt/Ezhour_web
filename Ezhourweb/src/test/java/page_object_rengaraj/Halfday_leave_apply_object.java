package page_object_rengaraj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Halfday_leave_apply_object {
	
	WebDriver driver;
	
	@FindBy(id="leaveModeSelect")
	WebElement halfdaydropdown;
	
	
	public Halfday_leave_apply_object(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void halfday(int half) throws InterruptedException
	{
		Thread.sleep(2000);
	 halfdaydropdown.click();
		
		Select select=new Select(halfdaydropdown);
		select.selectByIndex(half);
	}

}
