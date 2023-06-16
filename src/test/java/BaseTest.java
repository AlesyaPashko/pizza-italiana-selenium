import org.example.driver.DriverManager;
import org.example.utils.AllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.util.ResourceBundle;

@Listeners({AllureListener.class})
public class BaseTest {
    protected WebDriver driver;
    static ResourceBundle bundle = ResourceBundle.getBundle("test_framework");
    private final String URL = bundle.getString("path_to_url");

    @BeforeTest
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @BeforeMethod
    public void preparation() {
        driver = DriverManager.getDriver();
        driver.get(URL);
    }

    @AfterTest(alwaysRun= true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
