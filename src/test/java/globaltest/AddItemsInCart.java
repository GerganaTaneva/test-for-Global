package globaltest;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import globaltest.gui.CartPage;
import globaltest.gui.GwynEnduranceTeePage;
import globaltest.gui.MagnetoBasePage;
import globaltest.gui.PageWithProducts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemsInCart extends AbstractTest {

    private WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeWindow() {
        driver.close();
    }

    @Test(description = "Add 4 green Gwyn items, 1 yellow Gwyn item and 1 band in cart")
    @MethodOwner(owner = "Gergana Eneva")
    public void addItemsInCart() {
        MagnetoBasePage homePage = new MagnetoBasePage(driver);
        homePage.openHomePage();
        PageWithProducts pageWithProducts = homePage.findProductByName("Gwyn Endurance Tee");
        GwynEnduranceTeePage gwynEnduranceTeePage = pageWithProducts.openGwynEnduranceTee();
        //add items and verify the items in cart
        CartPage cartPage = gwynEnduranceTeePage.addFourGreenItemsToCart();
        cartPage.updateQuantityOfGreenGwynItem();
        gwynEnduranceTeePage = cartPage.openGwynItemPage();
        gwynEnduranceTeePage.addYellowItemInCart();
        pageWithProducts = gwynEnduranceTeePage.findProductByName("Quest Lumaflex™ Band");
        cartPage = pageWithProducts.addBandItemToCart();
        cartPage.verifyFinalTotal("$116.00");
    }
}