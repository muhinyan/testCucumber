package ru.yandex.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyStepdefs extends Steps {
    @Given("перейти на сайт '(.*)'")
    public void перейти_на_сайт(String site)
    {
        открытьХром();
        chromeDriver.get(site);
    }
    @Given("искать Гладиолус")
    public void искать_Гладиолус()
    {
        поисковый_запрос();
        //throw new cucumber.api.PendingException();
    }
    @Given("найти в листе элементов")
    public void найти_в_листе_элементов()
    {
        поиск_в_выборке();
    }
    @Then("закончить работу")
    public void закончить_работу()
    {
        закрытьХром();
    }




}
