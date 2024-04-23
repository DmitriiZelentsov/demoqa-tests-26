package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName("Dmitrii")
                .setLastName("Zelentsov")
                .setEmail("test@test.ru")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("01", "April", "1990")
                .setSubject("Computer")
                .setHobby("Sports")
                .setHobby("Music")
                .uploadPicture("1.JPG")
                .setAddress("Samara, Address, 1/2")
                .setState("Haryana")
                .setCity("Karnal")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "Dmitrii Zelentsov")
                .checkResult("Student Email", "test@test.ru")
                .checkResult("Gender","Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "01 April,1990")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Sports, Music")
                .checkResult("Picture", "1.JPG")
                .checkResult("Address", "Samara, Address, 1/2")
                .checkResult("State and City", "Haryana Karnal");
    }

    @Test
    void fillPracticeFormRequiredTest() {
        registrationPage.openPage()
                .setFirstName("Dmitrii")
                .setLastName("Zelentsov")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("01", "April", "1990")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "Dmitrii Zelentsov")
                .checkResult("Gender","Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "01 April,1990");
    }

    @Test
    void fillPracticeFormFailTest() {
        registrationPage.openPage()
                .setFirstName("Dmitrii")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("01", "April", "1990")
                .pressSubmit();

        registrationPage.checkFormNotDisplayed();
    }
}
