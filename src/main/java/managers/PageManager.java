package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObjects.HomePage;

public class PageManager {
    private WebDriver driver;
    private HomePage homePage;

    public PageManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
}
