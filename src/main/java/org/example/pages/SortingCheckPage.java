package org.example.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Data
public class SortingCheckPage extends BasePage {
    protected WebDriver driver;
    @FindBy(xpath = "//span[text()=\"Пицца\"]")
    private WebElement pizzaMenu;
    @FindBy(xpath = "//span[@class=\"selection\"]")
    private WebElement sortBy;
    @FindBy(xpath = "//li[contains(text(),'по убыванию цены')]")
    private WebElement descendingPrice;
    @FindBy(xpath = "//li[contains(text(),'по возрастанию цены')]")
    private WebElement ascendingPrice;
    @FindBy(xpath = "//div[@class=\"price\"]")
    private List<WebElement> pricesDescendingPrice;
    @FindBy(xpath = "//div[@class=\"product_to_basket price_mods\"]")
    private List<WebElement> pricesAscendingPrice;

    public SortingCheckPage(WebDriver driver) {
        super(driver);
    }
}
