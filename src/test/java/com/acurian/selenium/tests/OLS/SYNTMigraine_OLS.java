package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.AMIG_4742.HaveYouBeenDiagnosedWithMigrainesPageOLS;
import com.acurian.selenium.pages.OLS.AMIG_4742.HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.HowManyDaysYouSufferOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class SYNTMigraine_OLS extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_AMS1_MIGRS_site},
        };
    }

    @Test(enabled = true, dataProvider = "sites")
    @Description("SYNTMigraine_OLS")
    public void SYNTMigraine_OLS(Site site) {
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String phoneNumber = "AUTAMS1MIG";
        String studyName = "a migraine study!";//"a NASH";
        //String studyName1 = "a fatty liver study for diabetics, a study for diabetics!";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a migraine study", "400");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                .getExpectedModifiedTitle("a fatty liver study for diabetics", "750"),
//                "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        HaveYouBeenDiagnosedWithMigrainesPageOLS haveYouBeenDiagnosedWithMigrainesPageOLS = genderPageOLS
                .setDate("09091968")
                .clickOnAnswer("Male")
                .clickNextButton(new HaveYouBeenDiagnosedWithMigrainesPageOLS());


//        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = haveYouBeenDiagnosedWithMigrainesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back();

        WhichTypeOfHeadacheDoYouGetOLS whichTypeOfHeadacheDoYouGetOLS = new WhichTypeOfHeadacheDoYouGetOLS();
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = new DoAnyOftheFollowingAdditionalDiagnosesOLS();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Headaches (migraine, cluster, tension)")
                .clickNextButton(whichTypeOfHeadacheDoYouGetOLS)
                .waitForPageLoad()
                .clickOnAnswers("Unsure")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS45", site.activeProtocols)
                .back(whichTypeOfHeadacheDoYouGetOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .back();
        ApproximateHeightPageOLS approximateHeightPageOLS = haveYouBeenDiagnosedWithMigrainesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AgeWhenDiagnosedWithMigOLS())
                .waitForPageLoad()
                .setAge("60")
                .clickNextButton(new ApproxHowLongSufferingFromMIG())
                .waitForPageLoad()
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowManyDaysYouSufferOLS())
                .waitForPageLoad()
                .selectDays("5")
                .clickNextButton(new HaveYouEverTakenPrescriptionMedsToPreventMigrainesFromStartingPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No, never any daily medications that my doctor prescribed")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "190") //BMI > 30
                .clickNextButton(new IdentificationPageOLS());
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new TransitionalStatementLowtPageOLS())
//                .waitForPageLoad()
//                .clickNextButton(new ExperiencedAnyOfFollowingOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HasDoctorEverDiagnosedYouWithLowTestosterone_OLS())
//                .waitForPageLoad()
//                .clickOnAnswer("No")
//                .clickNextButton(new HasDoctorEverDiagnosedYouMedicalCond_OLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new AdditionalHeartRelatedConditionsPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickNextButton(new IdentificationPageOLS());

        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());

        siteSelectionPageOLS
                .waitForPageLoad1(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .waitForAnimation();
        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = siteSelectionPageOLS
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS());
        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AlzheimerClosePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}

