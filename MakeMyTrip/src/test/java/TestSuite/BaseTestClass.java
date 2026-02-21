package TestSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import PageObjects.HomePageObjects;
import PageObjects.LoginPageObjects;
import java_main.BaseUtilities;

public class BaseTestClass extends BaseUtilities {
	
	public WebDriver driver;
	public LoginPageObjects lp;
	public HomePageObjects hp;
	
	
    public void launchBrowser() throws Exception {
    	driver = super.setUp("Chrome");
    	lp = new LoginPageObjects(driver);
    	PageFactory.initElements(driver, LoginPageObjects.class);
    } 
    
    public void initilizePageObjects() {
    	lp = new LoginPageObjects(driver);
    	PageFactory.initElements(driver, LoginPageObjects.class);
    	
    	hp = new HomePageObjects(driver);
    	PageFactory.initElements(driver, HomePageObjects.class);
    }
    

    public void kill()
    {
    	super.tearDown();
    }

}
