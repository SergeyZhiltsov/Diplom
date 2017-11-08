package com.acurian.selenium.pages.OLS.OA_3138;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HowManyTotalDaysYouTakeFollowingNSAID extends MainPageOLS{

    public final String titleExpected = "During a typical week, how many total days do you take the following NSAID medication(s)?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS4521A_')]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> radioButtonsList;

    public HowManyTotalDaysYouTakeFollowingNSAID() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyTotalDaysYouTakeFollowingNSAID waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowManyTotalDaysYouTakeFollowingNSAID clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
