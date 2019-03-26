package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.GoogleStartPage;

public class BaseTest {
    private WebDriver driver;
    public GoogleStartPage googleStartPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        googleStartPage = new GoogleStartPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
