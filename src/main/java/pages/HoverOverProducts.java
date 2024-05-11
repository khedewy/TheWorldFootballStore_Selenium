package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverOverProducts {
    private final WebDriver driver;
    Actions actions;
    public HoverOverProducts(WebDriver driver){
        this.driver = driver;
    }

    private final By MensProduct = By.xpath("//*[@id=\"shopify-section-sections--17069026738405__header\"]/header/div/div/ul[1]/li[2]/a");
    private final By topsProduct =  By.xpath("//a[@href='/collections/mens-tops']");
    private final By menAssertionsMessage = By.xpath("//h2[text()='Mens Tops']");
    private final By kidsProducts = By.xpath("//*[@id=\"shopify-section-sections--17069026738405__header\"]/header/div/div/ul[1]/li[4]/a");
    private final By accessoriesProducts = By.xpath("//a[@href='/collections/kids-accessories']");
    private final By accessoriesAssertionMessage = By.xpath("//h2[text()='Kids Accessories']");

    public void HoverOverMenProducts(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(MensProduct));
        actions.moveToElement(driver.findElement(topsProduct)).click().perform();
    }

    public String getMenAssertionsMessage(){
        return driver.findElement(menAssertionsMessage).getText();
    }

    public void HoverOverKidsProducts(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(kidsProducts));
        actions.moveToElement(driver.findElement(accessoriesProducts)).click().perform();
    }

    public String getKidsAccessoriesAssertionMessage(){
        return driver.findElement(accessoriesAssertionMessage).getText();
    }
}
