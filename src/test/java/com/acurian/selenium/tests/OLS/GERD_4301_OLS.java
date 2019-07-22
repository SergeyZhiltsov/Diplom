package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.GERD.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class GERD_4301_OLS extends BaseTest {

    @Test
    @Description("GERD_4301_OLS")
    public void Gerd_4301_OLS() {
        Site site = Site.AUT_GER_4301_Site;
        String phoneNumber = "AUTAMSGERD";
        String studyName = "a heartburn or reflux";
        String site_Indication = "Gastroesophageal Reflux Disease (GERD)";

        String env = System.getProperty("acurian.env", "STG");

        //---------------Date of Birth Question-------------------
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle(studyName + " study", "500"), "Title is diff");

        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .setDate("08082005")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        lessThan18YearsOldPage_OLS.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();
        dateOfBirthPageOLS.waitForPageLoad();
        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());


        //---------------ZIP-CODE Question-------------------
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(), zipCodePageOLS.titleExpected, "Title is diff");
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        //---------------GENDER Question-------------------
        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DoYouExperienceAnyOfFollowingSymptoms_OLS doYouExperienceAnyOfFollowingSymptoms_OLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_OLS());


        //---------------Q2 DoYouExperienceAnyOfFollowingSymptoms_OLS page-------------------
        doYouExperienceAnyOfFollowingSymptoms_OLS
                .waitForPageLoad();
        Assert.assertEquals(doYouExperienceAnyOfFollowingSymptoms_OLS.getTitleText(), doYouExperienceAnyOfFollowingSymptoms_OLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = doYouExperienceAnyOfFollowingSymptoms_OLS
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6302", site.activeProtocols);
        debugPageOLS.back();
        doYouExperienceAnyOfFollowingSymptoms_OLS
                .waitForPageLoad();
        WhichoOfFollowingMedicationsCurrentlyGERD_OLS whichoOfFollowingMedicationsCurrentlyGERD_OLS = doYouExperienceAnyOfFollowingSymptoms_OLS
                .clickOnAnswers("GERD which has been diagnosed by a medical professional",
                        "Heartburn, which can be felt as pain or a burning sensation behind the breastbone",
                        "Acid reflux or frequent regurgitation, which is a sensation of liquid or food coming back up into your throat without vomiting")
                .clickNextButton(new WhichoOfFollowingMedicationsCurrentlyGERD_OLS());


        //---------------Q3 WhichoOfFollowingMedicationsCurrentlyGERD_OLS-------------------
        whichoOfFollowingMedicationsCurrentlyGERD_OLS
                .waitForPageLoad();
        Assert.assertEquals(whichoOfFollowingMedicationsCurrentlyGERD_OLS.getTitleText(), whichoOfFollowingMedicationsCurrentlyGERD_OLS.titleExpected, "Title is diff");
        HaveYouEverHadSurgeryOnStomach_OLS haveYouEverHadSurgeryOnStomach_OLS = whichoOfFollowingMedicationsCurrentlyGERD_OLS
                //----DQ if selected any of these options in Q3:  None of the above
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS());
        haveYouEverHadSurgeryOnStomach_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6303", site.activeProtocols);
        debugPageOLS.back();
        whichoOfFollowingMedicationsCurrentlyGERD_OLS
                .waitForPageLoad()
                .clickOnAnswers("Other")
                .clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS());
        haveYouEverHadSurgeryOnStomach_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6303", site.activeProtocols);
        debugPageOLS.back();
        whichoOfFollowingMedicationsCurrentlyGERD_OLS
                .waitForPageLoad();
        //----SKIP to Q5 if selected any of these options in Q3:  Aciphex (rabeprazole), Dexilant (dexlansoprazole), Protonix (pantoprazole), None of the above
        HowLongHaveYouBeenTaking_OLS howLongHaveYouBeenTaking_OLS = whichoOfFollowingMedicationsCurrentlyGERD_OLS
                .clickOnAnswers("Aciphex (rabeprazole)",
                        "Dexilant (dexlansoprazole)",
                        "Protonix (pantoprazole)")
                .clickNextButton(new HowLongHaveYouBeenTaking_OLS());
        howLongHaveYouBeenTaking_OLS
                .waitForMainPageLoad();
        debugPageOLS.back();
        whichoOfFollowingMedicationsCurrentlyGERD_OLS
                .waitForPageLoad();
        HowDoYouBuyFollowingMedications_OLS howDoYouBuyFollowingMedications_OLS = whichoOfFollowingMedicationsCurrentlyGERD_OLS
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
                .waitForPageLoad(4, howDoYouBuyFollowingMedications_OLS.titleExpected4);
        Assert.assertEquals(howDoYouBuyFollowingMedications_OLS.getTitleText(1), howDoYouBuyFollowingMedications_OLS.titleExpected1, "Title is diff");
        howDoYouBuyFollowingMedications_OLS
                .clickOnAnswerForSubQuestion(1, "With a prescription from my doctor that I get filled at the pharmacy counter")
                .clickOnAnswerForSubQuestion(2, "I get this medication off the shelf, or \"over-the-counter\"")
                .clickOnAnswerForSubQuestion(3, "With a prescription from my doctor that I get filled at the pharmacy counter")
                .clickOnAnswerForSubQuestion(4, "I get this medication off the shelf, or \"over-the-counter\"")
                .clickNextButton(new HowLongHaveYouBeenTaking_OLS());


        //---------------Q5 HowLongHaveYouBeenTaking_OLS-------------------
        howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howDoYouBuyFollowingMedications_OLS.titleExpected1)
                .waitForPageLoad(2, howDoYouBuyFollowingMedications_OLS.titleExpected2)
                .waitForPageLoad(3, howDoYouBuyFollowingMedications_OLS.titleExpected3)
                .waitForPageLoad(4, howDoYouBuyFollowingMedications_OLS.titleExpected4);
        Assert.assertEquals(howLongHaveYouBeenTaking_OLS.getTitleText(1), howLongHaveYouBeenTaking_OLS.titleExpected1, "Title is diff");
        HowOftenDoYouTake_OLS howOftenDoYouTake_OLS = howLongHaveYouBeenTaking_OLS
                .clickOnAnswerForSubQuestion(1, "Less than 1 month")
                .clickOnAnswerForSubQuestion(2, "1 month")
                .clickOnAnswerForSubQuestion(3, "Less than 1 month")
                .clickOnAnswerForSubQuestion(4, "1 month")
                .clickNextButton(new HowOftenDoYouTake_OLS());
        howOftenDoYouTake_OLS
                .waitForPageLoad(1, howDoYouBuyFollowingMedications_OLS.titleExpected1);
        debugPageOLS.checkProtocolsContainsForQNumber("QS6306", site.activeProtocols);
        debugPageOLS.back();
        howLongHaveYouBeenTaking_OLS
                .waitForPageLoad(1, howDoYouBuyFollowingMedications_OLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "2 months")
                .clickNextButton(new HowOftenDoYouTake_OLS());


        //---------------Q7 HowOftenDoYouTake_OLS-------------------
        howOftenDoYouTake_OLS
                .waitForPageLoad(1, howOftenDoYouTake_OLS.titleExpected1)
                .waitForPageLoad(2, howOftenDoYouTake_OLS.titleExpected2)
                .waitForPageLoad(3, howOftenDoYouTake_OLS.titleExpected3)
                .waitForPageLoad(4, howOftenDoYouTake_OLS.titleExpected4);
        //.waitForPageLoad(5,howOftenDoYouTake_OLS.titleExpected5)
        //.waitForPageLoad(6,howOftenDoYouTake_OLS.titleExpected6)
        //.waitForPageLoad(7,howOftenDoYouTake_OLS.titleExpected7);
        Assert.assertEquals(howOftenDoYouTake_OLS.getTitleText(1), howOftenDoYouTake_OLS.titleExpected1, "Title is diff");
        OnaTypicalDayWhenDoYouUsually_OLS onaTypicalDayWhenDoYouUsually_OLS = howOftenDoYouTake_OLS
                .clickOnAnswerForSubQuestion(1, "Twice a day")
                .clickOnAnswerForSubQuestion(2, "Twice a day")
                .clickOnAnswerForSubQuestion(3, "Other")
                .clickOnAnswerForSubQuestion(4, "Other")
                .clickNextButton(new OnaTypicalDayWhenDoYouUsually_OLS());
        onaTypicalDayWhenDoYouUsually_OLS
                .waitForPageLoad(1, onaTypicalDayWhenDoYouUsually_OLS.titleExpected1);
        debugPageOLS.checkProtocolsContainsForQNumber("QS6316", site.activeProtocols);
        debugPageOLS.back();
        howOftenDoYouTake_OLS
                .waitForPageLoad(1, howOftenDoYouTake_OLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "Only as needed (not regularly)")
                .clickOnAnswerForSubQuestion(2, "Only as needed (not regularly)")
                .clickOnAnswerForSubQuestion(3, "Once a day")
                .clickOnAnswerForSubQuestion(4, "Once a day")
                //.clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS());
                .clickNextButton(new OnaTypicalDayWhenDoYouUsually_OLS());


        //---------------Q9 OnaTypicalDayWhenDoYouUsually_OLS-------------------
        onaTypicalDayWhenDoYouUsually_OLS
                .waitForPageLoad(1, onaTypicalDayWhenDoYouUsually_OLS.titleExpected1)
                .waitForPageLoad(2, onaTypicalDayWhenDoYouUsually_OLS.titleExpected2)
                .waitForPageLoad(3, onaTypicalDayWhenDoYouUsually_OLS.titleExpected3)
                .waitForPageLoad(4, onaTypicalDayWhenDoYouUsually_OLS.titleExpected4);
        Assert.assertEquals(howLongHaveYouBeenTaking_OLS.getTitleText(1), onaTypicalDayWhenDoYouUsually_OLS.titleExpected1, "Title is diff");
        DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS despiteTakingMedicationDoYouStillExperienceSymptoms_OLS = onaTypicalDayWhenDoYouUsually_OLS
                .clickOnAnswerForSubQuestion(1, "Morning")
                .clickOnAnswerForSubQuestion(2, "Afternoon")
                .clickOnAnswerForSubQuestion(3, "Evening")
                .clickOnAnswerForSubQuestion(4, "Night")
                .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS());
        despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
                .waitForPageLoad();
        //debugPageOLS.checkProtocolsContainsForQNumber("QS6306", site.activeProtocols);
        debugPageOLS.back();
        onaTypicalDayWhenDoYouUsually_OLS
                .waitForPageLoad(1, onaTypicalDayWhenDoYouUsually_OLS.titleExpected1)
                .clickOnAnswerForSubQuestion(4, "Morning")
                .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS());


        //---------------Q10 DespiteTakingMedicationDoYouStillExperienceSymptoms_OLS-------------------
        despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
                .waitForPageLoad();
        Assert.assertEquals(despiteTakingMedicationDoYouStillExperienceSymptoms_OLS.getTitleText(), despiteTakingMedicationDoYouStillExperienceSymptoms_OLS.titleExpected, "Title is diff");
        despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
                .clickOnAnswer("No, my symptoms are well-controlled")
                .clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6307", site.activeProtocols);
        debugPageOLS.back();
        despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
                .waitForPageLoad();
        ThinkingAboutThePast2Months_OLS thinkingAboutThePast2Months_OLS = despiteTakingMedicationDoYouStillExperienceSymptoms_OLS
                .clickOnAnswer("Yes, I still have symptoms")
                .clickNextButton(new ThinkingAboutThePast2Months_OLS());


        //--------------Q11 ThinkingAboutThePast2Months_OLS ---------------------
        thinkingAboutThePast2Months_OLS
                .waitForPageLoad();
        Assert.assertEquals(thinkingAboutThePast2Months_OLS.getTitleText(), thinkingAboutThePast2Months_OLS.titleExpected, "Title is diff");
        HasYourDoctorToldYouThatYouHaveErosion_OLS hasYourDoctorToldYouThatYouHaveErosion_OLS = thinkingAboutThePast2Months_OLS
                .clickOnAnswer("1 day per week or less")
                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_OLS());
        hasYourDoctorToldYouThatYouHaveErosion_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6308", site.activeProtocols);
        debugPageOLS.back();
        thinkingAboutThePast2Months_OLS
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 days per week")
                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_OLS());
        hasYourDoctorToldYouThatYouHaveErosion_OLS
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6308", site.activeProtocols);
        debugPageOLS.back();
        thinkingAboutThePast2Months_OLS
                .waitForPageLoad()
                .clickOnAnswer("4 - 5 days per week")
                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_OLS());


        //--------------Q12 HasYourDoctorToldYouThatYouHaveErosion_OLS---------------------
        hasYourDoctorToldYouThatYouHaveErosion_OLS
                .waitForPageLoad();
        Assert.assertEquals(hasYourDoctorToldYouThatYouHaveErosion_OLS.getTitleText(), hasYourDoctorToldYouThatYouHaveErosion_OLS.titleExpected, "Title is diff");
        hasYourDoctorToldYouThatYouHaveErosion_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS())
                .waitForPageLoad();
        //debugPageOLS.checkProtocolsContainsForQNumber("QS6308", site.activeProtocols);
        debugPageOLS.back();
        hasYourDoctorToldYouThatYouHaveErosion_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS())
                .waitForPageLoad();
        //debugPageOLS.checkProtocolsContainsForQNumber("QS6308", site.activeProtocols);
        debugPageOLS.back();
        hasYourDoctorToldYouThatYouHaveErosion_OLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new HaveYouEverHadSurgeryOnStomach_OLS());


        //---------------Q13 HaveYouEverHadSurgeryOnStomach_OLS-------------------
        haveYouEverHadSurgeryOnStomach_OLS
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverHadSurgeryOnStomach_OLS.getTitleText(), haveYouEverHadSurgeryOnStomach_OLS.titleExpected, "Title is diff");
        AreYouCurrentlyAbleToSwallowTablets_OLS areYouCurrentlyAbleToSwallowTablets_OLS = haveYouEverHadSurgeryOnStomach_OLS
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_OLS())
                .waitForPageLoad();
        areYouCurrentlyAbleToSwallowTablets_OLS
                .back();
        haveYouEverHadSurgeryOnStomach_OLS
                .waitForPageLoad();
        WhatTypeOfSurgeryDidYouHave_OLS whatTypeOfSurgeryDidYouHave_OLS = haveYouEverHadSurgeryOnStomach_OLS
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatTypeOfSurgeryDidYouHave_OLS());


        //---------------Q14 WhatTypeOfSurgeryDidYouHave_OLS-------------------
        whatTypeOfSurgeryDidYouHave_OLS
                .waitForPageLoad();
        Assert.assertEquals(whatTypeOfSurgeryDidYouHave_OLS.getTitleText(), whatTypeOfSurgeryDidYouHave_OLS.titleExpected, "Title is diff");
        //---------SKIP to Q12 if selected "Other surgery on my stomach, intestines, colon, or esophagus"  or go to Q11--------
        whatTypeOfSurgeryDidYouHave_OLS
                .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
                .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_OLS())
                .waitForPageLoad()
                .back();
        whatTypeOfSurgeryDidYouHave_OLS
                .waitForPageLoad();
        WhenDidYouHaveAppendixRemoved_OLS whenDidYouHaveAppendixRemoved_OLS = whatTypeOfSurgeryDidYouHave_OLS
                .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
                .clickOnAnswers("Appendix removed - Appendectomy",
                        "Gallbladder removed - Cholecystectomy",
                        "Biopsy – removal of a small piece of tissue for analysis",
                        "Tonsils removed - Tonsillectomy",
                        "Hemorrhoids removed - Hemorrhoidectomy")
                .clickNextButton(new WhenDidYouHaveAppendixRemoved_OLS());


        //---------------Q15 WhenDidYouHaveAppendixRemoved_OLS-------------------
        whenDidYouHaveAppendixRemoved_OLS
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected1)
                .waitForPageLoad(2, whenDidYouHaveAppendixRemoved_OLS.titleExpected2);
        Assert.assertEquals(whenDidYouHaveAppendixRemoved_OLS.getTitleText(1), whenDidYouHaveAppendixRemoved_OLS.titleExpected1, "Title is diff");
        whenDidYouHaveAppendixRemoved_OLS
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(2, "4 - 6 months ago")
                .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_OLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6311", site.activeProtocols);
        debugPageOLS.back();
        whenDidYouHaveAppendixRemoved_OLS
                .waitForPageLoad(1, whenDidYouHaveAppendixRemoved_OLS.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_OLS());


        //---------------Q16 AreYouCurrentlyAbleToSwallowTablets_OLS-------------------
        areYouCurrentlyAbleToSwallowTablets_OLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6312", site.activeProtocols);
        debugPageOLS.back();
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
                .setAll("5", "5", "160")
                //----EthnicBackgroundPageOLS ------------
//                .clickNextButton(new EthnicBackgroundPageOLS())
//                .waitForPageLoad()
//                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new IdentificationPageOLS())
                // ----------PII (IdentificationPageOLS)
                // Page--------------------
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())

                //----------SiteSelection Page--------------------
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                //.clickNextButton(new HSGeneralPageOLS())
                //.waitForPageLoad(site_Indication)
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad()
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();

/*                //------------HUMAN API Interface in HelloSign----------------
                .getPage(new HumanAPIOLS())
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
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}