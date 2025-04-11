package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.switchTo;
import static pages.MainPage.ENTRY_CREATED_WITH_DESCRIPTION;

public class MainTest extends BaseTest{

    @Test(description = "success login with valid values and logout")
    public void logoutTest() {
        loginSteps.loginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.logoutStep();
    }

    @Test(description = "login and create an entry with description", invocationCount = 1)
    public void createEntryWithDescriptionTest(){
        loginSteps.loginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.createEntryWithDescriptionStep(MAIN_ENTRY_DESCRIPTION);
    }

    @Test(description = "login, create and delete an entry with description", invocationCount = 1)
    public void createAndDeleteEntryWithDescriptionTest(){
        loginSteps.loginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.createAndDeleteEntryWithDescriptionStep(MAIN_ENTRY_DESCRIPTION);
    }

    @Test(description = "login, create and search an entry with description")
    public void createAndSearchEntryWithDescriptionTest(){
        loginSteps.loginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.createAndSearchEntryWithDescriptionStep(MAIN_ENTRY_DESCRIPTION);
    }
}
