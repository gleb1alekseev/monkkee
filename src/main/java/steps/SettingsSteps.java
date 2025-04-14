package steps;

import constants.ITestConstants;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.SettingsPage;

import static pages.SettingsPage.getSuccessChangeColourSchemeText;
import static pages.SettingsPage.getSuccessChangeLanguageText;

public class SettingsSteps extends BaseSteps implements ITestConstants {

    SettingsPage settingsPage;

    public SettingsSteps() {
        this.settingsPage = new SettingsPage();
    }

    @Step("Change colour scheme on settings page")
    public void checkChangingColourSchemeStep(String option){
        settingsPage.changeColourScheme("Dark");
        Assert.assertEquals(getSuccessChangeColourSchemeText(), ITestConstants.CHANGE_COLOUR_SCHEME_TEXT);
    }

    @Step("Change language on settings page")
    public void checkChangingLanguageStep(String option){
        settingsPage.changeLanguage("English");
        Assert.assertEquals(getSuccessChangeLanguageText(), ITestConstants.CHANGE_LANGUAGE_TEXT);
    }
}
