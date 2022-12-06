package php.index.demo.com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import php.index.demo.com.tutorialsninja.utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {
    By currencyLink = By.xpath("//span[contains(text(),'Currency')]");
    By clickOnElementShowAllDesktops = By.linkText("Show All Desktops");
    By sortProductByZToA = By.id("input-sort");
    By clickOnHPLP3065 = By.xpath("//a[contains(text(),'HP LP3065')]");
    By verifyProductHPLP3065 = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By deliveryDate = By.xpath("//div[@class = 'input-group date']//button");
    By selectQuantity = By.xpath("//button[@id='button-cart']");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By VerifyTextHPLP3065 = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By clickOnShoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By VerifyTextShoppingCart = By.xpath("//div[@id='content']//h1");
    By verifyHPLP3065 = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By verifyDateOfDelivery = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By verifyTextProduct21 = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
    By verifyTotalAmount = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");


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

    public void clickOnShowAllDesktops() {
        clickOnElement(clickOnElementShowAllDesktops);
    }

    public String productSortByZToA() {
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

        return null;
    }

    public void clickOnHPLP3065() {
        clickOnElement(clickOnHPLP3065);
    }

    public String verifyProductHPLP3065() {
        return getTextFromElement(verifyProductHPLP3065);
    }

    public void deliveryDate() {
        //select delivery date
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        //clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void selectionOfQuantity(String quantity) {
        sendTextToElement(selectQuantity, quantity);
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

    public String VerifyTextHPLP3065() {
        return getTextFromElement(VerifyTextHPLP3065);
    }

    public void clickOnShoppingCart() {
        clickOnElement(clickOnShoppingCart);
    }

    public String VerifyShoppingCart() {
        return getTextFromElement(VerifyTextShoppingCart);
    }

    public String verifyTextHPLP3065() {
        return getTextFromElement(verifyHPLP3065);
    }

    public String verifyDateOfDelivery() {
        return getTextFromElement(verifyDateOfDelivery);
    }

    public String verifyProduct21() {
        return getTextFromElement(verifyTextProduct21);
    }

    public String verifyAmount() {
        return getTextFromElement(verifyTotalAmount);
    }

}
