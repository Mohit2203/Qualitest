package Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyWishList extends BasePage{

    @FindAll(@FindBy(xpath = "//table[contains(@class,'wishlist_table')]//td[4]"))
    private List<WebElement> unitPriceList;

    @FindAll(@FindBy(xpath = "//table[contains(@class,'wishlist_table')]//td[3]"))
    private List<WebElement> productNameList;

    @FindBy(xpath = "//div[text()='Product added to cart successfully']")
    private WebElement successMessage;

    public MyWishList(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public List<String> getProductNameList(){

        List<String> productName = new ArrayList<String>();

        for (int i = 0; i < productNameList.size(); i++) {

            productName.add(productNameList.get(i).getText().trim());

        }

        return productName;

    }

    public String getLowestUnitPrice(){

        List<String> unitPrice = new ArrayList<String>();

        for (int i = 0; i < unitPriceList.size(); i++) {

            String[] arr = unitPriceList.get(i).getText().trim().split(" ");

            if(arr.length == 2){

                unitPrice.add(arr[1].trim());

            }else {

                unitPrice.add(arr[0].trim());
            }


        }

        Collections.sort(unitPrice);

        return unitPrice.get(0).replace("£","");

    }

    public String lowestPriceProdName(String lowestPrice){

        return driver.findElement(By.xpath("(//*[*[*[*[*[text()='"+lowestPrice+"']]]]])[1]//td[3]")).getText().trim();

    }

    public void addToCart(String lowestPrice) {


        WebElement addToCart = driver.findElement(By.xpath("(//*[text()="+lowestPrice+"]/following::a)[1]"));
        clickOnElement(addToCart);

    }

    public boolean isSuccessMessage() {

        try {

            return successMessage.isDisplayed();

        }catch (Exception e){

            return false;

        }

    }
}