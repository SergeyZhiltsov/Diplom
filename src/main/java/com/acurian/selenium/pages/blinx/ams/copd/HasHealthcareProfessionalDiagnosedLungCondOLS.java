package com.acurian.selenium.pages.blinx.ams.copd;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HasHealthcareProfessionalDiagnosedLungCondOLS extends MainPageBlinx {

    public final String titleExpected = "COPD, or chronic obstructive pulmonary disease, is a common lung condition that makes it difficult to breathe. It is mainly caused by smoking. There are two forms of COPD:\n" +
            "• Chronic bronchitis, in which the lining of your airways becomes inflamed, causing a long-term cough with mucus or phlegm, and\n" +
            "• Emphysema, in which the air sacs in your lungs become damaged, causing shortness of breath.\n" +
            "Most people suffer from both forms, and symptoms often develop slowly over time.\n" +
            "Has a healthcare professional ever diagnosed you with any of these lung conditions?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    public HasHealthcareProfessionalDiagnosedLungCondOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasHealthcareProfessionalDiagnosedLungCondOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasHealthcareProfessionalDiagnosedLungCondOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
