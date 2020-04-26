package ru.sberbank_ast.test.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.logging.Level;

public class MyStepdefs1 extends Steps1 {

    @Given("перейти на сайт '(.*)'")
    public void перейти_на_сайт(String site)
    {
        ОткрытьХром();
        chromeDriver.get(site);
    }

    @When("выбрать в  {string}{string}")
    public void выбрать_в(String zakupki, String vidZakupki) {
        Поиск_в_SubMenu(zakupki, vidZakupki);
    }

    @When("ввести в поле {string}")
    public void ввести_в_поле(String strahovanie) throws InterruptedException {
        Поиск_по_ключевому_слову(strahovanie);
        Thread.sleep(3000);
    }

    @When("проверить {int} элементов, найти цену больше {int}")
    public void проверить_элементов(Integer amountOfElements,Integer minPrice) throws InterruptedException {
        int currentElement=0, page=1;

        while (currentElement < amountOfElements) {
            Обновить_список_Цен();
            Обновить_номера_договоров();
            Обновить_список_ссылок();

            for (int j = 0; j < Получить_список_цен().size(); j++) {
                if (currentElement < amountOfElements) {
                    currentElement++;
                    double doublePrice = Double.parseDouble(Получить_список_цен().get(j).getText().replaceAll("\\s", ""));

                    Добавить_подходящие(doublePrice,j,minPrice);
                }
            }
            page++;
            if (page>=7)
                break;
            Нажать_кнопку_далее(page);
            Thread.sleep(4000);
        }

    }
    @Then("вывести номера сделок и ссылки")
    public void вывести_номера_сделок_и_ссылки(){
        log.log(Level.INFO,"Номера сделок:"+Получить_список_подходящих_элементов());
    }

    @Then("более {int} элементов удовлетворяют условиям")
    public void более_элементов_больше(Integer minNumbOfElements) {
        Boolean check=false;
        if (Получить_список_подходящих_элементов().size()>=minNumbOfElements)
            check=true;
        Assert.assertTrue(check);
    }

    @Then("закончить тест")
    public void закончить_тест() {
        закрытьХром();

    }
}
