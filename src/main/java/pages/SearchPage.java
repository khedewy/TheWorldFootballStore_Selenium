package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private final WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }
    private final By acceptCookies = By.xpath("//button[text()='Accept']");
    private final By searchPageAssertionMessage = By.xpath("//h3[text()='Search results']");
    private final By chosenProduct = By.xpath("//a[@title='Official Arsenal Polo - Red']");

    public String gegSearchPageAssertionMessage(){
        return driver.findElement(searchPageAssertionMessage).getText();
    }

    public void navigateToChosenProduct(){
        driver.findElement(acceptCookies).click();
        driver.findElement(chosenProduct).click();
    }
}
