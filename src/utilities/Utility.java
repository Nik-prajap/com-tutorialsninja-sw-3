package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Utility extends BaseTest {

    public void selectMenu(String menu) {
        WebElement menu1 = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu1).click().perform();

    }

    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement desktopsTab = driver.findElement(by);
        actions.moveToElement(desktopsTab).click().perform();
    }

    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {

        WebElement dropDown = driver.findElement(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    public List<WebElement> findElementsList(By by) {
        return driver.findElements(by);
    }

}
