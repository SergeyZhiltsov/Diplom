package com.acurian.selenium.pages.CC.DYS_4356C;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class StatinMedicationsHavePageCC extends MainPageCC{

    public final String titleExpected = "One of the most common kinds of medicines to manage high cholesterol, triglycerides, or lipids is called a statin. Most people with these conditions are prescribed this kind of medicine. Statins are prescribed under many different names.\n" +
            "\n" +
            "Which of the following statin medications have you ever taken on a daily basis?\n" +
            "For each medication, please indicate if you are taking it now (currently), have taken it in the past (but stopped taking it), or if you have never taken it.\n" +
            "If you are not sure of the names of your medications, please first get your medication bottles or packages to confirm.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='subquestion']/span[@class='sub_question_text']")
    List<WebElement> subQuestions;

    public StatinMedicationsHavePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public StatinMedicationsHavePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public StatinMedicationsHavePageCC clickOnAnswerForSubQuestion(String questionText, String answerText) {
        List<WebElement> checkBoxListFromTitle = subQuestions.stream().filter(el -> questionText.contains(el.getText()))
                .findFirst()
                .get()
                .findElements(By.xpath("ancestor::div[@class='subquestion']/div[@class='radio_btns_container']//label"));
        clickOnRadioButton(checkBoxListFromTitle, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
