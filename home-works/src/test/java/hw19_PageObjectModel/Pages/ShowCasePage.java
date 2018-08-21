package hw19_PageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ShowCasePage extends Page {
    public ShowCasePage(WebDriver driver) {
        super(driver);
    }

public ShowCasePage open()
{
    driver.get("http://localhost/litecart/");
    return this;
}


public void selectProduct()
{
    WebElement product = driver.findElement(By.cssSelector("#box-most-popular li:nth-child(1) a.link div.name"));
    String nameProduct = product.getText();
    System.out.println(nameProduct);
    product.click();
}

}
