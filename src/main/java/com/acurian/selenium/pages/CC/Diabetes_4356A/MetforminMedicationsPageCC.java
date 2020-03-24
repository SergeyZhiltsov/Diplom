package com.acurian.selenium.pages.CC.Diabetes_4356A;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class MetforminMedicationsPageCC extends MainPageCC{

    public final String titleExpected = "Do you currently take any of the following oral (taken by mouth) metformin medications?\n" +
            "Metformin is a common medication prescribed to control blood sugar or treat type 2 diabetes.\n" +
            "Agent Note: Can be read to patients if needed: \"I will be happy to stay on hold while you retrieve your pill bottles.\" Read medications in the following way: \"Actoplus Met, also known as metformin and pioglitazone\" etc. Select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public MetforminMedicationsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public MetforminMedicationsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public MetforminMedicationsPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
