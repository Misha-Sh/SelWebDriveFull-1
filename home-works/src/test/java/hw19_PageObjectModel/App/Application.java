package hw19_PageObjectModel.App;

import hw19_PageObjectModel.Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Application {

    private WebDriver driver;
    private WebDriverWait wait;

private ShowCasePage showCasePage;
private CartPage cartPage;
private BasketPage basketPage;
private ProductPage productPage;

    public Application() {
        driver = new ChromeDriver();


        showCasePage = new ShowCasePage(driver);
        cartPage = new CartPage(driver);
        basketPage = new BasketPage(driver);
        productPage = new ProductPage(driver);

    }

    public void Add3ProductsToBasketAndDeleteFrom()
    {
        int i = 0;
        do {
            showCasePage.open();
            showCasePage.selectProduct();
            productPage.addToBasket();
i ++;
        } while (i < 3);

        cartPage.linkCheckout().click();
        basketPage.removeFromBasket();
    }

    public void quit() {
        driver.quit();
    }

}
