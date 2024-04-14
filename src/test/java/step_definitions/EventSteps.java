package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.EventPage;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EventSteps {

    private final WebDriver driver = Hooks.driver;
    EventPage eventPage = new EventPage(driver);

    @Given("User is already in tiket.com website")
    public void userIsAlreadyInTiketCom() {
        eventPage.verifyHome();
    }

    @When("User click Event button")
    public void userClickEventButton() {
        eventPage.clickEventButton();
    }

    @Then("User redirected to Event product page")
    public void userRedirectedToEventProductPage() {
        eventPage.verifyEventPage();
    }

    @Given("User is already in event ticket page")
    public void userIsAlreadyInEventTicketPage() {
        eventPage.clickEventButton();
        eventPage.verifyEventPage();
    }

    @When("User filter event by {string}")
    public void userFilterEventBy(String filter) {
        eventPage.clickFilterButton(filter);
    }

    @Then("User should see {string} on event ticket page")
    public void userShouldSeeOnEventTicketPage(String expectedTicket) throws InterruptedException {
        Thread.sleep(2000);
        String actualTicketText = eventPage.getTicketResult(expectedTicket);
        Assert.assertThat(actualTicketText, CoreMatchers.containsString(expectedTicket));
    }

    @When("User sort event by {string}")
    public void userSortEventBy(String sortBy) throws InterruptedException {
        eventPage.selectSortBy(sortBy);
    }
}
