package Page_object_pricilla;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PermissionsPageObjects {
	
	@FindBy(xpath = "//span[text()='My request']")
	public static WebElement myRequest;
	
	@FindBy(xpath = "//a[@href='/app/main/rubixProduct/permissionRequests']")
	public static WebElement permission;
	
	@FindBy(xpath = "//span[text()='Attendance']")
	public static WebElement attendance;
	
	@FindBy(id = "btn_create_permissionRequest")
	public static WebElement applybtn;
	
	@FindBy(id = "permissionGroup")
	public static WebElement selectPermissionType;
	
	@FindBy(name = "PermissionRequest_PermissionOn")
	public static WebElement permissionDate;
	
	@FindBy(xpath = "//table[@class='days weeks']//tbody//span[text()='20']")
	public static WebElement selectDate;
	
	@FindBy(id = "PermissionRequest_PermissionType")
	public static WebElement specifyPermissionType;
	
	@FindBy(name = "PermissionRequest_FromTime")
	public static WebElement permissionFromTime;
	
	@FindBy(name = "PermissionRequest_ToTime")
	public static WebElement permissionToTime;

	@FindBy(xpath = "//textarea[@name='Reason']")
	public static WebElement permissionReason;
	
	@FindBy(xpath = "//button[@type='submit']//span[text()='Apply']")
	public static WebElement applyPermission;
	
	@FindBy(id = "swal2-html-container")
	public static WebElement errorMsg;
	
	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	public static WebElement okButton;
	
	@FindBy(xpath = "//p[text()=' Pending ']")
	public static WebElement pending;

}
