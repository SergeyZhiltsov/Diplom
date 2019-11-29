package com.acurian.selenium.tests.OLS.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.DebugPageBlinxOLS;
import com.acurian.selenium.pages.blinx.ams.*;
import com.acurian.selenium.pages.blinx.gmega.AboutHealthPageOLS;
import com.acurian.selenium.pages.blinx.gmega.ApproximateHeightWeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.SiteSelectionPageOLS;
import com.acurian.selenium.pages.blinx.ams.QualifiedClosePageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.PersonalIdentificationPageOLS;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CV_4450_OLSblinx extends BaseTest {

    @DataProvider(name = "data")
    private Object[][] getTestData() {
        return new Object[][] {
                {Site.AUT_CV1_4450S_Syn, "Dover", "Delaware" }
        };
    }

    @Test(dataProvider = "data")
    public void cv4450olsBlinxTest(Site site, String city, String state) {
        DebugPageBlinxOLS debugPageBlinxOLS = new DebugPageBlinxOLS();
        LetsGetStartedPageOLS letsGetStartedPageOLS = new LetsGetStartedPageOLS();
        BaseTest.getDriver().navigate()
                .to("https://screener.acurianhealth.com/welcome.do?method=beginCall&phoneNumber=AUTAMS1CV1&up[]" +
                        "=CLIENT_BLINX&testing_key=51fa2780f2430b542923956ac1974bb7&show_debug=1#");

        LessThan18YearsOldPageOLSBlinx lessThan18YearsOldPageOLSBlinx = letsGetStartedPageOLS
                .waitForPageLoad("a heart health study", "750")
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLSBlinx());

        lessThan18YearsOldPageOLSBlinx
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QSI8005", site.activeProtocols)
                .clickPreviousQuestion();

        ZipCodePageOLS zipCodePageOLS = letsGetStartedPageOLS
                .waitForPageLoad("a heart health study", "750")
                .clickOnAnswer("Yes")
                .clickNextButton(new ZipCodePageOLS());

        DateOfBirthAndGenderPageOLS dateOfBirthAndGenderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new DateOfBirthAndGenderPageOLS());

        dateOfBirthAndGenderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .setDate("01082005") //Disqualify (“Age < 18 years old”) if <18
                .clickNextButton(lessThan18YearsOldPageOLSBlinx)
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .clickPreviousQuestion();
        CardiovascularDiseasePageOLS cardiovascularDiseasePageOLS = dateOfBirthAndGenderPageOLS
                .waitForPageLoad()
                .setDate("01081975")//"Disqualify (“Age”) if < 45
                .clickNextButton(new CardiovascularDiseasePageOLS());
        cardiovascularDiseasePageOLS
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .clickPreviousQuestion();
        dateOfBirthAndGenderPageOLS
                .waitForPageLoad()
                .setDate("01081970")
                .clickNextButton(cardiovascularDiseasePageOLS);

