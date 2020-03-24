package com.acurian.selenium.pages.OLS.FLARE;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class MostImportantChoiceOLS extends MainPageOLS {

    public final String titleExpected = "Most important choice will be. Select \"A\" and You IN_FLARE.\n" +
            "Select \"B\" or \"C\" and You get NON_FLARE";

    @FindBy(xpath = "//div[contains(@class, 'question_text')]//div[contains(@class, 'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST2_OLS)
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
