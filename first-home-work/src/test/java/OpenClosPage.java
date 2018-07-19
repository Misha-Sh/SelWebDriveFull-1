import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class OpenClosPage {
    private WebDriverWait wait;
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        

    }

    @Test
    public void OpenSite() {
        driver.get("https://www.fifa.com/worldcup/");

    }

    @After
    public void stop(){

        driver.quit();
        driver = null;
    }

}
