package tests;

import org.testng.annotations.Test;

public class MainTest extends BaseTest{

    @Test(description = "success login with valid values and logout")
    public void logoutTest() {
        loginSteps.loginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.logoutStep();
    }

    @Test(description = "login, create and delete an entry with description", invocationCount = 1)
    public void createAndDeleteEntryWithDescriptionTest(){
        loginSteps.loginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.createAndDeleteEntryWithDescriptionStep(MAIN_ENTRY_DESCRIPTION);
    }

    @Test(description = "login and create an entry with description", invocationCount = 1)
    public void createEntryWithDescriptionTest(){
        loginSteps.loginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.createEntryWithDescriptionStep(MAIN_ENTRY_DESCRIPTION);
    }

    @Test(description = "login, create and search an entry with description")
    public void createAndSearchEntryWithDescriptionTest(){
        loginSteps.loginWithUserAndPasswordStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.createAndSearchEntryWithDescriptionStep(MAIN_ENTRY_DESCRIPTION);
    }
}
