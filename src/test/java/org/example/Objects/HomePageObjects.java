package org.example.Objects;

import org.openqa.selenium.By;

public class HomePageObjects {

    public static final By searchText=By.xpath("//input[@placeholder=\"Aklına gelenler kapına gelsin\"]");
    public static final By openLoginPopup=By.xpath("//div[@title=\"Giriş Yap\"]");
    public static final By toLoginPageButton=By.xpath("//a[contains(@href,\"https://www.gittigidiyor.com/uye-girisi\")]");
    public static final By searchButton=By.xpath("//button//span[text()=\"BUL\"]");
    public static final By loginControl=By.cssSelector("div[class=\"style__ActionText-gekhq4-4 bOtXUx\"]>span");

}
