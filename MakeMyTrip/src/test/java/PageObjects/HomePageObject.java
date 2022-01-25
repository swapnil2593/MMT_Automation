package PageObjects;

import java_main.BaseUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePageObject {
    public WebDriver driver;

    By from_input_field = By.xpath("//span[contains(text(),'From')]");
    By to_input_field = By.xpath("//label//span[contains(text(),'To')]");
    By search_button = By.xpath("//a[contains(text(),'Search')]");

    public WebElement setFrom_input_field(){
        return BaseUtilities.driver.findElement(from_input_field);
    }

    public WebElement setTo_input_field(){
        return BaseUtilities.driver.findElement(to_input_field);
    }

    public WebElement setSearch_button(){
        return BaseUtilities.driver.findElement(search_button);
    }
}
