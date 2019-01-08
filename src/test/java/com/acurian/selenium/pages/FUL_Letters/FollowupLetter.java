package com.acurian.selenium.pages.FUL_Letters;

import com.acurian.selenium.pages.BasePage;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class FollowupLetter extends BasePage {
    private final String gmailServiceURL = "https://mail.google.com/";
    private WebDriver driver = getDriver();
    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;
    private Calendar date = Calendar.getInstance();
    private String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    @FindBy(id = "identifierId")
    private WebElement emailField;

    @FindBy(id = "identifierNext")
    private WebElement emailNextButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextButton;

    @FindBy(css = "input[aria-label='Search mail']")
    private WebElement emailSearchBox;

    @FindBy(xpath = "//h3[contains(@style, 'margin')]/..")
    private WebElement emailContent;

    public FollowupLetter() {
        PageFactory.initElements(getDriver(), this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        fluentWait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.MINUTES)
                .pollingEvery(30, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    String emailContentExpectedENG = monthNames[date.get(Calendar.MONTH)] + " " + date.get(Calendar.DATE) + ", " + date.get(Calendar.YEAR) + "\n" +
            "Acurian Trial\n" +
            "\n" +
            "Dover, DE 19901\n" +
            "Dear Acurian,\n" +
            "Thank you for your recent interest in participating in one of our Rheumatoid Arthritis, Diabetes, Low Back Pain, Arthritis clinical research studies.\n" +
            "We have forwarded your information to the study doctor’s office that you selected. If the study doctor’s office has not already contacted you, they should be contacting you within the next few days to further discuss the study and to set up an in-person evaluation.\n" +
            "If you are not contacted within the next 5 business days, please contact them directly.\n" +
            "The study doctor’s office that you selected is:\n" +
            "Dr. OriFName OriLName, MD\n" +
            "AUT_GRA1_Site\n" +
            "11 Walnut Grove Dr\n" +
            "Dover, DE 19901\n" +
            "(123) 456-7899\n" +
            "Clinical research studies greatly contribute to the overall progress in understanding and finding future treatments for diseases and we appreciate your interest in participation.\n" +
            "The AcurianHealth Team";

    @Step
    public FollowupLetter assertgmailFUL(String pid) {
        By emailLocator = new By.ByXPath("//div//span//span[contains(text(),'" + pid + "')]");
        WebElement emailTitle = null;
        driver.navigate().to(gmailServiceURL);
        emailField.sendKeys("qa.acurian@gmail.com");
        emailNextButton.click();
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys("automation");
        passwordNextButton.click();
        emailSearchBox.sendKeys(pid);
        emailSearchBox.sendKeys(Keys.ENTER);
        System.out.println("Waiting for email...");
        try{
            emailTitle = fluentWait.until(webDriver -> webDriver.findElement(emailLocator));
            emailTitle.click();
        }
        catch(WebDriverException e) {
            Assert.fail("Email wasn't received");
        }
        System.out.println("Recieved email: " + emailTitle.getText());
        Assert.assertEquals(emailContent.getText(), emailContentExpectedENG, "Email content is diff");
        return this;
    }
}
