package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static pages.LoginPage.loginFailedText;
import static pages.RegistrationPage.*;


public class RegistrationTest extends BaseTest{

    @Test(description = "success registration user with filling all field and check message that user registered")
    public void successRegistrationTest(){
        registrationSteps.registrationNewAccountStep(
                REGISTRATION_URL, REGISTRATION_EMAIL, REGISTRATION_PASSWORD,
                REGISTRATION_PASSWORD_CONFIRMATION, REGISTRATION_PASSWORD_HINT);
        Assert.assertEquals(successUserRegisteredText(), "User registered");
    }

    @Test(description = "success registration user and cannot try to login without confirm email")
    public void successRegistrationAndLoginWithoutConfirmationEmailTest(){
        registrationSteps.registrationNewAccountStep(
                REGISTRATION_URL, REGISTRATION_EMAIL, REGISTRATION_PASSWORD,
                REGISTRATION_PASSWORD_CONFIRMATION, REGISTRATION_PASSWORD_HINT);
        loginSteps.clickLogoAndFillLoginAndPasswordStep(REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
        Assert.assertEquals(loginFailedText(), "Login failed");
    }

    @Test(description = "check validation message about short password value")
    public void registrationShortPasswordValidationTest(){
        registrationSteps.registrationPasswordValidationStep(REGISTRATION_URL, REGISTRATION_SHORT_PASSWORD);
        Assert.assertEquals(registrationShortPasswordValidationMessage(), "Password is too short. Min. 8 characters");
    }

    @Test(description = "check validation message and red color for bad password value")
    public void registrationBadRedPasswordValidationTest(){
        registrationSteps.registrationPasswordValidationStep(REGISTRATION_URL, REGISTRATION_BAD_RED_PASSWORD);
        Assert.assertEquals(registrationBadPasswordValidationMessage(), "Password strength: Bad");
        Assert.assertTrue(VALIDATION_MESSAGE_PASSWORD_BACKGROUND.shouldHave(cssValue("background-color", "rgba(255, 160, 160, 1)")).exists());
    }

    @Test(description = "check validation message and green color for strong password value")
    public void registrationStrongGreenPasswordValidationTest(){
        registrationSteps.registrationPasswordValidationStep(REGISTRATION_URL, REGISTRATION_STRONG_GREEN_PASSWORD);
        Assert.assertEquals(registrationStrongPasswordValidationMessage(), "Password strength: Strong");
        Assert.assertTrue(VALIDATION_MESSAGE_PASSWORD_BACKGROUND.shouldHave(cssValue("background-color", "rgba(195, 255, 136, 1)")).exists());
    }

    @Test(description = "check validation message about confirmation password")
    public void registrationPasswordConfirmationValidationTest(){
        registrationSteps.registrationPasswordConfirmationValidationStep(REGISTRATION_URL, REGISTRATION_PASSWORD, REGISTRATION_PASSWORD_CONFIRMATION_NOT_EQUALS_PASSWORD);
        Assert.assertEquals(registrationPasswordConfirmationValidationMessage(), "Password confirmation doesn’t match");
    }
}
