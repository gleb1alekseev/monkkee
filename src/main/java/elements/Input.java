package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    String label;

    public String byNameLocator = "//*[@name='%s']";
    public String byIdLocator = "//*[@id='%s']";

    public Input(String label) {
        this.label = label;
    }

    public Input writeFieldsByName(String text) {
        $x(String.format(byNameLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeFieldsById(String text) {
        $x(String.format(byIdLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }
}
