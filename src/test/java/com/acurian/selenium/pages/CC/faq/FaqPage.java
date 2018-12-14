package com.acurian.selenium.pages.CC.faq;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FaqPage extends MainPageCC {
    private final String csvFileName = "\\faqData.csv";
    private List<String[]> expectedFaqData;
    public ArrayList<String> expectedFaqTitles;
    public ArrayList<String> expectedFaqDefinisions;

    @FindBy(xpath = "//div[@class='header']/h1")
    WebElement headerText;

    @FindBy(xpath = "//div[@class='header']/h3")
    WebElement projectText;

    @FindBy(xpath = "//div[@class='navigation']/ol/li[1]/a")
    WebElement firstNavigationText;

    @FindBy(xpath = "//div[@class='container']/div[@class='content']/div[@class='section']/h3[1]")
    WebElement studyHeaderText;

    @FindBy(xpath = "//div[@class='section']//dt")
    public List<WebElement> faqTitles;

    @FindBy(xpath = "//div[@class='section']//dd")
    public List<WebElement> faqDefinitions;

    public List<WebElement> filteredDefinitions;

    public FaqPage() {
        PageFactory.initElements(getDriver(), this);
        expectedFaqData = getCsvParser().getData(csvFileName);
        expectedFaqTitles = getExpectedFaqTitles();
        expectedFaqDefinisions = getExpectedFaqDefinisions();
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

    public void filtereFaqDefinitions() {
        List<WebElement> temp;
        temp = faqDefinitions.stream().filter(el -> !(el.getText().equals(""))).collect(Collectors.toList());
        filteredDefinitions = temp;
    }

    private ArrayList<String> getExpectedFaqTitles() {
        ArrayList<String> data = new ArrayList<>();
        for (String[] tempArray : expectedFaqData) {
            data.add(tempArray[0]);
        }
        return data;
    }

    private ArrayList<String> getExpectedFaqDefinisions() {
        ArrayList<String> data = new ArrayList<>();
        for (String[] tempArray : expectedFaqData) {
            data.addAll((Arrays.asList(tempArray).subList(1, tempArray.length)) // 1 - ignore term column
                    .stream().filter(cell -> !(cell.equals(""))).collect(Collectors.toList())); // ignore empty cells in case definition doesn't have subDefinition
        }
        return data;
    }
}
