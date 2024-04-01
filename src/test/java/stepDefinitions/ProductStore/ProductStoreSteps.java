package stepDefinitions.ProductStore;

import contextManager.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPageObjects.CartPage;
import pageObjects.HomePageObjects.HomePage;

public class ProductStoreSteps {
    TestContext testContext;
    HomePage homePage;
    CartPage cartPage;

    public ProductStoreSteps(){
        this.testContext = new TestContext();
        homePage = testContext.getPageManager().getHomePage();
        cartPage = testContext.getPageManager().getCartPage();
    }
    @Given("Existing user is in home Page")
    public void Existing_user_is_in_home_Page(){
        homePage.goToURL();
        homePage.logIn();
    }
    @When("The User selects A product In Phones tab")
    public void The_User_selects_A_product_In_Phones_tab() throws InterruptedException {
        homePage.selectPhone();
    }
    @Then("User validates that phone is in cart")
    public void User_validates_that_phone_is_in_cart() throws InterruptedException {
        homePage.validateProductIsInCart();
        cartPage.deleteACartItem();
        cartPage.closeDriver();
    }
    @When("The User selects a product in laptops tab")
    public void The_User_selects_a_product_in_laptops_tab() throws InterruptedException {
        homePage.selectLaptop();
    }
    @Then("User validates laptop is in cart")
    public void User_validates_laptop_is_in_cart() throws InterruptedException {
        homePage.validateProductIsInCart();
        cartPage.deleteACartItem();
        cartPage.closeDriver();
    }
}