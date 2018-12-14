package com.acurian.selenium.pages.CC.faq;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FaqPage extends MainPageCC {
    private final String titleExpected = "Frequently Asked Questions";
    private final String projectTextExpected = "(ACURIAN PROJECT CODE: AMS1)";
    private final String csvFileName = "\\glossary.csv";
    private List<String[]> expectedGlossaryData;
    public ArrayList<String> expectedTermTitles;
    public ArrayList<String> expectedDefinisionTitles;


    @FindBy(xpath = "//div[@class='header']/h1")
    WebElement headerText;

    @FindBy(xpath = "//div[@class='header']/h3")
    WebElement projectText;

    @FindBy(xpath = "//div[@class='navigation']/ol/li[1]/a")
    WebElement firstNavigationText;

    @FindBy(xpath = "//div[@class='container']/div[@class='content']/div[@class='section']/h3[1]")
    WebElement studyHeaderText;

    @FindBy(xpath = "//a[@name='a_glossary']/following-sibling::dl/dt")
    public List<WebElement> glossaryTerms;

    @FindBy(xpath = "//a[@name='a_glossary']/following-sibling::dl/dd")
    public List<WebElement> glossaryDefinisions;

    public FaqPage() {
        PageFactory.initElements(getDriver(), this);
        expectedGlossaryData = getCsvParser().getData(csvFileName);
        expectedTermTitles = getExpectedTermTitles();
        expectedDefinisionTitles = getExpectedDefinisionTitles();
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
//        waitForAnimation();
        waitForPageLoadMain(headerText, titleExpected);
        return this;
    }

    private ArrayList<String> getExpectedTermTitles() {
        ArrayList<String> data = new ArrayList<>();
        for (String[] tempArray : expectedGlossaryData) {
            data.add(tempArray[0]);
        }
        return data;
    }

    private ArrayList<String> getExpectedDefinisionTitles() {
        ArrayList<String> data = new ArrayList<>();
        for (String[] tempArray : expectedGlossaryData) {
            data.addAll(Arrays.asList(tempArray).subList(1, tempArray.length)); // 1 - ignore term column
        }
        return data;
    }
}
