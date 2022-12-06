package php.index.demo.com.tutorialsninja.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import php.index.demo.com.tutorialsninja.pages.DesktopsPage;
import php.index.demo.com.tutorialsninja.pages.TopMenuPage;
import php.index.demo.com.tutorialsninja.testbase.BaseTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends BaseTest {

    TopMenuPage topMenuPage = new TopMenuPage();
    DesktopsPage desktopsPage = new DesktopsPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder(){
        topMenuPage.hoverAndClickOnDesktop();
        desktopsPage.clickOnShowAllDesktops();
        desktopsPage.productSortByZToA();

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        desktopsPage.changeCurrency();
        topMenuPage.hoverAndClickOnDesktop();
        desktopsPage.clickOnShowAllDesktops();
        desktopsPage.productSortByZToA();
        desktopsPage.clickOnHPLP3065();
        String expectedMessage = "HP LP3065";
        Assert.assertEquals(desktopsPage.VerifyTextHPLP3065(),expectedMessage,"HP LP3065 did not displayed");
        desktopsPage.deliveryDate();
        desktopsPage.clickOnAddToCart();
        String expectedMessage1 = "HP LP3065";
        Assert.assertEquals(desktopsPage.VerifyShoppingCart(),expectedMessage1,"Unsuccessful");
        desktopsPage.clickOnShoppingCart();

        Assert.assertEquals(desktopsPage.VerifyShoppingCart(),"Shopping Cart  (1.00kg)", "Message not displayed");
        Assert.assertEquals(desktopsPage.verifyTextHPLP3065(),"HP LP3065","Message not displayed");
        Assert.assertEquals(desktopsPage.verifyDateOfDelivery(),"Delivery Date: 2023-11-30","Does Not match");
        Assert.assertEquals(desktopsPage.verifyProduct21(),"Product 21","Does not match");

        Assert.assertEquals(desktopsPage.verifyAmount(),"£74.73","Does not match");
    }

}
