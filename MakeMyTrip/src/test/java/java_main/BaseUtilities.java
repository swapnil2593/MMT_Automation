package java_main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class BaseUtilities {
    public static WebDriver driver;
    public Properties prop;
    
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
    
	/*
	 * public void applyClickWait(WebElement element) { WebDriverWait wait = new
	 * WebDriverWait(driver, 20);
	 * wait.until(ExpectedConditions.elementToBeClickable(element)); }
	 * 
	 * public void applyVisibleWait(WebElement element) { WebDriverWait wait = new
	 * WebDriverWait(driver, 20);
	 * wait.until(ExpectedConditions.visibilityOf(element)); }
	 */
    
    
    public void tearDown() {
    	driver.quit();
    }


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

    public String excelOperations(String sheetName, int rowNo, int cellNo) throws Exception
    {
    	File file = new File("../MakeMyTrip/src/test/java/java_main/Validations.xlsx");
    	FileInputStream fis = new FileInputStream(file);
    	XSSFWorkbook workbook = new XSSFWorkbook(fis);
    	Sheet sheet = workbook.getSheet(sheetName);
    	Row row = sheet.getRow(rowNo);
    	Cell cell = row.getCell(cellNo);
    	String value = cell.getStringCellValue();
    	return value;
    	
    	
    }
    
    public void getSystemTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

	
}
