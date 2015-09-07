package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public abstract class PageBase {

	/** The driver. */
	protected WebDriver driver = null;


	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public static void wait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public void pressEnter() {
		try {
			Thread.sleep(5000l);
			Actions ac = new Actions(driver);
			ac.sendKeys(Keys.ENTER).perform();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
