package com.acurian.selenium.pages.OLS.debug;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedFlareMonitoringAppClosePageOLS;
import com.acurian.utils.PassPID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Parameter;

import java.util.List;

public class ConfigPageOLS extends MainPageOLS {

    private static Logger Log = LogManager.getLogger(ConfigPageOLS.class.getName());

    @Parameter("StandAlone screeener 4733 PID OLS")
    private String pid;

    @FindBy(xpath = "//debug-popup//span[@id='debug_pid']")
    WebElement pidNumberPath;

    @FindBy(xpath = "//a[@id='info-debug-link']/span")
    WebElement CongigLink;

    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//span[text()='Close']")
    WebElement closeButton;

    @FindBy(xpath = "(//strong[contains(.,'4733')])[3]")
    public WebElement studySwitch;


    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//tbody//tr/td[3]")
    List<WebElement> questionList;

    @FindBy(xpath = "//div[@ng-show='!debug.is_mobile']//div[@id='info-debug-window']/div[15]/strong")
    WebElement verityScore;

    @FindBy(xpath = "//div[contains(@class,'k-content')]//td[text()='20150230']")
    WebElement protocol201;

    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//tbody//tr/td[1]")
    List<WebElement> questionNumberList;


    public ConfigPageOLS() {
    }

    public ConfigPageOLS openDebugWindow() {
        CongigLink.click();
        return this;
    }


    public ConfigPageOLS closeDebugWindow() {
        closeButton.click();
        return this;
    }

    public String getTextfromStudySwitch() {
        return studySwitch.getText();
    }


    public ConfigPageOLS getPID() {
        pid = getText(pidNumberPath);
        textToAttachment("PID of studySwitch standalone =" + pid);
        PassPID.getInstance().setPidNumber(pid);
        Log.info("Standalone Switch 4733 PID = " + pid);
        return this;
    }
}
