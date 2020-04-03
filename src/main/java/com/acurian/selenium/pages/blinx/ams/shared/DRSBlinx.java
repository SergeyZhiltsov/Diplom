package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DRSBlinx extends MainPageBlinx {

    public final String titleExpected = "The next step is to get you scheduled for an appointment with the study doctor's team. During this visit, the study doctor's team will further discuss the study requirements and answer any questions you may have.";

    public final String modalTitleExpected = "Your appointment has been successfully booked!";

    public final String thankYouTitleExpected = "Thank you";

    public final String titleExpectedClientDetailsMain = "Please confirm that the following details are correct before booking your appointment:";

    public final String titleExpected2 = "Client details";

    public final String titleExpectedUnf= "Unfortunately there are no available or convenient appointments at this site at the moment.";

    @FindBy(xpath = "//div[@class='col-12 p-0']/div[@class='row no-gutters translation']")
    WebElement titleText;

    @FindBy(xpath = "//*[@id='noAppointmentsSubmit']")
    WebElement unfNextBtn;

    @FindBy(xpath = "//*[@class='sb-widget-iframe']")
    WebElement frame;

    @FindBy(xpath = "/html//iframe[@id='siteSchedule']")
    WebElement frame2;

    @FindBy(xpath = "//iframe[@class='w-100']")
    WebElement frameBlinx;

    @FindBy(xpath = "//*[@id='confirmationPage']/div[1]/span")
    WebElement titleText2;

    @FindBy(xpath = "//*[@class='title-main']")
    WebElement titleTextClientDetailsMain;

    @FindBy(xpath = "(//div[contains(@class, 'cell-day')][not(contains(@class, 'disabled'))])[1]")
    WebElement dayBtn;

    @FindBy(xpath = "(//div[contains(@class, 'timeSlot-btn')]/div[not(contains(@class, 'unavailable'))])[1]")
    WebElement timeBtn;

    @FindBy(xpath = "//span[contains(@class, 'confirmationDate')]")
    WebElement date;

    @FindBy(xpath = "//span[contains(@class, 'confirmationTime')]")
    WebElement startAt;

    @FindBy(xpath = "(//span[contains(@class, 'confirmationAddress1')])[3]")
    WebElement serviceProvider;

    @FindBy(xpath = "(//*[contains(@class, 'custom-checkbox')])[1]")
    WebElement agreeBtn;

    @FindBy(xpath = "(//*[contains(@class, 'custom-checkbox')])[2]")
    WebElement sendSMS;

    @FindBy(xpath = "//*[@id='bookingSubmit']")
    WebElement nextBtn;

    @FindBy(xpath = "//*[@id='emailConfirmationInput']")
    WebElement email;

    @FindBy(xpath = "//*[@id='smsConfirmationInput']")
    WebElement phoneNumber;

    @FindBy(xpath = "//*[@id='confirmationSubmit']")
    WebElement bookBtn;

    @FindBy(xpath = "//*[@id='successModal']/div/div/div[1]/p")
    WebElement modalTitleText;

    @FindBy(xpath = "(//*[@id='successButton'])[1]")
    WebElement modalNextBtn;

    @FindBy(xpath = "//*[@id='endPage']/h4")
    WebElement thankYouTitle;

    @FindBy(xpath = "//*[@id='siteScheduler']/div[4]/button[2]")
    WebElement noAppTime;

    @FindBy(xpath = "//*[@id='noAppointmentsPage']/div[1]/div[2]")
    WebElement titleUnf;

    @FindBy(xpath = "//*[@id='noAppointmentsPage']/div[2]/button[2]")
    WebElement prevPage;

    @Step
    public DRSBlinx dateCheck() {
        logTextToAllureAndConsole(date.getText());
        return this;
    }

    @Step
    public DRSBlinx startsAtCheck() {
        logTextToAllureAndConsole(startAt.getText());
        return this;
    }

    @Step
    public DRSBlinx serviceProviderCheck() {
        logTextToAllureAndConsole(serviceProvider.getText());
        return this;
    }

    @Step
    public DRSBlinx waitForPageLoadClientDetails() {
        waitForPageLoadMain(titleText2, titleExpectedClientDetailsMain);
        return this;
    }

    @Step
    public DRSBlinx waitForPageLoad() {
        waitForAnimation();
        getDriver().switchTo().frame(frame);
        threadSleep(5);
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DRSBlinx waitForPageLoad2() {
        threadSleep(3);
        waitForAnimation();
        getDriver().switchTo().frame(frame2);
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DRSBlinx waitForPageLoadBlinxFrame() {
        waitForAnimation();
        getDriver().switchTo().frame(frameBlinx);
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DRSBlinx waitForPageLoadBlinx() {
            waitForAnimation();
            waitForPageLoadMain(titleText, titleExpected);
            return this;
    }

    @Step
    public DRSBlinx clickOnDay() {

        waitforVisibility(dayBtn);
        dayBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx clickOnTime() {

        waitforVisibility(timeBtn);
        timeBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx clickOnAgree() {

        waitforVisibility(agreeBtn);
        agreeBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx clickOnSendSMS() {

        waitforVisibility(sendSMS);
        sendSMS.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx assertClientData(String emailExpected, String phoneNumberExpected) {

        waitforVisibility(email);
        waitforVisibility(phoneNumber);
        Assert.assertEquals(email.getText(), emailExpected, "not expected email");
        Assert.assertEquals(phoneNumber.getText(), phoneNumberExpected, "not expected phone number");
        return this;
    }

    @Step
    public DRSBlinx clickOnNext() {

        waitforVisibility(nextBtn);
        nextBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx clickBook() {

        waitforVisibility(bookBtn);
        bookBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx waitForPageLoadSuccess() {
        waitForAnimation();
        waitForPageLoadMain(modalTitleText, modalTitleExpected);
        return this;
    }

    @Step
    public DRSBlinx clickOnBtnNext() {

        waitforVisibility(modalNextBtn);
        modalNextBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx waitForThankYou() {
        waitForAnimation();
        waitForPageLoadMain(thankYouTitle, thankYouTitleExpected);
        return this;
    }

    @Step
    public DRSBlinx waitForUnf() {
        waitForAnimation();
        waitForPageLoadMain(titleUnf, titleExpectedUnf);
        return this;
    }

    @Step
    public DRSBlinx clickOnBtnNoApp() {

        waitforVisibility(noAppTime);
        noAppTime.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx clickOnUnfNext() {

        waitforVisibility(unfNextBtn);
        unfNextBtn.click();
        waitForAnimation();
        return this;
    }

    @Step
    public DRSBlinx clickOnBtnPrev() {

        waitforVisibility(prevPage);
        prevPage.click();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
