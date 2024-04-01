package stepDefinitions.PlaceOrder;

import contextManager.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPageObjects.CartPage;
import pageObjects.HomePageObjects.HomePage;

public class PlaceOrderSteps {
    TestContext testContext;
    HomePage homePage;
    CartPage cartPage;
    public PlaceOrderSteps(){
        this.testContext = new TestContext();
        homePage = testContext.getPageManager().getHomePage();
        cartPage = testContext.getPageManager().getCartPage();
    }
    @Given("User access into home page")
    public void User_access_into_home_page(){
        homePage.goToURL();
        homePage.logIn();
    }
    @When("User completes the purchase process")
    public void User_completes_the_purchase_process() throws InterruptedException {
        homePage.putItemsIntoCart();
        cartPage.placeOrderProcess();
    }
    @Then("User validates success purchase")
    public void User_validates_success_purchase() throws InterruptedException {
        cartPage.validateSuccessOrder();
        cartPage.closeDriver();
    }
    @When("User tries to complete purchase process without information")
    public void User_tries_to_complete_purchase_process_without_information() throws InterruptedException {
        homePage.putItemsIntoCart();
        cartPage.placeOrderWithoutInformation();
    }
    @Then("User validates is not possible place order without information")
    public void User_validates_is_not_possible_place_order_without_information() throws InterruptedException {
        cartPage.validateOrderWithoutInformation();
        cartPage.closeDriver();
    }
}
