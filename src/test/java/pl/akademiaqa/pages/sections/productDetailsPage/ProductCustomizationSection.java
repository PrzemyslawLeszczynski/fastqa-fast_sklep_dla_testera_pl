package pl.akademiaqa.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class  ProductCustomizationSection extends BasePage {

    private Locator customMessageInput;
    private Locator saveCustomizationButton;
    private Locator customizationMessage;

    public ProductCustomizationSection(Page page) {
        super(page);
        this.page = page;
        this.customMessageInput = page.locator("#field-textField1");
        this.saveCustomizationButton = page.locator("button[name='submitCustomizedData']");
        this.customizationMessage = page.locator(".customization-message");
    }

    public void customizeProduct(String customMessage) {
        customMessageInput.fill(customMessage);
        saveCustomizationButton.click();
        page.waitForCondition(() -> page.locator(".customization-message").isVisible());
    }
}
