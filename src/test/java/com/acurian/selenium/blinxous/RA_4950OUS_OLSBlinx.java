package com.acurian.selenium.blinxous;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class RA_4950OUS_OLSBlinx extends BaseTest {


    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_4950}
        };
    }

    @Test(dataProvider = "sites", enabled = false)
    @Description("4950OUS_201790/201791/202018 Synexus GSK RA")
    public void ra4950olsTest(Site site) {

        String phoneNumber = "AUTAMS1RA1";
        String studyName = "a rheumatoid arthritis (RA) study";
        String env = System.getProperty("acurian.env", "STG");
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String compensation = "180";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadCrohns(studyName, compensation);
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText2(), dateOfBirthPageOLS
                .getExpectedModifiedTitle(studyName, compensation), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());


    }
}
