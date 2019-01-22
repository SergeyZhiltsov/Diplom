package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA_2821.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.RA_2821.WhenYouDiagnosedWithRaPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class WLPvalidation extends BaseTest {

    @Test
    @Description("WLP URL Validation & Re-direct Validation")
    public void dBValidation1Rgmega() {
        String phoneNumber = "AUTGMEGA01";
        String studyName = "Arthritis,a low back pain study,a rheumatoid arthritis (RA)";
        String siteName = "AUT_GRA1_Site";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");


    }
}
