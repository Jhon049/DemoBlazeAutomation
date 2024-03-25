package pageObjects.HomePageObjects;

import com.github.javafaker.Faker;
import com.github.javafaker.Number;
import comun.BaseClass;
import managers.ReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage {
    private static WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logger logger = LoggerFactory.getLogger(HomePage.class);
    SoftAssert softAssert = new SoftAssert();
    Faker faker = new Faker();
    String NewUser = faker.harryPotter().character();
    String NoUser = faker.pokemon().name();
    String NewPassword = faker.random().toString();
    @FindBy(id = "signin2")
    private static WebElement signUpOption;
    @FindBy(id = "sign-username")
    private static WebElement userNameSignUp;
    @FindBy(id = "sign-password")
    private static WebElement userPasswordSignUp;
    @FindBy(xpath = "//*[@id='signInModal']/div/div/div[3]/button[2]")
    private static WebElement signUpBttn;
    @FindBy(id = "login2")
    private static WebElement logInOption;
    @FindBy(id = "loginusername")
    private static WebElement userNameLogIn;
    @FindBy(id = "loginpassword")
    private static WebElement userPasswordLogIn;
    @FindBy(xpath = "//*[@id='logInModal']/div/div/div[3]/button[2]")
    private static WebElement logInBttn;
    @FindBy(id = "nameofuser")
    private static WebElement userNameLabel;
    public void goToURL(){
        driver.get(ReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }
    public void signUp(){
        BaseClass.waitForVisibility(signUpOption, 10, driver);
        signUpOption.click();
        BaseClass.waitForVisibility(userNameSignUp, 10, driver);
        userNameSignUp.sendKeys(NewUser);
        userPasswordSignUp.sendKeys(NewPassword);
        signUpBttn.click();
    }
    public void validateSignUp(){
        BaseClass.waitForAlertPresent(10, driver);
        Assert.assertEquals(driver.switchTo().alert().getText(), "Sign up successful.");
        driver.quit();
    }
    public void signUpWithExistingUser(){
        BaseClass.waitForVisibility(signUpOption, 10, driver);
        signUpOption.click();
        BaseClass.waitForVisibility(userNameSignUp, 10, driver);
        userNameSignUp.sendKeys("Test");
        userPasswordSignUp.sendKeys(NewPassword);
        signUpBttn.click();
    }
    public void validateSignUpWithExistingUSer(){
        BaseClass.waitForAlertPresent(10, driver);
        Assert.assertEquals(driver.switchTo().alert().getText(), "This user already exist.");
        driver.quit();
    }
    public void logIn(){
        BaseClass.waitForVisibility(logInOption, 10, driver);
        logInOption.click();
        BaseClass.waitForVisibility(userNameLogIn, 10, driver);
        userNameLogIn.sendKeys("Test0324");
        userPasswordLogIn.sendKeys("Test0324");
        logInBttn.click();
    }
    public void verifyLogIn(){
        BaseClass.waitForVisibility(userNameLabel, 10, driver);
        Assert.assertEquals(userNameLabel.getText(), "Test0324");
        driver.quit();
    }
    public void logInWithNoExistingUser(){
        BaseClass.waitForVisibility(logInOption, 10, driver);
        logInOption.click();
        BaseClass.waitForVisibility(userNameLogIn, 10, driver);
        userNameLogIn.sendKeys(NoUser);
        userPasswordLogIn.sendKeys("1234");
        logInBttn.click();
    }
    public void validateLogInWithNoExistingUSer(){
        BaseClass.waitForAlertPresent(10, driver);
        Assert.assertEquals(driver.switchTo().alert().getText(), "User does not exist.");
        driver.quit();
    }
}
