package stepDefinitions.LogIn;

import contextManager.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObjects.HomePage;
public class LogInSteps {
    TestContext testContext;
    HomePage homePage;
    public LogInSteps(TestContext testContext){
        this.testContext = testContext;
        homePage = testContext.getPageManager().getHomePage();
    }
    public LogInSteps(){
        this.testContext = new TestContext();
        this.homePage = testContext.getPageManager().getHomePage();
    }
    @When("User login in system")
    public void User_login_in_system(){
        homePage.logIn();
    }
    @Then("User verifies that is logged into system")
    public void User_verifies_that_is_logged_into_system(){
        homePage.verifyLogIn();
    }
    @When("User tries to make LogIn with No Existing User")
    public void User_tries_to_make_LogIn_with_No_Existing_User(){
        homePage.logInWithNoExistingUser();
    }
    @Then("User verifies that not exist in system")
    public void User_verifies_that_not_exist_in_system(){
        homePage.validateLogInWithNoExistingUSer();
    }
}
