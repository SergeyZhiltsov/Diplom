package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class FutureJointReplacementSurgery extends MainPageOLS{

    public final String titleExpected = "People who suffer from arthritis sometimes need a joint replacement.\n" +
    		"Have you discussed a future joint replacement surgery with your doctor?\n" +
    		"Please do not consider any joint replacement surgeries that you may have had in the past.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS1327_')]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> radioButtonsList;

    public FutureJointReplacementSurgery() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FutureJointReplacementSurgery waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FutureJointReplacementSurgery clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
