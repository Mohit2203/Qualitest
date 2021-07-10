package Automation.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void browserSetup() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        Steps.driver = new ChromeDriver();

        Steps.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Steps.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Steps.driver.manage().window().maximize();

        Steps.driver.get("https://testscriptdemo.com/");
    }

    @After
    public void teardown() {
        Steps.driver.close();
        Steps.driver.quit();
    }

}
