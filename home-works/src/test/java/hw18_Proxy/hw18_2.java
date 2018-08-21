package hw18_Proxy;



import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class hw18_2 {

    private WebDriver driver;
    private WebDriverWait wait;
    private Proxy proxy;
    //private Har har;

    @Before
    public void start() {
        proxy = new Proxy();

      proxy.setHttpProxy("localhost:8888");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("proxy", proxy);

        driver = new ChromeDriver(caps);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void testIt() {


//--------------------------------------------------------------------------
        //proxy.newHar();

        int i = 0;
        do {

            driver.get("http://localhost/litecart/");
            driver.findElement(By.cssSelector("#box-most-popular li:nth-child(1) a.link ")).click();
            WebElement cart = driver.findElement(By.cssSelector("div#cart span[class='quantity']"));
            String summInCart = cart.getText();

            driver.findElement(By.cssSelector("div#box-product button[name='add_cart_product']")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            try {
                WebElement optionSize = driver.findElement(By.cssSelector("div#box-product select[name='options[Size]']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=1; arguments[0].dispatchEvent(new Event ('change'));", optionSize);
                driver.findElement(By.cssSelector("div#box-product button[name='add_cart_product']")).click();
            } catch (Exception ex) {
            }


            do {
                if (!summInCart.equals(driver.findElement(By.cssSelector("div#cart span[class ='quantity']")).getText()))
                    break;
            } while (true);
            i++;
        } while (i < 3);


        driver.findElement(By.linkText("Checkout »")).click();

        do {
            List<WebElement> shortcuts = driver.findElements(By.cssSelector("div#box-checkout-cart li[class='shortcut']"));
            if (shortcuts.size() > 0)
                shortcuts.get(0).click();

            List<WebElement> rowsInTable = driver.findElements(By.cssSelector("div#order_confirmation-wrapper tr"));
            int numberRows = rowsInTable.size();

            driver.findElement(By.cssSelector("#box-checkout-cart button[name ='remove_cart_item']")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            try {
                driver.findElement(By.cssSelector("div#checkout-cart-wrapper p em"));
                System.out.println("Well, finish");
//--------------------------------------------------
                //har = proxy.endHar();

//                har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" +
//                        l.getRequest().getUrl()));
                return;
            } catch (Exception ex) {
            }


            do {
                List<WebElement> rowsInTableCurr = driver.findElements(By.cssSelector("div#order_confirmation-wrapper tr"));
                int numberRowsCurr = rowsInTableCurr.size();
                if ((numberRows - numberRowsCurr) == 1)
                    break;
            } while (true);


        } while (true);


    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
