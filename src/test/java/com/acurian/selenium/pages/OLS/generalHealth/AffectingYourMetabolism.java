package com.acurian.selenium.pages.OLS.generalHealth;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class AffectingYourMetabolism extends MainPageOLS{

    public final String titleExpected = "Has a healthcare professional ever diagnosed you with any of the following conditions affecting your metabolism and general health?\n" + 
    		"Please select all that apply.";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS4_')]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    public AffectingYourMetabolism() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AffectingYourMetabolism waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AffectingYourMetabolism clickOnAnswers(String answerText) {
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
