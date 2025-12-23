package Pricilla_test_files;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page_object_pricilla.Admin_UsersPageObjects;
import Page_object_pricilla.DashboardPageObjects;
import ezhourweb.testComponents.BaseTestAdmin;
import utils.TestDataProvider;

public class Admin_UsersPageTests extends BaseTestAdmin {
	
	
	@Test(dataProvider = "newUserData", dataProviderClass = TestDataProvider.class)
	public void createNewUser(String first_Name, String surName, String emailAddress, String phone, String username, String setPassword, String password, String passwordRepeat, String active, String role, String unitName, String fullName, String reportingTo, String designation, String empID, String joinDate, String exitDate) throws InterruptedException {
		
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.administration)).click();
		Admin_UsersPageObjects users = new Admin_UsersPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(users.orgSetup)).click();
		wait.until(ExpectedConditions.visibilityOf(users.users)).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(users.userList));
		
		if(users.checkIfUserAlreadyExists(emailAddress)) {
			System.out.println(emailAddress + " already exists");
		}
		
		else {
			wait.until(ExpectedConditions.elementToBeClickable(users.createUserBtn)).click();
			wait.until(ExpectedConditions.visibilityOf(users.createUserModal));
			Assert.assertTrue(users.createUserModal.isDisplayed(), "Create new user modal is not displayed");
			users.fillUserInformation(first_Name, surName, emailAddress, phone, username);
			users.setRandomPassword(setPassword, password, passwordRepeat);
			users.userStatus(active);
			users.clickNextBtn();
			wait.until(ExpectedConditions.visibilityOfAllElements(users.roles));
			users.selectRole(role);
			users.clickNextBtn();
			users.selectOrganizationUnit(unitName);
			users.clickNextBtn();
			users.fillUserDetails(fullName, reportingTo, designation, empID, joinDate, exitDate);
			users.checkUserCreated(emailAddress);
		}
	}
	
	@DataProvider(name = "deleteUsers")
    public Object[][] Users(){
    	
    	return new Object[][] {
    		{"selwyn.tay@rubixtek.com"},
    	};
    }
	@Test(dataProvider = "deleteUsers")
	public void deleteUser(String emailAddress)
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.administration)).click();
		Admin_UsersPageObjects users = new Admin_UsersPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(users.orgSetup)).click();
		wait.until(ExpectedConditions.visibilityOf(users.users)).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(users.userList));
		users.searchUserAndDelete(emailAddress);
	}
	
	@DataProvider(name = "deleteUsersMappedToProjects")
    public Object[][] UsersMappedToProjects(){
    	
    	return new Object[][] {
    		{"charles.neuman@bamboohr.com"},
    	};
    }
	@Test(dataProvider = "deleteUsersMappedToProjects")
	public void deleteUserMappedToProjects(String emailAddress)
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.administration)).click();
		Admin_UsersPageObjects users = new Admin_UsersPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(users.orgSetup)).click();
		wait.until(ExpectedConditions.visibilityOf(users.users)).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(users.userList));
		users.searchUserMappedToProjectsAndDelete(emailAddress);
	}
	
	@DataProvider(name = "users")
    public Object[][] UserData(){
    	
    	return new Object[][] {
    		{"abirami.s@rubixtek.com", "Hi, Abirami"},
    		{"jaivignesh@rubixtek.com", "Hi, JaiVignesh Elangovan"},
    	};
    }
	@Test(dataProvider = "users")
	public void loginAsThisUserAndBackToAdminAccount(String user, String userNAME) throws InterruptedException
	{
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.administration)).click();
		Admin_UsersPageObjects users = new Admin_UsersPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(users.orgSetup)).click();
		wait.until(ExpectedConditions.visibilityOf(users.users)).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(users.userList));
		users.searchUserAndClickLoginAsThisUser(user, tenantNAME, userNAME);
		Thread.sleep(5000);
		users.backToAdminAccount(tenantNAME);
	}
	
	@Test(dataProvider = "newUserDataPasswordValidations", dataProviderClass = TestDataProvider.class)
	public void checkPasswordValidations(String first_Name, String surName, String emailAddress, String phone, String username, String setPassword, String password, String passwordRepeat) throws InterruptedException {
		
		DashboardPageObjects dashboard = new DashboardPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(dashboard.administration)).click();
		Admin_UsersPageObjects users = new Admin_UsersPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(users.orgSetup)).click();
		wait.until(ExpectedConditions.visibilityOf(users.users)).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(users.userList));
		
		if(users.checkIfUserAlreadyExists(emailAddress)) {
			System.out.println(emailAddress + " already exists");
		}
		
		else {
			wait.until(ExpectedConditions.elementToBeClickable(users.createUserBtn)).click();
			wait.until(ExpectedConditions.visibilityOf(users.createUserModal));
			Assert.assertTrue(users.createUserModal.isDisplayed(), "Create new user modal is not displayed");
			users.fillUserInformation(first_Name, surName, emailAddress, phone, username);
			users.setRandomPassword(setPassword, password, passwordRepeat);
		}
	}
}
