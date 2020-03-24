package com.acurian.selenium.pages.OLS.FLARE;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DigestiveConditionsPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ChooseTheMatterYouAreHereOLS extends MainPageOLS {

    public final String titleExpected = "Choose the matter you are here, Your opinion is free. Q with options A or B, DQ with option C !!!";
    public final String titleExpectedQA = "Choose the matter you are here, Your opinion is free:  Q if options A or B, DQ with option C !!!";

    @FindBy(xpath = "//div[contains(@class, 'question_text')]//div[contains(@class, 'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST2_OLS)
    List<WebElement> checkBoxList;

    public ChooseTheMatterYouAreHereOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ChooseTheMatterYouAreHereOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ChooseTheMatterYouAreHereOLS waitForPageLoadQA() {
        waitForPageLoadMain(titleText, titleExpectedQA);
        return this;
    }

    @Step
    public ChooseTheMatterYouAreHereOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
