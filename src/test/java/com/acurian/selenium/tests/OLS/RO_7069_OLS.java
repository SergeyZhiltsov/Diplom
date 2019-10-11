package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class RO_7069_OLS extends MainPageOLS {

    @Test
    @Description("7069 BA058-05-021 Radius Osteoporosis OLS")
    public void af4958CCTest() {
        final Site site = Site.AUT_OA_4109_Site; //todo
        final String phoneNumber = "800AMS1MTA"; //todo
        final String studyName = "an osteoporosis study";

        String env = System.getProperty("acurian.env", "STG");


    }
}
