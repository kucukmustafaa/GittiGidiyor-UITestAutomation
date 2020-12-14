package org.example.Objects;

import org.openqa.selenium.By;

public class ProductListPageObjects {
    public static final By searchResultText=By.xpath("//span[@class=\"search-result-keyword\"]");
    public static final By productList=By.cssSelector("ul[class=\"catalog-view clearfix products-container\"]>li");
}
