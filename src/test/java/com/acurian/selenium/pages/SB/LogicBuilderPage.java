package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LogicBuilderPage extends BasePage {

    @FindBy(css = "#core-link")
    WebElement coreLink;
    @FindBy(css = "div.blockUI.blockOverlay")
    WebElement blockOverlay;
    @FindBy(xpath = "//button[@type='submit'][contains(.,'Save')]")
    WebElement save;
    @FindBy(css = "span[data-bind='text: message']")
    WebElement alertMessage;

    public LogicBuilderPage() {
        PageFactory.initElements(getDriver(), this);
        waitForJavaScriptComplete();
    }

    public LogicBuilderPage clickCoreLink() {
        waitForAbsence(blockOverlay);
        waitAndClickWebElement(coreLink);
        return this;
    }

    @Step
    public LogicBuilderPage clickSubCoreLink(int number) {
        threadSleep(3000); //TODO Remove
        waitForAbsence(blockOverlay);
        waitAndClickWebElement(By.xpath(String.format("//*[@id='floating-sidebar']//a[contains(text(),'Core-%d')]",
                number)));
        return this;
    }


    @Step
    public LogicBuilderPage clickCore(int coreNumber) {
        waitAndClickWebElement(By.xpath(String.format("//label[text() ='Core']/following-sibling::label[text() ='%d']",
                coreNumber)));
        waitForAbsence(blockOverlay);
        return this;
    }

    @Step
    public LogicBuilderPage clickFlowLogicOption(int coreNumber) {
        threadSleep(3000); //TODO Remove
        waitAndClickWebElement(By.cssSelector(String.format("#headingFlowLogicCore-QS%d > h4 > a", coreNumber)));
        return this;
    }

    @Step
    public LogicBuilderPage selectActionForCoreAndRule(int coreNumber, int ruleNumber, String select) {
        waitAndClickWebElement(By.xpath((String.format("//*[@id='FlowCore-QS%d']//span[@data-bind='text: orderID' " +
                "and contains(.,'%d')]/../../..//strong[contains(.,'Action')]/following-sibling::select",
                coreNumber, ruleNumber))));
        waitAndClickWebElement(By.xpath(String.format("//*[@id='FlowCore-QS%d']//span[@data-bind='text: orderID' " +
                "and contains(.,'%d')]/../../..//strong[contains(.,'Action')]/following-sibling::select" +
                "/option[contains(.,'%s')]", coreNumber, ruleNumber, select)));

        return this;
    }

    @Step
    public LogicBuilderPage clickSaveLogic() {
        waitAndClickWebElement(save);
        return this;
    }

    public LogicBuilderPage checkAlertMessage(String expectedText) {
        waitForVisibility(alertMessage);
        Assert.assertEquals(alertMessage.getText(), expectedText, "Save question alert message is different");
        return this;
    }
}