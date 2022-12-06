package php.index.demo.com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import php.index.demo.com.tutorialsninja.utility.Utility;
import java.util.List;

public class TopMenuPage extends Utility {
    By selectMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By tabDesktop = By.linkText("Desktops");
    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    By tabLaptopAndNotebook = By.linkText("Laptops & Notebooks");
    By laptopAndNotebookText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By tabComponents = By.linkText("Components");
    By componentsText = By.xpath("//h2[contains(text(),'Components')]");

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(selectMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(selectMenu);
        }
    }

    public void hoverAndClickOnDesktop(){
        mouseHoverToElementAndClick(tabDesktop);
        }
    public String getDesktopText(){
        return getTextFromElement(desktopText);
    }
    public void hoverAndClickOnLaptopAndNotebook(){
        mouseHoverToElementAndClick(tabLaptopAndNotebook);
    }
    public String getLaptopAndNotebookText(){
        return getTextFromElement(laptopAndNotebookText);
    }
    public void hoverAndClickOnComponents(){
        mouseHoverToElementAndClick(tabComponents);
    }
    public String getComponentsText(){
        return getTextFromElement(componentsText);
    }
}
