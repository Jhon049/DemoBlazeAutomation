package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.CartPageObjects.CartPage;
import pageObjects.HomePageObjects.HomePage;

public class PageManager {
    private WebDriver driver;
    private HomePage homePage;
    private CartPage cartPage;

    public PageManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
    public CartPage getCartPage() {
        return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
    }
}
