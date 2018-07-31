package com.acurian.selenium.pages.OLS.LMG_4686;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class ImpactHaveYourMigraineHeadachesOLS extends MainPageOLS{

    public final String titleExpected = "In the past 3 months, how much of an impact have your migraine headaches had on your daily life?";
    

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public ImpactHaveYourMigraineHeadachesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ImpactHaveYourMigraineHeadachesOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ImpactHaveYourMigraineHeadachesOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
