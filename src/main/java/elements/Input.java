package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    String label;
    public String byNameLocator = "//*[@name='%s']";
    public String byIdLocator = "//*[@id='%s']";

    /**
     * Instantiates a new Input.
     *
     * @param label the label
     */
    public Input(String label) {
        this.label = label;
    }

    /**
     * Write fields by name input.
     *
     * @param text the text
     * @return the input
     */
    public Input writeFieldsByName(String text) {
        $x(String.format(byNameLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    /**
     * Write fields by id input.
     *
     * @param text the text
     * @return the input
     */
    public Input writeFieldsById(String text) {
        $x(String.format(byIdLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }
}
