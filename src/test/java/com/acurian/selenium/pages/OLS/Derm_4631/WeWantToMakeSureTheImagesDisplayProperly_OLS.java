package com.acurian.selenium.pages.OLS.Derm_4631;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class WeWantToMakeSureTheImagesDisplayProperly_OLS extends MainPageOLS {
	public final String titleExpected = "Next, we are going to show you images to help us understand the area(s) of your body currently affected by eczema (atopic dermatitis).\n" +
			"We want to make sure the images display properly on your screen.  What device are you using to answer this screener?";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@class,'col-xs-11')]/span[@class='copy']")
    List<WebElement> radioButtonsList;

    public WeWantToMakeSureTheImagesDisplayProperly_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WeWantToMakeSureTheImagesDisplayProperly_OLS waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public WeWantToMakeSureTheImagesDisplayProperly_OLS clickOnAnswer(String answerText) {
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
