package searchtutorial.duckduckgo.search;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://duckduckgo.com")
public class DuckDuckGoSearchPage extends PageObject {
    public static final String SEARCH_INPUT_FIELD = "#search_form_input_homepage";
    public static final String SEARCH_BUTTON = "#search_button_homepage";
}
