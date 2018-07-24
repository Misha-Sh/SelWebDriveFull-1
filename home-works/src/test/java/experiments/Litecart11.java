package experiments;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class Litecart11 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        //driver = new SafariDriver();// doesn't want to work!!!! ERROR in first invoke of driver.findElement(By.xpath("//li[@id='app-']/a/span[2]")).click();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLitecart11() throws Exception {
        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("msh");
        driver.findElement(By.name("password")).sendKeys("msh");
        driver.findElement(By.name("login")).click();


        driver.findElement(By.xpath("//li[@id='app-']/a/span[2]")).click();

//        driver.findElement(By.xpath("//<li id='app-'> " +
//                "<a href='http://localhost/litecart/admin/?app=appearance&amp;doc=template'>" +
//                "<span class='fa-stack fa-lg icon-wrapper'>" +
//                "<i class='fa fa-circle fa-stack-2x icon-background' style='color: #ff387c;'></i>" +
//                "<i class='fa fa-adjust fa-stack-1x icon' style='color: #fff;'></i>" +
//                "</span> <span class='name'>Appearence</span></a> </li>\n")).click();


        driver.findElement(By.xpath("//li[@id='doc-template']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-logotype']/a/span")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[2]")).click();
        driver.findElement(By.xpath("//li[@id='doc-product_groups']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-option_groups']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-manufacturers']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-suppliers']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-delivery_statuses']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-sold_out_statuses']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-quantity_units']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-csv']/a/span")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[3]")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[4]")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[5]")).click();
        driver.findElement(By.xpath("//li[@id='doc-csv']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-newsletter']/a/span")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[6]")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[7]")).click();
        driver.findElement(By.xpath("//li[@id='doc-storage_encoding']/a/span")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[8]")).click();
        driver.findElement(By.xpath("//li[@id='doc-customer']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-shipping']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-payment']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-order_total']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-order_success']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-order_action']/a/span")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[9]")).click();
        driver.findElement(By.xpath("//li[@id='doc-order_statuses']/a/span")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[10]")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[11]")).click();
        driver.findElement(By.xpath("//li[@id='doc-most_sold_products']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-most_shopping_customers']/a/span")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[12]")).click();
        driver.findElement(By.xpath("//li[@id='doc-defaults']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-general']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-listings']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-images']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-checkout']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-advanced']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-security']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-store_info']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-defaults']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-general']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-listings']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-images']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-checkout']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-advanced']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-security']/a/span")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[13]")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[14]")).click();
        driver.findElement(By.xpath("//li[@id='doc-tax_rates']/a/span")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[14]")).click();
        driver.findElement(By.xpath("//li[@id='doc-tax_rates']/a/span")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[15]")).click();
        driver.findElement(By.xpath("//li[@id='doc-scan']/a/span")).click();
        driver.findElement(By.xpath("//li[@id='doc-csv']/a/span")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[16]")).click();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[17]")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
