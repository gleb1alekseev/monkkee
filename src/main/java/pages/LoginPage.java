package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage{

    public static final SelenideElement LOGIN = $x("//*[@type='submit']");
    public static final SelenideElement MANDATORY_FIELD_MESSAGE = $x("//*[contains(text(), 'Mandatory field')]");
    public static final String LOGIN_FAILED_MESSAGE = "//*[contains(text(), 'Login failed')]";
    public static final SelenideElement LOGO_BUTTON = $x("//*[@alt='Logo']");

    public LoginPage() {
    }

    public LoginPage openLoginPage(String url) {
        open(url);
        return this;
    }

    public LoginPage isOpened() {
        LOGIN.shouldBe(Condition.visible);
        return this;
    }

    private LoginPage fillLoginAndPasswordToLogin(String login, String password) {
        new Input("login").writeLoginFields(login);
        new Input("password").writeLoginFields(password);
        new Button().click(LOGIN);
        return this;
    }

    public MainPage loginToMainPage(String login, String password) {
        fillLoginAndPasswordToLogin(login, password);
        return new MainPage();
    }

    private LoginPage fillOnlyUserToLogin(String login) {
        new Input("login").writeLoginFields(login);
        new Button().click(LOGIN);
        return this;
    }

    public MainPage loginWithOnlyLogin(String login) {
        fillOnlyUserToLogin(login);
        return new MainPage();
    }

    private LoginPage fillOnlyPasswordToLogin(String password) {
        new Input("password").writeLoginFields(password);
        new Button().click(LOGIN);
        return this;
    }

    public MainPage loginWithOnlyPassword(String password) {
        fillOnlyPasswordToLogin(password);
        return new MainPage();
    }

    public static String loginFailedText() {
        return $x(String.format(LOGIN_FAILED_MESSAGE)).getText();
    }

    public LoginPage clickLogo(){
        new Button().click(LOGO_BUTTON);
        return this;
    }
}
