package com.acurian.selenium.tests.OLS.no_indication;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.ChronicCough.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class NoIndication4471_OLS extends BaseTest {

    @Test(enabled = false)
    @TestCaseId("00034")
    @Description("No Indication 4471 OLS")
    public void chronicCough_4471_OLS_NI() {
        String phoneNumber = "AUTAMS1GEN";
        String protocol1 = "MK_7264_027";
        String protocol2 = "MK_7264_030";
        List<String> protocols = Arrays.asList(protocol1, protocol2);
        String studyName = "a chronic cough study";
        String siteName = "AUT_MCC";
        String debugSiteName = "";
        String zipCode = "19341";

        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
//        dateOfBirthPageOLS
//                .openPage(env, phoneNumber)
//                .waitForPageLoad();
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGH(), dateOfBirthPageOLS.titleGHExpected, "Title is diff");
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad();
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Autism spectrum",
                        "High cholesterol, triglycerides, or lipids",
                        "Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38",protocol1,protocol2)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38",protocol1,protocol2)
                .back();
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", protocol1, protocol2)
                .back();
        WhichOfTheFollowingBreathingLungPageOLS whichOfTheFollowingBreathingLungPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhichOfTheFollowingBreathingLungPageOLS());

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = whichOfTheFollowingBreathingLungPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Asthma")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS41", protocol1, protocol2)
                .back();
        whichOfTheFollowingBreathingLungPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(whenDiagnosedWithCancerOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS41", protocol1, protocol2)
                .back();
        whichOfTheFollowingBreathingLungPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Chronic bronchitis")
                .clickNextButton(whenDiagnosedWithCancerOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS41", protocol1, protocol2)
                .back();
        whichOfTheFollowingBreathingLungPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Chronic cough")
                .clickNextButton(whenDiagnosedWithCancerOLS);

        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocol1, protocol2)
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", protocol1, protocol2)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", protocol1, protocol2)
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);

        FollowingMentalEmotionalHealthPageOLS following_mentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", protocol1, protocol2)
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(following_mentalEmotionalHealthPageOLS);

        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", protocol1, protocol2)
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", protocol1, protocol2)
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .back();
        following_mentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back();
        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .back();
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back();
        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .back();
        whichOfTheFollowingBreathingLungPageOLS
                .waitForPageLoad()
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                .clickNextButton(whichOfTheFollowingBreathingLungPageOLS)
                .waitForPageLoad()
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS61", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);

        HowLongYouHadChronicCoughOLS howLongYouHadChronicCoughOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new HowLongYouHadChronicCoughOLS());



        TreatingYourChronicCoughOLS treatingYourChronicCoughOLS = howLongYouHadChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 6 months")
                .clickNextButton(new TreatingYourChronicCoughOLS());
        treatingYourChronicCoughOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6203", protocol1, protocol2)
                .back();
        howLongYouHadChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswer("6 to 11 months")
                .clickNextButton(treatingYourChronicCoughOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6203", protocol1, protocol2)
                .back();
        howLongYouHadChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswer("1 year or longer")
                .clickNextButton(treatingYourChronicCoughOLS);

        HaveYouSmokedCigarettesOLS haveYouSmokedCigarettesOLS = treatingYourChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswers("No, have not treated")
                .clickNextButton(new HaveYouSmokedCigarettesOLS());
        haveYouSmokedCigarettesOLS
                .waitForPageLoadNew()
                .back();
        DoYouStillHaveCoughOLS doYouStillHaveCoughOLS = treatingYourChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswers("Yes, with prescription", "Yes, with over the counter")
                .clickNextButton(new DoYouStillHaveCoughOLS());

        doYouStillHaveCoughOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouSmokedCigarettesOLS);

        EverDiagnosedWithFollowingConditionsOLS everDiagnosedWithFollowingConditionsOLS = haveYouSmokedCigarettesOLS
                .waitForPageLoadNew()
                .clickOnAnswers("No, I never smoked")
                .clickNextButton(new EverDiagnosedWithFollowingConditionsOLS())
                .waitForPageLoad();
        everDiagnosedWithFollowingConditionsOLS.back();

        HowManyCigarettesOLS howManyCigarettesOLS = haveYouSmokedCigarettesOLS
                .waitForPageLoadNew()
                .clickOnAnswers("Yes, I currently smoke")
                .clickNextButton(new HowManyCigarettesOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6206", protocol1, protocol2);
        debugPageOLS.back();

        QuitSmokingOLS quitSmokingOLS = haveYouSmokedCigarettesOLS
                .waitForPageLoadNew()
                .clickOnAnswers("I used to smoke, but have since quit")
                .clickNextButton(new QuitSmokingOLS());

        quitSmokingOLS
                .waitForPageLoad()
                .clickOnAnswer("I quit smoking within the past year")
                .clickNextButton(new HowManyCigarettesOLS())
                .waitForPageLoad1();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6207", protocol1, protocol2);
        debugPageOLS.back();
        quitSmokingOLS
                .waitForPageLoad()
                .clickOnAnswer("I quit smoking more than a year ago")
                .clickNextButton(new HowManyCigarettesOLS());

        howManyCigarettesOLS
                .waitForPageLoad1()
                .enterYears("20")
                .howManyCigarettes("21")
                .clickNextButton(new EverDiagnosedWithFollowingConditionsOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6209", protocol1, protocol2);
        debugPageOLS.back();
        howManyCigarettesOLS
                .waitForPageLoad1()
                .enterYears("15")
                .clickNextButton(new EverDiagnosedWithFollowingConditionsOLS());

        ACEInhibitorsOLS aCEInhibitorsOLS = everDiagnosedWithFollowingConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("Post-Nasal Drip (Upper Airway Cough Syndrome)", "Lung Cancer", "Tuberculosis (TB)")
                .clickNextButton(new ACEInhibitorsOLS())
                .waitForPageLoad();
        aCEInhibitorsOLS.back();
        everDiagnosedWithFollowingConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ACEInhibitorsOLS());

        ExperienceWithYourChronicCoughOLS experienceWithYourChronicCoughOLS = aCEInhibitorsOLS
                .waitForPageLoad()
                .clickOnAnswers("Benazepril (Brand name: Lotensin)", "Captopril (Brand name: Capoten)", "Cilazapril (Brand name: Inhibace)", "Enalapril (Brand names: Vasotec, Renitec, Berlipril, Enap, Enapren)")
                .clickOnAnswers("Fosinopril (Brand names: Fositen, Monopril)", "Imidapril (Brand name: Tanatril)", "Lisinopril (Brand names: Listril, Lopril, Novatec, Prinivil, Zestril, Lisidigal)")
                .clickOnAnswers("Perindopril (Brand names: Coversyl, Coversum, Aceon)", "Quinapril (Brand name: Accupril)", "Ramipril (Brand names: Altace, Prilace, Ramace, Ramiwin, Triatec, Tritace)")
                .clickOnAnswers("Trandolapril ( Brand names: Mavik, Odrik, Gopten)", "Zofenopril (Brand names: Zofenil, Bifril, Zopranol)")
                .clickNextButton(new ExperienceWithYourChronicCoughOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6211", protocol1, protocol2);
        debugPageOLS.back();
        aCEInhibitorsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ExperienceWithYourChronicCoughOLS());

        SymptomsGetBetterOLS symptomsGetBetterOLS = experienceWithYourChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswers("A runny or stuffy nose", "Frequent throat clearing and sore throat", "Hoarseness", "Coughing up blood", "Heartburn or a sour taste in your mouth")
                .clickNextButton(new SymptomsGetBetterOLS());

        ChildrenUnderPageOLS childrenUnderPageOLS = symptomsGetBetterOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ChildrenUnderPageOLS());

        childrenUnderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageOLS())
                .waitForPageLoad()
                //-------------------PEDIATRIC QUESTIONS-----------------------------
                .clickOnAnswer("Public transportation")
                .clickNextButton(new WhatMedicalCoveragePageOLS())
                .waitForPageLoad()
                .clickOnAnswers("No, I have no coverage")
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
                .waitForPageLoad("Chronic Cough")
                .clickNextButton(new MedicalRecordsOptionPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();

/*                .getPage(new HumanAPIOLS())
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
                .clickNextButton(new ThankYouCloseSimplePageOLS())*/

        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();
        thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
