package Test_file;

import org.testng.annotations.Test;

import Base_file.Launchezhour;
import Pages.Slider_pages;

public class Slider_Screen extends Launchezhour {
	
	@Test
	public void Slider_screen_verify() throws InterruptedException
	{
		Slider_pages slider=new Slider_pages(driver);
		Thread.sleep(3000);
		slider.click_slider_button();
		Thread.sleep(3000);
	}

}
