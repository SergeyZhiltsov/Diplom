package com.acurian.selenium.pages.CC.shared.DIA;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class CurrentlyUseMetforminOrInsulinPage extends MainPageCC{

    public final String titleExpected = "Do you currently use metformin or insulin or any other medication prescribed by your doctor to treat your diabetes?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public CurrentlyUseMetforminOrInsulinPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentlyUseMetforminOrInsulinPage waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CurrentlyUseMetforminOrInsulinPage clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
