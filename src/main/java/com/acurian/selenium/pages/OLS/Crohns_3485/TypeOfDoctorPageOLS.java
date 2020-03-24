package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TypeOfDoctorPageOLS extends MainPageOLS{

    public final String titleExpected = "You noted that you were diagnosed with Crohn’s disease. To be clear, again Crohn’s is inflammation of the digestive system. The disease can affect any area from the mouth to the anus. It often affects the lower part of the small intestine called the ileum with symptoms such as strong abdominal cramps, bloody diarrhea, fever, unusual gas and even weight loss which may come and go.\n" +
            "\n" +
            "What type of doctor(s) do you see to help manage your Crohn’s disease?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public TypeOfDoctorPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TypeOfDoctorPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TypeOfDoctorPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
