package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps extends BaseSteps{

    MainPage mainPage;

    public MainSteps() {
        this.mainPage = new MainPage();
    }

    @Step("Logout from Main page")
    public void logoutStep(){
        mainPage.logout();
    }

    @Step("Login and create an entry with description")
    public void createEntryWithDescriptionStep(String description){
        mainPage.createEntryWithDescription(description);
    }

    @Step("Login, create and delete an entry with description")
    public void createAndDeleteEntryWithDescriptionStep(String description){
        mainPage.createAndDeleteEntryWithDescription(description);
    }

    @Step("Login, create and search an entry with description")
    public void createAndSearchEntryWithDescriptionStep(String description){
        mainPage.createAndSearchEntryWithDescription(description);
    }
}
