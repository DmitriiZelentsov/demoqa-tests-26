package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit")
            ;

    @Step("OpenPage")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("SetFirstName {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("SetLastName {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("SetEmail {value}")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("SetGender {value}")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("SetUserNumber {value}")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("SetDateOfBirth {day} {month} {year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("SetSubject {value}")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("SetHobby {value}")
    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step("UploadPicture {value}")
    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("SetAddress {value}")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    @Step("SetState {value}")
    public RegistrationPage setState(String value) {
        stateInput.click();
        $(byText(value)).click();

        return this;
    }

    @Step("SetCity {value}")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        $(byText(value)).click();

        return this;
    }

    @Step("PressSubmit")
    public RegistrationPage pressSubmit() {
        submitButton.click();

        return this;
    }

    @Step("CheckResult {key}, {value}")
    public RegistrationPage checkResult(String key, String value) {
        resultComponent.checkTable(key, value);

        return this;
    }

    @Step("CheckFormNotDisplayed")
    public RegistrationPage checkFormNotDisplayed() {
        resultComponent.modalDialogNotAppear();

        return this;
    }
}
