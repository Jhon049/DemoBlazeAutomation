package stepDefinitions;

import contextManager.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    TestContext testContext;
    WebDriver driver;
    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }
    public Hooks() {
        this.testContext = new TestContext();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }
    @After
    public void afterSteps() {
        testContext.getDriverManager().closeDriver();
    }
}
