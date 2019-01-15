package com.acurian.selenium.pages.OLS.Derm;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class EczemaSymptomsExperienceOLS extends MainPageOLS {
    private final String titleExpected = "Which of the following eczema symptoms do you experience?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    private WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST2_OLS)
    List<WebElement> checkBoxList;

    public EczemaSymptomsExperienceOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public EczemaSymptomsExperienceOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EczemaSymptomsExperienceOLS clickOnAnswers(String ...answerText) {
        List<String> answers = Arrays.asList(answerText);
        checkBoxList.stream().filter(element -> answers.contains(element.getText()))
                .forEach(element -> getActions().moveToElement(element).click().build().perform());
//        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
