package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.GERD.DoYouExperienceAnyOfFollowingSymptoms_OLS;
import com.acurian.selenium.pages.OLS.Gout.*;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.LessThan18YearsOldPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose1PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.cv_study.HeartRelatedSurgeriesProceduresPageOLS;
import com.acurian.selenium.pages.OLS.cv_study.SubquestionHeartPageOLS;
import com.acurian.selenium.pages.OLS.cv_study.SufferedFollowingHeartRelatedConditionsPageOLS;
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

import java.util.Arrays;
import java.util.List;

public class CG_4960_OLS extends BaseTest {
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
                {Site.AUT_AMS1_4960_site},
                {Site.AUT_AMS1_4960S_site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("4960 LG-GDCL002 LG Chem Gout OLS")
    public void cg4960OLSTest(Site site) {

        final String phoneNumber = "AUTAMSGOUT";
        final String studyName = "a gout study";
        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),
                dateOfBirthPageOLS.getExpectedModifiedTitle(studyName, "450"), "Title is diff");


        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        ZipCodePageOLS zipCodePageOLS = lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());


        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());


        genderPageOLS
                .waitForPageLoad()
                .setDate("01012002") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Female")
                .clickNextButton(lessThan18YearsOldPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                        .waitForPageLoad()
                        .setDate("01011943") //Disqualify ("Age") if > 76
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        EverDiagnosedWithGoutOLS everDiagnosedWithGoutOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("01011980")
                .clickNextButton(new EverDiagnosedWithGoutOLS());

        //Q2
        everDiagnosedWithGoutOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7902", site.activeProtocols)
                .back();
        HowManyGoutAttacksOLS howManyGoutAttacksOLS = everDiagnosedWithGoutOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowManyGoutAttacksOLS());

        //Q3
        EverTakenMedicationOLS everTakenMedicationOLS = howManyGoutAttacksOLS
                .waitForPageLoad()
                .clickOnAnswer("No gout attacks in the past year")
                .clickNextButton(new EverTakenMedicationOLS());
        everTakenMedicationOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7903", site.activeProtocols)
                .back(howManyGoutAttacksOLS)
                .waitForPageLoad()
                .clickOnAnswer("1")
                .clickNextButton(everTakenMedicationOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7903", site.activeProtocols)
                .back(howManyGoutAttacksOLS)
                .waitForPageLoad()
                .clickOnAnswer("2 or more")
                .clickNextButton(everTakenMedicationOLS);

        //Q4

        everTakenMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7904", site.activeProtocols)
                .back();
        EverTakenFollowingMedicationsCurrentlyOrPastOLS everTakenFollowingMedicationsCurrentlyOrPastOLS =
                everTakenMedicationOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(new EverTakenFollowingMedicationsCurrentlyOrPastOLS());

        //Q5,6,7
        CurrentlyTakingUloricOLS currentlyTakingUloriOLSC = everTakenFollowingMedicationsCurrentlyOrPastOLS
                .waitForPageLoad()
                .clickOnAnswers("Uloric, also called febuxostat") //continue to Q6
                .clickNextButton(new CurrentlyTakingUloricOLS());
        PastThreeMonthsTakenKrystexxaOLS pastThreeMonthsTakenKrystexxaOLS = currentlyTakingUloriOLSC
                .waitForPageLoad()
                .clickOnAnswer("No") //Select “Yes” in Q6 (current febuxostat) Otherwise disqualify (“Does not meet medication requirements”)
                .clickNextButton(new PastThreeMonthsTakenKrystexxaOLS());
        pastThreeMonthsTakenKrystexxaOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(currentlyTakingUloriOLSC)
                .clickOnAnswer("Unsure")
                .clickNextButton(pastThreeMonthsTakenKrystexxaOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(currentlyTakingUloriOLSC)
                .waitForPageLoad()
                .back(everTakenFollowingMedicationsCurrentlyOrPastOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(pastThreeMonthsTakenKrystexxaOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7907", site.activeProtocols)
                .back(everTakenFollowingMedicationsCurrentlyOrPastOLS)
                .waitForPageLoad()
                .clickOnAnswers("Allopurinol, also called Aloprim or Zyloprim")
                .clickNextButton(pastThreeMonthsTakenKrystexxaOLS);

        //Q8
        pastThreeMonthsTakenKrystexxaOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7908", site.activeProtocols)
                .back(pastThreeMonthsTakenKrystexxaOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        //#############General_Health ###########################
        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickNextButton(new WhatKindOfArthritisPageOLS());


        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back(whatKindOfArthritisPageOLS)
                .waitForPageLoad()
                .back();
        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new OtherThanSkinCancerPageOLS());


        otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(otherThanSkinCancerPageOLS)
                .waitForPageLoad()
                .back();
        SufferedFollowingHeartRelatedConditionsPageOLS sufferedFollowingHeartRelatedConditionsPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)")
                        .clickNextButton(new SufferedFollowingHeartRelatedConditionsPageOLS());


        SubquestionHeartPageOLS subquestionHeartPageOLS = sufferedFollowingHeartRelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack")
                .clickNextButton(new SubquestionHeartPageOLS());

        //Q15.1	When was the last time that you experienced had a heart attack?
        HeartRelatedSurgeriesProceduresPageOLS heartRelatedSurgeriesProceduresPageOLS =
                new HeartRelatedSurgeriesProceduresPageOLS();
        List<String> disqualifyQ15 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago", "4 - 6 months ago",
                "7 - 12 months ago");
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.1: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected1)
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.2	When was the last time that you experienced had a stroke?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.2: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected2)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected2)
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.4	When was the last time that you experienced suffered from angina or chest pain that required you to stay in a hospital overnight?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.4: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected4)
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.titleExpected4)
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .back();
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Kidney disease")
                        .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS)
                .waitForPageLoad()
                .back();
        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());

        whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS)
                .waitForPageLoad()
                .back();
        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());


        //Q18: QS53
        List<String> disqualifyQ18 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer : disqualifyQ18) {
            System.out.println(answer);
            followingMentalEmotionalHealthPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                    .back();
        }
        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);


        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        List<String> disqualifyQ24_QS59 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis", "Drug or alcohol abuse within the past year", "Hepatitis B",
                "Hepatitis C", "HIV or AIDS");
        for (String answer : disqualifyQ24_QS59) {
            System.out.println("Select answer for Q24_QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        List<String> disqualifyQ24_QS59p2 = Arrays.asList("Kidney disease requiring dialysis", "Schizophrenia");
        for (String answer : disqualifyQ24_QS59p2) {
            System.out.println("Select answer for Q24_QS59p2: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


        DoYouExperienceAnyOfFollowingSymptoms_OLS doYouExperienceAnyOfFollowingSymptoms_OLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "252") //Disqualify ("High BMI") if > 42
                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_OLS());
        doYouExperienceAnyOfFollowingSymptoms_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                .back();
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .setLbs("160")
                .clickNextButton(new IdentificationPageOLS());


        SiteSelectionPageOLS siteSelectionPageCC = identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());


        QualifiedClose1PageOLS qualifiedClose1PageOLS = siteSelectionPageCC
                .waitForPageLoad("a gout")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS());


        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose1PageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS());


        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForSENRPageLoad()
                .clickNextButton(new AboutHealthPageOLS());


        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .dispoShouldMatch(site.dispo, site.dispo)
                .assertGeneratedFul(env, site);

        if (site == Site.AUT_AMS1_4960_site) {
            aboutHealthPageOLS
                    .getRadiantDbToLog(env)
                    .getAnomalyDbToLog(env);
        }
    }
}
