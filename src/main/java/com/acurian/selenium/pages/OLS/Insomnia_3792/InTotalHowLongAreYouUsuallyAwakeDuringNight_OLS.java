package com.acurian.selenium.pages.OLS.Insomnia_3792;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class InTotalHowLongAreYouUsuallyAwakeDuringNight_OLS extends MainPageOLS {
	public final String titleExpected = "In total, after first falling asleep, how long are you usually awake during the night?\n" + 
			"For example, if you awaken 2 times during the night, and it takes 30 minutes for you to get back to sleep each time, your total time awake would be 1 hour.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public InTotalHowLongAreYouUsuallyAwakeDuringNight_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InTotalHowLongAreYouUsuallyAwakeDuringNight_OLS waitForPageLoad() {
        waitForAnimation();
        waitforVisibility(titleText);
        return this;
    }

    @Step
    public InTotalHowLongAreYouUsuallyAwakeDuringNight_OLS clickOnAnswer(String answerText) {
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
