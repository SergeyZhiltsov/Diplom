package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.FLARE.ChooseTheMatterYouAreHereOLS;
import com.acurian.selenium.pages.OLS.FLARE.MostImportantChoiceOLS;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedFlareMonitoringAppClosePageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.time.Instant;

public class FlareActivationCode extends BaseTest {

    @Test
    @Description("Flare Activation Code verification")
    public void flareActivationCode() {

        String phoneNumber = "AUTGMEGA01";
        Site site = Site.AUT_GFLR1_site;
        String env = System.getProperty("acurian.env", "QA");
        String studyName = env.equals("QA") ?
                "Arthritis,a Crohn's study,a low back pain study,a rheumatoid arthritis (RA) study,an arthritis" : "Arthritis, a Crohn's study, a low back pain study, a rheumatoid arthritis (RA) study, an osteoarthritis";

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
                .setAllFields("Acurian", "Trial", "", "9999999999", site.zipCode)
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
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS());

        ChooseTheMatterYouAreHereOLS chooseTheMatterYouAreHereOLS = digestiveConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new ChooseTheMatterYouAreHereOLS());

        MostImportantChoiceOLS mostImportantChoiceOLS = chooseTheMatterYouAreHereOLS
                .waitForPageLoadQA()
                .clickOnAnswers("B")
                .clickNextButton(new MostImportantChoiceOLS());

        mostImportantChoiceOLS
                .waitForPageLoad()
                .clickOnAnswers("B")
                .clickNextButton(identificationPageOLS);

        SiteSelectionPageOLS siteSelectionPageOLS = identificationPageOLS
                .waitForPageLoadGMEGA()
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedFlareMonitoringAppClosePageOLS qualifiedFlareMonitoringAppClosePageOLS = siteSelectionPageOLS
                .waitForPageLoad("a Crohn's")
                .clickOnFacilityName(site.name)
                .getPID()
                .clickNextButton(new QualifiedFlareMonitoringAppClosePageOLS());

        ThankYouCloseGmegaOLS thankYouCloseGmegaOLS = qualifiedFlareMonitoringAppClosePageOLS
                .waitForPageLoadHealthCheck()
                .getActivationCodeQA()
                .enterEmail(Instant.now().getEpochSecond() + "@gmail.com")
                .clickNextButton(new ThankYouCloseGmegaOLS());

        thankYouCloseGmegaOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}