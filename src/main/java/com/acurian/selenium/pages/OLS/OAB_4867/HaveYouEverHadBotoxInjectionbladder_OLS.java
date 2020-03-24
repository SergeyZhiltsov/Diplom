package com.acurian.selenium.pages.OLS.OAB_4867;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouEverHadBotoxInjectionbladder_OLS extends MainPageOLS{

    public final String titleExpected = "Botox (botulinum toxin) injections are sometimes given as a treatment for overactive bladder.\n" +
    		"Have you ever had a Botox injection into your bladder muscle?";
    

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HaveYouEverHadBotoxInjectionbladder_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverHadBotoxInjectionbladder_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverHadBotoxInjectionbladder_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
