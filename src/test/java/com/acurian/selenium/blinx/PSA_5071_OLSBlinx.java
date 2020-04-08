package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.derm.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.lps_4442.EitherOfFollowingMedicationsOLS;
import com.acurian.selenium.pages.blinx.ams.ps.*;
import com.acurian.selenium.pages.blinx.ams.ps_7469.PsoriaticArthritisConditionPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.*;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PSA_5071_OLSBlinx extends BaseTest {

    private static Logger Log = LogManager.getLogger(PSA_5071_OLSBlinx.class.getName());

    @Test()
    @Description("PsA 5071 OLS Gilead Psoriatic Arthritis(PsA)")
    public void ps5071olsTest() {
        Site site = Site.AUT_AMS1_5071_site;
        String phoneNumber = "AUTAMS1PSA";
        String studyName = "a psoriatic arthritis study";
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        DebugPageOLS debugPageOLS = new DebugPageOLS();

        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad(studyName, "300");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText2(), dateOfBirthPageOLS
                .getExpectedModifiedTitle(studyName, "300"), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .getPage(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS);

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad(studyName, "300")
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad()
                .setDate("09092002") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Male")
                .clickNextButton(lessThan18YearsOldPage_OLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS);
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                genderPageOLS
                        .waitForPageLoad()
                        .setDate("09091943")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS);

        PsoriaticArthritisConditionPageOLS psoriaticArthritisConditionPageOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickNextButton(new PsoriaticArthritisConditionPageOLS());

        //Module Psoriatic Arthritis (PsA) started
        //Q2
        DoYouSufferFromArthritisOLS doYouSufferFromArthritisOLS = new DoYouSufferFromArthritisOLS();
        psoriaticArthritisConditionPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7502", site.activeProtocols)
                .back(psoriaticArthritisConditionPageOLS);

        FirstDiagnosedPsoriaticArthritisPageOLS firstDiagnosedPsoriaticArthritisPageOLS =
                psoriaticArthritisConditionPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(new FirstDiagnosedPsoriaticArthritisPageOLS());

        //Q3
        SwollenJointsOfPsoriaticArthritisPageOLS swollenJointsOfPsoriaticArthritisPageOLS =
                new SwollenJointsOfPsoriaticArthritisPageOLS();
        List<String> disqualifyQ3 = Arrays.asList("Less than 1 month ago", "1 - 5 months ago");
        for (String answer : disqualifyQ3) {
            Log.info("Select answer for Q3: " + answer);
            firstDiagnosedPsoriaticArthritisPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(swollenJointsOfPsoriaticArthritisPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7503", site.activeProtocols)
                    .back(firstDiagnosedPsoriaticArthritisPageOLS);
        }
        firstDiagnosedPsoriaticArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("6 - 11 months ago")
                .clickNextButton(swollenJointsOfPsoriaticArthritisPageOLS);

        //Q4
        CurrentlyHaveSoreTenderPainfulPsoriaticArthritisPageOLS currentlyHaveSoreTenderPainfulPsoriaticArthritisPageOLS =
                swollenJointsOfPsoriaticArthritisPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No") //skip to Q6
                        .clickNextButton(new CurrentlyHaveSoreTenderPainfulPsoriaticArthritisPageOLS());
        currentlyHaveSoreTenderPainfulPsoriaticArthritisPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7504", site.activeProtocols)
                .back(swollenJointsOfPsoriaticArthritisPageOLS);
        HowManyJointsSwollenPageOLS howManyJointsSwollenPageOLS = swollenJointsOfPsoriaticArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes") //continue to Q5
                .clickNextButton(new HowManyJointsSwollenPageOLS());

        //Q5
        howManyJointsSwollenPageOLS
                .waitForPageLoad()
                .setJointsAreSwollen("1")
                .clickNextButton(currentlyHaveSoreTenderPainfulPsoriaticArthritisPageOLS);

        //Q6
        HasHealthCareProfessionalDiagnosedPsoriasisOLS hasHealthCareProfessionalDiagnosedPsoriasisOLS =
                currentlyHaveSoreTenderPainfulPsoriaticArthritisPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No") //skip to Q8
                        .clickNextButton(new HasHealthCareProfessionalDiagnosedPsoriasisOLS());
        hasHealthCareProfessionalDiagnosedPsoriasisOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7506", site.activeProtocols)
                .back(currentlyHaveSoreTenderPainfulPsoriaticArthritisPageOLS);
        HowManyJointsAreSoreTenderPainfulPageOLS howManyJointsAreSoreTenderPainfulPageOLS =
                currentlyHaveSoreTenderPainfulPsoriaticArthritisPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes") //continue to Q7
                        .clickNextButton(new HowManyJointsAreSoreTenderPainfulPageOLS());

        //Q7
        howManyJointsAreSoreTenderPainfulPageOLS
                .waitForPageLoad()
                .setJointsPainful("1")
                .clickNextButton(hasHealthCareProfessionalDiagnosedPsoriasisOLS);

        //Q8
        hasHealthCareProfessionalDiagnosedPsoriasisOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7508", site.activeProtocols)
                .back(hasHealthCareProfessionalDiagnosedPsoriasisOLS);
        WhichTypeOfPsoriasisDoYouHaveOLS whichTypeOfPsoriasisDoYouHaveOLS = hasHealthCareProfessionalDiagnosedPsoriasisOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes") //continue to Q9
                .clickNextButton(new WhichTypeOfPsoriasisDoYouHaveOLS());

        //Q9 //check Q11 Ghost Question - Psoriasis Logic
        CurrentlyHaveAnyOffFollowingPageOLS currentlyHaveAnyOffFollowingPageOLS = whichTypeOfPsoriasisDoYouHaveOLS
                .waitForPageLoad()
                .clickOnAnswers("Another type of psoriasis (Guttate, Pustular, Erythtodermic, Inverse)") //Otherwise disqualify
                .clickNextButton(new CurrentlyHaveAnyOffFollowingPageOLS());
        //Q10
        currentlyHaveAnyOffFollowingPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Otherwise disqualify
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7511", site.activeProtocols)
                .back(currentlyHaveAnyOffFollowingPageOLS)
                .waitForPageLoad()
                .back(whichTypeOfPsoriasisDoYouHaveOLS)
                .waitForPageLoad()
                .clickOnAnswers("Plaque - Thick, red patches of skin are covered by flaky, silver-white scales. This is the most common type of psoriasis")
                .clickNextButton(currentlyHaveAnyOffFollowingPageOLS);
        PrescriptionMedicationPsoriaticArthritisPageOLS prescriptionMedicationPsoriaticArthritisPageOLS =
                currentlyHaveAnyOffFollowingPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Patches of psoriasis on your skin", "Psoriasis on your fingernails or toenails")
                        .clickNextButton(new PrescriptionMedicationPsoriaticArthritisPageOLS());

        //Q12
        EitherOfFollowingMedicationsOLS eitherOfFollowingMedicationsOLS = prescriptionMedicationPsoriaticArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No") //skip to Q15 (JAK inhibitors question)
                .clickNextButton(new EitherOfFollowingMedicationsOLS());
        eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7512", site.activeProtocols)
                .back(prescriptionMedicationPsoriaticArthritisPageOLS);
        EverReceivedAnyBiologicMedicationsPageOLS everReceivedAnyBiologicMedicationsPageOLS =
                prescriptionMedicationPsoriaticArthritisPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes") //continue to Q13 (biologics Y/N question)
                        .clickNextButton(new EverReceivedAnyBiologicMedicationsPageOLS());

        //Q13
        BiologicMedicationsPageOLS biologicMedicationsPageOLS = everReceivedAnyBiologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new BiologicMedicationsPageOLS());

        //Q14
        List<String> disqualifyQ14 = Arrays.asList("Actemra", "Benlysta", "Cimzia", "Cosentyx", "Enbrel", "Entyvio",
                "Humira", "Kineret", "Orencia", "Prolia or Xgeva", "Raptiva", "Remicade", "Rituxan", "Simponi",
                "Stelara", "Taltz", "Tysabri");
        for (String answer : disqualifyQ14) {
            Log.info("Select answer for Q14: " + answer);
            biologicMedicationsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(eitherOfFollowingMedicationsOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7514", site.activeProtocols[0])
                    .back(biologicMedicationsPageOLS);
        }
        biologicMedicationsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(eitherOfFollowingMedicationsOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS7514", site.activeProtocols[1]);

        //Q15
        HowLongPsoriasisPageOLS howLongPsoriasisPageOLS = new HowLongPsoriasisPageOLS();
        List<String> disqualifyQ15 = Arrays.asList("Jakafi", "Olumiant", "Xeljanz");
        for (String answer : disqualifyQ15) {
            Log.info("Select answer for Q15: " + answer);
            eitherOfFollowingMedicationsOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(howLongPsoriasisPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS7515", site.activeProtocols)
                    .back(eitherOfFollowingMedicationsOLS);
        }
        eitherOfFollowingMedicationsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

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

        WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)",
                                "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)")
                        .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());

        List<String> disqualifyQS44 = Arrays.asList("Crohn's disease", "Ulcerative colitis");
        for (String answer : disqualifyQS44) {
            Log.info("Select answer for QS44: " + answer);
            whichOfFollowingDigestiveConditionPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                    .back(whichOfFollowingDigestiveConditionPageOLS);
        }
        whichOfFollowingDigestiveConditionPageOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Kidney disease")
                        .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        List<String> disqualifyQS51 = Arrays.asList("Dialysis", "Kidney transplant");
        for (String answer : disqualifyQS51) {
            Log.info("Select answer for QS51: " + answer);
            whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                    .waitForPageLoad()
                    .clickOnAnswers("Neither")
                    .clickOnAnswers(answer)
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                    .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);
        }
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());

        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                        .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());

        List<String> disqualifyQS53 = Arrays.asList("Bipolar disorder", "Schizophrenia");
        for (String answer : disqualifyQS53) {
            Log.info("Select answer for Q53: " + answer);
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
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS whichOfFollowingHaveYouDiagnosedWith_neurologicalOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, " +
                                "Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                        .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());

        whichOfFollowingHaveYouDiagnosedWith_neurologicalOLS
                .waitForPageLoad()
                .clickOnAnswers("Multiple sclerosis (MS)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_neurologicalOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);


        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        //Q24: QS59
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        List<String> disqualifyQ26 = Arrays.asList("Bipolar disorder",
                "Cancer in the past 5 years, except skin cancer",
                "Cirrhosis",
                "Drug or alcohol abuse within the past year",
                "HIV or AIDS");
        for (String answer : disqualifyQ26) {
            Log.info("Select answer for Q26: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        }
        List<String> disqualifyQ26pt2 = Arrays.asList("Kidney disease requiring dialysis", "Schizophrenia");
        for (String answer : disqualifyQ26pt2) {
            Log.info("Select answer for Q26: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
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

        AboutHealthPageOLS aboutHealthPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "144")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad2()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999")
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName + "!")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad3()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad3()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad();
        if (aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env, "5071")
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }

}
