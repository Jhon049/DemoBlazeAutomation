package stepDefinitions.SignUp;

import contextManager.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObjects.HomePage;

public class SignUpSteps {
    TestContext testContext;
    HomePage homePage;
    public SignUpSteps(TestContext testContext){
        this.testContext = testContext;
        homePage = testContext.getPageManager().getHomePage();
    }
    public SignUpSteps(){
        this.testContext = new TestContext();
        this.homePage = testContext.getPageManager().getHomePage();
    }
    @Given("User is in home page")
    public void User_is_in_home_page(){
        homePage.goToURL();
    }
    @When("User makes registration")
    public void User_makes_registration(){
        homePage.signUp();
    }
    @Then("User successfully sign up")
    public void User_successfully_sign_up(){
        homePage.validateSignUp();
    }
    @When("User tries to make a registration with an existing name user")
    public void User_tries_to_make_a_registration_with_an_existing_name_user(){
        homePage.signUpWithExistingUser();
    }
    @Then("System indicates that the user exists")
    public void System_indicates_that_the_user_exists(){
        homePage.validateSignUpWithExistingUSer();
    }
}
