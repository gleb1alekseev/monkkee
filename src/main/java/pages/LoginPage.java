package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage{

    public static final SelenideElement LOGIN_BUTTON = $x("//*[@type='submit']");
    public static final SelenideElement MANDATORY_FIELD_MESSAGE = $x("//*[contains(text(), 'Mandatory field')]");
    public static final SelenideElement LOGIN_FAILED_MESSAGE = $x("//*[contains(text(), 'Login failed')]");
    public static final SelenideElement LOGO_BUTTON = $x("//*[@alt='Logo']");

    /**
     * Instantiates a new Login page.
     */
    public LoginPage() {
    }

    /**
     * Open login page login page.
     *
     * @param url the url
     * @return the login page
     */
    public LoginPage openLoginPage(String url) {
        open(url);
        return this;
    }

    /**
     * Login login page.
     *
     * @param login    the login
     * @param password the password
     * @return the login page
     */
    public LoginPage login(String login, String password) {
        new Input("login").writeFieldsByName(login);
        new Input("password").writeFieldsByName(password);
        new Button().click(LOGIN_BUTTON);
        log.info("login");
        return this;
    }

    /**
     * Login without filling login field main page.
     *
     * @param login the login
     * @return the main page
     */
    public MainPage loginWithoutFillingLoginField(String login) {
        new Input("login").writeFieldsByName(login);
        new Button().click(LOGIN_BUTTON);
        log.info("Login without password");
        return new MainPage();
    }

    /**
     * Login without filling password field main page.
     *
     * @param password the password
     * @return the main page
     */
    public MainPage loginWithoutFillingPasswordField(String password) {
        new Input("password").writeFieldsByName(password);
        new Button().click(LOGIN_BUTTON);
        log.info("Login without login field");
        return new MainPage();
    }

    /**
     * Gets login failed text.
     *
     * @return the login failed text
     */
    public static String getLoginFailedText() {
        return LOGIN_FAILED_MESSAGE.getText();
    }

    /**
     * Click logo login page.
     *
     * @return the login page
     */
    public LoginPage clickLogo(){
        new Button().click(LOGO_BUTTON);
        return this;
    }
}
