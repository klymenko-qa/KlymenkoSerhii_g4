package baseTest;

import com.github.javafaker.Faker;
import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.pages.MainPage;
import ui.pages.MyAccountPage;
import ui.pages.RegistrationAlternativePage;
import ui.pages.RegistrationPage;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class BaseTests {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public MyAccountPage myAccountPage;
    public RegistrationAlternativePage registrationAlternativePage;
    public Utils utils = new Utils();
    public Faker faker = new Faker();

    public String pathToScreenShot;
    public String browser;

    public BaseTests(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
//                {"chrome"},
                {"firefox"}
        });
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        if ("chrome".equals(browser)) {
            logger.info(browser + " will be started");
            File fileChrome = new File("drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info(browser + " is started");
        } else if ("firefox".equals(browser)) {
            logger.info(browser + " will be started");
            File fileFirefox = new File("drivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", fileFirefox.getAbsolutePath());
            webDriver = new FirefoxDriver();
            logger.info(browser + " is started");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File("");
        pathToScreenShot = file.getAbsolutePath() + "screenShot" + "-" +
                this.getClass().getPackage().getName() +
                this.getClass().getSimpleName() +
                this.testName.getMethodName() + "-" + browser + ".png";

        initPages();
    }

    public void initPages() {
        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        registrationAlternativePage = new RegistrationAlternativePage(webDriver);
    }

    @After
    public void tearDown() {
        if (!(webDriver == null)) {
            utils.screenShot(pathToScreenShot, webDriver);
            webDriver.quit();
        }
    }
}