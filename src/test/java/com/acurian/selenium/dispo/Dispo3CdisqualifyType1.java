package com.acurian.selenium.dispo;

import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.UnqualifiedCloseOLS_GMEGA;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.gmega.ThankYouCloseGmegaOLS;
import com.acurian.selenium.pages.OLS.shared.BehalfOfSomeoneElsePageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class Dispo3CdisqualifyType1 extends BaseTest {

    @Test(enabled= true)
    @Description("Dispo_3C_DisQualify_Type1")
    public void dispo3Ctype1() {
        String phoneNumber = "AUTGMEGA01";
        String env = System.getProperty("acurian.env", "STG");
        String zipCode = "08204";

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
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com",
                        "9999999999", zipCode)
                .clickNextButton(new GenderPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = genderPageOLS
                .waitForPageLoadByTitle(genderPageOLS.titleExpectedGmega)
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightPageOLS());

        FollowingNeurologicalConditionsPageOLS followingNeurologicalConditionsPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "160")
                .clickNextButton(new FollowingNeurologicalConditionsPageOLS());

        DigestiveConditionsPageOLS digestiveConditionsPageOLS = followingNeurologicalConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DigestiveConditionsPageOLS());

        BoneOrJointConditionsPageOLS boneOrJointConditionsPageOLS = digestiveConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new BoneOrJointConditionsPageOLS());

        boneOrJointConditionsPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .getPage(new SiteSelectionPageOLS())
                .getPID();
        if (env.equals("QA")) {
            boneOrJointConditionsPageOLS
                    .clickNextButton(new AboutHealthPageOLS())
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .dispoShouldMatch("3C")
                    .copyRun(env)
                    .childPidFromDbToLog(env);
        } else {
            boneOrJointConditionsPageOLS
                    .clickNextButton(new UnqualifiedCloseOLS_GMEGA())
                    .waitForPageLoad()
                    .clickOnAnswer("No")
                    .clickNextButton(new ThankYouCloseGmegaOLS())
                    .waitForPageLoad()
                    .clickNextButton(new AboutHealthPageOLS())
                    .pidFromDbToLog(env)
                    .dispoShouldMatch("3C")
                    .copyRun(env)
                    .childPidFromDbToLog(env);
        }
    }
}
