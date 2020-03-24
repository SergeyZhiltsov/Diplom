package com.acurian.selenium.pages.OLS.LBP_2108;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.shared.HowLongHaveLbpPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class InTotalHowManyPageOLS extends MainPageOLS{

    public final String titleExpected = "People with low back pain may have to try many different medications for their pain. Please think about all the pills, gels, creams, or shots that you have taken for your pain.\n" +
            "In total, how many medications have you tried for your low back pain?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public InTotalHowManyPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InTotalHowManyPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public InTotalHowManyPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
