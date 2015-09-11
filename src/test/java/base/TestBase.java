package base;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public abstract class TestBase {
	
	public static Logger log = null;
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
	
	
	/**
	 * Initialize Logger.
	 */
	protected static void initLogs(String Logclass){
			
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
	protected static String getPropertyValue(String PropertyKey){
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
	 * Define path for Screenshot file.
	 */
	protected String getScreenshotSavePath() {
		String packageName = this.getClass().getPackage().getName();
		File dir = new File(System.getProperty("user.dir")+File.separator+"screenshot"+File.separator + packageName + File.separator);
		dir.mkdirs();
		return dir.getAbsolutePath();
	}
	
	
	/**
	 * Take Screenshot on failure.
	 */
	protected void getScreenshot() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String date = sdf.format(new Date());
		String url = driver.getCurrentUrl().replaceAll("[\\/:*\\?\"<>\\|]", "_");
		String ext = ".png";
		String path = getScreenshotSavePath() + File.separator + date + "_" + url + ext;

		try {
			if (driver instanceof TakesScreenshot) {
				File tmpFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				org.openqa.selenium.io.FileHandler.copy(tmpFile, new File(path));
				log.error("Captured Screenshot for Failure: "+path);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * Assert Actual and Expected Strings
	 */
	
	protected void assertStrings(String actual, String expected){
		
		
		try{
			Assert.assertEquals(actual, expected);
			log.info("Actual string: [ "+actual+" ] does match with Expected string: [ "+expected+" ]");		
			
		}catch(AssertionError e){
			log.error("Actual string: [ "+actual+" ] does not match with Expected string: [ "+expected+" ]");
			getScreenshot();
			Assert.fail();
			
		}
		
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
