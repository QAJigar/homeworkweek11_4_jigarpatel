package testsuite;
/**
 * Created by Jigar Patel
 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Locale;

public class testsuite extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";
    @Before
            public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    //1. userShouldLoginSuccessfullyWithValid Credentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //* Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //* Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //* Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        //* Verify the text “PRODUCTS”
        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.className("title")).getText().toUpperCase(Locale.ROOT);
        Assert.assertEquals("Text match", expectedText,actualText);
    }
    @Test
    //2. verifyThatSixProductsAreDisplayedOnPage
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //* Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //* Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //* Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        //* Verify that six products are displayed on page
        String expectedProduct= driver.findElement(By.className("inventory_list")).getText();
        String actualProduct= driver.findElement(By.className("inventory_list")).getText();
        Assert.assertEquals("Product Found", expectedProduct,actualProduct);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
