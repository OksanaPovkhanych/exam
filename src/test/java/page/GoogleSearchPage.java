package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage extends BasePage{
    @FindBy( xpath = "//div[@id='resultStats']")
    private WebElement searchResultTotal;

    @FindBy ( xpath = "//div[@class='srg']/div")
    private List<WebElement> searchResultElements;

    @FindBy( xpath = "//a[@aria-label='Page 2']")
    private WebElement linkToSecondSearchPage;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementIsClickable(searchResultTotal);
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("Selenium - Пошук Google")
                && (searchResultTotal.isDisplayed());
    }

    public List<String> getSearchResultsList() {
        List<String> searchResultStringList = new ArrayList<String>();
        for (WebElement searchResultElement: searchResultElements) {
            searchResultStringList.add(searchResultElement.getText());
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResultElement);
        }
        return searchResultStringList;
    }

    public int getSearchResultsCount() {
        return searchResultElements.size();
    }


    public GoogleSearchPage goToSecondSearchPage() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", linkToSecondSearchPage);
        linkToSecondSearchPage.click();
        return new GoogleSearchPage(driver);
    }

}
