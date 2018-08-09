package hw11_FillForm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Registration {

    private WebDriver driver;

    @Before

    public void start()
    {
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
        FirefoxOptions options = new FirefoxOptions();
          options.setBinary(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin")));
          driver = new FirefoxDriver(options);
//////////////////////////////////////////////////////////////////
        ////////////// For Chrome ///////////////////
        //driver = new ChromeDriver();
        //////////////////////For Safari ////////////////////
        //driver = new SafariDriver();
/////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }
    @Test
    public void test(){
        driver.get("http://localhost/litecart/en/create_account");
      //WebElement form = driver.findElement(By.cssSelector("div#create-account div form input"));
      // ((JavascriptExecutor) driver).executeScript("arguments[0].style.opacity=1;", form);
     driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='tax_id']")).sendKeys(Keys.HOME + "TaxID030303");
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='company']")).sendKeys(Keys.HOME + "Meteor");
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='firstname']")).sendKeys(Keys.HOME + "FirstName");
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='lastname']")).sendKeys(Keys.HOME + "LastName");
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='address1']")).sendKeys(Keys.HOME + "Address1");
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='address2']")).sendKeys(Keys.HOME + "Address2");
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='postcode']")).sendKeys(Keys.HOME + "54321");
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='city']")).sendKeys(Keys.HOME + "Lubertsy");
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='email']")).sendKeys(Keys.HOME + "pet24@pet.pet");
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='phone']")).sendKeys(Keys.HOME + "+7 232 333 5544");

        WebElement countries = driver.findElement(By.cssSelector("div#create-account div form table tbody tr td select[name='country_code']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=224; arguments[0].dispatchEvent(new Event ('change'));", countries);

        WebElement zones = driver.findElement(By.cssSelector("div#create-account div form table tbody tr td select[name='zone_code']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=5; arguments[0].dispatchEvent(new Event ('change'));", zones);


        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td label input[name='newsletter']")).click();
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='password']")).sendKeys(Keys.HOME + "mypassword");
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td input[name='confirmed_password']")).sendKeys(Keys.HOME + "mypassword");
        driver.findElement(By.cssSelector("div#create-account div form table tbody tr td button[name='create_account']")).click();

        driver.findElement(By.linkText("Logout")).click();

        driver.findElement(By.cssSelector("#box-account-login input[name='email']")).sendKeys(Keys.HOME + "pet24@pet.pet");
        driver.findElement(By.cssSelector("#box-account-login input[name='password']")).sendKeys(Keys.HOME + "mypassword");
        driver.findElement(By.cssSelector("#box-account-login button[name ='login']")).click();

        driver.findElement(By.linkText("Logout")).click();

    }
//
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }




}
