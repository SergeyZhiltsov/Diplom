package com.acurian.selenium.pages.OLS.generalHealth;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HeartRelatedMedicalProc extends MainPageOLS{

    public final String titleExpected = "Have you undergone any of the following heart-related medical procedures?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public HeartRelatedMedicalProc() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HeartRelatedMedicalProc waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HeartRelatedMedicalProc clickOnAnswers(String answerText) {
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
