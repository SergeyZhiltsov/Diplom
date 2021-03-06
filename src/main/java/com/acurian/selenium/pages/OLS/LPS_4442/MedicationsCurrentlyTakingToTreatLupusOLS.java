package com.acurian.selenium.pages.OLS.LPS_4442;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class MedicationsCurrentlyTakingToTreatLupusOLS extends MainPageOLS{

    public final String titleExpected = "Which of the following medications are you currently taking to treat your lupus?";
            

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public MedicationsCurrentlyTakingToTreatLupusOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public MedicationsCurrentlyTakingToTreatLupusOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public MedicationsCurrentlyTakingToTreatLupusOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
