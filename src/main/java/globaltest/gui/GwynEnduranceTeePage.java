package globaltest.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GwynEnduranceTeePage extends MagnetoBasePage {

    @FindBy(xpath = "//div[@option-label='M']") //id='option-label-size-143-item-168'
    private ExtendedWebElement mediumSizeElement;

    @FindBy(xpath = "//div[@option-label='Green']") //id="option-label-color-93-item-53"
    private ExtendedWebElement greenColorElement;

    @FindBy(xpath = "//div[@option-label='S']") //id='option-label-size-143-item-167'
    private ExtendedWebElement smallSizeElement;

    @FindBy(xpath = "//div[@option-label='Yellow']") //id="option-label-color-93-item-60"
    private ExtendedWebElement yellowColorElement;

    @FindBy(id = "qty")
    private ExtendedWebElement quantityElement;

    @FindBy(id = "product-addtocart-button")
    private ExtendedWebElement addToCartButton;

    public GwynEnduranceTeePage(WebDriver driver) {
        super(driver);
    }

    public CartPage addFourGreenItemsToCart() {
        this.mediumSizeElement.click();
        this.greenColorElement.click();
        this.quantityElement.type("4");
        this.addToCartButton.click();
        this.cartQuickViewComponent = assertSuccessMessageAfterAddedItemInCartAndShowCart("You added Gwyn " +
                "Endurance Tee to your shopping cart.", "4");
        //verify all added items are visible in quick view mode of the cart
        this.cartQuickViewComponent = new CartQuickViewComponent(driver);
        return this.cartQuickViewComponent.verifyGreenGwynItemsInCart();
    }

    public void addYellowItemInCart() {
        this.smallSizeElement.click();
        this.yellowColorElement.click();
        this.quantityElement.type("1");
        this.addToCartButton.click();
        this.cartQuickViewComponent = assertSuccessMessageAfterAddedItemInCartAndShowCart("You added Gwyn" +
                " Endurance Tee to your shopping cart.", "4");
        //verify all added items are visible in quick view mode of the cart
        this.cartQuickViewComponent.verifyYellowGwynItemsInCart();
    }
}
