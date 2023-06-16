import io.qameta.allure.Description;
import org.example.driver.DriverManager;
import org.example.steps.SortingCheckSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SortingCheckTest extends BaseTest {
    protected WebDriver driver;
    private SortingCheckSteps sortingCheckSteps;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        sortingCheckSteps = new SortingCheckSteps(driver);
    }
    @Description("Сheck the correct sorting of products by decreasing price")
    @Test(invocationCount = 3)
    public void checkSortByDescendingPrice() {
        sortingCheckSteps.choosePizzaMenu();
        sortingCheckSteps.clickSortingButton();
        sortingCheckSteps.sortByDescendingPrice();
        sortingCheckSteps.checkRightSortingDescendingPrice();
        Assert.assertTrue(sortingCheckSteps.checkRightSortingDescendingPrice()[0] >= sortingCheckSteps.checkRightSortingDescendingPrice()[1]);
    }
    @Description("Сheck the correct sorting of products by ascending price")
    @Test(invocationCount = 3)
    public void checkSortByAscendingPrice() {
        sortingCheckSteps.choosePizzaMenu();
        sortingCheckSteps.clickSortingButton();
        sortingCheckSteps.sortByAscendingPrice();
        sortingCheckSteps.checkRightSortingAscendingPrice();
        Assert.assertTrue(sortingCheckSteps.checkRightSortingAscendingPrice()[0] <= sortingCheckSteps.checkRightSortingAscendingPrice()[1]);
    }
}
