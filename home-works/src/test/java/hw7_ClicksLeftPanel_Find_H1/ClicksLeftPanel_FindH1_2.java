package hw7_ClicksLeftPanel_Find_H1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.ByteHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClicksLeftPanel_FindH1_2 {
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
//
        ////////////// For Chrome ///////////////////
        /////////////////////////////////////////////

        driver = new ChromeDriver();
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


driver.findElement(By.id("app-")).click();
int size = 10, sizeDoc = 10 ;
        for(int i = 0; i < size; i++) {
            List<WebElement> list = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-"));
            size = list.size();
            if(size == 0)
                break;
            list.get(i).click();

            for (int j = 0; j < sizeDoc; j ++) {
                List<WebElement> listDocs = driver.findElements(By.cssSelector("li#app-[class ='selected'] span[class = 'name']"));
                sizeDoc = listDocs.size();
                listDocs.get(j).click();
                List<WebElement> hs = driver.findElements(By.cssSelector("h1"));
                for (WebElement wb : hs) {
                    System.out.println("Name inH1 = " + wb.getText());
                }
                System.out.println("Numder of H1 = " + hs.size() + "\n----------------");
            }

        }
    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }


}
