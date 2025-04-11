package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.switchTo;
import static pages.LoginPage.LOGIN_BUTTON;
import static pages.MainPage.ENTRY_CREATED_WITH_DESCRIPTION;

public class MainSteps extends BaseSteps{
    MainPage mainPage;

    public MainSteps() {
        this.mainPage = new MainPage();
    }

    @Step("Logout from Main page")
    public void logoutStep(){
        mainPage.logout();
        Assert.assertTrue(LOGIN_BUTTON.isDisplayed());
    }

    @Step("Login and create an entry with description")
    public void createEntryWithDescriptionStep(String description){
        mainPage.createEntryWithDescription(description);
        Assert.assertEquals(ENTRY_CREATED_WITH_DESCRIPTION.getText(), description);
    }

    @Step("Login, create and delete an entry with description")
    public void createAndDeleteEntryWithDescriptionStep(String description){
        mainPage.createAndDeleteEntryWithDescription(description);
        switchTo().alert().accept();
        Assert.assertFalse(ENTRY_CREATED_WITH_DESCRIPTION.exists());
    }

    @Step("Login, create and search an entry with description")
    public void createAndSearchEntryWithDescriptionStep(String description){
        mainPage.createAndSearchEntryWithDescription(description);
        Assert.assertEquals(ENTRY_CREATED_WITH_DESCRIPTION.getText(), description);
    }
}
