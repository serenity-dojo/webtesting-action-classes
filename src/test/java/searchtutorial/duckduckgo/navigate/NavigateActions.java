package searchtutorial.duckduckgo.navigate;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import searchtutorial.duckduckgo.search.DuckDuckGoSearchPage;

public class NavigateActions extends UIInteractionSteps {

    DuckDuckGoSearchPage homePage;

    @Step("Navigate to the DuckDuckGo home page")
    public void toTheDuckDuckGoHomePage() {
        homePage.open();
    }
}
