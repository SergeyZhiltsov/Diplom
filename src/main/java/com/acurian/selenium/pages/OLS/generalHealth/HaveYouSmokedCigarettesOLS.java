package com.acurian.selenium.pages.OLS.generalHealth;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouSmokedCigarettesOLS extends MainPageOLS{

    public final String titleExpected = "Have you ever smoked cigarettes, cigars, or e-cigarettes?";
    
    public final String titleExpectedNew = "Have you ever smoked cigarettes?";
    
    

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    public HaveYouSmokedCigarettesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouSmokedCigarettesOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    @Step
    public HaveYouSmokedCigarettesOLS waitForPageLoadNew() {
        waitForPageLoadMain(titleText, titleExpectedNew);
        return this;
    }

    @Step
    public HaveYouSmokedCigarettesOLS clickOnAnswers(String answerText) {
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
