package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    private final By firstNameTxt = By.id("Customerfirst_name");
    private final By lastNameTxt = By.id("Customer-last_name");
    private final By emailTxt = By.id("Customer-email");
    private final By passwordTxt = By.id("Customer-password");
    private final By registerButton = By.xpath("//button[@class='button med-btn btn-block icon-btn right-icon style2']");
    private final By accountManager = By.xpath("//a[@class='unstyled-link header__icons-link account']");
    private final By AssertionMessage = By.xpath("//p[text()='Mahmoud Khedwewy']");

    public void enterRegisterData(String firstName, String lastName, String email , String password) throws InterruptedException {
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(registerButton)));
        driver.findElement(registerButton).click();
    }

    public void navigateToAccountManager() throws InterruptedException {
//        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(accountManager)));
        Thread.sleep(5000);
        driver.findElement(accountManager).click();
    }

    public String getAssertionMessage(){
        return  driver.findElement(AssertionMessage).getText();
    }

}
