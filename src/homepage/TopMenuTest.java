package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setupBrowser() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        selectMenu("Show AllDesktops");
        Assert.assertEquals("Desktops", getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']")));

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNoteBooksPageSuccessfully() {

        mouseHoverAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));
        selectMenu("Show AllLaptops & Notebooks");
        Assert.assertEquals("Laptops & Notebooks", getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']")));

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        mouseHoverAndClick(By.xpath("//a[normalize-space()='Components']"));
        selectMenu("Show AllComponents");
        Assert.assertEquals("Components", getTextFromElement(By.xpath("//h2[normalize-space()='Components']")));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
