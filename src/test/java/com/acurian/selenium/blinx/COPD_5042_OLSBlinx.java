package com.acurian.selenium.blinx;
import com.acurian.selenium.constants.Site;
import com.acurian.selenium.constants.Version;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.CCBlinxBeginning.AcurianHealthResearchStudyLine;
import com.acurian.selenium.pages.blinx.ams.CCBlinxBeginning.AdminPortalPage;
import com.acurian.selenium.pages.blinx.ams.CCBlinxBeginning.DnisPage;
import com.acurian.selenium.pages.blinx.ams.CCBlinxBeginning.LoginPage;
import com.acurian.selenium.pages.blinx.ams.chronic_cough.QuitSmokingOLS;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.copd.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.lowt_3017.EverSmokedCigarettesPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import com.acurian.utils.VersionGetter;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class COPD_5042_OLSBlinx extends BaseTest {

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_COPD_5042S_Site, Version.OLS},
//                {Site.AUT_COPD_5042S_Site, Version.CC},
                {Site.AUT_COPD_5042_Site, Version.OLS},
//                {Site.AUT_COPD_5042_Site, Version.CC}
        };
    }

    @Test(dataProvider = "sites")
    @Description("COPD_5042_OLS_A_S")
    public void copd5042ols(Site site, Version version) {
        String phoneNumber = "AUTAMSCOPD";
        String studyName = "a COPD study";
        String dnis = "3321.0";
        VersionGetter.setVersion(version.toString());
        String env = System.getProperty("acurian.env", "STG");
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DnisPage dnisPage = new DnisPage();

                //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        if(version == Version.CC) {
            LoginPage loginPage = new LoginPage();
            AdminPortalPage adminPortalPage = loginPage
                    .openPage(env)
                    .waitForPageLoad()
                    .setEmail()
                    .setPass()
                    .clickLogin(new AdminPortalPage());

            adminPortalPage
                    .waitForPageLoad()
                    .clickScreener(dnisPage);

            AcurianHealthResearchStudyLine acurianHealthResearchStudyLine = dnisPage
                    .waitForPageLoad()
                    .setDnis(dnis)
                    .clickBegin(new AcurianHealthResearchStudyLine());

            acurianHealthResearchStudyLine
                    .waitForPageLoad()
                    .clickOnAnswer("Learn more about matching to clinical trials");
        }

        if(version == Version.OLS) {
            dateOfBirthPageOLS
                    .openPage(env, phoneNumber);
        }

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .waitForPageLoad(studyName, "700")
                .clickOnAnswer("No")
                .getPage(new LessThan18YearsOldPageOLS());
        if(VersionGetter.getVersion().equals("CC")) { //maybe will not work. If so, simplify like ols
            dateOfBirthPageOLS
                    .clickNextButton(lessThan18YearsOldPageOLS);
        }

        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS);

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad(studyName, "700")
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());
        if(VersionGetter.getVersion().equals("CC")) {
            dateOfBirthPageOLS
                    .clickNextButton(zipCodePageOLS);
        }

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        debugPageOLS
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad();
        HasHealthcareProfessionalDiagnosedLungCondOLS hasHealthcareProfessionalDiagnosedLungCondOLS = genderPageOLS
                .setDate("09091978")
                .clickNextButton(new HasHealthcareProfessionalDiagnosedLungCondOLS());

        //ExperiencedAnyOfFollowingOLS experiencedAnyOfFollowing_OLS = hasHealthcareProfessionalDiagnosedLungCondOLS
        hasHealthcareProfessionalDiagnosedLungCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above");
        if (VersionGetter.getVersion().equals("CC")) {
            hasHealthcareProfessionalDiagnosedLungCondOLS
                    .clickNextButton(new NonQRtransitionPageCCBlinx())
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7402", site.activeProtocols)
                    .back(hasHealthcareProfessionalDiagnosedLungCondOLS);
        } else {
            hasHealthcareProfessionalDiagnosedLungCondOLS
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7402", site.activeProtocols)
                    .back(hasHealthcareProfessionalDiagnosedLungCondOLS);
        }
        hasHealthcareProfessionalDiagnosedLungCondOLS
                .waitForPageLoad();
        WhenWereYouDiagnosedWithCopdOLS whenWereYouDiagnosedWithCopdOLS = hasHealthcareProfessionalDiagnosedLungCondOLS
                .clickOnAnswers("COPD")//"Chronic bronchitis","Emphysema")
                .clickNextButton(new WhenWereYouDiagnosedWithCopdOLS());


        //------------WhenWereYouDiagnosedWithCopdOLS-------------------
        whenWereYouDiagnosedWithCopdOLS
                .waitForPageLoad();
        EverSmokedCigarettesPageOLS everSmokedCigarettesPageOLS = whenWereYouDiagnosedWithCopdOLS
                .clickOnAnswer("Less than 1 year ago")
                .clickNextButton(new EverSmokedCigarettesPageOLS());
        everSmokedCigarettesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7404", site.activeProtocols)
                .back(whenWereYouDiagnosedWithCopdOLS)
                .waitForPageLoad()
                .clickOnAnswer("More than 2 years ago")//"Chronic bronchitis","Emphysema")
                .clickNextButton(new EverSmokedCigarettesPageOLS());


        //-----------EverSmokedCigarettesPageOLS-----------------------
        SubquestionSmokedCigarettePageOLS subquestionSmokedCigarettePageOLS = everSmokedCigarettesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, I currently smoke")
                .clickNextButton(new SubquestionSmokedCigarettePageOLS());
        subquestionSmokedCigarettePageOLS
                .waitForPageLoadHaveYouBeenSmoking()
                .setFirst("15") //This page is mad. We have to put there some text to prevent idiotic crushes.
                .setSecond("15")
