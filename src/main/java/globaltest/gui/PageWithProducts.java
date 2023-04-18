package globaltest.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageWithProducts extends MagnetoBasePage {

    @FindBy(xpath = "//img[@alt='Gwyn Endurance Tee']")
    private ExtendedWebElement gwynEnduranceTee;

    @FindBy(xpath = "//img[@alt='Quest Lumaflex™ Band']")
    private ExtendedWebElement bandItem;

    @FindBy(xpath = "//button[@title = 'Add to Cart']")
    private List<ExtendedWebElement> addToCartButtons;

    public PageWithProducts(WebDriver driver) {
        super(driver);
    }

    public GwynEnduranceTeePage openGwynEnduranceTee() {
        this.gwynEnduranceTee.click();
        return new GwynEnduranceTeePage(driver);
    }

    public CartPage addBandItemToCart() {
        this.bandItem.hover();
        this.addToCartButtons.get(0).click();
        assertSuccessMessageAfterAddedItemInCartAndShowCart("You added Quest Lumaflex™ Band to your" +
                " shopping cart.", "5");
        super.cartQuickViewComponent = new CartQuickViewComponent(driver);
        super.cartQuickViewComponent.verifyBandInCart();
        return super.cartQuickViewComponent.viewCart();
    }
}
