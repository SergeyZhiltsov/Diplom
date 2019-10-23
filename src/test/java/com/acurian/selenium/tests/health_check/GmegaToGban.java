package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.GBAN.LetsStartPageOLS;
import com.acurian.selenium.pages.OLS.RA.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.gmega.WhenYouDiagnosedWithRaGmegaPageOLS;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class GmegaToGban extends BaseTest {

    @Test
    @Description("Test for 1R DB Validation")
    public void gmegaToGban() {
        String phoneNumber = "AUTGMEGA01";
        String zipCode = "19901";
        String firstName = "Acurian";
        String lastName = "Trial";

        String env = System.getProperty("acurian.env", "QA");
        DebugPageOLS debugPageOLS = new DebugPageOLS();

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad("a rheumatoid arthritis (RA)", "625")
                .setDate("09091930")
                .clickNextButton(new BehalfOfSomeoneElsePageOLS());

        IdentificationPageOLS identificationPageOLS = behalfOfSomeoneElsePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new IdentificationPageOLS());

        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields(firstName, lastName, "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = genderPageOLS
                .waitForPageLoadByTitle(genderPageOLS.titleExpectedGmega)
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightPageOLS());

        FollowingNeurologicalConditionsPageOLS followingNeurologicalConditionsPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS());

        DigestiveConditionsPageOLS digestiveConditionsPageOLS = followingNeurologicalConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Alzheimer's disease")
                .clickNextButton(new DigestiveConditionsPageOLS());

        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = digestiveConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageOLS());

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(new WhatKindOfArthritisPageOLS());

        WhenYouDiagnosedWithRaGmegaPageOLS whenYouDiagnosedWithRaGmegaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaGmegaPageOLS());

        WhereDoYouHaveArthritisPageOLS whereDoYouHaveArthritisPageOLS = whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new WhereDoYouHaveArthritisPageOLS());

        WhichContainAcetaminophenPageOLS whichContainAcetaminophenPageOLS = whereDoYouHaveArthritisPageOLS
                .waitForPageLoadGMEGA()
                .clickOnAnswers("Other")
                .clickNextButton(new WhichContainAcetaminophenPageOLS());

        UndergoneGeneticTestingPageOLS undergoneGeneticTestingPageOLS = whichContainAcetaminophenPageOLS
                .waitForPageLoad()
                .clickOnAnswers("I cannot take acetaminophen or Tylenol because of allergy or another health reason")
                .clickNextButton(new UndergoneGeneticTestingPageOLS());

        StudiesThatAreCurrentlyEnrollingPageOLS studiesThatAreCurrentlyEnrollingPageOLS = undergoneGeneticTestingPageOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new StudiesThatAreCurrentlyEnrollingPageOLS());

        LetsStartPageOLS letsStartPageOLS = new LetsStartPageOLS();
        studiesThatAreCurrentlyEnrollingPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes");

            letsStartPageOLS
                    .clickNextButton(letsStartPageOLS)
                    .waitForPageLoadByTitle(letsStartPageOLS.titleExpectedQA)
                    .clickNextButton(dateOfBirthPageOLS);

//        studiesThatAreCurrentlyEnrollingPageOLS
//                .clickNextButton(dateOfBirthPageOLS);

        dateOfBirthPageOLS
                .waitForPageLoadByTitle(dateOfBirthPageOLS.titleExpectedGBAN1);
        Assert.assertEquals(debugPageOLS.getProjectNameText(), "GBAN1", "Project name is diff");
        dateOfBirthPageOLS.threadSleep(2000);
        dateOfBirthPageOLS.setDate("09/09/1955")
                .clickNextButton(behalfOfSomeoneElsePageOLS);

        behalfOfSomeoneElsePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Someone else")
                .clickNextButton(identificationPageOLS)
                .waitForPageLoadCaregiver();

        Assert.assertEquals(identificationPageOLS.getFirstName(), firstName, "First name is diff");
        Assert.assertEquals(identificationPageOLS.getLastName(), lastName, "Last name is diff");
    }
}