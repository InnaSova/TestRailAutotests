package mainPageTests;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.mainPage;

public class mainPageGeneralTests {
    private WebDriver driver;
    private mainPage mainPage;

    @Test
    public void t_01_textChecksTests(){
        setUp();
        mainPage.clickAtMonButton();
    }

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new mainPage(driver);
        mainPage.navigateTo("https://ad.nure.ua");
    }
}
