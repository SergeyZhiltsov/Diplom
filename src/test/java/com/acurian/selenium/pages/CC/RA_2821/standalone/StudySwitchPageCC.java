package com.acurian.selenium.pages.CC.RA_2821.standalone;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class StudySwitchPageCC extends MainPageCC {
    public final String titleExpected = "No text to be read to caller, click next to study switch";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    public StudySwitchPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public StudySwitchPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
