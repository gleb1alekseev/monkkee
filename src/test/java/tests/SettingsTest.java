package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.SettingsPage.successChangeColourSchemeText;
import static pages.SettingsPage.successChangeLanguageText;

public class SettingsTest extends BaseTest{

    @Test(description = "change colour scheme on settings page")
    public void changeColourSchemeTest(){
        loginSteps.fillLoginAndPasswordToLoginStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        settingsSteps.changeColourSchemeStep();
        Assert.assertEquals(successChangeColourSchemeText(), "Your colour scheme has been changed successfully");
    }

    @Test(description = "change language on settings page")
    public void changeLanguageTest(){
        loginSteps.fillLoginAndPasswordToLoginStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        settingsSteps.changeLanguageStep();
        Assert.assertEquals(successChangeLanguageText(), "Your language has been changed successfully");
    }
}
