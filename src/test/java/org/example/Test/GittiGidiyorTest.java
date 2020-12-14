package org.example.Test;
import org.apache.log4j.Logger;
import org.example.Base.BaseTest;
import org.example.Page.HomePage;
import org.example.Utils.Constants;
import org.junit.Test;


public class GittiGidiyorTest extends BaseTest {

    private static Logger logger = Logger.getLogger(GittiGidiyorTest.class);

    @Test
    public void homeTest(){
        new HomePage(driver,wait)
                .checkHomePageLoad();
    }

    @Test
    public void searchTest(){
        new HomePage(driver,wait)
                .toLoginPage()
                .login(Constants.username,Constants.password)
                .search("bilgisayar")
                .checkSearchResult();
    }

    @Test
    public void loginTest(){
        new HomePage(driver,wait)
                .toLoginPage()
                .login(Constants.username,Constants.password)
                .checkLogin();
    }

    @Test
    public void selectRandomProduct(){
        new HomePage(driver,wait)
                .toLoginPage()
                .login(Constants.username,Constants.password)
                .search("bilgisayar")
                .selectProduct();
    }



}
