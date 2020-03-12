package com.google.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyStepdefs2 extends Steps2{
    @Given("перейти на сайт '(.*)' и искать Открытие")
    public void перейти_на_сайт_и_искать_Открытие(String site2) {
        открытьХром2();
        chromeDriver.get(site2);
        поисковый_запрос2();
    }

    @Given("найти Открытие в результатах поиска и перейти")
    public void найти_Открытие_в_результатах_поиска_и_перейти() {
        поиск_сайта();
        перейти_на_сайт();

    }

    @Given("получить значения валюты")
    public void получить_значения_валюты()
    {
        получить_и_преобразовать();
    }

    @Given("сравнить валюту")
    public void сравнить_валюту() {
        сравнить_значения();

    }

    @Then("закончить работу")
    public void закончить_работу() {
        закрытьХром();
    }
}
