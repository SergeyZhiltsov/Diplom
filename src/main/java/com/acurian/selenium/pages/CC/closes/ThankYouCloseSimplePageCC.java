package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouCloseSimplePageCC extends MainPageCC{

    //Thank You Close - AWR/SEN - 65_number

    public final String titleExpected = "Thank you again for contacting Acurian's Research Information Center. Goodbye.";

    public final String titleExpectedV2 = "Thank you again for contacting Acurian's Research Information Center.  Goodbye.";

    /**
     * Created on 26.11.2019 by Ivan Lipskyi
     */
    public final String titleExpected3 = "Thank you again for contacting Acurian's Research Information Center.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public ThankYouCloseSimplePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThankYouCloseSimplePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        attachPageScreenshot();
        return this;
    }

    @Step
    public ThankYouCloseSimplePageCC waitForPageLoadV2() {
        waitForPageLoadMain(titleText, titleExpectedV2);
        return this;
    }

    /**
     * created on 26.11.2019 by Ivan Lipskyi
     * @return
     */
    @Step
    public ThankYouCloseSimplePageCC waitForPageLoad3(){
        waitForPageLoadMain(titleText, titleExpected3);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
