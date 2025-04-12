package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.LoginPage;

import static pages.LoginPage.MANDATORY_FIELD_MESSAGE;
import static pages.LoginPage.getLoginFailedText;
import static pages.MainPage.CREATE_NEW_ENTRY;

public class LoginSteps extends BaseSteps{
    LoginPage loginPage;

    public LoginSteps(){
        this.loginPage = new LoginPage();
    }

    @Step("Login with user and password")
    public void loginWithUserAndPasswordStep(String login, String password, String url){
        loginPage
                .openLoginPage(url)
                .login(login, password);
        Assert.assertTrue(CREATE_NEW_ENTRY.shouldBe(Condition.visible).exists());
    }

    @Step("Login with user without password")
    public void loginWithoutPasswordStep(String login, String url){
        loginPage
                .openLoginPage(url)
                .loginWithoutFillingLoginField(login);
        Assert.assertTrue(MANDATORY_FIELD_MESSAGE.shouldBe(Condition.visible).exists());
    }

    @Step("Login with password without user")
    public void loginWithoutFillingUserStep(String password, String url){
        loginPage
                .openLoginPage(url)
                .loginWithoutFillingPasswordField(password);
        Assert.assertTrue(MANDATORY_FIELD_MESSAGE.shouldBe(Condition.visible).exists());
    }

    @Step("Open login page by click logo and fill login and password")
    public void clickLogoOnLoginToCheckValidationMessageStep(String login, String password){
        loginPage
                .clickLogo()
                .login(login, password);
        Assert.assertEquals(getLoginFailedText(), "Login failed");
    }
}
