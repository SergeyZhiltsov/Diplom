package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DIA_4241.PoundsOrMorePageCC;
import com.acurian.selenium.pages.CC.DPN_3769_4557.DoYouExperienceDPN_CC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.*;
import com.acurian.selenium.pages.CC.closes.QualifiedClose2PageCC;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransfer1;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransfer2;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransfer3;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransfer4;
import com.acurian.selenium.pages.CC.closes.RadiantWarmTransferClose1PageCC;
import com.acurian.selenium.pages.CC.closes.Regular_WarmTransfer1;
import com.acurian.selenium.pages.CC.closes.Regular_WarmTransfer4;
import com.acurian.selenium.pages.CC.closes.SRDirectScheduleWTTCPageCC;
import com.acurian.selenium.pages.CC.closes.Synexus4241DSWTC2PageCC;
import com.acurian.selenium.pages.CC.closes.SynexusDirectScheduleWTC3PageCC;
import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.ApproximateHeightPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.CC.generalHealth.LetMeSeePageCC;
import com.acurian.selenium.pages.CC.generalHealth.SiteSelectionPageCC;
import com.acurian.selenium.pages.CC.pediatric.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Arrays;
import java.util.List;

public class DIA_4241_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("00012")
    @Description("Diabetes_4241 CC")
    public void dia4241ccTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1DIA";
        List<String> protocols = Arrays.asList("EFC14822");
        String protocol1 = "EFC14822";
        String studyName = "a diabetes study";
        String siteName = "AUT_DIA_4241";
        String debugSiteName = "";
    //    String env = "STG";
        String zipCode = "19044";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

        LoginPageCC loginPageCC = new LoginPageCC();
        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(),"Please enter your username and password to login:","Title text is diff");
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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC.titleDIA4241Expected, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1980")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageCC.getTitleText(), zipCodePageCC.titleExpected, "Title is diff");
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode("19044")
                .clickNextButton(new GenderPageCC());

        genderPageCC
                .waitForPageLoad();
        Assert.assertEquals(genderPageCC.getTitleText(), genderPageCC.titleExpected, "Title is diff");
        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

        diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageCC.getTitleText(), diagnosedAnyTypeOfDiabetesPageCC.titleExpected, "Title is diff");
        NonQRtransitionPageCC nonQRtransitionPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        nonQRtransitionPageCC
                .waitForPageLoad();
        DebugPageCC debugPageCC = new DebugPageCC();
        debugPageCC
                .checkProtocolsEquals(diagnosedAnyTypeOfDiabetesPageCC.titleExpected, protocol1)
                .back();
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        whatKindOfDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(whatKindOfDiabetesPageCC.getTitleText(), whatKindOfDiabetesPageCC.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, protocol1)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, protocol1)
                .back();
        whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(whatKindOfDiabetesPageCC.titleExpected, protocol1)
                .back();
        TreatingYourDiabetesPageCC treatingYourDiabetesPageCC = whatKindOfDiabetesPageCC //rel 47
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new TreatingYourDiabetesPageCC())
                .waitForPageLoad();
        treatingYourDiabetesPageCC
                .back();
        WithType2DiabetesPageCC withType2DiabetesPageCC =  whatKindOfDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageCC());

        withType2DiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageCC.getTitleText(),withType2DiabetesPageCC.titleExpected, "Title is diff");
        withType2DiabetesPageCC
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(treatingYourDiabetesPageCC);

        treatingYourDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(treatingYourDiabetesPageCC.getTitleText(),treatingYourDiabetesPageCC.titleExpected, "Title is diff");
        FollowingToLoseWeightPageCC followingToLoseWeightPageCC = treatingYourDiabetesPageCC
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new FollowingToLoseWeightPageCC());
        followingToLoseWeightPageCC
                .waitForPageLoad()
                .back();
        treatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad() //rel 46.2
