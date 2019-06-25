package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.GERD.*;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.utils.DataProviderPool;
import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GERD_4301_CC extends BaseTest {

    @Test()
    public void Gerd_4301_CC() {
        Site site = Site.AUT_GER_4301_Site;
        String phoneNumber = "AUTAMSGERD";
        String site_Indication = "a heartburn or reflux study";
        String site_Indication1 = "Gastroesophageal Reflux Disease (GERD)";
        String studyName = "heartburn, reflux, or GERD history";

        String env = System.getProperty("acurian.env", "STG");

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
                .typePhoneNumber(phoneNumber)
                .clickPopupPhoneNumber(phoneNumber)
                .clickBeginButton();

        callCenterIntroductionPageCC
                .waitForPageLoad();
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .activateDebugOnProd(env)
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());


        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.getExpectedModifiedTitle(site_Indication, "500"), "Title is diff");
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("2010")
                .clickOnAnswer("Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        dateOfBirthPageCC
                .waitForPageLoad();
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setYear("1960")
                .clickNextButton(new ZipCodePageCC());


        //-------------DOB Page----------------------------------
        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());


        //-------------GENDER Page--------------------------------
        DoYouExperienceAnyOfFollowingSymptoms_CC doYouExperienceAnyOfFollowingSymptoms_CC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new DoYouExperienceAnyOfFollowingSymptoms_CC());


        //-------------DoYouExperienceAnyOfFollowingSymptoms_CC----------------------------------
        doYouExperienceAnyOfFollowingSymptoms_CC
                .waitForPageLoad();
        NonQRtransitionPageCC nonQRtransitionPageCC = doYouExperienceAnyOfFollowingSymptoms_CC
                .clickOnAnswers("None of the above")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017973-QS6302-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        doYouExperienceAnyOfFollowingSymptoms_CC
                .waitForPageLoad();
        WhichoOfFollowingMedicationsCurrentlyGERD_CC whichoOfFollowingMedicationsCurrentlyGERD_CC = doYouExperienceAnyOfFollowingSymptoms_CC
                .clickOnAnswers("GERD which has been diagnosed by a medical professional",
                        "Heartburn, which can be felt as pain or a burning sensation behind the breastbone",
                        "Acid reflux or frequent regurgitation, which is a sensation of liquid or food coming back up into your throat without vomiting")
                .clickNextButton(new WhichoOfFollowingMedicationsCurrentlyGERD_CC());


        //-------------WhichoOfFollowingMedicationsCurrentlyGERD_CC----------------------------------
        whichoOfFollowingMedicationsCurrentlyGERD_CC
                .waitForPageLoad();
        Assert.assertEquals(whichoOfFollowingMedicationsCurrentlyGERD_CC.getTitleText(), whichoOfFollowingMedicationsCurrentlyGERD_CC.titleExpected, "Title is diff");
        //HaveYouEverHadSurgeryOnStomach_CC haveYouEverHadSurgeryOnStomach_CC = whichoOfFollowingMedicationsCurrentlyGERD_CC
        HasYourDoctorToldYouThatYouHaveErosion_CC hasYourDoctorToldYouThatYouHaveErosion_cc = whichoOfFollowingMedicationsCurrentlyGERD_CC
                //----DQ if selected any of these options in Q3:  None of the above
                .clickOnAnswers("None of the above")
                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_CC());
        hasYourDoctorToldYouThatYouHaveErosion_cc
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017975-QS6303-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        whichoOfFollowingMedicationsCurrentlyGERD_CC
                .waitForPageLoad()
                .clickOnAnswers("Other")
                .clickNextButton(hasYourDoctorToldYouThatYouHaveErosion_cc);
        hasYourDoctorToldYouThatYouHaveErosion_cc
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017975-QS6303-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        whichoOfFollowingMedicationsCurrentlyGERD_CC
                .waitForPageLoad();
        //----SKIP to Q5 if selected any of these options in Q3:  Aciphex (rabeprazole), Dexilant (dexlansoprazole), Protonix (pantoprazole), None of the above
        HowLongHaveYouBeenTaking_CC howLongHaveYouBeenTaking_CC = whichoOfFollowingMedicationsCurrentlyGERD_CC
                .clickOnAnswers("Aciphex, also known as rabeprazole (Agent Note: AH-si-fex, ruh-BEP-ruh-zole)",
                        "Dexilant, also known as dexlansoprazole (Agent Note: DEX-ih-lant, dex-lan-SOP-ruh-zole)",
                        "Protonix, also known as pantoprazole (Agent Note: pro-TAHN-ix, pan-TOP-ruh-zole)")
                .clickNextButton(new HowLongHaveYouBeenTaking_CC());
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1, howLongHaveYouBeenTaking_CC.titleExpected5)
                .waitForPageLoad(2, howLongHaveYouBeenTaking_CC.titleExpected6)
                .waitForPageLoad(3, howLongHaveYouBeenTaking_CC.titleExpected7)
                .back();
        whichoOfFollowingMedicationsCurrentlyGERD_CC
                .waitForPageLoad();
        HowDoYouBuyFollowingMedications_CC howDoYouBuyFollowingMedications_CC = whichoOfFollowingMedicationsCurrentlyGERD_CC
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Nexium, also known as esomeprazol (Agent Note: NEX-ee-um, eh-so-MEP-ruh-zole)",
                        "Prevacid, also known as lansoprazole (Agent Note: PREV-uh-sid, lan-SOP-ruh-zole)",
                        "Prilosec, also known as omeprazole (Agent Note: PRY-lo-sec, oh-MEP-ruh-zole)",
                        "Zegerid, also known as omeprazole and sodium bicarbonate (Agent Note: ZEGG-er-rid, oh-MEP-ruh-zole, SO-dee-um bi-CAR-bo-nate)")
                .clickNextButton(new HowDoYouBuyFollowingMedications_CC());


        //----------------Q4 HowDoYouBuyFollowingMedications_CC --------------
        howDoYouBuyFollowingMedications_CC
                .waitForPageLoad(1, howDoYouBuyFollowingMedications_CC.titleExpected1)
                .waitForPageLoad(2, howDoYouBuyFollowingMedications_CC.titleExpected2)
                .waitForPageLoad(3, howDoYouBuyFollowingMedications_CC.titleExpected3)
                .waitForPageLoad(4, howDoYouBuyFollowingMedications_CC.titleExpected4);
        Assert.assertEquals(howDoYouBuyFollowingMedications_CC.getTitleText(1), howDoYouBuyFollowingMedications_CC.titleExpected1, "Title is diff");
        howDoYouBuyFollowingMedications_CC
                .clickOnAnswerForSubQuestion(1, "With a prescription from my doctor that I get filled at the pharmacy counter")
                .clickOnAnswerForSubQuestion(2, "I get this medication off the shelf, or \"over-the-counter\"")
                .clickOnAnswerForSubQuestion(3, "With a prescription from my doctor that I get filled at the pharmacy counter")
                .clickOnAnswerForSubQuestion(4, "I get this medication off the shelf, or \"over-the-counter\"")
                .clickNextButton(new HowLongHaveYouBeenTaking_CC());


        //---------------Q5 HowLongHaveYouBeenTaking_CC-------------------
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1,howLongHaveYouBeenTaking_CC.titleExpected1)
                .waitForPageLoad(2,howLongHaveYouBeenTaking_CC.titleExpected2)
                .waitForPageLoad(3,howLongHaveYouBeenTaking_CC.titleExpected3)
                .waitForPageLoad(4,howLongHaveYouBeenTaking_CC.titleExpected4);
        Assert.assertEquals(howLongHaveYouBeenTaking_CC.getTitleText(1),howLongHaveYouBeenTaking_CC.titleExpected1, "Title is diff");
        HowOftenDoYouTake_CC howOftenDoYouTake_CC = howLongHaveYouBeenTaking_CC
                .clickOnAnswerForSubQuestion(1, "Less than 1 month")
                .clickOnAnswerForSubQuestion(2, "1 month")
                .clickOnAnswerForSubQuestion(3, "Less than 1 month")
                .clickOnAnswerForSubQuestion(4, "1 month")
                .clickNextButton(new HowOftenDoYouTake_CC());
        howOftenDoYouTake_CC
                .waitForPageLoad(1,howOftenDoYouTake_CC.titleExpected1);
        debugPageCC.checkProtocolsContainsForQNumber("Q0018004-QS6306-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        howLongHaveYouBeenTaking_CC
                .waitForPageLoad(1,howLongHaveYouBeenTaking_CC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "2 months")
                .clickNextButton(new HowOftenDoYouTake_CC());


        //---------------Q7 HowOftenDoYouTake_CC-------------------
        howOftenDoYouTake_CC
                .waitForPageLoad(1,howOftenDoYouTake_CC.titleExpected1)
                .waitForPageLoad(2,howOftenDoYouTake_CC.titleExpected2)
                .waitForPageLoad(3,howOftenDoYouTake_CC.titleExpected3)
                .waitForPageLoad(4,howOftenDoYouTake_CC.titleExpected4);
        //.waitForPageLoad(5,howOftenDoYouTake_CC.titleExpected5)
        //.waitForPageLoad(6,howOftenDoYouTake_CC.titleExpected6)
        //.waitForPageLoad(7,howOftenDoYouTake_CC.titleExpected7);
        Assert.assertEquals(howOftenDoYouTake_CC.getTitleText(1),howOftenDoYouTake_CC.titleExpected1, "Title is diff");
        OnaTypicalDayWhenDoYouUsually_CC onaTypicalDayWhenDoYouUsually_CC = howOftenDoYouTake_CC
                .clickOnAnswerForSubQuestion(1, "Twice a day")
                .clickOnAnswerForSubQuestion(2, "Twice a day")
                .clickOnAnswerForSubQuestion(3, "Other")
                .clickOnAnswerForSubQuestion(4, "Other")
                .clickNextButton(new OnaTypicalDayWhenDoYouUsually_CC());
        onaTypicalDayWhenDoYouUsually_CC
                .waitForPageLoad(1,onaTypicalDayWhenDoYouUsually_CC.titleExpected1);
        debugPageCC.checkProtocolsContainsForQNumber("Q0019978-QS6316-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        howOftenDoYouTake_CC
                .waitForPageLoad(1,howOftenDoYouTake_CC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "Only as needed (not regularly)")
                .clickOnAnswerForSubQuestion(2, "Only as needed (not regularly)")
                .clickOnAnswerForSubQuestion(3, "Once a day")
                .clickOnAnswerForSubQuestion(4, "Once a day")
                //.clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_CC());
                .clickNextButton(new OnaTypicalDayWhenDoYouUsually_CC());


        //---------------Q9 OnaTypicalDayWhenDoYouUsually_CC-------------------
        onaTypicalDayWhenDoYouUsually_CC
                .waitForPageLoad(1,onaTypicalDayWhenDoYouUsually_CC.titleExpected1)
                .waitForPageLoad(2,onaTypicalDayWhenDoYouUsually_CC.titleExpected2)
                .waitForPageLoad(3,onaTypicalDayWhenDoYouUsually_CC.titleExpected3)
                .waitForPageLoad(4,onaTypicalDayWhenDoYouUsually_CC.titleExpected4);
        Assert.assertEquals(howLongHaveYouBeenTaking_CC.getTitleText(1),onaTypicalDayWhenDoYouUsually_CC.titleExpected1, "Title is diff");
        DespiteTakingMedicationDoYouStillExperienceSymptoms_CC despiteTakingMedicationDoYouStillExperienceSymptoms_CC =  onaTypicalDayWhenDoYouUsually_CC
                .clickOnAnswerForSubQuestion(1,"Morning")
                .clickOnAnswerForSubQuestion(2, "Afternoon")
                .clickOnAnswerForSubQuestion(3, "Evening")
                .clickOnAnswerForSubQuestion(4, "Night")
                .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_CC());
        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
                .waitForPageLoad();
        //debugPageCC.checkProtocolsContainsForQNumber("Q0018004-QS6306-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        onaTypicalDayWhenDoYouUsually_CC
                .waitForPageLoad(1,onaTypicalDayWhenDoYouUsually_CC.titleExpected1)
                .clickOnAnswerForSubQuestion(4, "Morning")
                .clickNextButton(new DespiteTakingMedicationDoYouStillExperienceSymptoms_CC());



        //---------------Q10 DespiteTakingMedicationDoYouStillExperienceSymptoms_CC-------------------
        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
                .waitForPageLoad();
        Assert.assertEquals(despiteTakingMedicationDoYouStillExperienceSymptoms_CC.getTitleText(),despiteTakingMedicationDoYouStillExperienceSymptoms_CC.titleExpected, "Title is diff");
        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
                .clickOnAnswer("No, my symptoms are well-controlled")
                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_CC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0018005-QS6307-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        despiteTakingMedicationDoYouStillExperienceSymptoms_CC
                .waitForPageLoad();
        ThinkingAboutThePast2Months_CC thinkingAboutThePast2Months_CC = despiteTakingMedicationDoYouStillExperienceSymptoms_CC
                .clickOnAnswer("Yes, I still have symptoms")
                .clickNextButton(new ThinkingAboutThePast2Months_CC());


        //--------------Q11 ThinkingAboutThePast2Months_CC ---------------------
        thinkingAboutThePast2Months_CC
                .waitForPageLoad();
        Assert.assertEquals(thinkingAboutThePast2Months_CC.getTitleText(),thinkingAboutThePast2Months_CC.titleExpected, "Title is diff");
        HasYourDoctorToldYouThatYouHaveErosion_CC hasYourDoctorToldYouThatYouHaveErosion_CC = thinkingAboutThePast2Months_CC
                .clickOnAnswer("1 day per week or less")
                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_CC());
        hasYourDoctorToldYouThatYouHaveErosion_CC
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0018001-QS6308-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        thinkingAboutThePast2Months_CC
                .waitForPageLoad()
                .clickOnAnswer("2 - 3 days per week")
                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_CC());
        hasYourDoctorToldYouThatYouHaveErosion_CC
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0018001-QS6308-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        thinkingAboutThePast2Months_CC
                .waitForPageLoad()
                .clickOnAnswer("4 - 5 days per week")
                .clickNextButton(new HasYourDoctorToldYouThatYouHaveErosion_CC());


        //--------------Q12 HasYourDoctorToldYouThatYouHaveErosion_CC---------------------
        hasYourDoctorToldYouThatYouHaveErosion_CC
                .waitForPageLoad();
        Assert.assertEquals(hasYourDoctorToldYouThatYouHaveErosion_CC.getTitleText(),hasYourDoctorToldYouThatYouHaveErosion_CC.titleExpected, "Title is diff");
        hasYourDoctorToldYouThatYouHaveErosion_CC
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouEverHadSurgeryOnStomach_CC())
                .waitForPageLoad();
        //debugPageCC.checkProtocolsContainsForQNumber("Q0018004-QS6308-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        hasYourDoctorToldYouThatYouHaveErosion_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverHadSurgeryOnStomach_CC())
                .waitForPageLoad();
        //debugPageCC.checkProtocolsContainsForQNumber("Q0018004-QS6309-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        hasYourDoctorToldYouThatYouHaveErosion_CC
                .waitForPageLoad()
                .clickOnAnswer("Unsure");
        HaveYouEverHadSurgeryOnStomach_CC haveYouEverHadSurgeryOnStomach_CC = hasYourDoctorToldYouThatYouHaveErosion_CC
                .clickNextButton(new HaveYouEverHadSurgeryOnStomach_CC());


        //---------------Q13 HaveYouEverHadSurgeryOnStomach_CC-------------------
        haveYouEverHadSurgeryOnStomach_CC
                .waitForPageLoad();
        Assert.assertEquals(haveYouEverHadSurgeryOnStomach_CC.getTitleText(),haveYouEverHadSurgeryOnStomach_CC.titleExpected, "Title is diff");
        AreYouCurrentlyAbleToSwallowTablets_CC areYouCurrentlyAbleToSwallowTablets_CC = haveYouEverHadSurgeryOnStomach_CC
                .clickOnAnswer("No")
                .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_CC())
                .waitForPageLoad();
        areYouCurrentlyAbleToSwallowTablets_CC
                .back();
        haveYouEverHadSurgeryOnStomach_CC
                .waitForPageLoad();
        WhatTypeOfSurgeryDidYouHave_CC whatTypeOfSurgeryDidYouHave_CC = haveYouEverHadSurgeryOnStomach_CC
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatTypeOfSurgeryDidYouHave_CC());



        //---------------Q14 WhatTypeOfSurgeryDidYouHave_CC-------------------
        whatTypeOfSurgeryDidYouHave_CC
                .waitForPageLoad();
        Assert.assertEquals(whatTypeOfSurgeryDidYouHave_CC.getTitleText(),whatTypeOfSurgeryDidYouHave_CC.titleExpected, "Title is diff");
        //---------SKIP to Q12 if selected "Other surgery on my stomach, intestines, colon, or esophagus"  or go to Q11--------
        whatTypeOfSurgeryDidYouHave_CC
                .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
                .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_CC())
                .waitForPageLoad()
                .back();
        whatTypeOfSurgeryDidYouHave_CC
                .waitForPageLoad();
        WhenDidYouHaveAppendixRemoved_CC whenDidYouHaveAppendixRemoved_CC = whatTypeOfSurgeryDidYouHave_CC
                .clickOnAnswers("Other surgery on my stomach, intestines, colon, or esophagus")
                .clickOnAnswers("Appendix removed - Appendectomy (Agent Note: app-en-DECK-toe-mee)",
                        "Gallbladder removed - Cholecystectomy (Agent Note: cole-leh-sis-TECK-toe-mee)",
                        "Biopsy (Agent Note: BY-op-see) – removal of a small piece of tissue for analysis",
                        "Tonsils removed - Tonsillectomy (Agent Note: tahn-sil-LECK-toe-mee)",
                        "Hemorrhoids removed - Hemorrhoidectomy (Agent Note, HEM-roids, hem-roy-DECK-toe-mee)")
                .clickNextButton(new WhenDidYouHaveAppendixRemoved_CC());


        //---------------Q15 WhenDidYouHaveAppendixRemoved_CC-------------------
        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1,whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                .waitForPageLoad(2,whenDidYouHaveAppendixRemoved_CC.titleExpected2);
        Assert.assertEquals(whenDidYouHaveAppendixRemoved_CC.getTitleText(1),whenDidYouHaveAppendixRemoved_CC.titleExpected1, "Title is diff");
        whenDidYouHaveAppendixRemoved_CC
                .clickOnAnswerForSubQuestion(1, "1 - 3 months ago")
                .clickOnAnswerForSubQuestion(2, "4 - 6 months ago")
                .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_CC())
                .waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0017976-QS6311-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        whenDidYouHaveAppendixRemoved_CC
                .waitForPageLoad(1,whenDidYouHaveAppendixRemoved_CC.titleExpected1)
                .clickOnAnswerForSubQuestion(1, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(2, "More than 6 months ago")
                .clickNextButton(new AreYouCurrentlyAbleToSwallowTablets_CC());


        //---------------Q16 AreYouCurrentlyAbleToSwallowTablets_CC-------------------
        areYouCurrentlyAbleToSwallowTablets_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoadGERD(studyName);
        debugPageCC.checkProtocolsContainsForQNumber("Q0018000-QS6312-STUDYQUES", site.activeProtocols);
        debugPageCC.back();
        areYouCurrentlyAbleToSwallowTablets_CC
                .waitForPageLoad();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = areYouCurrentlyAbleToSwallowTablets_CC
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC())
                .waitForPageLoadGERD(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        //------------------General Health--------------------------
        WhatKindOfArthritisCC whatKindOfArthritisCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder", "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickOnAnswers("Autism spectrum", "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)", "Cancer", "Breathing, respiratory, or lung problems (COPD, asthma, chronic cough)")
                .clickOnAnswers("Diabetes (type 1 or type 2)", "Headaches (migraine, cluster, tension)")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)", "High blood pressure or hypertension", "High cholesterol, triglycerides, or lipids")
                .clickOnAnswers("Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)", "Stomach problems (Acid reflux, heartburn or GERD, Gastroparesis or delayed gastric emptying)","Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)", "Lupus", "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)")
                .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)", "Skin problems (eczema or atopic dermatitis, psoriasis)")
                .clickOnAnswers( "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickNextButton(new WhatKindOfArthritisCC());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC.back();
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis", "Bipolar disorder", "Cancer in the past 5 years, except skin cancer", "Drug or alcohol abuse within the past year")
                .clickOnAnswers("Hepatitis B", "Hepatitis C", "HIV or AIDS", "Kidney disease requiring dialysis", "Multiple sclerosis (MS)", "Neuropathy (nerve damage due to diabetes or another condition)")
                .clickOnAnswers("Seizure disorder such as epilepsy", "Schizophrenia")
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());

        LetMeSeePageCC letMeSeePageCC = approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "7", "166")
                .clickNextButton(new LetMeSeePageCC());


        letMeSeePageCC
                .waitForPageLoad()
//        		.clickNextButton(new ChildrenUnderPageCC())
//        		.waitForPageLoad()
//        		.clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(site_Indication)
                .getPID()
                .clickOnAnswer(site.name)
                //.clickNextButton(new HSGeneralCC())
                //.waitForPageLoad(site_Indication1)
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new SynexusHealthyMindsPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
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