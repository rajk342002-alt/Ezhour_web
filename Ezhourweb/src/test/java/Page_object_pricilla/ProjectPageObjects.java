package Page_object_pricilla;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProjectPageObjects {
	
	WebDriver driver;
	
	public ProjectPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // if you're using PageFactory
    }
	
	@FindBy(xpath = "//button[@id='btn_create_project']")
	public static WebElement createProject;
	
	@FindBy(id = "Project_Name")
	public static WebElement projectName;
	
	@FindBy(id = "Project_Description")
	public static WebElement projectDescription;
	
	@FindBy(xpath = "//select[@formcontrolname='projectType']")
	public static WebElement projectType;
	
	@FindBy(xpath = "//select[@formcontrolname='projectTaskGroup']")
	public static WebElement projectTaskGroup;
	
	@FindBy(xpath = "//select[@formcontrolname='projectClient']")
	public static WebElement projectClient;
	
	@FindBy(id = "Project_ClientSpoc")
	public static WebElement projectSpoc;
	
	@FindBy(id = "Project_Email")
	public static WebElement projectEmail;
	
	@FindBy(id = "Project_ReleaseDate")
	public static WebElement projectReleaseDate;
	
	@FindBy(id = "Project_Status")
	public static WebElement projectStatus;
	
	@FindBy(id = "activeFrom")
	public static WebElement activeFrom;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	public static WebElement enforceTimesheet;
	
	@FindBy(id = "Project_UploadFile")
	public static WebElement projectUpload;
	
	@FindBy(xpath = "//button[@type='button']//following::span[text()='Next']")
	public static WebElement nextBtn;
	
	@FindBy(xpath = "//button[@type='button' and @class= 'next']")
	public static WebElement nextBtnCal;
	
	@FindBy(xpath = "//table[@class='days weeks']//tbody//span[text()='10']")
	public static WebElement selectDate;
	
	@FindBy(xpath = "//input[@placeholder='Search Member']")
	public static WebElement searchMember;
	
	@FindBy(id = "dateOfJoin")
	public static WebElement startDate;
	
	@FindBy(xpath = "//table[@class='days weeks']//tbody//span[text()='1']")
	public static WebElement selectJoinDate;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	public static WebElement checkMember;
	
	@FindBy(id = "project.projectHead")
	public static WebElement clickProjHeadDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[@role='listbox']//span[text()='RBX10146 - Madhankumar Murugan']")
	public static WebElement selectProjectHead;
	
	@FindBy(xpath = "//div[@class='row container']//following::p[@type='text']")
	public static WebElement reviewProjectDetails;
	
	@FindBy(xpath = "//button[@type='button']//following::span[text()='Save']")
	public static WebElement saveBtn;

	public void selectFutureDate() {
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 	
	wait.until(ExpectedConditions.visibilityOf(projectReleaseDate)).click();
	nextBtnCal.click();
	selectDate.click();
				
	}

	public void searchAndSelectMembers() {
		
		
		String[] memberIds = {"RBX10175", "RBX10147", "RBX10146", "RBX10100", "RBX10182"};

		for (String id : memberIds) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    wait.until(ExpectedConditions.visibilityOf(searchMember));
		    searchMember.clear();
		    searchMember.sendKeys(id);
		    startDate.click();
		    selectJoinDate.click();
		    checkMember.click();
		}

	}

	public void reviewProject() {
		
		List<WebElement> projectDetails = driver.findElements(By.xpath("//div[@class='row container']//following::p[@type='text']"));
		
		List<String> expected = Arrays.asList(
			    "BambooHR",
			    "BambooHR is a cloud-based Human Resources (HR) software platform designed for small and medium-sized businesses.", 
			    "Non Billable", 
			    "IT", 
			    "BambooHR", 
			    "Charles Neuman", 
			    "charles.neuman@bamboohr.com", 
			    "10 Sep 2025", 
			    "Active", 
			    "RBX10146 - Madhankumar Murugan" //, , , , , , , , , , 
			);
		
		List<String> actual = new ArrayList<>();
		
		for (WebElement webElement : projectDetails) {
			
			String text = webElement.getText();
			actual.add(text);			
		}
		
		for (int i = 0; i < expected.size(); i++) {
			
		    Assert.assertEquals(actual.get(i), expected.get(i), "Mismatch at index " + i);
		}

		
	}

}
