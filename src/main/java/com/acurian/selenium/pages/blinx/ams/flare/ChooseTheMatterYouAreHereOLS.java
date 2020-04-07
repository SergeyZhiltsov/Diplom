package com.acurian.selenium.pages.blinx.ams.flare;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

//TODO переписать ибо просто скопировано
public class ChooseTheMatterYouAreHereOLS  extends MainPageBlinx {

    public final String titleExpected = "Choose the matter you are here, Your opinion is free. Q with options A or B, DQ with option C !!!";
    public final String titleExpectedQA = "Choose the matter you are here, Your opinion is free:  Q if options A or B, DQ with option C !!!";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
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
        waitForAnimation();
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
