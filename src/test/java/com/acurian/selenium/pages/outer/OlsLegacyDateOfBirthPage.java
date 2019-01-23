package com.acurian.selenium.pages.outer;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.CC.AST_4337.CurrentlyTakingPillPageCC;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OlsLegacyDateOfBirthPage extends MainPageCC {

    public final String titleExpected = "Let's get started to see if you qualify for a rheumatoid arthritis (RA) study!\n" +
            "Those who qualify may receive*:\n" +
            "Payment which varies by study up to $625\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public OlsLegacyDateOfBirthPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OlsLegacyDateOfBirthPage waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
