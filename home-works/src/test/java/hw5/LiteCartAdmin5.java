package hw5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LiteCartAdmin5 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){



//     FireFoxESR5290 it works! /  old schema for Selenium >= 3.3!!!!
//
// FirefoxOptions options = new FirefoxOptions().setLegacy(true);
//        options.setBinary(new FirefoxBinary(new File("/Applications/FireFoxESR5290/Firefox.app/Contents/MacOS/firefox-bin")));
//        driver = new FirefoxDriver(options);

//
// FireFox45 doesn't work! BUT WORKS FireFox45ESR!!!
 FirefoxOptions options = new FirefoxOptions().setLegacy(true);
        options.setBinary(new FirefoxBinary(new File("/Applications/FireFox45ESR/Firefox.app/Contents/MacOS/firefox-bin")));
        driver = new FirefoxDriver(options);

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);


    }
    @Test
    public void fillAdminPage()
    {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("msh");
        driver.findElement(By.name("password")).sendKeys("msh");
        driver.findElement(By.name("login")).click();


    }
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
