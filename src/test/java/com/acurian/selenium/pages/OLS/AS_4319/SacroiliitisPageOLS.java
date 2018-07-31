package com.acurian.selenium.pages.OLS.AS_4319;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class SacroiliitisPageOLS extends MainPageOLS{

    public final String titleExpected = "Did your doctor tell you that your x-ray or MRI showed inflammation of the joints where your lower spine and pelvis connect? This is called sacroiliitis.";    		
    

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public SacroiliitisPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SacroiliitisPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SacroiliitisPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
