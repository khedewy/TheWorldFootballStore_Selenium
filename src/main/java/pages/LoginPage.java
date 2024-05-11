package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By logoutButton = By.xpath("//a[@class='unstyled-link button xsmall-btn icon-btn right-icon style2']");
    private final By IconManager = By.xpath("//a[@title='Log in']");
    private final By emailTxt = By.id("CustomerEmail");
    private final By passwordTxt = By.id("CustomerPassword");
    private final By loginButton = By.xpath("//*[@id=\"customer_login\"]/button");
    private final By AssertionMessage = By.xpath("//p[text()='Mahmoud Khedwewy']");

    public void logoutAndNavigateToLoginPage(){
        driver.findElement(logoutButton).click();
        driver.findElement(IconManager).click();
    }

    public void enterLoginData(String email,String password){
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }




}
