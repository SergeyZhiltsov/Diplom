package com.acurian.selenium.pages.OLS.generalHealth;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouSmokedCigarettes extends MainPageOLS{

    public final String titleExpected = "Have you ever smoked cigarettes, cigars, or e-cigarettes?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//label[contains(@for,'QS37_')]//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    public HaveYouSmokedCigarettes() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouSmokedCigarettes waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouSmokedCigarettes clickOnAnswers(String answerText) {
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
