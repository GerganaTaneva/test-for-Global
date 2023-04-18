package globaltest.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartQuickViewComponent extends AbstractUIObject {

    @FindBy(xpath = "//strong[@class='product-item-name']")
    private List<ExtendedWebElement> productFields;

    @FindBy(xpath = "//input[@data-cart-item-id='WS01-M-Green']")
    private ExtendedWebElement greenGwynItem;

    @FindBy(xpath = "//input[@data-cart-item-id='WS01-S-Yellow']")
    private ExtendedWebElement yellowGwynItem;

    @FindBy(xpath = "//input[@data-cart-item-id='24-UG01']")
    private ExtendedWebElement bandItem;

    @FindBy(xpath = "//a[@class ='action viewcart']")
    private ExtendedWebElement viewCartButton;

    public CartQuickViewComponent(WebDriver driver){
        super(driver);
    }

    public CartPage viewCart() {
        this.viewCartButton.click();
        return new CartPage(driver);
    }

    public CartPage verifyGreenGwynItemsInCart(){
        Assert.assertTrue(this.productFields.get(0).isVisible(), "The product field is not visible.");
        Assert.assertEquals(this.productFields.get(0).getText(), "Gwyn Endurance Tee");
        Assert.assertTrue(this.greenGwynItem.isVisible(), "The product's quantity is not visible.");
        Assert.assertTrue(this.greenGwynItem.isClickable(), "The product's quantity is not clickable.");
        return this.viewCart();
    }

    public void verifyYellowGwynItemsInCart(){
        Assert.assertTrue(this.productFields.get(1).isVisible(), "The product field is not visible.");
        Assert.assertEquals(this.productFields.get(1).getText(), "Gwyn Endurance Tee");
        Assert.assertTrue(this.yellowGwynItem.isVisible(), "The product's quantity is not visible.");
        Assert.assertTrue(this.yellowGwynItem.isClickable(), "The product's quantity is not clickable.");
    }

    public void verifyBandInCart(){
        Assert.assertTrue(this.productFields.get(2).isVisible(), "The product field is not visible.");
        Assert.assertEquals(this.productFields.get(2).getText(), "Gwyn Endurance Tee");
        Assert.assertTrue(this.bandItem.isVisible(), "The product's quantity is not visible.");
        Assert.assertTrue(this.bandItem.isClickable(), "The product's quantity is not clickable.");
    }
}
