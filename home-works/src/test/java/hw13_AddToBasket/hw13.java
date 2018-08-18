package hw13_AddToBasket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class hw13 {

    private WebDriver driver;
private WebDriverWait wait;

    @Before
    public void start() {
///////////////////////// FireFox ////////////////////////////
        ///////// for FireFoxNightly//////////////////////////
//        FirefoxOptions options = new FirefoxOptions();
//        options.setBinary(new FirefoxBinary(new File("/Applications/FireFoxNightly/Firefox Nightly.app/Contents/MacOS/firefox-bin")));
//        driver = new FirefoxDriver(options);
//        ///////// for FireFox45ESR ///////////////////////////
//        FirefoxOptions options = new FirefoxOptions().setLegacy(true);
//        options.setBinary(new FirefoxBinary(new File("/Applications/FireFox45ESR/Firefox.app/Contents/MacOS/firefox-bin")));
//        driver = new FirefoxDriver(options);
//        ///////////for FireFox Common ///////////////////////
//        FirefoxOptions options = new FirefoxOptions();
//options.setBinary(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin")));
//driver = new FirefoxDriver(options);
//////////////////////////////////////////////////////////////////
        ////////////// For Chrome ///////////////////
       driver = new ChromeDriver();
        //////////////////////For Safari ////////////////////
        //driver = new SafariDriver();
/////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////

        wait = new WebDriverWait(driver,2);
    }

    @Test

    public void testIt() {

        int i = 0;
        do {
            driver.get("http://localhost/litecart/");

            WebElement product = driver.findElement(By.cssSelector("#box-most-popular li:nth-child(1) a.link div.name"));
            String nameProduct = product.getText();
            System.out.println(nameProduct);
            product.click();

            WebElement buttonAdd = wait.until(presenceOfElementLocated(By.cssSelector("div#box-product button[name='add_cart_product']")));
            WebElement cart = driver.findElement(By.cssSelector("div#cart a span.quantity"));
            String summInCart = cart.getText();
            int isummInCart = Integer.parseInt(summInCart);
            String summInCartAfter = String.valueOf(isummInCart + 1);
            buttonAdd.click();

            try{
                WebElement optionSize = wait.until(presenceOfElementLocated(By.cssSelector("div#box-product select[name='options[Size]']")));
                //WebElement optionSize = driver.findElement(By.cssSelector("div#box-product select[name='options[Size]']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=1; arguments[0].dispatchEvent(new Event ('change'));", optionSize);
                driver.findElement(By.cssSelector("div#box-product button[name='add_cart_product']")).click();
            }catch (Exception ex) {}

wait.until(ExpectedConditions.textToBePresentInElement(cart,summInCartAfter));
            i++;
        }while(i < 3 );


driver.findElement(By.linkText("Checkout »")).click();

do {
    List<WebElement> shortcuts = driver.findElements(By.cssSelector("div#box-checkout-cart li[class='shortcut']"));
    if (shortcuts.size() > 0)
        shortcuts.get(0).click();


    WebElement summF = driver.findElement(By.cssSelector("#order_confirmation-wrapper tr.footer td strong"));

    driver.findElement(By.cssSelector("#box-checkout-cart button[name ='remove_cart_item']")).click();

    try {
        wait.until(presenceOfElementLocated(By.cssSelector("div#checkout-cart-wrapper p em")));
        System.out.println("Well, finish");
        return;
    } catch (Exception ex) {}

    wait.until(stalenessOf(summF));

}while(true);



    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }


}