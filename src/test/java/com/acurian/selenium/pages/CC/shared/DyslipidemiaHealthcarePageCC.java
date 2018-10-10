package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DyslipidemiaHealthcarePageCC extends MainPageCC {

    public final String titleExpected = "Has a healthcare professional ever told you that you have any of the following?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public DyslipidemiaHealthcarePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DyslipidemiaHealthcarePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
//        waitForAnimation();
//        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public DyslipidemiaHealthcarePageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
//        List<String> answerTextListj = Arrays.asList(answerText);
//        checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
//                .forEach(el -> el.click());
//        waitForAnimation();
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
