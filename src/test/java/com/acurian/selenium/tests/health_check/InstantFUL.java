package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.FUL_Letters.FollowupLetter;
import com.acurian.selenium.pages.OLS.RA_2821.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.RA_2821.WhenYouDiagnosedWithRaPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.utils.PassPID;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class InstantFUL extends BaseTest {

    @DataProvider(name = "sites")
    public static Object[][] getData() {
        return new Object[][]{
                {"AUT_GRA_FUL_Site", "60415"},
                {"AUT_GRA_FULm_Site", "60061"}
        };
    }

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(dataProvider = "sites")
    @Description("Test for Instant FOllow-Up Letter (FUL) Validation")
    public void instantFUL(final String siteName, final String zipCode) {
        final String phoneNumber = "GMEGA00001";
        final String studyName = "Arthritis,a low back pain study,a rheumatoid arthritis (RA)";
        String env = System.getProperty("acurian.env", "QA");
        FollowupLetter followupLetter;

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoad();

        IdentificationPageOLS identificationPageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new IdentificationPageOLS());

        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        ApproximateHeightPageOLS approximateHeightPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightPageOLS());

        approximateHeightPageOLS
                .waitForPageLoad();
        FollowingNeurologicalConditionsPageOLS followingNeurologicalConditionsOLS = approximateHeightPageOLS
                .setAll("5", "5", "160")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS());

        DigestiveConditionsPageOLS digestiveConditionsPageOLS = followingNeurologicalConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS());

        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = digestiveConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageOLS());

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhenYouDiagnosedWithRaPageOLS whenYouDiagnosedWithRaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaPageOLS());

        SiteSelectionPageOLS siteSelectionPageOLS = whenYouDiagnosedWithRaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(identificationPageOLS)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS());

        siteSelectionPageOLS
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseGmegaOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad();
        switch (siteName) {
            case "AUT_GRA_FUL_Site":
                followupLetter = new FollowupLetter();
                followupLetter.assertgmailFUL(PassPID.getInstance().getPidNumber(), false);
                break;
            case "AUT_GRA_FULm_Site":
                followupLetter = new FollowupLetter();
                followupLetter.assertgmailFUL(PassPID.getInstance().getPidNumber(), true);
        }
    }
}
