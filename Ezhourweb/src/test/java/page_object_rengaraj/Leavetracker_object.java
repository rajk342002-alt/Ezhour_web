package page_object_rengaraj;



import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import comman_methods.comman_methods;



public class Leavetracker_object extends comman_methods {
WebDriver driver;

double availablecl;
double availablesl;
double oph_available;
	
	public Leavetracker_object(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	 @FindBy(xpath="//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[1]/div/div[2]/div[2]/strong")
	 WebElement causal_leave_available;
	 
	 @FindBy(xpath="//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[1]/div/div[2]/div[2]/span")
	 WebElement causal_leave_total;
	 
	 @FindBy(xpath="//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[1]/div/div[2]/div[1]/div")
	 WebElement causal_leave_text;
	 
	 @FindBy(xpath="//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[1]/div/div[3]/div[2]/strong")
	 WebElement sick_leave_available;
	 
	 @FindBy(xpath="//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[1]/div/div[3]/div[2]/span")
	 WebElement sick_total_leave;
	 
	 @FindBy(xpath="//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[1]/div/div[3]/div[1]/div")
	 WebElement sick_leave_text;

	 @FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/leaves/div/div/div/div/div[1]/div/div[4]/div[2]/strong")
	 WebElement optional_available;
	 
	@FindBy(id = "btn_create_leave")
	WebElement applyleave_button;
		
		
		//apply leave button click
		public void applyleave_button()
		{
			waitForElementClickable(applyleave_button);
			applyleave_button.click();
			
		}
	 
	 public void causalleave_available_total()
	 {
		 waitforElementVisible(causal_leave_available);
		 
		String available_causal= causal_leave_available.getText().trim().split("/")[0].trim();
		waitforElementVisible(causal_leave_total);
		String total_causal=causal_leave_total.getText().trim();
		
		 availablecl=Double.parseDouble(available_causal);
		double total=Double.parseDouble(total_causal);
		
		System.out.println ("Causal leave available: " +availablecl);
		System.out.println("Causal leave total: " +total);
		
		if(availablecl<=total)
		{
			System.out.println("available leave is is not greter then total causall leave");
		}
		
		else
		{
			Assert.fail("Available leave should NOT be greater than total leave!");

	 }
	 }
	 
	 public void sickleavebox_available_total()
	 {
		 waitforElementVisible(sick_leave_available);
	String available_sick= sick_leave_available.getText().split("/")[0].trim();
	waitforElementVisible(sick_total_leave);
		String totalsick= sick_total_leave.getText().trim();
		
	 availablesl=Double.parseDouble(available_sick);
	double total_sick=Double.parseDouble(totalsick);
	System.out.println(availablesl);
	System.out.println(total_sick);
	if(availablesl<=total_sick)
	{
		
		System.out.println("sick leave count is not greater then total sick leave");
	}else
	{
		Assert.fail("sick leave coount is greater then total sick leave");
	}
	 
	 }
	 public void optionalholiday_available_total()
	 {
		 waitforElementVisible(optional_available);
		String available_oph= optional_available.getText().split("/")[0].trim();
		
		double oph_available=Double.parseDouble(available_oph);
		System.out.println("oph available"+oph_available);
		Assert.assertTrue(oph_available<= 1, "Available OPH leave is more than 1!");

	 }
	 
	 
}
