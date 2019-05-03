package com.acurian.selenium.pages.CC.IBD;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CrohnsDiseaseOrUlcerativeColitisFlarePageCC extends MainPageCC {

    public final String titleExpected = "People with Crohn’s disease or ulcerative colitis usually go through periods when the disease is quiet and few or no symptoms are present, alternating with times when it is active and causing symptoms. When symptoms reappear, this is sometimes called a flare or flare-up.\n" +
            "How would you describe your Crohn’s or colitis currently?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public CrohnsDiseaseOrUlcerativeColitisFlarePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CrohnsDiseaseOrUlcerativeColitisFlarePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CrohnsDiseaseOrUlcerativeColitisFlarePageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
