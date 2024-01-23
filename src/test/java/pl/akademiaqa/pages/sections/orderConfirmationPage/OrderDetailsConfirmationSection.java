package pl.akademiaqa.pages.sections.orderConfirmationPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class OrderDetailsConfirmationSection extends BasePage {

    private final static String orderConfirmationSection = "#content-hook_order_confirmation ";
    private Locator title;

    public OrderDetailsConfirmationSection(Page page) {
        super(page);
        this.title = page.locator(orderConfirmationSection + "h3[class='h1 card-title']");
    }

    public String getConfirmationTitle() {
        return title.innerText();
    }
}
