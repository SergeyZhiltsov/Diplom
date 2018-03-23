package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Crohns_3485.DiagnosedWithCrohnsPageOLS;
import com.acurian.selenium.pages.OLS.closes.UnqualifiedCloseOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class Gmega1 extends BaseTest{

    @Test
    @TestCaseId("001124")
    @Description("Gmega")
    public void gmega1Test() {
        String phoneNumber = "AUTGMEGA01";
        String protocol1 = "RA01_Generic";
        String protocol2 = "Radiant_Generic";
        String protocol3 = "GOA_3";
        String protocol4 = "RF_I6T_MC_AMAG";
        List<String> protocols = Arrays.asList(protocol1, protocol2, protocol3, protocol4);
        String studyName = "a Crohn's";
        String siteName = "AUT_CRN_3889_HS";
        String debugSiteName = "";
        String zipCode = "19044";
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGH(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleGmegaExpected, "Title is diff");
        PersonalDetails personalDetails = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new PersonalDetails());

        GenderPageOLS genderPageOLS = personalDetails
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new BoneOrJointConditionsPageOLS());

        boneOrJointConditionsPageOLS
                .waitForPageLoad();
//        Assert.assertEquals(boneOrJointConditionsPageOLS.getTitleText(), boneOrJointConditionsPageOLS.titleExpected, "Title is diff");
        UnqualifiedCloseOLS unqualifiedCloseOLS = boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new UnqualifiedCloseOLS());
        unqualifiedCloseOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEqualsForQNumber("QS3", protocol1, protocol2, protocol3);
        debugPageOLS.clickOnQNumber("QS3");//because after clicking back is same page loading
        boneOrJointConditionsPageOLS
                .waitForPageLoad().threadSleep(5000);



    }
}
