package Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavigationBar extends BasePage{

    @FindBy(xpath = "(//a[@data-tooltip='Wishlist'])[1]")
    private WebElement wishList;

    @FindBy(xpath = "(//a[@data-tooltip='Cart'])[1]")
    private WebElement myCart;

    public TopNavigationBar(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public MyWishList clickOnWishList(){

        clickOnElement(wishList);
        return new MyWishList(driver);

    }

    public MyCart clickOnMyCart(){

        clickOnElement(myCart);
        return new MyCart(driver);

    }

}
