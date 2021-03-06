package com.acurian.selenium.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.UF_4384.HaveYouHadSurgicalProcedurePast6MonthsUF_OLS;
import com.acurian.selenium.pages.OLS.UF_4384.HowWouldYouDescribeAvgPeriodUF_OLS;
import com.acurian.selenium.pages.OLS.UF_4384.WhichOfFollowingDoYouTypicallyExperienceUF_OLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;


public class UF_4384_OLS extends BaseTest {

    @Test(enabled = false)
    @TestCaseId("00022")
    @Description("UF_4384_OLS")
    public void uf_4384_OLS() {
        String phoneNumber = "AUTAMS1UF1";
        String protocol1 = "MVT_601_3001";
        String protocol2 = "MVT_601_3002";
        String studyName = "a uterine fibroids";
        String studyName1 = "uterine fibroids";
        String siteIndication = "Uterine Fibroids";
        String siteName = "AUT_UF_4384";
        String zipCode = "19044";

        String env = System.getProperty("acurian.env", "STG");


        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
//        dateOfBirthPageOLS
//                .openPage(env, phoneNumber)
//                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getQuestionText(), dateOfBirthPageOLS.titleExpected, "Question is diff");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleUF_4384_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091982")
                .clickNextButton(new ZipCodePageOLS());

        //---------------ZIP-CODE Question-------------------
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        //DiagnosedWithGynecologicalConditionOLS diagnosedWithGynecologicalConditionOLS = genderPageOLS
        FollowingGynecologicalConditionOLS followingGynecologicalConditionOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new FollowingGynecologicalConditionOLS());


        DebugPageOLS debugPageOLS = new DebugPageOLS();

