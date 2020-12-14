package org.example.Page;
import org.example.Base.BasePage;
import org.example.Objects.HomePageObjects;
import org.example.Utils.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public ProductListPage search(String searchText){
        click(HomePageObjects.searchText);
        waitSeconds(1);
        write(HomePageObjects.searchText,searchText);
        waitSeconds(3);
        click(HomePageObjects.searchButton);
        return new ProductListPage(driver,wait);
    }

    public LoginPage toLoginPage(){
        clickWithOnFocus(HomePageObjects.openLoginPopup);
        click(HomePageObjects.toLoginPageButton);
        return new LoginPage(driver,wait);
    }

    public void checkLogin(){
        String expectedLoginUsername=getText(HomePageObjects.loginControl);
        Assert.assertEquals(expectedLoginUsername,Constants.usernId);
    }

    public void checkHomePageLoad(){
        Assert.assertEquals(Constants.expectedPageTitle,getPageTitle());
    }
}
