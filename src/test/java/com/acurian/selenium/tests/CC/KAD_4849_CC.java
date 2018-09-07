package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Derm_4631.AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC;
import com.acurian.selenium.pages.CC.Derm_4631.HowLongHaveYouBeenSufferingFromEczema_CC;
import com.acurian.selenium.pages.CC.Derm_4631.IfYouUseYourHandToCoverAllOfTheEczema_CC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.ThankYouCloseSimplePageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.KidneyProblemsPage;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.generalHealth.WhenDiagnosedWithCancer;
import com.acurian.selenium.pages.CC.pediatric.ChildrenUnderPageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WhatKindOfArthritisCC;
import com.acurian.selenium.utils.DataProviderPool;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class KAD_4849_CC extends BaseTest {

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("Kiniksa Atopic Dermatitis")
    @Description("KAD 4849 for CC")
    public void kad4849_CC_Test(final String username, final String password) {
        String phoneNumber = "AUTAMS1KAD";
        String protocol1 = "ANB020_005";
        List<String> protocols = Arrays.asList(protocol1);
        String studyName = "eczema, or atopic dermatitis";
        String siteName = "AUT_DERM_4849_Site";
        String zipCode = "19901";

        String env = System.getProperty("acurian.env", "STG");//was in prod

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:", "Title text is diff");
        SelectActionPageCC selectActionPageCC = loginPageCC
                .typeUsername(username)
                .typePassword(password)
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

     /*   dateOfBirthPageCC
                .waitForPageLoadIBD();*/
        dateOfBirthPageCC.threadSleep(2000);
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleKAD4631, "Title is diff");
      //  Assert.assertEquals(dateOfBirthPageCC.getTitleText(), "May I have your date of birth?", "Question text is diff");
        //Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleKAD4631, "Title is diff");

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickNextButton(new LessThan18YearsOldPageCC());
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1);
        debugPageCC.back();

        IdentificationPageCC identificationPageCC = dateOfBirthPageCC
                .setYear("1942")
                .clickNextButton(new IdentificationPageCC());
        identificationPageCC.waitForPageLoad1();
        debugPageCC.checkProtocolsContainsForQNumber("Q0004925-QSI8004-STUDYQUES", protocol1);
        debugPageCC.back();
        dateOfBirthPageCC
                .setYear("1980")
                .clickNextButton(new IdentificationPageCC());

        GenderPageCC genderPageCC = identificationPageCC
                .waitForPageLoad1()
                .setAllFields("Auto", "Test", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageCC());

        HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC = genderPageCC
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC());

        LetMeSeePageCC letMeSeePageCC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new LetMeSeePageCC());
        letMeSeePageCC.waitForPageLoadNew();
        debugPageCC.checkProtocolsContainsForQNumber("Q0009397-QS5802-STUDYQUES", protocol1);
        debugPageCC.back();

        HowLongHaveYouBeenSufferingFromEczema_CC howLongHaveYouBeenSufferingFromEczema_CC = hasHealthcareProfessionalEverDiagnosedYouWithEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongHaveYouBeenSufferingFromEczema_CC());

        IfYouUseYourHandToCoverAllOfTheEczema_CC ifYouUseYourHandToCoverAllOfTheEczema_CC = howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months")
                .clickNextButton(new IfYouUseYourHandToCoverAllOfTheEczema_CC());
        ifYouUseYourHandToCoverAllOfTheEczema_CC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0016361-QS5803-STUDYQUES", protocol1);
        debugPageCC.back();
        howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("3 to less than 6 months")
                .clickNextButton(new IfYouUseYourHandToCoverAllOfTheEczema_CC());
        ifYouUseYourHandToCoverAllOfTheEczema_CC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0016361-QS5803-STUDYQUES", protocol1);
        debugPageCC.back();
        howLongHaveYouBeenSufferingFromEczema_CC
                .waitForPageLoad()
                .clickOnAnswer("1 year or more")
                .clickNextButton(new IfYouUseYourHandToCoverAllOfTheEczema_CC());

        AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC = ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .selectFromDropDown("1")
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC.waitForPageLoadKAD();
        debugPageCC.checkProtocolsContainsForQNumber("Q0016362-QS5804-STUDYQUES", protocol1);
        debugPageCC.back();
        ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .selectFromDropDown("7")
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC.waitForPageLoadKAD();
        debugPageCC.checkProtocolsContainsForQNumber("Q0016362-QS5804-STUDYQUES", protocol1);
        debugPageCC.back();
        ifYouUseYourHandToCoverAllOfTheEczema_CC
                .waitForPageLoad()
                .selectFromDropDown("10")
                .clickNextButton(new AreYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC());

        TransitionStatementCC transitionStatementCC = areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                .waitForPageLoadKAD()
                .clickOnAnswers("Actemra (Agent Note: ac-TEM-ruh)", "Benlysta (Agent Note: ben-LIST-uh)", "Cimzia (Agent Note: SIM-zee-uh)", "Cosentyx (Agent Note: co-SEN-tix)")
                .clickOnAnswers("Enbrel (Agent Note: EN-brel)", "Entyvio (Agent Note: en-TIV-ee-oh)", "Humira (Agent Note: hue-MAIR-uh)", "Kineret (Agent Note: KIN-er-et)", "Orencia (Agent Note: oh-REN-see-uh)")
                .clickOnAnswers("Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)", "Raptiva (Agent Note: rap-TEE-vuh)", "Remicade (Agent Note: REM-ih-cade)", "Rituxan (Agent Note: rih-TUX-an)")
                .clickOnAnswers("Simponi (Agent Note: SIM-po-nee)", "Stelara (Agent Note: ste-LAHR-uh)", "Taltz (Agent Note: TALTS)", "Tysabri (Agent Note: tie-SAB-ree)")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC.waitForPageLoadWithCurvesKAD(studyName);
        debugPageCC.checkProtocolsContainsForQNumber("Q0016383-QS5821-STUDYQUES", protocol1);
        debugPageCC.back();
        areYouCurrentlyReceivingRegularDosesOfBiologicMeds_CC
                .waitForPageLoadKAD()
                .clickOnAnswers("None of the above")
                .clickNextButton(new TransitionStatementCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
                .waitForPageLoadWithCurvesKAD(studyName)
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        WhatKindOfArthritisCC whatKindOfArthritisCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("ADHD or attention deficit hyperactivity disorder", "Alzheimer's disease", "Anemia (low red blood cell count)", "Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickOnAnswers("Autism spectrum", "Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)", "Cancer", "Breathing, respiratory, or lung problems (COPD, asthma, seasonal allergy, chronic cough)")
                .clickOnAnswers("Diabetes (type 1 or type 2)", "Digestive disorders (IBS, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)", "Eating disorders (anorexia, bulimia, binge eating disorder)", "Headaches (migraine, cluster, tension)")
                .clickOnAnswers("Heart or circulation problems (heart attack, heart failure, stroke)", "High blood pressure or hypertension", "High cholesterol, triglycerides, or lipids", "Kidney disease")
                .clickOnAnswers("Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)", "Lupus", "Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)")
                .clickOnAnswers("Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)", "Skin problems (eczema or atopic dermatitis, psoriasis, acne, cellulite, actinic or solar keratosis)")
                .clickOnAnswers("Sleep problems (insomnia, sleep apnea, narcolepsy)", "Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)")
                .clickOnAnswers("None of the above")
                .clickNextButton(new WhatKindOfArthritisCC());

        whatKindOfArthritisCC.back();
        WhenDiagnosedWithCancer whenDiagnosedWithCancer = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancer());

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancer
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1);
        debugPageCC.back();
        whenDiagnosedWithCancer.back();

        KidneyProblemsPage kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickOnAnswers("Cancer")
                .clickNextButton(new KidneyProblemsPage());

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1);
        debugPageCC.back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1);
        debugPageCC.back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1);
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC.waitForPageLoad();
        debugPageCC.checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES");
        debugPageCC.back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC());

        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC());

        letMeSeePageCC
                .waitForPageLoad()
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad("an eczema (atopic dermatitis) study")
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new QualifiedClose2PageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);


    }

}
