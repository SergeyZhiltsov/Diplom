package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA_2821.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class GmegaToGban extends BaseTest {

    @Test
    @Description("Test for 1R DB Validation")
    public void gmegaToGban() {
        String phoneNumber = "AUTGMEGA01";
        String studyName = "Arthritis,a low back pain study,a rheumatoid arthritis (RA)";
        String siteName = "AUT_GRA1_Site";
        String zipCode = "19044";
        String firstName = "Acurian";
        String lastName = "Trial";


        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleRA2821Expected, "Title is diff");
        IdentificationPageOLS identificationPageOLS = dateOfBirthPageOLS
                .setDate("09091930")
                .clickNextButton(new IdentificationPageOLS());

        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields(firstName, lastName, "qa.acurian@gmail.com", "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = genderPageOLS
                .waitForPageLoad()
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

        WhenYouDiagnosedWithRaPageOLS whenYouDiagnosedWithRaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaPageOLS());

        WhereDoYouHaveArthritisPageOLS whereDoYouHaveArthritisPageOLS = whenYouDiagnosedWithRaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 2 months")
                .clickNextButton(new WhereDoYouHaveArthritisPageOLS());

        WhichContainAcetaminophenPageOLS whichContainAcetaminophenPageOLS = whereDoYouHaveArthritisPageOLS
                .waitForPageLoad()
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

        StandAlone4295SwitchOLS standAlone4295SwitchOLS = studiesThatAreCurrentlyEnrollingPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new StandAlone4295SwitchOLS());

        standAlone4295SwitchOLS
                .waitForPageLoad();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        Assert.assertEquals(debugPageOLS.projectNameText(), "GBAN1", "Project name is diff");

        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = standAlone4295SwitchOLS
                .clickNextButton(new BehalfOfSomeoneElsePageOLS());
        behalfOfSomeoneElsePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Someone else")
                .clickNextButton(identificationPageOLS)
                .waitForPageLoadCaregiver();

        Assert.assertEquals(identificationPageOLS.getFirstName(), firstName, "First name is diff");
        Assert.assertEquals(identificationPageOLS.getLastName(), lastName, "Last name is diff");
    }
}
