package php.index.demo.com.tutorialsninja.testsuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import php.index.demo.com.tutorialsninja.pages.TopMenuPage;
import php.index.demo.com.tutorialsninja.testbase.BaseTest;


public class TopMenuTest extends BaseTest {
    TopMenuPage topMenuPage = new TopMenuPage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        topMenuPage.hoverAndClickOnDesktop();
        topMenuPage.selectMenu("Show All Desktops");
        String expectedText = "Desktops";
        Assert.assertEquals(topMenuPage.getDesktopText(),expectedText,"No such text as Desktops");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        topMenuPage.hoverAndClickOnLaptopAndNotebook();
        topMenuPage.selectMenu("Show All Laptops & Notebooks");
        String expectedText = "Laptops & Notebooks";
        Assert.assertEquals(topMenuPage.getLaptopAndNotebookText(),expectedText,"No such text as Laptops & Notebooks");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        topMenuPage.hoverAndClickOnComponents();
        topMenuPage.selectMenu("Show All Components");
        String expectedText = "Components";
        Assert.assertEquals(topMenuPage.getComponentsText(),expectedText,"Components not displayed");
    }
}
