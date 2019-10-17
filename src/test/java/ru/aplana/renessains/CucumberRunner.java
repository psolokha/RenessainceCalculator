package ru.aplana.renessains;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.runner.RunWith;
import ru.aplana.renessains.utils.InitDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
)
public class CucumberRunner {
    @After
    public void closeDriver() {
        InitDriver.getDriver().quit();
    }
}
