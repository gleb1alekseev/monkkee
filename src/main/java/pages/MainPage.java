package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

/**
 * The type Main page.
 */
public class MainPage extends BasePage{

    /**
     * The constant CREATE_NEW_ENTRY.
     */
    public static final SelenideElement CREATE_NEW_ENTRY = $x("//*[@title='Create an entry']");
    /**
     * The constant LOGOUT.
     */
    public static final SelenideElement LOGOUT = $x("//*[contains(text(), 'Logout')]");
    /**
     * The constant ENTRY_BACK_TO_OVERVIEW.
     */
    public static final SelenideElement ENTRY_BACK_TO_OVERVIEW = $x("//*[@title='Back to overview']");
    /**
     * The constant ENTRY_CREATED_WITH_DESCRIPTION.
     */
    public static final SelenideElement ENTRY_CREATED_WITH_DESCRIPTION = $x("//*[text()='MainEntryDescriptionTest']");
    /**
     * The constant CHECKBOX_CREATED_ENTITY.
     */
    public static final SelenideElement CHECKBOX_CREATED_ENTITY = $x("/html/body/div[1]/div/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[1]/input");
    /**
     * The constant DELETE_CREATED_ENTRY.
     */
    public static final SelenideElement DELETE_CREATED_ENTRY = $x("//*[@title='Delete selected entries']");
    /**
     * The constant SEARCH_CREATED_ENTRY.
     */
    public static final SelenideElement SEARCH_CREATED_ENTRY = $x("//*[@title='Search']");


    /**
     * Is opened main page.
     *
     * @return the main page
     */
    public MainPage isOpened() {
        CREATE_NEW_ENTRY.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Open login page main page.
     *
     * @param url the url
     * @return the main page
     */
    public MainPage openLoginPage(String url) {
        open(url);
        return this;
    }

    /**
     * Instantiates a new Main page.
     */
    public MainPage() {
    }

    /**
     * Logout main page.
     *
     * @return the main page
     */
    public MainPage logout(){
        new Button().click(LOGOUT);
        return this;
    }

    /**
     * Create entry with description main page.
     *
     * @param description the description
     * @return the main page
     */
    public MainPage createEntryWithDescription(String description){
        new Button().click(CREATE_NEW_ENTRY);
        new Input("editable").writeEntryDescriptionFields(description);
        new Button().click(ENTRY_BACK_TO_OVERVIEW);
        return this;
    }

    /**
     * Create and delete entry with description main page.
     *
     * @param description the description
     * @return the main page
     */
    public MainPage createAndDeleteEntryWithDescription(String description){
        new Button().click(CREATE_NEW_ENTRY);
        new Input("editable").writeEntryDescriptionFields(description);
        new Button().click(ENTRY_BACK_TO_OVERVIEW);
        new Button().click(CHECKBOX_CREATED_ENTITY);
        new Button().click(DELETE_CREATED_ENTRY);
        return this;
    }

    /**
     * Create and search entry with description main page.
     *
     * @param description the description
     * @return the main page
     */
    public MainPage createAndSearchEntryWithDescription(String description){
        new Button().click(CREATE_NEW_ENTRY);
        new Input("editable").writeEntryDescriptionFields(description);
        new Button().click(ENTRY_BACK_TO_OVERVIEW);
        new Input("appendedInputButton").writeEntryDescriptionFields(description);
        new Button().click(SEARCH_CREATED_ENTRY);
        return this;
    }
}
