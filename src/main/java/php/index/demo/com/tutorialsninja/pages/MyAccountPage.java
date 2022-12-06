package php.index.demo.com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import php.index.demo.com.tutorialsninja.utility.Utility;

import java.util.List;

public class MyAccountPage extends Utility {
    By myAccount = By.xpath("//span[contains(text(),'My Account')]");
    By verifyRegister = By.xpath("//h1[contains(text(),'Register Account')]");
    By verifyReturning = By.xpath("//h2[contains(text(),'Returning Customer')]");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By enterEmail = By.id("input-email");
    By enterPhone = By.id("input-telephone");
    By enterPass = By.id("input-password");
    By confirmPass = By.id("input-confirm");
    By newsLetter = By.xpath("//input[@name='newsletter']");
    By privacyPolicy = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By clickOnContinue = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    By verifyMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By continueButton = By.xpath("//a[contains(text(),'Continue')]");
    By myAccountTab = By.xpath("//span[contains(text(),'My Account')]");
    By verifyLogout = By.xpath("//h1[contains(text(),'Account Logout')]");
    By loginButton = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void clickOnMyAccount() {
        clickOnElement(myAccount);
    }

    public String getVerifyRegister() {
        return getTextFromElement(verifyRegister);

    }

    public String getVerifyReturning() {
        return getTextFromElement(verifyReturning);
    }

    public void enterFirstName(String name) {
        sendTextToElement(firstName, name);
    }

    public void enterLastName(String lastname) {
        sendTextToElement(lastName, lastname);
    }

    public void enterEmailAdd(String email) {
        sendTextToElement(enterEmail, email);
    }

    public void enterPhone(String phone) {
        sendTextToElement(enterPhone, phone);
    }


    public void enterPassword(String phone) {
        sendTextToElement(enterPass, phone);
    }


    public void enterConfirmPass(String phone) {
        sendTextToElement(confirmPass, phone);
    }


    public void clickYesOnNewsLetter() {
        clickOnElement(newsLetter);
    }

    public void clickOnPrivacy() {
        clickOnElement(privacyPolicy);
    }

    public void clickFinalContinue() {
        clickOnElement(clickOnContinue);
    }

    public String getVerifyMessage() {
        return getTextFromElement(verifyMessage);

    }


    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }


    public void clickOnMyAccountTab() {
        clickOnElement(myAccountTab);
    }


    public String getVerifyLogout() {
        return getTextFromElement(verifyLogout);

    }

    public void clickOnContinueTab() {
        clickOnElement(continueButton);
    }


    public void clickOnLogin() {
        clickOnElement(loginButton);

    }

}
