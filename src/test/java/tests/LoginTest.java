package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.LoginPage.MANDATORY_FIELD_MESSAGE;
import static pages.MainPage.CREATE_NEW_ENTRY;


public class LoginTest extends BaseTest{

    @Test(description = "success login with valid values")
    public void successLoginTest() {
        loginSteps.fillLoginAndPasswordToLoginStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        Assert.assertTrue(CREATE_NEW_ENTRY.shouldBe(Condition.visible).exists());
    }

    @Test(description = "check validation message triyng to login without password")
    public void loginWithoutPasswordTest() {
        loginSteps.fillLoginWithoutPasswordToLoginStep(LOGIN_USER, LOGIN_URL);
        Assert.assertTrue(MANDATORY_FIELD_MESSAGE.shouldBe(Condition.visible).exists());
    }

    @Test(description = "check validation message triyng to login without login value")
    public void loginWithoutUserTest() {
        loginSteps.fillPasswordWithoutLoginToLoginStep(LOGIN_PASSWORD, LOGIN_URL);
        Assert.assertTrue(MANDATORY_FIELD_MESSAGE.shouldBe(Condition.visible).exists());
    }
}
