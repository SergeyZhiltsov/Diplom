package com.acurian.selenium.tests.health_check;

import com.acurian.selenium.models.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.FLARE.ChooseTheMatterYouAreHereOLS;
import com.acurian.selenium.pages.OLS.FLARE.MostImportantChoiceOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedFlareMonitoringAppCLose_OLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.time.Instant;

public class FlareActivationCode extends BaseTest {


    @Test
    @Description("Flare Activation Code verification")
    public void flareActivationCode() {

        String phoneNumber = "AUTGMEGA01";
        Site site = Site.GFLR1_1234_GFLR1;
        String studyName = "Arthritis,a low back pain study,a rheumatoid arthritis (RA) study,an arthritis";
        String env = System.getProperty("acurian.env", "QA");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();

        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleRA2821Expected, "Title is diff");

        IdentificationPageOLS identificationPageOLS = dateOfBirthPageOLS
                .setDate("09091980")
                .clickNextButton(new IdentificationPageOLS());

        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "", "9999999999", site.zipCode)
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
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS());

        ChooseTheMatterYouAreHereOLS chooseTheMatterYouAreHereOLS = digestiveConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Crohn's disease")
                .clickNextButton(new ChooseTheMatterYouAreHereOLS());

        MostImportantChoiceOLS mostImportantChoiceOLS = chooseTheMatterYouAreHereOLS
                .waitForPageLoad()
                .clickOnAnswers("B")
                .clickNextButton(new MostImportantChoiceOLS());

        mostImportantChoiceOLS
                .waitForPageLoad()
                .clickOnAnswers("B")
                .clickNextButton(identificationPageOLS)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedFlareMonitoringAppCLose_OLS())
                .waitForPageLoad()
                .getActivationCodeQA()
                .enterEmail(Instant.now().getEpochSecond() + "@gmail.com");
    }
}
