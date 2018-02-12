package com.acurian.selenium.constants;

public interface URLs {

    String CODE_FOR_DEBUG_OLS = "51fa2780f2430b542923956ac1974bb7";
    String CODE_FOR_DEBUG_CC = "51fa2780f2430b542923956ac1974bb7";

    String CC_STG = "https://stg-cc.acuriancalls.com";
    String CC_QA = "http://qa-cc.acurian.com:8091/login.htm";
    String CC_PROD = "http://acuriancalls.com";
    // %1$s - phone number,   %2$s - debug code
    /*String OLS_STG = "http://acurianhealth-com.ahbrands.staging.wpengine.com/questionnaire_test_staging/welcome?pn=%1$s";
    String OLS_QA = "http://acurianhealth-com.ahbrands.staging.wpengine.com/questionnaire_test_qa/welcome?pn=%1$s"; */
    String OLS_STG = "https://test-screener.acurian.com/questionnaire_test_staging/welcome?pn=%1$s";
    String OLS_QA = "https://test-screener.acurian.com/questionnaire_test_qa/welcome?pn=%1$s";
    String OLS_PROD = "http://acurianhealth.com/questionnaire/welcome?pn=%1$s&show_debug=1&testing_key=%2$s";



}
