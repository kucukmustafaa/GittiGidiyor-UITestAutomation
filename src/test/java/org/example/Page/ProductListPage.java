package org.example.Page;
import org.example.Base.BasePage;
import org.example.Objects.ProductListPageObjects;
import org.example.Utils.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;


public class ProductListPage extends BasePage {

    public ProductListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void checkSearchResult(){
        WebElement element=getElement(ProductListPageObjects.searchResultText);
        Assert.assertEquals(Constants.expectedSearchResultText,element.getText());
    }

    public ProductDetailPage selectProduct(){
        List<WebElement> productList=getElementList(ProductListPageObjects.productList);
        int randomNumber=new Random().nextInt(10);
        WebElement element=productList.get(randomNumber);
        element.click();
        return new ProductDetailPage(driver,wait);
    }


}
