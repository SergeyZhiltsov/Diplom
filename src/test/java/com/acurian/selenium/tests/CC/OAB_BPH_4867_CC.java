package com.acurian.selenium.tests.CC;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.OAB_4867.DoYouSufferFromOAB_CC;
import com.acurian.selenium.pages.CC.OAB_4867.DoYouTakeAnyMedicationsControlHypertension_CC;
import com.acurian.selenium.pages.CC.OAB_4867.HaveYouEverHadBotoxInjectionbladder_CC;
import com.acurian.selenium.pages.CC.OAB_4867.SubquestionOABandBPH_CC;
import com.acurian.selenium.pages.CC.closes.SynexusRadiantDirectScheduleCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.DataProviderPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class OAB_BPH_4867_CC extends BaseTest {

    @Description("OAB_BPH_4867_CC")
    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class, enabled = false)
    public void OAB_BPH_4867_CC_Script(final String username, final String password) {
        String phoneNumber = "AUTAMS1OAB";
        String protocol1 = "URO_901_1001";
        String studyName =  "an overactive bladder study";
        String siteName = "AUT_OAB_4867";
        String zipCode = "08204";

        String env = System.getProperty("acurian.env", "STG");
        
		DebugPageCC debugPageCC = new DebugPageCC();
		
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
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
        .clickOnAnswer("Learn more about matching to clinical trials")
        .clickNextButton(new DateOfBirthPageCC());

        //------------dateOfBirthPageCC----------------
        dateOfBirthPageCC.threadSleep(1000);
        Assert.assertEquals(dateOfBirthPageCC.getQuestionText(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getTitleText1(), dateOfBirthPageCC.titleExpectedOAB, "Title is diff");
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .setMonth("Sep")
                .setDay("9")
                .setYear("1940")
                .clickNextButton(new ZipCodePageCC());

        zipCodePageCC
                .waitForPageLoad();
        GenderPageCC genderPageCC = zipCodePageCC
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageCC());

		//-------------If 'Female' AND selected "No" in Q2.1, Disqualify OAB
        DoYouSufferFromOAB_CC doYouSufferFromOAB_CC = genderPageCC
				.waitForPageLoad()
				.clickOnAnswer("Female")
				.clickNextButton(new DoYouSufferFromOAB_CC());
	   //-------------Display Q2.1
        TransitionStatementCC transitionStatementCC = doYouSufferFromOAB_CC
	    //HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = doYouSufferFromOAB_CC
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new TransitionStatementCC())
				.waitForPageLoadDYS();
	    debugPageCC.checkProtocolsContainsForQNumber("QS6502", protocol1);
	    debugPageCC.back();
	    doYouSufferFromOAB_CC
				.waitForPageLoad();
		HaveYouEverHadBotoxInjectionbladder_CC haveYouEverHadBotoxInjectionbladder_CC = doYouSufferFromOAB_CC
				.clickOnAnswer("Yes")
				.clickNextButton(new HaveYouEverHadBotoxInjectionbladder_CC())
				.waitForPageLoad();
				haveYouEverHadBotoxInjectionbladder_CC.back();
				haveYouEverHadBotoxInjectionbladder_CC.waitForPageLoad();
				doYouSufferFromOAB_CC.back();
				doYouSufferFromOAB_CC.waitForPageLoad();
				
				
		//-------------Display Q2.2 for MALEs only ------------------
		genderPageCC
				.waitForPageLoad();
		SubquestionOABandBPH_CC subquestionOABandBPH_CC = genderPageCC
				.clickOnAnswer("Male")
				.clickNextButton(new SubquestionOABandBPH_CC());
	   //-------------Display Q2.1
		subquestionOABandBPH_CC
				.waitForPageLoad(1,subquestionOABandBPH_CC.titleExpected1)
				.waitForPageLoad(2,subquestionOABandBPH_CC.titleExpected2)
    //----------Select options for Q2.2 sub-question---------
				.clickOnAnswerForSubQuestion(1, "No")
				.clickOnAnswerForSubQuestion(2, "No")
				.clickNextButton(new HaveYouEverHadBotoxInjectionbladder_CC())
				.waitForPageLoad();
				debugPageCC.back();
		subquestionOABandBPH_CC
				.waitForPageLoad(1,subquestionOABandBPH_CC.titleExpected1)
				.waitForPageLoad(2,subquestionOABandBPH_CC.titleExpected2)
				.clickOnAnswerForSubQuestion(1, "Yes")
				.clickOnAnswerForSubQuestion(2, "Yes")
				.clickNextButton(new HaveYouEverHadBotoxInjectionbladder_CC());
		
		
		//-------------Q3:  Have you ever had a Botox injection into your bladder muscle?---
		haveYouEverHadBotoxInjectionbladder_CC
				.waitForPageLoad();
		DoYouTakeAnyMedicationsControlHypertension_CC doYouTakeAnyMedicationsControlHypertension_CC = haveYouEverHadBotoxInjectionbladder_CC
				.clickOnAnswer("Yes, within the past 6 weeks")
				.clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_CC())
				.waitForPageLoad();
		debugPageCC.checkProtocolsContainsForQNumber("QS6503", protocol1);
		debugPageCC.back();
		haveYouEverHadBotoxInjectionbladder_CC
				.waitForPageLoad()
				.clickOnAnswer("Yes, more than 6 weeks ago")
				.clickOnAnswer("No, never")
				.clickNextButton(new DoYouTakeAnyMedicationsControlHypertension_CC());
				

		//-------------Q4:  Do you take any medications to control high blood pressure or hypertension?---
		doYouTakeAnyMedicationsControlHypertension_CC
				.waitForPageLoad()
				.clickOnAnswer("Yes")
				.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC())
				.waitForPageLoad();
		debugPageCC.checkProtocolsContainsForQNumber("QS6504", protocol1);
		debugPageCC.back();
		haveYouEverHadBotoxInjectionbladder_CC
				.waitForPageLoad()
        //TransitionStatementCC transitionStatementCC = doYouTakeAnyMedicationsControlHypertension_CC
				.clickOnAnswer("No")
				.clickOnAnswer("Unsure")
				.clickNextButton(new TransitionStatementCC());



        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
        		.waitForPageLoadDYS()
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());


        OtherThanSkinCancerPageCC otherThanSkinCancerPageCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer", "Kidney disease", "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)")
                .clickNextButton(new OtherThanSkinCancerPageCC());

        KidneyProblemsPage kidneyProblemsPage = otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new KidneyProblemsPage());
        kidneyProblemsPage
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1)
                .back();
        otherThanSkinCancerPageCC
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(kidneyProblemsPage);

        WhichOfTheFollowingLiverProblemsPageСС whichOfTheFollowingLiverProblemsPageСС = kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfTheFollowingLiverProblemsPageСС());
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1)
                .back();
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfTheFollowingLiverProblemsPageСС);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015139-QS52-STUDYQUES", protocol1)
                .back();
        whichOfTheFollowingLiverProblemsPageСС
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC);

        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageCC());
        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageCC);

        approximateHeightPageCC
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new LetMeSeePageCC())
                .waitForPageLoad()
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(siteName)
                .clickNextButton(new SynexusRadiantDirectScheduleCC())
                .waitForPageLoadSyn()
                .clickOnAnswer("[Successful direct schedule in clinical conductor]")
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}