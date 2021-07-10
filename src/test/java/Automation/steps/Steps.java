package Automation.steps;

import Automation.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Steps {

    public HomePage homePage;
    public ProductDescription productDescription;
    public TopNavigationBar topNavigationBar;
    public MyWishList myWishList;
    public MyCart myCart;

    public static WebDriver driver;

    public static List<String> expectedProductsList;

    public static String lowestPrice;
    public static String lowestPriceProd;

    @Given("I add four different products to my wish list")
    public void iAddFourDifferentProductsToMyWishList(DataTable productsList) {

        expectedProductsList = new ArrayList<String>();

        List<String> ProductsList = (List<String>) productsList.asList();

        Iterator<String> it = ProductsList.iterator();

        homePage = new HomePage(driver);

        while (it.hasNext()){

            String productName = it.next().trim();
            expectedProductsList.add(productName);
            homePage.searchForProducts(productName);
            productDescription = homePage.clickOnSearchButton();
            productDescription.clickOnAddToWishListLink();

        }

        topNavigationBar = new TopNavigationBar(driver);
        myWishList = topNavigationBar.clickOnWishList();
    }

    @When("I view my wishlist table")
    public void iViewMyWishlistTable() {

        String actualText = myWishList.getPageHeading();
        Assert.assertEquals("Error in navigating to My Wishlist Page","Wishlist",actualText);

    }

    @Then("I find total four selected items in my Wishlist")
    public void iFindTotalFourSelectedItemsInMyWishlist() {

        List<String> actualList = myWishList.getProductNameList();
        Collections.sort(actualList);
        Collections.sort(expectedProductsList);
        Assert.assertTrue(actualList.equals(expectedProductsList));
    }

    @When("I search for lowest price product")
    public void iSearchForLowestPriceProduct() {

        lowestPrice = myWishList.getLowestUnitPrice();

    }

    @And("I am able to add the lowest price item to my cart")
    public void iAmAbleToAddTheLowestPriceItemToMyCart() {

        lowestPriceProd = myWishList.lowestPriceProdName(lowestPrice);
        myWishList.addToCart(lowestPrice);
        myWishList.isSuccessMessage();

    }

    @Then("I am able to verify the item in my cart")
    public void iAmAbleToVerifyTheItemInMyCart() {

        myCart = topNavigationBar.clickOnMyCart();

        Assert.assertEquals(myCart.getProductName(),lowestPriceProd);


    }

}
