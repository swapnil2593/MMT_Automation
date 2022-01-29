package TestSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import PageObjects.LoginPageObjects;
import java_main.BaseUtilities;

public class HomePageTC extends BaseUtilities {
	
	public WebDriver driver;
	public HomePageObjects hp;
	public LoginPageObjects lp;
	
	
	@BeforeClass
	 public void launchBrowser() throws Exception {
    	driver = super.setUp("Firefox");
    	hp = new HomePageObjects(driver);
    	PageFactory.initElements(driver, HomePageObjects.class);
    	lp = new LoginPageObjects(driver);
    	PageFactory.initElements(driver, LoginPageObjects.class);
    	lp.clickLoginWith();
        lp.setEmailId(getPropertyFileData().getProperty("email"));
        lp.clickContinueButton();
        lp.setPassword(getPropertyFileData().getProperty("pass"));
        lp.clickLoginButton();
        lp.closePhoneNoWindow();
    	
	}
	
	
	@Test
	public void menu() throws Throwable {
		//lptc.loginTest();
		
		hp.flightMenuLink();
	}

}
