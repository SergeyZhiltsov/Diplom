package com.acurian.selenium.pages.OLS.Derm;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OverThePastWeekHowManyDaysHasSkinBeenItchyOLS extends MainPageOLS {
    private final String titleExpected = "Over the past week, how many days has your skin been itchy?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    private WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonList;

    public OverThePastWeekHowManyDaysHasSkinBeenItchyOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OverThePastWeekHowManyDaysHasSkinBeenItchyOLS waitForPageLoad() {
        waitForAnimation();
        waitForImagesToLoad();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public OverThePastWeekHowManyDaysHasSkinBeenItchyOLS clickOnAnswer(String answerText) {
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
