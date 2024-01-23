package pl.akademiaqa.pages.sections.searchResultsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.dto.ProductDTO;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.ProductDetailsPage;
import pl.akademiaqa.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsSection extends BasePage {
    @Getter
    private List<Locator> products;

    public SearchResultsSection(Page page) {
        super(page);
        this.page = page;
        products = page.locator(".js-product").all();
    }

    public ProductDetailsPage viewProductDetails(String productName) {
        ProductDTO productDto = productsToDto().stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Can not find product with name: " + productName));

        productDto.getThumbnail().click();

        return new ProductDetailsPage(page);
    }

    public List<ProductDTO> productsToDto() {
        return products.stream()
                .map(p -> ProductDTO.builder()
                        .thumbnail(p.locator(".thumbnail-top"))
                        .name(p.locator(".product-title").innerText())
                        .price(Double.parseDouble(p.locator(".price").innerText().replaceAll(StringUtils.toUTF8("zł"), " ")))
                        .build())
                .collect(Collectors.toList());
    }
}
