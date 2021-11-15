package baseTest;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.MainPage;
import ui.pages.MyAccountPage;
import ui.pages.RegistrationPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    public Faker faker = new Faker();

    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public MyAccountPage myAccountPage;

    @Before
    public void setUp() {
        File fileChrome = new File("drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        logger.info("Get chromedriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}