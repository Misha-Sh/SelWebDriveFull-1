package hw19_PageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(css = "div#cart a span.quantity")
//    public WebElement quantity;
   public WebElement quantity(){
        WebElement qua = driver.findElement(By.cssSelector("div#cart a span.quantity"));
        return qua;}

//public WebElement quantity = driver.findElement(By.cssSelector("div#cart a span.quantity"));

//    @FindBy(css = "#cart  a.link")
//    public WebElement linkCheckout;

public WebElement linkCheckout ()
{
    return driver.findElement(By.cssSelector("#cart  a.link"));
}

    public int Summ()
    {
        //WebElement cart = driver.findElement(By.cssSelector("div#cart a span.quantity"));
        String quantityOnCart = quantity().getText();
        int quantityOnCartInt = Integer.parseInt(quantityOnCart);
        return quantityOnCartInt;
    }
}
