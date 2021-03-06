package com.acurian.selenium.pages.CC.AS_4319;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class SignsOfAnkylosingSpondylitisCC extends MainPageCC {

    public final String titleExpected = "Have you ever had an x-ray or MRI of your back or pelvis, to look for signs of ankylosing spondylitis or AS?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public SignsOfAnkylosingSpondylitisCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SignsOfAnkylosingSpondylitisCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SignsOfAnkylosingSpondylitisCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
