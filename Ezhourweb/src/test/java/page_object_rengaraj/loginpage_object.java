package page_object_rengaraj;

import static org.testng.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comman_methods.comman_methods;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class loginpage_object extends comman_methods {
WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"kt_body\"]/app-root/ng-component/div/div/div[2]/div/div/div/div/ng-component/div[1]/form/div[1]/input")
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\"kt_body\"]/app-root/ng-component/div/div/div[2]/div/div/div/div/ng-component/div[1]/form/div[2]/input")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"kt_body\"]/app-root/ng-component/div/div/div[2]/div/div/div/div/ng-component/div[1]/form/div[4]/button")
	WebElement submit;
	
	@FindBy(xpath="//span[text()=\"Dashboard\"]")
	WebElement dashbord_text;
	
	public loginpage_object(WebDriver driver) {
		super(driver);
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public void imagevalidation()
	{

		Screenshot actualimage=new AShot().coordsProvider(new WebDriverCoordsProvider())
			    .takeScreenshot(driver);
		try {
			ImageIO.write(actualimage.getImage(), "PNG", new File("actualimage.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
//		Screenshot expectedimage=new AShot().coordsProvider(new WebDriverCoordsProvider())
//			    .takeScreenshot(driver);
//		ImageIO.write(expectedimage.getImage(), "PNG", new File("expectedimage.png"));
//		
		
		BufferedImage expectedimage = null;
		try {
			expectedimage = ImageIO.read(new File("./screenshort/expected.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	Screenshot expected=new Screenshot(expectedimage);
		
		
		
		
		
		ImageDiffer imgdiff=new ImageDiffer();
		ImageDiff diff=imgdiff.makeDiff(expected, actualimage);
		
		if(diff.hasDiff())
		{
			System.out.println("Image is not same");
			  try {
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("./screenshort/diff_image.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Image is same");
			
		}
		
		assert !diff.hasDiff() : "Images do not match! See diff_image.png";
		
	}

	public void mail(String string)
	{
		waitforElementVisible(email);
		
email.sendKeys(string);
	}
	
	public void password(String string)
	{
		waitforElementVisible(password);
		password.sendKeys(string);
	
	}
	public void submit()
	{
		waitForElementClickable(submit);
		submit.click();
	}
	public void dashboard_verify()
	{
		waitforElementVisible(dashbord_text);
		String dashboard=dashbord_text.getText();
		assertEquals(dashboard, "Dashboard");
		
	}
}
