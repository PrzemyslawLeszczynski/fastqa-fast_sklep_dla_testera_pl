package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.orderConfirmationPage.OrderDetailsConfirmationSection;

@Getter
public class OrderConfirmationPage extends BasePage {

    private OrderDetailsConfirmationSection orderDetailsConfirmationSection;

    public OrderConfirmationPage(Page page) {
        super(page);
        this.orderDetailsConfirmationSection = new OrderDetailsConfirmationSection(page);
    }
}
