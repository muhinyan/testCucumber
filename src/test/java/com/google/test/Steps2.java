package com.google.test;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Steps2 {
    WebDriver chromeDriver;
    boolean vhod;
    WebElement[] rate=new WebElement[4];
    String[] kostyl=new String[4];
    Double[] PrRate=new Double[4];


    @Step
    public void открытьХром2()
    {
        System.setProperty("webdriver.chrome.driver","/Users/mhn/Documents/chromedriver");
        chromeDriver=new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
    @Step
    public void поисковый_запрос2()
    {
        WebElement searchField=chromeDriver.findElement(By.xpath("//*[@class=\"gLFyf gsfi\"]"));
        WebElement searchButton=chromeDriver.findElement(By.xpath("//*[@class=\"gNO89b\"]"));
        searchField.click();
        searchField.sendKeys("Открытие");
        searchButton.click();

    }

    //public void поиск_сайта(String siteOpenru)
    @Step
    public void поиск_сайта()
    {
        List<WebElement> ListOfWebElements=chromeDriver.findElements(By.xpath("//*[@class=\"TbwUpd\"]//cite"));

        for(WebElement we : ListOfWebElements)
        {
            //if(we.getText().contains(siteOpenru))
            if(we.getText().contains("www.open.ru"))
               vhod=true;

        }
     }
     @Step
     public void перейти_на_сайт ()
     {
         if (vhod==true)
             chromeDriver.get("https://www.open.ru/");
         else
             chromeDriver.quit();
     }

    @Step
     public void получить_и_преобразовать()
     {

         rate[0]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div/span"));
         rate[1]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/div/span"));
         rate[2]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[3]/td[4]/div/span"));
         rate[3]=chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[3]/td[2]/div/span"));
         for (int i=0;i<4;i++)
         {
             kostyl[i]=rate[i].getText().toString();
             kostyl[i]=kostyl[i].replace(',','.');
             PrRate[i]=Double.parseDouble(kostyl[i]);
         }
     }
    @Step
     public void сравнить_значения()
     {
         if (PrRate[0]>PrRate[1])
         {
             System.out.println("Курс USD: Продажа "+PrRate[0]+" > покупки "+PrRate[1]);
         }
         if (PrRate[2]>PrRate[3])
         {
             System.out.println("Курс EUR: Продажа "+PrRate[2]+" > покупки "+PrRate[3]);
         }
     }
    @Step
    public void закрытьХром()
    {
        chromeDriver.quit();
    }


}
