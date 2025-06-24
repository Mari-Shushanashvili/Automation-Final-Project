package steps;

import hooks.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import java.time.Duration;

public class CartSteps extends BaseTest {

    private ProductsPage productsPage;
    private CartPage cartPage;

    @Given("The user is logged in")
    public void the_user_is_logged_in() {
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);
    }

    @Given("The user is logged in and has a product in the cart")
    public void the_user_is_logged_in_and_has_a_product_in_the_cart() {
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();
        productsPage.goToCart();
    }

    @When("The user adds a product to the cart")
    public void the_user_adds_a_product_to_the_cart() {
        productsPage.addBackpackToCart();
    }

    @When("The user navigates to the cart page")
    public void the_user_navigates_to_the_cart_page() {
        productsPage.goToCart();
    }

    @When("The user removes the product from the cart")
    public void the_user_removes_the_product_from_the_cart() {
        cartPage = new CartPage(driver);
        cartPage.removeProduct();
    }

    @Then("The product should be visible in the cart")
    public void the_product_should_be_visible_in_the_cart() {
        cartPage = new CartPage(driver);
        String expectedItemName = "Sauce Labs Backpack";
        String actualItemName = cartPage.getInventoryItemName();
        Assert.assertEquals(actualItemName, expectedItemName, "The correct product was not in the cart.");
    }

    @When("The user logs out")
    public void the_user_logs_out() {
        productsPage.openMenu();
        productsPage.clickLogout();
    }

    @Then("The user should be returned to the login page")
    public void the_user_should_be_returned_to_the_login_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "User was not on the login page after logout.");
    }

    @Then("The cart should be empty")
    public void the_cart_should_be_empty() {
        Assert.assertEquals(cartPage.getNumberOfItemsInCart(), 0, "The cart was not empty after removing an item.");
    }
}