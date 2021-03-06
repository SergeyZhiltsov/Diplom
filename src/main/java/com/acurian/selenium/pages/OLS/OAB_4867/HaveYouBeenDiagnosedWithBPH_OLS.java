package com.acurian.selenium.pages.OLS.OAB_4867;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouBeenDiagnosedWithBPH_OLS extends MainPageOLS{

    public final String titleExpected = "Have you been diagnosed with enlarged prostate or BPH?";
    

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HaveYouBeenDiagnosedWithBPH_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouBeenDiagnosedWithBPH_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouBeenDiagnosedWithBPH_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
