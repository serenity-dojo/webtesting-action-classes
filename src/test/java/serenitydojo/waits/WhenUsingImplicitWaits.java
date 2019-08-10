package serenitydojo.waits;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenUsingImplicitWaits {

    @Managed
    WebDriver driver;

    APageWithWaits pageWithWaits;

    @Before
    public void setImplicitWaits() {
        pageWithWaits.open();
    }

    @Test
    public void with_elements_that_are_already_present() {
        pageWithWaits.alwaysVisibleButton.click();

        assertThat(pageWithWaits.alwaysVisibleButton.isCurrentlyVisible()).isTrue();
    }

    @Test
    public void with_elements_that_appear_after_a_short_delay() {
        pageWithWaits.soonVisibleButton.click();

        assertThat(pageWithWaits.soonVisibleButton.isCurrentlyVisible()).isTrue();
    }

    @Test
    public void with_elements_that_appear_after_a_longer_delay() {
        pageWithWaits.useTheEventuallyVisibleButton();

        assertThat(pageWithWaits.eventuallyVisibleButton.isCurrentlyVisible()).isTrue();
    }

    @DefaultUrl("classpath:site/index.html")
    public static class APageWithWaits extends PageObject {
        @FindBy(id = "visible-button")
        public WebElementFacade alwaysVisibleButton;

        @FindBy(id = "soon-visible-button")
        public WebElementFacade soonVisibleButton;

        @FindBy(id = "eventually-visible-button")
        public WebElementFacade eventuallyVisibleButton;

        public void useTheEventuallyVisibleButton() {
            $("#eventually-visible-button").click();
        }

        @FindBy(id = "invisible-button")
        public WebElementFacade invisibleButton;
    }
}
