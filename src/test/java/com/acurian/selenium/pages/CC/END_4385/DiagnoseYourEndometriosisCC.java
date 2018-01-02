package com.acurian.selenium.pages.CC.END_4385;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class DiagnoseYourEndometriosisCC extends MainPageCC{

    public final String titleExpected = "Did your doctor perform any of the following procedures to help diagnose your endometriosis? \r\n" + 
    		"Please do not report any procedures you may have had to treat your endometriosis.\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public DiagnoseYourEndometriosisCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnoseYourEndometriosisCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnoseYourEndometriosisCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
