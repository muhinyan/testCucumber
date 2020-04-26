package ru.sberbank_ast.test.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Steps1 {
    WebDriver chromeDriver;
    public static final Logger log= Logger.getLogger(Steps1.class.getName());
    //public List<WebElement> listOfPrice = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-amount\"]"));
    //public List<WebElement> requestNumb = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-code-term\"]"));
    //public List<WebElement> requestLink = chromeDriver.findElements(By.xpath("//*[@class=\"element-in-one-row\"]/*[@value=\"Просмотр\"]"));
    //public WebElement searchField = chromeDriver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
   // public WebElement searchButton = chromeDriver.findElement(By.xpath("//*[@class=\"mainSearchBar-find\"]"));
    //public Map<String,String> requestNumLink=new HashMap<>();
    //public WebElement nextButton;
    @Step
    public void ОткрытьХром()
    {
        System.setProperty("webdriver.chrome.driver","/Users/mhn/Documents/chromedriver");
        chromeDriver=new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    }

    @Step
    public void Поиск_в_SubMenu(String zakupki,String vid_zakupki){
        WebElement subMenu = chromeDriver.findElement(By.xpath("//li[span=\""+zakupki+"\"]"));
        subMenu.click();
        WebElement linkSubMenu = chromeDriver.findElement(By.xpath("//li[a=\""+(zakupki+vid_zakupki)+"\"]"));
        linkSubMenu.click();
    }
    @Step
    public void Поиск_по_ключевому_слову(String strahovanie){
         WebElement searchField = chromeDriver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
         WebElement searchButton = chromeDriver.findElement(By.xpath("//*[@class=\"mainSearchBar-find\"]"));
        searchField.sendKeys(strahovanie);
        searchButton.click();
    }
    @Step
    public void Обновить_список_Цен(){
        List<WebElement> listOfPrice = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-amount\"]"));
        listOfPrice = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-amount\"]"));
    }
    @Step
    public void Обновить_номера_договоров(){
        List<WebElement> requestNumb = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-code-term\"]"));
        requestNumb = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-code-term\"]"));
    }
    @Step
    public void Обновить_список_ссылок(){
        List<WebElement> requestLink = chromeDriver.findElements(By.xpath("//*[@class=\"element-in-one-row\"]/*[@value=\"Просмотр\"]"));
        requestLink = chromeDriver.findElements(By.xpath("//*[@class=\"element-in-one-row\"]/*[@value=\"Просмотр\"]"));
    }
    @Step
    public List<WebElement> Получить_список_цен(){
        List<WebElement> listOfPrice = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-amount\"]"));
        return listOfPrice;
    }
    @Step
    public void Нажать_кнопку_далее(int page){
        WebElement nextButton;
        nextButton=chromeDriver.findElement(By.xpath("//span[@id=\"pagesControl\"]/span[@id=\"pageButton\"]/span[@content=" + page + "]"));
        nextButton.click();
    }
    @Step
    public void Добавить_подходящие(double price,int j,int minPrice){
        List<WebElement> requestNumb = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-code-term\"]"));
        Map<String,String> requestNumLink=new HashMap<>();
        List<WebElement> requestLink = chromeDriver.findElements(By.xpath("//*[@class=\"element-in-one-row\"]/*[@value=\"Просмотр\"]"));
        if (price>=minPrice)
            requestNumLink.put(requestNumb.get(j).getText(),requestLink.get(j).getText());
    }
    @Step
    public Map<String,String> Получить_список_подходящих_элементов()
    {
        Map<String,String> requestNumLink=new HashMap<>();
        return requestNumLink;
    }
    @Step
    public void закрытьХром()
    {
        chromeDriver.quit();
    }

}
