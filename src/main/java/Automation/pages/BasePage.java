package Automation.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;

    @FindBy(xpath = "//h1")
    private WebElement pageHeading;

    public String getPageHeading(){

        return pageHeading.getText().trim();

    }

    public void clickOnElement(WebElement element){

        for (int i = 0; i < 5; i++) {

            try {

                WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;
            }catch (Exception e){

            }

        }

    }
}
