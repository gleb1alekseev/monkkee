package tests;

import org.testng.annotations.Test;

public class SettingsTest extends BaseTest{

    @Test(description = "change colour scheme on settings page")
    public void changeColourSchemeTest(){
        loginSteps.loginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        settingsSteps.checkChangingColourSchemeStep("Dark");
    }

    @Test(description = "change language on settings page")
    public void changeLanguageTest(){
        loginSteps.loginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        settingsSteps.checkChangingLanguageStep("English");
    }
}
