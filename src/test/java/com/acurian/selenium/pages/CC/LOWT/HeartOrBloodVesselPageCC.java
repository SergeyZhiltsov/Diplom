package com.acurian.selenium.pages.CC.LOWT;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HeartOrBloodVesselPageCC extends MainPageCC {

    public final String titleExpected = "Have you experienced any of the following heart or blood vessel related events? \n" +
            "Agent note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public HeartOrBloodVesselPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HeartOrBloodVesselPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HeartOrBloodVesselPageCC clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
