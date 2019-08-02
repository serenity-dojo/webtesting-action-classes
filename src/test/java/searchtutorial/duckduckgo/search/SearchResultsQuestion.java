package searchtutorial.duckduckgo.search;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsQuestion extends UIInteractionSteps {
    public List<String> displayed() {
        return findAll(DuckDuckGoResultPage.RESULT_TITLE)
                .stream()
                .map(WebElementFacade::getTextContent)
                .collect(Collectors.toList());
    }
}
