package pages;

/*******************************************************************************************
 * Page Factory class Template
 * @author Shirish Kawatkar
 *******************************************************************************************/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;

public class Users_sign_in extends TestBase {

	/*******************************************************************************************
	 * All WebElements are identified by @FindBy annotation
	 *******************************************************************************************/

	WebDriver driver;
	// Web Element for Email field
	@FindBy(id = "user_email")
	WebElement Email;
	
	// Web Element for password field
		@FindBy(id = "user_password")
		WebElement password;

		// Web Element for signin button
		@FindBy(xpath = "//*[@id='new_user']/input[3]")
		WebElement signin;

	/*******************************************************************************************
	 * All Methods for performing actions
	 * @return 
	 *******************************************************************************************/

	public Users_sign_in(WebDriver driver) {

		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		log.info("Create web elements");

	}

	public void enter_email(String emailid) {

		log.info("Enter Email Id " + emailid);
		Email.sendKeys(emailid);

	}

	public void enter_password(String pwd) {

		log.info("Enter password " + pwd);
		password.sendKeys(pwd);

	}

	public void Click_signin() {

		log.info("Click on sign in button ");
		signin.click();

	}

	
	/*******************************************************************************************
	 * This POM method will be exposed in test case
	 * @param 
	 *******************************************************************************************/

	public void Login(String emailid_text, String pwd_text) {

		this.enter_email(emailid_text);
		this.enter_password(pwd_text);

	}
	
	public void click_on_sign_in_button() {

		this.Click_signin();

	}
}
