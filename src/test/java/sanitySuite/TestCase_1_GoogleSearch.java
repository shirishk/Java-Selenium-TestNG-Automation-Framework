package sanitySuite;

import org.testng.annotations.Test;

import base.TestBase;
import pages.Syn_google_search;



public class TestCase_1_GoogleSearch extends TestBase{

	Syn_google_search obj_google_search;


	@Test (priority=1, description = "Open Google Search URL")	
	public void open_url() {

		log.info("Open Google Search URL.");
		driver.get(data.getProperty("base.url"));

		log.info("Get input string from properties file and put it into the search box.");
		obj_google_search = new Syn_google_search (driver);
		obj_google_search.search_by_first_option(data.getProperty("TestCase_1.searchString_1"));
		
		log.info("Assert actual searched string with expected string from properties file.");
		assertStrings(obj_google_search.get_first_option(),data.getProperty("TestCase_1.assertString_1"));

		//	  Assert.assertTrue(obj_google_search.get_first_option().equals(getPropertyValue("TestCase_1.assertString_1")));

	}

	@Test (priority=2, description = "Click on first search option")	
	public void click_first_search_option() {

		log.info("Click on first search option");
		obj_google_search.click_on_first_search_option();

	}

}
