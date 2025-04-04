package steps;

import io.qameta.allure.Step;
import pages.RegistrationPage;

public class RegistrationSteps extends BaseSteps{

    RegistrationPage registrationPage;

    public RegistrationSteps() {
        this.registrationPage = new RegistrationPage();
    }

    @Step("Registration user with filling all fields with valid data and select both checkboxes")
    public void registrationNewAccountStep(String url, String email, String password, String passwordConfirmation, String passwordHint){
        registrationPage
                .openRegistrationPage(url)
                .registrationNewAccount(email, password, passwordConfirmation, passwordHint);
    }
}
