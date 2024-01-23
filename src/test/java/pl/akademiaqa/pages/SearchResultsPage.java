package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.searchResultsPage.SearchResultsSection;

import static pl.akademiaqa.utils.PageUtils.*;

public class SearchResultsPage extends BasePage {
    @Getter
    private SearchResultsSection searchResultsSection;

    public SearchResultsPage(Page page) {
        super(page);
        waitForPageTpoLoad(page);
        this.searchResultsSection = new SearchResultsSection(page);
    }

    public ProductDetailsPage viewProductDetails(String productName) {
        return getSearchResultsSection().viewProductDetails(productName);
    }
}
