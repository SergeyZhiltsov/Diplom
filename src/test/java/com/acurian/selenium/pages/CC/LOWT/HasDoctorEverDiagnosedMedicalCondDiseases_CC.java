package com.acurian.selenium.pages.CC.LOWT;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class HasDoctorEverDiagnosedMedicalCondDiseases_CC extends MainPageCC{

    public final String titleExpected = "Has a doctor ever diagnosed you with any of the following medical conditions or diseases? \n" +
    		"Agent note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public HasDoctorEverDiagnosedMedicalCondDiseases_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasDoctorEverDiagnosedMedicalCondDiseases_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HasDoctorEverDiagnosedMedicalCondDiseases_CC clickOnAnswers(String ...answerText) {
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
