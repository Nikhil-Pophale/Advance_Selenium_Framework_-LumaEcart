package org.TTA.Resources;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "",
        features = {"src/main/java/org/TTA/Resources/LumaEcart.feature"},
        glue = {"org/TTA/Resources"},
        plugin = { "pretty", "html:target/cucumber-reports.html"}
)

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}


