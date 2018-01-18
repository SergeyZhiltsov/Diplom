package com.acurian.selenium.pages.OLS.debug;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.utils.PassPID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigPageOLS extends MainPageOLS{
	
    @Parameter("StandAlone screeener 4295 PID OLS")
    private String pidNumber;
    
    @FindBy(xpath = "//debug-popup//span[@id='debug_pid']")
    WebElement pidNumberPath;

    @FindBy(xpath = "//a[@id='info-debug-link']/span")
    WebElement CongigLink;

    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//span[text()='Close']")
    WebElement closeButton;
    
    @FindBy(xpath = "//div[contains(@class,'k-widget')]//h3[text()='Phone:']/following-sibling::div[1]/strong")
    public WebElement studySwitch;
  

    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//tbody//tr/td[3]")
    List<WebElement> questionList;

    @FindBy(xpath = "//div[contains(@class,'k-content')]//td[text()='VK2809_201']")
    WebElement protocolVK;

    @FindBy(xpath = "//div[contains(@class,'k-content')]//td[text()='20150230']")
    WebElement protocol201;   
    
    @FindBy(xpath = "//div[contains(@class,'k-widget')][2]//tbody//tr/td[1]")
    List<WebElement> questionNumberList;
    

    
    public ConfigPageOLS() {
    }

    public ConfigPageOLS openDebugWindow(){
    	CongigLink.click();
        return this;
    }

    
    
    public ConfigPageOLS closeDebugWindow(){
        closeButton.click();
        return this;
    }

    public String getTextfromStudySwitch(){
    	return studySwitch.getText();
    }
    

    public ConfigPageOLS getPID(){
        pidNumber = getText(pidNumberPath);
        logTextToAllure("PID of studySwitch standalone ="+pidNumber);
        PassPID.getInstance().setPidNumber(pidNumber);
        System.out.println("Standalone Switch 4295 PID ="+pidNumber);
        return this;
    }
}
