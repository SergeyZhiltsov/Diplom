package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.constants.FULType;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.gmega.WhenYouDiagnosedWithRaGmegaPageOLS;
import com.acurian.selenium.pages.OLS.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.utils.DBConnection;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;


public class InstantFUL extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider(name = "sites")
    public static Object[][] getData() {
        return new Object[][]{
                {Site.AUT_GRA_FUL_Site},
                {Site.AUT_GRA_FULm_Site}
        };
    }

    private String env = System.getProperty("acurian.env", "QA");
    private String pidNumber;

    @Test(dataProvider = "sites", priority = -1)
    @Description("Test for Instant Follow-Up Letter (FUL) Validation")
    public void instantFUL(Site site) {
        final String phoneNumber = "GMEGA00001";
        final String studyName = "a rheumatoid arthritis (RA)";
        final String studyNameClose = env.equals("QA") ? "Arthritis,a low back pain study,a rheumatoid arthritis (RA) study!" :
        "Arthritis, a low back pain study, a rheumatoid arthritis (RA) study!";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad(studyName, "625")
                .setDate("09091980")
                .clickNextButton(new BehalfOfSomeoneElsePageOLS());

        IdentificationPageOLS identificationPageOLS = behalfOfSomeoneElsePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new IdentificationPageOLS());

        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999",
                        site.zipCode)
                .clickNextButton(new GenderPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = genderPageOLS
                .waitForPageLoadByTitle(genderPageOLS.titleExpectedGmega)
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

        WhenYouDiagnosedWithRaGmegaPageOLS whenYouDiagnosedWithRaGmegaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaGmegaPageOLS());

        SiteSelectionPageOLS siteSelectionPageOLS = whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(identificationPageOLS)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS());

        siteSelectionPageOLS
                .waitForPageLoad1(studyNameClose)
                .clickOnFacilityName(site.name)
                .getPID();
        pidNumber = siteSelectionPageOLS.getPidNumber();
        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                .clickNextButton(new QualifiedClose2PageOLS());

        ThankYouCloseGmegaOLS thankYouCloseGmegaOLS = qualifiedClose2PageOLS
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseGmegaOLS());

        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseGmegaOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        aboutHealthPageOLS
                .assertGeneratedFul(env, site);
    }

    @Test(dataProvider = "sites", priority = 1)
    public void instantFULAssertion(Site site) {
        DBConnection dbConnection = new DBConnection();
        String fulValueField = dbConnection.dbReadFulValue(env, pidNumber);
        System.out.println("Fetched DB value of FUL cell: " + fulValueField);
        Assert.assertNotEquals(fulValueField, "", "FUL VALUE is empty string!");
        Assert.assertNotEquals(fulValueField.toLowerCase(), "null", "FUL VALUE is null string!");
        if (site.withMedicalRecords) {
            Assert.assertTrue(fulValueField.contains(FULType.MEDICAL_RECORD.toString()),
                    String.format("FUL VALUE contains different string. Expected [%s] but found [%s]",
                            FULType.MEDICAL_RECORD.toString(), fulValueField));
        }
    }
}