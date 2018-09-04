package upload;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class UploadFile {

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
        //////////// test for Uploading the projects /////////////

//        UUID uniqueKey = UUID.randomUUID();
//        String pref = uniqueKey.toString();
        String projectName = "My 3 project in LM about my BIKE";
        String projectDescription = "My project 33 in LM is too hard for common people! ";
        String keywords = "history, logo, ball";

        ////////////////// enter to account
        driver.get("http://orange.gan4x4.ru/");
        driver.findElement(By.cssSelector("#app a.btn.btn-primary")).click();//Upload button

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.findElement(By.cssSelector("#email")).sendKeys(Keys.HOME + "uu@ii.ru"); /// form -- login
driver.findElement(By.cssSelector("#password")).sendKeys(Keys.HOME + "mmmmmmm");/// form -- psw

        driver.findElement(By.cssSelector("#app button.btn.btn-primary")).click();//Login button!!!!!?

        //////////// enter image file
        WebElement imageFile = driver.findElement(By.cssSelector("input#image_file"));
        Path file = Paths.get("/Users/int58/Documents/GitHub/SelWebDriveFull-1/lmr-web/src/test/resources/veloSea.jpg");
        Path folderF = Paths.get("/Users/int58/Documents/GitHub/SelWebDriveFull-1/lmr-web");
        Path relativePath = folderF.relativize(file);
        String filePath = relativePath.toAbsolutePath().toString();
        imageFile.sendKeys(filePath);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //////////// enter project file

        WebElement projectFile = driver.findElement(By.cssSelector("input#project_file"));
        Path file2 = Paths.get("/Users/int58/Documents/GitHub/SelWebDriveFull-1/lmr-web/src/test/resources/velosip.mj3");
        Path folderF2 = Paths.get("/Users/int58/Documents/GitHub/SelWebDriveFull-1/lmr-web");
        Path relativePath2 = folderF2.relativize(file2);
        String filePath2 = relativePath2.toAbsolutePath().toString();
        projectFile.sendKeys(filePath2);

        ///////// enter name, description, keywords

        driver.findElement(By.cssSelector("#name")).sendKeys(Keys.HOME + projectName);
        driver.findElement(By.cssSelector("#description")).sendKeys(Keys.HOME + projectDescription);
        driver.findElement(By.cssSelector("#tags")).sendKeys(Keys.HOME + keywords);

        ///// choose folder ///////////////////
        WebElement folder = driver.findElement(By.cssSelector("select#folder_id"));
                ///// shoose line 1 in drop down list of folders
     ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=1; arguments[0].dispatchEvent(new Event ('change'));", folder);

     String folderListValue = folder.getAttribute("value");/////value of selected line
        // System.out.println("value of selected folder line " + folderListValue);


        ///// check/unchek flag Private
        WebElement privateCheck = driver.findElement(By.cssSelector("div.checkbox input[name = 'private']"));
        //privateCheck.click();

        ////// shoose curriculum to line 1
        WebElement curriculum = driver.findElement(By.cssSelector("select#curriculum"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=1; arguments[0].dispatchEvent(new Event ('change'));", curriculum);
        ////// shoose level to line 2
        WebElement gradeLevel = driver.findElement(By.cssSelector("select#grade"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=2; arguments[0].dispatchEvent(new Event ('change'));", gradeLevel);

        ////////////// click Upload
        driver.findElement(By.cssSelector("input[type = 'submit']")).click();

//////////// page My projects///////////////

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        ///////// is correct folder opened?
        String pageURL = driver.getCurrentUrl();
        System.out.println(pageURL);
        if ( pageURL.contains("folder_id="+folderListValue))
            System.out.println("OK! It's my folder");
        else
            System.out.println("!!!PROBLEM! It's NO my folder!!!");

        ///////////// is project in his folder? /////////
        List<WebElement> mpCarts = driver.findElements(By.cssSelector("#form_all div.col-md-3"));
int flagIAMHere = 0;
        for (WebElement mpC : mpCarts){
            if(
                mpC.findElement(By.cssSelector("a h2")).getAttribute("innerText").equals(projectName))
                flagIAMHere++;
//                defaultValue:"79"
        }
        if(flagIAMHere == 0)
            System.out.println("!!!PROBLEM! I am  NOt in my folder!!!");
        else
        if(flagIAMHere == 1)
            System.out.println("OK! I am HERE and ALONE");
        else
            if (flagIAMHere > 1)
                System.out.println("Well! But user uploaded projects with the same names ");






    }

   // @After
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }
}
