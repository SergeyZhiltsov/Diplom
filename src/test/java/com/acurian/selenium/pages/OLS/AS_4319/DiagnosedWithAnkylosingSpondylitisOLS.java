package com.acurian.selenium.pages.OLS.AS_4319;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class DiagnosedWithAnkylosingSpondylitisOLS extends MainPageOLS{

    public final String titleExpected = "Have you been diagnosed with ankylosing spondylitis (AS) by a doctor?\n" +
    		"Ankylosing spondylitis is a chronic inflammatory disease that primarily affects the spine, leading to frequent back pain and stiffness and sometimes pain in other areas of the body, too. The back pain is usually worse in the morning and after periods of rest or inactivity. In advanced cases, inflammation can cause sections of the spine to fuse together and become less flexible.";
    

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public DiagnosedWithAnkylosingSpondylitisOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedWithAnkylosingSpondylitisOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedWithAnkylosingSpondylitisOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
