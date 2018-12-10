package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.END_4385.*;
import com.acurian.selenium.pages.OLS.Vaccine_4556.AreYouInterestedInPneumoniaVaccineStudyOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class END_4385_OLS extends BaseTest {

    @Test
    @Description("a cluster headache study 3237 - OLS")
    public void end_4385_OLS() {

        String phoneNumberRA = "AUTAMS1END";
        String protocol1 = "MVT_601_3101";
        String protocol2 = "MVT_601_3102";
        String studyName = "an endometriosis";
        String siteName = "AUT_END_4385";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumberRA)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleEND_Expected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("10/10/1980")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode("19044")
                .clickNextButton(new GenderPageOLS());

        FollowingGynecologicalConditionOLS followingGynecologicalConditionOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new FollowingGynecologicalConditionOLS());

        DebugPageOLS debugPageOLS = new DebugPageOLS();

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = followingGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Has a healthcare professional ever diagnosed you with any of the following women's health conditions...", protocol1, protocol2)
                .back();
        DiagnoseYourEndometriosisOLS diagnoseYourEndometriosisOLS = followingGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("Endometriosis")
                .clickNextButton(new DiagnoseYourEndometriosisOLS());

        //-------------------------Q3-When was your most recent surgery to treat or diagnose your endometriosis performed?---------------------------------------------
        HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .clickOnAnswer("11 or more years ago")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());
        haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("When was your most recent surgery to treat or diagnose your endometriosis performed?", protocol1, protocol2)
                .back();
        diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .clickOnAnswer("1 month ago or less")
                .clickNextButton(haveYouGoneThroughMenopauseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("When was your most recent surgery to treat or diagnose your endometriosis performed?", protocol1, protocol2)
                .back();
        diagnoseYourEndometriosisOLS
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 months ago")
                .clickNextButton(new HaveYouGoneThroughMenopauseOLS());

        //-------------------------Q4- Have you gone through menopause?---------------------------------------------
        HaveYouHadHysterectomyOLS haveYouHadHysterectomyOLS = haveYouGoneThroughMenopauseOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickNextButton(new HaveYouHadHysterectomyOLS());
        haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Menopause is the period in a woman's life in which menstruation stops permanently and she is no long...", protocol1, protocol2)
                .back();
        haveYouGoneThroughMenopauseOLS.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouHadHysterectomyOLS());


        //-------------------------Q5- Have you had a hysterectomy (surgical removal of the uterus)?----------------------------------------------
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1 = haveYouHadHysterectomyOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS1
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Have you had a hysterectomy (surgical removal of the uterus)?", protocol1, protocol2)
                .back();
        PlzDescribeYourMenstrualCyclesOLS plzDescribeYourMenstrualCyclesOLS = haveYouHadHysterectomyOLS
                .clickOnAnswer("No")
                .clickNextButton(new PlzDescribeYourMenstrualCyclesOLS());

        //-------------------------Q6- Please describe your menstrual cycles:-----------------------------
        ApproxHowManyDaysInYourMenstrualCycle_OLS approxHowManyDaysInYourMenstrualCycle_OLS = plzDescribeYourMenstrualCyclesOLS
                .waitForPageLoad()
                .clickOnAnswer("Never regular")
                .clickNextButton(new ApproxHowManyDaysInYourMenstrualCycle_OLS());


        //-------------------------new  Q7- Approximately how many days are in your menstrual cycle?-----------------------------
        HowManyTimesDidYouGetYourPeriodInThreeMons_OLS howManyTimesDidYouGetYourPeriodInThreeMons_OLS = approxHowManyDaysInYourMenstrualCycle_OLS
                .waitForPageLoad()
                .setDays("15")
                .clickNextButton(new HowManyTimesDidYouGetYourPeriodInThreeMons_OLS());

        //-------------------------new Q8- How many times did you get your period in the past three months?-----------------------------
        PelvicPainOLS pelvicPainOLS = howManyTimesDidYouGetYourPeriodInThreeMons_OLS
                .waitForPageLoad()
                .clickOnAnswer("Did not get period at all in the past 3 months")
                .clickNextButton(new PelvicPainOLS());


        //-------------Q9 - Do you experience pelvic pain during your menstrual period?-----------------
        PelvicPainOtherTimesOLS pelvicPainOtherTimesOLS = pelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new PelvicPainOtherTimesOLS());
        pelvicPainOtherTimesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Do you ever experience pelvic pain during your menstrual period?", protocol1, protocol2)
                .back();
        DescribesPelvicPainOLS describesPelvicPainOLS = pelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DescribesPelvicPainOLS());

        //---------------------"Q10 - Which of the following best describes the pelvic pain that you experience during your period, and how it affects your life?"---------
        describesPelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
                .clickNextButton(new PelvicPainOtherTimesOLS());

        //-----------------------Q11 - Do you experience pelvic pain at other times, when you do NOT have your period?------------
        DescribesNonMenstrualPelvicPainOLS describesNonMenstrualPelvicPainOLS = pelvicPainOtherTimesOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DescribesNonMenstrualPelvicPainOLS());

        //---------------------------Q12 - Which of the following best describes your pelvic pain at times when you do NOT have your period, and how it affects your life?--------
        HormonalBirthControlOLS hormonalBirthControlOLS = describesNonMenstrualPelvicPainOLS
                .waitForPageLoad()
                .clickOnAnswer("Mild - I have some pain, but I am still able to complete my daily activities")
                .clickNextButton(new HormonalBirthControlOLS());

        //-------------------------Q13 - Are you currently taking a hormonal form of birth control?----------
        //SurgicalProceduresOLS surgicalProceduresOLS = hormonalBirthControlOLS
        DiagnosedWithGynecologicalConditionOLS diagnosedWithGynecologicalConditionOLS = hormonalBirthControlOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new DiagnosedWithGynecologicalConditionOLS());
        //------------------R 50.1-----
        diagnosedWithGynecologicalConditionOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Ghost Question - Irregular Menstrual Cycle DQ Logic", protocol1, protocol2)
                .back();
        hormonalBirthControlOLS.waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new DiagnosedWithGynecologicalConditionOLS());


        //---------Q12 - Has a healthcare professional ever diagnosed you with any of these other gynecological or women's health conditions? ---
        AreYouCurrentlyPregnantOLS areYouCurrentlyPregnantOLS = diagnosedWithGynecologicalConditionOLS
                .waitForPageLoad()
                .clickOnAnswers("Vaginismus")
                .clickNextButton(new AreYouCurrentlyPregnantOLS());

        //-------------Q13 - Are you currently pregnant, breastfeeding or planning to become pregnant in the next year?-------
        areYouCurrentlyPregnantOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsEquals("Are you currently pregnant, breastfeeding or planning to become pregnant in the next year?", protocol1, protocol2)
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
                .clickNextButton(new AreYouInterestedInPneumoniaVaccineStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(siteName)
                .clickNextButton(new HSGeneralPageOLS())
                .waitForPageLoad("Endometriosis")
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature()

                //------------HUMAN API Interface in HelloSign----------------
                .getPage(new HumanAPIOLS())
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
                .clickConnect()

                .waitToClickNext()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}