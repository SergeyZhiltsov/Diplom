package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.AST_4337.SubquestionSmokedCigarettePageOLS;
import com.acurian.selenium.pages.OLS.COPD_5042.*;
import com.acurian.selenium.pages.OLS.ChronicCough.QuitSmokingOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.EverSmokedCigarettesPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class COPD_5042_OLS extends BaseTest {

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
                {Site.AUT_COPD_5042S_Site},
                {Site.AUT_COPD_5042_Site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("COPD_5042_OLS_A_S")
    public void copd5042ols(Site site) {
        String phoneNumber = "AUTAMSCOPD";
        String protocol1 = "208657";
        String protocol2 = "M16_100_S";
        String kowaProtocolA = "208657";
        String kowaProtocolS = "K_877_302_S";
        String studyName = "a COPD";
        String site_Indication = "low testosterone or hypogonadism";

        String env = System.getProperty("acurian.env", "STG");

        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a COPD study", "700");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                .getExpectedModifiedTitle("a COPD study", "700"), "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());


        //---------------ZIP-CODE Question-------------------
        zipCodePageOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        genderPageOLS
                .waitForPageLoad();
        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = genderPageOLS
                .setDate("09092005")
                .clickOnAnswer("Female")
                .clickNextButton(new LessThan18YearsOldPageOLS());


        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = genderPageOLS
                .setDate("09091980")
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
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7402", site.activeProtocols)
                .back(hasHealthcareProfessionalDiagnosedLungCondOLS)
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
                .waitForPageLoad(1, "How many years have you been smoking cigarettes?")
                .back(everSmokedCigarettesPageOLS)
                .waitForPageLoad();
        QuitSmokingOLS quitSmokingOLS = everSmokedCigarettesPageOLS
                .clickOnAnswer("I used to smoke, but have since quit")//"Chronic bronchitis","Emphysema")
                .clickNextButton(new QuitSmokingOLS());


        //-----------QuitSmokingOLS-----------------------
        quitSmokingOLS
                .waitForPageLoad()
                .clickOnAnswer("I quit smoking within the past year")
                .clickNextButton(new SubquestionSmokedCigarettePageOLS());
        subquestionSmokedCigarettePageOLS
                .waitForPageLoad(1, "How many years did you smoke cigarettes?")
                .waitForPageLoad(2, "About how many cigarettes per day did you smoke?");
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
//                .clickOnAnswer("None")
//                .clickNextButton(new HaveYouEverHadFollowingLungSurgeriesOLS());
//        haveYouEverHadFollowingLungSurgeriesOLS
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS7411", site.activeProtocols)
//                .back(inThePastYearHowManyUrgentMedicalforCopdOLS)
//                .waitForPageLoad()
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
                .clickOnAnswer("6 months ago or less")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7413", site.activeProtocols)
                .back(whenDidYouHaveYourMostRecentLungSurgeryOLS)
                .waitForPageLoad()
                .clickOnAnswer("1 year ago or more")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());


//General_Health
        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers(//"Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Cancer",
                        // "Kidney disease",
                        //"Heart or circulation problems (heart attack, heart failure, stroke)",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                //"Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
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
                .back();
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
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


        //AboutHealthPageOLS aboutHealthPageOLS = approximateHeightPageOLS
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "250")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS912", site.activeProtocols)
                .back(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS913", site.activeProtocols)
                .back(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());


        //----------PII (IdentificationPageOLS) Page--------------------
        identificationPageOLS
                .waitForPageLoad();
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .setAllFields("Acurian", "Trial", "", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());
        MedicalRecordsOptionPageOLS medicalRecordsOptionPageOLS = siteSelectionPageOLS
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS());
        HSGeneralPageOLS hsGeneralPageOLS = medicalRecordsOptionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new HSGeneralPageOLS());
        DoctorInformationCollectionPageOLS doctorInformationCollectionPageOLS = hsGeneralPageOLS
                .waitForPageLoadEmailNotProvided()
                .typeEmail("qa.acurian@gmail.com")
                .clickNextButton(new DoctorInformationCollectionPageOLS());
        HS1PageOLS hs1PageOLS = doctorInformationCollectionPageOLS
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS());
        hs1PageOLS
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();
//                .waitToClickNext();
        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        aboutHealthPageOLS
                .waitForPageLoad()
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