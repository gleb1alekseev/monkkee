package tests;

import org.testng.annotations.Test;

public class MainTest extends BaseTest{

    @Test(description = "success login with valid values and logout")
    public void logoutTest() {
        loginSteps.checkLoginWithUserAndPasswordStep(USER, PASSWORD, LOGIN_URL);
        mainSteps.logoutCheckStep();
    }

    @Test(description = "login, create and delete an entry with description", invocationCount = 1)
    public void createAndDeleteEntryWithDescriptionTest(){
        loginSteps.checkLoginWithUserAndPasswordStep(USER, PASSWORD, LOGIN_URL);
        mainSteps.createAndDeleteEntryCheckStep(MAIN_ENTRY_DESCRIPTION);
    }

    @Test(description = "login, create and search an entry with description")
    public void createAndSearchEntryWithDescriptionTest(){
        loginSteps.checkLoginWithUserAndPasswordStep(USER, PASSWORD, LOGIN_URL);
        mainSteps.createAndSearchEntryCheckStep(MAIN_ENTRY_DESCRIPTION);
    }

    @Test(description = "login and create an entry with description", invocationCount = 1)
    public void createEntryWithDescriptionTest(){
        loginSteps.checkLoginWithUserAndPasswordStep(USER, PASSWORD, LOGIN_URL);
        mainSteps.createEntryWithDescriptionCheckStep(MAIN_ENTRY_DESCRIPTION);
    }
}
