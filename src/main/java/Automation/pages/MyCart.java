package Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyCart extends BasePage{

    @FindBy(xpath = "//td[@data-title='Product']")
    private WebElement productPrice;

    public MyCart(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public String getProductName() {

        return productPrice.getText().trim();

    }
}
