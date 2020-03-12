package ru.yandex.test;
import io.qameta.allure.Step;
import jdk.internal.vm.annotation.ReservedStackAccess;
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
    public void поисковый_запрос()
    {
        WebElement searchField=chromeDriver.findElement(By.xpath("//*[@class=\"input__control input__input\"]"));
        WebElement searchButton=chromeDriver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/form/div[2]/button"));
        searchField.click();
        searchField.sendKeys("Гладиолус");
        searchButton.click();

    }
    @Step
    public void поиск_в_выборке()
    {
        List<WebElement> ListOfWebElements=chromeDriver.findElements(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[1]/ul/li[2]/div/div/div[2]/div[1]/div[1]/a[1]/b"));

        for(WebElement we : ListOfWebElements){
            if(we.getText().contains("ru.wikipedia.org"))
            {
                System.out.println("Wiki есть!!!");
                chromeDriver.quit();
            }
        }

    }


    @Step
    public void закрытьХром()
    {
        chromeDriver.quit();
    }

}
