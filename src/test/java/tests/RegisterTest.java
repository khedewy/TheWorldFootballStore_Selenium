package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;
import java.time.Duration;

public class RegisterTest extends TestBase {
   HomePage homePage;
   RegisterData data;
   RegisterPage registerPage;
   String currentTime = String.valueOf(System.currentTimeMillis());
   WebDriverWait wait;
    @Test
    public void navigateToRegisterPage(){
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, InterruptedException {
        registerPage = new RegisterPage(driver);
        data = new RegisterData();
        data.testData();
        registerPage.enterRegisterData(data.firstName, data.lastName, data.email+currentTime+"@gmail.com", data.password);
    }

    @Test(priority = 2)
    public void navigateToAccountManager() throws InterruptedException {
        registerPage = new RegisterPage(driver);
        registerPage.navigateToAccountManager();
    }

    @Test(priority = 3)
    public void assertRegistering(){
        registerPage = new RegisterPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertEquals(registerPage.getAssertionMessage(),"Mahmoud Khedwewy\n" +
                "Egypt");
    }

}
