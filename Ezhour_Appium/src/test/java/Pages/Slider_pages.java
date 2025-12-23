package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Slider_pages {
	AndroidDriver driver;
	
	@AndroidFindBy(accessibility = "Optimize\\nWorkers\\nHR management made easily, organize \\n your daily working routine easily")
	WebElement First_Screen_content;
	
	@AndroidFindBy(accessibility = "SKIP")
	WebElement First_screen_Skip_button;
	
	
	@AndroidFindBy(accessibility = "Keep\\nhealthy\\nwork-life\\nbalance\\nTry to spend some time thinking")
	WebElement Second_screen_content;
	
	@AndroidFindBy(accessibility = "SKIP")
	WebElement second_screen_skip_button;
	
	
	
	@AndroidFindBy(accessibility = "GET STARTED")
	WebElement Get_Started_button;

	public Slider_pages(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void Screen_one()
	{
	String actual_message=	First_Screen_content.getAttribute("content-desc");
	System.out.println("Scre en 1: "+actual_message);
//String	Expected_message="Optimize \nWorkers\n"+
//	"HR management made easily, organize \n"+
//		"your daily working routine easily";
//	assertEquals(actual_message, Expected_message);
	}
	
	public void screen_two()
	{
		String actual_message=Second_screen_content.getAttribute("content-desc");
//		String Expected_message="Keep\\nhealthy\\nwork-life\\nbalance\\nTry to spend some time thinking"
		System.out.println("screen 2: " +actual_message);
	}
	
	public void screen_three()
	{
//		String actual_message=Third_screen_content.getAttribute("content-desc");
//		System.out.println("screen 3: "+actual_message);
	}
	
	public void click_slider_button()
	{
		Get_Started_button.click();
	}
	
}
