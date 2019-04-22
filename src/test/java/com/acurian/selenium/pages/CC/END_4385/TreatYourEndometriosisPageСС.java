package com.acurian.selenium.pages.CC.END_4385;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TreatYourEndometriosisPageСС extends MainPageCC{

    public final String titleExpected = "Confirmation of endometriosis can be made when a doctor sees endometriosis tissue during a procedure (\"direct visualization\"), or by taking a biopsy that confirmed endometriosis. Imaging alone, such as ultrasound, CT scan, or MRI, does not count as confirmation for this study.\n" +
            "\n" +
            "The study site will need to review your medical records from any procedures before you can participate.\n" +
            "\n" +
            "Have you ever had any of the following to diagnose or treat your endometriosis?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public TreatYourEndometriosisPageСС() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TreatYourEndometriosisPageСС waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TreatYourEndometriosisPageСС clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
