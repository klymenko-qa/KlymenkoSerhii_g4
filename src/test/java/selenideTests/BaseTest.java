package selenideTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import ui.pages.pagesSelenide.MainPage;
import ui.pages.pagesSelenide.MyAccountPage;
import ui.pages.pagesSelenide.RegistrationPage;
import ui.pages.pagesSelenide.SignInPage;

import java.util.HashMap;
import java.util.Map;

@Listeners({ScreenShooter.class, TextReport.class})
@Report
public class BaseTest {

    public MainPage mainPage = new MainPage();
    public RegistrationPage registrationPage = new RegistrationPage();
    public MyAccountPage myAccountPage = new MyAccountPage();
    public SignInPage signInPage = new SignInPage();
    SelenoidWebDriverProvider selenoidWebDriverProvider = new SelenoidWebDriverProvider();

    public void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        // 1 - Allow, 2 - block, 0 - default
        prefs.put("profile.default_content_setting_values.notification", 1);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("disable-infobars");
        options.addArguments("--window-size=1920,1080");
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    @BeforeClass
    public void setUp() {
        final String RUN_TYPE = "remote";
        switch (RUN_TYPE) {
            case ("local"):
                WebDriverManager.chromedriver().browserVersion("95").setup();
                Configuration.browser = "chrome";
                Configuration.timeout = 10000;
                Configuration.baseUrl = "http://automationpractice.com";
                Configuration.screenshots = true;
                Configuration.savePageSource = true;
                Configuration.reopenBrowserOnFail = true;
                setUpBrowser();
                Selenide.open(Configuration.baseUrl);
                break;
            case ("remote"):
                Configuration.remote = "http://localhost:4444/wd/hub";
                Configuration.browserSize = "1920x1080";
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "91.0");
                capabilities.setCapability("platform", "LINUX");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
                capabilities.setCapability("enableLog", true);
                Configuration.browserCapabilities = capabilities;
                Selenide.open("http://automationpractice.com");
//                WebDriverRunner.setWebDriver(selenoidWebDriverProvider.createDriver(capabilities));
                break;
        }
    }

    @AfterClass
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }
}