package page_object_rengaraj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Logout_object extends comman_methods{

	WebDriver driver;
	
	@FindBy(xpath="//div[@id=\"kt_quick_user_toggle\"]/div/span")
	WebElement click_username_header;
	
	@FindBy(xpath="//span[text()=\" Logout \"]")
	WebElement logout_button;
	
	public Logout_object(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void click_username() throws InterruptedException
	{
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		action.moveToElement(click_username_header).click().build().perform();
	}
	public void click_logout_button()
	{
		waitForElementClickable(logout_button);
		logout_button.click();
	}
	
}

