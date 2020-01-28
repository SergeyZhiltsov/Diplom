package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.OA_3138.SubquestionCurrentlyTakingPainMedicationPageOLS;
import com.acurian.selenium.pages.OLS.OA_3138.SubquestionHowManyTotalDaysYouTakeFollowingNSAIDOLS;
import com.acurian.selenium.pages.OLS.OA_3138.SubquestionNSAIDMedicationPageOLS;
import com.acurian.selenium.pages.OLS.PsoriaticArthritis.PsoriaticArthritisConditionPageOLS;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OA_4831_OLS_A_S extends BaseTest {

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
           //     {Site.AUT_OA_4831_Syn},
                {Site.AUT_OA_4831_site}
        };
    }

    @Test(dataProvider = "sites")
    public void OA_4831_OLS_NonSynexus_Script(Site site) {
        String phoneNumber = "AUTAMS1OA1";
        String studyName = "an osteoarthritis";

        String env = System.getProperty("acurian.env", "STG");


        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS.openPage(env, phoneNumber)
                .waitForPageLoad("an osteoarthritis study", "850");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                        .getExpectedModifiedTitle("an osteoarthritis study", "850"),
//                "Title is diff");


        //------------Disqualify (“Age < 18 years old”) if <18 -----------------------------------------
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad("an osteoarthritis study", "850")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        DoYouSufferFromArthritis doYouSufferFromArthritis = genderPageOLS
                .waitForPageLoad()
                .setDate("09091980")
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouSufferFromArthritis());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                doYouSufferFromArthritis
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4502", site.activeProtocols)
                .back();

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = doYouSufferFromArthritis
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4503", site.activeProtocols)
                .back();

        PsoriaticArthritisConditionPageOLS psoriaticArthritisConditionPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Psoriatic Arthritis") //Select
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints") //Deselect
                .clickNextButton(new PsoriaticArthritisConditionPageOLS());
        psoriaticArthritisConditionPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4503", site.activeProtocols)
                .back();


        WhereYouHaveArthritisOLS whereYouHaveArthritisOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging") //Select
                .clickOnAnswers("Psoriatic Arthritis") //Deselect
                .clickNextButton(new WhereYouHaveArthritisOLS());

        whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Spine or shoulders")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4504", site.activeProtocols)
                .back();

        AnyMedicationForYourArthritisOLS anyMedicationForYourArthritisOLS = whereYouHaveArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("Left Knee")
                .clickOnAnswer("Spine or shoulders")
                .clickNextButton(new AnyMedicationForYourArthritisOLS());


        NSAIDMedicationOLS nSAIDMedicationOLS = anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("I do not take any medication for arthritis pain") // Disqualify ("Frequency of analgesic use")
                .clickNextButton(new NSAIDMedicationOLS());
        nSAIDMedicationOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4520", site.activeProtocols)
                .back();
        anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 days per week or less") // Disqualify ("Frequency of analgesic use")
                .clickNextButton(nSAIDMedicationOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4520", site.activeProtocols)
                .back();

        anyMedicationForYourArthritisOLS
                .waitForPageLoad()
                .clickOnAnswer("3 days per week")
                .clickNextButton(nSAIDMedicationOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //"Skip to Q10 //Disqualify ("No history of NSAIDs")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4505", site.activeProtocols)
                .back();

        SubquestionNSAIDMedicationPageOLS subquestionNSAIDMedicationPageOLS =
                nSAIDMedicationOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Aspirin (Anacin, Ascriptin, Bayer, Bufferin, Ecotrin, Excedrin)",
                                "Naproxen (Aleve, Naprosyn, Naprelan, Anaprox)",
                                "Ibuprofen (Motrin, Advil, Nuprin)",
                                "Indomethacin (Indocin)",
                                "Celebrex (celecoxib)",
                                "Meloxicam (Mobic)",
                                "Ketoprofen (Orudis, Oruvail)",
                                "Fenoprofen (Nalfon)",
                                "Diclofenac (Cataflam, Voltaren, Arthrotec)",
                                "Ketorolac (Sprix, Toradol)",
                                "Piroxicam (Feldene)",
                                "Flurbiprofen (Ansaid)",
                                "Magnesium salicylate (Arthritab, Bayer Select, Magan, Mobidin, Mobogesic)",
                                "Nabumetone (Relafen)",
                                "Oxaprozin (Daypro)",
                                "Sulindac")
                        .clickNextButton(new SubquestionNSAIDMedicationPageOLS());

        SubquestionHowManyTotalDaysYouTakeFollowingNSAIDOLS subquestionHowManyTotalDaysYouTakeFollowingNSAIDOLS =
                subquestionNSAIDMedicationPageOLS
                        .waitForPageLoad(1, subquestionNSAIDMedicationPageOLS.titleExpected1)
                        .waitForPageLoad(2, subquestionNSAIDMedicationPageOLS.titleExpected2)
                        .waitForPageLoad(3, subquestionNSAIDMedicationPageOLS.titleExpected3)
                        .waitForPageLoad(4, subquestionNSAIDMedicationPageOLS.titleExpected4)
                        .waitForPageLoad(5, subquestionNSAIDMedicationPageOLS.titleExpected5)
                        .waitForPageLoad(6, subquestionNSAIDMedicationPageOLS.titleExpected6)
                        .waitForPageLoad(7, subquestionNSAIDMedicationPageOLS.titleExpected7)
                        .waitForPageLoad(8, subquestionNSAIDMedicationPageOLS.titleExpected8)
                        .waitForPageLoad(9, subquestionNSAIDMedicationPageOLS.titleExpected9)
                        .waitForPageLoad(10, subquestionNSAIDMedicationPageOLS.titleExpected10)
                        .waitForPageLoad(11, subquestionNSAIDMedicationPageOLS.titleExpected11)
                        .waitForPageLoad(12, subquestionNSAIDMedicationPageOLS.titleExpected12)
                        .waitForPageLoad(13, subquestionNSAIDMedicationPageOLS.titleExpected13)
                        .waitForPageLoad(14, subquestionNSAIDMedicationPageOLS.titleExpected14)
                        .waitForPageLoad(15, subquestionNSAIDMedicationPageOLS.titleExpected15)
                        .waitForPageLoad(16, subquestionNSAIDMedicationPageOLS.titleExpected16)
                        .clickOnAnswerForAllSubQuestion("Yes")
                        .clickNextButton(new SubquestionHowManyTotalDaysYouTakeFollowingNSAIDOLS());

        TreatedYourArthritisPainAcetaminophenOLS treatedYourArthritisPainAcetaminophenOLS =
                subquestionHowManyTotalDaysYouTakeFollowingNSAIDOLS
                        .waitForPageLoad(1, subquestionNSAIDMedicationPageOLS.titleExpected1)
                        .waitForPageLoad(2, subquestionNSAIDMedicationPageOLS.titleExpected2)
                        .waitForPageLoad(3, subquestionNSAIDMedicationPageOLS.titleExpected3)
                        .waitForPageLoad(4, subquestionNSAIDMedicationPageOLS.titleExpected4)
                        .waitForPageLoad(5, subquestionNSAIDMedicationPageOLS.titleExpected5)
                        .waitForPageLoad(6, subquestionNSAIDMedicationPageOLS.titleExpected6)
                        .waitForPageLoad(7, subquestionNSAIDMedicationPageOLS.titleExpected7)
                        .waitForPageLoad(8, subquestionNSAIDMedicationPageOLS.titleExpected8)
                        .waitForPageLoad(9, subquestionNSAIDMedicationPageOLS.titleExpected9)
                        .waitForPageLoad(10, subquestionNSAIDMedicationPageOLS.titleExpected10)
                        .waitForPageLoad(11, subquestionNSAIDMedicationPageOLS.titleExpected11)
                        .waitForPageLoad(12, subquestionNSAIDMedicationPageOLS.titleExpected12)
                        .waitForPageLoad(13, subquestionNSAIDMedicationPageOLS.titleExpected13)
                        .waitForPageLoad(14, subquestionNSAIDMedicationPageOLS.titleExpected14)
                        .waitForPageLoad(15, subquestionNSAIDMedicationPageOLS.titleExpected15)
                        .waitForPageLoad(16, subquestionNSAIDMedicationPageOLS.titleExpected16)
                        .clickOnAnswerForAllSubQuestion("1 day per week or less")
                        .clickNextButton(new TreatedYourArthritisPainAcetaminophenOLS());

        PrescriptionPainMedicationsForArthritis prescriptionPainMedicationsForArthritis = treatedYourArthritisPainAcetaminophenOLS
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(new PrescriptionPainMedicationsForArthritis());

        HasYourDoctorEverPrescribedOpioidNarcoticOLS hasYourDoctorEverPrescribedOpioidNarcotic_OLS = prescriptionPainMedicationsForArthritis
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Skip to Q13
                .clickNextButton(new HasYourDoctorEverPrescribedOpioidNarcoticOLS());
        hasYourDoctorEverPrescribedOpioidNarcotic_OLS
                .waitForPageLoad()
                .clickOnAnswer("No, my doctor never offered me a prescription for opioids or narcotics for pain")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4511", site.activeProtocols)
                .back(hasYourDoctorEverPrescribedOpioidNarcotic_OLS)
                .waitForPageLoad()
                .back(prescriptionPainMedicationsForArthritis);

        SubquestionCurrentlyTakingPainMedicationPageOLS subquestionCurrentlyTakingPainMedicationPageOLS =
                prescriptionPainMedicationsForArthritis
                        .waitForPageLoad()
                        .clickOnAnswers("Oxycodone (Oxaydo, Oxycontin, Roxicodone)",
                                "Oxycodone and acetaminophen (Endocet, Percocet, Primlev, Roxicet, Xartemis)",
                                "Hydrocodone (Hysingla, Zohydro)",
                                "Hydrocodone and acetaminophen (Hycet, Lortab, Norco, Verdrocet, Vicodin, Xodol, Zamicet)",
                                "Tramadol (ConZip, Synapryn FusePaq, Ultram)",
                                "Morphine (Astramorph, Duramorph, Infumorph, Kadian, MS Contin)",
                                "Morphine and naltrexone (Embeda)",
                                "Meperidine (Demerol, Meperitab)",
                                "Fentanyl (Abstral, Actiq, Fentora, Lazanda, Subsys)",
                                "Fentanyl patch (Duragesic, Ionsys)",
                                "Codeine",
                                "Tylenol #3 or Tylenol #4 (acetaminophen with codeine)",
                                "Capital with codeine",
                                "Oxymorphone (Opana)",
                                "Hydromorphone (Dilaudid, Exalgo)",
                                "Methadone (Dolophine, Intensol, Methadose)",
                                "Buprenorphine (Belbuca, Buprenex, Butrans)",
                                "Buprenorphine and naloxone (Suboxone)",
                                "Oxycodone and naloxone")
                        .clickNextButton(new SubquestionCurrentlyTakingPainMedicationPageOLS());

        subquestionCurrentlyTakingPainMedicationPageOLS
                .waitForPageLoad(1, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected1)
                .waitForPageLoad(2, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected2)
                .waitForPageLoad(3, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected3)
                .waitForPageLoad(4, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected4)
                .waitForPageLoad(5, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected5)
                .waitForPageLoad(6, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected6)
                .waitForPageLoad(7, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected7)
                .waitForPageLoad(8, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected8)
                .waitForPageLoad(9, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected9)
                .waitForPageLoad(10, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected10)
                .waitForPageLoad(11, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected11)
                .waitForPageLoad(12, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected12)
                .waitForPageLoad(13, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected13)
                .waitForPageLoad(14, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected14)
                .waitForPageLoad(15, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected15)
                .waitForPageLoad(16, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected16)
                .waitForPageLoad(17, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected17)
                .waitForPageLoad(18, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected18)
                .waitForPageLoad(19, subquestionCurrentlyTakingPainMedicationPageOLS.titleExpected19)
                .clickOnAnswerForAllSubQuestion("Yes")
                .clickNextButton(new AreYouCurrentlyOnPageOLS());

        HashMap<String, List<String>> disqualifyQ15 = new HashMap<>();
        AreYouCurrentlyOnPageOLS areYouCurrentlyOnPageOLS = new AreYouCurrentlyOnPageOLS();
        disqualifyQ15.put("Yes, for arthritis", Arrays.asList(site.activeProtocols));
        disqualifyQ15.put("Yes, for another chronic condition", Arrays.asList(site.activeProtocols));
        disqualifyQ15.put("I am currently taking a short course of steroids (10 days or less)", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ15.entrySet()) {
            areYouCurrentlyOnPageOLS
                    .waitForPageLoad()
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);
            haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS4513", site.activeProtocols)
                    .back();
        }

        HaveYouEverHadKneeReplacementSurgeryOLS haveYouEverHadKneeReplacementSurgeryOLS = areYouCurrentlyOnPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverHadKneeReplacementSurgeryOLS());

        HaveYouEverReceivedInjectionIntoYourKneeOLS haveYouEverReceivedInjectionIntoYourKneeOLS = haveYouEverHadKneeReplacementSurgeryOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverReceivedInjectionIntoYourKneeOLS());

        haveYouEverReceivedInjectionIntoYourKneeOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, a joint fluid supplement injection such as Synvisc or Hyalgan") //Continue to Q18
                .clickNextButton(new HaveYouReceivedKneeInjectionWithinPast3MonthsOLS())
                .waitForPageLoad()
                .back(haveYouEverReceivedInjectionIntoYourKneeOLS);

        haveYouEverReceivedInjectionIntoYourKneeOLS
                .waitForPageLoad()
                .clickOnAnswer("I have never received a knee injection for my arthritis pain") //Skip to Q19
                .clickNextButton(new FollowingDevicesInYourBodyOLS());

        HashMap<String, List<String>> disqualifyQ19 = new HashMap<>();
        FollowingDevicesInYourBodyOLS followingDevicesInYourBodyOLS = new FollowingDevicesInYourBodyOLS();
        disqualifyQ19.put("A pacemaker", Arrays.asList(site.activeProtocols));
        disqualifyQ19.put("Aneurysm clip", Arrays.asList(site.activeProtocols));
        disqualifyQ19.put("Artificial heart valve", Arrays.asList(site.activeProtocols));
        for (Map.Entry<String, List<String>> entry : disqualifyQ19.entrySet()) {
            followingDevicesInYourBodyOLS
                    .waitForPageLoad()
                    .clickOnAnswer("None of the above")
                    .clickOnAnswer(entry.getKey())
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS4514", site.activeProtocols)
                    .back();
        }

        DiagnosedwithCarpalTunnelSyndrome diagnosedwithCarpalTunnelSyndrome = followingDevicesInYourBodyOLS
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickOnAnswer("Unsure")
                .clickNextButton(new DiagnosedwithCarpalTunnelSyndrome());

        WithinThePast6MonthsHaveYouHadNumbnessOLS withinThePast6MonthsHaveYouHadNumbnessOLS = diagnosedwithCarpalTunnelSyndrome
                .waitForPageLoad()
                .clickOnAnswer("Yes") //Continue to Q21
                .clickNextButton(new WithinThePast6MonthsHaveYouHadNumbnessOLS());

        AreYouCurrentlyReceivingWorkersPageOLS areYouCurrentlyReceivingWorkersPageOLS = withinThePast6MonthsHaveYouHadNumbnessOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AreYouCurrentlyReceivingWorkersPageOLS());

        areYouCurrentlyReceivingWorkersPageOLS
                .waitForPageLoad2()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4516", site.activeProtocols)
                .back(withinThePast6MonthsHaveYouHadNumbnessOLS)
                .waitForPageLoad()
                .back();

        diagnosedwithCarpalTunnelSyndrome
                .waitForPageLoad()
                .clickOnAnswer("No") //Skip to Q22
                .clickNextButton(areYouCurrentlyReceivingWorkersPageOLS);

        areYouCurrentlyReceivingWorkersPageOLS
                .waitForPageLoad2()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        //----------*******NEW GENERAL HEALTH Questions**************************----------
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


        //Q24: QS59
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        List<String> disqualifyQ26 = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Drug or alcohol abuse within the past year", "Hepatitis B", "Hepatitis C", "HIV or AIDS");
        for (String answer : disqualifyQ26) {
            System.out.println("Select answer for Q26: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                    .back();
        }
        List<String> disqualifyQ26pt2 = Arrays.asList("Kidney disease requiring dialysis", "Multiple sclerosis (MS)",
                "Neuropathy (nerve damage due to diabetes or another condition)");
        for (String answer : disqualifyQ26pt2) {
            System.out.println("Select answer for Q26: " + answer);
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
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
                .clickNextButton(approximateHeightPageOLS)
                //----------ProvideHeight-Weight Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
//                .clickNextButton(new EthnicBackgroundPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                //----------PII (IdentificationPageOLS) Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad2();
        AboutHealthPageOLS aboutHealthPageOLS = new AboutHealthPageOLS();
        aboutHealthPageOLS
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .threadSleep(2000);

        switch (site) {
            case AUT_OA_4831_Syn: //41C
                aboutHealthPageOLS
                        .pidFromDbToLog(env)
                        .getRadiantDbToLog(env)
                        .getAnomalyDbToLog(env)
                        .childPidFromDbToLog(env, "4831")
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
            case AUT_OA_4831_site: //1R
                aboutHealthPageOLS
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env, "4831")
                        .assertGeneratedFul(env, site)
                        .dispoShouldMatch(site.dispo, site.dispo);
                break;
        }
    }
}