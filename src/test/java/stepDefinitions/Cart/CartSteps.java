package stepDefinitions.Cart;

import contextManager.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPageObjects.CartPage;
import pageObjects.HomePageObjects.HomePage;

public class CartSteps {
    TestContext testContext;
    HomePage homePage;
    CartPage cartPage;
    public CartSteps(){
        this.testContext = new TestContext();
        homePage = testContext.getPageManager().getHomePage();
        cartPage = testContext.getPageManager().getCartPage();
    }
    @Given("An Existing User access to home page")
    public void An_Existing_User_access_to_home_page(){
        homePage.goToURL();
        homePage.logIn();
    }
    @When("User puts items into the cart")
    public void User_puts_items_into_the_cart() throws InterruptedException {
        homePage.putItemsIntoCart();
    }
    @Then("User validates cart is not empty")
    public void User_validates_cart_is_not_empty() throws InterruptedException {
        cartPage.validateCartIsNotEmpty();
    }
    @Then("User deletes and validates the item is not longer into cart")
    public void User_deletes_and_validates_the_item_is_not_longer_into_cart() throws InterruptedException {
        cartPage.deleteACartItem();
        cartPage.validateItemIsDeleted();
    }
}
