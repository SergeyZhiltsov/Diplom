package com.acurian.selenium.pages.blinx.ams.common_elements;

import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPageBlinx extends BasePage {

    public final String titleExpected = "When do you take your insulin injections?";

    @FindBy(xpath = "//a[@data-translate-link='link.privacy_policy']")
    WebElement privacyPolicyLink;

    @FindBy(xpath = "//a[@data-translate-link='link.more_about_acurian']")
    WebElement moreAboutLink;

    @FindBy(xpath = "//a[@data-translate-link='link.terms-and-conditions']")
    WebElement termOfUseLink;

    @FindBy(xpath = "//div[@id='disclaimer-text']")
    WebElement footerText;

    public FooterPageBlinx() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PrivacyPolicyPage clickPrivacyPolicyLink(){
        waitForAnimation();
        privacyPolicyLink.click();
        return new PrivacyPolicyPage();
    }

    @Step
    public MoreAboutPage clickMoreAboutLink(){
        waitForAnimation();
        moreAboutLink.click();
        return new MoreAboutPage();
    }

    @Step
    public TermOfUsePage clickTermOfUseLink(){
        waitForAnimation();
        termOfUseLink.click();
        return new TermOfUsePage();
    }

    @Step
    public String getFooterText(){
        return getText(footerText);
    }

}
