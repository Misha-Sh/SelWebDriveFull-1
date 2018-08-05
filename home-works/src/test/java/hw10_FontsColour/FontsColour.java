package hw10_FontsColour;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.Color;

import java.io.File;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

public class FontsColour {

    public WebDriver driver;

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
//        FirefoxOptions options = new FirefoxOptions();
//          options.setBinary(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin")));
//          driver = new FirefoxDriver(options);
//////////////////////////////////////////////////////////////////
        ////////////// For Chrome ///////////////////
        //driver = new ChromeDriver();
        //////////////////////For Safari ////////////////////
        driver = new SafariDriver();
/////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }
    @Test
    public void test()
    {///////// Checking the identity of Product names
        driver.get("http://localhost/litecart/");
        // path to detail page:
        String urlOfPrDetails = driver.findElement(By.cssSelector("#box-campaigns a[class = 'link']")).getAttribute("href");
        System.out.println("**************** Main Page *********************");
        WebElement nameProduct_MainPage = driver.findElement(By.cssSelector("#box-campaigns div[class = 'name']"));
        String nameMP = nameProduct_MainPage.getText();

//////////////////// Checking the parametries and identity of Prices //////////////
        driver.get("http://localhost/litecart/");/////////// on Main Page:
                                                    //////////////////// Reg price
    WebElement priceRegMp = driver.findElement(By.cssSelector("#box-campaigns a[class = 'link'] s[class = 'regular-price']"));
    String priceRegMpValue = priceRegMp.getText(); ///price RegularValue and isStrikethrough
        System.out.println("OK! priceReg on Maine Page isStrikethrough");

        String priceRegfontSize = priceRegMp.getCssValue("font-size");///
        String priceRegMpColor = priceRegMp.getCssValue("color"); /// color of price Reg
        colorRedGreyOrWhat(priceRegMpColor,"grey");

                                                    //////////////////////Campaign price
        WebElement priceCampaignMP = driver.findElement(By.cssSelector("#box-campaigns  strong[class = 'campaign-price']"));
        String priceCampaignMpValue = priceCampaignMP.getText();
        System.out.println("OK! price Campaign on Main Page is Strong");///price Campaign, isStrong

        String priceCampaignFontSize = priceCampaignMP.getCssValue("font-size");
        String priceCampaignMpColor = priceCampaignMP.getCssValue("color");
        colorRedGreyOrWhat(priceCampaignMpColor,"red");

                                                                        /// Checking fontSize Reg < fontSize Campaign
if(sizeFontDouble(priceCampaignFontSize) > sizeFontDouble(priceRegfontSize))
    System.out.println("OK! Reg Font Size < Campaign Font Size");
else System.out.println("Wrong! Reg Font Size !< Campaign Font Size");

                                                     ///////////on Details page:
        System.out.println("**************** Details Page *********************");

        driver.get(urlOfPrDetails);
        String nameDP = driver.findElement(By.cssSelector("h1[class = 'title']")).getText();

        WebElement priceRegDp = driver.findElement(By.cssSelector("div [class = 'price-wrapper'] s[class = 'regular-price']"));
        String priceRegDpValue = priceRegDp.getText(); ///price DTValue and isStrikethrough
        System.out.println("OK! priceReg on Details Page isStrikethrough");

        String priceDpRegFontSize = priceRegDp.getCssValue("font-size");///
        String priceRegDpColor = priceRegDp.getCssValue("color"); /// color of price Reg
        colorRedGreyOrWhat(priceRegDpColor,"grey");

        //////////////////////Campaign price
        WebElement priceCampaignDP = driver.findElement(By.cssSelector("div [class = 'price-wrapper']  strong[class = 'campaign-price']"));
        String priceCampaignDpValue = priceCampaignDP.getText();
        System.out.println("OK! price Campaign on Details Page is Strong");///price Campaign, isStrong

        String priceDpCampaignfontSize = priceCampaignDP.getCssValue("font-size");
        String priceCampaignDpColor = priceCampaignDP.getCssValue("color");
        colorRedGreyOrWhat(priceCampaignMpColor,"red");

        /// Checking fontSize Reg < fontSize Campaign
        if(sizeFontDouble(priceDpCampaignfontSize) > sizeFontDouble(priceDpRegFontSize))
            System.out.println("OK! Reg Font Size < Campaign Font Size");
        else System.out.println("Wrong! Reg Font Size !< Campaign Font Size");

// price Value MP = price Value DP ?
        System.out.println("************* Name&Price MP = Name&Price DP? *************");
        if(priceRegDpValue.equals(priceRegMpValue) && priceCampaignDpValue.equals(priceCampaignMpValue))
            System.out.println("OK! Prices on MP and DP are Equals!");
        else
            System.out.println("Wrong !Prices on MP and DP NOT Equals!");

// name product MP = name product DP?
        if(nameMP.equalsIgnoreCase(nameDP))
            System.out.println("OK! NameProduct = NameProductDetails");
        else
            System.out.println("Wrong! NameProduct !!!!!!!= NameProductDetails");
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }





public void colorRedGreyOrWhat (String color, String flagColor)
    {
        int indBeg = color.indexOf('(');
        int indEnd = color.indexOf(')');
        color = color.substring(indBeg +1,indEnd );

        String [] arRGB = color.split(", ");

        if (arRGB[0].equals(arRGB[1]) && arRGB[2].equals(arRGB[1]) && flagColor.equals("grey"))
            System.out.println("OK! priceReg Color = GREY: " + arRGB[0] + " " + arRGB[1]+ " " + arRGB[2]);
else if(!arRGB[0].equals("0") && arRGB[1].equals("0") && arRGB[2].equals("0") && flagColor.equals("red"))
       System.out.println("OK! priceCampaign Color = RED: " +  arRGB[0] + " " + arRGB[1]+ " " + arRGB[2]);
        else
            System.out.println("Wrong! price Color not Grey and not Red: " + " R" + arRGB[0]+ " G" +arRGB[1]+ " B" + arRGB[2]);
    }

    public double sizeFontDouble (String str)
    {int d = str.indexOf('p');
        return Double.valueOf(str.substring(0,d));
    }
}
