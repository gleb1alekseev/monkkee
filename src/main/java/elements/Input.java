package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    String label;

    public String loginLocator = "//*[@name='%s']";
    public String registrationLocator = "//*[@id='%s']";

    public Input(String label) {
        this.label = label;
    }

    public Input writeLoginFields(String text) {
        $x(String.format(loginLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeRegistrationFields(String text) {
        $x(String.format(registrationLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }
}
