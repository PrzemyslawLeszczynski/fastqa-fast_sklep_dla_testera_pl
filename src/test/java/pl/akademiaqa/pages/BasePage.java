package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.common.TopMenuAndSearchSection;
import pl.akademiaqa.pages.sections.common.TopNavigationSection;

public class BasePage {

    protected Page page;
    @Getter
    protected TopMenuAndSearchSection topMenuAndSearchSection;
    @Getter
    protected TopNavigationSection topNavigationSection;

    public BasePage(Page page) {
        this.page = page;
        topMenuAndSearchSection = new TopMenuAndSearchSection(page);
        topNavigationSection = new TopNavigationSection(page);
    }

    public SearchResultsPage searchForProducts(String productName) {
        return topMenuAndSearchSection.searchForProducts(productName);
    }

    public void setPageLanguageToEn() {
        topNavigationSection.setPageLanguagetoEn();
    }

    public ArtPage clickArtLink() {
        return topMenuAndSearchSection.clickArtLink();
    }
}
