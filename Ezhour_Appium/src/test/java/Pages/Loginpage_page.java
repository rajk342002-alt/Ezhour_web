
package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Loginpage_page {

    AndroidDriver driver;

    // Email field
    @AndroidFindBy(
    	    xpath = "//android.widget.EditText")
    	WebElement usermail_send;


    // Next button
    @AndroidFindBy(
        xpath = "//android.widget.Button"
    )
    WebElement usermail_next_button;

    // Error message
    @AndroidFindBy(
        xpath = "//android.view.View[@content-desc='Please enter a valid email address']"
    )
    WebElement valid_mail_error_message;

    // Password field
    @AndroidFindBy(
        xpath = "//android.view.View[@content-desc='Forgot password?']" +
                "/preceding-sibling::android.widget.EditText"
    )
    WebElement password;

    // Login button
    @AndroidFindBy(
        xpath = "//android.view.View[@content-desc='Login']"
    )
    WebElement login_button;

    public Loginpage_page(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(
            new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),
            this
        );
    }

    public void Usermail() {
    	usermail_send.click();
        usermail_send.sendKeys("rengaraj.k@rubixtek.com");
        
    }
    
    public void usermail_next()
    {
    	usermail_next_button.click();
    }

    public void password() {
    	password.click();
        password.sendKeys("123qwe");

        try {
            if (driver.isKeyboardShown()) {
                driver.hideKeyboard();
            }
        } catch (Exception e) {
            System.out.println("Keyboard already hidden");
        }
    }

    public void click_login_button() {
        login_button.click();
    }
}
