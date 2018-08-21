package hw19_PageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class BasketPage extends Page{

    public BasketPage(WebDriver driver) {
        super(driver);
    }

public void removeFromBasket()
{
    do {
    List<WebElement> shortcuts = driver.findElements(By.cssSelector("div#box-checkout-cart li[class='shortcut']"));
    if (shortcuts.size() > 0)
        shortcuts.get(0).click();

    WebElement summF = driver.findElement(By.cssSelector("#order_confirmation-wrapper tr.footer td strong"));
    driver.findElement(By.cssSelector("#box-checkout-cart button[name ='remove_cart_item']")).click();

    try {
        wait.until(presenceOfElementLocated(By.cssSelector("div#checkout-cart-wrapper p em")));
        System.out.println("Well, my Basket is Empty!");
        return;
    } catch (Exception ex) { }

    wait.until(stalenessOf(summF));
}while(true);
}
}
