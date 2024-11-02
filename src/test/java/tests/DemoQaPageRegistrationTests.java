package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;

public class DemoQaPageRegistrationTests extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();


    String firstName = randomUtils.getRandomFirstName(),
            lastName = randomUtils.getRandomLastName(),
            userEmail = randomUtils.getRandomEmail(),
            userGender = randomUtils.getRandomGender(),
            userPhone = randomUtils.getRandomUserPhone(),
            userIncorrectPhone = randomUtils.getRandomIncorrectUserPhone(),
            userDayOfBirth = randomUtils.getRandomDayOfBirth(),
            userMonthOfBirth = randomUtils.getRandomMonthOfBirth(),
            userYearOfBirth = randomUtils.getRandomYearOfBirth(),
            userSubjects = randomUtils.getRandomSubjects(),
            userHobbies = randomUtils.getRandomHobbies(),
            userUploadPicture = randomUtils.getRandomUploadPicture(),
            userCurrentAddress = randomUtils.getRandomCurrentAddress(),
            userState = randomUtils.getRandomUserState(),
            userCity = randomUtils.getRandomUserCity(userState);

    @Test
    @Owner("Maxim Shlemin")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение данных DemoQA в полном объеме")
    @Tag("demoqa_auto")
    void successfulRegistrationTest() {

        step("Заполнение формы DemoQA", () -> {
            registrationPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(userEmail)
                    .setGender(userGender)
                    .setPhoneNumber(userPhone)
                    .setDateOfBirth(userDayOfBirth, userMonthOfBirth, userYearOfBirth)
                    .setSubjects(userSubjects)
                    .setHobbies(userHobbies)
                    .setUserUploadPicture(userUploadPicture)
                    .setUserCurrentAddress(userCurrentAddress)
                    .setUserState(userState)
                    .setUserCity(userCity)
                    .clickSubmit();
        });

        step("Проверка заполненных данных", () -> {
            registrationPage.checkResults("Student Name", firstName + " " + lastName)
                    .checkResults("Student Email", userEmail)
                    .checkResults("Gender", userGender)
                    .checkResults("Mobile", userPhone)
                    .checkResults("Date of Birth", userDayOfBirth + " " + userMonthOfBirth + "," + userYearOfBirth)
                    .checkResults("Subjects", userSubjects)
                    .checkResults("Hobbies", userHobbies)
                    .checkResults("Picture", userUploadPicture)
                    .checkResults("Address", userCurrentAddress)
                    .checkResults("State and City", userState + " " + userCity);
        });


    }

    @Test
    @Owner("Maxim Shlemin")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение данных DemoQA в минимальном объеме")
    @Tag("demoqa_auto")
    public void successfulMinDataRegistrationTest() {

        step("Заполнение формы DemoQA", () -> {
                    registrationPage.openPage()
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setGender(userGender)
                            .setPhoneNumber(userPhone)
                            .clickSubmit();
                });

        // Проверка результатов теста

        step("Проверка данных", () -> {
            registrationPage.checkResults("Student Name", firstName + " " + lastName)
                    .checkResults("Gender", userGender)
                    .checkResults("Mobile", userPhone);
        });
    }

    @Test
    @Owner("Maxim Shlemin")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Негативный сценарий регистрации. Ввод неккоректного номера телефона")
    @Tag("demoqa_auto")
    public void negativeRegistrationTest() {
        step("Заполнение формы DemoQA", () -> {
                    registrationPage.openPage()
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setGender(userGender)
                            .setPhoneNumber(userIncorrectPhone)
                            .clickSubmit();
                });

        // Проверка результатов теста

        step("Проверка данных", () -> {
            registrationPage.checkUnsuccessfulRegistration();
        });
    }

}