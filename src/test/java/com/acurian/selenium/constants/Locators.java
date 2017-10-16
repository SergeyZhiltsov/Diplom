package com.acurian.selenium.constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
public @interface Locators {

    //Login Page
    String LOGIN_INPUT = "input[ng-model='user.Username']";

    //Base CC
    String BASIC_TITLE_WITH_RADIO_BUTTON_CC = "//div[@class='question_text']";
    String RADIO_BUTTON_LIST_CC = "//div[@class='radio_btns_container']//label";

    String BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC = "//div[@class='question_text']//div[@class='show-in-cc']";
    String CHEKBOX_LIST_CC = "//div[@class='checkboxes_container']//span[@class='show-in-cc']";

    //basic OLS
    String BASIC_TITLE_WITH_RADIO_BUTTON_OLS = "//div[@class='question_text']";
    String RADIO_BUTTON_LIST_OLS = "//div[@class='radio_btns_container']//label";

    String BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS = "//div[@class='question_text']//div[@class='show-in-cc']";
    String CHEKBOX_LIST_OLS = "//div[@class='radio_btns_container']//label";

}
