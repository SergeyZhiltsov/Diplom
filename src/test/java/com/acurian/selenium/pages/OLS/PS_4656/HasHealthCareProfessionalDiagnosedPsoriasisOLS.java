package com.acurian.selenium.pages.OLS.PS_4656;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HasHealthCareProfessionalDiagnosedPsoriasisOLS extends MainPageOLS {

    public final String titleExpected = "Psoriasis is an autoimmune condition that causes the body to produce too many" +
            " skin cells. Raised, red patches with silvery scales, called plaques, form on your skin. The plaques may be painful or itch.\n" +
            "\n" +
            "Has a healthcare professional ever diagnosed you with psoriasis?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    @Step
    public HasHealthCareProfessionalDiagnosedPsoriasisOLS waitForPageLoad() {
        waitForImagesToLoad();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasHealthCareProfessionalDiagnosedPsoriasisOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
