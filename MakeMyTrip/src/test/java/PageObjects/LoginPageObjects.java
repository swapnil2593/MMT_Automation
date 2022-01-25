package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java_main.BaseUtilities;

public class LoginPageObjects extends BaseUtilities{
    WebDriver driver;

    public LoginPageObjects(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath= "//label[contains(text(), 'Login with Phone/Email')]")
    WebElement loginWith;
    
    @FindBy(xpath = "//*[@id='SW']//ul//li[@data-cy='account']")
    WebElement loginAccount;

    @FindBy(xpath = "//input[@id = 'username']")
    WebElement emailId;

    @FindBy(xpath = "//div//span[contains(text(), 'Continue')]")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//div//span[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//div//span[@data-cy='modalClose']")
    WebElement phoneNoWindow;
    
    @FindBy(xpath = "//div//p[@data-cy='loggedInUser']")
    WebElement myAcc;
    
    public void applyClickWait(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void applyVisibleWait(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickLoginWith() {
		applyClickWait(loginWith);
		loginWith.click();
    }
    
    public void clickLoginAccount(){
    	applyClickWait(loginAccount);
        loginAccount.click();
    }

    public void setEmailId(String email){
    	//super.applyClickWait(emailId);
        emailId.sendKeys(email);
    }

    public void clickContinueButton() throws InterruptedException{
    	//super.applyClickWait(continueButton);
    	Thread.sleep(1000);
        continueButton.click();
    }

    public void setPassword(String pass){
    	applyClickWait(password);
        password.sendKeys(pass);
    }

    public void clickLoginButton(){
    	applyClickWait(loginButton);
        loginButton.click();
    }

    public void closePhoneNoWindow(){
    	applyClickWait(phoneNoWindow);
    	phoneNoWindow.click();
    }
    
    public String validateMyAcc() {
    	applyClickWait(myAcc);
    	String str = myAcc.getText();
    	return str;
    }

}
