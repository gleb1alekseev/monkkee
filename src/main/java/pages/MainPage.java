package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage{

    public static final SelenideElement CREATE_NEW_ENTRY = $x("//*[@title='Create an entry']");

    public MainPage isOpened() {
        CREATE_NEW_ENTRY.shouldBe(Condition.visible);
        return this;
    }

    public MainPage openLoginPage(String url) {
        open(url);
        return this;
    }

    public MainPage() {
    }
}
