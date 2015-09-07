package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class TestBase {
	
	public static Logger log = null;
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
	
	
	/**
	 * Initialize Logger.
	 */
	public static void initLogs(String Logclass){
			
			// Initialize Log4j logs 
			DOMConfigurator.configure(System.getProperty("user.dir")+File.separator+"config"+File.separator+"log4j.xml");
			log = Logger.getLogger(Logclass);
					
		}
	
	
	/**
	 * Initialize Driver.
	 */
	protected static WebDriver initDriver (){
			
		// Initialize Web Driver 
		
	         log.debug("Initialize Firefox WebDriver");
	         driver = new FirefoxDriver(); 
	         
	         
	   //Implicit Wait
	         
	 		String waitTime = "30";
	 		driver.manage().timeouts().implicitlyWait(Long.parseLong(waitTime), TimeUnit.SECONDS);
	 		driver.manage().window().setPosition(new Point(0, 0));
	 		driver.manage().window().setSize(new Dimension(1024, 768));
	
	 		
	 	//Explicit Wait + Expected Conditions
	 		
	 		wait = new WebDriverWait(driver, 120);
	 		return driver;
		}
	
	/**
	 * Read Properties.
	 */
	public static String getPropertyValue(String PropertyKey){
		Properties props=null;
		FileInputStream fin =null;
		String PropertyValue = null;
		
		try {
		File f = new File(System.getProperty("user.dir")+File.separator+"config"+File.separator+"env.properties");
		fin = new FileInputStream(f);
		props = new Properties();
		props.load(fin);
		PropertyValue = props.getProperty(PropertyKey);
		} catch(Exception e){
		System.out.println(e.getMessage());
		} 
		
		return PropertyValue;
		}
	

	/**
	 * Quit Driver.
	 */
	public static void quitDriver() {

		driver.quit();
		driver = null;
		log.debug("Closing Browser.");
		
	}
	
}
