package com.acurian.selenium.constants;

public interface URLs {

    String CODE_FOR_DEBUG_OLS = "51fa2780f2430b542923956ac1974bb7";
    String CODE_FOR_DEBUG_CC = "51fa2780f2430b542923956ac1974bb7";
    String CODE_FOR_DEBUG_BLINX = "51fa2780f2430b542923956ac1974bb7";

    String CC_STG = "https://stg-cc.acuriancalls.com";
    String CC_QA = "https://qa-cc.acuriancalls.com";
    String CC_PROD = "https://acuriancalls.com";
    // %1$s - phone number,   %2$s - debug code
    /*String OLS_STG = "http://acurianhealth-com.ahbrands.staging.wpengine.com/questionnaire_test_staging/welcome?pn=%1$s";
    String OLS_QA = "http://acurianhealth-com.ahbrands.staging.wpengine.com/questionnaire_test_qa/welcome?pn=%1$s"; */
    
    
    //INTERNATIONAL URL: 
    //String OLS_STG = "http://test-screener.acurian.com/questionnaire_test_staging_international/welcome?pn=%1$s";

    String BLINX_PROD = "https://screener.acurianhealth.com/welcome.do?method=beginCall&phoneNumber=%1$s&up[]" +
            "=CLIENT_BLINX&testing_key=%2$s&show_debug=1#";
    String BLINX_STG = "https://sf.acu2.aws.blinxsolutions.systems/welcome.do?method=beginCall&phoneNumber=%1$s";
    String BLINX_QA = "https://sf.acu3.aws.blinxsolutions.systems/welcome.do?method=beginCall&phoneNumber=%1$s";

    String OLS_STG = "https://test-screener.acurian.com/questionnaire_test_staging/welcome?pn=%1$s";
    String OLS_QA = "https://test-screener.acurian.com/questionnaire_test_qa/welcome?pn=%1$s";
    //String OLS_PROD = "http://acurianhealth.com/questionnaire/welcome?pn=%1$s&show_debug=1&testing_key=%2$s"; //changed to avoid Blinx provider
    String OLS_PROD = "https://acurianhealth.com/questionnaire/patient/welcome?pn=%1$s&show_debug=1&testing_key=%2$s";
    //String AH_PROD = "https://acurianhealth.com/questionnaire/welcome?show_debug=1&testing_key=%2$s&up[]=AHLandingPage&pn=%1$s"; //changed to avoid Blinx provider
    String AH_PROD = "https://acurianhealth.com/questionnaire/patient/welcome?show_debug=1&testing_key=%2$s&up[]=AHLandingPage&pn=%1$s";
    String AH_STG = "https://test-screener.acurian.com/questionnaire_test_staging/welcome?method=beginCall&up[]=AHLandingPage&phoneNumber=%1$s";


    //RPA
    String RPA_STG = "https://stg-appservice.acurian.com/rpa/login.htm";
    String RPA_QA = "https://qa-appservice.acurian.com/rpa/login.htm";
    String RPA_PROD = "http://prod-appservice.acurian.com/rpa/login.htm";

    //ScreenBuilder
    String SB_QA = "https://qa-sb.acurian.com/sb/";
    String SB_PRD = "https://sb.acurian.com/";

    //Screeners Clear Cache services
    String QA_CLEAR_CACHE_OLS = "qa-api.acurian.com/ols/ctrl/index.htm"; // do not add http:// prefix to the URL as these urls are secured and require authentication
    String STG_CLEAR_CACHE_OLS = "stg-api.acurian.com/ols/ctrl/index.htm"; // see clearCacheApp.openSecuredPage method
    String PRD_CLEAR_CACHE_OLS = "api.acurian.com/ols/ctrl/index.htm";
}