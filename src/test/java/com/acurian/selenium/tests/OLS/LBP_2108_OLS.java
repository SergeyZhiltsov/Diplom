package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.LBP_2108.OfMedicationsYou;
import com.acurian.selenium.pages.CC.generalHealth.HasHealthcareProfessionalPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.OLS.LBP_2108.InPastYearPageOLS;
import com.acurian.selenium.pages.OLS.LBP_2108.InTotalHowManyPageOLS;
import com.acurian.selenium.pages.OLS.LBP_2108.OfMedicationsYouPageOLS;
import com.acurian.selenium.pages.OLS.LBP_2108.WhatTypeOfHealthcarePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HasHealthcareProfessionalPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class LBP_2108_OLS extends BaseTest{

    @Test
    @TestCaseId("00002")
    @Description("LBP 2108 OLS module")
    public void tc002Test() {
        String phoneNumberLBP = "AUTAMS1LBP";
        List<String> protocols = Arrays.asList("A4091059");
        String protocol = "A4091059";
        String studyName = "low back pain";
        String siteName = "AUT_LBP_2108_Site";
   //     String env = "STG";
        String zipCode = "19044";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberLBP)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(),dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),dateOfBirthPageOLS.titleLBPExpected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DoYouSufferFromLbpPageOLS doYouSufferFromLbpPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromLbpPageOLS());

        doYouSufferFromLbpPageOLS
                .waitForPageLoad();
        Assert.assertEquals(doYouSufferFromLbpPageOLS.getTitleText(),doYouSufferFromLbpPageOLS.titleExpected, "Title is diff");
        HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = doYouSufferFromLbpPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HasHealthcareProfessionalPageOLS());

        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        DebugPageOLS debugPageCC = new DebugPageOLS();
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(doYouSufferFromLbpPageOLS.titleExpected), protocol, "Protocol is diff");
        debugPageCC.back();

        HowLongHaveLbpPageOLS howLongHaveLbpPageOLS = doYouSufferFromLbpPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveLbpPageOLS());

        howLongHaveLbpPageOLS
                .waitForPageLoad();
        Assert.assertEquals(howLongHaveLbpPageOLS.getTitleText(), howLongHaveLbpPageOLS.titleExpected, "Title is diff");
        howLongHaveLbpPageOLS
                .clickOnAnswer("Less than 3 months")
                .clickNextButton(hasHealthcareProfessionalPageOLS);

        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(hasHealthcareProfessionalPageOLS.titleExpected), protocol, "Protocol is diff");
        debugPageCC.back();

        WhatTypeOfHealthcarePageOLS whatTypeOfHealthcarePageOLS =howLongHaveLbpPageOLS
                .clickOnAnswer("3 - 6 months")
                .clickNextButton(new WhatTypeOfHealthcarePageOLS());

        whatTypeOfHealthcarePageOLS
                .waitForPageLoad();
        Assert.assertEquals(whatTypeOfHealthcarePageOLS.getTitleText(), whatTypeOfHealthcarePageOLS.titleExpected, "Title is diff");
        InTotalHowManyPageOLS inTotalHowManyPageOLS = whatTypeOfHealthcarePageOLS
                .clickOnAnswers("Family doctor or general practitioner")
                .clickNextButton(new InTotalHowManyPageOLS());

        inTotalHowManyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("0")
                .clickNextButton(hasHealthcareProfessionalPageOLS);

        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(inTotalHowManyPageOLS.titleExpected), protocol, "Protocol is diff");
        hasHealthcareProfessionalPageOLS.back();

        inTotalHowManyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("1")
                .clickNextButton(hasHealthcareProfessionalPageOLS);

        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(inTotalHowManyPageOLS.titleExpected), protocol, "Protocol is diff");
        hasHealthcareProfessionalPageOLS.back();

        inTotalHowManyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("2")
                .clickNextButton(hasHealthcareProfessionalPageOLS);

        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(inTotalHowManyPageOLS.titleExpected), protocol, "Protocol is diff");
        hasHealthcareProfessionalPageOLS.back();

        OfMedicationsYouPageOLS ofMedicationsYouPageOLS = inTotalHowManyPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3")
                .clickNextButton(new OfMedicationsYouPageOLS());

        ofMedicationsYouPageOLS
                .waitForPageLoad();
        Assert.assertEquals(ofMedicationsYouPageOLS.getTitleText(), ofMedicationsYouPageOLS.titleExpected, "Title is diff");
        AreYouCurrentlyOnPageOLS areYouCurrentlyOnPageOLS = ofMedicationsYouPageOLS
                .clickOnAnswer("0")
                .clickNextButton(new AreYouCurrentlyOnPageOLS());

        areYouCurrentlyOnPageOLS
                .waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyOnPageOLS.getTitleText(), areYouCurrentlyOnPageOLS.titleExpected, "Title is diff");
        areYouCurrentlyOnPageOLS
                .clickOnAnswer("Yes, for another chronic condition")
                .clickNextButton(hasHealthcareProfessionalPageOLS);

        hasHealthcareProfessionalPageOLS
                .waitForPageLoad();
        Assert.assertEquals(debugPageCC.getProtocolForQuestion(areYouCurrentlyOnPageOLS.titleExpected), protocol, "Protocol is diff");
        hasHealthcareProfessionalPageOLS.back();

        InPastYearPageOLS inPastYearPageOLS = areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, for low back pain")
                .clickNextButton(new InPastYearPageOLS());

        inPastYearPageOLS
                .waitForPageLoad();
        Assert.assertEquals(areYouCurrentlyOnPageOLS.getTitleText(), areYouCurrentlyOnPageOLS.titleExpected, "Title is diff");
        inPastYearPageOLS
                .clickOnAnswers("");




    }

}
