import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest {

    private WebDriver driver;
    private WebDriverWait wait;


@Before
    public void start() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 30);
}

@Test
    public void myFirstTest() {
    driver.get("http://www.google.com/");
    //driver.navigate().to("http://www.google.com");
    driver.findElement(By.name("q")).sendKeys("divider");
    driver.findElement(By.name("btnK")).click();
    //driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    wait.until(titleIs("divider - Поиск в Google"));

}

    @After
            public void stop(){

        driver.quit();
        driver = null;
    }



}
