package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    private final WebDriver driver;
    WebDriverWait wait;
    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }

    private final By acceptCookies = By.xpath("//button[text()='Accept']");
    private final By nameTxt = By.id("ContactName");
    private final By emailTxt =  By.id("ContactEmail");
    private final By phoneTxt = By.id("ContactNumber");
    private final By commentTxt = By.id("ContactForm-body");
    private final By sendMessageButton = By.xpath("//button[@class='button med-btn btn-block icon-btn right-icon style2']");
    private final By assertionMessage = By.xpath("//*[@id=\"ContactForm\"]/div[5]/p");

    public void enterContactUsData(String name, String email, String phone, String comment){
        driver.findElement(nameTxt).sendKeys(name);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(phoneTxt).sendKeys(phone);
        driver.findElement(commentTxt).sendKeys(comment);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(sendMessageButton)));
        driver.findElement(sendMessageButton).click();
    }

    public String getAssertionMessage() throws InterruptedException {

        Thread.sleep(5000);
        return driver.findElement(assertionMessage).getText();
    }


}
