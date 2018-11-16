package com.acurian.selenium.tests.CC.no_indication;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ChronicCough.*;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class NoIndication4471_CC extends BaseTest {

    @Test(enabled = false, dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00034")
    @Description("No Indication 4471 CC")
    public void chronicCough_4471_CC_NI(final String username, final String password) {
        String phoneNumber = "AUTAMS1GEN";
        String protocol1 = "MK_7264_027";
        String protocol2 = "MK_7264_030";
        String studyName = "a chronic cough study";
        String siteName = "AUT_MCC";
        String zipCode  = "19341";

        String env = System.getProperty("acurian.env", "STG");


        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageGHLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleTextGH(), dateOfBirthPageCC.titleGHExpected, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Autism spectrum",
                        "High cholesterol, triglycerides, or lipids",
                        "Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        DebugPageCC debugPageCC = new DebugPageCC();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015111-QS38-STUDYQUES",protocol1,protocol2)
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015111-QS38-STUDYQUES",protocol1,protocol2)
                .back();
        KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new KidneyProblemsPage());
        kidneyProblemsPage
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015111-QS38-STUDYQUES", protocol1, protocol2)
                .back();
        WhichOfTheFollowingBreathingLungPageСС whichOfTheFollowingBreathingLungPageСС = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickNextButton(new WhichOfTheFollowingBreathingLungPageСС());

        OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = whichOfTheFollowingBreathingLungPageСС
                .waitForPageLoad()
                .clickOnAnswers("Asthma")
                .clickNextButton(new OtherThanSkinCancerPageCC());
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015113-QS41-STUDYQUES", protocol1, protocol2)
                .back();
        whichOfTheFollowingBreathingLungPageСС
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(otherThanSkinCancerPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015113-QS41-STUDYQUES", protocol1, protocol2)
                .back();
        whichOfTheFollowingBreathingLungPageСС
                .waitForPageLoad()
                .clickOnAnswers("Chronic bronchitis")
                .clickNextButton(otherThanSkinCancerPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015113-QS41-STUDYQUES", protocol1, protocol2)
                .back();
        whichOfTheFollowingBreathingLungPageСС
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Chronic cough")
                .clickNextButton(otherThanSkinCancerPageCC);

        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(kidneyProblemsPage)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1, protocol2)
                .back();
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(kidneyProblemsPage);

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС = kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1, protocol2)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1, protocol2)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС);

        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealth_Page_cc = whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageCC());
        followingMentalEmotionalHealth_Page_cc
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", protocol1, protocol2)
                .back();
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealth_Page_cc);

        followingMentalEmotionalHealth_Page_cc
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocol1, protocol2)
                .back();
        followingMentalEmotionalHealth_Page_cc
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015149-QS53-STUDYQUES", protocol1, protocol2)
                .back();
        followingMentalEmotionalHealth_Page_cc
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back();
        followingMentalEmotionalHealth_Page_cc
                .waitForPageLoad()
                .back();
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .back();
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .back();
        whichOfTheFollowingBreathingLungPageСС
                .waitForPageLoad()
                .back();
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                .clickNextButton(whichOfTheFollowingBreathingLungPageСС)
                .waitForPageLoad()
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease requiring dialysis")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocol1, protocol2)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        HowLongYouHadChronicCoughCC howLongYouHadChronicCoughCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new HowLongYouHadChronicCoughCC());



        TreatingYourChronicCoughCC treatingYourChronicCoughCC = howLongYouHadChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 6 months")
                .clickNextButton(new TreatingYourChronicCoughCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017639-QS6203-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        howLongYouHadChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswer("6 to 11 months")
                .clickNextButton(new TreatingYourChronicCoughCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017639-QS6203-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        howLongYouHadChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswer("1 year or longer")
                .clickNextButton(new TreatingYourChronicCoughCC());

        SmokedCigarettesPageCC smokedCigarettesPageCC = treatingYourChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswers("(QS6217_C)") //No, have not treated
                .clickNextButton(new SmokedCigarettesPageCC())
                .waitForPageLoadNew();
        smokedCigarettesPageCC.back();

        StillHaveYourCoughCC stillHaveYourCoughCC = treatingYourChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswers("(QS6217_B)", "(QS6217_A)")    //A. Yes, with prescription and B. Yes, with over the counter
                .clickNextButton(new StillHaveYourCoughCC());

        stillHaveYourCoughCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new SmokedCigarettesPageCC());

        HowManyYearsYouSmokeCC howManyYearsYouSmokeCC = smokedCigarettesPageCC
                .waitForPageLoadNew()
                .clickOnAnswer("Yes, I currently smoke")
                .clickNextButton(new HowManyYearsYouSmokeCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017025-QS6206-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();

        QuitSmokingCC quitSmokingCC = smokedCigarettesPageCC
                .waitForPageLoadNew()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new QuitSmokingCC());

        quitSmokingCC
                .waitForPageLoad()
                .clickOnAnswer("I quit smoking within the past year")
                .clickNextButton(new HowManyYearsYouSmokeCC())
                .waitForPageLoad1();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017651-QS6207-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        quitSmokingCC
                .waitForPageLoad()
                .clickOnAnswer("I quit smoking more than a year ago")
                .clickNextButton(new HowManyYearsYouSmokeCC());

        FollowingConditionsCC followingConditionsCC = howManyYearsYouSmokeCC
                .waitForPageLoad1()
                .enterYears("20")
                .enterCigrettes("21")
                .clickNextButton(new FollowingConditionsCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017642-QS6209-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        howManyYearsYouSmokeCC
                .waitForPageLoad1()
                .enterCigrettes("10")
                .clickNextButton(new FollowingConditionsCC());

        ACEInhibitorsCC aCEInhibitorsCC = followingConditionsCC
                .waitForPageLoad()
                .clickOnAnswers("Post-Nasal Drip (Upper Airway Cough Syndrome)", "Lung Cancer", "Tuberculosis (TB) (Agent Note: too-ber-cue-LOW-sis)")
                .clickNextButton(new ACEInhibitorsCC())
                .waitForPageLoad();
        aCEInhibitorsCC.back();
        followingConditionsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ACEInhibitorsCC());

        ExperienceWithYourChronicCoughCC experienceWithYourChronicCoughCC = aCEInhibitorsCC
                .waitForPageLoad()
                .clickOnAnswers("Benazepril (Ben-az-uh-pril) - Brand name Lotensin (Low-ten-sin)", "Captopril (Cap-toe-pril) - Brand name Capoten (Cap-oh-ten)", "Cilazapril (Sil-az-uh-pril) - Brand name Inhibace (In-hib-ace)")
                .clickOnAnswers("Enalapril (Ee-nal-uh-pril) - Brand names Vasotec, Renitec, Berlipril, Enap, Enapren (Vay-zo-tech / Ren-eh-tech / Bur-lip-rell / Ee-Nap / Ee-nap-ren)", "Quinapril (Kwin-uh-pril) - Brand name Accupril (Ack-you-pril)")
                .clickOnAnswers("Fosinopril (Foe-sin-uh-pril) - Brand names Fositen, Monopril (Foe-sit-en / Mono-pril)", "Imidapril (Im-eh-di-prell) - Brand name Tanatril (Tan-eh-tril)")
                .clickNextButton(new ExperienceWithYourChronicCoughCC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017644-QS6211-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        aCEInhibitorsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ExperienceWithYourChronicCoughCC());

        SymptomsGetBetterCC symptomsGetBetterCC = experienceWithYourChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswers("A runny or stuffy nose", "A feeling of liquid running down the back of your throat (postnasal drip)", "Frequent throat clearing and sore throat", "Hoarseness")
                .clickOnAnswers("Wheezing and shortness of breath", "Heartburn or a sour taste in your mouth", "Coughing up blood")
                .clickNextButton(new SymptomsGetBetterCC())
                .waitForPageLoad();
        symptomsGetBetterCC.back();
        TransitionStatementCC transitionStatementCC = experienceWithYourChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoadMCC("chronic cough");
        transitionStatementCC.back();

        experienceWithYourChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswers("A runny or stuffy nose")
                .clickNextButton(new SymptomsGetBetterCC());

        symptomsGetBetterCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());

        LetMeSeePageCC letMeSeePageCC = transitionStatementCC
                .waitForPageLoadMCC("chronic cough")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Auto", "Test", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoadMCC(studyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new HSGeneralCC())
                .waitForPageLoad("Chronic Cough")
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);


    }
}
