package com.acurian.selenium.pages.CC.AS_4319;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class DiagnosedWithAnkylosingSpondylitisPageCC extends MainPageCC {

    public final String titleExpected = "Have you been diagnosed with ankylosing spondylitis, or AS, by a doctor? (Agent Note: ANK-kih-low-sing spon-dill-LITE-iss)\n" +
    		"Ankylosing spondylitis is a chronic inflammatory disease that primarily affects the spine, leading to frequent back pain and stiffness and sometimes pain in other areas of the body, too. The back pain is usually worse in the morning and after periods of rest or inactivity. In advanced cases, inflammation can cause sections of the spine to fuse together and become less flexible.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public DiagnosedWithAnkylosingSpondylitisPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedWithAnkylosingSpondylitisPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedWithAnkylosingSpondylitisPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
