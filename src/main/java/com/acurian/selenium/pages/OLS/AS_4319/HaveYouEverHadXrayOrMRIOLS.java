package com.acurian.selenium.pages.OLS.AS_4319;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouEverHadXrayOrMRIOLS extends MainPageOLS{

    public final String titleExpected = "Have you ever had an x-ray or MRI of your back or pelvis, to look for signs of ankylosing spondylitis or AS?";
    

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public HaveYouEverHadXrayOrMRIOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverHadXrayOrMRIOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverHadXrayOrMRIOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
