package PageObjects;

import java_main.BaseUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageObjects extends BaseUtilities {
    public WebDriver driver;
    WebElement flightOption;
    
    public HomePageObjects(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void applyClickWait(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void applyVisibleWait(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    
    public WebElement getHeaderMenueElement(int option)
    {
        flightOption = driver.findElement(By.xpath("//ul[@class='makeFlex font12']/li["+option+"]"));
        applyClickWait(flightOption);
    	return flightOption;
    }

    
    
    
}
