package org.example.Page;

import org.example.Base.BasePage;
import org.example.Objects.HomePageObjects;
import org.example.Objects.LoginPageObjects;
import org.example.Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public HomePage login(String username,String password){
        write(LoginPageObjects.username,username);
        waitSeconds(1);
        write(LoginPageObjects.password,password);
        waitSeconds(1);
        click(LoginPageObjects.loginButton);
        return new HomePage(driver,wait);
    }




}
