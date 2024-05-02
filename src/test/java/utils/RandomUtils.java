package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RandomUtils {
    private final Faker faker = new Faker(new Locale("en-GB"));
    private final String[] gender = {"Male", "Female", "Other"},
            subject = {"Accounting", "Arts", "Biology", "Chemistry", "Computer Science", "Commerce", "Civics",
                    "English", "Economics", "Hindi", "History", "Maths", "Physics", "Social Studies"},
            hobbies = {"Sports", "Reading", "Music"},
            picture = {"1.jpg", "2.jpg", "3.jpg"},
            state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            cityNcr = {"Delhi", "Gurgaon", "Noida"},
            cityUttarPradesh = {"Agra", "Lucknow", "Merrut"},
            cityHaryana = {"Karnal", "Panipat"},
            cityRajasthan = {"Jaipur", "Jaiselmer"};

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option(gender);
    }

    public String getUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getDate(String type){
        SimpleDateFormat date;
        switch (type) {
            case "day":
                date = new SimpleDateFormat("dd", Locale.ENGLISH);
                break;
            case "month":
                date = new SimpleDateFormat("MMMM", Locale.ENGLISH);
                break;
            case "year":
                date = new SimpleDateFormat("YYYY", Locale.ENGLISH);
                break;
            default:
                return null;
        }

        return date.format(faker.date().birthday());
    }

    public String getSubject() {
        return faker.options().option(subject);
    }

    public String getHobbies() {
        return faker.options().option(hobbies);
    }

    public String getPicture() {
        return faker.options().option(picture);
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    public String getState() {
        return faker.options().option(state);
    }

    public String getCity(String state) {
        String city;
        switch (state) {
            case "NCR":
                city = new Faker().options().option(cityNcr);
                break;
            case "Uttar Pradesh":
                city = new Faker().options().option(cityUttarPradesh);
                break;
            case "Haryana":
                city = new Faker().options().option(cityHaryana);
                break;
            case "Rajasthan":
                city = new Faker().options().option(cityRajasthan);
                break;
            default:
                return null;
        }

        return city;
    }
}
