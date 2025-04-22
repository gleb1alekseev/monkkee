package tests;

import com.codeborne.selenide.Configuration;
import constants.ITestConstants;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.BasePage;
import steps.LoginSteps;
import steps.MainSteps;
import steps.RegistrationSteps;
import steps.SettingsSteps;
import utils.PropertyReader;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Listeners(TestListener.class)
public class BaseTest extends BasePage implements ITestConstants {

    protected LoginSteps loginSteps;
    protected RegistrationSteps registrationSteps;
    protected MainSteps mainSteps;
    protected SettingsSteps settingsSteps;

    public static String USER = System.getProperty("user", ""); //передать данные для логина
    public static String PASSWORD = System.getProperty("password", ""); //передать данные для пароля

    public static String LOGIN_USER = PropertyReader.getProperty("login");
    public static String LOGIN_PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");
    public static String REGISTRATION_URL = PropertyReader.getProperty("registrationUrl");

    public void initPages() {
        loginSteps = new LoginSteps();
        registrationSteps = new RegistrationSteps();
        mainSteps = new MainSteps();
        settingsSteps = new SettingsSteps();
    }

    @BeforeMethod
    public void initTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        initPages();
    }

    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }
}
