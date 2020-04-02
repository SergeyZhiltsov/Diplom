package com.acurian.selenium.pages.blinx.ams.flare;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

//TODO переписать ибо просто скопировано
public class MostImportantChoiceOLS extends MainPageBlinx {

    public final String titleExpected = "Most important choice will be. Select \"A\" and You IN_FLARE.\n" +
            "Select \"B\" or \"C\" and You get NON_FLARE";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = "//div[@class='answer-text']")
    List<WebElement> checkBoxList;

    public MostImportantChoiceOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public MostImportantChoiceOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public MostImportantChoiceOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
