package com.acurian.selenium.pages.OLS.Derm;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EczemaSymptomsExperienceOLS extends MainPageOLS {
    private final String titleExpected = "Which of the following eczema symptoms do you experience?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    private WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> checkboxList;

    public EczemaSymptomsExperienceOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public EczemaSymptomsExperienceOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EczemaSymptomsExperienceOLS clickOnAnswers(String answerText) {
        getActions().moveToElement(checkboxList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get())
                .click()
                .build()
                .perform();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
