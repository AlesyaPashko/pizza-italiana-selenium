package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.BasketPage;
import org.openqa.selenium.WebDriver;

public class BasketSteps {
    private BasketPage basketPage;
    @Step("Open rolotto menu")
    public void openRolottoMenu() {
        basketPage.getRolottoMenu().click();
    }
    @Step("Choose best rolotto")
    public void chooseBestRolotto() {
        basketPage.getBestRolotto().click();
    }
    @Step("Choose meet")
    public void meetChoice() {
        basketPage.getMeetChoice().click();
    }
    @Step("Take one more")
    public void oneMorePlease() {
        basketPage.getOneMorePlease().click();
    }
    @Step("Put rolotto in basket")
    public void putRolottoInBasket(){
        basketPage.getPutRolottoInBasket().click();
    }
    @Step("Open basket")
    public void openBasket() {
        basketPage.getBasket().click();
    }
    @Step("Get total price")
    public double totalPrice() {
        return Double.parseDouble(basketPage.getTotalPrice().getText().replaceAll(" руб.",""));
    }
    @Step("Open drinks menu")
    public void drinksMenu(){
        basketPage.getDrinksMenu().click();
    }
    @Step("Choose cola")
    public void chooseCola(){
        basketPage.getCola().click();
    }
    @Step("Put cola in basket")
    public void putColaInBasket(){
        basketPage.getPutColaInBasket().click();
    }
    @Step("Get order list")
    public String orderList(){
        basketPage.getOrderList();
        String[] products = new String[basketPage.getOrderList().size()];
        for (int i = 0; i < basketPage.getOrderList().size(); i++){
            products[i] = basketPage.getOrderList().get(i).getText();
        }
        return  String.join(" ", products);
    }
    public BasketSteps(WebDriver driver) {
        basketPage = new BasketPage(driver);
    }
}
