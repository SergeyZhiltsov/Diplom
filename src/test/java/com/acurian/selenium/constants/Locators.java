package com.acurian.selenium.constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
public @interface Locators {

    //Login Page
    String LOGIN_INPUT = "input[ng-model='user.Username']";
    String isEnvWeb = System.getProperty("acurian.platform", "web");// web, mobile, tablet

    String BASIC_DROPDOWN_LIST = "//div[contains(@class,'dropdown')]/select";

    //Base CC
    String BASIC_TITLE_WITH_RADIO_BUTTON_CC = "//div[@class='question_text']"; //norm
    String RADIO_BUTTON_LIST_CC = "//div[@class='radio_btns_container']//label";
    String BASIC_DROPDOWN_LIST_CC = "//div[@class='ddlist_container']//select";

    String BASIC_TITLE2_WITH_RADIO_BUTTON_CC = "//div[@class='question_text']//div[@class='show-in-cc']";
    String RADIO_BUTTON_LIST2_CC = "";

    String BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC = "//div[@class='question_text']//span[@class='show-in-cc']";
    String CHEKBOX_LIST_CC = "//div[@class='checkboxes_container']//span[@class='show-in-cc']";

    String BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC = "//div[@class='question_text']";
    String CHEKBOX_LIST2_CC = "//div[@class='checkboxes_container']//label";

    //basic OLS
    String BASIC_TITLE_WITH_RADIO_BUTTON_OLS = "//div[@class='question']//div[contains(@class,'visible-md-block')]";

    String BASIC_TITLE_WITH_RADIO_BUTTON_OLS_TABLET = "//div[@class='question']//div[contains(@class,'visible-sm-block')]";
    String BASIC_TITLE_WITH_RADIO_BUTTON_OLS_MOBILE = "//div[@class='question']//div[contains(@class,'visible-xs-block')]";
    String RADIO_BUTTON_LIST_OLS = "//span[contains(@class,'visible-md-inline')]/ancestor::label | //div[@class='answer-text']";

    String BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']";
    String BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS_TABLET = "//div[@class='question']//div[contains(@class,'visible-sm-block')]/div[@class='show-in-ols']";
    String BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS_MOBILE = "//div[@class='question']//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']";
    String CHEKBOX_LIST_OLS = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']";
    String CHEKBOX_LIST_OLS_TABLET = "//span[contains(@class,'visible-sm-inline')]/span[@class='show-in-ols']";
    String CHEKBOX_LIST_OLS_MOBILE = "//span[contains(@class,'visible-xs-inline')]/span[@class='show-in-ols']";

    String BASIC_TITLE2_WITH_RADIO_BUTTON_OLS = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']";
    String RADIO_BUTTON_LIST2_OLS = "";

    String BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_OLS = "//div[@class='question']//div[contains(@class,'visible-md-block')]";
    String CHEKBOX_LIST2_OLS = "//span[contains(@class,'visible-md-inline')]";


    String BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX = "//div[@class='mt-2 mt-sm-4']//div[contains(@class,'question-text')]";
    String CHEKBOX_LIST_OLS_BLINX = "//div[@class='multiple-choice-answers-container']/button";

}
