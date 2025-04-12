package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Checkbox;
import elements.Input;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class MainPage extends BasePage{

    public static final SelenideElement CREATE_NEW_ENTRY = $x("//*[@title='Create an entry']");
    public static final SelenideElement LOGOUT = $x("//*[contains(text(), 'Logout')]");
    public static final SelenideElement ENTRY_BACK_TO_OVERVIEW = $x("//*[@title='Back to overview']");
    public static final SelenideElement ENTRY_CREATED_WITH_DESCRIPTION = $x("//*[text()='MainEntryDescriptionTest']");
    public static final SelenideElement ENTRY_DESCRIPTION_EDIT = $x("//div[contains(@class, 'entries__entry-container')]");
    public static final SelenideElement CHECKBOX_CREATED_ENTITY = $x("//*[contains(text(), '%s')]/preceding::input[@type='checkbox'][2]");
    public static final SelenideElement DELETE_CREATED_ENTRY = $x("//*[@title='Delete selected entries']");
    public static final SelenideElement SEARCH_CREATED_ENTRY = $x("//*[@title='Search']");

    /**
     * Instantiates a new Main page.
     */
    public MainPage() {
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
     * Logout main page.
     *
     * @return the main page
     */
    public MainPage logout(){
        new Button().click(LOGOUT);
        log.info("Logout by click logout button");
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
        new Input("editable").writeFieldsById(description);
        new Button().click(ENTRY_BACK_TO_OVERVIEW);
        new Button().click(ENTRY_DESCRIPTION_EDIT);
        new Input("editable").writeFieldsById(description);
        new Button().click(ENTRY_BACK_TO_OVERVIEW);
        log.info("Create entry with description");
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
        new Input("editable").writeFieldsById(description);
        new Button().click(ENTRY_BACK_TO_OVERVIEW);
        new Checkbox("No content").setCheckboxValueEntry(true);
        new Button().click(DELETE_CREATED_ENTRY);
        log.info("Create entry with description and delete it");
        return this;
    }

    /**
     * Create and search entry with description main page.
     *
     * @param description the description
     * @return the main page
     */
    public MainPage createAndSearchEntryWithDescription(String description){
        createEntryWithDescription(description);
        new Input("appendedInputButton").writeFieldsById(description);
        new Button().click(SEARCH_CREATED_ENTRY);
        log.info("Create entry with description and search it");
        return this;
    }
}
