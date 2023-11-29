package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setupBrowser(){
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> topMenuNames = findElementsList(By.cssSelector("#top-links a"));
        for (WebElement names : topMenuNames) {
            //System.out.println(names.getText());
            if (names.getText().equalsIgnoreCase(option)) {
                names.click();
                break;
            }
        }

    }

    @Test
    public void verifyUserShouldNavigateToRegisterPAgeSuccessfully() {

        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        selectMyAccountOptions("Register");
        Assert.assertEquals("Register Account", "//h1[normalize-space()='Register Account']");

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        selectMyAccountOptions("Login");
        Assert.assertEquals("Returning Customer", getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']")));
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {

        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        selectMyAccountOptions("Register");
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Prime");
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Testing");
        sendTextToElement(By.xpath("//input[@id='input-email']"), "primetesting987@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "07912341234");
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Testing789");
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "Testing789");
        clickOnElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']"));
        clickOnElement(By.xpath("//input[@name='agree']"));
        clickOnElement(By.xpath("//input[@value='Continue']"));
        Assert.assertEquals("Your Account Has Been Created!", getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")));
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));
        selectMyAccountOptions("Logout");
        Assert.assertEquals("Account Logout", getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']")));
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){

        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        selectMyAccountOptions("Login");
        sendTextToElement(By.xpath("//input[@id='input-email']"), "primetesting987@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-password']']"), "Testing789");
        clickOnElement(By.xpath("//input[@value='Login']"));
        Assert.assertEquals("My Account", getTextFromElement(By.xpath("//h2[normalize-space()='My Account']")));
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        selectMyAccountOptions("Logout");
        Assert.assertEquals("Account Logout", getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']")));
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
