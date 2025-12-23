package Test_file;

import org.testng.annotations.Test;

import Base_file.Launchezhour;
import Pages.Loginpage_page;
import Pages.Slider_pages;

public class Loginpage extends Launchezhour {

	@Test 
	public void login() throws InterruptedException
	{
		Slider_pages slider=new Slider_pages(driver);
		Thread.sleep(3000);
		slider.click_slider_button();
		Thread.sleep(2000);
		Loginpage_page login=new Loginpage_page(driver);
		login.Usermail();
		Thread.sleep(2000);
		login.usermail_next();
		Thread.sleep(2000);
		login.password();
		login.click_login_button();
		Thread.sleep(2000);
	}
	
}
