package com.acurian.selenium.pages.blinx.ams.dia;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BrandsOfInsulinPageOLS extends MainPageBlinx {

    public final String titleExpected = "Which of the following types or brands of insulin do you currently take?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    public BrandsOfInsulinPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public BrandsOfInsulinPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public BrandsOfInsulinPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
