package pl.akademiaqa.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModal;

public class AddToCartSection extends BasePage {

    private Locator addToCartButton;

    public AddToCartSection(Page page) {
        super(page);
        this.page = page;
        this.addToCartButton = page.locator("button.add-to-cart");
    }

    public AddToCartConfirmationModal addProductToCart() {
        addToCartButton.click();
        return new AddToCartConfirmationModal(page);
    }
}
