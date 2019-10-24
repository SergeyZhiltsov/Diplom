package com.acurian.selenium.pages.ServerStatus;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class ServerStatusStartPageOLS extends MainPageOLS {

    public final String titleExpected = "Let's get started to see if there is a study that's right for you!\n" +
            "\n" +
            "First, please complete this questionnaire. Your information will only be used for this purpose.\n" +
            "Then, if there is a study right for you, you’ll schedule an in person visit at the study doctor's office.\n" +
            "If you attend all required study visits, you may receive*:\n" +
            "Payment up to $1,000, which varies by study\n" +
            "No-cost study-related care from doctors\n" +
            "No-cost study medication";

    @FindBy(xpath = "(//div[@class='show-in-ols'])[2]")
    WebElement titleText;

    @FindBy(xpath = "//*[@id='command']/div[3]/div/div[1]/label")
    WebElement yesButton;

    @FindBy(xpath = "//*[@id='command']/div[4]/a")
    WebElement nextButton;
    @Step
    public ServerStatusStartPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ServerStatusStartPageOLS clickOnYes() {
        yesButton.click();
        return this;
    }

    @Step
    public <T extends MainPageOLS> T clickNextButtonCH(T page) {
        nextButton.click();
        return (T) page;
    }
}
