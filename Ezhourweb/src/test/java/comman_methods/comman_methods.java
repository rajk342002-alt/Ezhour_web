package comman_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class comman_methods {
	
	 public WebDriver driver;

	    public comman_methods(WebDriver driver) {
	        this.driver = driver;
	    }
	
	
public void waitforElementVisible(WebElement selectleavetype)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(selectleavetype));
}

public void waitforelementlocated(String element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(element)));
}

public void waitForElementClickable(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(element));
}



public void scroll(WebElement xpath)
{
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	 executor.executeScript("arguments[0].scrollIntoView(true);", xpath);	
}

public boolean isElementVisible(WebElement element) {
    try {
        return element.isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

public void dropdown(WebElement element,String name)
{
	Select select=new Select(element);
	select.selectByVisibleText(name);;
}

public void waitForOverlayToDisappear() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.xpath("//div[contains(@class,'ngx-spinner-overlay')]")));
    } catch (Exception e) {
        
    }
}

public void scroll_new(WebElement element)
{
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);	
}

public void Elementclickable(WebElement element)
{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].click();", element);
}


}
