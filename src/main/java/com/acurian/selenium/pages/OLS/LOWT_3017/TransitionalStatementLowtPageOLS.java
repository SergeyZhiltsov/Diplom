package com.acurian.selenium.pages.OLS.LOWT_3017;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class TransitionalStatementLowtPageOLS extends MainPageOLS {

    public final String titleExpected = "Thank you for answering these initial questions.\n" +
            "We would like to ask you a few more questions about your health to better match you with a research study in your area.\n" +
            "You may be asked similar information in this next set of questions. We appreciate your patience.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;


    @Step
    public TransitionalStatementLowtPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
