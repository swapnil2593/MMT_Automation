package java_main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class BaseUtilities {
    public static WebDriver driver;
    public Properties prop;
    //public String baseURL = "https://www.makemytrip.com/";
    //public String email = "sopya@yopmail.com";
    //public String pass = "Swapnil@123";
    
    public Properties getPropertyFileData() throws IOException {
        FileInputStream fis = new FileInputStream("./Configurations/Config.properties");
        prop = new Properties();
        prop.load(fis);
        return prop;
    }

    public WebDriver setUp(String browserName) throws Exception {
		
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.get(getPropertyFileData().getProperty("baseURL"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
		return driver;
    }
    
    public void applyClickWait(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void applyVisibleWait(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    @AfterClass
    public void tearDown() {
    	driver.quit();
    }

    /*public void getPropertyFileData() throws IOException {
        FileInputStream fis = new FileInputStream("./Configurations/Config.properties");
        prop = new Properties();
        prop.load(fis);
        //return prop;
    }*/

    public void takeSnapShot() throws Exception {

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile = new File("./ScreenShots/login.jpg");

        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public void getSystemTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}
