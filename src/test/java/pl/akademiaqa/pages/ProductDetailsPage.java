package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModal;
import pl.akademiaqa.pages.sections.productDetailsPage.AddToCartSection;
import pl.akademiaqa.pages.sections.productDetailsPage.ProductCustomizationSection;

import static pl.akademiaqa.utils.PageUtils.*;

@Getter
public class ProductDetailsPage extends BasePage {

    private ProductCustomizationSection productCustomizationSection;
    private AddToCartSection addToCartSection;

    public ProductDetailsPage(Page page) {
        super(page);
        waitForPageTpoLoad(page);
        this.productCustomizationSection = new ProductCustomizationSection(page);
        this.addToCartSection = new AddToCartSection(page);
    }

    public ProductDetailsPage customizeProduct(String customMessage) {
        productCustomizationSection.customizeProduct(customMessage);
        return this;
    }

    public AddToCartConfirmationModal addProductToCart() {
        return addToCartSection.addProductToCart();
    }
}
