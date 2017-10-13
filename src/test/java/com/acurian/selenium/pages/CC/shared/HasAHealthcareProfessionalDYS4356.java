package com.acurian.selenium.pages.CC.shared;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;


import ru.yandex.qatools.allure.annotations.Step;

public class HasAHealthcareProfessionalDYS4356 extends MainPageCC {

    public final String titleExpected = "Has a healthcare professional ever told you that you have any of the following?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public HasAHealthcareProfessionalDYS4356() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public  HasAHealthcareProfessionalDYS4356 waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public  HasAHealthcareProfessionalDYS4356 clickOnAnswers(String ...answerText) {
        List<String> answerTextList = Arrays.asList(answerText);
        checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
                .forEach(el -> el.click());
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
