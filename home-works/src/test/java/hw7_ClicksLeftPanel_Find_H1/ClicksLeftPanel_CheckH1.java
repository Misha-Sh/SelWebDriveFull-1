package hw7_ClicksLeftPanel_Find_H1;



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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClicksLeftPanel_CheckH1 {

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
        FirefoxOptions options = new FirefoxOptions().setLegacy(true);
        options.setBinary(new FirefoxBinary(new File("/Applications/FireFox45ESR/Firefox.app/Contents/MacOS/firefox-bin")));
        driver = new FirefoxDriver(options);
//        ///////////for FireFox Common ///////////////////////
//        FirefoxOptions options = new FirefoxOptions();
//options.setBinary(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin")));
//driver = new FirefoxDriver(options);
//
        ////////////// For Chrome ///////////////////
        /////////////////////////////////////////////
        //driver = new ChromeDriver();
        //////////////////////For Safari ////////////////////
        /////////////////////////////////////////////////////
        //driver = new SafariDriver();
/////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
        @Test
                public void testIt() {
            driver.get("http://localhost/litecart/admin/");

            driver.findElement(By.name("username")).sendKeys("msh");
            driver.findElement(By.name("password")).sendKeys("msh");
            driver.findElement(By.name("login")).click();

            ///////////////// for Safari:((((((((((( ///////////////////

            //WebElement link = (WebElement) ((JavascriptExecutor) driver)
            //      .executeScript("return document.querySelectorAll('a:contains((http://localhost/litecart/admin/?app=appearance&doc=template)')");

// List<WebElement> links = driver.findElements(By.id("app-"));
//
//            driver.findElement(By.linkText("Appearence")).click();
//            driver.findElement(By.id("doc-template")).click();
//            driver.findElement(By.id("doc-logotype")).click();
//            driver.findElement(By.linkText("href = 'http://localhost/litecart/admin/?app=catalog&doc=catalog'")).click();
////////////////////////////////////////////////////////////////////////////////////////////////////////////
            String[] loc1 = {"a[href='http://localhost/litecart/admin/?app=appearance&doc=template']",
                    "#doc-template", "#doc-logotype",
                    "a[href='http://localhost/litecart/admin/?app=catalog&doc=catalog']",
                    "#doc-catalog", "#doc-product_groups", "#doc-option_groups", "#doc-manufacturers",
                    "#doc-suppliers", "#doc-delivery_statuses", "#doc-sold_out_statuses", "#doc-quantity_units",
                    "#doc-csv", "a[href='http://localhost/litecart/admin/?app=countries&doc=countries']",
                    "a[href='http://localhost/litecart/admin/?app=currencies&doc=currencies']",
                    "a[href='http://localhost/litecart/admin/?app=customers&doc=customers']",
                    "#doc-customers",
                    "a[href='http://localhost/litecart/admin/?app=customers&doc=csv']",
                    "#doc-newsletter",
                    "a[href='http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones']",
                    "a[href='http://localhost/litecart/admin/?app=languages&doc=languages']",
                    "#doc-languages",
                    "#doc-storage_encoding",
                    "a[href='http://localhost/litecart/admin/?app=modules&doc=jobs']",
                    "#doc-jobs",
                    "#doc-customer",
                    "#doc-shipping",
                    "#doc-payment",
                    "#doc-order_total",
                    "#doc-order_success",
                    "#doc-order_action",
                    "a[href='http://localhost/litecart/admin/?app=orders&doc=orders']",
                    "#doc-orders",
                    "#doc-order_statuses",
                    "a[href='http://localhost/litecart/admin/?app=pages&doc=pages']",
                    "a[href='http://localhost/litecart/admin/?app=reports&doc=monthly_sales']",
                    "#doc-monthly_sales",
                    "#doc-most_sold_products",
                    "#doc-most_shopping_customers",
                    "a[href='http://localhost/litecart/admin/?app=settings&doc=store_info']",
                    "#doc-store_info",
                    "#doc-defaults",
                    "#doc-general",
                    "#doc-listings",
                    "#doc-images",
                    "#doc-checkout",
                    "#doc-advanced",
                    "#doc-security",
                    "a[href='http://localhost/litecart/admin/?app=slides&doc=slides']",
                    "a[href='http://localhost/litecart/admin/?app=tax&doc=tax_classes']",
                    "a[href='http://localhost/litecart/admin/?app=translations&doc=search']",
                    "#doc-search", "#doc-scan",
                    "a[href='http://localhost/litecart/admin/?app=translations&doc=csv']",
                    "a[href='http://localhost/litecart/admin/?app=users&doc=users']",
                    "a[href='http://localhost/litecart/admin/?app=vqmods&doc=vqmods']",
                    "#doc-vqmods"};


            for (int i = 0; i < loc1.length; i++) {
                WebElement item = driver.findElement(By.cssSelector(loc1[i]));
                item.getText();
                System.out.println("item.getText(); = " + item.getText());
                item.click();
                List<WebElement> hs = driver.findElements(By.cssSelector("h1"));
                for (WebElement wb : hs)
                {
                    System.out.println("Name inH1 = " + wb.getText());
                }
                System.out.println("Numder of H1 = " + hs.size() + "\n----------------");

            }
        }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }


}
