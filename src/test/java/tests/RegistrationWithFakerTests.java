package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class RegistrationWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    String firstName = randomUtils.getFirstName(),
            lastName = randomUtils.getLastName(),
            email = randomUtils.getEmail(),
            gender = randomUtils.getGender(),
            userNumber = randomUtils.getUserNumber(),
            day = randomUtils.getDate("day"),
            month = randomUtils.getDate("month"),
            year = randomUtils.getDate("year"),
            subject = randomUtils.getSubject(),
            hobbies = randomUtils.getHobbies(),
            picture = randomUtils.getPicture(),
            address = randomUtils.getAddress(),
            state = randomUtils.getState(),
            city = randomUtils.getCity(state);
    @Test
    void fillPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobby(hobbies)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender",gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void fillPracticeFormRequiredTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender",gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year);
    }

    @Test
    void fillPracticeFormFailTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .pressSubmit();

        registrationPage.checkFormNotDisplayed();
    }
}
