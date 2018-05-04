package com.acurian.selenium.tests.CC;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Crohns_3485.BiologicMedicationsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.DiagnosedWithCrohnsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.FollowingMedicationsCrohnsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.HaveAnyOfTheFollowingPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.ManageYourCrohnsPageCC;
import com.acurian.selenium.pages.CC.Crohns_3485.WhenDiagnosedCrohnsPageCC;
import com.acurian.selenium.pages.CC.END_4385.HormonalBirthControlCC;
import com.acurian.selenium.pages.CC.IBD.CurrentlyExperiencingFlareUpCC;
import com.acurian.selenium.pages.CC.IBD.EverTreatedCrohnOrColitisCC;
import com.acurian.selenium.pages.CC.IBD.HowWouldYouRateCC;
import com.acurian.selenium.pages.CC.IBD.MostRecentColonoscopyCC;
import com.acurian.selenium.pages.CC.IBD.SteroidMedicationsForCrohnsCC;
import com.acurian.selenium.pages.CC.closes.DoctorInformationCollectionPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import com.acurian.selenium.pages.CC.closes.HSMedicalRecordsPageCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
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
import com.acurian.selenium.pages.CC.pediatric.HSCrohns2PageCC;
import com.acurian.selenium.pages.CC.shared.CallCenterIntroductionPageCC;
import com.acurian.selenium.pages.CC.shared.DateOfBirthPageCC;
import com.acurian.selenium.pages.CC.shared.GenderPageCC;
import com.acurian.selenium.pages.CC.shared.LoginPageCC;
import com.acurian.selenium.pages.CC.shared.ProcedureForWeightLossPageCC;
import com.acurian.selenium.pages.CC.shared.SelectActionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import com.acurian.selenium.pages.CC.shared.WeightLossSurgeryPageCC;
import com.acurian.selenium.utils.DataProviderPool;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class IBD_3485_CC extends BaseTest{

    @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderPool.class)
    @TestCaseId("IBD_Crohn's")
    @Description("IBD 3485 for CC")
    public void crohns3889ccTest(final String username, final String password) {
        String phoneNumber = "AUTAMS1IBD";
        String protocol1 = "I6T_MC_AMAG";
        String protocol2 = "RF_I6T_MC_AMAG";        
        List<String> protocols = Arrays.asList(protocol1,protocol2);
        String studyName = "Crohn's or colitis";
        String studyIndication = "a Ulcerative Colitis";
        String siteName = "AUT_CRN_3485_HS_Site";
        String debugSiteName = "";
  //      String env = "STG";
        String zipCode = "19044";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "PRD";

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
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpectedDYS, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

     /*   dateOfBirthPageCC
                .waitForPageLoadIBD();*/
        dateOfBirthPageCC.threadSleep(2000);
        Assert.assertEquals(dateOfBirthPageCC.getTitleTextIBD(),"May I have your date of birth?","Question text is diff");
        Assert.assertEquals(dateOfBirthPageCC.getQuestionTextIBD(), dateOfBirthPageCC.titleIBD3264, "Title is diff");
        
        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = dateOfBirthPageCC
                .setMonth("Mar")
                .setDay("2")
                .setYear("2003")
                .clickNextButton(new LessThan18YearsOldPageCC());
        DebugPageCC debugPageCC = new DebugPageCC();       
        debugPageCC.checkProtocolsContainsForQNumber("Q0004929-QSI8005-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        
        IdentificationPageCC identificationPageCC = dateOfBirthPageCC                
                .setYear("1942")
                .clickNextButton(new IdentificationPageCC());        
        debugPageCC.checkProtocolsContainsForQNumber("Q0004929-QSI8005-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();        
        dateOfBirthPageCC		   		
		   		.setYear("1980")
		   		.clickNextButton(new IdentificationPageCC()); 
        
       
        GenderPageCC genderPageCC = identificationPageCC
     		   .waitForPageLoad1()
     		   .setAllFields("Auto", "Test", "qa.acurian@gmail.com", "9999999999", zipCode)
     		   .clickNextButton(new GenderPageCC());
        
        DiagnosedWithCrohnsPageCC  diagnosedWithCrohnsPageCC = genderPageCC
     		   .waitForPageLoad()
     		   .clickOnAnswer("Female")
     		   .clickNextButton(new DiagnosedWithCrohnsPageCC());
        
        WhenDiagnosedCrohnsPageCC whenDiagnosedCrohnsPageCC = diagnosedWithCrohnsPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("Ulcerative colitis")
        		.clickNextButton(new WhenDiagnosedCrohnsPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015878-QS5702-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        diagnosedWithCrohnsPageCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new LetMeSeePageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015878-QS5702-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        diagnosedWithCrohnsPageCC
				.waitForPageLoad()
				.clickOnAnswers("Crohn's disease")
				.clickNextButton(new WhenDiagnosedCrohnsPageCC());
        
        whenDiagnosedCrohnsPageCC
				.waitForPageLoad()
				.clickOnAnswer("Not officially diagnosed with Crohn's by a doctor")				
				.clickNextButton(new LetMeSeePageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015880-QS5703-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        
        MostRecentColonoscopyCC mostRecentColonoscopyCC = whenDiagnosedCrohnsPageCC
				.waitForPageLoad()
				.clickOnAnswer("Less than 3 months ago")
				.clickNextButton(new MostRecentColonoscopyCC());
        
        ManageYourCrohnsPageCC manageYourCrohnsPageCC = mostRecentColonoscopyCC
        		.waitForPageLoad()
        		.clickOnAnswer("I have never had a colonoscopy")
        		.clickNextButton(new ManageYourCrohnsPageCC());
                
        CurrentlyExperiencingFlareUpCC currentlyExperiencingFlareUpCC = manageYourCrohnsPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015883-QS5706-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        
        SteroidMedicationsForCrohnsCC steroidMedicationsForCrohnsCC = manageYourCrohnsPageCC
				.waitForPageLoad()
				.clickOnAnswer("Yes")
				.clickNextButton(new SteroidMedicationsForCrohnsCC());
        
        FollowingMedicationsCrohnsPageCC followingMedicationsCrohnsPageCC = steroidMedicationsForCrohnsCC
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new FollowingMedicationsCrohnsPageCC());
        
        EverTreatedCrohnOrColitisCC everTreatedCrohnOrColitisCC = followingMedicationsCrohnsPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("Dipentum, also known as olsalazine (Agent Note: di-PENT-um, ol-SAL-uh-zeen)")
        		.clickNextButton(new EverTreatedCrohnOrColitisCC());
        
        everTreatedCrohnOrColitisCC.threadSleep(2000);
        BiologicMedicationsPageCC biologicMedicationsPageCC = everTreatedCrohnOrColitisCC        		
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new BiologicMedicationsPageCC());      
        
        biologicMedicationsPageCC        		
        		.clickOnAnswers("Stelara (Agent Note: ste-LAHR-uh)")
        		.clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005225-QS5710-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        biologicMedicationsPageCC.back();
        everTreatedCrohnOrColitisCC.back();
        
        followingMedicationsCrohnsPageCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new EverTreatedCrohnOrColitisCC());

        everTreatedCrohnOrColitisCC.threadSleep(2000);
        everTreatedCrohnOrColitisCC        		
        		.clickOnAnswers("Xeljanz (Agent Note: ZEL-jans)", "Jakafi (Agent Note: JAK-uh-fie)", "CellCept or Myfortic, also known as mycophenolate (Agent Note: my-co-FEN-o-late)")
        		.clickOnAnswers("Astagraf, Envarsus, or Prograf, also known as tacrolimus (Agent Note: tah-CRO-li-mus)", "Rapamune, also known as sirolimus (Agent Note: RAP-uh-mune, sir-OH-li-mus)")
        		.clickOnAnswers("Sandimmune, Gengraf, or Neoral, also known as cyclosporine (Agent Note: GEN-graf, NEE-oh-ral, cy-clo-SPOR-in)")
        		.clickNextButton(new BiologicMedicationsPageCC());      

        biologicMedicationsPageCC        		
				.clickOnAnswers("None of the above")
				.clickNextButton(new CurrentlyExperiencingFlareUpCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015899-QS5711-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        biologicMedicationsPageCC        		
				.clickOnAnswers("Benlysta (Agent Note: ben-LIST-uh)", "Cimzia (Agent Note: SIM-zee-uh)", "Enbrel (Agent Note: EN-brel)", "Entyvio (Agent Note: en-TIV-ee-oh)", "Humira (Agent Note: hue-MAIR-uh)")
				.clickOnAnswers("Raptiva (Agent Note: rap-TEE-vuh)", "Remicade (Agent Note: REM-ih-cade)", "Rituxan (Agent Note: rih-TUX-an)", "Simponi (Agent Note: SIM-po-nee)", "Tysabri (Agent Note: tie-SAB-ree)")
				.clickNextButton(new CurrentlyExperiencingFlareUpCC());
        
        HowWouldYouRateCC howWouldYouRateCC = currentlyExperiencingFlareUpCC
                .waitForPageLoad()
                .clickOnAnswer("No, I am not currently in a flare with my Crohn's or colitis")
                .clickNextButton(new HowWouldYouRateCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015902-QS5714-STUDYQUES", protocol2);
        debugPageCC.back();
        currentlyExperiencingFlareUpCC
        		.waitForPageLoad()
        		.clickOnAnswer("Yes, I am currently in a flare with my Crohn's or colitis")
        		.clickNextButton(new HowWouldYouRateCC());
        
        debugPageCC.checkProtocolsContainsForQNumber("Q0015902-QS5714-STUDYQUES", protocol1);
        debugPageCC.back();
        currentlyExperiencingFlareUpCC
        		.waitForPageLoad()
        		.clickOnAnswer("I am unsure as to whether I am in a flare with my Crohn's or colitis")
        		.clickNextButton(new HowWouldYouRateCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0015902-QS5714-STUDYQUES", protocol1);
        
        WeightLossSurgeryPageCC weightLossSurgeryPageCC = howWouldYouRateCC
        		.waitForPageLoadIBD()
        		.clickOnAnswer("Fair")
        		.clickOnAnswer("About the same")
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new WeightLossSurgeryPageCC());
        
        ProcedureForWeightLossPageCC procedureForWeightLossPageCC = weightLossSurgeryPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("I had a weight loss surgery, but I am unsure which type")
        		.clickNextButton(new ProcedureForWeightLossPageCC());
        
        HaveAnyOfTheFollowingPageCC haveAnyOfTheFollowingPageCC = procedureForWeightLossPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("Less than 3 months ago")
        		.clickNextButton(new HaveAnyOfTheFollowingPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005313-QS5717-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        procedureForWeightLossPageCC
				.waitForPageLoad()
				.clickOnAnswer("3 - 6 months ago")
				.clickNextButton(new HaveAnyOfTheFollowingPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005313-QS5717-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        procedureForWeightLossPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("7 - 11 months ago")
        		.clickNextButton(new HaveAnyOfTheFollowingPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005313-QS5717-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        procedureForWeightLossPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("1 - 2 years ago")
        		.clickNextButton(new HaveAnyOfTheFollowingPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005313-QS5717-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        procedureForWeightLossPageCC
        		.waitForPageLoad()
        		.clickOnAnswer("More than 2 years ago")
        		.clickNextButton(new HaveAnyOfTheFollowingPageCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0005313-QS5717-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        procedureForWeightLossPageCC.back();
        
        weightLossSurgeryPageCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HaveAnyOfTheFollowingPageCC());
        
        TransitionStatementCC transitionStatementCC = haveAnyOfTheFollowingPageCC
        		.waitForPageLoad()
        		.clickOnAnswers("Colostomy and/or Colectomy")
        		.clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        haveAnyOfTheFollowingPageCC
				.waitForPageLoad()
				.clickOnAnswers("Ileostomy")
				.clickOnAnswers("Colostomy and/or Colectomy")
				.clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();
        haveAnyOfTheFollowingPageCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickOnAnswers("Another type of stomach or colon surgery")
				.clickNextButton(new TransitionStatementCC());
        debugPageCC.checkProtocolsContainsForQNumber("Q0012938-QS5718-STUDYQUES", protocol1, protocol2);
        debugPageCC.back();  
        
        haveAnyOfTheFollowingPageCC
				.waitForPageLoad()
				.clickOnAnswers("Another type of stomach or colon surgery")
				.clickOnAnswers("Feeding tube", "IV (parenteral) nutrition (Agent Note: puh-REN-ter-ul)")						
				.clickNextButton(new TransitionStatementCC());
        
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = transitionStatementCC
        		.waitForPageLoadWithCurves(studyName)
        		.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        
        WhenDiagnosedWithCancer whenDiagnosedWithCancer = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
  		      .waitForPageLoad()
  		      .clickOnAnswers("Cancer")
  		      .clickNextButton(new WhenDiagnosedWithCancer());
          
          DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = whenDiagnosedWithCancer
          		.waitForPageLoad()
          		.clickOnAnswer("Within the past 5 years")
          		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
          debugPageCC.checkProtocolsContainsForQNumber("Q0015116-QS42-STUDYQUES", protocol1, protocol2);
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
          debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1, protocol2);
          debugPageCC.back();
          kidneyProblemsPage
          		.waitForPageLoad()
          		.clickOnAnswers("Kidney transplant")
          		.clickOnAnswers("Dialysis")
          		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
          debugPageCC.checkProtocolsContainsForQNumber("Q0015143-QS51-STUDYQUES", protocol1, protocol2);
          debugPageCC.back();
          kidneyProblemsPage
  				.waitForPageLoad()
  				.clickOnAnswers("Neither")
  				.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());
          
          HormonalBirthControlCC hormonalBirthControlCC = doAnyOftheFollowingAdditionalDiagnosesCC
          		.waitForPageLoad()
          		.clickOnAnswers("Cirrhosis")
          		.clickNextButton(new HormonalBirthControlCC());
          debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
          debugPageCC.back();
          doAnyOftheFollowingAdditionalDiagnosesCC
  				.waitForPageLoad()
  				.clickOnAnswers("None of the above")
  				.clickOnAnswers("Hepatitis B")
  				.clickNextButton(new HormonalBirthControlCC());
          debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
          debugPageCC.back();
          doAnyOftheFollowingAdditionalDiagnosesCC
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickOnAnswers("Bipolar disorder")
				.clickNextButton(new HormonalBirthControlCC());
          debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
          debugPageCC.back();
          doAnyOftheFollowingAdditionalDiagnosesCC
  				.waitForPageLoad()
  				.clickOnAnswers("None of the above")
  				.clickOnAnswers("Hepatitis C")
  				.clickNextButton(new HormonalBirthControlCC());
          debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
          debugPageCC.back();

          doAnyOftheFollowingAdditionalDiagnosesCC
          		.waitForPageLoad()
          		.clickOnAnswers("None of the above")
          		.clickOnAnswers("HIV or AIDS")
          		.clickNextButton(new HormonalBirthControlCC());
          debugPageCC.checkProtocolsContainsForQNumber("Q0015156-QS59-STUDYQUES", protocol1, protocol2);
          debugPageCC.back();
          doAnyOftheFollowingAdditionalDiagnosesCC
  				.waitForPageLoad()
  				.clickOnAnswers("None of the above")
  				.clickOnAnswers("Schizophrenia")
  				.clickNextButton(new HormonalBirthControlCC());
          debugPageCC.checkProtocolsContainsForQNumber("Q0015266-QS61-STUDYQUES", protocol1, protocol2);
          debugPageCC.back();
          doAnyOftheFollowingAdditionalDiagnosesCC
  		    	.waitForPageLoad()
  		    	.clickOnAnswers("None of the above")
  		    	.clickNextButton(new HormonalBirthControlCC());
        
          ApproximateHeightPageCC approximateHeightPageCC = hormonalBirthControlCC
          		.waitForPageLoad()
          		.clickOnAnswer("No")
          		.clickNextButton(new ApproximateHeightPageCC());
          
          ChildrenUnderPageCC childrenUnderPageCC = approximateHeightPageCC
          		.waitForPageLoad()
          		.setAll("5", "7", "170")
          		.clickNextButton(new ChildrenUnderPageCC());
          
          childrenUnderPageCC
          		.waitForPageLoad()
          		.clickOnAnswer("No")
          		.clickNextButton(new IdentificationPageCC())
          		.waitForPageLoad()        		              
          		.clickNextButton(new SiteSelectionPageCC())
          		.waitForPageLoad("a Crohn's study")
          		.getPID()
          		.clickOnAnswer(siteName)
          		.clickNextButton(new HSCrohns2PageCC())
                .waitForPageLoad("Crohn's Disease")
                .clickNextButton(new DoctorInformationCollectionPageCC())
                .waitForPageLoad()
                .clickNextButton(new HSMedicalRecordsPageCC())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .waitForPageLoad()
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env);
     
    }

}
