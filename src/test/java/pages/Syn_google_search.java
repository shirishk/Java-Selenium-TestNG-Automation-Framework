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


public class Syn_google_search extends TestBase {

	/*******************************************************************************************
	 * All WebElements are identified by @FindBy annotation
	 *******************************************************************************************/

	WebDriver driver;
	// Web Element for Google Search Box
	@FindBy(id = "gs_htif0")
	WebElement searchBox;
	
	// Web Element for Google Search first option
	@FindBy(xpath = "//*[@id='sbse0']/div[2]")
	WebElement searchFirstOption;

	/*******************************************************************************************
	 * All Methods for performing actions
	 * @return 
	 *******************************************************************************************/

	public Syn_google_search(WebDriver driver) {

		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		log.info("Create web elements");

	}
	
	public void enter_text(String Search_text){
		
		log.info("Enter text to search: "+Search_text);
		searchBox.sendKeys(Search_text);
		
	}
	
	public void select_first_option(){
		
		log.info("Select first option displayed by google search");
		searchFirstOption.click();
		
	}

	/*******************************************************************************************
	 * This POM method will be exposed in test case
	 * @param 
	 *******************************************************************************************/

	public void search_by_first_option(String text_to_search) {

		this.enter_text(text_to_search);
		this.select_first_option();

	}
}
