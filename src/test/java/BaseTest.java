import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class BaseTest{

    protected WebDriver driver;
    HomePage homePage;
    Log log = new Log();


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        homePage = new HomePage(driver);

        log.info("Ready");
    }

    @After
    public void tearDown(){
        log.info("Finish");
        driver.quit();
    }

}
