package sanitySuite;

import org.testng.annotations.Test;
import base.TestBase;
import pages.Syn_google_search;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;



public class TestCase_1_GoogleSearch extends TestBase{
 
  WebDriver driver;
  Syn_google_search obj_google_search;
	

  @Test (priority=1, description = "Open Google Search URL")	
  public void open_url() {
	  log.info("Open Google Search URL");
	  driver.get(getPropertyValue("base.url"));
	  obj_google_search.search_by_first_option(getPropertyValue("TestCase_1.searchString_1"));
	  Assert.assertTrue(obj_google_search.get_first_option().equals(getPropertyValue("TestCase_1.assertString_1")), "Expected String doesn't match");
	  
  }
  
  @Test (priority=2, description = "Click on first search option")	
  public void click_first_search_option() {
	  log.info("Click on first search option");
	  
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
