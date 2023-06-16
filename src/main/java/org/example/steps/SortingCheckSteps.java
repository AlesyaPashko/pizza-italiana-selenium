package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.SortingCheckPage;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortingCheckSteps {
    private SortingCheckPage sortingCheckPage;
    public SortingCheckSteps(WebDriver driver) {
        sortingCheckPage = new SortingCheckPage(driver);
    }

    @Step("Choose pizza menu")
    public void choosePizzaMenu() {
        sortingCheckPage.getPizzaMenu().click();
    }
    @Step("Click sorting button")
    public void clickSortingButton() {
        sortingCheckPage.getSortBy().click();
    }
    @Step("Choose sorting by descending price")
    public void sortByDescendingPrice() {
        sortingCheckPage.getDescendingPrice().click();
    }
    @Step("Choose sorting by descending price")
    public void sortByAscendingPrice() {
        sortingCheckPage.getAscendingPrice().click();
    }
    @Step("Check right sorting descending price")
    public double[] checkRightSortingDescendingPrice() {
        String[] pricesString = new String[sortingCheckPage.getPricesDescendingPrice().size()];
        double[] prices = new double[pricesString.length];
        for (int i = 0; i < sortingCheckPage.getPricesDescendingPrice().size() - 1; i++) {
            Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
            Matcher matcher = pat.matcher(sortingCheckPage.getPricesDescendingPrice().get(i).getText());
            while (matcher.find()) {
                pricesString[i] = matcher.group();
            }
        }
        for (int i = 0; i < pricesString.length - 1; i++){
            prices[i] = Double.parseDouble(pricesString[i]);
        }
        return prices;
    }
    @Step("Check right sorting ascending price")
    public double[] checkRightSortingAscendingPrice() {
        String[] pricesString = new String[sortingCheckPage.getPricesAscendingPrice().size()];
        double[] prices = new double[pricesString.length];
        for (int i = 0; i < sortingCheckPage.getPricesAscendingPrice().size() - 1; i++) {
            Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
            Matcher matcher = pat.matcher(sortingCheckPage.getPricesAscendingPrice().get(i).getText());
            while (matcher.find()) {
                pricesString[i] = matcher.group();
            }
        }
        for (int i = 0; i < pricesString.length - 1; i++){
            prices[i] = Double.parseDouble(pricesString[i]);
        }
        return prices;
    }
}
