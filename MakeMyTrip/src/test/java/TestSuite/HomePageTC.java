package TestSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
    	driver = super.setUp("chrome");
    	hp = new HomePageObjects(driver);
    	PageFactory.initElements(driver, HomePageObjects.class);
    	lp = new LoginPageObjects(driver);
    	PageFactory.initElements(driver, LoginPageObjects.class);
    	
	}
	
	@AfterClass
	public void close()
	{
		tearDown();
	}
	
	@Test
	public void getData() throws Exception
	{
		String exp = excelOperations("Homepage", 2, 0);
		System.out.println(exp);
	}
	
	@Test
	public void headerMenuValidation() throws Throwable {
		lp.doLogin();
		//click on the options by entering 1 to 10
		for(int i=1; i<=10; i++)
		{
			menuOption = hp.getHeaderMenueElement(i);
			menuOption.click();
			//System.out.println(menuOption.getText());
			String exp = excelOperations("Homepage", i-1, 0);
			Assert.assertEquals(driver.getTitle(),exp );
			System.out.println(menuOption.getText() + " Validation success!!");
		}
	}

}
