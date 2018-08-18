package hw17_CheckLogs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class hw17 {


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

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
    @Test
    public void testIt() {
        driver.get("http://localhost/litecart/admin/");

        showLogs(driver,"Logs on Open Start Page ");//////////////

        driver.findElement(By.name("username")).sendKeys("msh");
        driver.findElement(By.name("password")).sendKeys("msh");
        driver.findElement(By.name("login")).click();

        showLogs(driver,"Log after authorization");////////////////

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=2");

        showLogs(driver,"Logs after open Product List ");////////////

        String url = driver.getCurrentUrl();
        List<WebElement> productList = driver.findElements(By.cssSelector("#content tr[class = 'row']"));
        int i = 3;
        do {
       productList = driver.findElements(By.cssSelector("#content tr[class = 'row'] "));
WebElement productCurr = productList.get(i);
            productCurr.findElement(By.tagName("a")).click();
            showLogs(driver,"Log in jumping LP -> P ");//////////////
            driver.get(url);
            showLogs(driver,"Log in jumping LP <- P ");///////////////
            i++;
        }while (i < productList.size());
        showLogs(driver,"Logs when test finished ");////////////
        }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

    public static void showLogs(WebDriver driver,String info)
    {

        for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
            System.out.println(info + " : " +l);
        }
    }
}
