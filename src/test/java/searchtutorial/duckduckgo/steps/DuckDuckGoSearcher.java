package searchtutorial.duckduckgo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import searchtutorial.duckduckgo.navigate.NavigateActions;
import searchtutorial.duckduckgo.search.DuckDuckGoResultPage;
import searchtutorial.duckduckgo.search.SearchActions;
import searchtutorial.duckduckgo.search.SearchResultsQuestion;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;


public class DuckDuckGoSearcher {

    private String actor;

    @Steps
    NavigateActions navigate;

    @Steps
    SearchActions search;

    @Steps
    SearchResultsQuestion searchResults;

    @Step("#actor searches for things related to {0}")
    public void searches_by_keyword_for(String keyword) {
        search.byKeyword(keyword);
    }

    @Step("#actor should see only results containing the words {0}")
    public void should_see_only_results_containing(String expectedTerms) {
        List<String> results = searchResults.displayed();

        assertThat(results, everyItem(containsString(expectedTerms)));
    }

    @Step("#actor starts on the DuckDuckGo home page")
    public void is_on_the_duckduckgo_homepage() {
         navigate.toTheDuckDuckGoHomePage();
    }

}
