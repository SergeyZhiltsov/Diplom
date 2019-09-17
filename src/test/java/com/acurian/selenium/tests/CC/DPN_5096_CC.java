package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.DPN_3769_4557.*;

import com.acurian.selenium.pages.CC.Diabetes_4356A.CurrentlyTreatingYourDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.DiagnosedAnyTypeOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.SubquestionExperiencedHeartPageCC;
import com.acurian.selenium.pages.CC.Diabetes_4356A.WhatKindOfDiabetesPageCC;
import com.acurian.selenium.pages.CC.LOWT.CardiovascularDiseaseThanOthersPageCC;

import com.acurian.selenium.pages.CC.closes.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.*;
import com.acurian.selenium.pages.CC.shared.*;

import com.acurian.selenium.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DPN_5096_CC extends BaseTest {

    @Test()
    @Description("Diabetic Peripheral Neuropath (DPN)- 5096 CC")
    public void dpn5096Test() {
        Site site = Site.AUT_AMS1_4825_site;
        final String phoneNumber = "AUTAMS1DPN";
        String studyName = "a diabetic nerve pain";
        String studyNameForTrans = "a diabetic nerve pain";
        DebugPageCC debugPageCC = new DebugPageCC();
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
                .waitForPageLoad()
                .activateDebugOnProd(env);
        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), callCenterIntroductionPageCC.titleExpected,
                "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
                        .getExpectedModifiedTitle("a study for diabetics", "300"),
                "Title is diff");

        dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC())
                .waitForPageLoad()
                .back(dateOfBirthPageCC);
        ZipCodePageCC zipCodePageCC = dateOfBirthPageCC
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new ZipCodePageCC());

        GenderPageCC genderPageCC = zipCodePageCC
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageCC());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Apr")
                .setDay("5")
                .setYear("1943")
                .clickOnAnswer("Female")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();

        DiagnosedAnyTypeOfDiabetesPageCC diagnosedAnyTypeOfDiabetesPageCC = genderPageCC
                .waitForPageLoad()
                .setMonth("Apr")
                .setDay("5")
                .setYear("2001")
                .clickOnAnswer("Male")
                .clickNextButton(new DiagnosedAnyTypeOfDiabetesPageCC());

        //------------Q2 Have you been diagnosed with any type of diabetes?---------------
        diagnosedAnyTypeOfDiabetesPageCC.waitForPageLoad();
        Assert.assertEquals(diagnosedAnyTypeOfDiabetesPageCC.getTitleText(), diagnosedAnyTypeOfDiabetesPageCC.titleExpected, "Title is diff");
        diagnosedAnyTypeOfDiabetesPageCC
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5502", site.activeProtocols)
                .back(diagnosedAnyTypeOfDiabetesPageCC);

        diagnosedAnyTypeOfDiabetesPageCC.waitForPageLoad();
        WhatKindOfDiabetesPageCC whatKindOfDiabetesPageCC = diagnosedAnyTypeOfDiabetesPageCC  //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswer("Yes")
                .clickNextButton(new WhatKindOfDiabetesPageCC());

        //-----------Q3 -What kind of diabetes do you have?? ---------------
        CardiovascularDiseaseThanOthersPageCC cardiovascularDiseaseThanOthersPageCC = new CardiovascularDiseaseThanOthersPageCC();
        List<String> disqualifyQ3 = Arrays.asList("Type 1 diabetes (sometimes called Juvenile diabetes)",
                "High blood sugar only",
                "Unsure");
        for (String answer : disqualifyQ3) {
            System.out.println("Select answer for Q3: " + answer);
            whatKindOfDiabetesPageCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS5503", site.activeProtocols)
                    .back();
        }

        DoYouExperienceDPN_CC doYouExperienceDPN_CC = whatKindOfDiabetesPageCC.waitForPageLoad()
                .clickOnAnswer("Type 2 diabetes (sometimes called Adult-onset diabetes)")
                .clickNextButton(new DoYouExperienceDPN_CC())
                .waitForPageLoad();

        //----------Q4 - Do you experience diabetic peripheral neuropathy or diabetic nerve pain? -  Page ---------------
        doYouExperienceDPN_CC
                .waitForPageLoad()
                .clickOnAnswer("No, none of the above")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC);

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5504", site.activeProtocols)
                .back(doYouExperienceDPN_CC);

        WhereDoYouExperienceDiabeticNervePain_CC whereDoYouExperienceDiabeticNervePain_CC =
                doYouExperienceDPN_CC
                        .waitForPageLoad()
                        .clickOnAnswer("Yes, and I have been diagnosed by a healthcare professional")
                        .clickNextButton(new WhereDoYouExperienceDiabeticNervePain_CC());

        whereDoYouExperienceDiabeticNervePain_CC
                .waitForPageLoad()
                .back(doYouExperienceDPN_CC)
                .clickOnAnswer("I have not been diagnosed by a healthcare professional, but I do experience these symptoms")
                .clickNextButton(whereDoYouExperienceDiabeticNervePain_CC);

        //----------Q5 - "Where do you experience diabetic nerve pain symptoms or sensations?" Page ---------------
        whereDoYouExperienceDiabeticNervePain_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5522", site.activeProtocols)
                .back(whereDoYouExperienceDiabeticNervePain_CC);

        whereDoYouExperienceDiabeticNervePain_CC
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Right foot", "Left leg", "Right hand or arm", "Left hand or arm", "Other")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC);

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5522", site.activeProtocols)
                .back(whereDoYouExperienceDiabeticNervePain_CC);

        whereDoYouExperienceDiabeticNervePain_CC //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Right leg", "Left foot")
                .clickOnAnswers("Right hand or arm", "Left hand or arm", "Other")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC);

        cardiovascularDiseaseThanOthersPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5522", site.activeProtocols)
                .back(whereDoYouExperienceDiabeticNervePain_CC);

        HowWouldYouDescribeTheSymptoms_CC howWouldYouDescribeTheSymptoms_CC = whereDoYouExperienceDiabeticNervePain_CC //[create NEXT PAGE Object = THIS page object]
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Right foot", "Left foot")
                .clickNextButton(new HowWouldYouDescribeTheSymptoms_CC());

        howWouldYouDescribeTheSymptoms_CC
                .waitForPageLoad()
                .back(whereDoYouExperienceDiabeticNervePain_CC);

        whereDoYouExperienceDiabeticNervePain_CC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Right leg", "Left leg", "Left foot", "Right hand or arm", "Left hand or arm", "Other")
                .clickNextButton(howWouldYouDescribeTheSymptoms_CC);

        //----------Q6 - How would you describe the symptoms or sensations you feel in your feet, legs, hands, or arms? ---------
        ApproxHowlongYouBeenExpSymptomsCC approxHowlongYouBeenExpSymptomsCC =
                howWouldYouDescribeTheSymptoms_CC
                        .waitForPageLoad()
                        .clickOnAnswers("None of the above")
                        .clickNextButton(new ApproxHowlongYouBeenExpSymptomsCC());

        approxHowlongYouBeenExpSymptomsCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5506", site.activeProtocols)
                .back(howWouldYouDescribeTheSymptoms_CC);

        howWouldYouDescribeTheSymptoms_CC
                .waitForPageLoad()
                .clickOnAnswers("Other")
                .clickNextButton(approxHowlongYouBeenExpSymptomsCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5506", site.activeProtocols)
                .back(howWouldYouDescribeTheSymptoms_CC);

        howWouldYouDescribeTheSymptoms_CC
                .waitForPageLoad()
                .clickOnAnswers("Burning", "Painful cold", "Electric", "Tingling", "Pins and needles", "Numbness",
                        "Itching", "An increase in these symptoms or sensations when something brushes against your skin")
                .clickNextButton(approxHowlongYouBeenExpSymptomsCC);

        //----------Q9 -Approximately how long have you been experiencing symptoms or sensations of diabetic nerve pain?-  Page ---------------
        HowWouldYouRateYourPain_CC howWouldYouRateYourPain_CC = approxHowlongYouBeenExpSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("5 months or less")
                .clickNextButton(new HowWouldYouRateYourPain_CC());

        howWouldYouRateYourPain_CC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5509", site.activeProtocols)
                .back(approxHowlongYouBeenExpSymptomsCC);

        approxHowlongYouBeenExpSymptomsCC
                .waitForPageLoad()
                .clickOnAnswer("6 - 11 months")
                .clickNextButton(howWouldYouDescribeTheSymptoms_CC);

        howWouldYouRateYourPain_CC.waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5509", site.activeProtocols)
                .back(approxHowlongYouBeenExpSymptomsCC);

        List<String> qualifyQ9 = Arrays.asList("1 - 3 years",
                "4 - 6 years",
                "7 - 10 years",
                "11 or more years");

        for (String answer : qualifyQ9) {
            System.out.println("Select answer for Q9: " + answer);
            approxHowlongYouBeenExpSymptomsCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(howWouldYouRateYourPain_CC)
                    .waitForPageLoad()
                    .back(approxHowlongYouBeenExpSymptomsCC);
        }

        approxHowlongYouBeenExpSymptomsCC
                .clickNextButton(howWouldYouRateYourPain_CC);

        //----------Q10 - How would you rate your pain or discomfort on a scale of 0 to 10? - page
        HaveYouHadAnyOfTheFollowingAmputatedPageCC haveYouHadAnyOfTheFollowingAmputatedPageCC = howWouldYouRateYourPain_CC
                .waitForPageLoad()
                .selectPainRating("0")
                .clickNextButton(new HaveYouHadAnyOfTheFollowingAmputatedPageCC());

        haveYouHadAnyOfTheFollowingAmputatedPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5510", site.activeProtocols)
                .back(howWouldYouRateYourPain_CC);

        howWouldYouRateYourPain_CC
                .waitForPageLoad()
                .selectPainRating("5")
                .clickNextButton(haveYouHadAnyOfTheFollowingAmputatedPageCC);

        //----------Q14 -Which of the following have you had amputated or surgically removed because of your diabetes?-  Page ---------------
        CurrentlyTreatingYourDiabetesPageCC currentlyTreatingYourDiabetesPageCC = haveYouHadAnyOfTheFollowingAmputatedPageCC
                .waitForPageLoad()
                .clickOnAnswers("Leg")
                .clickNextButton(new CurrentlyTreatingYourDiabetesPageCC());

        currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5523", site.activeProtocols)
                .back(haveYouHadAnyOfTheFollowingAmputatedPageCC);

        haveYouHadAnyOfTheFollowingAmputatedPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Foot")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC);

        currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5523", site.activeProtocols)
                .back(haveYouHadAnyOfTheFollowingAmputatedPageCC);

        haveYouHadAnyOfTheFollowingAmputatedPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Toe", "Other")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC);

        currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .back(haveYouHadAnyOfTheFollowingAmputatedPageCC);

        haveYouHadAnyOfTheFollowingAmputatedPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(currentlyTreatingYourDiabetesPageCC);

        currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("I am not currently treating my diabetes")
                .clickNextButton(cardiovascularDiseaseThanOthersPageCC);

        cardiovascularDiseaseThanOthersPageCC
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS5524")
                .back(currentlyTreatingYourDiabetesPageCC);

        currentlyTreatingYourDiabetesPageCC
                .waitForPageLoad()
                .clickOnAnswers("Diet and exercise", "Medication such as metformin or insulin or other diabetes medication")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);

        //----------------------GENERAL HEALTH Questions -----------------------------
        WhenDiagnosedWithCancerCC whenDiagnosedWithCancerCC = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .clickOnAnswers("Cancer", "Heart or circulation problems (heart attack, heart failure, stroke)")
                .clickNextButton(new WhenDiagnosedWithCancerCC());

        HaveYouEverExperiencedHeartRelatedMedicalCondCC haveYouEverExperiencedHeartRelatedMedicalCondCC = whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new HaveYouEverExperiencedHeartRelatedMedicalCondCC());

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerCC);

        whenDiagnosedWithCancerCC
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        SubquestionExperiencedHeartPageCC subquestionExperiencedHeartPageCC =
                haveYouEverExperiencedHeartRelatedMedicalCondCC
                        .waitForPageLoad()
                        .clickOnAnswers("Heart attack", "Stroke",
                                "Mini-Stroke or TIA",
                                "Angina, or heart-related chest pain, that required you to stay in a hospital overnight")
                        .clickNextButton(new SubquestionExperiencedHeartPageCC());

        subquestionExperiencedHeartPageCC
                .waitForPageLoad(1, subquestionExperiencedHeartPageCC.titleExpected1)
                .waitForPageLoad(2, subquestionExperiencedHeartPageCC.titleExpected2)
                .waitForPageLoad(3, subquestionExperiencedHeartPageCC.titleExpected3)
                .waitForPageLoad(4, subquestionExperiencedHeartPageCC.titleExpected4);

        HeartrelatedMedicalProceduresPageCC heartrelatedMedicalProceduresPageCC = subquestionExperiencedHeartPageCC
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected1, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected2, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected3, "4 - 6 months ago")
                .clickOnAnswerForSubQuestion(subquestionExperiencedHeartPageCC.titleExpected4, "4 - 6 months ago")
                .clickNextButton(new HeartrelatedMedicalProceduresPageCC());

        heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS47", site.activeProtocols)
                .back(subquestionExperiencedHeartPageCC)
                .back(haveYouEverExperiencedHeartRelatedMedicalCondCC);

        haveYouEverExperiencedHeartRelatedMedicalCondCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(heartrelatedMedicalProceduresPageCC);

        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = heartrelatedMedicalProceduresPageCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesCC());

        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad();
        ApproximateHeightPageCC approximateHeightPageCC = doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder",
                        "Cirrhosis",
                        "Drug or alcohol abuse within the past year",
                        "HIV or AIDS",
                        "Kidney disease requiring dialysis",
                        "Multiple sclerosis (MS)",
                        "Seizure disorder such as epilepsy",
                        "Schizophrenia")
                .clickNextButton(new ApproximateHeightPageCC());

        approximateHeightPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back();
        doAnyOftheFollowingAdditionalDiagnosesCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B", "Hepatitis C", "Neuropathy (nerve damage due to diabetes or another condition)")
                .clickNextButton(approximateHeightPageCC)
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new IdentificationPageCC())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageCC())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnAnswer(site.name)
                .clickNextButton(new QualifiedClose1PageCC())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageCC())
                .clickNextButton(selectActionPageCC)
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
        ;
    }
}