//                .getPage(debugPageCC)// copy text from previous question until "..."(white space should be include)
//                .checkProtocolsEquals("How are you currently treating your diabetes?Agent Note: Select all that applyHow are you currently ", protocol1)
                .back();
        LastTimeYouTookPageCC lastTimeYouTookPageCC = treatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new LastTimeYouTookPageCC());

        lastTimeYouTookPageCC
                .waitForPageLoad();
        Assert.assertEquals(lastTimeYouTookPageCC.getTitleText(),lastTimeYouTookPageCC.titleExpected, "Title is diff");
        lastTimeYouTookPageCC
                .clickOnAnswer("2 - 3 months ago")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(lastTimeYouTookPageCC.titleExpected, protocol1)
                .back();
        MetforminMedicationsPageCC metforminMedicationsPageCC = lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageCC());
        metforminMedicationsPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(lastTimeYouTookPageCC.titleExpected, protocol1)
                .back();
        lastTimeYouTookPageCC
                .waitForPageLoad()
                .clickOnAnswer("6 months ago or longer")
                .clickNextButton(followingToLoseWeightPageCC);

      /*  metforminMedicationsPageCC
                .waitForPageLoad();
        Assert.assertEquals(metforminMedicationsPageCC.getTitleText(),metforminMedicationsPageCC.titleExpected, "Title is diff");
        ApartFromMetforminPageCC apartFromMetforminPageCC = metforminMedicationsPageCC
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApartFromMetforminPageCC());

        InsulinForYourDiabetesPageCC insulinForYourDiabetesPageCC = apartFromMetforminPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InsulinForYourDiabetesPageCC());

        insulinForYourDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(insulinForYourDiabetesPageCC.getTitleText(),insulinForYourDiabetesPageCC.titleExpected, "Title is diff");
        SubquestionsHumalogPageCC subquestionsHumalogPageCC = insulinForYourDiabetesPageCC
                .clickOnAnswers("Humalog","Humulin","Novolin","Novolog")
                .clickNextButton(new SubquestionsHumalogPageCC());

        subquestionsHumalogPageCC
                .waitForPageLoad();
        Assert.assertEquals(subquestionsHumalogPageCC.getTitleText(1),subquestionsHumalogPageCC.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageCC.getTitleText(2),subquestionsHumalogPageCC.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageCC.getTitleText(3),subquestionsHumalogPageCC.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageCC.getTitleText(4),subquestionsHumalogPageCC.titleExpected4, "Title is diff");
        subquestionsHumalogPageCC
                .clickOnAnswersForSubQuestion(1,"Humalog Mix 50/50","Humalog Mix 75/25")
                .clickOnAnswersForSubQuestion(2,"Humulin N or NPH")
                .clickOnAnswersForSubQuestion("What type of Novolin do you currently use?","Novolin N or NPH")
                .clickOnAnswersForSubQuestion("What type of Novolog do you currently use?","Novolog Mix 70/30")
                .back();

        InjectableMedicationsForYourDiabetesPageCC injectableMedicationsForYourDiabetesPageCC = insulinForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageCC());

        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad();
        Assert.assertEquals(injectableMedicationsForYourDiabetesPageCC.getTitleText(),injectableMedicationsForYourDiabetesPageCC.titleExpected, "Title is diff");
        CombinationWithEachOtherPageCC combinationWithEachOtherPageCC = injectableMedicationsForYourDiabetesPageCC
                .clickOnAnswers("Adlyxin (lixisenatide)", "Another injectable medication not listed above")
                .clickNextButton(new CombinationWithEachOtherPageCC());
        combinationWithEachOtherPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 months")
                .clickNextButton(followingToLoseWeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals("Ghost Question - Diabetes_Type_2 Antidiabetic Medication Logic", protocol1)
                .back();
        combinationWithEachOtherPageCC
                .waitForPageLoad()
                .back();
        injectableMedicationsForYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(combinationWithEachOtherPageCC);

        combinationWithEachOtherPageCC
                .waitForPageLoad();
        Assert.assertEquals(combinationWithEachOtherPageCC.getTitleText(),combinationWithEachOtherPageCC.titleExpected, "Title is diff");
        combinationWithEachOtherPageCC
                .clickNextButton(followingToLoseWeightPageCC);

        followingToLoseWeightPageCC
                .waitForPageLoad();
        Assert.assertEquals(followingToLoseWeightPageCC.getTitleText(),followingToLoseWeightPageCC.titleExpected, "Title is diff"); */
        
        
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = followingToLoseWeightPageCC
                .clickOnAnswers("Prescription weight loss medication")
                .clickNextButton(new WeightLossSurgeryPageCC());

        weightLossSurgeryPageCC
                .waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageCC.getTitleText(),weightLossSurgeryPageCC.titleExpected, "Title is diff");
        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageCC());

        procedureForWeightLossPageCC
                .waitForPageLoad();
        Assert.assertEquals(procedureForWeightLossPageCC.getTitleText(),procedureForWeightLossPageCC.titleExpected, "Title is diff");
        PoundsOrMorePageCC poundsOrMorePageCC = procedureForWeightLossPageCC
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new PoundsOrMorePageCC());
        poundsOrMorePageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .clickOnAnswer("1 - 2 years ago")
                .clickNextButton(poundsOrMorePageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(procedureForWeightLossPageCC.titleExpected, protocol1)
                .back();
        procedureForWeightLossPageCC
                .waitForPageLoad()
                .back();

        weightLossSurgeryPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(poundsOrMorePageCC);

        poundsOrMorePageCC
                .waitForPageLoad();
        Assert.assertEquals(poundsOrMorePageCC.getTitleText(),poundsOrMorePageCC.titleExpected, "Title is diff");
        poundsOrMorePageCC
                .clickOnAnswer("Yes")
                .clickNextButton(new DoYouExperienceDPN_CC())
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsEquals(poundsOrMorePageCC.titleExpected, protocol1)
                .back();
        ChildrenUnderPageCC childrenUnderPageCC = poundsOrMorePageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ChildrenUnderPageCC());
        childrenUnderPageCC
        .waitForPageLoad()
        .clickOnAnswer("No")
      /*.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        
        //-------------------New GENERAL HEALTH---------------------------
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")                	
        		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC())
        		//----------Q23 - Do any of the following additional diagnoses apply to you?--------
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageCC())
        		//----------Height and Weight Question Page--------------------
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new ChildrenUnderPageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new TheStudySitePageCC())
                //----------PEDIATRIC HEALTH Questions----------
                //.clickNextButton(new HouseholdHavePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("None of the above")
                //.clickNextButton(new TheStudySitePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Public transportation")
                //.clickNextButton(new WhatMedicalCoveragePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("No, I have no coverage")
                //.clickNextButton(new EthnicBackgroundPageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Prefer not to answer")  */
         //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
        		.getPID()
        		.clickOnAnswer(siteName)
        		.clickNextButton(new QualifiedClose2PageCC())
        		//Regular Warm Transfer Questions ----- //Regular Warm Transfer Page#1
        		.waitForPageLoad()
        		.clickNextButton(new Regular_WarmTransfer1())
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		//Regualr Warm Transfer Page#2
        		.clickNextButton(new Regular_WarmTransfer2())
        		.waitForPageLoad()
        		.clickOnAnswer("Yes: Great, I'll connect them now.")
        		.clickOnAnswer("[site did not answer]")
        		//Regualr Warm Transfer Page#3
        		.clickNextButton(new Regular_WarmTransfer3())
        		.waitForPageLoad()
        		//Regualr Warm Transfer Page#4
        		.clickNextButton(new Regular_WarmTransfer4())
        		.waitForPageLoad()                
        		.clickOnAnswer("Successful transfer made to site")
        		.clickNextButton(selectActionPageCC)
        		.waitForPageLoad()
        		.pidFromDbToLog(env);
        
        
        //----------------------OLD G Health--------------
       /* childrenUnderPageCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                //----------PEDIATRIC HEALTH Questions----------
                //.clickNextButton(new HouseholdHavePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("None of the above")
                //.clickNextButton(new TheStudySitePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Public transportation")
                //.clickNextButton(new WhatMedicalCoveragePageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("No, I have no coverage")
                //.clickNextButton(new EthnicBackgroundPageCC())
                //.waitForPageLoad()
                //.clickOnAnswers("Prefer not to answer")
         //----------Resume GENERAL HEALTH Questions----------
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
        		.getPID()
        		.clickOnAnswer(siteName)
        		.clickNextButton(new QualifiedClose2PageCC())
        		//Regular Warm Transfer Questions ----- //Regular Warm Transfer Page#1
        		.waitForPageLoad()
        		.clickNextButton(new Regular_WarmTransfer1())
        		.waitForPageLoad()
        		.clickOnAnswer("Yes")
        		//Regualr Warm Transfer Page#2
        		.clickNextButton(new Regular_WarmTransfer2())
        		.waitForPageLoad()
        		.clickOnAnswer("Yes: Great, I'll connect them now.")
        		.clickOnAnswer("[site did not answer]")
        		//Regualr Warm Transfer Page#3
        		.clickNextButton(new Regular_WarmTransfer3())
        		.waitForPageLoad()
        		//Regualr Warm Transfer Page#4
        		.clickNextButton(new Regular_WarmTransfer4())
        		.waitForPageLoad()                
        		.clickOnAnswer("Successful transfer made to site")
        		.clickNextButton(selectActionPageCC)
        		.waitForPageLoad()
        		.pidFromDbToLog(env); */
    }
}
