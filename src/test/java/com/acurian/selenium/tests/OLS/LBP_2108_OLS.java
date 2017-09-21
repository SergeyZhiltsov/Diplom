package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.generalHealth.HasHealthcareProfessionalPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
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
        String env = "STG";
        String zipCode = "19044";

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

        doYouSufferFromLbpPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveLbpPageOLS());





    }

}
