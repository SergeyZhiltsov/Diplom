package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Diabetes_4356A.DiagnosedAnyTypeOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.TreatingYourDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WithType2DiabetesPageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HasHealthcareProfessionalPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.TreatingYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class Diabetes_4356A_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00004")
    @Description("Diabetes_4356A_Synexus for CC")
    public void tc004Test(final String username, final String password) {
        String phoneNumber = "AUTAMS1HFL";
        List<String> protocols = Arrays.asList("EFC14835", "ITCA 650_CLP_203","K_877_302","17530","EFC13794","NN2211_4315","NN9535_4269");
        String protocol1 = "17530";
        String protocol2 = "NN9535_4269";
        String protocol3 = "NN2211_4315";
        String protocol4 = "EFC13794";
        String protocol5 = "EFC14835";
        String protocol6 = "ITCA 650_CLP_203";
        String protocol7 = "K_877_302";
        String studyName = "Diabetes";//Diabetes study
        String siteName = "AUT_DIA_4356A";
        String debugSiteName = "QSC9004_4356A_AUT_MIG_4356A";
        String env = "STG";
        String zipCode = "19044";

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad();
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleExpectedLBP, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

        diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageCC.getTitleText(), diagnosedAnyTypeOfDiabetesPageCC.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC
                .checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageCC.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7)
                .back();
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        whatKindOfDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(whatKindOfDiabetesPageCC.getTitleText(), whatKindOfDiabetesPageCC.titleExpected, "Title is diff");
        HasHealthcareProfessionalPageCC hasHealthcareProfessionalPageCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new HasHealthcareProfessionalPageCC());
        hasHealthcareProfessionalPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(hasHealthcareProfessionalPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(hasHealthcareProfessionalPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(hasHealthcareProfessionalPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, protocol1, protocol2, protocol3, protocol4, protocol6, protocol7)
                .back();
        WithType2DiabetesPageCC withType2DiabetesPageCC =  whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        withType2DiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageCC.getTitleText(),withType2DiabetesPageCC.titleExpected, "Title is diff");
        TreatingYourDiabetesPageCC treatingYourDiabetesPageCC = withType2DiabetesPageCC
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new TreatingYourDiabetesPageCC());
        treatingYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(withType2DiabetesPageCC.titleExpected, protocol4,protocol6,protocol7)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(treatingYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(withType2DiabetesPageCC.titleExpected, protocol4)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 12 months ago")
                .clickNextButton(treatingYourDiabetesPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(withType2DiabetesPageCC.titleExpected, protocol4)
                .back();
        withType2DiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("More than 1 year ago")
                .clickNextButton(treatingYourDiabetesPageCC);











    }

}
