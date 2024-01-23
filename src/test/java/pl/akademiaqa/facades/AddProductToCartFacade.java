package pl.akademiaqa.facades;

import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModal;

public class AddProductToCartFacade {

    private HomePage homePage;

    public AddProductToCartFacade(HomePage homepage) {
        this.homePage = homepage;
    }

    public AddToCartConfirmationModal addProductWithCustomizationToCart(String productName) {
        return homePage
                .searchForProducts(productName)
                .viewProductDetails(productName)
                .customizeProduct(productName)
                .addProductToCart();
    }

    public AddToCartConfirmationModal addProductToCart(String productName) {
        return homePage
                .searchForProducts(productName)
                .viewProductDetails(productName)
                .addProductToCart();
    }
}
