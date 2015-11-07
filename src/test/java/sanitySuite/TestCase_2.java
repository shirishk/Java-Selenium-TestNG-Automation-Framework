package sanitySuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;


import pages.Users_sign_up;

public class TestCase_2 extends TestBase{
	
	  WebDriver driver;
	  Users_sign_up  obj_Users_sign_up;
	  
	
	  @Test (priority=1, description = "Register New User.")	
	  public void open_url() {
		  
		  log.info("Open Signup URL.");
		  driver.get(getPropertyValue("base.url.signup"));
		  		  
		  log.info("Register new User");
		  obj_Users_sign_up = new Users_sign_up(driver);
		  obj_Users_sign_up.Register_New_User(getPropertyValue("registered.user.name1"), getPropertyValue("registered.user.password1"));
		  
//		  log.info("Assert actual searched string with expected string from properties file.");
	
		
	  }

	  
	  @BeforeClass
	  public void beforeClass() {
		  initLogs(this.getClass().getName().toString());
		  driver = initDriver();
	  }

	  @AfterClass
	  public void afterClass() {
		  quitDriver();
	  }
}
