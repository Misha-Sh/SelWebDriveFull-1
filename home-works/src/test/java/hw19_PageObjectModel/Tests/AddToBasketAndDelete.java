package hw19_PageObjectModel.Tests;

import org.junit.Test;

public class AddToBasketAndDelete extends TestBase {


    @Test
    public void startAddToBusket()
    {
        app.Add3ProductsToBasketAndDeleteFrom();
    }

}
