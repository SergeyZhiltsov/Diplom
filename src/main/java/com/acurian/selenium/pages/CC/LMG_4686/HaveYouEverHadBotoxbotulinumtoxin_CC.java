package com.acurian.selenium.pages.CC.LMG_4686;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouEverHadBotoxbotulinumtoxin_CC extends MainPageCC{

    public final String titleExpected ="Have you ever had a Botox (botulinum toxin) injection to your face, head, or neck?\n" +
    		"Agent Note: Select all that apply"; 
    
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public HaveYouEverHadBotoxbotulinumtoxin_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverHadBotoxbotulinumtoxin_CC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverHadBotoxbotulinumtoxin_CC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
