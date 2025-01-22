import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.itemPage;
import pages.mainPage;

public class CalculationTests {

    private mainPage mainPage;
    private itemPage itemPage;

    @Test
    public void t_06_Test() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void t_07_Test() {
        setUp();
        //додавання бургера в корзину
        mainPage.wait(5);
        mainPage.addItem();
        mainPage.assertTextPresent("Cart 1");
    }

    @Test
    public void t_08_Test() {
        setUp();
        //додавання бургера в корзину
        mainPage.wait(5);
        mainPage.addItem();
        mainPage.assertTextPresent("Cart 1");
    }

    @Test
    public void t_09_Test() {
        setUp();
        //додавання бургера в корзину
        mainPage.wait(5);
        mainPage.addItem();
        mainPage.assertTextPresent("Cart 1");
    }

    @Test
    public void t_10_Test() {
        setUp();
        //додавання бургера в корзину
        mainPage.wait(5);
        mainPage.addItem();
        mainPage.assertTextPresent("Cart 1");
    }

    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new mainPage(driver);
        itemPage = new itemPage(driver);
        mainPage.navigateTo("https://musical-douhua-c546d9.netlify.app/");
    }


}
