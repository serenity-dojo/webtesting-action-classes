package searchtutorial.duckduckgo.search;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import static searchtutorial.duckduckgo.search.DuckDuckGoSearchPage.SEARCH_BUTTON;
import static searchtutorial.duckduckgo.search.DuckDuckGoSearchPage.SEARCH_INPUT_FIELD;

public class SearchActions extends UIInteractionSteps {
    @Step("Search by keyword {0}")
    public void byKeyword(String keyword) {
        $(SEARCH_INPUT_FIELD).sendKeys(keyword);
        $(SEARCH_BUTTON).click();
    }
}
