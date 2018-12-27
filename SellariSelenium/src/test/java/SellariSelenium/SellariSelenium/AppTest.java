package SellariSelenium.SellariSelenium;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	private final Logger slf4jLogger = LoggerFactory.getLogger(AppTest.class);
	
	private static RemoteWebDriver driver;
	
	static DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws MalformedURLException 
     */
    public void testApp() throws MalformedURLException
    {
        capabilities.setVersion("latest");
        capabilities.setCapability("platform", "Windows 8.1");
        capabilities.setCapability("testName","SellariSelenium - Dallas Stars Test");
        capabilities.setCapability("SRF_CLIENT_ID", "t919707050_oauth2-Fd7wTPr231LHXVTmTEAR@microfocus.com"); 
        capabilities.setCapability("SRF_CLIENT_SECRET", "Sf0FsXCA8UuLKEvVULbd");
        capabilities.setCapability("resolution", "1920x1080");
    	
    	
    	/*ChromeDriverManager.getInstance().setup();
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");    	
        WebDriver driver = new ChromeDriver(options);
        //driver.manage().window().maximize();*/
        
        driver = new RemoteWebDriver(
        	      new URL("https://ftaas.saas.hpe.com/wd/hub/"), capabilities);
        	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        slf4jLogger.info("Navigating to Dallas Stars Website");
        driver.get("https://www.nhl.com/stars");
        
        slf4jLogger.info("Opening Stats");
        driver.findElement(By.xpath("//*[@id=\"team-landing_index\"]/div[2]/div[3]/div[2]/div/nav[2]/ul/li[5]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"team-landing_index\"]/div[2]/div[3]/div[2]/div/nav[2]/ul/li[5]/a")).click();
        
        slf4jLogger.info("Selecting Tyler Seguin");
        driver.get("https://www.nhl.com/player/tyler-seguin-8475794");
        
        try
        {

        	slf4jLogger.info("Capturing Name and Number");
        	String info = driver.findElement(By.xpath("//*[@id=\"content-wrap\"]/section[1]/div/section/h3")).getText();
        	
        	slf4jLogger.info("Checking if the name and number are correct");
        	if(info.contains("Seguin") && info.contains("#92"))
			{
        		slf4jLogger.info("Correct!");
				assertTrue(true);
			}
			else
			{
				slf4jLogger.info("Not Correct");
				assertTrue(false);
			}
        	
        }
        catch(Exception e)
        {
        	slf4jLogger.info("Error Occurred");
        	assertTrue(false);
        }
       
        
        driver.close();
        

    }
}
