package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.cssValue;
import static constants.ITestConstants.*;
import static pages.RegistrationPage.*;

public class RegistrationSteps extends BaseSteps{
    RegistrationPage registrationPage;

    public RegistrationSteps() {
        this.registrationPage = new RegistrationPage();
    }

    @Step("Registration user with filling all fields with valid data and select both checkboxes")
    public void registerAndCheckSuccessRegistrationMessage(String url, String email, String password, String passwordConfirmation, String passwordHint){
        registrationPage
                .openRegistrationPage(url)
                .registrationNewAccount(email, password, passwordConfirmation, passwordHint);
        Assert.assertEquals(registrationPage.getSuccessRegistrationMessage(), USER_REGISTERED_TEXT);
    }

    @Step("Registration user with short password field check validation message")
    public void registrationWithShortPasswordAndCheckValidationMessageStep(String url, String password){
        registrationPage
                .openRegistrationPage(url)
                .enterPassword(password);
        Assert.assertEquals(registrationPage.getPasswordValidationMessage(), PASSWORD_TOO_SHORT);
    }

    @Step("Registration user bad short password field check validation message and background colour")
    public void registrationWithBadPasswordAndCheckValidationMessageStep(String url, String password){
        registrationPage
                .openRegistrationPage(url)
                .enterPassword(password);
        Assert.assertEquals(registrationPage.getPasswordValidationMessage(), PASSWORD_BAD);
        Assert.assertTrue(PASSWORD_VALIDATION_MESSAGE.shouldHave(cssValue("background-color", RED_COLOR)).exists());
    }

    @Step("Registration user strong short password field check validation message and background colour")
    public void registrationWithStrongPasswordAndCheckValidationMessageStep(String url, String password){
        registrationPage
                .openRegistrationPage(url)
                .enterPassword(password);
        Assert.assertEquals(registrationPage.getPasswordValidationMessage(), PASSWORD_STRONG);
        Assert.assertTrue(PASSWORD_VALIDATION_MESSAGE.shouldHave(cssValue("background-color", GREEN_COLOR)).exists());
    }

    @Step("Registration user filling password and password_confirmation fields to check validation message")
    public void registrationWithDifferentPasswordConfirmationValidationCheckStep(String url, String password, String passwordConfirmation){
        registrationPage
                .openRegistrationPage(url)
                .enterPasswordAndPasswordConfirmation(password, passwordConfirmation);
        Assert.assertEquals(registrationPage.getPasswordConfirmationValidationMessage(), PASSWORD_CONFIRMATION_MISMATCH);
    }
}
