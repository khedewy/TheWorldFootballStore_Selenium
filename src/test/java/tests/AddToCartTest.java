package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import pages.SearchPage;

public class AddToCartTest extends TestBase{
    HomePage homePage;
    SearchPage searchPage;
    AddToCartPage add;

    @Test
    public void searchForItems(){
        homePage = new HomePage(driver);
        homePage.searchForItems("Arsenal");
        searchPage = new SearchPage(driver);
        Assert.assertEquals(searchPage.gegSearchPageAssertionMessage(),"Search results");
        searchPage.navigateToChosenProduct();
    }

    @Test(priority = 1)
    public void addProductToCart() throws InterruptedException {
        add = new AddToCartPage(driver);
        add.addProductToCart("2");
        Assert.assertEquals(add.getAssertionMessage(),"Official Arsenal Polo - Red");
    }
}
