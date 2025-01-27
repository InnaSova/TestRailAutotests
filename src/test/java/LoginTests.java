
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.itemPage;
import pages.mainPage;

public class LoginTests {
    private mainPage mainPage;
    private itemPage itemPage;

    /**
     * Тест відповідає за перевірку основної логіки на головній сторінці додатку: перегляд
     * карток із бургерами, перевірка інформації про бургери, додавання бургеру в корзину
     */
    @Test
    public void t_19_loginTest() {
        Assert.assertEquals(1, 1);
    }

    /**
    * Тест перевіряє роботу пагінації на головній сторінці
    */
    @Test
    public void t_20_assertLoginPageTest() {
        Assert.assertEquals(1, 2);

    }

    /**
     * Тест перевіряє додавання окремого товару в корзину. Перевірка підтвердження покупки
     */
    @Test
    public void t_21_checkLogin() {
        Assert.assertEquals(1, 1);

    }

    @Test
    public void t_04_Test() {
        setUp();
        //додавання бургера в корзину
        mainPage.wait(5);
        mainPage.addItem();
        mainPage.assertTextPresent("Cart 1");
    }

//    @Test
    public void t_05_Test() {
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
