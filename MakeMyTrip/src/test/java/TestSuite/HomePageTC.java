package TestSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	WebElement menuOption;
	
	
	@BeforeClass
	 public void launchBrowser() throws Exception {
    	driver = super.setUp("firefox");
    	hp = new HomePageObjects(driver);
    	PageFactory.initElements(driver, HomePageObjects.class);
    	lp = new LoginPageObjects(driver);
    	PageFactory.initElements(driver, LoginPageObjects.class);
    	
    	
	}
	
	@Test
	public void headerMenu() throws Throwable {
		lp.doLogin();
		//click on the options by entering 1 to 10
		menuOption = hp.getHeaderMenueElement(3);
		menuOption.click();
		System.out.println(menuOption.getText());
	}

}
