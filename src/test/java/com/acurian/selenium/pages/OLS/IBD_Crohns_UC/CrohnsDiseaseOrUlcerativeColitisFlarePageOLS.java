package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CrohnsDiseaseOrUlcerativeColitisFlarePageOLS extends MainPageOLS {

	public final String titleExpected = "People with Crohn’s disease or ulcerative colitis usually go through periods when the disease is quiet and few or no symptoms are present, alternating with times when it is active and causing symptoms. When symptoms reappear, this is sometimes called a flare or flare-up.\n" +
            "How would you describe your Crohn’s or colitis currently?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public CrohnsDiseaseOrUlcerativeColitisFlarePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CrohnsDiseaseOrUlcerativeColitisFlarePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CrohnsDiseaseOrUlcerativeColitisFlarePageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
