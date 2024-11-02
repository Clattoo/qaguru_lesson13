package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultsComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),

    lastNameInput = $("#lastName"),

    userEmailInput = $("#userEmail"),

    genderWrapper = $("#genterWrapper"),

    userPhoneNumberInput = $("#userNumber"),

    calendarInput = $("#dateOfBirthInput"),

    subjectInput = $("#subjectsInput"),

    hobbiesWrapper = $("#hobbiesWrapper"),

    userUploadPicture = $("#uploadPicture"),

    userCurrentAddress = $("#currentAddress"),

    userState = $("#react-select-3-input"),

    userCity = $("#react-select-4-input"),

    submitButton = $("#submit"),

    modalTitle = $(".modal-title");

    TableResultsComponent tableResultsComponent = new TableResultsComponent();

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        userPhoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserUploadPicture(String value) {
        userUploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setUserCurrentAddress(String value) {
        userCurrentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setUserState(String value) {
        userState.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setUserCity(String value) {
        userCity.setValue(value).pressEnter();

        return this;
    }

    public void clickSubmit() {

        submitButton.click();
    }

    public RegistrationPage checkResults (String key, String value) {
        tableResultsComponent.checkResultTable(key, value);

        return this;
    }

    public void checkUnsuccessfulRegistration() {

        modalTitle.shouldNotBe(exist);
    }


}
