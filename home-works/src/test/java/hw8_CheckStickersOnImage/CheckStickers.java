package hw8_CheckStickersOnImage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class CheckStickers {

    private WebDriver driver;
    @Before
    public void start() {
    ///////////////////////// FireFox ////////////////////////////
    ///////// for FireFoxNightly//////////////////////////
//        FirefoxOptions options = new FirefoxOptions();
//        options.setBinary(new FirefoxBinary(new File("/Applications/FireFoxNightly/Firefox Nightly.app/Contents/MacOS/firefox-bin")));
//        driver = new FirefoxDriver(options);
//        ///////// for FireFox45ESR ///////////////////////////
//    FirefoxOptions options = new FirefoxOptions().setLegacy(true);
//        options.setBinary(new FirefoxBinary(new File("/Applications/FireFox45ESR/Firefox.app/Contents/MacOS/firefox-bin")));
//    driver = new FirefoxDriver(options);
//        ///////////for FireFox Common ///////////////////////
//        FirefoxOptions options = new FirefoxOptions();
//options.setBinary(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin")));
//driver = new FirefoxDriver(options);
//
    ////////////// For Chrome ///////////////////
    /////////////////////////////////////////////
    driver = new ChromeDriver();
    //////////////////////For Safari ////////////////////
    /////////////////////////////////////////////////////
    //driver = new SafariDriver();
/////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
@Test
public void test() {
    driver.get("http://localhost/litecart/");
    WebElement e1 = driver.findElement(By.cssSelector("#box-most-popular"));
    List<WebElement> e11 = e1.findElements(By.cssSelector("li.product.column.shadow.hover-light"));
    System.out.println("--------------\nAmount of pictures in section box-most-popular = " + e11.size());
    int count = 0;
    for (WebElement e111 : e11) {
        if (e111.findElements(By.cssSelector("div.sticker.new")).size() == 1)
            count++;
        if (e111.findElements(By.cssSelector("div.sticker.sale")).size() == 1)
            count++;
        if (count != 1)
            System.out.println("Sticker Problem in box-most-popular");
        count = 0;
    }


    e1 = driver.findElement(By.cssSelector("#box-campaigns"));
    e11 = e1.findElements(By.cssSelector("li.product.column.shadow.hover-light"));
    System.out.println("----------------\nAmount of pictures in section box-campaigns = " + e11.size());
    for (WebElement e111 : e11) {
        if (e111.findElements(By.cssSelector("div.sticker.new")).size() == 1)
            count++;
        if (e111.findElements(By.cssSelector("div.sticker.sale")).size() == 1)
            count++;
        if (count != 1)
            System.out.println("Sticker Problem in box-campaigns");
        count = 0;
    }

    e1 = driver.findElement(By.cssSelector("#box-latest-products"));
    e11 = e1.findElements(By.cssSelector("li.product.column.shadow.hover-light"));
    System.out.println("----------------\nAmount of pictures in section #box-latest-products = " + e11.size());
    for (WebElement e111 : e11) {
        if (e111.findElements(By.cssSelector("div.sticker.new")).size() == 1)
            count++;
        if (e111.findElements(By.cssSelector("div.sticker.sale")).size() == 1)
            count++;
        if (count != 1)
            System.out.println("Sticker Problem in #box-latest-products");
        count = 0;
    }
}
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
