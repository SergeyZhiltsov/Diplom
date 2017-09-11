package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SelectActionPageCC extends BasePage{

    @FindBy(id = "text_study_lookup")
    WebElement studyNameInput;

    @FindBy(id = "text_phone_lookup")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@value='begin']")
    WebElement beginButton;

    @FindBy(xpath = "//ul[contains(@class,'ui-autocomplete')]/li/a[contains(@class,'ui-corner-all')]")
    List<WebElement> popUpListStudy;

    @FindBy(xpath = "//ul[contains(@class,'ui-autocomplete')]")
    WebElement popUpBlockStudy;

    @FindBy(xpath = "//ul[contains(@class,'ui-autocomplete')][2]/li/a[contains(@class,'ui-corner-all')]")
    List<WebElement> popUpListPhone;

    @FindBy(xpath = "//ul[contains(@class,'ui-autocomplete')][2]")
    WebElement popUpBlockPhone;


    public SelectActionPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SelectActionPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(beginButton);
        return this;
    }

    @Step
    public SelectActionPageCC typeStudyName(String studyName) {
        typeTextWithoutClear(studyNameInput, studyName);
        return this;
    }

    @Step
    public SelectActionPageCC typePhoneNumber(String phoneNumber) {
        typeTextWithoutClear(phoneNumberInput, phoneNumber);
        return this;
    }

    @Step
    public SelectActionPageCC clickPopupStudy(String studyName) {
        driverWait.waitforVisibility(popUpBlockStudy);
        popUpListStudy.stream().filter(el -> el.getText().contains(studyName))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public SelectActionPageCC clickPopupPhoneNumber(String phoneNumber) {
        driverWait.waitforVisibility(popUpBlockPhone);
        popUpListPhone.stream().filter(el -> el.getText().contains(phoneNumber))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public CallCenterIntroductionPageCC clickBeginButton() {
        beginButton.click();
        return new CallCenterIntroductionPageCC();
    }

}