//                .back(everSmokedCigarettesPageOLS)
                .back(everSmokedCigarettesPageOLS);
        QuitSmokingOLS quitSmokingOLS = everSmokedCigarettesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("I used to smoke, but have since quit")//"Chronic bronchitis","Emphysema")
                .clickNextButton(new QuitSmokingOLS());


        //-----------QuitSmokingOLS-----------------------
        quitSmokingOLS
                .waitForPageLoad()
                .clickOnAnswer("I quit smoking within the past year")
                .clickNextButton(new SubquestionSmokedCigarettePageOLS());
        subquestionSmokedCigarettePageOLS
                .waitForPageLoadHaveYouBeenSmoking();
//                .waitForPageLoadDidYouSmoke();
        AreYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdOLS areYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdOLS = subquestionSmokedCigarettePageOLS
                .setFirst("15")  //---10 for DQ
                .setSecond("15")
                .clickNextButton(new AreYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdOLS());


        //------------AreYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdOLS--------
        InThePastYearHowManyUrgentMedicalforCopdOLS inThePastYearHowManyUrgentMedicalforCopdOLS = areYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new InThePastYearHowManyUrgentMedicalforCopdOLS());
        inThePastYearHowManyUrgentMedicalforCopdOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7409", site.activeProtocols)
                .back(areYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdOLS)
                .waitForPageLoad();
        WhichFollowingInhalersdoYouUseCopdOLS whichFollowingInhalersdoYouUseCopdOLS =
                areYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdOLS
                        .clickOnAnswer("Yes")
                        .clickNextButton(new WhichFollowingInhalersdoYouUseCopdOLS());

        whichFollowingInhalersdoYouUseCopdOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InThePastYearHowManyUrgentMedicalforCopdOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7410", site.activeProtocols)
                .back(whichFollowingInhalersdoYouUseCopdOLS)
                .waitForPageLoad()
                .clickOnAnswers("Asmanex or Asmanex HFA", "Bevespi Aerosphere")
                .clickNextButton(new InThePastYearHowManyUrgentMedicalforCopdOLS());


        //------------InThePastYearHowManyUrgentMedicalforCopdOLS---------
        HaveYouEverHadFollowingLungSurgeriesOLS haveYouEverHadFollowingLungSurgeriesOLS =
                inThePastYearHowManyUrgentMedicalforCopdOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Twice")
                        .clickNextButton(new HaveYouEverHadFollowingLungSurgeriesOLS());

        //------------HaveYouEverHadFollowingLungSurgeriesOLS---------
        WhenDidYouHaveYourMostRecentLungSurgeryOLS whenDidYouHaveYourMostRecentLungSurgeryOLS =
                haveYouEverHadFollowingLungSurgeriesOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Removal of a whole lung", "Lung transplant")
                        .clickNextButton(new WhenDidYouHaveYourMostRecentLungSurgeryOLS());
        whenDidYouHaveYourMostRecentLungSurgeryOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7412", site.activeProtocols)
                .back(haveYouEverHadFollowingLungSurgeriesOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Removal of a lobe of your lung (lobectomy)")
                .clickNextButton(new WhenDidYouHaveYourMostRecentLungSurgeryOLS());


        //------13 When did you have your most recent lung surgery?---------
        //ApproximateHeightPageOLS approximateHeightPageOLS = whenDidYouHaveYourMostRecentLungSurgeryOLS
        whenDidYouHaveYourMostRecentLungSurgeryOLS
                .waitForPageLoad()
                .clickOnAnswer("6 months ago or less");
        if (VersionGetter.getVersion().equals("CC")) {
            whenDidYouHaveYourMostRecentLungSurgeryOLS
                    .clickNextButton(new TransitionStatementCCBlinx())
                    .waitForPageLoadCOPD()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7413", site.activeProtocols)
                    .back(whenDidYouHaveYourMostRecentLungSurgeryOLS);
        } else {
            whenDidYouHaveYourMostRecentLungSurgeryOLS
                    .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7413", site.activeProtocols)
                    .back(whenDidYouHaveYourMostRecentLungSurgeryOLS);
        }
        whenDidYouHaveYourMostRecentLungSurgeryOLS
                .waitForPageLoad()
                .clickOnAnswer("1 year ago or more");
        if (VersionGetter.getVersion().equals("CC")) {
            whenDidYouHaveYourMostRecentLungSurgeryOLS
                    .clickNextButton(new TransitionStatementCCBlinx())
                    .waitForPageLoadCOPD();
        }
        whenDidYouHaveYourMostRecentLungSurgeryOLS
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


//General_Health
        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        //HaveYouEverExperiencedHeartRelatedMedicalCondOLS haveYouEverExperiencedHeartRelatedMedicalCondOLS = otherThanSkinCancerPageOLS
        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS =
                whenDiagnosedWithCancerOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Within the past 5 years")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerOLS);
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());


        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad();
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                        .clickOnAnswers("Unsure which type of liver disease")
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad();
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        LetMeSeePageCCBlinx letMeSeePageCCBlinx = new LetMeSeePageCCBlinx();

        //AboutHealthPageOLS aboutHealthPageOLS = approximateHeightPageOLS
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "250");

        if (VersionGetter.getVersion().equals("CC")) {
            approximateHeightPageOLS
                    .clickNextButton(letMeSeePageCCBlinx)
                    .waitForPageLoad();
        }
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());


        //----------PII (IdentificationPageOLS) Page--------------------
        identificationPageOLS
                .waitForPageLoad2();
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999")
                .clickNextButton(new SiteSelectionPageOLS());
        MedicalRecordsOptionPageOLS medicalRecordsOptionPageOLS = siteSelectionPageOLS
                .waitForPageLoad(studyName + "!")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS());
        medicalRecordsOptionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records");

        AboutHealthPageOLS aboutHealthPageOLS = new AboutHealthPageOLS();

        if (VersionGetter.getVersion().equals("CC")) {
            medicalRecordsOptionPageOLS
                    .clickNextButton(new DoctorInformationCollectionPageOLS())
                    .waitForPageLoad()
                    .clickNextButton(new SynexusRadiantDirectScheduleCCBlinx())
                    .waitForPageLoadSyn()
                    .assertVariables("Acurian", "Trial", "09/09/1941", "US",
                            "Cape May, NJ", site.zipCode, "qa.acurian@gmail.com", "999 -999-9999",
                            "AUT_5042S", "AUT_AMS1_5042S_site", "GSKPPDCOP657")
                    .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                    .clickNextButton(dnisPage)
                    .waitForPageLoad();
        } else {
            medicalRecordsOptionPageOLS
                    .clickNextButton(new HSGeneralPageOLS());
            DoctorInformationCollectionPageOLS doctorInformationCollectionPageOLS = new DoctorInformationCollectionPageOLS();

            HS1PageOLS hs1PageOLS = doctorInformationCollectionPageOLS
                    .waitForPageLoad()
                    .clickNextButton(new HS1PageOLS());

            hs1PageOLS
                    .waitForPageLoad()
                    .clickOkInPopUp()
                    .setSignature();
            ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
            thankYouCloseSimplePageOLS
                    .waitForPageLoad()
                    .clickNextButton(new AboutHealthPageOLS())
                    .waitForPageLoad();
        }
        if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .dispoShouldMatch(site.dispo, site.dispo);
            switch (site) {
                case AUT_COPD_5042_Site: //1R
                    aboutHealthPageOLS
                            .assertGeneratedFul(env, site);
                    break;
                case AUT_COPD_5042S_Site: //41C
                    aboutHealthPageOLS
                            .getRadiantDbToLog(env)
                            .getAnomalyDbToLog(env);
            }
        }
    }
}
