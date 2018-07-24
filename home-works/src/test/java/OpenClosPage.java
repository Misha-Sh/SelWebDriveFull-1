import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenClosPage {
    private WebDriverWait wait;
    private WebDriver driver;

    @Before
    public void start() {
       // driver = new SafariDriver();
        driver = new FirefoxDriver();


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
