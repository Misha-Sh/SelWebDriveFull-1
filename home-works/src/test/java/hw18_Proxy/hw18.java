package hw18_Proxy;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class hw18 {


    private WebDriver driver;
    private WebDriverWait wait;
    //Proxy proxy;

    //private BrowserMobProxy proxy = new BrowserMobProxyServer();
private Proxy proxy;
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

//         start the proxy
//        BrowserMobProxy proxy = new BrowserMobProxyServer();
//        proxy.start(0);
//
//        // get the Selenium proxy object
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//
//        // configure it as a desired capability
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
//
//       proxy.start(8888);
//        proxy = new Proxy();
////
//      proxy.setHttpProxy("localhost:8888");
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("proxy", proxy);
//
//        driver = new ChromeDriver(caps);




       // driver = new ChromeDriver();
        //////////////////////For Safari ////////////////////
        //driver = new SafariDriver();
/////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testIt() {

//        BrowserMobProxy proxy = new BrowserMobProxyServer();
//        proxy.start(0);
//        // get the JVM-assigned port and get to work!
//        int port = proxy.getPort();

        // start the proxy
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(8888);
        int port = proxy.getPort();
//
//        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//
//        // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        driver = new ChromeDriver(capabilities);

        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//
//        // create a new HAR with the label "yahoo.com"
proxy.newHar("yahoo.com");
//
////        // open yahoo.com
////        driver.get("http://yahoo.com");
//
//        // get the HAR data
//        Har har = proxy.getHar();


//--------------------------------------------------------------------------
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

                //har = proxy.endHar();
                Har har = proxy.getHar();
                har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" +
               l.getRequest().getUrl()));
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