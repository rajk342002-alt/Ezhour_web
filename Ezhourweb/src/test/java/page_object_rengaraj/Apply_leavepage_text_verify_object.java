package page_object_rengaraj;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import comman_methods.comman_methods;

public class Apply_leavepage_text_verify_object extends comman_methods {
WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/createoreditleave/div[1]/sub-header/div/div/div[1]/h1")
	WebElement addrequest;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/createoreditleave/div[1]/div/div/div/form/div[1]/div/div/label")	
	WebElement selectleavetype;
	
	@FindBy(name="leaveTypeId")
	WebElement dropdownvalue;
	
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoreditleave/div[1]/div/div/div/form/div[2]/label")
	WebElement resontext;
	
	@FindBy(xpath="//*[@id=\"inputGroupFileAddon01\"]")
	WebElement upload;
	
	@FindBy(xpath="//*[@id=\"kt_app_main\"]/div/createoreditleave/div[2]/div/button[1]")
	WebElement cancelbutton;
	
	@FindBy(xpath = "//*[@id=\"kt_app_main\"]/div/createoreditleave/div[2]/div/button[2]")
	WebElement applybutton;
	
	public Apply_leavepage_text_verify_object(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Addrequest_label()
	{
		waitforElementVisible(addrequest);
		String text=addrequest.getText();
	//	System.out.println(" Request" +text);
		assertEquals("Add Request", text);
	}
	public void Leavetype_label_text()
	{
waitforElementVisible(selectleavetype);
		String font=selectleavetype.getText();
		System.out.println("Select Leave Type*" +font);
		assertEquals("Select Leave Type *", font);
	}
	public void Leavetype_dropdown_options_text()
	{
		waitforElementVisible(dropdownvalue);
		dropdownvalue.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		Select typetext=new Select(dropdownvalue);
	List<WebElement> option=typetext.getOptions();
	
	
	List<String> actualresult=new ArrayList<>();
	for(WebElement options : option)
	{
		actualresult.add(options.getText());
	}
	
	List<String> expectedresult=Arrays.asList("Select Leave Type","LOP","Casual","Sick","OPH");
	assertEquals(actualresult, expectedresult);
	System.out.println(actualresult);
	System.out.println(expectedresult);
	}
	
	public void leavereason_text()
	{
		waitforElementVisible(resontext);
	String reason=resontext.getText();
	assertEquals("Reason For Leave *",reason);
	
	}
	
	public void Upload_file_text()
	{
		waitforElementVisible(upload);
		String uploadfile=upload.getText();
		assertEquals("Upload File", uploadfile);
	}
	
	public void cancel_button_text()
	{
		waitforElementVisible(cancelbutton);
		String cancel_text=cancelbutton.getText();
		assertEquals("Cancel", cancel_text);
	}
	public void apply_button_text()
	{ 
		waitforElementVisible(applybutton);
		String apply_text=applybutton.getText();
		assertEquals("Apply", apply_text);
	}
	
	
}
