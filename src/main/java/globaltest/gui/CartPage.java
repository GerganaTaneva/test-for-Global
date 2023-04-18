package globaltest.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends AbstractPage {

    @FindBy(id = "block-shipping-heading")
    private ExtendedWebElement shippingHeading;

    @FindBy(name = "country_id")
    private ExtendedWebElement shippingCountry;

    @FindBy(xpath = "//option[@data-title='United Kingdom']")
    private ExtendedWebElement unitedKingdomOption;

    @FindBy(xpath = "//td[@data-th='Discount']")
    private ExtendedWebElement appliedDiscount;

    @FindBy(xpath = "//td[@data-th='Order Total']")
    private ExtendedWebElement orderTotal;

    @FindBy(xpath = "//input[@class='input-text qty']")
    private ExtendedWebElement greenGwynQuantity;

    @FindBy(xpath = "//button[@class ='action update']")
    private ExtendedWebElement updateCartButton;

    @FindBy(xpath = "//*[@id='shopping-cart-table']/tbody[1]/tr[1]/td[1]/div/strong/a")
    private ExtendedWebElement greenGwynEnduranceItem;

    public CartPage(WebDriver driver){
        super(driver);
    }

    public void updateQuantityOfGreenGwynItem() {
//        if(shippingHeading.isClickable() && this.shippingCountry.isVisible()) {
            this.shippingHeading.click();
            this.shippingCountry.click();
            this.unitedKingdomOption.click();
            pause(5);
            Assert.assertEquals(this.appliedDiscount.getText(), "-$24.00");
            Assert.assertEquals(this.orderTotal.getText(), "$92.00");
            this.greenGwynQuantity.click();
            this.greenGwynQuantity.type("3");
            this.updateCartButton.click();
            pause(5);
            Assert.assertEquals(this.orderTotal.getText(), "$87.00");
//        }
    }

    public GwynEnduranceTeePage openGwynItemPage() {
        this.greenGwynEnduranceItem.click();
        return new GwynEnduranceTeePage(driver);
    }

    public void verifyFinalTotal(String price) {
        Assert.assertEquals(this.orderTotal.getText(), price);
    }
}
