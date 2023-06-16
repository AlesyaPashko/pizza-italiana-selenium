
import io.qameta.allure.Description;
import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.steps.BasketSteps;
import org.example.utils.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasketTest extends BaseTest {
    protected WebDriver driver;
    private BasketSteps basketSteps;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        basketSteps = new BasketSteps(driver);
    }
    @Description("Check the correct total price in the backet")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkBacketForPrice(UserData userData) {
        basketSteps.openRolottoMenu();
        basketSteps.chooseBestRolotto();
        basketSteps.meetChoice();
        basketSteps.oneMorePlease();
        basketSteps.putRolottoInBasket();
        basketSteps.drinksMenu();
        basketSteps.chooseCola();
        basketSteps.putColaInBasket();
        basketSteps.openBasket();
        new Actions(driver).moveToElement(driver.findElement(By.linkText("Перейти к оформлению"))).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Assert.assertEquals(Double.parseDouble(userData.getRightPrice()), basketSteps.totalPrice());

    }
    @Description("Check the correct list of products in the backet")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkBacketForList(UserData userData){
        basketSteps.openRolottoMenu();
        basketSteps.chooseBestRolotto();
        basketSteps.meetChoice();
        basketSteps.oneMorePlease();
        basketSteps.putRolottoInBasket();
        basketSteps.drinksMenu();
        basketSteps.chooseCola();
        basketSteps.putColaInBasket();
        basketSteps.openBasket();
        new Actions(driver).moveToElement(driver.findElement(By.linkText("Перейти к оформлению"))).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(basketSteps.orderList());
        Assert.assertTrue(userData.getOurOrder().contains(basketSteps.orderList()));
    }
}
