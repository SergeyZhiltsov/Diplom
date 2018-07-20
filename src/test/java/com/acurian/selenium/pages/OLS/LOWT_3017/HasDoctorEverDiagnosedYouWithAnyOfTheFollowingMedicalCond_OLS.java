package com.acurian.selenium.pages.OLS.LOWT_3017;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS extends MainPageOLS{

    public final String titleExpected = "Certain conditions are more closely linked to cardiovascular disease than others.\n" +
    		"Has a doctor ever diagnosed you with any of the following medical conditions or diseases?\n" +
    		"Please select all that apply:";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public HasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasDoctorEverDiagnosedYouWithAnyOfTheFollowingMedicalCond_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
