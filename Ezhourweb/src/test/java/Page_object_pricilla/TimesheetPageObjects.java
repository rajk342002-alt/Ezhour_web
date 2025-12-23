package Page_object_pricilla;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimesheetPageObjects {
	
	@FindBy(xpath = "//span[contains(text(), 'Time tracker')]")
	public static WebElement timeTracker;
	
	@FindBy(xpath = "//span[contains(text(), 'Timesheet Details')]")
	public static WebElement timeSheetDetails;
	
	@FindBy(xpath = "//select[@formcontrolname='projectId']")
	public static WebElement selectProject;
	
	@FindBy(xpath = "//select[@formcontrolname='taskGroupDetailId']")
	public static WebElement selectTask;
	
	@FindBy(xpath = "//input[@class='form-control weekday-sun ng-untouched ng-pristine ng-valid']//following::input[@formcontrolname='hourinString' and @class='form-control ng-untouched ng-pristine ng-valid'][1]")
	public static WebElement mon;
	
	@FindBy(xpath = "//input[@class='form-control weekday-sun ng-untouched ng-pristine ng-valid']//following::input[@formcontrolname='hourinString' and @class='form-control ng-untouched ng-pristine ng-valid'][1]")
	public static WebElement tue;
	
	@FindBy(xpath = "//input[@class='form-control weekday-sun ng-untouched ng-pristine ng-valid']//following::input[@formcontrolname='hourinString' and @class='form-control ng-untouched ng-pristine ng-valid'][1]")
	public static WebElement wed;
	
	@FindBy(xpath = "//input[@class='form-control weekday-sun ng-untouched ng-pristine ng-valid']//following::input[@formcontrolname='hourinString' and @class='form-control ng-untouched ng-pristine ng-valid'][1]")
	public static WebElement thurs;
	
	@FindBy(xpath = "//input[@class='form-control weekday-sun ng-untouched ng-pristine ng-valid']//following::input[@formcontrolname='hourinString' and @class='form-control ng-untouched ng-pristine ng-valid'][1]")
	public static WebElement fri;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement submitButton;
	
	@FindBy(xpath = "//a[@class='float-end']")
	public static WebElement closeBtn;
	
	@FindBy(xpath = "//div[contains(@class, 'pending')]")
	public static WebElement notSubmitted;
	
	@FindBy(xpath = "//button[contains(@class, 'next-btn')]")
	public static WebElement nextMnth;

}
