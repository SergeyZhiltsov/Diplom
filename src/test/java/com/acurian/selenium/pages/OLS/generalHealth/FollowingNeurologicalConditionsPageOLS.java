package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class FollowingNeurologicalConditionsPageOLS extends MainPageOLS{

//    public final String titleExpected = "Has a healthcare professional ever diagnosed you with any of the following neurological conditions?\n" +
//            "Please select all that apply.";

    public final String titleExpected = "Has a healthcare professional ever diagnosed you with any of the following neurological conditions?N\n" +
            "Please select all that apply.";

//    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
//    WebElement titleText;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/span[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public FollowingNeurologicalConditionsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingNeurologicalConditionsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FollowingNeurologicalConditionsPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
