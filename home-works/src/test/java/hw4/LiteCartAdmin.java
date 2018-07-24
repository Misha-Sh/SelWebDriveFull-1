package hw4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LiteCartAdmin {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
            public void start(){
       //driver = new ChromeDriver();
        driver = new SafariDriver();
        //driver = new FirefoxDriver();
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
