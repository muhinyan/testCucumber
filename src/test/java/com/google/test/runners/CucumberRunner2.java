package com.google.test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/google/test/features/open.feature",
        glue = "com.google.test",
        tags = {"@testOpen"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "pretty", "json:target/cucumber-report/report.json"},
        strict = true
)
public class CucumberRunner2 {

}
