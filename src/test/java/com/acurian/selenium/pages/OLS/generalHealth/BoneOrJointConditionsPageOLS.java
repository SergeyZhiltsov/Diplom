package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BoneOrJointConditionsPageOLS extends MainPageOLS{

    public final String titleExpected = "Do you suffer from any of the following bone or joint conditions?\n" +
            "Please select all that apply.";

    public final String titleExpected2 = "You indicated that you have a condition that affects bones and joints.\n" +
            "Which of the following specific conditions have you been diagnosed with?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText1;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-sm-block')]/div[@class='show-in-ols']")
    WebElement titleText2;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']")
    WebElement titleText3;

    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList1;

    @FindBy(xpath = "//span[contains(@class,'visible-sm-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList2;

    @FindBy(xpath = "//span[contains(@class,'visible-xs-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList3;

    List<WebElement> checkBoxList;

    public BoneOrJointConditionsPageOLS() {
        PageFactory.initElements(getDriver(), this);
        switch (Locators.isEnvWeb) {
            case Platforms.WEB:
                titleText = titleText1;
                checkBoxList = checkBoxList1;
                break;
            case Platforms.TABLET:
                titleText = titleText2;
                checkBoxList = checkBoxList2;
                break;
            case Platforms.MOBILE:
                titleText = titleText3;
                checkBoxList = checkBoxList3;
                break;
        }
    }

    @Step
    public BoneOrJointConditionsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public BoneOrJointConditionsPageOLS waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public BoneOrJointConditionsPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
