package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.switchTo;
import static pages.LoginPage.LOGIN;
import static pages.MainPage.ENTRY_CREATED_WITH_DESCRIPTION;

public class MainTest extends BaseTest{

    @Test(description = "success login with valid values and logout")
    public void logoutTest() {
        loginSteps.fillLoginAndPasswordToLoginStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.logoutStep();
        Assert.assertTrue(LOGIN.shouldBe(Condition.visible).exists());
    }

    @Test(description = "login and create an entry with description")
    public void createEntryWithDescriptionTest(){
        loginSteps.fillLoginAndPasswordToLoginStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.createEntryWithDescriptionStep(MAIN_ENTRY_DESCRIPTION);
        Assert.assertTrue(ENTRY_CREATED_WITH_DESCRIPTION.shouldBe(Condition.visible).exists());
    }

    @Test(description = "login, create and delete an entry with description")
    public void createAndDeleteEntryWithDescriptionTest(){
        loginSteps.fillLoginAndPasswordToLoginStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.createAndDeleteEntryWithDescriptionStep(MAIN_ENTRY_DESCRIPTION);
        switchTo().alert().accept();
        Assert.assertFalse(ENTRY_CREATED_WITH_DESCRIPTION.shouldNotBe(Condition.visible).exists());
    }

    @Test(description = "login, create and search an entry with description")
    public void createAndSearchEntryWithDescriptionTest(){
        loginSteps.fillLoginAndPasswordToLoginStep(LOGIN_USER, LOGIN_PASSWORD, LOGIN_URL);
        mainSteps.createAndSearchEntryWithDescriptionStep(MAIN_ENTRY_DESCRIPTION);
        Assert.assertTrue(ENTRY_CREATED_WITH_DESCRIPTION.shouldBe(Condition.visible).exists());
    }
}
