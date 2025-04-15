package tests;

import org.testng.annotations.Test;
import utils.Retry;

public class SettingsTest extends BaseTest{

    @Test(description = "change colour scheme on settings page", retryAnalyzer = Retry.class)
    public void changeColourSchemeTest(){
        loginSteps.checkLoginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        settingsSteps.checkChangingColourSchemeStep("Dark");
    }

    @Test(description = "change language on settings page", invocationCount = 1)
    public void changeLanguageTest(){
        loginSteps.checkLoginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        settingsSteps.checkChangingLanguageStep("English");
    }
}
