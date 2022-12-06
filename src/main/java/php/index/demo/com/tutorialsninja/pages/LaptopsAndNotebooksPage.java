package php.index.demo.com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import php.index.demo.com.tutorialsninja.utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    By laptopAndNotebooksLink = By.linkText("Laptops & Notebooks");
    By clickOnShowAllLaptopsAndNotebooks = By.linkText("Show All Laptops & Notebooks");
    By clickMacbook = By.linkText("MacBook");
    By verifyTextMacbook = By.xpath("//h1[contains(text(),'MacBook')]");
    By clickButtonCart = By.xpath("//button[@id='button-cart']");
    By verifySuccess = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By verifyCart = By.xpath("//a[contains(text(),'Shopping Cart')]");
    By getVerifyTextMacbook = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By sendQuantity = By.xpath("//input[contains(@name, 'quantity')]");
    By ClickOnUpdateCart = By.xpath("//button[contains(@data-original-title, 'Update')]");
    By verifyCartUpdateText = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By verifyTotalAmount = By.xpath("//tbody/tr[1]/td[6]");
    By clickOnCart = By.xpath("//span[contains(text(),'Checkout')]");
    By clickOnCheckout = By.xpath("//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[2]/strong[1]");
    By verifyCheckout = By.xpath("//a[contains(text(),'Checkout')]");
    By verifyNewCustomer = By.xpath("//h2[contains(text(),'New Customer')]");
    By guestCheckout = By.xpath("//label[text()[normalize-space()='Guest Checkout']]");
    By continueTab = By.xpath("//input[@id='button-account']");
    By nameField = By.name("firstname");
    By lastnameField = By.name("lastname");
    By emailField = By.id("input-payment-email");
    By telephone = By.name("telephone");
    By addressLine = By.name("address_1");
    By cityName = By.name("city");
    By postCode = By.name("postcode");
    By countryName = By.id("input-payment-country");
    By zoneName = By.xpath("//select[@id='input-payment-zone']");
    By continueCheckout = By.xpath("(//input[@value='Continue'])[2]");
    By passText = By.xpath("//textarea[@name='comment']");
    By termsAndCondition = By.xpath("//input[@type='checkbox']");
    By lastContinue = By.xpath("//input[@id='button-payment-method']");
    By warningMessage = By.xpath("//div[contains(@class,'alert alert-danger')]");

    public void changeCurrency() {
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    public void clickOnLaptopLink() {
        clickOnElement(laptopAndNotebooksLink);
    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        clickOnElement(clickOnShowAllLaptopsAndNotebooks);
    }

    public String productPriceSort() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (Low > High)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        return null;
    }

    public void clickOnMacbook() {
        clickOnElement(clickMacbook);
    }

    public String textMacbook() {
        return getTextFromElement(verifyTextMacbook);
    }

    public void clickOnButtonCart() {
        clickOnElement(clickButtonCart);
    }

    public String getVerifySuccess() {
        return getTextFromElement(verifySuccess);
    }

    public void clickOnCart() {
        clickOnElement(shoppingCart);
    }

    public String getVerifyCart() {
        return getTextFromElement(verifyCart);
    }

    public String verifyMacbookText() {
        return getTextFromElement(getVerifyTextMacbook);
    }

    public void setSendQuantity(String quantity) {
        sendTextToElement(sendQuantity, quantity);
    }

    public void setClickOnUpdateCart() {
        clickOnElement(ClickOnUpdateCart);
    }

    public String cartUpdateText() {
        return getTextFromElement(verifyCartUpdateText);
    }

    public String totalAmountText() {
        return getTextFromElement(verifyTotalAmount);
    }

    public void clickOnCheckoutCart() {
        clickOnElement(clickOnCart);
    }

    public void clickOnFinalCheckout() {
        clickOnElement(clickOnCheckout);
    }

    public String getVerifyCheckout() {
        return getTextFromElement(verifyCheckout);
    }

    public String getVerifyNewCustomer() {
        return getTextFromElement(verifyNewCustomer);
    }

    public void clickOnGuestCheckout() {
        clickOnElement(guestCheckout);
    }

    public void clickOnContinueTab() {
        clickOnElement(continueTab);
    }

    public void enterName(String name) {
        sendTextToElement(nameField, name);
    }

    public void enterLastName(String lastname) {
        sendTextToElement(lastnameField, lastname);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterTelephone(String phone) {
        sendTextToElement(telephone, phone);
    }

    public void enterAddress(String street) {
        sendTextToElement(addressLine, street);
    }

    public void enterCity(String city) {
        sendTextToElement(cityName, city);
    }

    public void enterPostcode(String code) {
        sendTextToElement(postCode, code);
    }

    public void enterCountry(String country) {
        sendTextToElement(countryName, country);
    }

    public void enterState(String state) {
        sendTextToElement(zoneName, state);
    }

    public void clickOnCheckout() {
        clickOnElement(continueCheckout);
    }

    public void enterMessage(String msg) {
        sendTextToElement(passText, msg);
    }

    public void clickOnTerms() {
        clickOnElement(termsAndCondition);
    }

    public void clickContinue() {
        clickOnElement(lastContinue);
    }

    public String getVerifyWarningMsg() {
        return getTextFromElement(warningMessage);
    }
}



