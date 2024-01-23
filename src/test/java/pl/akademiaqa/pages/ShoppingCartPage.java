package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.shoppingCartPage.SummarySection;

import static pl.akademiaqa.utils.PageUtils.*;

@Getter
public class ShoppingCartPage extends BasePage {

    private SummarySection summarySection;

    public ShoppingCartPage(Page page) {
        super(page);
        waitForPageTpoLoad(page);
        this.summarySection = new SummarySection(page);
    }

    public OrderDetailsPage proceedToCheckoutOnShoppingCartPage() {
        return summarySection.proceedToCheckout();
    }
}
