package com.acurian.selenium.pages.CC.faq;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaqPage extends BasePage {

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
    }

    public String getHeaderText() {
        return headerText.getText();
    }

    public String getProjectText() {
        return projectText.getText();
    }

    public String getFirstNavigationText() {
        return firstNavigationText.getText();
    }

    public String getStudyHeaderText() {
        return studyHeaderText.getText();
    }
}
