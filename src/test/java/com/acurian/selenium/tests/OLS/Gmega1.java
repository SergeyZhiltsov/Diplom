package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.UnqualifiedCloseOLS_GMEGA;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.gmega1.BasedOnYourAnswersPageOLS;
import com.acurian.selenium.pages.OLS.gmega1.ReachTheSchedulingCenterPageOLS;
import com.acurian.selenium.pages.OLS.gmega1.TakingAcetaminophenTylenolPageOLS;
import com.acurian.selenium.pages.OLS.gmega1.TransferPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.PersonalDetails;
import com.acurian.selenium.pages.OLS.shared.WhereDoYouHaveArthritisPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class Gmega1 extends BaseTest{

    @Test(enabled = false)
    @TestCaseId("001124")
    @Description("Gmega")
    public void gmega1Test() {
        String phoneNumber = "AUTGMEGA01";
        String protocol1 = "RA01_Generic";
        String protocol2 = "Radiant_Generic";
        String protocol3 = "GOA_3";
        String protocol4 = "RF_I6T_MC_AMAG";
        List<String> protocols = Arrays.asList(protocol1, protocol2, protocol3, protocol4);
        String studyName = "an arthritis";
        String siteName = "AUT_GMEGA";
        String debugSiteName = "";
        String zipCode = "19044";
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGH(), dateOfBirthPageOLS.titleExpected, "Question is diff");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleGmegaExpected, "Title is diff");
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
        UnqualifiedCloseOLS_GMEGA unqualifiedCloseOLS = boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new UnqualifiedCloseOLS_GMEGA());
        unqualifiedCloseOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsEqualsForQNumber("QS3", protocol1, protocol2, protocol3);
        debugPageOLS.clickOnQNumber("QS3");//because after clicking back is same page loading
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhereDoYouHaveArthritisPageOLS whereDoYouHaveArthritisPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                .clickNextButton(new WhereDoYouHaveArthritisPageOLS());

        TakingAcetaminophenTylenolPageOLS takingAcetaminophenTylenolPageOLS = whereDoYouHaveArthritisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("What kind of arthritis do you have?Agent Note: Select all that applyWhat kind of arthritis do you ha", protocol1)
                .getPage(whereDoYouHaveArthritisPageOLS)
                .clickOnAnswers("Left Knee", "Right Knee")
                .clickNextButton(new TakingAcetaminophenTylenolPageOLS());

        IdentificationPageOLS identificationPageOLS = takingAcetaminophenTylenolPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Where do you have arthritis?Agent Note: Select all that applyWhere do you have arthritis?Please sele", protocol2)
                .getPage(takingAcetaminophenTylenolPageOLS)
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());

        identificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new BasedOnYourAnswersPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ReachTheSchedulingCenterPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Ok, I will pass your information on to the scheduling center and they will call you back. Thank you again for contacting Acurian's Research Information Center. Goodbye.")
                .clickNextButton(new TransferPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Successful transfer made to site")
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad();

    }
}
