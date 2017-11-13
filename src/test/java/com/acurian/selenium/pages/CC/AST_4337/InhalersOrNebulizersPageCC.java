package com.acurian.selenium.pages.CC.AST_4337;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.Crohns_3485.FollowingMedicalConditionsPageCC;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class InhalersOrNebulizersPageCC extends MainPageCC{

    public final String titleExpected = "Do you currently use any of the following inhalers or nebulizers to manage your asthma?\n" +
            "These are prescribed to be taken on a daily basis, whether or not you're having symptoms.\n" +
            "Agent Note: Read medications in the following way: \"Advair Diskus or Advair HFA, also known as fluticasone and salmeterol\" etc. Select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public InhalersOrNebulizersPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InhalersOrNebulizersPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public InhalersOrNebulizersPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
