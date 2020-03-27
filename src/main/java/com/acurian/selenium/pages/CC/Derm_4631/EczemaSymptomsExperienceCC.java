package com.acurian.selenium.pages.CC.Derm_4631;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EczemaSymptomsExperienceCC extends MainPageCC {

    public final String titleExpected = "Which of the following additional eczema symptoms do you experience?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//div")
    List<WebElement> checkBoxList;

    public EczemaSymptomsExperienceCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public EczemaSymptomsExperienceCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public EczemaSymptomsExperienceCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
