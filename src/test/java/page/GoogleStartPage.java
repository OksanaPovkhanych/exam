package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleStartPage extends BasePage {

    @FindBy( xpath = "//input[@name='q']")
    private WebElement searchField;

    public GoogleStartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementIsClickable(searchField);
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("Google")
                && driver.getCurrentUrl().contains("https://www.google.com/")
                && (searchField.isDisplayed());
    }

    public GoogleSearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new GoogleSearchPage(driver);
    }

}
