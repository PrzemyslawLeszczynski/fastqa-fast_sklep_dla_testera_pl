package pl.akademiaqa.facades;

import pl.akademiaqa.pages.OrderConfirmationPage;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModal;

public class OrderProductFacade {

    public OrderConfirmationPage orderProduct(AddToCartConfirmationModal confirmationModal) {
        return confirmationModal
                .proceedToCheckoutOnModal()
                .proceedToCheckoutOnShoppingCartPage()
                .enterOrderDetails();
    }
}
