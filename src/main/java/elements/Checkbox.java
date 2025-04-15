package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Checkbox {
    private final String label;
    private static final String CHECKBOX_LOCATOR = "//*[contains(text(), '%s')]/preceding::input[@type='checkbox'][2]";

    /**
     * Instantiates a new Checkbox.
     *
     * @param label the label
     */
    public Checkbox(String label) {
        this.label = label;
    }

    /**
     * Sets checkbox value registration.
     *
     * @param selected the selected
     */
    public void setCheckboxValueRegistration(boolean selected) {
        SelenideElement checkbox = $("#" + label);
        if (selected != checkbox.isSelected()) {
            checkbox.click();
        }
    }

    /**
     * Sets checkbox value entry.
     *
     * @param selected the selected
     */
    public void setCheckboxValueEntry(boolean selected) {
        SelenideElement checkbox = $x(String.format(CHECKBOX_LOCATOR, label));
        if (selected && !checkbox.isSelected()) {
            checkbox.click();
        } else if (!selected && checkbox.isSelected()) {
            checkbox.click();
        }
    }
}