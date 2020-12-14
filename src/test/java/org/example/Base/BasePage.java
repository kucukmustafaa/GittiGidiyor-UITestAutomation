package org.example.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePage {

    protected WebDriverWait wait;
    protected WebDriver driver;
    protected JavascriptExecutor js;
    private   Logger logger;

    public BasePage(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        this.js = (JavascriptExecutor) driver;
        this.logger = Logger.getLogger(BasePage.class);
    }

    protected void click(By by){
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        try {
            element.click();
            logger.info(by.toString()+" elementine tiklandi.");
        }catch (Exception e){
            logger.error(by.toString()+" elementine tiklanamadi.");
        }
    }

    protected void write(By by,String text){
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        try {
            element.sendKeys(text);
            logger.info(by.toString()+" elementine "+text+" degeri yazildi..");
        }catch (Exception e){
            logger.error(by.toString()+" elementine "+text+ "degeri yazilmadi.");
        }
    }

    protected void waitSeconds(int seconds){
        try {
            Thread.sleep(seconds*1000);
            logger.info(seconds+" saniye bekleniyor.");
        } catch (Exception e){
          logger.error("bekleme gerceklesmedi.");
        }
    }

    protected String getText(By by){
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }

    protected WebElement getElement(By by){
        WebElement element=null;
        try {
            element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (ElementNotVisibleException e){
            e.printStackTrace();
        }
        return element;
    }

    protected void clickWithOnFocus(By by){
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        try {
            element.click();
            logger.info(by.toString()+" elementine onFocus ile tiklandi.");
        }catch (Exception e){
            logger.error(by.toString()+" elementine onFocus ile tiklanamadi.");
        }
    }

    protected List<WebElement> getElementList(By by){
        List<WebElement> elementList = null;
        try {
            elementList=this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            logger.info(by.toString()+" elementin listesi geldi.");
        }catch (Exception e){
            logger.error(by.toString()+" element listesi gelmedi..");
        }
        return elementList;
    }

    protected String getPageTitle(){
        return driver.getTitle();
    }




}
