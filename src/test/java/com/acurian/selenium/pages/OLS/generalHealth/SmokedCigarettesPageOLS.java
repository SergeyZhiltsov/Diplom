package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SmokedCigarettesPageOLS extends MainPageOLS{

    public final String titleExpected = "Have you ever been diagnosed with cancer, other than skin cancer?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public SmokedCigarettesPageOLS() {
    }
}
