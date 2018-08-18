package hw16Cloud;


    import org.openqa.selenium.*;
    import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.net.URL;

    import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class hw16 {

        public static final String USERNAME = "misha178";
        public static final String AUTOMATE_KEY = "S2PHqnB59Ecztqwz4Csv";
        public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


        public static void main(String[] args) throws Exception {


            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "IE");
            caps.setCapability("browser_version", "8.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "7");
            caps.setCapability("resolution", "1024x768");

            WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
            WebDriverWait wait;
            wait = new WebDriverWait(driver, 30);

            driver.get("http://www.google.com/");

            driver.findElement(By.name("q")).sendKeys("divider");
            driver.findElement(By.name("btnG")).click();

            wait.until(titleIs("divider - Google zoeken"));
            System.out.println(driver.getTitle());
            driver.quit();

        }
    }

