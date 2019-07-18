package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.RA.WhatKindOfArthritisPageOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.gmega.WhenYouDiagnosedWithRaGmegaPageOLS;
import com.acurian.selenium.pages.OLS.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class HelloSignOls extends BaseTest {

    @Test(enabled = true)
    @Description("Test for Hello Sign")
    public void helloSignOlsTest() {
        Site site = Site.AUT_GRA1_Site;
        String phoneNumber = "AUTGMEGA03"; //Indication RA
        String studyName = "a rheumatoid arthritis (RA) study!";

        String env = System.getProperty("acurian.env", "QA");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleRA2821Expected,
                "Title is diff");

        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new BehalfOfSomeoneElsePageOLS());

        IdentificationPageOLS identificationPageOLS = behalfOfSomeoneElsePageOLS
                .waitForPageLoad()
                .clickOnAnswer("Self")
                .clickNextButton(new IdentificationPageOLS());

        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        WhatKindOfArthritisPageOLS whatKindOfArthritisPageOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new WhatKindOfArthritisPageOLS()); //BoneOrJointConditionsPageOLS

        WhenYouDiagnosedWithRaGmegaPageOLS whenYouDiagnosedWithRaGmegaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaGmegaPageOLS());

        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(new BoneOrJointConditionsPageOLS());

        boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(identificationPageOLS);

        HSGeneralPageOLS hsGeneralPageOLS = identificationPageOLS
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad1(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new HSGeneralPageOLS());

        DoctorInformationCollectionPageOLS doctorInformationCollectionPageOLS = hsGeneralPageOLS
                .waitForPageLoadByTitle(hsGeneralPageOLS.titleRaExpectedQA)
                .clickNextButton(new DoctorInformationCollectionPageOLS());

        doctorInformationCollectionPageOLS
                .waitForPageLoadByTitle(doctorInformationCollectionPageOLS.titleGmegaQAExpected)
                .clickNextButton(new HS1PageOLS())
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();
        HumanAPIOLS humanAPIOLS = new HumanAPIOLS();
        ThankYouCloseGmegaOLS thankYouCloseGmegaOLS = humanAPIOLS
                .getPage(new HumanAPIOLS())
                .waitForPageLoadGmega()
                .connectBTN()
                .switchToAPI()
                .waitForProvider()
                .clickANY()
                .waitSearchAll()
                .search("cleveland clinic")
                .waitProvider()
                .clickProvider()
                .typeUserName("democlinical@gmail.com")
                .typePWD("password")
                .clickConnect()
                .waitToClickNext()
                .clickNextButton(new ThankYouCloseGmegaOLS());
        thankYouCloseGmegaOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}