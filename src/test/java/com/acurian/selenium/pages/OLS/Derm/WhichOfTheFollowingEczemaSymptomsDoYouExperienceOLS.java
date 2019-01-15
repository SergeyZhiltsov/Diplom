package com.acurian.selenium.pages.OLS.Derm;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhichOfTheFollowingEczemaSymptomsDoYouExperienceOLS extends MainPageOLS {
    private final String titleExpected = "Which of the following eczema symptoms do you experience?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    private WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonList;

    public WhichOfTheFollowingEczemaSymptomsDoYouExperienceOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichOfTheFollowingEczemaSymptomsDoYouExperienceOLS waitForPageLoad() {
        waitForAnimation();
        waitForImagesToLoad();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhichOfTheFollowingEczemaSymptomsDoYouExperienceOLS clickOnAnswers(String answerText) {
        getActions().moveToElement(radioButtonList.stream().filter(el -> el.getText().contains(answerText))
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
