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

        GoogleSearchPage googleFirstSearchPage = googleStartPage.search(searchTerm);
        Assert.assertTrue(googleFirstSearchPage.isPageLoaded(), "First page of results didn't load.");
        Assert.assertEquals(googleFirstSearchPage.getSearchResultsCount(), 9, "Search results count of the first page is wrong.");
        List<String> searchResultsOfFirstPageList = googleFirstSearchPage.getSearchResultsList();
        for (String searchResult: searchResultsOfFirstPageList) {
            Assert.assertTrue(searchResult.contains(searchTerm), "Search term " + searchTerm + " not found in:\n" +searchResult);
        }

        GoogleSearchPage googleSecondSearchPage  = googleFirstSearchPage.goToSecondSearchPage();
        Assert.assertTrue(googleSecondSearchPage.isPageLoaded(), "Second page of results didn't load.");
        Assert.assertEquals(googleSecondSearchPage.getSearchResultsCount(), 10, "Search results count of the second page is wrong.");
        List<String> searchResultsOfSecondPageList = googleSecondSearchPage.getSearchResultsList();
        for (String searchResult: searchResultsOfSecondPageList) {
            Assert.assertTrue(searchResult.contains(searchTerm), "Search term " + searchTerm + " not found in:\n" +searchResult);
        }
    }

    @Test
    public void GoogleCaseNotSensitiveSearchTests() {
        String searchTerm = "Selenium";
        Assert.assertTrue(googleStartPage.isPageLoaded(), "Google start page didn't load.");

        GoogleSearchPage googleFirstSearchPage = googleStartPage.search(searchTerm);
        Assert.assertTrue(googleFirstSearchPage.isPageLoaded(), "First page of results didn't load.");
        Assert.assertEquals(googleFirstSearchPage.getSearchResultsCount(), 9, "Search results count of the first page is wrong.");
        List<String> searchResultsOfFirstPageList = googleFirstSearchPage.getSearchResultsList();
        for (String searchResult: searchResultsOfFirstPageList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "Search term " + searchTerm + " not found in:\n" +searchResult);
        }

        GoogleSearchPage googleSecondSearchPage  = googleFirstSearchPage.goToSecondSearchPage();
        Assert.assertTrue(googleSecondSearchPage.isPageLoaded(), "Second page of results didn't load.");
        Assert.assertEquals(googleSecondSearchPage.getSearchResultsCount(), 10, "Search results count of the second page is wrong.");
        List<String> searchResultsOfSecondPageList = googleSecondSearchPage.getSearchResultsList();
        for (String searchResult: searchResultsOfSecondPageList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "Search term " + searchTerm + " not found in:\n" +searchResult);
        }
    }
}
