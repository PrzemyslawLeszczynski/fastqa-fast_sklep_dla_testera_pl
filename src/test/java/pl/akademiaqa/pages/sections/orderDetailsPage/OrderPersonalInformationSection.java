package pl.akademiaqa.pages.sections.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.utils.EmailUtils;

import static pl.akademiaqa.utils.EmailUtils.*;

public class OrderPersonalInformationSection extends BasePage {

    private final String personalInformationSection = "#checkout-personal-information-step";
    private final String customerForm = personalInformationSection + " #customer-form ";

    private Locator socialTitleMr;
    private Locator socialTitleMrs;
    private Locator firstNameInput;
    private Locator lastNameInput;
    private Locator emailInput;
    private Locator passwordInput;
    private Locator dobInput;
    private Locator termsAndConditionsCheckBox;
    private Locator customerPrivacySCheckBox;
    private Locator continueButton;


    public OrderPersonalInformationSection(Page page) {
        super(page);
        this.socialTitleMr = page.locator(customerForm + "#field-id_gender-1");
        this.socialTitleMrs = page.locator(customerForm + "#field-id_gender-2");
        this.firstNameInput = page.locator(customerForm + "#field-firstname");
        this.lastNameInput = page.locator(customerForm + "#field-lastname");
        this.emailInput = page.locator(customerForm + "#field-email");
        this.passwordInput = page.locator(customerForm + "#field-password");
        this.dobInput = page.locator(customerForm + "#field-birthday");
        this.termsAndConditionsCheckBox = page.locator(customerForm + "input[name=psgdpr]");
        this.customerPrivacySCheckBox = page.locator(customerForm + "input[name=customer_privacy]");
        this.continueButton = page.locator(customerForm + "button[name=continue]").first();
    }

    public OrderAddressSection enterPersonalInformation() {
        selectSocialTitleMr()
                .selectSocialTitleMrs()
                .enterFirstName("Jan")
                .enterLastName("Kowalski")
                .enterEmail(getRandomEmail())
                .enterPassword("123456@#$Fff")
                .enterDob("2000-01-01")
                .acceptTermsAndConditions()
                .acceptPrivacyPolicy()
                .clickContinueButton();
        return new OrderAddressSection(page);
    }

    private OrderPersonalInformationSection selectSocialTitleMr() {
        socialTitleMr.check();
        return this;
    }

    private OrderPersonalInformationSection selectSocialTitleMrs() {
        socialTitleMrs.check();
        return this;
    }

    private OrderPersonalInformationSection enterFirstName(String firstName) {
        firstNameInput.type(firstName);
        return this;
    }

    private OrderPersonalInformationSection enterLastName(String lastName) {
        lastNameInput.type(lastName);
        return this;
    }

    private OrderPersonalInformationSection enterEmail(String email) {
        emailInput.type(email);
        return this;
    }

    private OrderPersonalInformationSection enterPassword(String password) {
        passwordInput.type(password);
        return this;
    }

    private OrderPersonalInformationSection enterDob(String dob) {
        dobInput.type(dob);
        return this;
    }

    private OrderPersonalInformationSection acceptTermsAndConditions() {
        termsAndConditionsCheckBox.check();
        return this;
    }

    private OrderPersonalInformationSection acceptPrivacyPolicy() {
        customerPrivacySCheckBox.check();
        return this;
    }

    private OrderPersonalInformationSection clickContinueButton() {
        continueButton.click();
        return this;
    }
}
