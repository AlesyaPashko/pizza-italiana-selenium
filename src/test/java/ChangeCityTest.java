import io.qameta.allure.Description;
import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.steps.ChangeCitySteps;
import org.example.utils.JsonReader;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ChangeCityTest extends BaseTest {
    protected WebDriver driver;
    private ChangeCitySteps changeCitySteps;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        changeCitySteps = new ChangeCitySteps(driver);
    }
    @Description("Check the correct city selection (Pinsk)")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void choosePinsk(UserData userData) {
        changeCitySteps.clickCitySelectButton();
        changeCitySteps.pinskSelect();
        changeCitySteps.openAboutUs();
        Assert.assertTrue(changeCitySteps.ourCity().contains(userData.getCityP()));
    }
    @Description("Check the correct city selection (Jabinka)")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class, expectedExceptions = {NoSuchElementException.class})
    public void chooseJabinka (UserData userData) {
        changeCitySteps.clickCitySelectButton();
        changeCitySteps.jabinkaSelect();
        changeCitySteps.openAboutUs();
        Assert.assertTrue(changeCitySteps.ourCity().contains(userData.getCityJ()));
    }
    @Description("Check the correct city selection (Kobrin)")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void chooseKobrin (UserData userData) {
        changeCitySteps.clickCitySelectButton();
        changeCitySteps.kobrinSelect();
        changeCitySteps.openAboutUs();
        Assert.assertTrue(changeCitySteps.ourCity().contains(userData.getCityK()));
    }
}
