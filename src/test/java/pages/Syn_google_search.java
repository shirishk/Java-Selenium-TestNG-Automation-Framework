package pages;

/*******************************************************************************************
 * Page Factory class Template
 * @author Shirish Kawatkar
 *******************************************************************************************/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;


public class Syn_google_search extends PageBase {

	public Syn_google_search(WebDriver driver) {
		super(driver);
	}

	/*******************************************************************************************
	 * All WebElements are identified by @FindBy annotation
	 *******************************************************************************************/

	WebDriver driver;
	// Web Element for Google Search Box
	@FindBy(name = "q")
	WebElement searchBox;
	
	// Web Element for Google Search first option
	@FindBy(xpath = "//*[@id='tsf']/div[2]/div/div[2]/div[2]/ul/li[1]/div[1]/div/span")
	WebElement searchFirstOption;

	/*******************************************************************************************
	 * All Methods for performing actions
	 * @return 
	 *******************************************************************************************/

	
	public void enter_text(String Search_text){
		
		log.info("Enter text to search: "+Search_text);
		searchBox.sendKeys(Search_text);
		
	}
	
	public String get_first_option(){
		log.info("Select first option displayed by google search");
		return searchFirstOption.getText();
		
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
		
	}
	
	public void click_on_first_search_option () {

		this.select_first_option();
		
	}
}
