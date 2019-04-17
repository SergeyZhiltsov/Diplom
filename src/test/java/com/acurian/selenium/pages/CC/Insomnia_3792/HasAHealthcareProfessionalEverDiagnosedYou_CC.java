package com.acurian.selenium.pages.CC.Insomnia_3792;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class HasAHealthcareProfessionalEverDiagnosedYou_CC extends MainPageCC{

    public final String titleExpected = "Has a healthcare professional ever diagnosed you with any of the following sleep related conditions?\n"+
            "Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc'] ")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public HasAHealthcareProfessionalEverDiagnosedYou_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasAHealthcareProfessionalEverDiagnosedYou_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HasAHealthcareProfessionalEverDiagnosedYou_CC clickOnAnswers(String ...answerText) {
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
