package com.acurian.selenium.tests.OLS;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.DIA_4241.PoundsOrMorePageOLS;
import com.acurian.selenium.pages.OLS.DPN_3769_4557.DoYouExperienceDPN_OLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.ApartFromMetforminPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.CombinationWithEachOtherPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.DiabeticNephropathyPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.FollowingToLoseWeightPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.ForYourKidneysPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.InjectableMedicationsForYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.InsulinForYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.LastTimeYouTookPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.LiverRelatedConditionOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.MetforminMedicationsPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.NoOfAlcoholicDrinkOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.SubquestionsHumalogPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.TreatingYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.WithType2DiabetesPageOLS;
import com.acurian.selenium.pages.OLS.END_4385.HormonalBirthControlOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HeartrelatedMedicalProceduresPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.IdentificationPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.OtherThanSkinCancerPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.SiteSelectionPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.ChildrenUnderPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.pediatric.TheStudySitePageOLS;
import com.acurian.selenium.pages.OLS.pediatric.WhatMedicalCoveragePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.DiagnosedAnyTypeOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS;
import com.acurian.selenium.pages.OLS.shared.ProcedureForWeightLossPageOLS;
import com.acurian.selenium.pages.OLS.shared.StatinMedicationsOnPageOLS;
import com.acurian.selenium.pages.OLS.shared.WeightLossSurgeryPageOLS;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfArthritisPage;
import com.acurian.selenium.pages.OLS.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class AKC_4691_OLS extends BaseTest{

    @Test
    @TestCaseId("0001")
    @Description("Akcea_4691 OLS")
    public void akc4691olsTest() {
    	
        String phoneNumber = "AUTAMS1AKC";
        List<String> protocols = Arrays.asList("ISIS 703802_CS2");
        String protocol1 = "ISIS 703802_CS2";
        String studyName = "diabetics";
        String siteName = "AUT_4691";   
        String zipCode = "08204";
        
        String env = System.getProperty("acurian.env");
        if (env == null) env = "STG";

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
		dateOfBirthPageOLS.openPage(env, phoneNumber)		           
		           .waitForPageLoadGROUP()
		           .maximizePage();
		Assert.assertEquals(dateOfBirthPageOLS.getTitleTextGROUP(),dateOfBirthPageOLS.titleAKC_4691_Expected, "Title is diff");
      
		ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new ZipCodePageOLS());
        
        zipCodePageOLS
                .waitForPageLoad();
        Assert.assertEquals(zipCodePageOLS.getTitleText(),zipCodePageOLS.titleExpected, "Title is diff");
        
        GenderPageOLS genderPageOLS = zipCodePageOLS
                .typeZipCode(zipCode)
                .clickNextButton(new GenderPageOLS());

        genderPageOLS
                .waitForPageLoad();
        Assert.assertEquals(genderPageOLS.getTitleText(), genderPageOLS.titleExpected, "Title is diff");
        DiagnosedAnyTypeOfDiabetesPageOLS diagnosedAnyTypeOfDiabetesPageOLS = genderPageOLS
                .clickOnAnswer("Female")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageOLS());

        diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageOLS.getTitleText(),diagnosedAnyTypeOfDiabetesPageOLS.titleExpected, "Title is diff");
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        debugPageOLS.checkProtocolsContainsForQNumber("QS4602", protocol1);
        debugPageOLS.back();
        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = diagnosedAnyTypeOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        whatKindOfDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(whatKindOfDiabetesPageOLS.getTitleText(),whatKindOfDiabetesPageOLS.titleExpected, "Title is diff");
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocol1)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocol1)
                .back();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("High blood sugar only")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocol1)
                .back();
        TreatingYourDiabetesPageOLS treatingYourDiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(new TreatingYourDiabetesPageOLS());
        treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4603", protocol1)
                .back();
        WithType2DiabetesPageOLS withType2DiabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2DiabetesPageOLS());

        withType2DiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(withType2DiabetesPageOLS.getTitleText(),withType2DiabetesPageOLS.titleExpected, "Title is diff");
        withType2DiabetesPageOLS
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new TreatingYourDiabetesPageOLS());

        treatingYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(treatingYourDiabetesPageOLS.getTitleText(),treatingYourDiabetesPageOLS.titleExpected, "Title is diff");
        FollowingToLoseWeightPageOLS followingToLoseWeightPageOLS = treatingYourDiabetesPageOLS
                .clickOnAnswers("Diet and exercise")
                .clickNextButton(new FollowingToLoseWeightPageOLS());
        followingToLoseWeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4605", protocol1)
                .back();
        treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(followingToLoseWeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4605", protocol1)
                .back();
        LastTimeYouTookPageOLS lastTimeYouTookPageOLS = treatingYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(new LastTimeYouTookPageOLS());

        lastTimeYouTookPageOLS
                .waitForPageLoad();
        Assert.assertEquals(lastTimeYouTookPageOLS.getTitleText(),lastTimeYouTookPageOLS.titleExpected, "Title is diff");
        lastTimeYouTookPageOLS
                .clickOnAnswer("2 - 3 months ago")
                .clickNextButton(followingToLoseWeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4606", protocol1)
                .back();
        lastTimeYouTookPageOLS
        		.clickOnAnswer("4 - 5 months ago")
        		.clickNextButton(followingToLoseWeightPageOLS)
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4606", protocol1)
        		.back();
        lastTimeYouTookPageOLS
				.clickOnAnswer("6 months ago or longer")
				.clickNextButton(followingToLoseWeightPageOLS)
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS4606", protocol1)
				.back();
        
        MetforminMedicationsPageOLS metforminMedicationsPageOLS = lastTimeYouTookPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Currently taking / have taken within the past month")
                .clickNextButton(new MetforminMedicationsPageOLS());
        

        metforminMedicationsPageOLS
                .waitForPageLoad();
        Assert.assertEquals(metforminMedicationsPageOLS.getTitleText(),metforminMedicationsPageOLS.titleExpected, "Title is diff");
        ApartFromMetforminPageOLS apartFromMetforminPageOLS = metforminMedicationsPageOLS
                .clickOnAnswers("Actoplus Met (metformin and pioglitazone)")
                .clickNextButton(new ApartFromMetforminPageOLS());
        apartFromMetforminPageOLS
                .waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS4607", protocol1)
				.back();
        
        metforminMedicationsPageOLS
        		.waitForPageLoad()
        		.clickOnAnswers("Actoplus Met (metformin and pioglitazone)")
        		.clickOnAnswers("Avandamet (metformin and rosiglitazone)")
        		.clickNextButton(new ApartFromMetforminPageOLS())
        		.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS4607", protocol1)
				.back();
        
        metforminMedicationsPageOLS
        		.waitForPageLoad()
        		.clickOnAnswers("Avandamet (metformin and rosiglitazone)")
				.clickOnAnswers("Metformin", "Fortamet (metformin)", "Glucophage (metformin)", "Glucovance (metformin and glyburide)", "Glumetza (metformin)", "Invokamet (metformin and canagliflozin)")
				.clickOnAnswers("Janumet (metformin and sitagliptin)", "Jentadueto (metformin and linagliptin)", "Kazano (metformin and alogliptin)", "Kombiglyze (metformin and saxagliptin)")
				.clickNextButton(new ApartFromMetforminPageOLS())
				.waitForPageLoad()
				.back();
				
        
        metforminMedicationsPageOLS
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new ApartFromMetforminPageOLS());

        InsulinForYourDiabetesPageOLS insulinForYourDiabetesPageOLS = apartFromMetforminPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Actos (pioglitazone)")
                .clickNextButton(new InsulinForYourDiabetesPageOLS());
        insulinForYourDiabetesPageOLS
                .waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS4608", protocol1)
				.back();
        
        apartFromMetforminPageOLS
        		.waitForPageLoad()
        		.clickOnAnswers("Actos (pioglitazone)")
        		.clickOnAnswers("Avandia (rosiglitazone)")
        		.clickNextButton(new InsulinForYourDiabetesPageOLS())
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS4608", protocol1)
				.back();
        
        apartFromMetforminPageOLS
				.waitForPageLoad()
				.clickOnAnswers("Avandia (rosiglitazone)")
				.clickOnAnswers("Duetact (pioglitazone and glimepiride)")
				.clickNextButton(new InsulinForYourDiabetesPageOLS())
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS4608", protocol1)
				.back();
        
        apartFromMetforminPageOLS
				.waitForPageLoad()
				.clickOnAnswers("Duetact (pioglitazone and glimepiride)")
				.clickOnAnswers("Oseni (alogliptin and pioglitazone)")
				.clickNextButton(new InsulinForYourDiabetesPageOLS())
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS4608", protocol1)
				.back();
        
        apartFromMetforminPageOLS
				.waitForPageLoad()
				.clickOnAnswers("Oseni (alogliptin and pioglitazone)")
				.clickOnAnswers("Amaryl (glimepiride)", "Chlorpropamide", "Cycloset (bromocriptine)", "Farxiga (dapagliflozin)", "Glipizide XL, Glucotrol, or Glucotrol XL (glipizide)")
				.clickOnAnswers("Glynase (glyburide)", "Glyset (miglitol)", "Glyxambi (empagliflozin and linagliptin)", "Invokana (canagliflozin)", "Januvia (sitagliptin)", "Jardiance (empagliflozin)")
				.clickOnAnswers("Nesina (alogliptin)", "Onglyza (saxagliptin)", "Prandin (repaglinide)", "Precose (acarbose)", "Starlix (nateglinide)", "Tradjenta (linagliptin)", "Unsure")
				.clickNextButton(new InsulinForYourDiabetesPageOLS())
				.waitForPageLoad();							


        insulinForYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(insulinForYourDiabetesPageOLS.getTitleText(),insulinForYourDiabetesPageOLS.titleExpected, "Title is diff");
        SubquestionsHumalogPageOLS subquestionsHumalogPageOLS = insulinForYourDiabetesPageOLS
                .clickOnAnswers("Humalog","Humulin","Novolin","Novolog")
                .clickNextButton(new SubquestionsHumalogPageOLS());
        subquestionsHumalogPageOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS4609", protocol1);

        subquestionsHumalogPageOLS
                .waitForPageLoad();
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(1),subquestionsHumalogPageOLS.titleExpected1, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(2),subquestionsHumalogPageOLS.titleExpected2, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(3),subquestionsHumalogPageOLS.titleExpected3, "Title is diff");
        Assert.assertEquals(subquestionsHumalogPageOLS.getTitleText(4),subquestionsHumalogPageOLS.titleExpected4, "Title is diff");
        subquestionsHumalogPageOLS
                .clickOnAnswersForSubQuestion(1,"Humalog Mix 50/50","Humalog Mix 75/25")
                .clickOnAnswersForSubQuestion(2,"Humulin N or NPH")
                .clickOnAnswersForSubQuestion("What type of Novolin do you currently use?","Novolin N or NPH")
                .clickOnAnswersForSubQuestion("What type of Novolog do you currently use?","Novolog Mix 70/30")
                .back();

        InjectableMedicationsForYourDiabetesPageOLS injectableMedicationsForYourDiabetesPageOLS = insulinForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new InjectableMedicationsForYourDiabetesPageOLS());

        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad();
        Assert.assertEquals(injectableMedicationsForYourDiabetesPageOLS.getTitleText(),injectableMedicationsForYourDiabetesPageOLS.titleExpected, "Title is diff");
        CombinationWithEachOtherPageOLS combinationWithEachOtherPageOLS = injectableMedicationsForYourDiabetesPageOLS
                .clickOnAnswers("Adlyxin (lixisenatide)", "Another injectable medication not listed above", "Bydureon or Byetta (exenatide)", "Tanzeum (albiglutide)", "Trulicity (dulaglutide)")
                .clickOnAnswers("Saxenda or Victoza (liraglutide)", "SymlinPen (pramlintide)")
                .clickNextButton(new CombinationWithEachOtherPageOLS());
        combinationWithEachOtherPageOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4611", protocol1);
        NoOfAlcoholicDrinkOLS noOfAlcoholicDrinkOLS = combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 months")
                .clickNextButton(new NoOfAlcoholicDrinkOLS());
        noOfAlcoholicDrinkOLS
        		.waitForPageLoad()
                .back();
        combinationWithEachOtherPageOLS
                .waitForPageLoad()
                .back();
        injectableMedicationsForYourDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(combinationWithEachOtherPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("3 months")
                .clickNextButton(new NoOfAlcoholicDrinkOLS());
        
        LiverRelatedConditionOLS liverRelatedConditionOLS = noOfAlcoholicDrinkOLS
        		.waitForPageLoad()
        		.setDrinks("2")
        		.clickNextButton(new LiverRelatedConditionOLS());
        liverRelatedConditionOLS
        		.waitForPageLoad()
        		.clickOnAnswers("Alcoholic liver disease", "Hemochromatosis or iron overload", "Liver cancer or hepatocellular carcinoma", "Wilson's disease", "Primary sclerosing cholangitis or primary biliary cirrhosis")
        		.clickNextButton(followingToLoseWeightPageOLS)
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4624", protocol1)
        		.back();
        liverRelatedConditionOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(followingToLoseWeightPageOLS)
                .waitForPageLoad();
        
        Assert.assertEquals(followingToLoseWeightPageOLS.getTitleText(),followingToLoseWeightPageOLS.titleExpected, "Title is diff");
        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = followingToLoseWeightPageOLS
                .clickOnAnswers("Prescription weight loss medication")
                .clickNextButton(new WeightLossSurgeryPageOLS());

        weightLossSurgeryPageOLS
                .waitForPageLoad();
        Assert.assertEquals(weightLossSurgeryPageOLS.getTitleText(),weightLossSurgeryPageOLS.titleExpected, "Title is diff");
        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = weightLossSurgeryPageOLS
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());

        procedureForWeightLossPageOLS
                .waitForPageLoad();
        Assert.assertEquals(procedureForWeightLossPageOLS.getTitleText(),procedureForWeightLossPageOLS.titleExpected, "Title is diff");
        PoundsOrMorePageOLS poundsOrMorePageOLS = procedureForWeightLossPageOLS
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(new PoundsOrMorePageOLS());
        poundsOrMorePageOLS
                .waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS4616", protocol1)
        		.back();
       
        procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("3 - 6 months ago")
                .clickNextButton(poundsOrMorePageOLS)               
                .waitForPageLoad();
        
        Assert.assertEquals(poundsOrMorePageOLS.getTitleText(),poundsOrMorePageOLS.titleExpected, "Title is diff");
        poundsOrMorePageOLS
                .clickOnAnswer("Yes")
                //.clickNextButton(new StatinMedicationsOnPageOLS())
                .clickNextButton(new DoYouExperienceDPN_OLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS4617", protocol1)
                .back();
        poundsOrMorePageOLS
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new DoYouExperienceDPN_OLS())
        		.waitForPageLoad()
        		.clickOnAnswer("No, none of the above")
        		.clickNextButton(new StatinMedicationsOnPageOLS())
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new DiabeticNephropathyPageOLS())
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new ForYourKidneysPageOLS())
        		.waitForPageLoad()
        		.clickOnAnswer("No")
        		.clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondOLS())
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new HaveYouEverBeenDiagnosedAdditionalHeartRelatedOLS())
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new HeartrelatedMedicalProceduresPageOLS())
        		.waitForPageLoad()
        		.clickOnAnswers("None of the above")
        		.clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
        		.waitForPageLoad()
        	    .clickOnAnswers("ADHD or attention deficit hyperactivity disorder",
        	             		"Alzheimer's disease",
        	             		"Anemia (low red blood cell count)",
        	             		"Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)",
        	             		"Autism spectrum",
        	             		"Bone or joint problems (gout, osteoporosis, back pain, ankylosing spondylitis)",
        	             		"Breathing, respiratory, or lung problems (COPD, asthma, seasonal allergy, chronic cough)",
        	             		"Cancer",
        	             		"Diabetes (type 1 or type 2)",
        	             		"Digestive disorders (IBS, IBD, Crohn's disease, ulcerative colitis, heartburn or GERD)",
        	             		"Eating disorders (anorexia, bulimia, binge eating disorder)",
        	             		"Headaches (migraine, cluster, tension)",
        	             		"Heart or circulation problems (heart attack, heart failure, stroke)",
        	             		"High blood pressure or hypertension",
        	             		"High cholesterol, triglycerides, or lipids",
        	             		"Kidney disease",
        	             		"Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
        	             		"Lung problems",
        	             		"Lupus",
        	             		"Mental or emotional health conditions (anxiety, bipolar disorder, depression, PTSD, schizophrenia)",
        	             		"Neurological issues (memory loss, multiple sclerosis or MS, Parkinson's disease, seizure disorder or epilepsy, fibromyalgia)",
        	             		"Skin problems (eczema or atopic dermatitis, psoriasis, acne, cellulite, actinic or solar keratosis)",
        	             		"Sleep problems (insomnia, sleep apnea, narcolepsy)",
        	             		"Urinary or bladder problems (overactive bladder, urinary leakage or incontinence)",
        	             		"Women's health issues (endometriosis, uterine fibroids, PCOS, dense breasts)")
        	    .clickNextButton(new WhatKindOfArthritisPage())
        	    .waitForPageLoad()
        	    .back();
        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
         		.waitForPageLoad()
         		.clickOnAnswers("None of the above")
         		.clickOnAnswers("Cancer")
         		.clickNextButton(new OtherThanSkinCancerPageOLS());
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = otherThanSkinCancerPageOLS
         		.waitForPageLoad()
         		.clickOnAnswer("Within the past 5 years")
         		.clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());
        doAnyOftheFollowingAdditionalDiagnosesOLS
         		.waitForPageLoad()
         		.getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocol1)
                .back();
        otherThanSkinCancerPageOLS
 				.waitForPageLoad()
 				.clickOnAnswer("Diagnosed with skin cancer only")
 				.clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
        
        HormonalBirthControlOLS hormonalBirthControlOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
        		.waitForPageLoad()
        		.clickOnAnswers("Cirrhosis")
        		.clickNextButton(new HormonalBirthControlOLS());        		
        
        hormonalBirthControlOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS59", protocol1)
        		.back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Drug or alcohol abuse within the past year")
				.clickNextButton(new HormonalBirthControlOLS());
        hormonalBirthControlOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS59", protocol1)
				.back();
        
        
        doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Hepatitis B")
				.clickNextButton(new HormonalBirthControlOLS());
        hormonalBirthControlOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS59", protocol1)
				.back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("Hepatitis C")
				.clickNextButton(new HormonalBirthControlOLS());
        hormonalBirthControlOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS59", protocol1)
				.back();
        
        doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("HIV or AIDS")
				.clickNextButton(new HormonalBirthControlOLS());
        hormonalBirthControlOLS
				.waitForPageLoad()
				.getPage(debugPageOLS)
				.checkProtocolsContainsForQNumber("QS59", protocol1)
				.back();
        doAnyOftheFollowingAdditionalDiagnosesOLS
				.waitForPageLoad()
				.clickOnAnswers("None of the above")
				.clickNextButton(new HormonalBirthControlOLS());
        ApproximateHeightPageOLS approximateHeightPageOLS = hormonalBirthControlOLS
				.waitForPageLoad()
				.clickOnAnswer("No")
				.clickNextButton(new ApproximateHeightPageOLS());
        ChildrenUnderPageOLS childrenUnderPageOLS = approximateHeightPageOLS
				.waitForPageLoad()
		        .setAll("5", "5", "160")
		        .clickNextButton(new ChildrenUnderPageOLS());
        childrenUnderPageOLS
        		.waitForPageLoad()
        		.getPage(debugPageOLS)
        		.checkProtocolsContainsForQNumber("QS60", protocol1)
        		.back();
        
        approximateHeightPageOLS
				.waitForPageLoad()
				.setIncheswithClear("6")
				.setLbs("170")				
				.clickNextButton(new ChildrenUnderPageOLS());
        childrenUnderPageOLS
				.waitForPageLoad()
				.clickOnAnswer("No")		
                .clickNextButton(new TheStudySitePageOLS());
        
                TheStudySitePageOLS theStudySitePageOLS = new TheStudySitePageOLS();
  //----------*******NEW GENERAL HEALTH Questions********---------------------------     
		//-------------------PEDIATRIC QUESTIONS-----------------------------
         theStudySitePageOLS.waitForPageLoad()
         .clickOnAnswer("Public transportation")
         .clickNextButton(new WhatMedicalCoveragePageOLS())
        .waitForPageLoad()
        .clickOnAnswers("No, I have no coverage")
        .clickNextButton(new EthnicBackgroundPageOLS())
        .waitForPageLoad()
        .clickOnAnswers("Prefer not to answer")
        .clickNextButton(new IdentificationPageOLS())
		//----------PII (IdentificationPageOLS) Page--------------------
		.waitForPageLoad()
        .setAllFields("Auto", "Test", "qa.acurian@gmail.com", "9999999999", zipCode)
        .clickNextButton(new SiteSelectionPageOLS())
        .waitForPageLoadAKC()
        .getPID()
        .clickOnFacilityName(siteName)
        .clickNextButton(new QualifiedClose2PageOLS())
        .waitForPageLoad()
        .clickNextButton(new ThankYouCloseSimplePageOLS())
        .waitForPageLoad()
        .clickNextButton(new AboutHealthPageOLS())
        .waitForPageLoad()
        .pidFromDbToLog(env);
		
    }

}
