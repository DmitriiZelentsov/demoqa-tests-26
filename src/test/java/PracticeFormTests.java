import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Dmitrii");
        $("#lastName").setValue("Zelentsov");
        $("#userEmail").setValue("test@test.ru");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("9277232217");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--001").scrollTo().click();

        $("#subjectsInput").setValue("Computer").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("1.JPG");

        $("#currentAddress").setValue("Samara, Address, 1/2").scrollTo();

        $("#state").click();
        $(byText("Haryana")).click();

        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Dmitrii Zelentsov"));
        $(".table-responsive").shouldHave(text("test@test.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9277232217"));
        $(".table-responsive").shouldHave(text("01 April,1990"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("1.JPG"));
        $(".table-responsive").shouldHave(text("Samara, Address, 1/2"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));

        $(byText("Close")).click();
    }
}
