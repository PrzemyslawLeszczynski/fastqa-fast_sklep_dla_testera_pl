package pl.akademiaqa.pages.sections.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static pl.akademiaqa.utils.PageUtils.waitForPageTpoLoad;
import static pl.akademiaqa.utils.StringUtils.*;


public class ProductsSections extends BasePage {

    @Getter
    private List<Locator> products;
    @Getter
    private Locator mattPaperProductLabel;
    @Getter
    private Locator mattPaperProductItemsCountLabel;

    public ProductsSections(Page page) {
        super(page);
        waitForPageTpoLoad(page);
        this.page = page;
        this.products = page.locator("#js-product-list .js-product").all();
        this.mattPaperProductLabel = page.getByText("There are 3 products.");
        this.mattPaperProductItemsCountLabel = page.getByText("Showing 1-3 of 3 item(s)").last();
    }

    private List<String> getProductsPricesText() {
        return page.locator(".js-product .price").allInnerTexts();
    }

    public List<Double> getProductsPrices() {
        return getProductsPricesText().
                stream()
                .map(p -> p.replaceAll(toUTF8("zł"), ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
