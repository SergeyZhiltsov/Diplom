package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.AST_4337.SubquestionSmokedCigarettePageCC;
import com.acurian.selenium.pages.CC.AS_4319.YouBeenDiagnosedWithCC;
import com.acurian.selenium.pages.CC.COPD_5042.*;
import com.acurian.selenium.pages.CC.ChronicCough.QuitSmokingCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WithType2DiabetesPageCC;
import com.acurian.selenium.pages.CC.LOWT.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.cv_study.CholesterolTriglyceridesLipidsPageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


public class COPD_5042_CC extends BaseTest {

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
        return new Object[][] {
                {Site.AUT_COPD_5042S_Site},
                {Site.AUT_COPD_5042_Site}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
    @Description("COPD_5042_CC_A_S")
    public void copdCC(Site site) {
        String phoneNumber = "AUTAMSCOPD";
        String protocol1 = "208657";
        String protocol2 = "M16_100_S";
        String kowaProtocolA = "208657";
        String kowaProtocolS = "K_877_302_S";
        String studyName = "a COPD study";
        String site_Indication = "a COPD";

        String env = System.getProperty("acurian.env", "STG");


        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),
                "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(),
                callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle
                ("a COPD study", "700"), "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();

        DebugPageCC debugPageCC = new DebugPageCC();

        //PersonaQuestionsCC personaQuestionsCC = genderPageCC
        HasHealthcareProfessionalDiagnosedLungCondCC hasHealthcareProfessionalDiagnosedLungCondCC = genderPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1941")
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalDiagnosedLungCondCC());

        //ExperiencedAnyOfFollowingCC experiencedAnyOfFollowing_CC = hasHealthcareProfessionalDiagnosedLungCondCC
        hasHealthcareProfessionalDiagnosedLungCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0021125-QS7402-STUDYQUES", site.activeProtocols)
                .back(hasHealthcareProfessionalDiagnosedLungCondCC)
                .waitForPageLoad();
        WhenWereYouDiagnosedWithCopdCC whenWereYouDiagnosedWithCopdCC = hasHealthcareProfessionalDiagnosedLungCondCC
                .clickOnAnswers("COPD")//"Chronic bronchitis","Emphysema")
                .clickNextButton(new WhenWereYouDiagnosedWithCopdCC());


        //------------WhenWereYouDiagnosedWithCopdCC-------------------
        whenWereYouDiagnosedWithCopdCC
                .waitForPageLoad();
        EverSmokedCigarettesPageCC everSmokedCigarettesPageCC = whenWereYouDiagnosedWithCopdCC
                .clickOnAnswer("Less than 1 year ago")
                .clickNextButton(new EverSmokedCigarettesPageCC());
        everSmokedCigarettesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7404", site.activeProtocols)
                .back(whenWereYouDiagnosedWithCopdCC)
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")//"Chronic bronchitis","Emphysema")
                .clickNextButton(new EverSmokedCigarettesPageCC());


        //-----------EverSmokedCigarettesPageCC-----------------------
        SubquestionSmokedCigarettePageCC subquestionSmokedCigarettePageCC = everSmokedCigarettesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes, I currently smoke")
                .clickNextButton(new SubquestionSmokedCigarettePageCC());
        subquestionSmokedCigarettePageCC
                .waitForPageLoad(1,"How many years have you been smoking cigarettes?")
                .back(everSmokedCigarettesPageCC)
                .waitForPageLoad();
        QuitSmokingCC quitSmokingCC = everSmokedCigarettesPageCC
                .clickOnAnswer("I used to smoke, but have since quit")//"Chronic bronchitis","Emphysema")
                .clickNextButton(new QuitSmokingCC());


        //-----------QuitSmokingCC-----------------------
        quitSmokingCC
                .waitForPageLoad()
                .clickOnAnswer("I quit smoking within the past year")
                .clickNextButton(new SubquestionSmokedCigarettePageCC());
        subquestionSmokedCigarettePageCC
                .waitForPageLoad(1,"How many years did you smoke cigarettes?")
                .waitForPageLoad(2,"About how many cigarettes per day did you smoke?");
        AreYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdCC areYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdCC = subquestionSmokedCigarettePageCC
                .setFirst("15")  //---10 for DQ
                .setSecond("15")
                .clickNextButton(new AreYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdCC());


