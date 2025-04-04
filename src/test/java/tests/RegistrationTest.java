package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.LoginPage.loginFailedText;
import static pages.RegistrationPage.successUserRegisteredText;


public class RegistrationTest extends BaseTest{

    @Test
    public void successRegistrationTest(){
        registrationSteps.registrationNewAccountStep(
                REGISTRATION_URL, REGISTRATION_EMAIL, REGISTRATION_PASSWORD,
                REGISTRATION_PASSWORD_CONFIRMATION, REGISTRATION_PASSWORD_HINT);
        Assert.assertEquals(successUserRegisteredText(), "User registered");
    }

    @Test
    public void successRegistrationAndLoginWithoutConfirmationEmailTest(){
        registrationSteps.registrationNewAccountStep(
                REGISTRATION_URL, REGISTRATION_EMAIL, REGISTRATION_PASSWORD,
                REGISTRATION_PASSWORD_CONFIRMATION, REGISTRATION_PASSWORD_HINT);
        loginSteps.clickLogoAndFillLoginAndPasswordStep(REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
        Assert.assertEquals(loginFailedText(), "Login failed");
    }
}
