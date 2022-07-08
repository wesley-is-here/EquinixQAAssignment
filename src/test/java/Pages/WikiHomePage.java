package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WikiHomePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public WikiHomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void launchURL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void enterAndSelectLanguage(String language) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mw-interlanguage-selector"))).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".languagefilter"))).sendKeys(language);
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'autonym') and text() = '"+ language +"'] "))).click();
        Thread.sleep(500);
    }

    public void verifyPageTitleWithLanguage(String language, String ActualPageTitle) throws InterruptedException {
        Thread.sleep(500);
        String expectedPageTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle, ActualPageTitle);
        System.out.println("Page is displayed in the selected language " + language + " with page Title as- " + ActualPageTitle + " ");
    }

    public void enterAndSelectCelebrity(String CelebrityName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput"))).sendKeys(CelebrityName);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='" + CelebrityName + "']"))).click();
    }
    public void getDateOfBirthAndSpouseDetails(String CelebrityName) throws InterruptedException {
        Thread.sleep(500);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //Waiting to display the Date of Birth Details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Born']")));
        //Fetching the Date of Birth using JavascriptExecutor as the element is hidden in UI. (style="display:none")
        String DateOfBirth= (String) jsExecutor.executeScript("return document.getElementsByClassName('bday')[0].innerText");
        //Waiting to display the Spouse Details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Spouse')]")));
        //Getting spouseDetails from the WIKI page
        String spouseDetails=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Spouse')]//ancestor::tr//td[@class='infobox-data']"))).getText();
        System.out.println(CelebrityName+":  Date of Birth -"+DateOfBirth +"\nSpouse Details - "+spouseDetails);
    }


}