        //------------AreYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdCC--------
        InThePastYearHowManyUrgentMedicalforCopdCC inThePastYearHowManyUrgentMedicalforCopdCC = areYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new InThePastYearHowManyUrgentMedicalforCopdCC());
        inThePastYearHowManyUrgentMedicalforCopdCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7409", site.activeProtocols)
                .back(areYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdCC)
                .waitForPageLoad();
        WhichFollowingInhalersdoYouUseCopdCC whichFollowingInhalersdoYouUseCopdCC = areYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdCC
                .clickOnAnswer("Yes")
                .clickNextButton(new WhichFollowingInhalersdoYouUseCopdCC());

        whichFollowingInhalersdoYouUseCopdCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InThePastYearHowManyUrgentMedicalforCopdCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7410", site.activeProtocols)
                .back(whichFollowingInhalersdoYouUseCopdCC)
                .waitForPageLoad()
                .clickOnAnswers("Asmanex or Asmanex HFA","Bevespi Aerosphere")
                .clickNextButton(new InThePastYearHowManyUrgentMedicalforCopdCC());


        //------------InThePastYearHowManyUrgentMedicalforCopdCC---------
        HaveYouEverHadFollowingLungSurgeriesCC haveYouEverHadFollowingLungSurgeriesCC = inThePastYearHowManyUrgentMedicalforCopdCC
                .waitForPageLoad()
                .clickOnAnswer("None")
                .clickNextButton(new HaveYouEverHadFollowingLungSurgeriesCC());
        haveYouEverHadFollowingLungSurgeriesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7411", site.activeProtocols)
                .back(inThePastYearHowManyUrgentMedicalforCopdCC)
                .waitForPageLoad()
                .clickOnAnswer("Twice")
                .clickNextButton(new HaveYouEverHadFollowingLungSurgeriesCC());


        //------------HaveYouEverHadFollowingLungSurgeriesCC---------
        WhenDidYouHaveYourMostRecentLungSurgeryCC whenDidYouHaveYourMostRecentLungSurgeryCC = haveYouEverHadFollowingLungSurgeriesCC
                .waitForPageLoad()
                .clickOnAnswers("Removal of a whole lung","Lung transplant")
                .clickNextButton(new WhenDidYouHaveYourMostRecentLungSurgeryCC());
        whenDidYouHaveYourMostRecentLungSurgeryCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7412", site.activeProtocols)
                .back(haveYouEverHadFollowingLungSurgeriesCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Removal of a lobe of your lung (lobectomy)")
                .clickNextButton(new WhenDidYouHaveYourMostRecentLungSurgeryCC());


        //------13 When did you have your most recent lung surgery?---------
        TransitionStatementCC transitionStatementCC = whenDidYouHaveYourMostRecentLungSurgeryCC
                .waitForPageLoad()
                .clickOnAnswer("6 months ago or less")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadWithTitle(transitionStatementCC.titleCOPDExpected)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7413", site.activeProtocols)
                .back(whenDidYouHaveYourMostRecentLungSurgeryCC)
                .waitForPageLoad()
                .clickOnAnswer("1 year ago or more")
                .clickNextButton(transitionStatementCC);

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithTitle(transitionStatementCC.titleCOPDExpected)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


//-----------------------General_Health--------------------------
        OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers(//"Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Cancer",
                        // "Kidney disease",
                        //"Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                //"Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new OtherThanSkinCancerPageCC());

        //HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = otherThanSkinCancerPageCC
        YouBeenDiagnosedWithCC youBeenDiagnosedWithCC = otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new YouBeenDiagnosedWithCC());
        youBeenDiagnosedWithCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back();
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(new YouBeenDiagnosedWithCC());


        youBeenDiagnosedWithCC
                .waitForPageLoad();
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = youBeenDiagnosedWithCC
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());


        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad();
        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);


        //AboutHealthPageCC aboutHealthPageCC = approximateHeightPageCC
        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "250")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad();
        IdentificationPageCC identificationPageCC = approximateHeightPageCC
                .clickNextButton(new IdentificationPageCC());


        //----------PII (IdentificationPageCC) Page--------------------
        identificationPageCC
                .waitForPageLoad();
        SiteSelectionPageCC selectionPageCC = identificationPageCC
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC());
        selectionPageCC
                .waitForPageLoad(studyName)
                .getPID();
        switch (site) {
            case AUT_COPD_5042S_Site: //41C
                selectionPageCC
                        .clickOnAnswer(site.name)
//                        .clickNextButton(new HSGeneralCC())
//                        .waitForPageLoad(siteIndication)
                        .clickNextButton(new MedicalRecordsOptionPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("Continue with medical records")
                        .clickNextButton(new DoctorInformationCollectionPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new HSMedicalRecordsPageCC())
                        .waitForPageLoad()
                        .clickNextButton(new SynexusRadiantDirectScheduleCC())
                        .waitForPageLoadSyn()
                        .assertVariables("Acurian", "Trial", "09/09/1941", "US",
                            "Cape May, NJ", site.zipCode, "qa.acurian@gmail.com", "999 -999-9999",
                            "AUT_5042S", "AUT_AMS1_5042S_site", "GSKPPDCOP657")
                        .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .childPidFromDbToLog(env, "5042")
                        .dispoShouldMatch(site.dispo, site.dispo);

                break;
            case AUT_COPD_5042_Site:
                selectionPageCC
                        .clickOnAnswer(site.name)
//                        .clickNextButton(new HSGeneralCC())
//                        .waitForPageLoad(siteIndication)
                        .clickNextButton(new MedicalRecordsOptionPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("Continue without medical records")
                     /*   .clickNextButton(new QualifiedClose2PageCC())
                        .waitForPageLoad()
//                        .clickNextButton(new HSMedicalRecordsPageCC())
//                        .waitForPageLoad()*/
                        .clickNextButton(new SynexusHealthyMindsPageCC())
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new ThankYouCloseSimplePageCC())
                        .waitForPageLoad()
                        .clickNextButton(selectActionPageCC)
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env, "5042")
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}