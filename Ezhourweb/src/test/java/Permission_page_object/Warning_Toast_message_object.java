package Permission_page_object;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Warning_Toast_message_object {
WebDriver driver;

@FindBy(xpath = "//*[@id=\"swal2-html-container\"]")
WebElement available_time_exceed;


@FindBy(xpath = "//*[@id=\"kt_body\"]/div/div/div[6]/button[1]")
WebElement toast_ok_button;



	public Warning_Toast_message_object(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void Available_time_exceed_permission_apply()
	{
		assertEquals(available_time_exceed.getText().trim(), "Enter a time within the available permission time");
	}
	
	
	public void To_time_greater_than_from_time()
	{
		assertEquals(available_time_exceed.getText().trim(), "To time should be greater than From time");

	}
	public void Toast_Message_Ok_button()
	{
		toast_ok_button.click();
	}
	
}
