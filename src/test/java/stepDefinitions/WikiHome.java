package stepDefinitions;

import Pages.WikiHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WikiHome {
    WebDriver driver = _Hooks.driver;
    WebDriverWait wait = _Hooks.wait;
    WikiHomePage wikiHomePage = new WikiHomePage(driver,wait);

    @Given("^I open browser to launch URL \"([^\"]*)\"$")
    public void launchURL(String url) {
        wikiHomePage.launchURL(url);
    }

    @Then("^I verify that page is displayed in the selected language \"([^\"]*)\" with \"([^\"]*)\"$")
    public void verifyLanguageDisplayed(String language, String PageTitle) throws InterruptedException {
        wikiHomePage.verifyPageTitleWithLanguage(language, PageTitle);
    }

    @Given("^I enter and select the language \"([^\"]*)\"$")
    public void enterAndSelectLanguage(String language) throws InterruptedException {
        wikiHomePage.enterAndSelectLanguage(language);
    }
    @Given("^I enter and select the celebrity \"([^\"]*)\"$")
    public void enterAndSelectCelebrity(String CelebrityName) {
        wikiHomePage.enterAndSelectCelebrity(CelebrityName);
    }
    @Given("^I log the date of birth and spouse details for \"([^\"]*)\"$")
    public void getDateOfBirthAndSpouseDetails(String CelebrityName) throws InterruptedException {
        wikiHomePage.getDateOfBirthAndSpouseDetails(CelebrityName);
    }

}
