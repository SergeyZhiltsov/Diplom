package com.acurian.selenium.pages.SB;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.support.PageFactory;

public class LogicBuilderPage extends BasePage {

    public LogicBuilderPage() {
        PageFactory.initElements(getDriver(), this);
    }
}