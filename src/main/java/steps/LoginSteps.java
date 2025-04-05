package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps extends BaseSteps{

    LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @Step("Login with user and password")
    public void fillLoginAndPasswordToLoginStep(String login, String password, String url){
        loginPage
                .openLoginPage(url)
                .loginToMainPage(login, password);
    }

    @Step("Login with user without password")
    public void fillLoginWithoutPasswordToLoginStep(String login, String url){
        loginPage
                .openLoginPage(url)
                .loginWithOnlyLogin(login);
    }

    @Step("Login with password without user")
    public void fillPasswordWithoutLoginToLoginStep(String password, String url){
        loginPage
                .openLoginPage(url)
                .loginWithOnlyPassword(password);
    }

    @Step("Open login page by click logo and fill login and password")
    public void clickLogoAndFillLoginAndPasswordStep(String login, String password){
        loginPage
                .clickLogo()
                .loginToMainPage(login, password);
    }
}
