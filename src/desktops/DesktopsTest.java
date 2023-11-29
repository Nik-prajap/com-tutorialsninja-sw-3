package desktops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setupBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        selectMenu("Show AllDesktops");

        WebElement dropDown = findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText(" Default ");
        selectByVisibleTextFromDropDown(By.className("input-group-addon"), "Name (Z - A)");
        select.selectByValue("https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC");

        List<WebElement> productNames = findElementsList(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-9 div.row:nth-child(7) div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12:nth-child(1) div.product-thumb div:nth-child(2) div.caption h4:nth-child(1) > a:nth-child(1)"));
        List<String> originalList = new ArrayList<>();
        for (WebElement productName : productNames) {
            originalList.add(productName.getText());
        }
        List<String> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList, Collections.reverseOrder());
        Assert.assertEquals(originalList, sortedList);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() {

        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        selectMenu("Show AllDesktops");
        WebElement dropDown = findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText(" Default ");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        select.selectByValue("https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=ASC");
        mouseHoverAndClick(By.xpath("//a[contains(text(),'HP LP3065')]"));
        Assert.assertEquals("Matched", "HP LP3065", getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']")));
        WebElement dateTextField = findElement(By.cssSelector("#input-option225"));
        dateTextField.click();
        dateTextField.sendKeys(Keys.CONTROL, "a");
        dateTextField.sendKeys(Keys.DELETE);
        dateTextField.sendKeys("2023-11-27");
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Assert.assertEquals("Success: You have added HP LP3065 to your shopping cart!", getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Assert.assertEquals("Shopping Cart  (1.00kg)", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")));
        Assert.assertEquals("HP LP3065", getTextFromElement(By.linkText("HP LP3065")));
        Assert.assertEquals("Delivery Date:2022-11-30", getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']")));
        Assert.assertEquals("Product 21", getTextFromElement(By.xpath("//td[normalize-space()='Product 21']")));
        Assert.assertEquals("$122.00", getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")));

    }

    public void tearDown() {
        closeBrowser();
    }
}
