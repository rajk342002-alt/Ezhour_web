package Page_object_pricilla;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AttendanceViewPageObjects {
	
	@FindBy(xpath = "//div[@id='kt_app_main' ]//div[text()=' No data ']")
	public static WebElement noData;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']//th[text()=' Employee ']")
	public static WebElement col_employee;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']//th[text()=' Permission Type ']")
	public static WebElement col_permissiontype;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']//th[text()=' Time Period ']")
	public static WebElement col_timePeriod;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']//th[text()=' Hours Taken ']")
	public static WebElement col_hoursTaken;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']//th[text()=' Date ']")
	public static WebElement col_date;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']//th[text()=' Status ']")
	public static WebElement col_status;
	
	@FindBy(xpath = "//button[contains(@class, 'prev-btn')]")
	public static WebElement prev_btn;
	
	@FindBy(xpath = "//button[contains(@class, 'next-btn')]")
	public static WebElement next_btn;
	
	@FindBy(xpath = "//input[contains(@name,'date')]")
	public static WebElement monthName;
	
	
	public static boolean verifyEmployeeCol() {
		return col_employee.isDisplayed();		
	}
	
	public static boolean verifyPermissionTypeCol() {
		return col_permissiontype.isDisplayed();		
	}
	
	public static boolean verifyTimePeriodCol() {
		return col_timePeriod.isDisplayed();
	}
	
	public static boolean verifyHoursTakenCol() {
		return col_hoursTaken.isDisplayed();
	}
	
	public static boolean verifyDateCol() {
		return col_date.isDisplayed();
	}
	
	public static boolean verifyStatusCol() {
		return col_status.isDisplayed();
	}

}
