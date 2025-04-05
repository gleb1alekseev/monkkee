package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {

    String label;

    public Dropdown(String label) {
        this.label = label;
    }

    private static final String DROPDOWN_XPATH = "//select[@name='%s']";
    private static final String DROPDOWN_OPTION_XPATH = DROPDOWN_XPATH + "/option[text()='%s']";

    public void selectByVisibleText(String option) {
        $x(String.format(DROPDOWN_XPATH, label)).shouldBe(Condition.visible).click();
        $x(String.format(DROPDOWN_OPTION_XPATH, label, option)).shouldBe(Condition.visible).click();
    }
}
