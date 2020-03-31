package com.acurian.selenium.pages.OLS.common_elements;

import com.acurian.selenium.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPageOLS extends BasePage {

    public final String titleExpected = "When do you take your insulin injections?";

    @FindBy(xpath = "//a[contains(@class,'footer-links__privacy') and text()='Privacy Policy']")
    WebElement privacyPolicyLink;

    @FindBy(xpath = "//a[contains(@class,'footer-links__more') and text()='More about Acurian, Inc']")
    WebElement moreAboutLink;

    @FindBy(xpath = "//a[text()='Terms of Use']")
    WebElement termOfUseLink;

    @FindBy(xpath = "//div[@translate='first_question.disclaimer_text']")
    WebElement footerText;

    public FooterPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PrivacyPolicyPage clickPrivacyPolicyLink(){
        privacyPolicyLink.click();
        return new PrivacyPolicyPage();
    }

    @Step
    public MoreAboutPage clickMoreAboutLink(){
        moreAboutLink.click();
        return new MoreAboutPage();
    }

    @Step
    public TermOfUsePage clickTermOfUseLink(){
        termOfUseLink.click();
        return new TermOfUsePage();
    }

    @Step
    public String getFooterText(){
        return getText(footerText);
    }
}
