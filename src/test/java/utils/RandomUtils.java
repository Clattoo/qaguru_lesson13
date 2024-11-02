package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class RandomUtils {

    Faker faker = new Faker();

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getRandomUserPhone() {
        return faker.number().digits(10);
    }

    public String getRandomIncorrectUserPhone() {
        return faker.number().digits(9);
    }

    public String getRandomDayOfBirth() {
        return String.format("%02d", faker.number().numberBetween(1,28));
    }
//    }

    public String getRandomMonthOfBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String getRandomYearOfBirth() {
        return new SimpleDateFormat("yyyy").format(faker.date().birthday());
    }

    public String getRandomSubjects() {
        return faker.options().option("Arts", "Accounting", "Math", "Social Studies");
    }

    public String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getRandomUploadPicture() {
        return faker.options().option("1.jpg", "2.jpg", "3.jpg");
    }

    public String getRandomCurrentAddress() {
        return faker.address().fullAddress();
    }

    public String getRandomUserState() {
        String randomState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

        return randomState;
    }

    public String getRandomUserCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut" );
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalStateException("Unexpected value: " + state);
        };

    }
}