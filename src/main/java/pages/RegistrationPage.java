package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Checkbox;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends BasePage{

    public static final SelenideElement OK_BUTTON = $x("//button[@type='submit']");
    public static final SelenideElement CHECKBOX_TERMS_OF_USE = $x("//input[@id='registration_terms_of_use']");
    public static final SelenideElement CHECKBOX_LOST_PASSWORD_WARNING_REGISTERED = $x("//input[@id='registration_lost_password_warning_registered']");
    public static final String USER_REGISTERED_XPATH = "//*[contains(text(), 'User registered')]";

    public RegistrationPage(){

    }

    public RegistrationPage openRegistrationPage(String url) {
        open(url);
        return this;
    }

    public RegistrationPage registrationNewAccount(String email, String password, String passwordConfirmation, String passwordHint) {
        new Input("registration_email").writeRegistrationFields(email);
        new Input("registration_password").writeRegistrationFields(password);
        new Input("registration_password_confirmation").writeRegistrationFields(passwordConfirmation);
        new Input("registration_password_hint").writeRegistrationFields(passwordHint);
        new Checkbox().selectCheckbox(CHECKBOX_TERMS_OF_USE);
        new Checkbox().selectCheckbox(CHECKBOX_LOST_PASSWORD_WARNING_REGISTERED);
        new Button().click(OK_BUTTON);
        return this;
    }

    public static String successUserRegisteredText() {
        return $x(String.format(USER_REGISTERED_XPATH)).getText();
    }
}
