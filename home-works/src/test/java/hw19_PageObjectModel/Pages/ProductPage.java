package hw19_PageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ProductPage extends Page {
    private CartPage cartPage = new CartPage(driver);
    public ProductPage(WebDriver driver) {
            super(driver);
        }


public void addToBasket()
{int quantityOnCartInt = cartPage.Summ();
    String quantityOnCartAfter = String.valueOf(quantityOnCartInt + 1);
    WebElement buttonAdd = wait.until(presenceOfElementLocated(By.cssSelector("div#box-product button[name='add_cart_product']")));
    buttonAdd.click();

    try{
        WebElement optionSize = wait.until(presenceOfElementLocated(By.cssSelector("div#box-product select[name='options[Size]']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=1; arguments[0].dispatchEvent(new Event ('change'));", optionSize);
        driver.findElement(By.cssSelector("div#box-product button[name='add_cart_product']")).click();
    }catch (Exception ex) {}
    wait.until(ExpectedConditions.textToBePresentInElement(cartPage.quantity(), quantityOnCartAfter));
}
}
