package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        BaseTest.driver = new ChromeDriver();
        BaseTest.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (BaseTest.driver != null) {
            BaseTest.driver.quit();
        }
    }
}