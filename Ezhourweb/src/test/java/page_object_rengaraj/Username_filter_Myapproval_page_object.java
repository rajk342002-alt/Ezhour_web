package page_object_rengaraj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Username_filter_Myapproval_page_object extends comman_methods {

	WebDriver driver;
	
	
	public Username_filter_Myapproval_page_object(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/form/div/div/div[1]/p-dropdown/div")
	WebElement name_filter_box;
	
	@FindBy(xpath="//p-dropdownitem[2]")
	WebElement dropdown_user_name_list;
	
	
	public void user_name_filter_box_click()
	{
		name_filter_box.click();
	}
	
	public void username_click()
	{
		dropdown_user_name_list.click();
	}
	
	public void getoption()
	{
		name_filter_box.getText();
	}
	
}
