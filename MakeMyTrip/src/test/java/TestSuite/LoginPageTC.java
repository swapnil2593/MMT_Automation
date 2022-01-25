package TestSuite;

import PageObjects.HomePageObject;
import PageObjects.LoginPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java_main.BaseUtilities;

public class LoginPageTC extends BaseUtilities {
    WebDriver driver;
    LoginPageObjects lp;

    @BeforeSuite
    public void launchBrowser() {
    	driver = super.setUp("Chrome");
    }
    
    @Test
    public void loginTest() throws Throwable{
    	
    	lp = new LoginPageObjects(driver);
    	PageFactory.initElements(driver, LoginPageObjects.class);
        lp.clickLoginWith();
        lp.setEmailId(email);
        lp.clickContinueButton();
        lp.setPassword(pass);
        lp.clickLoginButton();
        lp.closePhoneNoWindow();
        String str2 = lp.validateMyAcc();
        System.out.println(str2);
        
        Assert.assertEquals(str2.contains("Hi"), true);
    }

    /*@Test
    public void oneWaySearch(){
        hpo.setFrom_input_field().sendKeys("Pune");
        hpo.setTo_input_field().sendKeys("Thailand");
        hpo.setSearch_button().click();

    }*/
}
