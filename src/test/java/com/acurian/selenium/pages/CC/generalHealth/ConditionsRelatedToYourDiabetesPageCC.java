package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.shared.StatinMedicationsOnPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ConditionsRelatedToYourDiabetesPageCC extends MainPageCC{

    public final String titleExpected = "Do you have any of the following conditions related to your diabetes?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='subquestion']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public ConditionsRelatedToYourDiabetesPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ConditionsRelatedToYourDiabetesPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ConditionsRelatedToYourDiabetesPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
