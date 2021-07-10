package Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@name='s']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    public HomePage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public void searchForProducts(String productName){

        searchTextBox.sendKeys(productName);

    }

    public ProductDescription clickOnSearchButton(){

        clickOnElement(searchButton);

        return new ProductDescription(driver);

    }

}
