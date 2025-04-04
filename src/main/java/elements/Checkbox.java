package elements;

import com.codeborne.selenide.SelenideElement;

public class Checkbox {

    public Checkbox(){
    }

    public void selectCheckbox(SelenideElement selenideElement){
        selenideElement.click();
    }
}
