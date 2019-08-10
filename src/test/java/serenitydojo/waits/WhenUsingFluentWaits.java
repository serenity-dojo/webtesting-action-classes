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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenUsingFluentWaits {

    @Managed
    WebDriver driver;

    APageWithWaits pageWithWaits;

    @Before
    public void setImplicitWaits() {
        pageWithWaits.open();
    }

    @Test
    public void with_an_element_that_is_initially_disabled() {
        pageWithWaits.initiallyDisabledButton.click();
        assertThat(pageWithWaits.initiallyDisabledButton.getText()).isEqualTo("Clicked!");
    }

    @Test
    public void with_an_element_that_is_eventually_enabled() {
        pageWithWaits.waitAndClick();
        assertThat(pageWithWaits.buttonThatIsEnabledLater.getText()).isEqualTo("Clicked!");
    }

    @Test
    public void with_an_element_that_becomes_visible() {
        pageWithWaits.waitUntilVisibleButton().click();
        assertThat(pageWithWaits.waitUntilVisibleButton().getText()).isEqualTo("Clicked!");
    }

    @Test
    public void waitingForVisibleText() {
        pageWithWaits.waitForVisibleTextToAppear();
        assertThat(pageWithWaits.textbox.getText()).isEqualTo("Visible text");
    }


    @Test
    public void waitingForVisibleTextExpectedCondition() {
        pageWithWaits.waitForCondition()
                .until(
                        ExpectedConditions.numberOfElementsToBe(
                                By.cssSelector("#elements option"), 4
                        )
                );
        assertThat(pageWithWaits.displayedElements()).contains("Earth","Air","Fire","Water");
    }

    @DefaultUrl("classpath:site/index.html")
    public static class APageWithWaits extends PageObject {

        @FindBy(id = "buttonThatIsInitiallyDisabled")
        public WebElementFacade initiallyDisabledButton;

        @FindBy(id = "buttonThatIsEnabledLater")
        public WebElementFacade buttonThatIsEnabledLater;

        @FindBy(id = "soon-invisible-button")
        public WebElementFacade soonInvisible;

        @FindBy(id = "textBox")
        public WebElementFacade textbox;

        public void waitAndClick() {
            buttonThatIsEnabledLater.withTimeoutOf(Duration.ofSeconds(10)).click();
        }

        public WebElementFacade waitUntilVisibleButton() {
            return withTimeoutOf(Duration.ofSeconds(10))
                    .find(By.id("eventually-visible-button"));
        }

        public List<String> displayedElements() {
            return findAll("#elements option")
                    .stream()
                    .map(WebElementFacade::getText)
                    .collect(Collectors.toList());
        }

        public void waitForVisibleTextToAppear() {
            waitForCondition().until(
                    ExpectedConditions.textToBePresentInElement(textbox, "Visible text")
            );
        }
    }
}
