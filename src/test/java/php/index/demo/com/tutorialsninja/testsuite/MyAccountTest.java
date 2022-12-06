package php.index.demo.com.tutorialsninja.testsuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import php.index.demo.com.tutorialsninja.pages.MyAccountPage;
import php.index.demo.com.tutorialsninja.testbase.BaseTest;

public class MyAccountTest extends BaseTest {
    MyAccountPage myAccountPage = new MyAccountPage();


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccountPage.clickOnMyAccount();
        myAccountPage.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccountPage.getVerifyRegister(), "Register Account", "Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccountPage.clickOnMyAccount();
        myAccountPage.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccountPage.getVerifyReturning(), "Returning Customer", "Message not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        myAccountPage.clickOnMyAccount();
        myAccountPage.selectMyAccountOptions("Register");
        myAccountPage.enterFirstName("ABC");
        myAccountPage.enterLastName("ABCDEF");
        myAccountPage.enterEmailAdd("ABCDEF4@gmail.com");
        myAccountPage.enterPhone("9638258147");
        myAccountPage.enterPassword("abc123");
        myAccountPage.enterConfirmPass("abc123");
        myAccountPage.clickYesOnNewsLetter();
        myAccountPage.clickOnPrivacy();
        myAccountPage.clickFinalContinue();
        Assert.assertEquals(myAccountPage.getVerifyMessage(), "Your Account Has Been Created!", "Message not displayed");
        myAccountPage.clickOnContinueButton();
        myAccountPage.clickOnMyAccountTab();
        myAccountPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountPage.getVerifyLogout(), "Account Logout", "Message not displayed");
        myAccountPage.clickOnContinueTab();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccountPage.clickOnMyAccount();
        myAccountPage.selectMyAccountOptions("Login");
        myAccountPage.enterEmailAdd("ABCDEF3@gmail.com");
        myAccountPage.enterPassword("abc123");
        myAccountPage.clickOnLogin();
        myAccountPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountPage.getVerifyLogout(), "Account Logout", "Message not displayed");
        myAccountPage.clickOnContinueTab();
    }


}

