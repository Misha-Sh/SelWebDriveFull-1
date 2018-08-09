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


int size = 0, sizeDoc = 0, i = 0, j = 0;
String nameItem ="";
        do
        {
            List<WebElement> list = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-"));
            size = list.size();
            if(size == 0 || i >= size)
                break;
            nameItem = list.get(i).getText();

            list.get(i).click();
            List<WebElement> hs0 = driver.findElements(By.cssSelector("#content h1[style = 'margin-top: 0px;']"));
            if (hs0.size() != 1)
                System.out.println("ERROR! Problem with TITLE in Content: " + nameItem);

            do {
                List<WebElement> listDocs = driver.findElements(By.cssSelector("li#app-[class ='selected'] span[class = 'name']"));
                sizeDoc = listDocs.size();
                if(sizeDoc == 0 || j >= sizeDoc)
                    break;
                nameItem = listDocs.get(i).getText();
                listDocs.get(j).click();
                List<WebElement> hs = driver.findElements(By.cssSelector("#content h1[style = 'margin-top: 0px;']"));

                if (hs.size() != 1)
                System.out.println("ERROR! Problem with TITLE in Content: " + nameItem);
            j++;
            }while(true);
        i++;
        }while(true);
    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }


}
