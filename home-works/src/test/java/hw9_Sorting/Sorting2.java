package hw9_Sorting;

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
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.io.File;
        import java.util.List;
        import java.util.TreeSet;
        import java.util.concurrent.TimeUnit;

        import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Sorting2 {
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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testIt() {
        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("msh");
        driver.findElement(By.name("password")).sendKeys("msh");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        String url = "";
        String fact = "";
        List<WebElement> listCountries = driver.findElements(By.cssSelector("tr[class = 'row']  td:nth-child(3) a"));

        for (WebElement country : listCountries) {
            url = url + ";;" + country.getAttribute("href");
        }

        String[] arrUrl = url.split(";;");
System.out.println("Size arrUrl = " + arrUrl.length);
        for (int i = 1; i < arrUrl.length; i++) {
            driver.get(arrUrl[i]);

            List<WebElement> listZones = driver.findElements(By.cssSelector("select[name *= 'zone_code']"));
            for (WebElement zona : listZones) {
                fact = fact + ";;" + zona.getText();

            }

            checkAB(fact);
            fact = "";
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

        public void checkAB(String fact)
        {TreeSet<String> etalon = new TreeSet<>();
            String [] factArr = fact.split(";;");
            int i = 1, flag = 0;
            for(String strE : etalon){
                if(!strE.equalsIgnoreCase(factArr[i]))
                    flag ++;
                i++;
            }
            if(flag > 0)
                System.out.println("Wrong ABC in " + factArr[1]);
            else
                System.out.println("OK ABC in " + factArr[1]);

        }
}
