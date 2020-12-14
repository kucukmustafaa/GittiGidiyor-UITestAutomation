package org.example.Base;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseTest {
    protected String selectBrowser = "chrome";
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @Before
    public void beforeMethod(){
        PropertyConfigurator.configure("log4j.properties");
        if (selectBrowser.equalsIgnoreCase("chrome")){
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--kiosk");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-fullscreen");
            System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
            driver=new ChromeDriver(options);
            wait=new WebDriverWait(driver,30);
            driver.get("https://www.gittigidiyor.com");

        }else if (selectBrowser.equalsIgnoreCase("firefox")){
            FirefoxOptions options=new FirefoxOptions();
            options.addArguments("--kiosk");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-fullscreen");
            System.setProperty("webdriver.gecko.driver","driver/geckodriver.exe");
            driver=new FirefoxDriver(options);
            wait=new WebDriverWait(driver,30);
            driver.get("https://www.gittigidiyor.com");
        }
        else{
            Assert.fail("Driver bulunamadı.");
        }
    }

    @After
    public void afterMethod(){
        if (driver != null) {
            driver.quit();
        }
    }
}
