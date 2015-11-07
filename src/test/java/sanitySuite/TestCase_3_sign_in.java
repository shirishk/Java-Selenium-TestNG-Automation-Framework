package sanitySuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;


import pages.Users_sign_in;
import pages.Users_sign_up;

public class TestCase_3_sign_in extends TestBase{
	
	  WebDriver driver;
	  Users_sign_in  obj_Users_sign_in;
	  
	
	  @Test (priority=1, description = "Login as Admin.")	
	  public void open_url() {
		  
		  log.info("Open Signup URL.");
		  driver.get(getPropertyValue("base.url.signin"));
		  		  
		  log.info("Register new User");
		  obj_Users_sign_in = new Users_sign_in(driver);
		  obj_Users_sign_in.Login(getPropertyValue("admin.user.name1"), getPropertyValue("admin.user.password1"));
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
