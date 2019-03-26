package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import java.util.List;

public class GoogleSearchTests extends BaseTest {
    @Test
    public void GoogleCaseSensitiveSearchTests() {
        String searchTerm = "Selenium";
        Assert.assertTrue(googleStartPage.isPageLoaded(), "Google start page didn't load.");

        GoogleSearchResultsPage googleFirstSearchResultsPage = googleStartPage.search(searchTerm);
        Assert.assertTrue(googleFirstSearchResultsPage.isPageLoaded(), "First page of results didn't load.");
        Assert.assertEquals(googleFirstSearchResultsPage.getSearchResultsCount(), 9, "Search results count of the first page is wrong.");
        List<String> searchResultsOfFirstPageList = googleFirstSearchResultsPage.getSearchResultsList();
        for (String searchResult: searchResultsOfFirstPageList) {
            Assert.assertTrue(searchResult.contains(searchTerm), "Search term " + searchTerm + " not found in:\n" +searchResult);
        }

        GoogleSearchResultsPage googleSecondSearchResultsPage  = googleFirstSearchResultsPage.goToSecondSearchPage();
        Assert.assertTrue(googleSecondSearchResultsPage.isPageLoaded(), "Second page of results didn't load.");
        Assert.assertEquals(googleSecondSearchResultsPage.getSearchResultsCount(), 10, "Search results count of the second page is wrong.");
        List<String> searchResultsOfSecondPageList = googleSecondSearchResultsPage.getSearchResultsList();
        for (String searchResult: searchResultsOfSecondPageList) {
            Assert.assertTrue(searchResult.contains(searchTerm), "Search term " + searchTerm + " not found in:\n" +searchResult);
        }
    }

    @Test
    public void GoogleCaseNotSensitiveSearchTests() {
        String searchTerm = "Selenium";
        Assert.assertTrue(googleStartPage.isPageLoaded(), "Google start page didn't load.");

        GoogleSearchResultsPage googleFirstSearchResultsPage = googleStartPage.search(searchTerm);
        Assert.assertTrue(googleFirstSearchResultsPage.isPageLoaded(), "First page of results didn't load.");
        Assert.assertEquals(googleFirstSearchResultsPage.getSearchResultsCount(), 9, "Search results count of the first page is wrong.");
        List<String> searchResultsOfFirstPageList = googleFirstSearchResultsPage.getSearchResultsList();
        for (String searchResult: searchResultsOfFirstPageList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "Search term " + searchTerm + " not found in:\n" +searchResult);
        }

        GoogleSearchResultsPage googleSecondSearchResultsPage  = googleFirstSearchResultsPage.goToSecondSearchPage();
        Assert.assertTrue(googleSecondSearchResultsPage.isPageLoaded(), "Second page of results didn't load.");
        Assert.assertEquals(googleSecondSearchResultsPage.getSearchResultsCount(), 10, "Search results count of the second page is wrong.");
        List<String> searchResultsOfSecondPageList = googleSecondSearchResultsPage.getSearchResultsList();
        for (String searchResult: searchResultsOfSecondPageList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "Search term " + searchTerm + " not found in:\n" +searchResult);
        }
    }
}
