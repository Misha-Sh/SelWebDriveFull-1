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

public class Sorting {
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


        driver.findElement(By.linkText("Countries")).click();

        List<WebElement> listCountries = driver.findElements(By.cssSelector("table[class = 'dataTable']  td:nth-child(5)"));
        List<WebElement> listZones = driver.findElements(By.cssSelector("table[class = 'dataTable'] td:nth-child(6)"));

        String countryZonaNonNull = "";////////////////////////// for country with zones > 0
        String fact = "";
        String strCur = "";
        int index = 0;
        for (WebElement wb : listCountries) {
            strCur = wb.getText();
            fact = fact + ";;" + strCur;

            if (!listZones.get(index).getText().equals("0"))  ////////////////////////// find country with zones > 0
                countryZonaNonNull = countryZonaNonNull + ";;" + Integer.toString(index);///////////////////////////
            index++;
        }

        checkAB(fact);

        ////////// check zones of country ///////////////////////////////////////////////////////////////////////
        if (countryZonaNonNull.length() < 2)
            return;

        String[] arrCountry = countryZonaNonNull.split(";;");
        int [] arCountryInt = new int[arrCountry.length - 1];/// make int array of indexes of country /////////

String countryName = "";
        for (int i = 0, j = 1; i < arCountryInt.length; i++, j ++) {
            arCountryInt[i] = Integer.parseInt(arrCountry[j]);
            System.out.println(arrCountry[j]);///////////only for me////////////////////////////
        }
        for (int j = 0; j < arCountryInt.length; j++) {

            List<WebElement> listCountries1 = driver.findElements(By.cssSelector("table[class = 'dataTable']  td:nth-child(5) "));
            countryName =  listCountries1.get(arCountryInt[j]).getText();///// only for me
            System.out.println("On page Country " + j+ " time. Country name: " + countryName);////only for me

            driver.findElement(By.linkText(countryName)).click();//click on country with zones >0

            List<WebElement> listZones2 = driver.findElements(By.cssSelector("table#table-zones  td:nth-child(3)"));

String fact1 = "";
            for (WebElement wb1 : listZones2) {
                strCur = wb1.getText();
                fact1 = fact1 + ";;" + strCur;

            }
            checkAB(fact1);
            driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");///return - 1 page
        }

    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

        /////// check AB /////////////////////////////////////////////////////////////////
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
//////////////////////////////////////////////////////////////////////////////////////
    }










