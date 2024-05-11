package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoverOverProducts;

public class HoverOverProductsTest extends TestBase{
    HoverOverProducts hoverOverProducts;


    @Test
    public void hoverOverMenProducts(){
        hoverOverProducts = new HoverOverProducts(driver);
        hoverOverProducts.HoverOverMenProducts();
        Assert.assertEquals(hoverOverProducts.getMenAssertionsMessage(),"Mens Tops");
    }

    @Test(priority = 1)
    public void HoverOverKidsProducts(){
        hoverOverProducts = new HoverOverProducts(driver);
        hoverOverProducts.HoverOverKidsProducts();
        Assert.assertEquals(hoverOverProducts.getKidsAccessoriesAssertionMessage(),"Kids Accessories");
    }
}
