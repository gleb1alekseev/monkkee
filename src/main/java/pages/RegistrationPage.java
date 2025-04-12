package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Checkbox;
import elements.Input;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class RegistrationPage extends BasePage {

    public static final SelenideElement OK_BUTTON = $x("//button[@type='submit']");
    public static final SelenideElement USER_REGISTERED_MESSAGE = $x("//*[contains(text(), 'User registered')]");
    public static final SelenideElement PASSWORD_VALIDATION_MESSAGE = $x("//*[@id='registration_password-strength-indicator']");
    public static final SelenideElement PASSWORD_CONFIRMATION_MESSAGE = $x("//*[contains(text(), 'Password confirmation')]");
    public static final String GREEN_COLOR = "rgba(195, 255, 136, 1)";
    public static final String RED_COLOR = "rgba(255, 160, 160, 1)";

    /**
     * Instantiates a new Registration page.
     */
    public RegistrationPage() {
    }

    /**
     * Open registration page registration page.
     *
     * @param url the url
     * @return the registration page
     */
    public RegistrationPage openRegistrationPage(String url) {
        open(url);
        return this;
    }

    /**
     * Registration new account registration page.
     *
     * @param email                the email
     * @param password             the password
     * @param passwordConfirmation the password confirmation
     * @param passwordHint         the password hint
     * @return the registration page
     */
    public RegistrationPage registrationNewAccount(String email, String password, String passwordConfirmation, String passwordHint) {
        new Input("registration_email").writeFieldsById(email);
        new Input("registration_password").writeFieldsById(password);
        new Input("registration_password_confirmation").writeFieldsById(passwordConfirmation);
        new Input("registration_password_hint").writeFieldsById(passwordHint);
        new Checkbox("registration_terms_of_use").setCheckboxValueRegistration(true);
        new Checkbox("registration_lost_password_warning_registered").setCheckboxValueRegistration(true);
        new Button().click(OK_BUTTON);
        log.info("User is registered");
        return this;
    }

    /**
     * Gets success registration message text.
     *
     * @return the success message text
     */
    public String getSuccessRegistrationMessage() {
        try {
            log.info("Getting success user registered text.");
            return USER_REGISTERED_MESSAGE.getText();
        } catch (Exception e) {
            log.error("Failed to get success registration message", e);
            return "";
        }
    }

    /**
     * Registration input password field registration page.
     *
     * @param password the password
     * @return the registration page
     */
    public RegistrationPage enterPassword(String password) {
        new Input("registration_password").writeFieldsById(password);
        log.info("Password field is filling");
        return this;
    }

    /**
     * Registration input password and password confirmation fields registration page.
     *
     * @param password             the password
     * @param passwordConfirmation the password confirmation
     * @return the registration page
     */
    public RegistrationPage enterPasswordAndPasswordConfirmation(String password, String passwordConfirmation) {
        new Input("registration_password").writeFieldsById(password);
        new Input("registration_password_confirmation").writeFieldsById(passwordConfirmation);
        log.info("Password and password confirmation fields are filling");
        new Button().click(OK_BUTTON);
        return this;
    }

    /**
     * Gets password validation message.
     *
     * @return the password validation message text
     */
    public String getPasswordValidationMessage() {
        try {
            log.info("Getting password validation message");
            return PASSWORD_VALIDATION_MESSAGE.getText();
        } catch (Exception e) {
            log.error("Failed to get password validation message", e);
            return "";
        }
    }

    /**
     * Gets password confirmation validation message.
     *
     * @return the password confirmation validation message text
     */
    public String getPasswordConfirmationValidationMessage() {
        try {
            log.info("Getting password confirmation validation message");
            return PASSWORD_CONFIRMATION_MESSAGE.getText();
        } catch (Exception e) {
            log.error("Failed to get password confirmation validation message", e);
            return "";
        }
    }
}