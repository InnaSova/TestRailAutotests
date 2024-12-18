import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public void setUp(){
        ChromeDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","Users/Andrii/Downloads/chromedriver_win32/chromedriver");
        driver.get("https://ad.nure.ua");
    }
}
