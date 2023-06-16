package org.example.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class ChangeCityPage extends BasePage {

    protected WebDriver driver;

    @FindBy(xpath = "//div[@class=\"city_select\"]")
    private WebElement citySelectButton;
    @FindBy(xpath = "//a[text()=\"Пинск\"]")
    private WebElement pinskSelect;
    @FindBy(xpath = "//a[text()=\"Жабинка\"]")
    private WebElement jabinkaSelect;
    @FindBy(xpath = "//a[text()=\"Кобрин\"]")
    private WebElement kobrinSelect;
    @FindBy(xpath = "//span[contains(text(),\"нас\")]")
    private WebElement aboutUsButton;
    @FindBy(xpath = "//div[@class=\"text_content\"]")
    private WebElement aboutUsInformation;



    public ChangeCityPage(WebDriver driver) {
        super(driver);
    }
}
