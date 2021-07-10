import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/test/resources/Features/ProductOrder.feature",
                glue= {"classpath:Automation.steps"},
                tags = {"@TestID-001"}
        )
public class TestRunner {



}