//        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseasePageOLS
        HeartRelatedEventsOrConditionsPageOLS heartRelatedEventsOrConditionsPageOLS = cardiovascularDiseasePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Diabetes or High Blood Sugar",
                        "High cholesterol or high triglycerides",
                        "High blood pressure or hypertension")
                .clickOnAnswers("None of the above")
                .clickNextButton(new HeartRelatedEventsOrConditionsPageOLS());
        heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();

        ConfirmsHighCholesterolTriglyceridesPageOLS confirmsHighCholesterolTriglyceridesPageOLS = cardiovascularDiseasePageOLS
                .waitForPageLoad()
                .clickOnAnswers("High cholesterol or high triglycerides")
                .clickNextButton(new ConfirmsHighCholesterolTriglyceridesPageOLS());

        CholesterolTriglyceridesLipidsPageOLS cholesterolTriglyceridesLipidsPageOLS = confirmsHighCholesterolTriglyceridesPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Yes, high cholesterol", "Yes, high triglycerides")
                .clickNextButton(new CholesterolTriglyceridesLipidsPageOLS());

        cholesterolTriglyceridesLipidsPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();
        confirmsHighCholesterolTriglyceridesPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = cardiovascularDiseasePageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes or High Blood Sugar")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        WithType1DiabetesPageOLSBlinx withType1DiabetesPageOLSBlinx = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(new WithType1DiabetesPageOLSBlinx());
        withType1DiabetesPageOLSBlinx
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .clickPreviousQuestion();
        WithType2diabetesPageOLS withType2diabetesPageOLS = whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new WithType2diabetesPageOLS());
        withType2diabetesPageOLS
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QS6704", site.activeProtocols)
                .clickPreviousQuestion();
        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Gestational diabetes (diabetes only during pregnancy)") //Display for Females only
                .clickOnAnswer("Unsure")
                .clickNextButton(heartRelatedEventsOrConditionsPageOLS);

        HeartRelatedSurgeriesOrProceduresPageOLS heartRelatedSurgeriesOrProceduresPageOLS = heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight",
                        "Heart failure or congestive heart failure (CHF)")
                .clickOnAnswers("None of the above") //Skip to Q16
                .clickNextButton(new HeartRelatedSurgeriesOrProceduresPageOLS());

        heartRelatedSurgeriesOrProceduresPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();

        SubquestionHeartPageOLS subquestionHeartPageOLS = heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Heart attack",
                        "Stroke",
                        "Mini-Stroke or TIA",
                        "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(new SubquestionHeartPageOLS());

        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .waitForPageLoad(2, subquestionHeartPageOLS.getTitleExpected2())
                .waitForPageLoad(3, subquestionHeartPageOLS.getTitleExpected3())
                .waitForPageLoad(4, subquestionHeartPageOLS.getTitleExpected4())
                .clickPreviousQuestion();
        heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack")
                .clickNextButton(subquestionHeartPageOLS);

        List<String> disqualifyQ15 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.1: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                    .clickOnAnswerForSubQuestion(2, answer)
                    .clickNextButton(heartRelatedSurgeriesOrProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageBlinxOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .clickPreviousQuestion();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .clickPreviousQuestion();
        heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Stroke")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.2	When was the last time that you experienced had a stroke?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.2: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected2())
                    .clickOnAnswerForSubQuestion(2, answer)
                    .clickNextButton(heartRelatedSurgeriesOrProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageBlinxOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .clickPreviousQuestion();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected2())
                .clickPreviousQuestion();
        heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Mini-Stroke or TIA")
                .clickNextButton(subquestionHeartPageOLS);

        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.3: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected3())
                    .clickOnAnswerForSubQuestion(2, answer)
                    .clickNextButton(heartRelatedSurgeriesOrProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageBlinxOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .clickPreviousQuestion();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected3())
                .clickPreviousQuestion();
        heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                .clickNextButton(subquestionHeartPageOLS);

        //Q15.4	When was the last time that you experienced suffered from angina or chest pain that required you to stay in a hospital overnight?
        for (String answer : disqualifyQ15) {
            System.out.println("Select answer for Q15.4: " + answer);
            subquestionHeartPageOLS
                    .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected4())
                    .clickOnAnswerForSubQuestion(2, answer)
                    .clickNextButton(heartRelatedSurgeriesOrProceduresPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageBlinxOLS)
                    .checkProtocolsContainsForQNumber("QS6737", site.activeProtocols)
                    .clickPreviousQuestion();
        }
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected4())
                .clickPreviousQuestion();
        heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart failure or congestive heart failure (CHF)")
                .clickNextButton(heartRelatedSurgeriesOrProceduresPageOLS);

        MostRecentHeartRelatedSurgeryProcedurePageOLSBlinx mostRecentHeartRelatedSurgeryProcedurePageOLSBlinx = heartRelatedSurgeriesOrProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Stent placement in your heart, neck or legs")
                .clickNextButton(new MostRecentHeartRelatedSurgeryProcedurePageOLSBlinx());

        AdditionalHeartrelatedConditionsPageOLS additionalHeartrelatedConditionsPageOLS = new AdditionalHeartrelatedConditionsPageOLS();
        List<String> disqualifyQ17 = Arrays.asList("Less than 30 days ago", "1 - 3 months ago");
        for (String answer : disqualifyQ17) {
            System.out.println("Select answer for Q17: " + answer);
            mostRecentHeartRelatedSurgeryProcedurePageOLSBlinx
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(additionalHeartrelatedConditionsPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageBlinxOLS)
                    .checkProtocolsContainsForQNumber("QS6739", site.activeProtocols)
                    .clickPreviousQuestion();
        }
        mostRecentHeartRelatedSurgeryProcedurePageOLSBlinx
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(additionalHeartrelatedConditionsPageOLS);

        ApproximateHeightWeightPageOLS approximateHeightWeightPageOLS = additionalHeartrelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightWeightPageOLS());

        CurrentlyTreatingYourDiabetesPageOLSBlinx currentlyTreatingYourDiabetesPageOLSBlinx = approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5", "5", "170")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageOLSBlinx());
        currentlyTreatingYourDiabetesPageOLSBlinx
                .waitForPageLoad()
                .getPage(debugPageBlinxOLS)
                .checkProtocolsContainsForQNumber("QS6722", site.activeProtocols)
                .clickPreviousQuestion();
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();
        additionalHeartrelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers()
                .clickPreviousQuestion();
        mostRecentHeartRelatedSurgeryProcedurePageOLSBlinx
                .waitForPageLoad()
                .clickPreviousQuestion();
        heartRelatedSurgeriesOrProceduresPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();
        heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Heart attack", "Stroke") //Qualifying answer Ghost Question
                .clickNextButton(subquestionHeartPageOLS);
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .waitForPageLoad(2, subquestionHeartPageOLS.getTitleExpected2())
                .clickOnAnswerForSubQuestion(2, "More than 1 year ago")
                .clickOnAnswerForSubQuestion(3, "More than 1 year ago")
                .clickNextButton(heartRelatedSurgeriesOrProceduresPageOLS);
        heartRelatedSurgeriesOrProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(additionalHeartrelatedConditionsPageOLS);
        additionalHeartrelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightWeightPageOLS);
        HealthcareDiagnosedConditionsPageOLS healthcareDiagnosedConditionsPageOLS = approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5","5", "170")
                .clickNextButton(new HealthcareDiagnosedConditionsPageOLS());

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();
        additionalHeartrelatedConditionsPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();
        heartRelatedSurgeriesOrProceduresPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();
        subquestionHeartPageOLS
                .waitForPageLoad(1, subquestionHeartPageOLS.getTitleExpected1())
                .waitForPageLoad(2, subquestionHeartPageOLS.getTitleExpected2())
                .clickPreviousQuestion();
        heartRelatedEventsOrConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartRelatedSurgeriesOrProceduresPageOLS);
        heartRelatedSurgeriesOrProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Any other surgery on the arteries in your legs, neck or heart")
                .clickNextButton(mostRecentHeartRelatedSurgeryProcedurePageOLSBlinx);
        mostRecentHeartRelatedSurgeryProcedurePageOLSBlinx
                .waitForPageLoad()
                .clickOnAnswer("4 - 6 months ago")
                .clickNextButton(additionalHeartrelatedConditionsPageOLS);
        additionalHeartrelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightWeightPageOLS);
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5","5", "170")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS);

        healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();
        additionalHeartrelatedConditionsPageOLS
                .waitForPageLoad()
                .clickPreviousQuestion();
        mostRecentHeartRelatedSurgeryProcedurePageOLSBlinx
                .waitForPageLoad()
                .clickPreviousQuestion();
        heartRelatedSurgeriesOrProceduresPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(additionalHeartrelatedConditionsPageOLS);
        additionalHeartrelatedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Peripheral Artery Disease or PAD (blockage in the arteries in your legs or poor circulation in legs)") //Qualifying answer Ghost Question
                .clickNextButton(approximateHeightWeightPageOLS);
        approximateHeightWeightPageOLS
                .waitForPageLoad()
                .setAllFields("5","5", "170")
                .clickNextButton(healthcareDiagnosedConditionsPageOLS);
        //------------------------Ghost Question - Cardiovascular Disease / Risk Qualifying Logic check-------------------------
        //Q26	Has a healthcare professional ever diagnosed you with any of the following medical conditions?
        List<String> disqualifyQ26 = Arrays.asList("Cancer in the past 5 years, except skin cancer",
                "Cirrhosis of the liver",
                "Drug or alcohol abuse within the past year",
                "Hepatitis B",
                "Hepatitis C",
                "HIV or AIDS",
                "Kidney disease requiring dialysis or transplant");
        for (String answer : disqualifyQ26) {
            System.out.println("Select answer for Q26: " + answer);
            healthcareDiagnosedConditionsPageOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(currentlyTreatingYourDiabetesPageOLSBlinx)
                    .waitForPageLoad()
                    .getPage(debugPageBlinxOLS)
                    .checkProtocolsContainsForQNumber("QS6725", site.activeProtocols)
                    .clickPreviousQuestion();
        }
        PersonalIdentificationPageOLS personalIdentificationPageOLS = healthcareDiagnosedConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PersonalIdentificationPageOLS());
        SiteSelectionPageOLS siteSelectionPageOLS = personalIdentificationPageOLS
                .waitForPageLoadPrequalified()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", site.zipCode, city, state)
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedClosePageOLS qualifiedClosePageOLS = siteSelectionPageOLS
                .waitForPageLoad5("a heart health study!")
                .getPage(debugPageBlinxOLS)
                .getPID()
                .getPage(siteSelectionPageOLS)
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClosePageOLS());

        ThankYouClosePageOLS thankYouClosePageOLS = qualifiedClosePageOLS
                .waitForPageLoad3()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouClosePageOLS());

        AboutHealthPageOLS aboutHealthPageOLS = thankYouClosePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());

        aboutHealthPageOLS
                .waitForPageLoad()
                .pidFromDbToLog("PRD")
                .childPidFromDbToLog("PRD")
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}