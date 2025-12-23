package page_object_rengaraj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Dashboard_object extends comman_methods {

WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"#kt_app_sidebar_menu\"]/div[3]/a")
	WebElement dashboard_leavetracker;
	
	
	@FindBy(xpath="//*[@id=\"#kt_app_sidebar_menu\"]/div[3]/div/div/div/a/span[2]")
	WebElement dashboard_leavedetails;
	
	public Dashboard_object(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void leavetrackerclick()
	{
        waitForElementClickable(dashboard_leavetracker);
		dashboard_leavetracker.click();
	}

	public void leavedetailsclick()
	{ 
		waitForElementClickable(dashboard_leavedetails);
		dashboard_leavedetails.click();
	}
	
}
