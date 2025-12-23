package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;



public class Practise extends launchezhour{
	 @Test(dataProvider = "login")
	    public void loginTest(String data[]) throws InterruptedException {
	        System.out.println("Username: " + data[0])																																																	;
	        System.out.println("Password: " + data[1]);
	        System.out.println("good morning");
	        // Example usage: 
	        // driver.findElement(By.id("username")).sendKeys(username);
	        // driver.findElement(By.id("password")).sendKeys(password);
	        Thread.sleep(5000);
	    }
}
