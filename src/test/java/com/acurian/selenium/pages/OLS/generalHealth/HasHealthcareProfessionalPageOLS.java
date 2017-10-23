package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.CC.generalHealth.HasHealthcareProfessionalPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.shared.DoYouSufferFromLbpPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class HasHealthcareProfessionalPageOLS extends MainPageOLS{

    public final String titleExpected = "Has a healthcare professional told you that you have any of the following heart-related medical conditions?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public HasHealthcareProfessionalPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasHealthcareProfessionalPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasHealthcareProfessionalPageOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
//        List<String> answerTextList = Arrays.asList(answerText);
//        checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
//                .forEach(el -> getActions().moveToElement(el.findElement(By.xpath("ancestor::label")),5,5).click().build().perform());
//        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }


}
