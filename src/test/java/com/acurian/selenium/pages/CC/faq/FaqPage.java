package com.acurian.selenium.pages.CC.faq;

import com.acurian.selenium.pages.BasePage;
import org.openqa.selenium.support.PageFactory;

public class FaqPage extends BasePage {


    public FaqPage() {
        PageFactory.initElements(getDriver(), this);
    }
}
