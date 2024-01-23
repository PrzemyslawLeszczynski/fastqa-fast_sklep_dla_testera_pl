package pl.akademiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.BaseTest;
import pl.akademiaqa.pages.ArtPage;
import pl.akademiaqa.pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterByCompositionTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
    }

    @Test
    void should_return_products_by_composition() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection()
                .clickArtLink()
                .getFilterBySection()
                .filterProductsByComposition();
        assertThat(artPage.getProductsSections().getMattPaperProductLabel().isVisible()
                && artPage.getProductsSections().getMattPaperProductItemsCountLabel().isVisible());
        assertThat(artPage.getProductsSections().getProducts().size()).isEqualTo(3);
    }
}
