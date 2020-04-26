package ru.sberbank_ast.test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ru/sberbank_ast/test/features/sberTest.feature",
        glue = "ru.sberbank_ast.test",
        tags = {"@testSberbank_ast"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "pretty", "json:target/cucumber-report/report.json"},
        strict = true
)
public class CucumberRunner1 {
}
