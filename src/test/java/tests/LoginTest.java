package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(description = "success login with valid values")
    public void successLoginTest() {
        loginSteps.checkLoginWithUserAndPasswordStep(USER, PASSWORD, LOGIN_URL);
    }

    @Test(description = "check validation message triyng to login without password")
    public void loginWithoutPasswordTest() {
        loginSteps.checkLoginWithoutPasswordStep(USER, LOGIN_URL);
    }

    @Test(description = "check validation message triyng to login without login value")
    public void loginWithoutUserTest() {
        loginSteps.checkLoginWithoutFillingUserStep(PASSWORD, LOGIN_URL);
    }
}
