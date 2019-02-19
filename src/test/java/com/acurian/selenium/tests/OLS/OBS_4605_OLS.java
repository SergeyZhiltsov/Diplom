package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Obesity_4605.*;
import com.acurian.selenium.pages.OLS.closes.AboutHealthPageOLS;
import com.acurian.selenium.pages.OLS.closes.LessThan18YearsOldPageOLS;
import com.acurian.selenium.pages.OLS.closes.QualifiedClose2PageOLS;
import com.acurian.selenium.pages.OLS.closes.ThankYouCloseSimplePageOLS;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.pediatric.EthnicBackgroundPageOLS;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ProcedureForWeightLossPageOLS;
import com.acurian.selenium.pages.OLS.shared.WeightLossSurgeryPageOLS;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class OBS_4605_OLS extends BaseTest {

    @Test()
    @Description("OBS_4605_OLS")
    public void obs4605Ols() {
        Site site = Site.AUT_OBS_4605_Site;
        final String phoneNumber = "AUTAMS1OBS";
        final String studyName = "a genetic obesity";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.titleObesityExpected);
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_ols = dateOfBirthPageOLS
                .setDate("05052005")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPage_ols
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();

        IdentificationPageOLS identificationPageOLS = dateOfBirthPageOLS
                .setDate("05051990")
                .clickNextButton(new IdentificationPageOLS());

        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new ApproximateHeightPageOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        ExperienceExcessiveHungerOrIncreasedAppetiteOLS experienceExcessiveHungerOrIncreasedAppetitehaveOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6802", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .setLbs("300")
                .clickNextButton(new ExperienceExcessiveHungerOrIncreasedAppetiteOLS());

        WhenYouBecomeConcernedAboutWeightOLS whenYouBecomeConcernedAboutWeightOLS = experienceExcessiveHungerOrIncreasedAppetitehaveOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new WhenYouBecomeConcernedAboutWeightOLS());

        whenYouBecomeConcernedAboutWeightOLS
                .waitForPageLoad()
                .back(experienceExcessiveHungerOrIncreasedAppetitehaveOLS)
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(whenYouBecomeConcernedAboutWeightOLS)
                .waitForPageLoad()
                .back();

        WhenFirstNoticeHungerOrAbnormalFoodSeekingOLS whenFirstNoticeHungerOrAbnormalFoodSeekingOLS = experienceExcessiveHungerOrIncreasedAppetitehaveOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WhenFirstNoticeHungerOrAbnormalFoodSeekingOLS());

        DiagnosedWithPraderWilliSyndromeOLS diagnosedWithPraderWilliSyndromeOLS = whenFirstNoticeHungerOrAbnormalFoodSeekingOLS
                .waitForPageLoad()
                .clickOnAnswer("12 - 17 years old")
                .clickNextButton(whenYouBecomeConcernedAboutWeightOLS)
                .waitForPageLoad()
                .clickOnAnswer("18 years or older")
                .clickNextButton(new DiagnosedWithPraderWilliSyndromeOLS());

        WeightLossSurgeryPageOLS weightLossSurgeryPageOLS = diagnosedWithPraderWilliSyndromeOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new WeightLossSurgeryPageOLS());

        weightLossSurgeryPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6806", site.activeProtocols)
                .back(diagnosedWithPraderWilliSyndromeOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(weightLossSurgeryPageOLS);

        PlanningBiatricOrWeightLossSurgeryOLS planningBiatricOrWeightLossSurgeryOLS = weightLossSurgeryPageOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new PlanningBiatricOrWeightLossSurgeryOLS());

        ProcedureForWeightLossPageOLS procedureForWeightLossPageOLS = planningBiatricOrWeightLossSurgeryOLS
                .waitForPageLoad()
                .back(weightLossSurgeryPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Gastric bypass")
                .clickNextButton(new ProcedureForWeightLossPageOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = procedureForWeightLossPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 3 months ago")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        EthnicBackgroundPageOLS ethnicBackgroundPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new EthnicBackgroundPageOLS());

        ethnicBackgroundPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(identificationPageOLS)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS())
                .waitForPageLoad()
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env);
    }
}
