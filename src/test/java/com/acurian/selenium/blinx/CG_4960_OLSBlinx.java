package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.cv_study.HeartRelatedSurgeriesProceduresPageOLS;
import com.acurian.selenium.pages.blinx.ams.cv_study.SubquestionHeartPageOLS;
import com.acurian.selenium.pages.blinx.ams.cv_study.SufferedFollowingHeartRelatedConditionsPageOLS;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.derm.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.gerd.CurrentlySufferOfAnyOfFollowingOLS;
import com.acurian.selenium.pages.blinx.ams.gout.*;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.ZipCodePageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CG_4960_OLSBlinx extends BaseTest {

    private static Logger Log = LogManager.getLogger(CG_4960_OLSBlinx.class.getName());

    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_AMS1_4960_site},
                {Site.AUT_AMS1_4960S_site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("4960 LG-GDCL002 LG Chem Gout OLS")
    public void cg4960BlinxTest(Site site) {

        final String phoneNumber = "AUTAMSGOUT";
        final String studyName = "a gout study";
        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad(studyName, "450");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),
//                dateOfBirthPageOLS.getExpectedModifiedTitle(studyName, "450"), "Title is diff");


        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .getPage(new LessThan18YearsOldPageOLS());
        ZipCodePageOLS zipCodePageOLS = lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS)
                .waitForPageLoad(studyName, "450")
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());


        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());


        genderPageOLS
                .waitForPageLoad()
                .setDate("01012003") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Female")
                .clickNextButton(lessThan18YearsOldPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS);
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                        .waitForPageLoad()
                        .setDate("01011943") //Disqualify ("Age") if > 76
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS);
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
                .back(everDiagnosedWithGoutOLS);
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
//                .waitForPageLoad()
//                .clickOnAnswer("1")
//                .clickNextButton(everTakenMedicationOLS)
//                .waitForPageLoad()
//                .getPage(debugPageOLS)
//                .checkProtocolsContainsForQNumber("QS7903", site.activeProtocols)
//                .back(howManyGoutAttacksOLS)
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
                .back(everTakenMedicationOLS);
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
                .waitForPageLoad()
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
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());


        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
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
            Log.info("Select answer for Q15.1: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionHeartPageOLS);
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.2	When was the last time that you experienced had a stroke?
        for (String answer : disqualifyQ15) {
            Log.info("Select answer for Q15.2: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected2())
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionHeartPageOLS);
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected2())
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.4	When was the last time that you experienced suffered from angina or chest pain that required you to stay in a hospital overnight?
        for (String answer : disqualifyQ15) {
            Log.info("Select answer for Q15.4: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected4())
                    .clickOnAnswerForSubQuestion(1, answer)
                    .clickNextButton(heartRelatedSurgeriesProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                    .back(subquestionHeartPageOLS);
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected4())
                .back(sufferedFollowingHeartRelatedConditionsPageOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
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
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
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
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());


        //Q18: QS53
        List<String> disqualifyQ18 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer : disqualifyQ18) {
            Log.info(answer);
            followingMentalEmotionalHealthPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS53", site.activeProtocols)
                    .back(followingMentalEmotionalHealthPageOLS);
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
            Log.info("Select answer for Q24_QS59: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        }
        List<String> disqualifyQ24_QS59p2 = Arrays.asList("Kidney disease requiring dialysis", "Schizophrenia");
        for (String answer : disqualifyQ24_QS59p2) {
            Log.info("Select answer for Q24_QS59p2: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS61", site.activeProtocols)
                    .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        }
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


        CurrentlySufferOfAnyOfFollowingOLS currentlySufferOfAnyOfFollowingOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "252") //Disqualify ("High BMI") if > 42
                .clickNextButton(new CurrentlySufferOfAnyOfFollowingOLS());
        currentlySufferOfAnyOfFollowingOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back(approximateHeightPageOLS);
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setPounds("160")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());


        SiteSelectionPageOLS siteSelectionPageCC = identificationPageOLS
                .waitForPageLoad2()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999")
                .clickNextButton(new SiteSelectionPageOLS());


        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageCC
                .waitForPageLoad("a gout study!")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS());


        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                .waitForPageLoad3()
                .clickNextButton(new ThankYouCloseSimplePageOLS());


        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad3()
                .clickNextButton(new AboutHealthPageOLS());
//                .waitForPageLoad();

        if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .dispoShouldMatch(site.dispo, site.dispo)
                    .assertGeneratedFul(env, site);

            if (site == Site.AUT_AMS1_4960_site) {
                aboutHealthPageOLS
                        .getRadiantDbToLog(env);
            }
        }
    }

}
