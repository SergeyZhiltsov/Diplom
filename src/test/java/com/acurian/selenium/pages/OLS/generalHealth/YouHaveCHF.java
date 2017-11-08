package com.acurian.selenium.pages.OLS.generalHealth;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class YouHaveCHF extends MainPageOLS{

    public final String titleExpected = "Heart failure is also called congestive heart failure or CHF. It is an ongoing health problem. It happens when your heart cannot pump as well as it should. Common symptoms of CHF include: fluid retention, swelling of the feet and ankles, bloating, and difficulty breathing.\n"
    		+ "\n" +
    		"Many people with heart failure have a history of other heart problems, like a heart attack or blocked arteries. However, heart failure is a different, specific medical condition. Not everyone who has had a heart attack will develop heart failure.\n" +
    		"Has a healthcare professional told you that you have heart failure, congestive heart failure, or CHF?";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS2_')]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    public YouHaveCHF() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public YouHaveCHF waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public YouHaveCHF clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
//        List<String> answerTextList = Arrays.asList(answerText);
//        checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
//                .forEach(el -> getActions().moveToElement(el.findElement(By.xpath("ancestor::label")),5,5).click().build().perform());
//        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
