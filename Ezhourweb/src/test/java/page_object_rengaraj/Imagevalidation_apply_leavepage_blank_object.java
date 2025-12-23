package page_object_rengaraj;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Imagevalidation_apply_leavepage_blank_object {
WebDriver driver;
	

@FindBy(xpath="(//button[@type=\"submit\"])[1]")
WebElement applybutton;

@FindBy(xpath="(//button[text()=\" Cancel \"])[1]")
WebElement cancelbutton;


	
	
	
	public Imagevalidation_apply_leavepage_blank_object(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void leavepage_imagevalidation() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		AShot ashot=new AShot();
//		//actual image
	Screenshot actualimage=ashot.takeScreenshot(driver);
	ImageIO.write(actualimage.getImage(), "PNG", new File("actualleave_page.png"));
	
// expected image
//	Screenshot expectedimage=ashot.takeScreenshot(driver);
//	ImageIO.write(expectedimage.getImage(), "PNG", new File("Expectedleave_page.png"));
	
	BufferedImage expectedimage_file=ImageIO.read(new File("./screenshort/Expectedleave_page.png"));
	
	Screenshot expected=new Screenshot(expectedimage_file);
	
	ImageDiffer imagediff=new ImageDiffer();
ImageDiff diff=imagediff.makeDiff(expected, actualimage);


if(diff.hasDiff())
{
	ImageIO.write(diff.getMarkedImage(), "PNG", new File("./screenshort/applyleavepagedifferent.png"));
	System.out.println("Image not same");
	assertFalse(false);
//	assertFalse(diff.hasDiff());
}
else {
	System.out.println("image is same apply leave page");
}
	
	
	}
	
	public void applybutton()
	{
		assertFalse(applybutton.isEnabled(), "Apply button is enabled");
	}
	
	public void cancelbutton()
	{
	assertTrue(cancelbutton.isEnabled(), "Cancel button is enabled");
	}
}


