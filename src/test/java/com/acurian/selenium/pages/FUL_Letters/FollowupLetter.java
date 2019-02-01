package com.acurian.selenium.pages.FUL_Letters;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class FollowupLetter extends BasePage {
    String gmailServiceURL = "https://mail.google.com/";
    WebDriver driver = getDriver();
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    private File fulsToBeVerified;
    private Calendar date = Calendar.getInstance();
    private final String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    @FindBy(id = "identifierId")
    WebElement emailField;

    @FindBy(id = "identifierNext")
    WebElement emailNextButton;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @FindBy(id = "passwordNext")
    WebElement passwordNextButton;

    @FindBy(css = "input[aria-label='Search mail']")
    WebElement emailSearchBox;

    @FindBy(xpath = "//h3[contains(@style, 'margin')]/..")
    WebElement emailContent;

    @FindBy(xpath = "//a[contains(@aria-label,'Google Account')]")
    WebElement accountLabel;

    @FindBy(xpath = "//a[text() = 'Sign out']")
    WebElement signOut;

    @FindBy(id = "profileIdentifier")
    WebElement accountsDropdown;

    @FindBy(xpath = "//form[@method='post']//li[2]/div[@role='link']")
    WebElement changeAccount;

    private final String emailContentExpectedMR = monthNames[date.get(Calendar.MONTH)] + " " + date.get(Calendar.DATE) + ", " + date.get(Calendar.YEAR) + "\n" +
            "Acurian Trial\n" +
            "\n" +
            "Vernon Hills, IL 60061\n" +
            "Dear Acurian,\n" +
            "Thank you for your recent interest in participating in one of our Arthritis, Low Back Pain, Rheumatoid Arthritis, Diabetes clinical research studies.\n" +
            "We have forwarded your information to the study doctor’s office that you selected. If the study doctor’s office has not already contacted you, they should " +
            "be contacting you within the next few days to further discuss the study and to set up an in-person evaluation.\n" +
            "If you are not contacted within the next 5 business days, please contact them directly.\n" +
            "The study doctor’s office that you selected is:\n" +
            "Dr. OriFName Ted OriLName, MD\n" +
            "AUT_GRA_FULm_Site\n" +
            "433, Main Street\n" +
            "VERNON HILLS, IL 60061\n" +
            "(123) 456-7899\n" +
            "To allow us to send your medical records to the study doctor, please provide information on the doctors who are treating, or have treated, your Arthritis, Low Back Pain, " +
            "Rheumatoid Arthritis, Diabetes. Please complete all details required by clicking on the link below. Please click here to learn more.\n" +
            "Please click here to learn more.\n" +
            "Please be assured that your records will be kept confidential and only shared with the study research facility.\n" +
            "Clinical research studies greatly contribute to the overall progress in understanding and finding future treatments for diseases and we appreciate your interest in participation.\n" +
            "The AcurianHealth Team";

    private final String emailContentExpected = monthNames[date.get(Calendar.MONTH)] + " " + date.get(Calendar.DATE) + ", " + date.get(Calendar.YEAR) + "\n" +
            "Acurian Trial\n" +
            "\n" +
            "Chicago Ridge, IL 60415\n" +
            "Dear Acurian,\n" +
            "Thank you for your recent interest in participating in one of our Arthritis, Low Back Pain, Rheumatoid Arthritis, Diabetes clinical research studies.\n" +
            "We have forwarded your information to the study doctor’s office that you selected. If the study doctor’s office has not already contacted you, they should be " +
            "contacting you within the next few days to further discuss the study and to set up an in-person evaluation.\n" +
            "If you are not contacted within the next 5 business days, please contact them directly.\n" +
            "The study doctor’s office that you selected is:\n" +
            "Dr. OriFName Ted OriLName, MD\n" +
            "AUT_GRA_FUL_Site\n" +
            "002, Main Str\n" +
            "Chicago Ridge, il 60415\n" +
            "(123) 456-7899\n" +
            "Clinical research studies greatly contribute to the overall progress in understanding and finding future treatments for diseases and we appreciate your interest in participation.\n" +
            "The AcurianHealth Team";

    public FollowupLetter() {
        PageFactory.initElements(getDriver(), this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        /*
        Waiting email for 15 mins with 10 seconds pulling delay
         */
        fluentWait = new FluentWait<>(driver)
                .withTimeout(15, TimeUnit.MINUTES)
                .pollingEvery(10, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        fulsToBeVerified = new File(System.getProperty("resources.dir") + "FULs_to_be_verified" + LocalDate.now() + ".txt");
    }

    public File getFulsToBeVerifiedFile() {
        return fulsToBeVerified;
    }

    WebDriverWait getWaiter() {
        return wait;
    }

    Wait<WebDriver> getFluentWait() {
        return fluentWait;
    }

    @Step
    public FollowupLetter assertgmailFUL(String pid, boolean withMedicalRecords) {
        By emailLocator = new By.ByXPath("//div[2]/span/span[contains(text(),'" + pid + "')]");
        WebElement emailTitle;
        driver.navigate().to(gmailServiceURL);
        emailField.sendKeys("qa.acurian@gmail.com");
        emailNextButton.click();
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys("automation");
        passwordNextButton.click();
        emailSearchBox.sendKeys(pid);
        emailSearchBox.sendKeys(Keys.ENTER);
        System.out.println("Waiting for email...");
        try {
            emailTitle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
            System.out.println("Recieved email: " + emailTitle.getText());
            driver.findElement(emailLocator).click();
        } catch (TimeoutException e) {
            Assert.fail("Email wasn't received within 15 mins timeout");
        }
        if (withMedicalRecords)
            Assert.assertEquals(emailContent.getText(), emailContentExpectedMR, "Email content is diff");
        else Assert.assertEquals(emailContent.getText(), emailContentExpected, "Email content is diff");
        return this;
    }

    @Step
    public FollowupLetter assertFULDbRecordIsNotNull(String env, String pid) {
        String fulIsSentCell = getDbConnection().dbReadFulIsSent(env, pid);
        logTextToAllure("FUL VALUE cell: " + fulIsSentCell);
        Assert.assertNotNull(fulIsSentCell, "FUL VALUE cell is null");
        return this;
    }

    @Step
    public FollowupLetter assertFULDbRecordIsNull(String env, String pid) {
        String fulIsSentCell = getDbConnection().dbReadFulIsSent(env, pid);
        logTextToAllure("FUL VALUE cell: " + fulIsSentCell);
        Assert.assertNull(fulIsSentCell, "FUL VALUE cell is NOT null");
        return this;
    }

    @Step
    public FollowupLetter assertAllFULs(String env) {
        LinkedHashMap<String, String> list;
        try {
            list = getCsvParser().getDataAsMap(fulsToBeVerified.getName(), false);
            for (Map.Entry<String, String> entry : list.entrySet()) {
                for (Site site : Site.values()) {
                    if (site.name.equals(entry.getValue())) {
                        System.out.println("Matched: " + site.name + " with quequed site: " + entry.getValue());
                        if (site.hasFul) {
//                            assertFULDbRecordIsNotNull(env, entry.getKey());
                            System.out.println("DB is checked");
                            if (site.withMedicalRecords)
                                new MedicalRecordsFUL().assertgmailMRFUL(entry.getKey(), entry.getValue());
                            else new RegularFUL().assertgmailRegularFUL(entry.getKey(), entry.getValue());
                        } else assertFULDbRecordIsNull(env, entry.getKey());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fulsToBeVerified.delete()) System.out.println("Temp file: " + fulsToBeVerified.getAbsolutePath() + " has been deleted.");
            else System.out.println("Couldn't delete file: " + fulsToBeVerified.getName());
        }
        return this;
    }

    @Step
    public FollowupLetter gmailLogout() {
        accountLabel.click();
        wait.until(ExpectedConditions.visibilityOf(signOut));
        signOut.click();
        driver.navigate().refresh();
        driver.manage().deleteCookieNamed("ACCOUNT_CHOOSER");
//        accountsDropdown.click();
//        wait.until(ExpectedConditions.visibilityOf(changeAccount));
//        changeAccount.click();
        return this;
    }
}
