package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mainPage extends basePage {

    public mainPage(WebDriver driver){
        super(driver);
    }
    public By monButton = By.className("news-col");

    public void clickAtMonButton(){
        driver.findElement(monButton).click();
    }
}
