package Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescription extends BasePage{

    @FindBy(xpath = "(//a[@data-title='Add to wishlist'])[1]")
    private WebElement addToWishListLink;

    public ProductDescription(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public void clickOnAddToWishListLink(){

        clickOnElement(addToWishListLink);

    }

}
