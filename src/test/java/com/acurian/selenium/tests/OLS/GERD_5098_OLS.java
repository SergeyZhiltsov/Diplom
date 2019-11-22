package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.GERD.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.List;

public class GERD_5098_OLS extends BaseTest {

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
                {Site.AUT_AMS1_5098_site},
                //{Site.AUT_AMS1_5098S_site}
        };
    }

    @Test(dataProvider = "sites")
    @Description("GERD_5098_OLS")
    public void gerd5098ols(Site site) {
        final String phoneNumber = "AUTAMSGER1";
        final String studyName = "an indigestion, heartburn, or stomach ulcers";

        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS()
                .openPage(env, phoneNumber)
                .waitForPageLoad(studyName + " study", "300");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
        //        .getExpectedModifiedTitle(studyName + " study", "300"), "Title is diff");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle(studyName + " study", "300"), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .back();
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad(studyName + " study", "300")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        //---------------ZIP-CODE Question-------------------
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        DoYouExperienceAnyOfFollowingSymptoms_OLS doYouExperienceAnyOfFollowingSymptoms_OLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDate("09091980")
                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_OLS());


        //---------------Q2 DoYouExperienceAnyOfFollowingSymptoms_OLS page-------------------
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                doYouExperienceAnyOfFollowingSymptoms_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6302", site.activeProtocols)
                .back();
        WhichoOfFollowingMedicationsCurrentlyGERD_OLS whichoOfFollowingMedicationsCurrentlyGERD_OLS =
                doYouExperienceAnyOfFollowingSymptoms_OLS
                .waitForPageLoad()
                .clickOnAnswers("GERD which has been diagnosed by a medical professional",
                        "Heartburn, which can be felt as pain or a burning sensation behind the breastbone",
                        "Acid reflux or frequent regurgitation, which is a sensation of liquid or food coming back up into your throat without vomiting")
                .clickNextButton(new WhichoOfFollowingMedicationsCurrentlyGERD_OLS());


        //---------------Q3 WhichoOfFollowingMedicationsCurrentlyGERD_OLS-------------------
         HasYourDoctorToldYouThatYouHaveErosion_OLS hasYourDoctorToldYouThatYouHaveErosion_OLS= whichoOfFollowingMedicationsCurrentlyGERD_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //----DQ if selected any of these options in Q3:  None of the above
                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_OLS());
        hasYourDoctorToldYouThatYouHaveErosion_OLS
                .waitForPageLoad()
                .back();
        whichoOfFollowingMedicationsCurrentlyGERD_OLS
                .waitForPageLoad()
                .clickOnAnswers("Other")
                .clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS());
        hasYourDoctorToldYouThatYouHaveErosion_OLS
                .waitForPageLoad()
                .back();
        HowLongHaveYouBeenTaking_OLS howLongHaveYouBeenTaking_OLS = whichoOfFollowingMedicationsCurrentlyGERD_OLS
                .waitForPageLoad()
        //----SKIP to Q5 if selected any of these options in Q3:  Aciphex (rabeprazole), Dexilant (dexlansoprazole), Protonix (pantoprazole), None of the above
                .clickOnAnswers("Aciphex (rabeprazole)",
                        "Dexilant (dexlansoprazole)",
                        "Protonix (pantoprazole)")
                .clickNextButton(new HowLongHaveYouBeenTaking_OLS());
        howLongHaveYouBeenTaking_OLS
                .waitForMainPageLoad()
                .back();
        HowDoYouBuyFollowingMedications_OLS howDoYouBuyFollowingMedications_OLS =
                whichoOfFollowingMedicationsCurrentlyGERD_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Nexium (esomeprazole)",
                        "Prevacid (lansoprazole)",
                        "Prilosec (omeprazole)",
                        "Zegerid (omeprazole and sodium bicarbonate)")
                .clickNextButton(new HowDoYouBuyFollowingMedications_OLS());


        //----------------Q4 HowDoYouBuyFollowingMedications_OLS --------------
        howDoYouBuyFollowingMedications_OLS
                .waitForMainPageLoad()
                .waitForPageLoad(1, howDoYouBuyFollowingMedications_OLS.titleExpected1)
                .waitForPageLoad(2, howDoYouBuyFollowingMedications_OLS.titleExpected2)
                .waitForPageLoad(3, howDoYouBuyFollowingMedications_OLS.titleExpected3)
                .waitForPageLoad(4, howDoYouBuyFollowingMedications_OLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "With a prescription from my doctor that I get filled at the pharmacy counter")
                .clickOnAnswerForSubQuestion(2, "I get this medication off the shelf, or \"over-the-counter\"")
                .clickOnAnswerForSubQuestion(3, "With a prescription from my doctor that I get filled at the pharmacy counter")
                .clickOnAnswerForSubQuestion(4, "I get this medication off the shelf, or \"over-the-counter\"")
                .clickNextButton(new HowLongHaveYouBeenTaking_OLS());


        //---------------Q5 HowLongHaveYouBeenTaking_OLS-------------------
        HowOftenDoYouTake_OLS howOftenDoYouTake_OLS = howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howDoYouBuyFollowingMedications_OLS.titleExpected1)
                .waitForPageLoad(2, howDoYouBuyFollowingMedications_OLS.titleExpected2)
                .waitForPageLoad(3, howDoYouBuyFollowingMedications_OLS.titleExpected3)
                .waitForPageLoad(4, howDoYouBuyFollowingMedications_OLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Less than 1 month")
                .clickOnAnswerForSubQuestion(2, "1 month")
                .clickOnAnswerForSubQuestion(3, "Less than 1 month")
                .clickOnAnswerForSubQuestion(4, "1 month")
                .clickNextButton(new HowOftenDoYouTake_OLS());
        howOftenDoYouTake_OLS
                .waitForPageLoad(1, howDoYouBuyFollowingMedications_OLS.titleExpected1)
                .back();
        howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howDoYouBuyFollowingMedications_OLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "2 months")
                .clickNextButton(new HowOftenDoYouTake_OLS());


        //---------------Q7 HowOftenDoYouTake_OLS-------------------
        DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS despiteTakingMedicationDoYouStillExperienceSymptoms_OLS = howOftenDoYouTake_OLS
                .waitForPageLoad(1, howOftenDoYouTake_OLS.titleExpected1)
                .waitForPageLoad(2, howOftenDoYouTake_OLS.titleExpected2)
                .waitForPageLoad(3, howOftenDoYouTake_OLS.titleExpected3)
                .waitForPageLoad(4, howOftenDoYouTake_OLS.titleExpected4)
                .clickOnAnswerForSubQuestion(1, "Only as needed (not regularly)")
                .clickOnAnswerForSubQuestion(2, "Only as needed (not regularly)")
                .clickOnAnswerForSubQuestion(3, "Once a day")
                .clickOnAnswerForSubQuestion(4, "Once a day")
                .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS());


        //---------------Q10 DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS-------------------
        despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
                .waitForPageLoad()
                .clickOnAnswer("No, my symptoms are well-controlled")
                .clickNextButton(hasYourDoctorToldYouThatYouHaveErosion_OLS)
                .waitForPageLoad()
                .back();
        ThinkingAboutThePast2Months_OLS thinkingAboutThePast2Months_OLS =
                despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes, I still have symptoms")
                .clickNextButton(new ThinkingAboutThePast2Months_OLS());


        //--------------Q11 ThinkingAboutThePast2Months_OLS ---------------------
        hasYourDoctorToldYouThatYouHaveErosion_OLS =
                thinkingAboutThePast2Months_OLS
                .waitForPageLoad()
                .clickOnAnswer("1 day per week or less")
                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_OLS());
        hasYourDoctorToldYouThatYouHaveErosion_OLS
                .waitForPageLoad()
                .back();
        thinkingAboutThePast2Months_OLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 5 days per week")
                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_OLS());



        //--------------Q12 HasYourDoctorToldYouThatYouHaveErosion_OLS---------------------
        TestedForStomachInfectionHelicobacterOLS testedForStomachInfectionHelicobacterOLS =
                hasYourDoctorToldYouThatYouHaveErosion_OLS
                        .waitForPageLoad()
                        .clickOnAnswer("Unsure")
                        .clickOnAnswer("No")
                        .clickOnAnswer("Yes")
                        .clickNextButton(new TestedForStomachInfectionHelicobacterOLS());

        //----Q13	Have you ever been tested for a stomach infection called Helicobacter pylori or H. pylori?-----
        DidTestPositivePyloriOLS didTestPositivePyloriOLS = testedForStomachInfectionHelicobacterOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes") //Continue to Q14
                .clickNextButton(new DidTestPositivePyloriOLS());

        //Q15	Did you take medication to treat your H. pylori infection?
        DidTakeMedicationToTreatPyloriOLS didTakeMedicationToTreatPyloriOLS = didTestPositivePyloriOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes") //Continue to Q15
                .clickNextButton(new DidTakeMedicationToTreatPyloriOLS());
        MembersOfHouseholdBeenDiagnosedPyloriOLS membersOfHouseholdBeenDiagnosedPyloriOLS = didTakeMedicationToTreatPyloriOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new MembersOfHouseholdBeenDiagnosedPyloriOLS());
        membersOfHouseholdBeenDiagnosedPyloriOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6323", site.activeProtocols[1])
                .back(didTakeMedicationToTreatPyloriOLS)
                .clickOnAnswer("No")
                .clickOnAnswer("Unsure")
                .back();
        didTestPositivePyloriOLS
                .waitForPageLoad()
                .clickOnAnswer("No, I tested negative")
                .clickOnAnswer("Unsure")
                .clickNextButton(new MembersOfHouseholdBeenDiagnosedPyloriOLS());
        membersOfHouseholdBeenDiagnosedPyloriOLS
                .waitForPageLoad()
                .back(didTestPositivePyloriOLS)
                .waitForPageLoad()
                .back(testedForStomachInfectionHelicobacterOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickOnAnswer("Unsure")
                .clickNextButton(membersOfHouseholdBeenDiagnosedPyloriOLS);

//--------Q16	Have any members of your household (meaning people you live with) been diagnosed with H. pylori infection?
        DoYouHaveZollingerEllisonSyndrome_OLS doYouHaveZollingerEllisonSyndrome_OLS = membersOfHouseholdBeenDiagnosedPyloriOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickOnAnswer("No")
                .clickOnAnswer("Unsure")
                .clickNextButton(new DoYouHaveZollingerEllisonSyndrome_OLS());
//Element <ul class="radio-group radio-checkbox-group m_choices">...</ul> is not clickable at point (691, 192). Other element would receive the click: <div class="radio-question row ng-scope">...</div>
        WhatTypeOfSurgeryDidYouHave_OLS whatTypeOfSurgeryDidYouHave_OLS = doYouHaveZollingerEllisonSyndrome_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatTypeOfSurgeryDidYouHave_OLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6326", site.activeProtocols)
                .back(doYouHaveZollingerEllisonSyndrome_OLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhatTypeOfSurgeryDidYouHave_OLS());
        //---------------Q14 WhatTypeOfSurgeryDidYouHave_OLS-------------------
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = whatTypeOfSurgeryDidYouHave_OLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above") //Skip to Q20
                .clickNextButton(new WeightLossSurgeryPageOLS());

        List<String> disqualify = Arrays.asList("Gastric bypass",
                "Gastric sleeve or sleeve gastrectomy",
                "Duodenal switch",
                "Lap band or gastric banding",
                "Gastric balloon", "I had a weight loss surgery, but I am unsure which type");
        for (String answer : disqualify) {
            System.out.println(answer);
            weightLossSurgeryPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(new ProcedureForWeightLossPageOLS())
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6327", site.activeProtocols)
                    .back();
        }

        AreYouCurrentlyAbleToSwallowTablets_OLS areYouCurrentlyAbleToSwallowTablets_OLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_OLS());


