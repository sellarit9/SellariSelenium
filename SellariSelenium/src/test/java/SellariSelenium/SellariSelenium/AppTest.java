package SellariSelenium.SellariSelenium;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
     */
    public void testApp()
    {
    	ChromeDriverManager.getInstance().setup();
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");    	
        WebDriver driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        
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
