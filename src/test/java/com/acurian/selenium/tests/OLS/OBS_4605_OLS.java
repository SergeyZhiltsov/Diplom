package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Obesity_4605.*;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
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
                .waitForPageLoad("a genetic obesity study", "25 per visit");
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(),
                dateOfBirthPageOLS.getExpectedModifiedTitle("a genetic obesity study", "25 per visit"), "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_ols = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .clickNextButton(new LessThan18YearsOldPageOLS());

        lessThan18YearsOldPage_ols
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back();

        IdentificationPageOLS identificationPageOLS = dateOfBirthPageOLS
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());

        GenderPageOLS genderPageOLS = identificationPageOLS
                .waitForPageLoadNotQ()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new GenderPageOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("05051990")
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

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(identificationPageOLS)
                .waitForPageLoad()
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose1PageOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new ThankYouCloseSimplePageOLS())
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS())
                .waitForPageLoad()
                .pidFromDbToLog(env)
                .childPidFromDbToLog(env)
                .assertGeneratedFul(env, site)
                .dispoShouldMatch(site.dispo, site.dispo);
    }
}
