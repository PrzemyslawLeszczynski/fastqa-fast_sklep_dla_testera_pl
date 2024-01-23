package pl.akademiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.BaseTest;
import pl.akademiaqa.pages.ArtPage;
import pl.akademiaqa.pages.HomePage;

import static org.assertj.core.api.Assertions.*;

class FilterByPriceTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
    }

    @Test
    void should_return_products_by_price_greater_than_40_url() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        String newUrl = page.url() + "&q=Price-zł-40-44";
        page.navigate(newUrl);
        assertThat(artPage.getProductsSections().getProductsPrices().stream().allMatch(p -> p > 40)).isTrue();
    }

    @Test
    void should_return_products_by_price_greater_than_40_by_mouse() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceWithMouse(40.00);
        assertThat(artPage.getProductsSections().getProductsPrices().stream().allMatch(p -> p > 40)).isTrue();
    }

    @Test
    void should_return_products_by_price_greater_than_40_by_keyboard() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceWithKeyboard(40.00);
        assertThat(artPage.getProductsSections().getProductsPrices().stream().allMatch(p -> p > 40)).isTrue();
    }
}
