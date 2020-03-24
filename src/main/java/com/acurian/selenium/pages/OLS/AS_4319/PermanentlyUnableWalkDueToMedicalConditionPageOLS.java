package com.acurian.selenium.pages.OLS.AS_4319;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class PermanentlyUnableWalkDueToMedicalConditionPageOLS extends MainPageOLS {

    public final String titleExpectedOLD = "Are you permanently wheelchair-bound, bedridden, or otherwise completely unable to walk due to your back pain or another medical condition?";
    
    public final String titleExpected = "Are you permanently unable to walk due to your medical condition?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public PermanentlyUnableWalkDueToMedicalConditionPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PermanentlyUnableWalkDueToMedicalConditionPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }   
    

    @Step
    public PermanentlyUnableWalkDueToMedicalConditionPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
