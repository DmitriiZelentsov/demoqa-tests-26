package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    private final SelenideElement
            modalDialog = $(".modal-dialog"),
            formTable = $(".table-responsive");
    public void checkTable(String key, String value) {
        formTable.$(byText(key)).parent()
                .shouldHave(text(value));
    }
    public void modalDialogNotAppear() {
        modalDialog.shouldNot(appear);
    }
}
