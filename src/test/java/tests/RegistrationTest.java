package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static pages.LoginPage.getLoginFailedText;
import static pages.RegistrationPage.*;


public class RegistrationTest extends BaseTest{

    @Test(description = "success registration user with filling all field and check message that user registered")
    public void successRegistrationTest(){
        registrationSteps.registrationNewAccountStep(
                REGISTRATION_URL, REGISTRATION_EMAIL, REGISTRATION_PASSWORD,
                REGISTRATION_PASSWORD_CONFIRMATION, REGISTRATION_PASSWORD_HINT);
    }

    @Test(description = "success registration user and cannot try to login without confirm email")
    public void successRegistrationAndLoginWithoutConfirmationEmailTest(){
        registrationSteps.registrationNewAccountStep(
                REGISTRATION_URL, REGISTRATION_EMAIL, REGISTRATION_PASSWORD,
                REGISTRATION_PASSWORD_CONFIRMATION, REGISTRATION_PASSWORD_HINT);
        loginSteps.clickLogoAndFillLoginAndPasswordStep(REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
        Assert.assertEquals(getLoginFailedText(), "Login failed");
    }

    @Test(description = "check validation message about short password value")
    public void registrationShortPasswordValidationTest(){
        registrationSteps.registrationWithShortPasswordStep(REGISTRATION_URL, REGISTRATION_SHORT_PASSWORD);
    }

    @Test(description = "check validation message and red color for bad password value")
    public void registrationBadRedPasswordValidationTest(){
        registrationSteps.registrationWithBadPasswordStep(REGISTRATION_URL, REGISTRATION_BAD_RED_PASSWORD);
    }

    @Test(description = "check validation message and green color for strong password value")
    public void registrationStrongGreenPasswordValidationTest(){
        registrationSteps.registrationWithStrongPasswordStep(REGISTRATION_URL, REGISTRATION_STRONG_GREEN_PASSWORD);
    }

    @Test(description = "check validation message about confirmation password")
    public void registrationPasswordConfirmationValidationTest(){
        registrationSteps.registrationCheckValidationPasswordStep(REGISTRATION_URL, REGISTRATION_PASSWORD, REGISTRATION_PASSWORD_CONFIRMATION_NOT_EQUALS_PASSWORD);
    }
}