        //---------------Q2 Has a healthcare professional ever diagnosed you with any of the following gynecological or women's health conditions? -------------------
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = followingGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Has a healthcare professional ever diagnosed you with any of the following women's health conditions...", protocol1, protocol2)
                .back();
        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = followingGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("Uterine fibroids, also known as leiomyomas or myomas")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());

        //---------------Q3 Have you gone through menopause?-------------------
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouGoneThroughMenopauseOLS.getTitleText(), haveYouGoneThroughMenopauseOLS.titleExpected, "Title is diff");
        //----DQ if selected any option other than None of the above-----------
        HaveYouHadHysterectomyOLS haveYouHadHysterectomyOLS = haveYouGoneThroughMenopauseOLS
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickNextButton(new HaveYouHadHysterectomyOLS());
        haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1, protocol2)
                .back();
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                .clickNextButton(new HaveYouHadHysterectomyOLS());
        haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1, protocol2)
                .back();
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                .clickNextButton(new HaveYouHadHysterectomyOLS());
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1, protocol2)
                .back();
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouHadHysterectomyOLS());


        //---------------Q4 Have you had a hysterectomy (surgical removal of the uterus)?-------------------
        haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(haveYouHadHysterectomyOLS.titleExpected, protocol1, protocol2)
                .back();
        PlzDescribeYourMenstrualCyclesOLS plzDescribeYourMenstrualCyclesOLS = haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PlzDescribeYourMenstrualCyclesOLS());


        //---------------Q5 - Please describe your menstrual cycles:-------------------
        plzDescribeYourMenstrualCyclesOLS
                .waitForPageLoad();
        HowWouldYouDescribeAvgPeriodUF_OLS howWouldYouDescribeAvgPeriodUF_OLS = plzDescribeYourMenstrualCyclesOLS
                .clickOnAnswer("Never regular")
                .clickNextButton(new HowWouldYouDescribeAvgPeriodUF_OLS());
        howWouldYouDescribeAvgPeriodUF_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Please describe your menstrual cycles:", protocol1, protocol2)
                .back();
        plzDescribeYourMenstrualCyclesOLS
                .waitForPageLoad()
                .clickOnAnswer("Always regular")
                .clickNextButton(new HowWouldYouDescribeAvgPeriodUF_OLS());


        //---------------Q6 How would you describe the average flow of your period?-------------------
        howWouldYouDescribeAvgPeriodUF_OLS
                .waitForPageLoad();
        Assert.assertEquals(howWouldYouDescribeAvgPeriodUF_OLS.getTitleText(), howWouldYouDescribeAvgPeriodUF_OLS.titleExpected, "Title is diff");
        WhichOfFollowingDoYouTypicallyExperienceUF_OLS whichOfFollowingDoYouTypicallyExperienceUF_OLS = howWouldYouDescribeAvgPeriodUF_OLS
                .clickOnAnswer("Very light")
                .clickNextButton(new WhichOfFollowingDoYouTypicallyExperienceUF_OLS());
        whichOfFollowingDoYouTypicallyExperienceUF_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(howWouldYouDescribeAvgPeriodUF_OLS.titleExpected, protocol1, protocol2)
                .back();
        howWouldYouDescribeAvgPeriodUF_OLS
                .waitForPageLoad()
                .clickOnAnswer("Very heavy")
                .clickNextButton(new WhichOfFollowingDoYouTypicallyExperienceUF_OLS());


        //---------------Q7 Which of the following do you typically experience during your period? -------------------
        whichOfFollowingDoYouTypicallyExperienceUF_OLS
                .waitForPageLoad();
        Assert.assertEquals(whichOfFollowingDoYouTypicallyExperienceUF_OLS.getTitleText(), whichOfFollowingDoYouTypicallyExperienceUF_OLS.titleExpected, "Title is diff");
        HaveYouHadSurgicalProcedurePast6MonthsUF_OLS haveYouHadSurgicalProcedurePast6MonthsUF_OLS = whichOfFollowingDoYouTypicallyExperienceUF_OLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouHadSurgicalProcedurePast6MonthsUF_OLS());
        haveYouHadSurgicalProcedurePast6MonthsUF_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Heavy menstrual bleeding often affects a woman's quality of life.Which of the following do you typic...", protocol1, protocol2)
                .back();
        whichOfFollowingDoYouTypicallyExperienceUF_OLS
                .waitForPageLoad()
                .clickOnAnswers("Missing work, school, or social activities")
                .clickNextButton(new HaveYouHadSurgicalProcedurePast6MonthsUF_OLS());


        //---------------Q8 Have you had a surgical procedure to treat your uterine fibroids in the past 6 months?-------------------
        haveYouHadSurgicalProcedurePast6MonthsUF_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouHadSurgicalProcedurePast6MonthsUF_OLS.getTitleText(), haveYouHadSurgicalProcedurePast6MonthsUF_OLS.titleExpected, "Title is diff");
        DiagnosedWithGynecologicalConditionOLS diagnosedWithGynecologicalConditionOLS = haveYouHadSurgicalProcedurePast6MonthsUF_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new DiagnosedWithGynecologicalConditionOLS());
        diagnosedWithGynecologicalConditionOLS.waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Have you had a surgical procedure to treat your uterine fibroids in the past 6 months?This surgery m...", protocol1, protocol2)
                .back();
        haveYouHadSurgicalProcedurePast6MonthsUF_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedWithGynecologicalConditionOLS());


        //---------------Q9 Has a healthcare professional ever diagnosed you with any of these other women's health conditions? -------------------
        diagnosedWithGynecologicalConditionOLS
                .waitForPageLoad();
        AreYouCurrentlyPregnantOLS areYouCurrentlyPregnantOLS = diagnosedWithGynecologicalConditionOLS
                .clickOnAnswers("Uterine polyps, also known as endometrial polyps",
                        "Cervical polyps",
                        "Ovarian cyst that is currently causing symptoms",
                        "Endometrioma, also known as endometrial or endometrioid cyst or \"chocolate cyst\"")
                .clickNextButton(new AreYouCurrentlyPregnantOLS());
        areYouCurrentlyPregnantOLS
                .waitForPageLoad()
                //.getPage(debugPageCC)
                //.checkProtocolsEquals("Has a healthcare professional ever diagnosed you with any of these other gynecological or women's he...", protocol1, protocol2)
                .back();
        diagnosedWithGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouCurrentlyPregnantOLS());


        //---------------Q10 Are you currently pregnant, breastfeeding or planning to become pregnant in the next year?------------------
        areYouCurrentlyPregnantOLS
                .waitForPageLoad();
        //HasHealthcareProfessionalPageOLS hasHealthcareProfessionalPageOLS = areYouCurrentlyPregnantUF_CC
        areYouCurrentlyPregnantOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals(areYouCurrentlyPregnantOLS.titleExpected, protocol1, protocol2)
                .back();
        areYouCurrentlyPregnantOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


        //----------*******NEW GENERAL HEALTH Questions********----------     
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                //----------Q23 - Do any of the following additional diagnoses apply to you?--------
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS())
                //----------ProvideHeight-Weight Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
//        .clickNextButton(new ChildrenUnderPageOLS())
//		//----------ChildrenUnderTheAge Page--------------------
//        .waitForPageLoad()
//        .clickOnAnswer("Yes")
//        .clickNextButton(new HouseholdHavePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("None of the above")
//        .clickNextButton(new TheStudySitePageOLS())
//        .waitForPageLoad()
//		//-------------------PEDIATRIC QUESTIONS-----------------------------
//        .clickOnAnswer("Public transportation")
//        .clickNextButton(new WhatMedicalCoveragePageOLS())
//        .waitForPageLoad()
//        .clickOnAnswers("No, I have no coverage")
                .clickNextButton(new EthnicBackgroundPageOLS())
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                //----------SiteSelection Page--------------------
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new HSGeneralPageOLS())
                .waitForPageLoad(siteIndication)
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature()
                //------------HUMAN API Interface in HelloSign----------------
                /*.getPage(new HumanAPIOLS())
                .waitForPageLoad()
                .connectBTN()
                .switchToAPI()
                .waitForProvider()
                .clickANY()
                .waitSearchAll()
                .search("cleveland clinic")
                .waitProvider()
                .clickProvider()
                .typeUserName("democlinical@gmail.com")
                .typePWD("password")
                .clickConnect()*/

                .waitToClickNext()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}