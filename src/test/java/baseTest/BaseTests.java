package baseTest;

import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import libs.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ui.pages.pagesSelenium.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public MyAccountPage myAccountPage;
    public RegistrationAlternativePage registrationAlternativePage;
    public SignInPage signInPage;
    public Utils utils = new Utils();
    public Faker faker = new Faker();

    public String patchToScreenShot;

    public BaseTests() {
    }

    @Parameters("browserName")
    @BeforeClass
    @Step("Set up browser options {browser}")
    public void setUp(@Optional("chrome") String browser) {
        if (browser.toLowerCase().equals("chrome")) {
            logger.info(browser + " will be started");
            File fileChrome = new File("drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info(browser + " is started");
        } else if (browser.toLowerCase().equals("firefox")) {
            logger.info(browser + " will be started");
            File fileFirefox = new File("drivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", fileFirefox.getAbsolutePath());
            webDriver = new FirefoxDriver();
            logger.info(browser + " is started");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File("");
        patchToScreenShot = file.getAbsolutePath() + "\\screenShot" + "-" +
                this.getClass().getPackage().getName() + "\\" +
                this.getClass().getSimpleName() + ".png";

        initPages();
    }

    public void initPages() {
        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        registrationAlternativePage = new RegistrationAlternativePage(webDriver);
        signInPage = new SignInPage(webDriver);
    }

    @Step("Tear down browser")
    @AfterClass
    public void tearDown() {
        if (!(webDriver == null)) {
            screenshot();
            utils.screenShot(patchToScreenShot, webDriver);
            webDriver.quit();
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
}