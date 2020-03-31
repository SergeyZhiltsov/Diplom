package com.acurian.selenium.pages.blinx.ams.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouSmokedCigarettesOLS extends MainPageBlinx {

    public final String titleExpected = "Have you ever smoked cigarettes, cigars, or e-cigarettes?";

    public final String titleExpectedNew = "Have you ever smoked cigarettes?";



    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> checkBoxList;

    public HaveYouSmokedCigarettesOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouSmokedCigarettesOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouSmokedCigarettesOLS waitForPageLoadNew() {
        waitForAnimation();
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
