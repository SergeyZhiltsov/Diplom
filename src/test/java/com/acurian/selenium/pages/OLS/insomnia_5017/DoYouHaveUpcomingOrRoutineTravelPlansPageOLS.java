package com.acurian.selenium.pages.OLS.insomnia_5017;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoYouHaveUpcomingOrRoutineTravelPlansPageOLS extends MainPageOLS {

    public final String titleExpected = "Travel across multiple time zones can affect your sleep patterns or sleep quality.\n" +
            "Do you have upcoming or routine travel plans that cross three or more time zones?\n" +
            "This could include travel for work or vacation.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public DoYouHaveUpcomingOrRoutineTravelPlansPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouHaveUpcomingOrRoutineTravelPlansPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouHaveUpcomingOrRoutineTravelPlansPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
