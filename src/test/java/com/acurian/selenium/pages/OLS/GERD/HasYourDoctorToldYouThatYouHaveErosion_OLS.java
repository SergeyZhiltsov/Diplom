package com.acurian.selenium.pages.OLS.GERD;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HasYourDoctorToldYouThatYouHaveErosion_OLS extends MainPageOLS {
	public final String titleExpected = "Has your doctor told you that you have an erosion in your esophagus, esophageal erosions or erosive esophagitis?\n" +
            "This refers to ulceration or \"wearing away\" of the esophageal lining, and is seen on endoscopy.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public HasYourDoctorToldYouThatYouHaveErosion_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasYourDoctorToldYouThatYouHaveErosion_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public HasYourDoctorToldYouThatYouHaveErosion_OLS clickOnAnswer(String answerText) {
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
