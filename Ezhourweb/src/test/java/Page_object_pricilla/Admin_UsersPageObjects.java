package Page_object_pricilla;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admin_UsersPageObjects {
	
	WebDriver driver;

	private static final Logger logger = LogManager.getLogger(Admin_UsersPageObjects.class);


    public Admin_UsersPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//button[text()=' Organization Setup ']")
	public WebElement orgSetup;
	
	@FindBy(xpath = "//h5[text()='Users']")
	public WebElement users;
	
	@FindBy(xpath = "//tbody//tr//following::a[@target='_blank']")
	public List<WebElement> userList;
	
	@FindBy(xpath = "//span[text()=' Create new user ']")
	public WebElement createUserBtn;
	
	@FindBy(xpath = "//div[@class='modal-header']//following-sibling::span[text()='Create new user']")
	public WebElement createUserModal;
	
	@FindBy(id = "Name")
	public WebElement firstName;
	
	@FindBy(id = "Surname")
	public WebElement Surname;
	
	@FindBy(id = "EmailAddress")
	public WebElement EmailAddress;
	
	@FindBy(id = "PhoneNumber")
	public WebElement PhoneNumber;
	
	@FindBy(id = "UserName")
	public WebElement UserName;
	
	@FindBy(xpath = "//tab[contains(@class,'tab-pane') and contains(@class,'active')]//button[contains(@class,'btn-primary')]//span[text()='Next']")
	public WebElement next;
	
	@FindBy(xpath = "//tab[contains(@class, 'tab-pane') and contains(@class,'active')]//label")
	public List<WebElement> roles;
	
	@FindBy(xpath = "//span[@class='form-check-label' and text()=' User ']")
	public WebElement userLabel;
	
	@FindBy(id = "OrganizationUnitsTreeFilter")
	public WebElement orgUnitTreeFilter;
	
	@FindBy(xpath = "//tab[contains(@class,'tab-pane') and contains(@class,'active')]//span[@class='p-treenode-label']")
	public List<WebElement> searchResults;
	
	@FindBy(xpath = "//tab[contains(@class,'tab-pane') and contains(@class,'active')]//label[@for='UserName']//following::p[contains(@class,'form-select')]")
	public WebElement userFullName;
	
	@FindBy(name = "userDetail.reporteeId")
	public WebElement reportingToDD;
	
	@FindBy(name = "userDetail.designationId")
	public WebElement designationDD;
	
	@FindBy(id = "UserDetail_EmployeeId")
	public WebElement employeeID;
	
	@FindBy(id = "UserDetail_DateOfJoin")
	public WebElement dateOfJoin;
	
	@FindBy(id = "UserDetail_DateOfRelease")
	public WebElement dateOfRelease;
	
	@FindBy(xpath = "//tab[contains(@class,'tab-pane') and contains(@class,'active')]//preceding::button[@aria-label='Close'][1]")
	public WebElement closeBtnPopup;
	
	@FindBy(xpath = "//tab[contains(@class,'tab-pane') and contains(@class,'active')]//span[text()='Save']")
	public WebElement saveBtn;
	
	@FindBy(name = "filterText")
	public WebElement searchEmail;
	
	@FindBy(xpath = "//tbody//tr//td[span[text()='Email address']]")
	public WebElement existingEmailID;
	
	@FindBy(id = "dropdownButton")
	public WebElement actionsBtn;
	
	@FindBy(xpath = "//li//a[text()=' Delete ']")
	public WebElement delete;
	
	@FindBy(xpath = "//li//a[text()=' Login as this user ']")
	public WebElement loginAsThisUser;
	
	@FindBy(xpath = "//button[text()='Yes']")
	public WebElement yesBtn;
	
	@FindBy(id = "swal2-html-container")
	public WebElement warningPopup;
	
	@FindBy(xpath = "//button[text()='Ok']")
	public WebElement okBtn;
	
	@FindBy(xpath = "//*[@id='kt_quick_user_toggle']//following::span[contains(@class, 'logged-user')]")
	public WebElement loggedUser;
	
	@FindBy(xpath = "//a[text()=' Back to my account ']")
	public WebElement backToMyAcc;
	
	@FindBy(id = "EditUser_SetRandomPassword")
	public WebElement setRandomPasswordCheckbox;
	
	@FindBy(xpath = "//label//span[text()=' Set random password. ']")
	public WebElement setRandomPassword;
	
	@FindBy(id = "Password")
	public WebElement PasswordField;
	
	@FindBy(id = "PasswordRepeat")
	public WebElement PasswordRepeatField;
	
	@FindBy(id = "EditUser_IsActive")
	public WebElement activeCheckbox;
	
	@FindBy(xpath = "//ul[contains(@class, 'text-danger')]//li[text()=' Passwords must be at least 6 characters. ']")
	public WebElement pswdCharactersErrorMsg;
	
	@FindBy(xpath = "//ul[contains(@class, 'text-danger')]//li[text()=' Passwords do not match! ']")
	public WebElement pswdLengthMatchError;
	

	public void fillUserInformation(String first_Name, String surName, String emailAddress, String phone, String username) throws InterruptedException {
		
		firstName.sendKeys(first_Name);
		Surname.sendKeys(surName);
		EmailAddress.sendKeys(emailAddress);
		PhoneNumber.sendKeys(phone);
		UserName.sendKeys(username);
		Thread.sleep(5000);
	}

	public void selectRole(String role) throws InterruptedException {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(userLabel)).click();
				
		for (WebElement roleName : roles) {
			
			String roleType = roleName.getText();
			if (roleType.equalsIgnoreCase(role.trim())) {
				System.out.println(roleType + "matches");				
	            roleName.click(); 
	            break;
	        }			
		}				
	}

	public void selectOrganizationUnit(String unitName) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(orgUnitTreeFilter)).click();
		wait.until(ExpectedConditions.visibilityOf(orgUnitTreeFilter)).sendKeys(unitName);
		
		for (WebElement units : searchResults) {
			
			String unit_name = units.getText();
			if(unit_name.equalsIgnoreCase(unitName.trim())) {
				units.click();
				break;
			}
		}			
	}

	public void fillUserDetails(String fullName, String reportingTo, String designation, String empID, String joinDate,
			String exitDate) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(userFullName));
		Thread.sleep(5000);
		String full_name = userFullName.getText();
		Assert.assertEquals(full_name, fullName);
		System.out.println("Full Name verified");
		Select selectReportee = new Select(reportingToDD);
		selectReportee.selectByVisibleText(reportingTo);
		Select selectDesignation = new Select(designationDD);
		selectDesignation.selectByVisibleText(designation);
		employeeID.sendKeys(empID);
		dateOfJoin.sendKeys(joinDate);
		dateOfRelease.sendKeys(exitDate);
		saveBtn.click();
	}

	public boolean checkIfUserAlreadyExists(String emailAddress) throws InterruptedException {
		
		try {
			searchUser(emailAddress);
			Thread.sleep(3000);
			String id = existingEmailID.getText();
			Assert.assertEquals(id, emailAddress);	
			if (id.equalsIgnoreCase(emailAddress)) {
		            return true;
		        }
		} catch (Exception e) {
			System.out.println("User does not exist. Let's create a new user with User ID : " + emailAddress);
		}
			
		return false;
	}

	public void checkUserCreated(String emailAddress) throws InterruptedException {
		
		searchUser(emailAddress);
		Thread.sleep(3000);
		String id = existingEmailID.getText();
		Assert.assertEquals(id, emailAddress);	
		if (id.equalsIgnoreCase(emailAddress)) {
	            System.out.println("User with ID : "+emailAddress+" is found.");
	    }		
	}

	public void searchUserAndDelete(String emailAddress) {
		try {
			searchUser(emailAddress);
			Thread.sleep(3000);
			String id = existingEmailID.getText();
			Assert.assertEquals(id, emailAddress);	
			if (id.equalsIgnoreCase(emailAddress)) {
		            actionsBtn.click();
		            delete.click();
		            Assert.assertTrue(warningPopup.isDisplayed(), "Popup is not displayed");
		            yesBtn.click();
		            System.out.println("User with ID : "+emailAddress+" is deleted");
		        }
		} catch (Exception e) {
			System.out.println("User does not exist with ID " + emailAddress);
		}
		
	}

	public void searchUserMappedToProjectsAndDelete(String emailAddress) {
		try {
			searchUser(emailAddress);
			Thread.sleep(3000);
			String id = existingEmailID.getText();
			Assert.assertEquals(id, emailAddress);	
			if (id.equalsIgnoreCase(emailAddress)) {
		            actionsBtn.click();
		            delete.click();
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    		wait.until(ExpectedConditions.visibilityOf(warningPopup));
		            Assert.assertTrue(warningPopup.isDisplayed(), "Popup is not displayed");
		            String text = warningPopup.getText();
		            Assert.assertEquals(text, "The SPOC you are trying to delete is already mapped to an existing project so it cannot be deleted at this time.");
		            okBtn.click();
		            System.out.println("User with ID : "+emailAddress+" is already mapped to an existing project so it cannot be deleted at this time.");
		        }
		} catch (Exception e) {
			logger.error("User does not exist with ID {}", emailAddress, e);
		}		
	}

	public void searchUserAndClickLoginAsThisUser(String user, String tenantNAME, String userNAME) {
		try {
			searchUser(user);
			Thread.sleep(3000);
			String id = existingEmailID.getText();
			Assert.assertEquals(id, user);	
			if (id.equalsIgnoreCase(user)) {
		            actionsBtn.click();
		            loginAsThisUser.click();
		            removeTenant(tenantNAME);
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		            wait.until(ExpectedConditions.urlContains("https://qa.ezhour.com/app/main/dashboard"));		            
		            String name = wait.until(ExpectedConditions.visibilityOf(loggedUser)).getText();
		            Assert.assertEquals(name, userNAME);
		            logger.info("{} has been logged in successfully", user);
		        }
		} catch (Exception e) {
			logger.error("User does not exist with ID {}", user, e);
		}		
	}
	
	public void searchUser(String user)
	{
		searchEmail.clear();
		searchEmail.sendKeys(user + Keys.ENTER);
	}
	public void removeTenant(String tenantNAME)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(tenantNAME+".qa.ezhour.com"));				
        String currentURL = driver.getCurrentUrl();
        String updatedURL = currentURL.replace(tenantNAME+".", "");
        driver.get(updatedURL);
	}

	public void backToAdminAccount(String tenantNAME) {
		try {
			loggedUser.click();
			backToMyAcc.click();
			removeTenant(tenantNAME);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.urlContains("https://qa.ezhour.com/app/main/dashboard"));		            
	        String name = wait.until(ExpectedConditions.visibilityOf(loggedUser)).getText();
	        Assert.assertEquals(name, "Hi, admin admin");
	        logger.info("User is navigated back to Admin's account successfully");			
		} catch (Exception e) {
			logger.error(e);
		}
		
	}

	public void setRandomPassword(String setPassword, String password, String passwordRepeat) {
		
		boolean results = setRandomPasswordCheckbox.isSelected();
		System.out.println(results);
		
		try {
			if(results==true && setPassword.contains("Yes"))
			{				
				logger.info("Random password will be set for this user");
			}
			else
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable(setRandomPasswordCheckbox)).click();
				PasswordField.sendKeys(password);
				PasswordRepeatField.sendKeys(passwordRepeat);
				
				if(password.length()<6 && passwordRepeat.length()<6)
				{
					Assert.assertEquals(pswdCharactersErrorMsg.getText(), "Passwords must be at least 6 characters.");
					logger.error("Passwords must be at least 6 characters for Password field.");
					Assert.assertEquals(pswdCharactersErrorMsg.getText(), "Passwords must be at least 6 characters.");
					logger.error("Passwords must be at least 6 characters for Repeat Password field.");
					Assert.assertEquals(pswdLengthMatchError.getText(), "Passwords do not match!");
					logger.error("Passwords do not match!");
					closeBtnPopup.click();
				}
				else if(password.length()>=6 && passwordRepeat.length()>=6 && !password.equals(passwordRepeat))
				{
					Assert.assertEquals(pswdLengthMatchError.getText(), "Passwords do not match!");
					logger.error("Passwords do not match!");
					closeBtnPopup.click();
				}
				else if(password.length()>=6 && passwordRepeat.length()<6)
				{
					Assert.assertEquals(pswdCharactersErrorMsg.getText(), "Passwords must be at least 6 characters.");
					logger.error("Passwords must be at least 6 characters for Password field.");
					Assert.assertEquals(pswdLengthMatchError.getText(), "Passwords do not match!");
					logger.error("Passwords do not match!");
					closeBtnPopup.click();
				}
				else if(password.length()<6 && passwordRepeat.length()>=6)
				{
					Assert.assertEquals(pswdCharactersErrorMsg.getText(), "Passwords must be at least 6 characters.");
					logger.error("Passwords must be at least 6 characters.");
					Assert.assertEquals(pswdLengthMatchError.getText(), "Passwords do not match!");
					logger.error("Passwords do not match!");
					closeBtnPopup.click();
				}
				else
				{
					logger.info("Passwords entered successfully");
				}
			}
			
		} catch (Exception e) {
		    logger.error("Exception occurred: " + e.getMessage());
		    throw e;
		}	
	}

	public void userStatus(String active) {
		
		boolean results = activeCheckbox.isSelected();
		System.out.println(results);
		
		try {
			if(results==true && active.contains("Yes"))
			{				
				logger.info("User is marked as active");
			}
			else
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable(activeCheckbox)).click();
				logger.info("User is marked as inactive");
			}
			
		} catch (Exception e) {
			logger.error(e);
		}	
	}

	public void clickNextBtn() {
			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
		wait.until(ExpectedConditions.visibilityOf(next)).click();
		wait.until(ExpectedConditions.elementToBeClickable(next)).click();		
	}	
}
