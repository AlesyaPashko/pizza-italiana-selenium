package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.ChangeCityPage;
import org.openqa.selenium.WebDriver;

public class ChangeCitySteps {
    private ChangeCityPage changeCityPage;
    public ChangeCitySteps(WebDriver driver) {
        changeCityPage = new ChangeCityPage(driver);
    }

    @Step("Click city select button")
    public void clickCitySelectButton() {
        changeCityPage.getCitySelectButton().click();
    }
    @Step("Choose Pinsk")
    public void pinskSelect() {
        changeCityPage.getPinskSelect().click();
    }
    @Step("Choose Jabinka")
    public void jabinkaSelect() {
        changeCityPage.getJabinkaSelect().click();
    }
    @Step("Choose Kobrin")
    public void kobrinSelect() {
        changeCityPage.getKobrinSelect().click();
    }
    @Step("Open about us information")
    public void openAboutUs() {
        changeCityPage.getAboutUsButton().click();
    }
    @Step("Check city")
    public String ourCity(){
        return changeCityPage.getAboutUsInformation().getText();
    }

}
