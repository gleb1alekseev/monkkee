package steps;

import io.qameta.allure.Step;
import pages.SettingsPage;

public class SettingsSteps extends BaseSteps{

    SettingsPage settingsPage;

    public SettingsSteps() {
        this.settingsPage = new SettingsPage();
    }

    @Step("Change colour scheme on settings page")
    public void changeColourSchemeStep(){
        settingsPage.changeColourScheme();
    }

    @Step("Change language on settings page")
    public void changeLanguageStep(){
        settingsPage.changeLanguage();
    }
}
