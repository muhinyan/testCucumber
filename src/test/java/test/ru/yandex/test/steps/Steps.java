package test.ru.yandex.test.steps;
import io.qameta.allure.Step;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver chromeDriver;


    @Step
    public void открытьХром()
    {
        System.setProperty("webdriver.chrome.driver","/Users/mhn/Documents/chromedriver");
        chromeDriver=new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
    @Step
    public void поисковый_запрос(String search_word)
    {
        WebElement searchField=chromeDriver.findElement(By.xpath("//*[@class=\"input__control input__input\"]"));
        WebElement searchButton=chromeDriver.findElement(By.xpath("//button[@class=\"button suggest2-form__button button_theme_websearch button_size_xl i-bem\"]"));
        searchField.click();
        searchField.sendKeys(search_word);
        searchButton.click();

    }
    @Step
    public void поиск_в_выборке(String site)
    {
        List<WebElement>
                ListOfWebElements=chromeDriver.findElements(By.xpath("//*[@class=\"path path_show-https organic__path\"]"));
        Boolean check=false;

        for(WebElement we : ListOfWebElements){
            if(we.getText().contains(site))
                check=true;
         }
        Assert.assertTrue("Ссылка на Wiki есть",check);
    }


    @Step
    public void закрытьХром()
    {
        chromeDriver.quit();
    }

}
