package com.acurian.selenium.pages.CC.LPS_4442;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.AST_4337.CurrentlyTakingPillPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class MedicationsCurrentlyTakingToTreatLupusCC extends MainPageCC{

    public final String titleExpected = "Which of the following medications are you currently taking to treat your lupus?\n" +            
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public MedicationsCurrentlyTakingToTreatLupusCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public MedicationsCurrentlyTakingToTreatLupusCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public MedicationsCurrentlyTakingToTreatLupusCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
