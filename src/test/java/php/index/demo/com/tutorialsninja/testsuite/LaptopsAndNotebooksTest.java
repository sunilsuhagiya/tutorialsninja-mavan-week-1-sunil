package php.index.demo.com.tutorialsninja.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import php.index.demo.com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import php.index.demo.com.tutorialsninja.testbase.BaseTest;


public class LaptopsAndNotebooksTest extends BaseTest {

    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        laptopsAndNotebooksPage.clickOnLaptopLink();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.productPriceSort();

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        laptopsAndNotebooksPage.changeCurrency();
        laptopsAndNotebooksPage.clickOnLaptopLink();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.productPriceSort();
        laptopsAndNotebooksPage.clickOnMacbook();
        Assert.assertEquals(laptopsAndNotebooksPage.textMacbook(), "MacBook", "Text does not match");
        laptopsAndNotebooksPage.clickOnButtonCart();
        Assert.assertEquals(laptopsAndNotebooksPage.getVerifySuccess(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        laptopsAndNotebooksPage.clickOnCart();
        Assert.assertEquals(laptopsAndNotebooksPage.getVerifyCart(), "Shopping Cart", "Message not Displayed");
        Assert.assertEquals(laptopsAndNotebooksPage.verifyMacbookText(), "MacBook", "Message not displayed");
        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        quantity.clear();
        sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), "2");
        laptopsAndNotebooksPage.setClickOnUpdateCart();
        Assert.assertEquals(laptopsAndNotebooksPage.cartUpdateText(), "Success: You have modified your shopping cart!\n" + "×", "Does not match");
        Assert.assertEquals(laptopsAndNotebooksPage.totalAmountText(), "£737.45", "Does not match");

        Assert.assertEquals(laptopsAndNotebooksPage.getVerifyCheckout(), "Checkout", "Does not match");
        laptopsAndNotebooksPage.clickOnCheckoutCart();
        Assert.assertEquals(laptopsAndNotebooksPage.getVerifyNewCustomer(), "New Customer", "Does not match");
        laptopsAndNotebooksPage.clickOnGuestCheckout();
        laptopsAndNotebooksPage.clickOnContinueTab();
        laptopsAndNotebooksPage.enterName("Prime");
        laptopsAndNotebooksPage.enterLastName("testing");
        laptopsAndNotebooksPage.enterEmail("prime1234@gmail.com");
        laptopsAndNotebooksPage.enterTelephone("123456789012");
        laptopsAndNotebooksPage.enterAddress("abc");
        laptopsAndNotebooksPage.enterCity("surat");
        laptopsAndNotebooksPage.enterPostcode("41252");
        laptopsAndNotebooksPage.enterCountry("India");
        laptopsAndNotebooksPage.enterState("Maharashtra");
        laptopsAndNotebooksPage.clickOnCheckout();
        laptopsAndNotebooksPage.enterMessage("Please consider my order ASAP");
        laptopsAndNotebooksPage.clickOnTerms();
        laptopsAndNotebooksPage.clickContinue();
        Assert.assertEquals(laptopsAndNotebooksPage.getVerifyWarningMsg(), "Warning: Payment method required!\n" + "×", "Does not match");

    }

}


