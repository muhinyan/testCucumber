package test.ru.yandex.test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/test/ru/yandex/test/features/searchWiki.feature",
        glue = "test.ru.yandex.test",
        tags = {"@testYandex"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "pretty", "json:target/cucumber-report/report.json"},
        strict = true
)

public class CucumberRunner {

}
