package globaltest.gui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MagnetoBasePage extends AbstractPage {

    @FindBy(id = "search")
    protected ExtendedWebElement searchField;

    @FindBy(xpath = "//button[@title='Search']")
    protected ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@data-ui-id='message-success']")
    protected ExtendedWebElement successMessageField;

    @FindBy(xpath = "//span[@class ='counter-number']") //className = "counter-number"
    protected ExtendedWebElement cartCounterNumber;

    @FindBy(xpath = "//a[@class ='action showcart']")
    protected ExtendedWebElement showCartButton;

    protected CartQuickViewComponent cartQuickViewComponent;

    public MagnetoBasePage(WebDriver driver){
        super(driver);
    }

    public void openHomePage() {
        openURL("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    public PageWithProducts findProductByName(String productName) {
        this.searchField.click();
        this.searchField.type(productName);
        this.searchButton.click();
        return new PageWithProducts(driver);
    }

    protected CartQuickViewComponent assertSuccessMessageAfterAddedItemInCartAndShowCart(String message, String counter){
        Assert.assertTrue(this.successMessageField.isVisible());
        Assert.assertEquals(this.successMessageField.getText(), message);
        Assert.assertEquals(this.cartCounterNumber.getText(), counter);
        this.showCartButton.click();
        return new CartQuickViewComponent(driver);
    }
}
