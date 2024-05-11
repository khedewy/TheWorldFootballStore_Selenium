package tests;

import data.ContactUsData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.io.IOException;

public class ContactUsTest extends TestBase {
    HomePage homePage;
    ContactUsData data;
    ContactUsPage contactUsPage;
    String currentTime  = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToContactUsPage(){
        homePage = new HomePage(driver);
        homePage.navigateToContactPage();
    }

    @Test(priority = 1)
    public void enterContactUsData() throws IOException, ParseException, InterruptedException {
        data = new ContactUsData();
        data.contactUsData();
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.enterContactUsData(data.name, data.email+currentTime+"@gmail.com", data.phone, data.comment);

    }

    @Test(priority = 2)
    public void assertSendingMessageSuccessfully() throws InterruptedException {
        contactUsPage = new ContactUsPage(driver);
        Assert.assertEquals(contactUsPage.getAssertionMessage()
                ,"Thanks for contacting us. We'll get back to you as soon as possible.");
    }
}
