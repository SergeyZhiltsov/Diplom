package com.acurian.selenium.pages.CC.faq;

import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.utils.CSVParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.LinkedHashMap;

public class FaqPage extends MainPageCC {
    private final String titleExpected = "Frequently Asked Questions";
    private final String projectTextExpected = "(ACURIAN PROJECT CODE: AMS1)";
    String csvFileName = "D:\\Git\\ams1_selenium\\src\\test\\resources\\glossary.csv";
    private CSVParser parser = new CSVParser(csvFileName);
    public LinkedHashMap<String, String> expecedGlossaryData;

    @FindBy(xpath = "//div[@class='header']/h1")
    WebElement headerText;

    @FindBy(xpath = "//div[@class='header']/h3")
    WebElement projectText;

    @FindBy(xpath = "//div[@class='navigation']/ol/li[1]/a")
    WebElement firstNavigationText;

    @FindBy(xpath = "//div[@class='container']/div[@class='content']/div[@class='section']/h3[1]")
    WebElement studyHeaderText;

    public FaqPage() {
        PageFactory.initElements(getDriver(), this);
        expecedGlossaryData = parser.getDataFrom2Rows();
    }

    @Step
    public String getHeaderText() {
        return headerText.getText();
    }

    @Step
    public String getProjectText() {
        return projectText.getText();
    }

    @Step
    public String getFirstNavigationText() {
        return firstNavigationText.getText();
    }

    @Step
    public String getStudyHeaderText() {
        return studyHeaderText.getText();
    }

    public FaqPage waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(headerText, titleExpected);
        return this;
    }
}
