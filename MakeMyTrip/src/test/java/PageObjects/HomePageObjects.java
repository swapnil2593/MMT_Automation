package PageObjects;

import java_main.BaseUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageObjects extends BaseUtilities {
    public WebDriver driver;
    
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
    
    @FindBy(xpath= "//ul[@class='makeFlex font12']")
    WebElement menuHeaders;
    
    public void flightMenuLink() {
    	applyVisibleWait(menuHeaders);
    	String str = menuHeaders.getText();
    	System.out.println(str);
    	
    }

    
    
    
}
