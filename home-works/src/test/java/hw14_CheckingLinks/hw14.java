package hw14_CheckingLinks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class hw14 {
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

        driver.findElement(By.name("username")).sendKeys("msh");
        driver.findElement(By.name("password")).sendKeys("msh");
        driver.findElement(By.name("login")).click();


        driver.get("http://localhost/litecart/admin/?app=countries&doc=edit_country");

        String originalWindow = driver.getWindowHandle();

        int i = 0, size = 0;

        do{
            Set<String> existingWindows= driver.getWindowHandles();
            List<WebElement> links = driver.findElements(By.cssSelector("#content a[target='_blank']"));
            size = links.size();
            links.get(i).click();
            String newWindow = "";
            int flag = 0;
            do{Set<String> newListWindows = driver.getWindowHandles();
            newListWindows.removeAll(existingWindows);
            if(newListWindows.size() == 1){
               newWindow = newListWindows.iterator().next();
               flag = 1;
            }
            }while(flag == 0);

        driver.switchTo().window(newWindow);

        driver.close();
        i++;
        driver.switchTo().window(originalWindow);
        }while(i < size);

    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

////////////////////////////////////////////////////////////////////////////////////


}
