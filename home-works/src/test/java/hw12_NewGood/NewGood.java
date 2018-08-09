package hw12_NewGood;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class NewGood {

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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testIt() {
        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("msh");
        driver.findElement(By.name("password")).sendKeys("msh");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.cssSelector("ul#box-apps-menu li:nth-child(2)")).click();
        driver.findElement(By.cssSelector("td#content div a:nth-child(2)")).click();

        //driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(1) > td > label:nth-child(3) > input[type='radio']")).click();
        driver.findElement(By.cssSelector("#tab-general input[value = '1']")).click();

        driver.findElement(By.cssSelector("#tab-general input[name = 'name[en]']")).sendKeys("Duckling1");
        driver.findElement(By.cssSelector("#tab-general input[name = 'code']")).sendKeys("D0001");
        driver.findElement(By.cssSelector("#tab-general input[data-name = 'Rubber Ducks']")).click();



        WebElement def_cat = driver.findElement(By.cssSelector("#tab-general select[name = 'default_category_id']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=1; arguments[0].dispatchEvent(new Event ('change'));", def_cat);

        driver.findElement(By.cssSelector("#tab-general input[value='1-3']")).click();
        WebElement number = driver.findElement(By.cssSelector("#tab-general input[name='quantity']"));
        number.clear();
        number.sendKeys("200");

    WebElement fileInput = driver.findElement(By.cssSelector("#tab-general input[type='file']"));

        Path file = Paths.get("/Users/int58/Documents/GitHub/SelWebDriveFull-1/home-works/src/test/resources/veloSea.jpg");
        Path folder = Paths.get("/Users/int58/Documents/GitHub/SelWebDriveFull-1/home-works");
       Path relativePath = folder.relativize(file);
String filePath = relativePath.toAbsolutePath().toString();
fileInput.sendKeys(filePath);


driver.findElement(By.cssSelector("#tab-general input[name='date_valid_from']")).sendKeys("08.08.2018");
driver.findElement(By.cssSelector("#tab-general input[name='date_valid_to']")).sendKeys("08.08.2020");


        driver.findElement(By.cssSelector("#content a[href = '#tab-information']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement manufacturer = driver.findElement(By.cssSelector("#tab-information select[name = 'manufacturer_id']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=1; arguments[0].dispatchEvent(new Event ('change'));", manufacturer);


driver.findElement(By.cssSelector("#tab-information input[name ='keywords']")).sendKeys("duck, duckling, water");
driver.findElement(By.cssSelector("#tab-information input[name ='short_description[en]']")).sendKeys("New little duck");
driver.findElement(By.cssSelector("#tab-information div.trumbowyg-editor")).sendKeys("A small unsinkable duckling will be with your children in all waters");
    driver.findElement(By.cssSelector("#tab-information input[name ='head_title[en]']")).sendKeys("Duckling");

        driver.findElement(By.cssSelector("#tab-information input[name='meta_description[en]']")).sendKeys("Meta Duckling");

        driver.findElement(By.cssSelector("#content a[href = '#tab-prices']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


WebElement pricePurchase = driver.findElement(By.cssSelector("#tab-prices input[name = 'purchase_price']"));
        pricePurchase.clear();
        pricePurchase.sendKeys("1");

        WebElement pricePurchaseValuta = driver.findElement(By.cssSelector("#table-prices select[name = 'tax_class_id']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=1; arguments[0].dispatchEvent(new Event ('change'));", pricePurchaseValuta);

WebElement priceUSD = driver.findElement(By.cssSelector("#tab-prices input[name='prices[USD]']"));
    priceUSD.clear();
    priceUSD.sendKeys("1.5");

    WebElement priceEVRO = driver.findElement(By.cssSelector("#tab-prices input[name='prices[EUR]']"));

    priceEVRO.clear();
    priceEVRO.sendKeys("0.7");

    driver.findElement(By.cssSelector("#content button[name = 'save']")).click();

    driver.get("http://localhost/litecart/en/");
    driver.findElement(By.cssSelector("a[title = 'Duckling1']")).click();
    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }




}