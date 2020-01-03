package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.GERD.DoYouExperienceAnyOfFollowingSymptoms_OLS;
import com.acurian.selenium.pages.OLS.HOTF_7119.DoyouExperienceHotFlashesOLS;
import com.acurian.selenium.pages.OLS.LOWT_3017.CardiovascularDiseaseThanOthersPageOLS;
import com.acurian.selenium.pages.OLS.Obesity_4605.ExperienceExcessiveHungerOrIncreasedAppetiteOLS;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.Vaccine.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouGoneThroughMenopauseOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.DRSBlinx;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VACC_JANRSV_OLS extends BaseTest {

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
                {Site.JANRSV_AUT_JANDS},
                {Site.AUT_AMS_JANRSV_Syn},
                {Site.AUT_AMS_JANRSV}
        };
    }

    @Test(dataProvider = "sites")
    @Description("VACC_4556_OLS")
    public void vaccJANRSVOlsTest(Site site) {
        final String phoneNumber = "AUTAMS1VAC";
        final String studyName = "a vaccine";
        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a vaccine study", "650");
//        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS
//                .getExpectedModifiedTitle(studyName, "650"), "Title is diff");

        if (site == Site.JANRSV_AUT_JANDS) {
            HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                    new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();
            //DRSOLS drsols = new DRSOLS();
            DirectSheduleVaccOLS directSheduleVaccOLS = new DirectSheduleVaccOLS();
            DRSBlinx dRSBlinx = new DRSBlinx();
            dateOfBirthPageOLS
                    .waitForPageLoad("a vaccine study", "650")
                    .clickOnAnswer("Yes")
                    .clickNextButton(new ZipCodePageOLS())
                    .waitForPageLoad()
                    .typeZipCode(site.zipCode)
                    .clickNextButton(dateOfBirthPageOLS)
                    .waitForPageLoad1()
                    .clickOnAnswer("Female")
                    .setDate("01011954")
                    .clickNextButton(new AreYouInterestedVaccineResearchStudyOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(new AreYouGenerallyInGoodHealthOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(new AllergicToAnyVaccinesOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Unsure")
                    .clickNextButton(new HaveYouGoneThroughMenopauseOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(new ApproximateHeightPageOLS())
                    .waitForPageLoad()
                    .setAll("5", "5", "150")
                    .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new RequirePassDrugTestOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(new IdentificationPageOLS())
                    .waitForPageLoad2()
                    .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                            "9999999999", site.zipCode)
                    .clickNextButton(new SiteSelectionPageOLS())
                    .waitForPageLoad1("a vaccine study!")
                    .getPID()
                    .clickOnFacilityName(site.name)
                    .clickNextButton(directSheduleVaccOLS);
            if(env.equals("PRD")){
                directSheduleVaccOLS
                        .waitForPageLoad();
            }
            if(env.equals("STG")){
                directSheduleVaccOLS
                        .waitForPageLoadSTG();
            }
            directSheduleVaccOLS
                    .clickSheduleBtnBlinx(dRSBlinx);
            ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
            getDriver().switchTo().window(tabs.get(1));
            dRSBlinx
                    .waitForPageLoadBlinx()
//                    .clickOnBtnNoApp()
//                    .waitForUnf()
//                    .clickOnBtnPrev()
                    .clickOnDay()
                    .clickOnTime()
                    .clickOnNext()
                    .waitForPageLoadClientDetails()
                    .dateCheck()
                    .startsAtCheck()
                    .serviceProviderCheck();

                    //.assertClientData("qa.acurian@gmail.com", "9999999999")
//                    .clickBook()
//                    .waitForPageLoadSuccess()
//                    .clickOnBtnNext()
//                    .waitForThankYou();
//            if(env.equals("PRD")){
//                directSheduleVaccOLS
//                        .waitForPageLoad();
//            }
//            if(env.equals("STG")){
//                directSheduleVaccOLS
//                        .waitForPageLoadSTG();
//            }
//            directSheduleVaccOLS
//                    .clickSheduleBtn(drsols);
//            drsols
//                    .waitForPageLoad()
//                    .clickOnDay()
//                    .clickOnTime()
//                    .waitForPageLoadClientDetails()
//                    .dateCheck()
//                    .startsAtCheck()
//                    .serviceProviderCheck()
//                    .clickOnAgree();
//            getDriver().switchTo().window(tabs.get(0));
//            QualifiedClose2PageOLS qualifiedClose2PageOLS = new QualifiedClose2PageOLS();
//            if(env.equals("PRD")){
//                directSheduleVaccOLS
//                        .waitForPageLoad();
//            }
//            if(env.equals("STG")){
//                directSheduleVaccOLS
//                        .waitForPageLoadSTG();
//            }
//            directSheduleVaccOLS
//                    .clickNextButton(qualifiedClose2PageOLS);
            getDriver().switchTo().window(tabs.get(0));
            DirectSheduleVaccOLS directSheduleBlinx = new DirectSheduleVaccOLS();
            if(env.equals("PRD")){
                directSheduleBlinx
                        .waitForPageLoad();
            }
            if(env.equals("STG")){
                directSheduleBlinx
                        .waitForPageLoadSTG();
            }
            QualifiedClose2PageOLS qualifiedClose2PageOLS = directSheduleBlinx
                    .clickNextButton(new QualifiedClose2PageOLS());
            ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                    .waitForPageLoad()
                    .clickNextButton(new ThankYouCloseSimplePageOLS());

//            ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = synexusHealthyMindsPageOLS
//                    .waitForPageLoad()
//                    .clickOnAnswer("No, I am not interested in receiving information")
//                    .clickNextButton(new ThankYouCloseSimplePageOLS());

            AlzheimerClosePageOLS alzheimerClosePageOLS = thankYouCloseSimplePageOLS
                    .waitForPageLoad2()
                    .clickNextButton(new AlzheimerClosePageOLS());
            AboutHealthPageOLS aboutHealthPageOLS = alzheimerClosePageOLS
                    .waitForPageLoad()
                    .clickNextButton(new AboutHealthPageOLS());
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .dispoShouldMatch(site.dispo, site.dispo);

        } else {

        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();


        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad("a vaccine study", "650")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(dateOfBirthPageOLS)
                .waitForPageLoad1()
                .clickOnAnswer("Female")
                .setDate("01012003")
                .clickNextButton(lessThan18YearsOldPageOLS);
        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                dateOfBirthPageOLS
                        .waitForPageLoad1()
                        .setDate("01011955")
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        AreYouInterestedVaccineResearchStudyOLS areYouInterestedVaccineResearchStudyOLS = dateOfBirthPageOLS
                .waitForPageLoad1()
                .setDate("01011954")
                .clickNextButton(new AreYouInterestedVaccineResearchStudyOLS());

            AreYouGenerallyInGoodHealthOLS areYouGenerallyInGoodHealthOLS = areYouInterestedVaccineResearchStudyOLS
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6908", site.activeProtocols)
                    .back(areYouInterestedVaccineResearchStudyOLS)
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(new AreYouGenerallyInGoodHealthOLS());


            AllergicToAnyVaccinesOLS allergicToAnyVaccinesOLS = areYouGenerallyInGoodHealthOLS
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new AllergicToAnyVaccinesOLS());
            allergicToAnyVaccinesOLS
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6909", site.activeProtocols)
                    .back(areYouGenerallyInGoodHealthOLS)
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(allergicToAnyVaccinesOLS);


            HaveYouGoneThroughMenopauseOLS haveYouGoneThroughMenopauseOLS = allergicToAnyVaccinesOLS
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(new HaveYouGoneThroughMenopauseOLS());
            haveYouGoneThroughMenopauseOLS
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6910", site.activeProtocols)
                    .back(allergicToAnyVaccinesOLS)
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickOnAnswer("Unsure")
                    .clickNextButton(haveYouGoneThroughMenopauseOLS);


            haveYouGoneThroughMenopauseOLS
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS6911", site.activeProtocols)
                    .back(haveYouGoneThroughMenopauseOLS)
                    .waitForPageLoad()
                    .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                    .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                    .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                    .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

            //#############General_Health ###########################
            DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS =
                    haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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
                            .clickOnAnswers("Lupus")
                            .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());


            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS38", site.activeProtocols)
                    .back();
            WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                    .clickNextButton(new WhatKindOfArthritisPageOLS());


            whatKindOfArthritisPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                    .back();

            whatKindOfArthritisPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                    .clickOnAnswers("Psoriatic Arthritis")
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                    .back(whatKindOfArthritisPageOLS)
                    .waitForPageLoad()
                    .clickOnAnswers("Psoriatic Arthritis") //deselect
                    .clickOnAnswers("Osteoarthritis, the most common form of arthritis, caused by wear and tear on the joints due to aging")
                    .back();
            WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS =
                    haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                            .waitForPageLoad()
                            .clickOnAnswers("None of the above")
                            .clickOnAnswers("Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)")
                            .clickNextButton(new WhichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS());


            whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS
                    .waitForPageLoad()
                    .clickOnAnswers("Ankylosing spondylitis or axial spondyloarthritis")
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS40", site.activeProtocols)
                    .back(whichOfTheFollowingHaveYouBeenDiagnosedBonesJoints_OLS)
                    .waitForPageLoad()
                    .clickOnAnswers("Gout", "Low back pain", "Osteoporosis") //deselect
                    .clickOnAnswers("None of the above")
                    .back();
            WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS =
                    haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
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
                    .clickOnAnswer("6 - 10 years ago")
                    .clickOnAnswer("11 or more years ago")
                    .clickOnAnswer("Diagnosed with skin cancer only")
                    .back();
            WhichOfFollowingDigestiveConditionPageOLS whichOfFollowingDigestiveConditionPageOLS =
                    haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                            .waitForPageLoad()
                            .clickOnAnswers("None of the above")
                            .clickOnAnswers("Intestinal disorders (IBS or irritable bowel syndrome, IBD, Crohn's disease, ulcerative colitis)")
                            .clickNextButton(new WhichOfFollowingDigestiveConditionPageOLS());

            List<String> disqualifyQ8QS44 = Arrays.asList("Crohn's disease", "Ulcerative colitis");
            for (String answer : disqualifyQ8QS44) {
                System.out.println("Select answer for Q8:QS44: " + answer);
                whichOfFollowingDigestiveConditionPageOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers(answer)
                        .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QS44", site.activeProtocols)
                        .back();
            }
            whichOfFollowingDigestiveConditionPageOLS
                    .waitForPageLoad()
                    .back();
            WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS =
                    haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                            .waitForPageLoad()
                            .clickOnAnswers("None of the above")
                            .clickOnAnswers("Kidney disease")
                            .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());


            List<String> disqualifyQ6QS51 = Arrays.asList("Dialysis", "Kidney transplant");
            for (String answer : disqualifyQ6QS51) {
                System.out.println("Select answer for Q6:QS51: " + answer);
                whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                        .waitForPageLoad()
                        .clickOnAnswers("Neither")
                        .clickOnAnswers(answer)
                        .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                        .back();
            }
            whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
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
                    .clickOnAnswers("Fatty liver disease", "NASH (non-alcoholic steatohepatitis)",
                            "NAFLD (non-alcoholic fatty liver disease)")
                    .clickOnAnswers("Unsure which type of liver disease")
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
                System.out.println("Select answer for Q18:QS53: " + answer);
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
                    .back();
            WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS =
                    haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                            .waitForPageLoad()
                            .clickOnAnswers("None of the above")
                            .clickOnAnswers("Neurological issues (Alzheimer's disease, memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)")
                            .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS());


            //Q19: QS54
            List<String> disqualifyQ19 = Arrays.asList("Alzheimer's disease", "Multiple sclerosis (MS)");
            for (String answer : disqualifyQ19) {
                System.out.println("Select answer for Q19:QS54: " + answer);
                whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickOnAnswers(answer)
                        .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QS54", site.activeProtocols)
                        .back();
            }
            whichOfFollowingHaveYouDiagnosedWith_NeurologicalOLS
                    .waitForPageLoad()
                    .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);


            //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
            ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
            List<String> disqualifyQ24 = Arrays.asList("Bipolar disorder", "Cancer in the past 5 years, except skin cancer",
                    "Cirrhosis",
                    "Drug or alcohol abuse within the past year",
                    "Hepatitis B",
                    "Hepatitis C",
                    "HIV or AIDS");
            for (String answer : disqualifyQ24) {
                System.out.println("Select answer for Q24QS59: " + answer);
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
            List<String> disqualifyQ24pt2 = Arrays.asList("Kidney disease requiring dialysis", "Multiple sclerosis (MS)",
                    "Schizophrenia");
            for (String answer : disqualifyQ24pt2) {
                System.out.println("Select answer for Q24QS59: " + answer);
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
                    .clickNextButton(approximateHeightPageOLS);


            ExperienceExcessiveHungerOrIncreasedAppetiteOLS experienceExcessiveHungerOrIncreasedAppetiteOLS = approximateHeightPageOLS
                    .waitForPageLoad()
                    .setAll("5", "5", "250")
                    .clickNextButton(new ExperienceExcessiveHungerOrIncreasedAppetiteOLS());
            experienceExcessiveHungerOrIncreasedAppetiteOLS
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS60", site.activeProtocols)
                    .back();
            /*DoYouExperienceAnyOfFollowingSymptoms_OLS doYouExperienceAnyOfFollowingSymptoms_OLS*/ IdentificationPageOLS identificationPageOLS= approximateHeightPageOLS
                    .waitForPageLoad()
                    .setLbs("150")
                    .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new RequirePassDrugTestOLS())
                    .waitForPageLoad()
                    .clickOnAnswer("Yes")
                    .clickNextButton(new /*DoYouExperienceAnyOfFollowingSymptoms_OLS*/IdentificationPageOLS());

//            DoyouExperienceHotFlashesOLS doyouExperienceHotFlashesOLS = doYouExperienceAnyOfFollowingSymptoms_OLS
//                    .waitForPageLoad()
//                    .clickOnAnswers("None of the above")
//                    .clickNextButton(new DoyouExperienceHotFlashesOLS());

//            IdentificationPageOLS identificationPageOLS = doyouExperienceHotFlashesOLS
//                    .waitForPageLoad()
//                    .clickOnAnswer("No")
//                    .clickNextButton(new IdentificationPageOLS());

            SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                    .waitForPageLoad()
                    .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                            "9999999999", site.zipCode)
                    .clickNextButton(new SiteSelectionPageOLS());


            QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                    .waitForPageLoad(studyName)
                    .getPID()
                    .clickOnFacilityName(site.name)
                    .clickNextButton(new QualifiedClose2PageOLS());

            ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                    .waitForPageLoad()
                    .clickNextButton(new ThankYouCloseSimplePageOLS());

//            ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = synexusHealthyMindsPageOLS
//                    .waitForPageLoad()
//                    .clickOnAnswer("No")
//                    .clickNextButton(new ThankYouCloseSimplePageOLS());

            AlzheimerClosePageOLS alzheimerClosePageOLS = thankYouCloseSimplePageOLS
                    .waitForPageLoad2()
                    .clickNextButton(new AlzheimerClosePageOLS());

            AboutHealthPageOLS aboutHealthPageOLS = alzheimerClosePageOLS
                    .waitForPageLoad()
                    .clickNextButton(new AboutHealthPageOLS());

            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .dispoShouldMatch(site.dispo, site.dispo);
            if (site == Site.AUT_AMS_JANRSV_Syn) {
                aboutHealthPageOLS
                        .getAnomalyDbToLog(env)
                        .getRadiantDbToLog(env);
            }
        }
    }
}
