package com.acurian.selenium.pages.CC.END_4385;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class LaparoscopyAndLaparotomyCC extends MainPageCC{

    public final String titleExpected = "Laparoscopy and laparotomy are the surgical procedures used to confirm a diagnosis of endometriosis.\n" +
    		"When was the surgical procedure which confirmed your endometriosis performed?";    

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public LaparoscopyAndLaparotomyCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LaparoscopyAndLaparotomyCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public LaparoscopyAndLaparotomyCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
