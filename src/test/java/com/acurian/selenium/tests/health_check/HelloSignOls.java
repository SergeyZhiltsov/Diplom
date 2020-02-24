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
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import org.openqa.selenium.TimeoutException;

public class HelloSignOls extends BaseTest {

    @Test(enabled = true)
    @Description("Test for Hello Sign")
    public void helloSignOlsTest() {
        Site site = Site.AUT_GRA1_Site;
        String phoneNumber = "AUTGMEGA03"; //Indication RA
        String studyName = "a rheumatoid arthritis (RA)";

        String env = System.getProperty("acurian.env", "QA");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        BehalfOfSomeoneElsePageOLS behalfOfSomeoneElsePageOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadGMEGA("a rheumatoid arthritis (RA)", "625")
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
                .waitForPageLoadByTitle(genderPageOLS.titleExpected)
                .clickOnAnswer("Female")
                .clickNextButton(new WhatKindOfArthritisPageOLS()); //BoneOrJointConditionsPageOLS

        WhenYouDiagnosedWithRaGmegaPageOLS whenYouDiagnosedWithRaGmegaPageOLS = whatKindOfArthritisPageOLS
                .waitForPageLoadGMEGA()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(new WhenYouDiagnosedWithRaGmegaPageOLS());

        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = whenYouDiagnosedWithRaGmegaPageOLS
                .waitForPageLoad()
                .clickOnAnswer("7 - 11 months ago")
                .clickNextButton(new BoneOrJointConditionsPageOLS());

        boneOrJointConditionsPageOLS
                .waitForPageLoadGMEGA()
                .clickOnAnswers("Any type of arthritis")
                .clickNextButton(identificationPageOLS);

        HSGeneralPageOLS hsGeneralPageOLS = identificationPageOLS
                .waitForPageLoadGMEGA2()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoadGMEGA(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new HSGeneralPageOLS());

        DoctorInformationCollectionPageOLS doctorInformationCollectionPageOLS = hsGeneralPageOLS
                .waitForPageLoadByTitleGMEGA(hsGeneralPageOLS.titleRaExpectedQA)
                .clickNextButton(new DoctorInformationCollectionPageOLS());

        HS1PageOLS hs1PageOLS = doctorInformationCollectionPageOLS
                .waitForPageLoadByTitleGMEGA(env.equals("QA") ? doctorInformationCollectionPageOLS.titleGmegaQAExpected :
                        doctorInformationCollectionPageOLS.titleGmegaExpected)
                .clickNextButton(new HS1PageOLS());

        hs1PageOLS
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();
        if (env.equals("QA")) {
            HumanAPIOLS humanAPIOLS = new HumanAPIOLS();
            humanAPIOLS
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
                    .clickConnect();
        }
        ThankYouCloseGmegaOLS thankYouCloseGmegaOLS = hs1PageOLS
                .waitToClickNext()
                .clickNextButton(new ThankYouCloseGmegaOLS());

        try {
            thankYouCloseGmegaOLS
                    .waitForPageLoad()
                    .clickNextButton(new AboutHealthPageOLS());
        } catch (TimeoutException ex) {
            System.out.println("Page ThankYouCloseGmegaOLS was skipped.");
        }
        new AboutHealthPageOLS()
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}