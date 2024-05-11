package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By accountManagerIcon = By.xpath("//a[@class='unstyled-link header__icons-link account']");
    private final By createAccountButton = By.xpath("//*[@id=\"customer_login\"]/div[3]/p/a");
    private final By acceptCookies = By.xpath("//button[text()='Accept']");
    private final By searchIcon = By.xpath("//a[@class='unstyled-link header__icons-link search']");
    private final By searchBox = By.id("Search-In-Template");
    private final By searchButton = By.xpath("//button[@class='mg-search-button seachbar__button']");
    private final By contactUsButton = By.xpath("//a[@class='unstyled-link footer-menu-head text-small with-link']");

    public RegisterPage navigateToRegisterPage(){
        driver.findElement(acceptCookies).click();
        driver.findElement(accountManagerIcon).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(createAccountButton)));
        driver.findElement(createAccountButton).click();
        return new RegisterPage(driver);
    }

    public SearchPage searchForItems(String product){
        driver.findElement(searchIcon).click();
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }

    public ContactUsPage navigateToContactPage(){
        driver.findElement(acceptCookies).click();
        driver.findElement(contactUsButton).click();
        return new ContactUsPage(driver);
    }
}
