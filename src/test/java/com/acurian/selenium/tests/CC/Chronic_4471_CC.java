package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.ChronicCough.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Chronic_4471_CC extends BaseTest {

    @Test()
    public void chronic4471ccTest() {
        Site site = Site.AUT_MCC;
        String phoneNumberOA = "AUTAMS1MCC";
        String studyName = "a chronic cough study";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageCC debugPageCC = new DebugPageCC();
        LoginPageCC loginPageCC = new LoginPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(Properties.getUsername())
                .typePassword(Properties.getPassword())
                .clickLoginButton();

        CallCenterIntroductionPageCC callCenterIntroductionPageCC = selectActionPageCC
                .waitForPageLoad()
                .typeStudyName("AMS1")
                .clickPopupStudy("AMS1")
                .typePhoneNumber(phoneNumberOA)
                .clickPopupPhoneNumber(phoneNumberOA)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad("a chronic cough study", "350");
        //Assert.assertEquals(dateOfBirthPageCC.getTitleText(),  dateOfBirthPageCC.getExpectedModifiedTitle("a chronic cough study", "350"), "Title is diff");

        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
//                .setMonth("Mar")
//                .setDay("2")
//                .setYear("2003")
//                .clickOnAnswer("Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad("a chronic cough study", "350")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        ZipCodePageCC zipCodePageCC = lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad("a chronic cough study", "350")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        CurrentlySufferFromChronicCoughCC currentlySufferFromChronicCoughCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickOnAnswer("Female")
                .clickNextButton(lessThan18YearsOldPageCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1980")
                .clickNextButton(new CurrentlySufferFromChronicCoughCC());

        NonQRtransitionPageCC nonQRtransitionPageCC = currentlySufferFromChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6202", site.activeProtocols)
                .back();

        HowLongYouHadChronicCoughCC howLongYouHadChronicCoughCC = currentlySufferFromChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongYouHadChronicCoughCC());

        TreatingYourChronicCoughCC treatingYourChronicCoughCC = howLongYouHadChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswer("Less than 6 months")
                .clickNextButton(new TreatingYourChronicCoughCC());
        treatingYourChronicCoughCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6203", site.activeProtocols)
                .back();
        howLongYouHadChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswer("6 to 11 months")
                .clickNextButton(new TreatingYourChronicCoughCC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6203", site.activeProtocols)
                .back();
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
                .clickNextButton(new HowManyYearsYouSmokeCC());
        howManyYearsYouSmokeCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6206", site.activeProtocols)
                .back();

        QuitSmokingCC quitSmokingCC = smokedCigarettesPageCC
                .waitForPageLoadNew()
                .clickOnAnswer("I used to smoke, but have since quit")
                .clickNextButton(new QuitSmokingCC());

        quitSmokingCC
                .waitForPageLoad()
                .clickOnAnswer("I quit smoking within the past year")
                .clickNextButton(new HowManyYearsYouSmokeCC())
                .waitForPageLoad1()
                .getPage(debugPageCC).checkProtocolsContainsForQNumber("QS6207", site.activeProtocols)
                .back();
        quitSmokingCC
                .waitForPageLoad()
                .clickOnAnswer("I quit smoking more than a year ago")
                .clickNextButton(new HowManyYearsYouSmokeCC());

        FollowingConditionsCC followingConditionsCC = howManyYearsYouSmokeCC
                .waitForPageLoad1()
                .enterYears("20")
                .enterCigrettes("21")
                .clickNextButton(new FollowingConditionsCC());
        followingConditionsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6209", site.activeProtocols)
                .back();
        howManyYearsYouSmokeCC
                .waitForPageLoad1()
                .enterCigrettes("10")
                .clickNextButton(new FollowingConditionsCC());

        ACEInhibitorsCC aCEInhibitorsCC = followingConditionsCC
                .waitForPageLoad()
                .clickOnAnswers("Post-Nasal Drip (Upper Airway Cough Syndrome)",
                        "Lung Cancer",
                        "Tuberculosis (TB) (Agent Note: too-ber-cue-LOW-sis)")
                .clickNextButton(new ACEInhibitorsCC());
        aCEInhibitorsCC
                .waitForPageLoad()
                .back();
        followingConditionsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ACEInhibitorsCC());

        ExperienceWithYourChronicCoughCC experienceWithYourChronicCoughCC = aCEInhibitorsCC
                .waitForPageLoad()
                .clickOnAnswers("Benazepril (Ben-az-uh-pril) - Brand name Lotensin (Low-ten-sin)", "Captopril (Cap-toe-pril) - Brand name Capoten (Cap-oh-ten)", "Cilazapril (Sil-az-uh-pril) - Brand name Inhibace (In-hib-ace)",
               "Enalapril (Ee-nal-uh-pril) - Brand names Vasotec, Renitec, Berlipril, Enap, Enapren (Vay-zo-tech / Ren-eh-tech / Bur-lip-rell / Ee-Nap / Ee-nap-ren)", "Quinapril (Kwin-uh-pril) - Brand name Accupril (Ack-you-pril)",
                "Fosinopril (Foe-sin-uh-pril) - Brand names Fositen, Monopril (Foe-sit-en / Mono-pril)", "Imidapril (Im-eh-di-prell) - Brand name Tanatril (Tan-eh-tril)")
                .clickNextButton(new ExperienceWithYourChronicCoughCC());
        experienceWithYourChronicCoughCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS6211", site.activeProtocols)
                .back();
        aCEInhibitorsCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ExperienceWithYourChronicCoughCC());

        SymptomsGetBetterCC symptomsGetBetterCC = experienceWithYourChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswers("A runny or stuffy nose",
                        "A feeling of liquid running down the back of your throat (postnasal drip)",
                        "Frequent throat clearing and sore throat",
                        "Hoarseness",
                        "Wheezing and shortness of breath",
                        "Heartburn or a sour taste in your mouth",
                        "Coughing up blood")
                .clickNextButton(new SymptomsGetBetterCC());

        symptomsGetBetterCC
                .waitForPageLoad()
                .back();
        TransitionStatementCC transitionStatementCC = experienceWithYourChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadMCC("chronic cough")
                .back();

        experienceWithYourChronicCoughCC
                .waitForPageLoad()
                .clickOnAnswers("A runny or stuffy nose")
                .clickNextButton(new SymptomsGetBetterCC());

        symptomsGetBetterCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadMCC("chronic cough")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new KidneyProblemsPage());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
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
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
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
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC());
        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new MedicalRecordsOptionPageCC())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}