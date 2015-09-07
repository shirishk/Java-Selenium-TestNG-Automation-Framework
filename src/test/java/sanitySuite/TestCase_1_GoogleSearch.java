package sanitySuite;

import org.testng.annotations.Test;
import base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;



public class TestCase_1_GoogleSearch extends TestBase{
 
	
	

  @Test (priority=1, description = "Open Google Search URL")	
  public void open_url() {
	  log.info("Open Google Search URL");
	  driver.get(getPropertyValue("base.url"));
	  
  }
  
  @Test (priority=2, description = "Click on first search option")	
  public void click_first_search_option() {
	  log.info("Test Case 2");
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
