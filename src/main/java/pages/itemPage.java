package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class itemPage extends basePage {
    public itemPage(WebDriver driver){
        super(driver);
    }

    public void assertTextPresent(String text){
        driver.findElements(By.linkText(text));
    }

    public void clickAtAddItemButton(){
        driver.findElement(By.xpath("//button[@class = 'btn btn-outline-info btn-sm'][contains(., '+')]")).click();
    }

    public void removeItemButton(){
        driver.findElement(By.xpath("//button[@class = 'btn btn-outline-info btn-sm'][contains(., '–')]")).click();
    }

    public void deleteButton(){
        driver.findElement(By.xpath("//button[@class = 'btn btn-danger btn-sm']")).click();
    }

    public void confirmButton(){
        driver.findElement(By.xpath("//button[@class = 'w-25 mt-2 btn btn-primary']")).click();
    }
}
