package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * userSholdLoginSuccessfullyWithValid
 * Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed
 * on pag
 */
public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {                   //Open browser
        openBrowser(this.baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {                  //Login test
        sendTextToElement(By.id("user-name"), "standard_user");     //Enter username
        sendTextToElement(By.id("password"), "secret_sauce");       //Enter password
        clickOnElement(By.id("login-button"));                           //Click on login button
        Assert.assertEquals("PRODUCTS", getTextFromElement(By.xpath("//span[text()='Products']")).toUpperCase());                                                                         //Compare 2 strings
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {             //Six products display test
        sendTextToElement(By.id("user-name"), "standard_user");     //Enter username
        sendTextToElement(By.id("password"), "secret_sauce");       //Enter password
        clickOnElement(By.id("login-button"));                           //Click on login button
        //Compare 2 values
        Assert.assertEquals("User cannot see 6 products.", 6, getMultipleElements(By.className("inventory_item")).size());
    }

    @After
    public void tearDown() {                //Close browser
        closeBrowser();

    }
}
