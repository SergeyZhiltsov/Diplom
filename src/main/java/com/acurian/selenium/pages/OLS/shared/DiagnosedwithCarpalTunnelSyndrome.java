package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.END_4385.DescribesNonMenstrualPelvicPainOLS;
import com.acurian.selenium.pages.OLS.OA_3138.ParticipatedInAnotherClinicalResearch;

import ru.yandex.qatools.allure.annotations.Step;

public class DiagnosedwithCarpalTunnelSyndrome extends MainPageOLS {
	
	public final String titleExpected = "Has a doctor ever diagnosed you with carpal tunnel syndrome?";
      
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]")
    List<WebElement> radioButtonsList;

    public DiagnosedwithCarpalTunnelSyndrome() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedwithCarpalTunnelSyndrome waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedwithCarpalTunnelSyndrome clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}