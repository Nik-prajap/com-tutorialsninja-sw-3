package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setupBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        mouseHoverAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));
        selectMenu("Show AllLaptops & Notebooks");
        WebElement dropDown = findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText(" Default ");
        selectByVisibleTextFromDropDown(By.className("form-control"), "Price (High > Low)");
        select.selectByValue("https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        List<WebElement> element1 = findElementsList(By.xpath("//p[@class= 'price']"));
        for (WebElement result : element1) {
            System.out.println(result.getText());

        }
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {

        mouseHoverAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));
        selectMenu("Show AllLaptops & Notebooks");
        WebElement dropDown = findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Default");
        selectByVisibleTextFromDropDown(By.className("form-control"), "Price (High > Low)");
        select.selectByValue("https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        findElement(By.xpath("//a[normalize-space()='MacBook']")).click();
        Assert.assertEquals("MacBook", getTextFromElement(By.xpath("//h1[normalize-space()='MacBook']")));
        findElement(By.xpath("//button[@id='button-cart']")).click();
        Assert.assertEquals("Success: You have added MacBook to your shopping cart!" + "×", getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();
        Assert.assertEquals("Shopping Cart  (0.00kg)", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")));
        Assert.assertEquals("MacBook" + "Reward Points: 600", getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")));
        findElement(By.xpath("//input[@class='form-control']")).clear();
        sendTextToElement(By.xpath("//input[@class='form-control']"), "2");
        findElement(By.xpath("//i[@class='fa fa-refresh']")).click();
        Assert.assertEquals("Success: You have modified your shopping cart!" + "×", getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        Assert.assertEquals("$1,204.00", getTextFromElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")));
        findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Assert.assertEquals("Checkout", getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']")));
        Assert.assertEquals("New Customer", getTextFromElement(By.id("//h2[normalize-space()='New Customer']")));
        findElement(By.xpath("//input[@value='guest']")).click();
        findElement(By.xpath("//input[@id='button-account']")).click();
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Pinks");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Shah");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "Prim123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "0776859453");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "St Johns Parade");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "Sidcup");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "DA1 4ED");
        WebElement dropDown3 = findElement(By.xpath("//select[@id='input-payment-zone']"));
        Select select3 = new Select(dropDown3);
        select3.selectByVisibleText("Buckinghamshire");
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Please leave order at neighbours");
        clickOnElement(By.xpath("//input[@id='button-shipping-method']"));
        clickOnElement(By.xpath("//input[@id='button-shipping-method']"));
        Assert.assertEquals(" Warning: Payment method required! ", getTextFromElement(By.xpath("//div[contains(text(), 'Warning: Payment method required!')]")));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
