package TestSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import PageObjects.LoginPageObjects;
import java_main.BaseUtilities;

public class LoginPageTC extends BaseUtilities {
	
	public WebDriver driver;
	public LoginPageObjects lp;
	
	@BeforeMethod
	 public void launchBrowser() throws Exception {
    	driver = super.setUp("Firefox");
    	lp = new LoginPageObjects(driver);
    	PageFactory.initElements(driver, LoginPageObjects.class);
	}
	
	@AfterMethod
	public void quit() {
		super.tearDown();
	}
	
    
    @Test(priority=1)
    public void loginTest() throws Throwable{
        lp.clickLoginWith();
        lp.setEmailId(getPropertyFileData().getProperty("email"));
        lp.clickContinueButton();
        lp.setPassword(getPropertyFileData().getProperty("pass"));
        lp.clickLoginButton();
        lp.closePhoneNoWindow();
        String str2 = lp.validateMyAcc();
        System.out.println(str2);
        Assert.assertEquals(str2.contains("Hi"), true);
        System.out.println("login valiudated successfully!!");
    }
    
    @Test(priority = 2)
    public void continueButtonValidation() throws Exception
    {
    	lp.clickLoginWith();
        super.takeSnapShot();
        Assert.assertEquals(lp.continueBtnVisible(), false);
        	
    }
    
    @Test
    public void invalidEmailValidPass() throws Exception 
    {
    	lp.clickLoginWith();
    	lp.setEmailId("test@gm.com");
    	lp.clickContinueButton();
    	lp.setPassword(getPropertyFileData().getProperty("pass"));
    	lp.clickLoginButton();
    	String str = lp.validIDInvalidPass();
    	Assert.assertEquals(str, "Either Username or Password is incorrect.");
    }
    
    @Test
    public void validIDInvalidPass() throws InterruptedException, Exception {
    	lp.clickLoginWith();
    	lp.setEmailId(getPropertyFileData().getProperty("email"));
    	lp.clickContinueButton();
    	lp.setPassword(getPropertyFileData().getProperty("invalidPass"));
    	lp.clickLoginButton();
    	Thread.sleep(1000);
    	String str = lp.validIDInvalidPass();
    	Assert.assertEquals(str, "Either Username or Password is incorrect.");
    }

    /*@Test
    public void oneWaySearch(){
        hpo.setFrom_input_field().sendKeys("Pune");
        hpo.setTo_input_field().sendKeys("Thailand");
        hpo.setSearch_button().click();

    }*/
}