//        areYouCurrentlyAbleToSwallowTablets_OLS
//                .waitForPageLoad()
//                .back(whatTypeOfSurgeryDidYouHave_OLS)
//                .waitForPageLoad()
//                .clickOnAnswers("Biopsy (Agent Note: BY-op-see) – removal of a small piece of tissue for analysis",
//                        "Tonsils removed - Tonsillectomy (Agent Note: tahn-sil-LECK-toe-mee)")
//                .clickNextButton(areYouCurrentlyAbleToSwallowTablets_OLS)
//                .waitForPageLoad()
//                .back();
//        WhenDidYouHaveAppendixRemoved_OLS whenDidYouHaveAppendixRemoved_OLS = whatTypeOfSurgeryDidYouHave_OLS
//                .waitForPageLoad()
//                .clickOnAnswers("None of the above")
//                .clickOnAnswers("Appendix removed - Appendectomy",
//                        "Gallbladder removed - Cholecystectomy",
//                        "Hemorrhoids removed - Hemorrhoidectomy",
//                        "Other surgery on my stomach, intestines, colon, or esophagus")
//                .clickNextButton(new WhenDidYouHaveAppendixRemoved_OLS());
//
//
//        //-----Q19.1	When did you have your appendix removed (appendectomy)? --------------
//        whenDidYouHaveAppendixRemoved_OLS
//                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected1)
//                .waitForPageLoad(2, whenDidYouHaveAppendixRemoved_OLS.titleExpected2)
//                .waitForPageLoad(3, whenDidYouHaveAppendixRemoved_OLS.titleExpected3)
//                .waitForPageLoad(4, whenDidYouHaveAppendixRemoved_OLS.titleExpected4)
//                .clickOnAnswerForSubQuestion(1, "Less than 1 month ago")
//                .clickOnAnswerForSubQuestion(2, "1 - 3 months ago")
//                .clickOnAnswerForSubQuestion(3, "4 - 6 months ago")
//                .clickOnAnswerForSubQuestion(4, "More than 6 months ago")
//                .clickNextButton(areYouCurrentlyAbleToSwallowTablets_OLS);


        //---------------Q20 AreYouCurrentlyAbleToSwallowTablets_OLS-------------------
        areYouCurrentlyAbleToSwallowTablets_OLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());



        //----------------------GENERAL HEALTH Questions -----------------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Lupus")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


        //----Do any of the following additional diagnoses apply to you? ------------
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad();
        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder",
                        "Cancer in the past 5 years, except skin cancer",
                        "Cirrhosis",
                        "Drug or alcohol abuse within the past year",
                        "Hepatitis B",
                        "Hepatitis",
                        "HIV or AIDS",
                        "Kidney disease requiring dialysis",
                        "Multiple sclerosis (MS",
                        "Neuropathy (nerve damage due to diabetes or another condition)",
                        "Seizure disorder such as epilepsy",
                        "Schizophrenia")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());


        //----HEIGHT and WEIGHT Question ------------
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160");
        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .clickNextButton(new IdentificationPageOLS());
                // ----------PII (IdentificationPageOLS)

        identificationPageOLS
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode);
        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .clickNextButton(new SiteSelectionPageOLS());

        //----------SiteSelection Page--------------------
        siteSelectionPageOLS
                .waitForPageLoad("a heartburn or reflux study, "+studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS())
                //.waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForSENRPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}