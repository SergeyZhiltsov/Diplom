package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DrugOrAlcoholAbuse extends MainPageOLS {

    public final String titleExpected = "Do you have a history of drug or alcohol abuse?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    @FindBy(xpath = "//label[contains(@for,'QS22_')]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    @Step
    public DrugOrAlcoholAbuse waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DrugOrAlcoholAbuse clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
