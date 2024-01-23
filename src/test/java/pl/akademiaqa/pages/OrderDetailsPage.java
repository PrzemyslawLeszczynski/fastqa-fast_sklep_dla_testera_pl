package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.orderDetailsPage.OrderAddressSection;
import pl.akademiaqa.pages.sections.orderDetailsPage.OrderPaymentSection;
import pl.akademiaqa.pages.sections.orderDetailsPage.OrderPersonalInformationSection;
import pl.akademiaqa.pages.sections.orderDetailsPage.OrderShippingSection;
import pl.akademiaqa.utils.PageUtils;

import static pl.akademiaqa.utils.PageUtils.*;

@Getter
public class OrderDetailsPage extends BasePage {

    private OrderPersonalInformationSection personalInformationSection;
    private OrderAddressSection addressSection;
    private OrderShippingSection shippingSection;

    private OrderPaymentSection paymentSection;

    public OrderDetailsPage(Page page) {
        super(page);
        waitForPageTpoLoad(page);
        this.personalInformationSection = new OrderPersonalInformationSection(page);
        this.addressSection = new OrderAddressSection(page);
        this.shippingSection = new OrderShippingSection(page);
        this.paymentSection = new OrderPaymentSection(page);
    }

    public OrderConfirmationPage enterOrderDetails() {
        return personalInformationSection
                .enterPersonalInformation()
                .enterAddress()
                .selectShippingMethod()
                .placeOrder();
    }
}
