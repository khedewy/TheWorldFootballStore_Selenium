package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class SearchTest extends TestBase{
    HomePage homePage;
    SearchPage searchPage;

    @Test
    public void searchForItems(){
        homePage = new HomePage(driver);
        homePage.searchForItems("Arsenal");
        searchPage = new SearchPage(driver);
        Assert.assertEquals(searchPage.gegSearchPageAssertionMessage(),"Search results");
        searchPage.navigateToChosenProduct();
    }
}
