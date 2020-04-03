package com.acurian.selenium.health_checkBlinx;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.derm.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.blinx.ams.gban.LetsStartPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.ApproximateHeightPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.BoneOrJointConditionsPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.FollowingNeurologicalConditionsPageOLS;
import com.acurian.selenium.pages.blinx.ams.ra.StudiesThatAreCurrentlyEnrollingPageOLS;
import com.acurian.selenium.pages.blinx.ams.ra.UndergoneGeneticTestingPageOLS;
import com.acurian.selenium.pages.blinx.ams.ra.WhichContainAcetaminophenPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.WhereDoYouHaveArthritisPageOLS;
import com.acurian.selenium.pages.blinx.gmega.DigestiveConditionsPageOLS;
import com.acurian.selenium.pages.blinx.gmega.WhenYouDiagnosedWithRaGmegaPageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

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
                .waitForPageLoadGMEGA("a rheumatoid arthritis (RA)", "625")
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
                .waitForPageLoadGMEGAConfirm()
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
                .waitForPageLoad1();
//                .waitForPageLoadByTitle(dateOfBirthPageOLS.titleExpectedGBAN1);

        Assert.assertEquals(debugPageOLS.getProjectNameText(), "GBAN1", "Project name is diff");
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
