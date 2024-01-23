package pl.akademiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.BaseTest;
import pl.akademiaqa.facades.AddProductToCartFacade;
import pl.akademiaqa.facades.OrderProductFacade;
import pl.akademiaqa.pages.*;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModal;

import static org.assertj.core.api.Assertions.*;

class FullPurchaseTest extends BaseTest {

    private final String productName = "Customizable Mug";

    private HomePage homePage;
    private AddProductToCartFacade addProductToCartFacade;
    private OrderProductFacade orderProductFacade;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        addProductToCartFacade = new AddProductToCartFacade(homePage);
        orderProductFacade = new OrderProductFacade();
    }

//    @Test
//    void should_purchase_selected_product_v1_test() {
//        SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSection().searchForProducts(productName);
//        ProductDetailsPage productDetailsPage = searchResultsPage.getSearchResultsSection().viewProductDetails(productName);
//        productDetailsPage.getProductCustomizationSection().customizeProduct(productName);
//        AddToCartConfirmationModal cartConfirmationModal = productDetailsPage.getAddToCartSection().addProductToCart();
//
//        assertThat(cartConfirmationModal.getConfirmationMessage()).contains("Product successfully added to your shopping cart");
//
//        ShoppingCartPage shoppingCartPage = cartConfirmationModal.proceedToCheckoutOnModal();
//        OrderDetailsPage orderDetailsPage = shoppingCartPage.getSummarySection().proceedToCheckout();
//        OrderAddressSection orderAddressSection = orderDetailsPage.getPersonalInformationSection().enterPersonalInformation();
//        OrderShippingSection orderShippingSection = orderAddressSection.enterAddress();
//        OrderPaymentSection orderPaymentSection = orderShippingSection.selectShippingMethod();
//        OrderConfirmationPage orderConfirmationPage = orderPaymentSection.placeOrder();
//        assertThat(orderConfirmationPage.getOrderDetailsConfirmationSection().
//                getConfirmationTitle()).containsIgnoringCase("Your order is confirmed");
//    }
//
//    @Test
//    void should_purchase_selected_product_v2_test() {
//        AddToCartConfirmationModal confirmationModal =
//                homePage
//                        .searchForProducts(productName)
//                        .viewProductDetails(productName)
//                        .customizeProduct(productName)
//                        .addProductToCart();
//
//        assertThat(confirmationModal.getConfirmationMessage()).contains("Product successfully added to your shopping cart");
//
//        OrderConfirmationPage orderConfirmationPage =
//                confirmationModal
//                        .proceedToCheckoutOnModal()
//                        .proceedToCheckoutOnShoppingCartPage()
//                        .enterOrderDetails();
//
//        assertThat(orderConfirmationPage.getOrderDetailsConfirmationSection().
//                getConfirmationTitle()).containsIgnoringCase("Your order is confirmed");
//    }

    @Test
    void should_purchase_selected_product_v3_test() {
        AddToCartConfirmationModal confirmationModal = addProductToCartFacade
                .addProductWithCustomizationToCart(productName);
        assertThat(confirmationModal.getConfirmationMessage()).contains("Product successfully added to your shopping cart");

        OrderConfirmationPage confirmationPage = orderProductFacade
                .orderProduct(confirmationModal);
        assertThat(confirmationPage.getOrderDetailsConfirmationSection().
                getConfirmationTitle()).containsIgnoringCase("Your order is confirmed");
    }
}
