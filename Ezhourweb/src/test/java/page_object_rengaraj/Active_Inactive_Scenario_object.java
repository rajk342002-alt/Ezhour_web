package page_object_rengaraj;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;

public class Active_Inactive_Scenario_object extends comman_methods {

	WebDriver driver;
	String serch_Value;
	
	@FindBy(xpath="//span[text()=\"Administration\"]")
	WebElement administration;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/app-setting-notification/div/div/div/div[3]/div/div/div/div[4]/div")
	WebElement User_box;
	
	@FindBy(xpath="//button[text()=\" Organization Setup \"]")
	WebElement organization_setup;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/form/div/div[1]/div/div/div/input")
	WebElement search_box;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/div/div/div/form/div/div[1]/div/div/div/button")
	WebElement serch_button;
	
	@FindBy(xpath = "//div[@id=\"kt_app_main\"]//table//tbody/tr[1]/td[1]")
	WebElement username;
	
	@FindBy(xpath="//div[@id=\"kt_app_main\"]//table//tbody/tr[1]/td[4]")
	WebElement mail;
	
	@FindBy(xpath="//div[@id=\"kt_app_main\"]//table//tbody/tr[1]/td[5]/span[2]")
	WebElement Active_status;
	
	@FindBy(xpath = "//div[@id=\"kt_app_main\"]//table//tbody/tr[1]/td[6]/div/button")
	WebElement action_button;
	
	@FindBy(xpath="//a[text()=\" Edit \"]")
	WebElement edit_option;
	
	@FindBy(xpath="//input[@id=\"EditUser_IsActive\"]")
	WebElement active_inactive_checkbox;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/createoreditusermodal/div/div/div/form/div[2]/tabset/div/tab[1]/ul/li[4]")
	WebElement active_inactive_scroll;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/createoreditusermodal/div/div/div/form/div[2]/tabset/div/tab[1]/div[5]/button[2]")
	WebElement next_button;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/createoreditusermodal/div/div/div/form/div[2]/tabset/div/tab[2]/div[2]/button[2]")
	WebElement next_button_role_page;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/createoreditusermodal/div/div/div/form/div[2]/tabset/div/tab[3]/div/button[2]")
	WebElement next_button_permission_page;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/ng-component/div/createoreditusermodal/div/div/div/form/div[2]/tabset/div/tab[4]/app-user-details-modal/form/button")
	WebElement save_button;
	
	@FindBy(xpath="//*[@id=\"swal2-html-container\"]/span")
	WebElement toastmessage;
	
	@FindBy(xpath = "//*[@id=\"swal2-html-container\"]")
	WebElement login_page_inactive_Warning_message;
	
	@FindBy(xpath="//*[@id=\"kt_body\"]/div[2]/div/div[6]/button[1]")
	WebElement warning_message_ok_button;
	
	@FindBy(xpath = "//*[@id=\"kt_body\"]/app-root/ng-component/div/div/div[2]/div/div/div/div/ng-component/div[1]/form/div[1]/input")
	WebElement email_input;
	
	@FindBy(xpath="//*[@id=\"kt_body\"]/app-root/ng-component/div/div/div[2]/div/div/div/div/ng-component/div[1]/form/div[2]/input")
	WebElement password_input;
	
	
	public Active_Inactive_Scenario_object(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void click_administration()
	{
		waitforElementVisible(administration);
		administration.click();
	}
	
	public void Click_organization_setup()
	{
		waitforElementVisible(organization_setup);
		organization_setup.click();
	}
	
	public void Click_user()
	{
		waitforElementVisible(User_box);
		User_box.click();
	}
	
	public void Enter_search_box(String usermail)
	{
		search_box.sendKeys(usermail);
		serch_button.click();
	}
	
	public void verify_userdetails()
	{
	 serch_Value=	search_box.getAttribute("value");
	System.out.println("Serch mail: "+serch_Value);
	String username_list=username.getText();
	System.out.println("List name: "+username_list);
	assertTrue(serch_Value.equals(username_list), "Search username and list username is mismatched");
		
	}
	
	public void In_active_scenario() throws InterruptedException
	{
		String status=Active_status.getText();
		System.out.println("Status: "+status);
		
		if(status.endsWith("Yes"))
		{
			waitforElementVisible(action_button);
			Thread.sleep(2000);
			action_button.click();
			waitforElementVisible(edit_option);
			edit_option.click();
			waitforElementVisible(active_inactive_scroll);
			scroll(active_inactive_scroll);
			waitforElementVisible(active_inactive_checkbox);
			active_inactive_checkbox.click();
			waitForElementClickable(next_button);
			next_button.click();
			waitforElementVisible(next_button_role_page);
			next_button_role_page.click();
			scroll(next_button_permission_page);
			next_button_permission_page.click();
			save_button.click();
			assertEquals(toastmessage.getText().trim(), "Submitted successfully.");
			
			
		}
	}
	
	public void login_inactive_Warning_verify()
	{
		waitforElementVisible(login_page_inactive_Warning_message);
		assertEquals(login_page_inactive_Warning_message.getText().trim(), "User " +serch_Value+ " is not active and can not log in.");
	warning_message_ok_button.click();
	
	}
	
	public void active_scenario() throws InterruptedException
	{
		String status=Active_status.getText();
		System.out.println("Status: "+status);
		
		if(status.endsWith("No"))
		{
			waitforElementVisible(action_button);
			Thread.sleep(2000);
			action_button.click();
			waitforElementVisible(edit_option);
			edit_option.click();
			waitforElementVisible(active_inactive_scroll);
			scroll(active_inactive_scroll);
			waitforElementVisible(active_inactive_checkbox);
			active_inactive_checkbox.click();
			next_button.click();
			next_button_role_page.click();
			scroll(next_button_permission_page);
			next_button_permission_page.click();
			save_button.click();
			assertEquals(toastmessage.getText().trim(), "Submitted successfully.");
			
			
		}
	}
	
	public void clear_mail_password()
	{
		email_input.clear();
		password_input.clear();
	}
	
}
