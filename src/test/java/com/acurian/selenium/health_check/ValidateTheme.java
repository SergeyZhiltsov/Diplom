package com.acurian.selenium.health_check;

import com.acurian.selenium.blinx.Crohns_4818_OLSBlinx;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class ValidateTheme extends BaseTest {

    private static Logger Log = LogManager.getLogger(ValidateTheme.class.getName());

    @Test(enabled = true)
    @Description("Test for 1R and Verity Check")
    public void verityThemeTest() {
        String phoneNumber = "AUTGMEGA01";
        String studyName = "a rheumatoid arthritis (RA)";
        String siteName = "AUT_GRA1_Site";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadGMEGA("a rheumatoid arthritis (RA)", "625")
                .setDate("09091980")
                .clickNextButton(new BehalfOfSomeoneElsePageOLS());

        IdentificationPageOLS identificationPageOLS = behalfOfSomeoneElsePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new IdentificationPageOLS());

        identificationPageOLS
                .waitForPageLoadNotQ();
        GenderPageOLS genderPageOLS = identificationPageOLS
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoadByTitle(genderPageOLS.titleExpectedGmega)
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();

        Log.info(debugPageOLS.getThemeText());
        Assert.assertEquals(debugPageOLS.getThemeText(), "Design(not used): electro (13)", "Theme is not ELECTRO");
    }
}
