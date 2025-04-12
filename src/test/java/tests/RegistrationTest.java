package tests;

import org.testng.annotations.Test;


public class RegistrationTest extends BaseTest{

    @Test(description = "success registration user with filling all field and check message that user registered")
    public void successRegistrationTest(){
        registrationSteps.registerAndCheckSuccessRegistrationMessage(
                REGISTRATION_URL, REGISTRATION_EMAIL, REGISTRATION_PASSWORD,
                REGISTRATION_PASSWORD_CONFIRMATION, REGISTRATION_PASSWORD_HINT);
    }

    @Test(description = "success registration user and cannot try to login without confirm email")
    public void successRegistrationAndLoginWithoutConfirmationEmailToCheckValidationMessageTest(){
        registrationSteps.registerAndCheckSuccessRegistrationMessage(
                REGISTRATION_URL, REGISTRATION_EMAIL, REGISTRATION_PASSWORD,
                REGISTRATION_PASSWORD_CONFIRMATION, REGISTRATION_PASSWORD_HINT);
        loginSteps.clickLogoOnLoginToCheckValidationMessageStep(REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
    }

    @Test(description = "check validation message about short password value")
    public void registrationWithShortPasswordAndCheckValidationMessageTest(){
        registrationSteps.registrationWithShortPasswordAndCheckValidationMessageStep(REGISTRATION_URL, REGISTRATION_SHORT_PASSWORD);
    }

    @Test(description = "check validation message and red color for bad password value")
    public void registrationWithBadPasswordAndCheckValidationMessageTest(){
        registrationSteps.registrationWithBadPasswordAndCheckValidationMessageStep(REGISTRATION_URL, REGISTRATION_BAD_RED_PASSWORD);
    }

    @Test(description = "check validation message and green color for strong password value")
    public void registrationWithStrongPasswordAndCheckValidationMessageTest(){
        registrationSteps.registrationWithStrongPasswordAndCheckValidationMessageStep(REGISTRATION_URL, REGISTRATION_STRONG_GREEN_PASSWORD);
    }

    @Test(description = "check validation message about confirmation password")
    public void registrationWithDifferentPasswordConfirmationValidationCheckTest(){
        registrationSteps.registrationWithDifferentPasswordConfirmationValidationCheckStep(REGISTRATION_URL, REGISTRATION_PASSWORD, REGISTRATION_PASSWORD_CONFIRMATION_NOT_EQUALS_PASSWORD);
    }
}
