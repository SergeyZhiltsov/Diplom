package com.acurian.selenium.pages.OLS.SUI_3923;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class WhichTypeOfUrinaryLeakageYouExperienceOLS extends MainPageOLS {
	public final String titleExpected = "To review, stress urinary leakage is associated with physical activities such as coughing, sneezing, and laughing, while urge urinary leakage is associated with sudden, intense urges to urinate.\n" +
"Which type of urinary leakage do you experience most often?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public WhichTypeOfUrinaryLeakageYouExperienceOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichTypeOfUrinaryLeakageYouExperienceOLS waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public WhichTypeOfUrinaryLeakageYouExperienceOLS clickOnAnswer(String answerText) {
        radioButtonsList.stream().filter(el -> el.getText().contains(answerText))
                .findFirst()
                .get()
                .click();
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
