package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Osteoporosis.*;
import com.acurian.selenium.pages.CC.closes.DoesNotGivePermissionToProceedClosePageCC;
import com.acurian.selenium.pages.CC.closes.LessThan18YearsOldPageCC;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC;
import com.acurian.selenium.pages.CC.shared.*;
import com.acurian.selenium.utils.Properties;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RO_7069_CC extends BaseTest {

    @Test
    @Description("7069 Radius Osteoporosis CC")
    public void af4958CCTest() {
        final Site site = Site.AUT_OA_4109_Site; //todo
        final String phoneNumber = "800AMS1MTA"; //todo
        final String studyName = "an osteoporosis study";
        final String transitionStudyName = "osteoporosis";

        String env = System.getProperty("acurian.env", "STG");

        LoginPageCC loginPageCC = new LoginPageCC();
        DebugPageCC debugPageCC = new DebugPageCC();

        loginPageCC
                .openPage(env)
                .waitForPageLoad();
        Assert.assertEquals(loginPageCC.getTitleText(), "Please enter your username and password to login:",
                "Title text is diff");
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
//        Assert.assertEquals(callCenterIntroductionPageCC.getTitleText(), //todo
//                callCenterIntroductionPageCC.titleExpected, "Title is diff");
        DateOfBirthPageCC dateOfBirthPageCC = callCenterIntroductionPageCC
                .clickOnAnswer("Learn more about matching to clinical trials")
                .clickNextButton(new DateOfBirthPageCC());

        //-------Date of Birth Page--------
        dateOfBirthPageCC
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageCC.getTitleText(), dateOfBirthPageCC
                .getExpectedModifiedTitle(studyName, "others"), "Title is diff");
        DoesNotGivePermissionToProceedClosePageCC doesNotGivePermissionToProceedClosePageCC = dateOfBirthPageCC
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "No")
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "No")
                .clickNextButton(new DoesNotGivePermissionToProceedClosePageCC());

        LessThan18YearsOldPageCC lessThan18YearsOldPageCC = doesNotGivePermissionToProceedClosePageCC
                .waitForPageLoad()
                .back(dateOfBirthPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected2, "Yes")
                .clickNextButton(new LessThan18YearsOldPageCC());
        GenderPageCC genderPageCC = lessThan18YearsOldPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageCC)
                .waitForPageLoad()
                .clickOnAnswerForSubQuestion(dateOfBirthPageCC.titleExpected, "Yes")
                .clickNextButton(new GenderPageCC());


        genderPageCC
                .waitForPageLoad()
                .setMonth("Jan")
                .setDay("1")
                .setYear("2002") //Disqualify (“Age < 18 years old”) if <18
                .clickOnAnswer("Female")
                .clickNextButton(lessThan18YearsOldPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC =
                genderPageCC
                        .waitForPageLoad()
                        .setYear("1970") //Disqualify ("Age") if < 50
                        .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageCC)
                .waitForPageLoad()
                .setYear("1932") //Disqualify ("Age") if >= 86
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back();
        EverDiagnosedWithOsteoporosisCC everDiagnosedWithOsteoporosisCC = genderPageCC
                .waitForPageLoad()
                .setYear("1960")
                .clickNextButton(new EverDiagnosedWithOsteoporosisCC());

        //Q2
        NonQRtransitionPageCC nonQRtransitionPageCC = everDiagnosedWithOsteoporosisCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new NonQRtransitionPageCC());
        OsteoporosisRelatedFracturesCC osteoporosisRelatedFracturesCC = nonQRtransitionPageCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7702", site.activeProtocols)
                .back(everDiagnosedWithOsteoporosisCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new OsteoporosisRelatedFracturesCC());

        //Q3
        HaveYouGoneThroughMenopauseCC haveYouGoneThroughMenopauseCC = osteoporosisRelatedFracturesCC
                .waitForPageLoad()
                .clickOnAnswers("Hip fracture",
                        "Spine (vertebral) fracture",
                        "Wrist fracture",
                        "Pelvic fracture",
                        "Other fracture")
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouGoneThroughMenopauseCC());

        //Q4
        HowLongAgoReachMenopauseCC howLongAgoReachMenopauseCC = haveYouGoneThroughMenopauseCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HowLongAgoReachMenopauseCC());
        howLongAgoReachMenopauseCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7704", site.activeProtocols)
                .back(haveYouGoneThroughMenopauseCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes, natural menopause (meaning that you have not had a menstrual period for at least 12 consecutive months, due to the natural aging process)")
                .clickOnAnswer("Yes, surgical menopause (meaning that both of your ovaries were surgically removed)")
                .clickOnAnswer("Yes, menopause for another reason, such as premature ovarian failure or exposure to a medical treatment like chemotherapy")
                .clickNextButton(howLongAgoReachMenopauseCC);

        //Q5
        CurrentlyTakingMedicationsOsteoporosisCC currentlyTakingMedicationsOsteoporosisCC =
                new CurrentlyTakingMedicationsOsteoporosisCC();
        List<String> disqualifyQ5 = Arrays.asList("Within the past year", "1 - 4 years ago");
        for (String answer : disqualifyQ5) {
            System.out.println("Select answer for Q5: " + answer);
            howLongAgoReachMenopauseCC
                    .waitForPageLoad()
                    .clickOnAnswer(answer)
                    .clickNextButton(currentlyTakingMedicationsOsteoporosisCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7705", site.activeProtocols)
                    .back();
        }
        howLongAgoReachMenopauseCC
                .waitForPageLoad()
                .clickOnAnswer("5 years ago or more")
                .clickNextButton(currentlyTakingMedicationsOsteoporosisCC);

        //Q6
        InjectionsForteoOrTymlosOsteoporosisCC injectionsForteoOrTymlosOsteoporosisCC =
                new InjectionsForteoOrTymlosOsteoporosisCC();
        List<String> disqualifyQ6 = Arrays.asList("Actonel or Atelvia (risedronate)", "Binosto or Fosamax (alendronate)",
                "Boniva (ibandronate)", "Reclast or Zometa (zoledronic acid)", "Evista (raloxifene)",
                "Soltamox (tamoxifen)", "Rayaldee (calcifediol)", "Rocaltrol (calcitriol)",
                "Prolia or Xgeva (denosumab)", "Miacalcin (calcitonin)");
        for (String answer : disqualifyQ6) {
            System.out.println("Select answer for Q6: " + answer);
            currentlyTakingMedicationsOsteoporosisCC
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(answer)
                    .clickNextButton(injectionsForteoOrTymlosOsteoporosisCC)
                    .waitForPageLoad()
                    .getPage(debugPageCC)
                    .checkProtocolsContainsForQNumber("QS7706", site.activeProtocols)
                    .back();
        }
        currentlyTakingMedicationsOsteoporosisCC
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(injectionsForteoOrTymlosOsteoporosisCC);

        //Q7
        IntravenousMedicationOsteoporosisCC intravenousMedicationOsteoporosisCC = injectionsForteoOrTymlosOsteoporosisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IntravenousMedicationOsteoporosisCC());
        intravenousMedicationOsteoporosisCC
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7707", site.activeProtocols)
                .back(injectionsForteoOrTymlosOsteoporosisCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickOnAnswer("Unsure")
                .clickNextButton(intravenousMedicationOsteoporosisCC);

        //Q8
        TransitionStatementCC transitionStatementCC = intravenousMedicationOsteoporosisCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new TransitionStatementCC());
        transitionStatementCC
                .waitForPageLoadNew(transitionStudyName)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("QS7708", site.activeProtocols)
                .back(intravenousMedicationOsteoporosisCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickOnAnswer("Unsure")
                .clickNextButton(transitionStatementCC);


        transitionStatementCC
                .waitForPageLoadNew(transitionStudyName)
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondCC);
    }
}
