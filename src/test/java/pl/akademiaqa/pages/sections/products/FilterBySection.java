package pl.akademiaqa.pages.sections.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.akademiaqa.pages.ArtPage;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.utils.StringUtils;

import java.util.Arrays;

import static pl.akademiaqa.utils.PageUtils.waitForPageTpoLoad;
import static pl.akademiaqa.utils.StringUtils.*;

public class FilterBySection extends BasePage {

    private Locator leftSlider;
    private Locator priceLabel;
    private Locator compositionLabel;

    public FilterBySection(Page page) {
        super(page);
        this.page = page;
        this.leftSlider = page.locator(".ui-slider-handle").first();
        this.priceLabel = page.locator("#search_filters li p");
        this.compositionLabel = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Matt paper"));
    }

//    public void showLeftSlider() {
//        System.out.println(leftSlider.boundingBox().x);
//        System.out.println(leftSlider.boundingBox().y);
//        System.out.println(leftSlider.boundingBox().height);
//        System.out.println(leftSlider.boundingBox().width);
//     }

    public void filterProductsByPriceWithMouse(double fromPrice) {

        while (fromPrice != getFromPrice()) {

            leftSlider.scrollIntoViewIfNeeded();
            double x = leftSlider.boundingBox().x;
            double y = leftSlider.boundingBox().y;

            double middleX = x + leftSlider.boundingBox().width / 2;
            double middleY = y + leftSlider.boundingBox().height / 2;

            page.mouse().move(middleX, middleY);
            page.mouse().down();
            page.mouse().move(x + 7.00, y);
            page.mouse().up();
            page.waitForCondition(() -> page.locator(".overlay__inner").isHidden());
        }
    }

    public void filterProductsByPriceWithKeyboard(double fromPrice) {

        while (fromPrice != getFromPrice()) {
            leftSlider.press("ArrowRight");
            page.waitForCondition(() -> page.locator(".overlay__inner").isHidden());
        }
    }

    public ArtPage filterProductsByComposition() {
        compositionLabel.click();
        page.waitForCondition(() -> page.locator(".overlay__inner").isHidden());
        return new ArtPage(page);
    }

    private double getFromPrice() {
        return Arrays.asList(page.locator("#search_filters li p").innerText().split(" "))
                .stream()
                .map(p -> p.replaceAll(toUTF8("zł"), ""))
                .map(Double::parseDouble)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Incorrect price format"));
    }
}
