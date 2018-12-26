package SellariSelenium.SellariSelenium;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://www.nhl.com/stars");
        
        driver.findElement(By.xpath("//*[@id=\"team-landing_index\"]/div[2]/div[3]/div[2]/div/nav[2]/ul/li[7]/a")).click();
        
        driver.findElement(By.xpath("//*[@id=\"stats_index\"]/div[1]/div[3]/div[2]/div/nav[2]/ul/li[5]/a")).click();
        
        driver.findElement(By.xpath("//a[@href='/player/tyler-seguin-8475794']")).click();
        
        
        //driver.close();
        

    }
}
