
import listeners.TestRailIntegration;
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
    public void t_01_Test() {
        setUp();

        //перевірка наявності карточки із бургером Tribute Burger
        mainPage.wait(3);
        mainPage.assertIsDisplayed();
        //перевірка наявності основних текстів на сторінці
        mainPage.assertTextPresent("BonBurgers");
        mainPage.assertTextPresent("Card");
        mainPage.assertTextPresent("Tribute Burger");
        mainPage.assertTextPresent("A mouth-watering honest beef burger");
        mainPage.assertTextPresent("Cost: 7.90$");
        mainPage.assertTextPresent("Curry On My Wayward Bun");
        mainPage.assertTextPresent("N/A");
        mainPage.assertTextPresent("Cost: 7.72$");
        //перевірка інформації у вікні із бургером
        mainPage.clickAtItem();
        mainPage.assertAmericanCheeseIsDisplayed();
        mainPage.assertBurgerSauceIsDisplayed();
        mainPage.assertFrenchMustardIsDisplayed();
        mainPage.assertOnionIsDisplayed();
        mainPage.assertLettuceIsDisplayed();
        mainPage.assertPickesIsDisplayed();
        mainPage.assertBeefIsDisplayed();
        //Додавання товару в корзину
        mainPage.closePopUp();
        mainPage.wait(3);
        mainPage.addItem();
        //перевірка що елемент було додано
        mainPage.assertTextPresent("Cart 1");
    }

    /**
    * Тест перевіряє роботу пагінації на головній сторінці
    */
    @Test
    public void t_02_Test() {
        setUp();

        mainPage.wait(5);
        //перевірка кліків до останньої сторінки
        mainPage.clickRightPaginationButton();
        mainPage.clickRightPaginationButton();
        mainPage.clickRightPaginationButton();
        mainPage.assertTextPresent("The Street Burgers and Coctail Bar Prague 1");
        mainPage.assertTextPresent("American, Bar, International, European, Vegetarian Friendly");
        mainPage.assertTextPresent("Cost: 9.19$");
        //перевірка вмісту товару на останній сторінці
        mainPage.clickAtItem();
        mainPage.wait(3);
        mainPage.assertBeefIsDisplayed();
        mainPage.closePopUp();
        mainPage.wait(3);
        //перевірка повернення на першу сторінку
        mainPage.clickLeftPaginationButton();
        mainPage.clickLeftPaginationButton();
        mainPage.clickLeftPaginationButton();
        //перевірка вмісту товару на першій сторінці сторінці
        mainPage.clickAtItem();
        mainPage.assertAmericanCheeseIsDisplayed();
        mainPage.assertBurgerSauceIsDisplayed();
        mainPage.assertFrenchMustardIsDisplayed();
    }

    /**
     * Тест перевіряє додавання окремого товару в корзину. Перевірка підтвердження покупки
     */
    @Test
    public void t_03_Test() {
        setUp();
        //додавання бургера в корзину
        mainPage.wait(5);
        mainPage.addItem();
        mainPage.assertTextPresent("Cart 1");
        mainPage.wait(5);
        mainPage.clickAtClosePopUpButton();
        mainPage.clickAtCardButton();
        //перевірка валідацій в корзині
        itemPage.assertTextPresent("Tribute Burger");
        itemPage.clickAtAddItemButton();
        itemPage.clickAtAddItemButton();
        itemPage.clickAtAddItemButton();
        itemPage.removeItemButton();
        itemPage.removeItemButton();
        itemPage.removeItemButton();
        //погодження покупки
        itemPage.confirmButton();
        mainPage.wait(5);
        //перевірка повернення на головну сторінку
        mainPage.assertIsDisplayed();
    }

    @Test
    public void t_04_Test() {
        setUp();
        //додавання бургера в корзину
        mainPage.wait(5);
        mainPage.addItem();
        mainPage.assertTextPresent("Cart 1");
    }

    @Test
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
