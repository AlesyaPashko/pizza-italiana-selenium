package org.example.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Data
public class BasketPage extends BasePage {
    protected WebDriver driver;
    @FindBy(xpath = "//span[text()=\"Ролотто\"]")
    private WebElement rolottoMenu;
    @FindBy(xpath = "//a[@href=\"/catalog/rolly/rolotto-bono/\"]")
    private WebElement bestRolotto;
    @FindBy(xpath = "//a[text()=\"Ветчина\"]")
    private WebElement meetChoice;
    @FindBy(xpath = "//input[@onclick=\"CountProductCart(this, 1)\"]")
    private WebElement oneMorePlease;
    @FindBy(xpath = "//a[@class=\"add_to_basket\"]")
    private WebElement putRolottoInBasket;
    @FindBy(xpath = "//div[@class=\"price\"]")
    private WebElement twoRolottoPrice;
    @FindBy(xpath = "//a[@href=\"/catalog/kholodnye-napitki/\"]//span")
    private WebElement drinksMenu;
    @FindBy(xpath = "//div[@class=\"nikolaus_pizza_product product_id_339 set_mh\"]")
    private WebElement cola;
    @FindBy(xpath = "//a[@class=\"add_to_basket\"]")
    private WebElement putColaInBasket;
    @FindBy(xpath = "//a[@href=\"/checkout/\"]")
    private WebElement basket;
    @FindBy(xpath = "//div[@class=\"total_amount_summ\"]//span")
    private WebElement totalPrice;
    @FindBy(xpath = "//div[@class=\"mb_product\"]")
    private List<WebElement> orderList;
    public BasketPage(WebDriver driver) {
        super(driver);
    }
}
