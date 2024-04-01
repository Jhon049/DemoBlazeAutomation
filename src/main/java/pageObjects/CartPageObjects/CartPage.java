package pageObjects.CartPageObjects;

import com.github.javafaker.Faker;
import comun.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePageObjects.HomePage;

import java.util.prefs.BackingStoreException;

public class CartPage {
    private static WebDriver driver;
    public CartPage(WebDriver driver){
        CartPage.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logger logger = LoggerFactory.getLogger(HomePage.class);
    Faker faker = new Faker();
    static SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath = "//*[@id='navbarExample']/ul/li[4]/a")
    private static WebElement cartTab;
    @FindBy(id = "totalp")
    private static WebElement totalCart;
    @FindBy(xpath = "//*[contains(text(),'Delete')]")
    private static WebElement deleteBttn;
    @FindBy(xpath = "//*[@id='page-wrapper']/div/div[2]/button")
    private static WebElement placeOrderBttn;
    @FindBy(id = "name")
    private static WebElement nameField;
    @FindBy(id = "country")
    private static WebElement countryField;
    @FindBy(id = "city")
    private static WebElement cityField;
    @FindBy(id = "card")
    private static WebElement cardField;
    @FindBy(id = "month")
    private static WebElement monthField;
    @FindBy(id = "year")
    private static WebElement yearField;
    @FindBy(xpath = "//*[@id='orderModal']/div/div/div[3]/button[2]")
    private static WebElement purchaseBttn;
    @FindBy(xpath = "/html/body/div[10]/h2")
    private static WebElement purchaseLabel;
    public static void goToCart(){
        BaseClass.waitForVisibility(cartTab, 10, driver);
        cartTab.click();
    }
    public void validateCartIsNotEmpty() throws InterruptedException {
        goToCart();
        Thread.sleep(500);
        BaseClass.waitForVisibility(totalCart, 10, driver);
        softAssert.assertNotEquals(totalCart.getText(), "0");
        Thread.sleep(500);
        deleteACartItem();
        driver.quit();
    }
    public void deleteACartItem() throws InterruptedException {
        goToCart();
        Thread.sleep(500);
        BaseClass.waitForVisibility(deleteBttn, 10, driver);
        softAssert.assertTrue(BaseClass.isAnElementPresentInTheDOM("//*[contains(text(),'Delete')]", driver));
        deleteBttn.click();
        Thread.sleep(500);
    }
    public void validateItemIsDeleted() throws InterruptedException {
        goToCart();
        Thread.sleep(500);
        softAssert.assertFalse(BaseClass.isAnElementPresentInTheDOM("//*[contains(text(),'Delete')]", driver));
        softAssert.assertAll();
        driver.quit();
    }
    public void closeDriver(){
        driver.quit();
    }
    public void placeOrderProcess() throws InterruptedException {
        goToCart();
        Thread.sleep(800);
        placeOrderBttn.click();
        Thread.sleep(500);
        nameField.sendKeys(faker.name().name());
        countryField.sendKeys(faker.address().country());
        cityField.sendKeys(faker.address().city());
        cardField.sendKeys(faker.finance().creditCard());
        monthField.sendKeys("October");
        yearField.sendKeys("2024");
        purchaseBttn.click();
    }
    public void validateSuccessOrder() throws InterruptedException {
        Thread.sleep(500);
        BaseClass.waitForVisibility(purchaseLabel, 10, driver);
        Assert.assertEquals(purchaseLabel.getText(), "Thank you for your purchase!");
    }
    public void placeOrderWithoutInformation() throws InterruptedException {
        goToCart();
        Thread.sleep(800);
        placeOrderBttn.click();
        Thread.sleep(500);
        purchaseBttn.click();
    }
    public void validateOrderWithoutInformation(){
        BaseClass.waitForAlertPresent(10, driver);
        Assert.assertEquals(driver.switchTo().alert().getText(), "Please fill out Name and Creditcard.");
    }
}
