package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.products.FilterBySection;
import pl.akademiaqa.pages.sections.products.ProductsSections;

@Getter
public class ArtPage extends BasePage {
    private ProductsSections productsSections;
    private FilterBySection filterBySection;

    public ArtPage(Page page) {
        super(page);
        this.productsSections = new ProductsSections(page);
        this.filterBySection = new FilterBySection(page);
    }
}
