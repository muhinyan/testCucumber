package test.ru.yandex.test.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyStepdefs extends Steps {
    @Given("перейти на сайт '(.*)'")
    public void перейти_на_сайт(String site)
    {
        открытьХром();
        chromeDriver.get(site);
    }
    @Given("искать {string}")
    public void искать_Гладиолус(String search_word)
    {
        поисковый_запрос(search_word);
    }
    @Given("найти в результатах поиска {string}")
    public void найти_в_листе_элементов(String site)
    {
        поиск_в_выборке(site);
    }
    @Then("закончить работу")
    public void закончить_работу()
    {
        закрытьХром();
    }




}
