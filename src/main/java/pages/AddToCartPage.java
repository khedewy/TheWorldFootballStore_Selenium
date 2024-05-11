package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage {
    private final WebDriver driver;
    WebDriverWait wait;
    public AddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By size = By.xpath("//*[@id=\"option-2-3-template--17069030801637__main\"]");
    private final By quantityBox = By.name("quantity");
    private final By addToCartButton = By.xpath("//button[@class='atc__button button btn-block style2']");
    private final By viewCartPage = By.xpath("//a[@class='continue-btn hyperlink text-small']");
    private final By AssertionMessage = By.xpath("//a[text()='Official Arsenal Polo - Red']");

    public void addProductToCart(String quantity) throws InterruptedException {
        driver.findElement(size).click();
        driver.findElement(quantityBox).clear();
        driver.findElement(quantityBox).sendKeys(quantity);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(addToCartButton)));
        driver.findElement(addToCartButton).click();
        Thread.sleep(5000);
        driver.findElement(viewCartPage).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }


}
