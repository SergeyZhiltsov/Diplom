package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.HOTF_7119.AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC;
import com.acurian.selenium.pages.CC.HOTF_7119.DoyouExperienceHotFlashesCC;
import com.acurian.selenium.pages.CC.HOTF_7119.HowWouldYouDescribeYourHotFlashesCC;
import com.acurian.selenium.pages.CC.HOTF_7119.OnAvgHowManyHotFlashesDoYouExperiencePerDayCC;
import com.acurian.selenium.pages.CC.SUI_3923.HaveYouGoneThroughMenopauseCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.closes.UnqualifiedCloseCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.tests.OLS.HOTF_7119_OLS;
import com.acurian.selenium.utils.Properties;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class HOTF_7119_CC extends BaseTest {

    @Test(enabled = true, dataProvider = "sites", dataProviderClass = HOTF_7119_OLS.class)
    @Description("HOTF_7119_OLS")
    public void HOTF_7119_OLS(Site site) {
        String phoneNumber = "AUTAMS1HOT";
        String studyName = "a study for menopausal women with hot flashes";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageCC debugPageCC = new DebugPageCC();
        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:",
                "Title text is diff");
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
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
                .getExpectedModifiedTitle("a study for menopausal women with hot flashes",
                        "750"), "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());

        lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();

        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad()
                .setMonth("Aug")
                .setDay("9")
                .setYear("2002") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Female")
                .clickNextButton(lessThan18YearsOldPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC);
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                genderPageCC
                        .waitForPageLoad()
                        .setYear("1980") //Disqualify ("Age") if < 40
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1953") //Disqualify ("Age") OR >= 66
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        DoyouExperienceHotFlashesCC doyouExperienceHotFlashesCC = genderPageCC
                .waitForPageLoad()
                .setYear("1970")
                .clickNextButton(new DoyouExperienceHotFlashesCC());

        //---------Q2 - Do you experience hot flashes?-----------------------------------------
        NonQRtransitionPageCC nonQRtransitionPageCC = doyouExperienceHotFlashesCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());

        nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7602", site.activeProtocols)
                .back();
        OnAvgHowManyHotFlashesDoYouExperiencePerDayCC onAvgHowManyHotFlashesDoYouExperiencePerDayCC =
                doyouExperienceHotFlashesCC
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(new OnAvgHowManyHotFlashesDoYouExperiencePerDayCC());


        //---------Q3 - On average, how many hot flashes do you experience per day?--------------
        HowWouldYouDescribeYourHotFlashesCC howWouldYouDescribeYourHotFlashesCC =
                new HowWouldYouDescribeYourHotFlashesCC();
        List<String> disqualifyQ3 = Arrays.asList("0 (I do not have hot flashes every day)", "1 - 2", "3 - 4", "5 - 6");
        for (String answer : disqualifyQ3) {
            System.out.println(answer);
            onAvgHowManyHotFlashesDoYouExperiencePerDayCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(howWouldYouDescribeYourHotFlashesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7603", site.activeProtocols[0],
                            site.activeProtocols[1])
                    .back();
        }
        onAvgHowManyHotFlashesDoYouExperiencePerDayCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 8")
                .clickNextButton(howWouldYouDescribeYourHotFlashesCC);


        //------------Q4:  How would you describe your hot flashes? ---------------------------------------------
        HaveYouGoneThroughMenopauseCC haveYouGoneThroughMenopauseСС = howWouldYouDescribeYourHotFlashesCC
                .waitForPageLoad()
                .clickOnAnswer("Mild - minimal or no effect on daily life or usual activities")
                .clickNextButton(new HaveYouGoneThroughMenopauseCC());
        haveYouGoneThroughMenopauseСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7604", site.activeProtocols[0],
                        site.activeProtocols[1])
                .back(howWouldYouDescribeYourHotFlashesCC)
                .waitForPageLoad()
                .clickOnAnswer("Moderate - noticeable effect on daily life, or some interference with usual activities")
                .clickOnAnswer("Severe - serious effect on daily life, or constant interference with usual activities")
                .clickNextButton(haveYouGoneThroughMenopauseСС);


        //------------Q5:  HaveYouGoneThroughMenopauseOLS ---------------------------------------------
        AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC =
                haveYouGoneThroughMenopauseСС
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC());
        areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7605", site.activeProtocols)
                .back(haveYouGoneThroughMenopauseСС)
                .waitForPageLoad()
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process")
                .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed")
                .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                .clickNextButton(areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC);


        //------------Q6:  AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS ---------------------------------------------
        TransitionStatementCC transitionStatementCC = areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadMDD("hot flashes")
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7606", site.activeProtocols)
                .back(areYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickOnAnswer("Unsure")
                .clickNextButton(transitionStatementCC);

        transitionStatementCC
                .waitForPageLoadMDD("hot flashes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);


//#############General_Health ###########################
        OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
                        "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
                        "Autism spectrum",
                        "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
                        "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)",
                        "Cancer",
                        "Diabetes (type 1 or type 2)",
                        "Headaches (migraine, cluster, tension)",
                        "Heart or circulation problems (heart attack, heart failure, stroke)",
                        "High blood pressure or hypertension",
                        "High cholesterol, triglycerides, or lipids",
                        "Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                        "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)",
                        "Kidney disease",
                        "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Lupus",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)",
                        "Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
                        "Skin problems (eczema or atopic dermatitis, psoriasis)",
                        "Sleep problems (insomnia, sleep apnea, narcolepsy)",
                        "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
                        "Women's health issues (endometriosis, uterine fibroids)")
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new OtherThanSkinCancerPageCC());


        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC =
                new DoAnyOftheFollowingAdditionalDiagnosesCC();
        List<String> disqualifyQ6QS42 = Arrays.asList("Within the past 5 years", "6 - 10 years ago",
                "11 or more years ago");
        for (String answer : disqualifyQ6QS42) {
            System.out.println("Select answer for QS42: " + answer);
            otherThanSkinCancerPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                    .back();
        }
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .back();
        KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new KidneyProblemsPage());

        List<String> disqualifyQ16 = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer : disqualifyQ16) {
            System.out.println("Select answer for Q16: " + answer);
            kidneyProblemsPage
                    .waitForPageLoad()
                    .clickOnAnswers("Neither")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                    .back();
        }
        kidneyProblemsPage
                .waitForPageLoad()
                .back();
        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());


        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfTheFollowingLiverProblemsPageСС)
                .waitForPageLoad()
                .back();
        FollowingMentalEmotionalHealthPageCC followingMentalEmotionalHealthPageCC =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageCC());


        //Q18: QS53
        List<String> disqualifyQ18 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer : disqualifyQ18) {
            System.out.println(answer);
            followingMentalEmotionalHealthPageCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                    .back();
        }
        followingMentalEmotionalHealthPageCC
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
        ApproximateHeightPageCC approximateHeightPageCC = new ApproximateHeightPageCC();
        List<String> disqualifyQ24 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS");
        for (String answer : disqualifyQ24) {
            System.out.println("Select answer for Q24QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        List<String> disqualifyQ24pt2 = Arrays.asList("Kidney disease requiring dialysis", "Schizophrenia");
        for (String answer : disqualifyQ24pt2) {
            System.out.println("Select answer for Q24QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);


//        UnqualifiedCloseCC unqualifiedCloseCC = approximateHeightPageCC
        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
//                .setAll("5", "5", "105") //Disqualify ("Low BMI") if < 18
//                .clickNextButton(new UnqualifiedCloseCC());
//        unqualifiedCloseCC
//                .waitForPageLoad()
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
//                .back(approximateHeightPageCC)
//                .waitForPageLoad()
//                .setLbs("230") //Disqualify ("High BMI") if > 38
//                .clickNextButton(unqualifiedCloseCC)
//                .getPage(debugPageCC)
//                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
//                .back();
//        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
//                .waitForPageLoad()
                .setAll("5", "5", "105")
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
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .assertVariables("Acurian", "Trial", "08/09/1970", "US",
                        "Dover, DE", site.zipCode, "qa.acurian@gmail.com", "999 -999-9999",
                        "aut7119s", site.name, "ASSICNVMS301,ASSICNVMS302,ASSICNVMS304")
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .getRadiantDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo)
                .queueSiteForFULCheck(site.name);

    }
}
