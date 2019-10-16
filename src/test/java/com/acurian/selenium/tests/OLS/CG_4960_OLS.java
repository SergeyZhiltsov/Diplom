package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Gout.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesOLS;
import io.qameta.allure.Description;
import org.junit.Test;

public class CG_4960_OLS extends BaseTest {
    @Description("4960 LG-GDCL002 LG Chem Gout OLS")
    @Test()
    public void cg4960OLSTest(Site site) {
        EverDiagnosedWithGoutOLS everDiagnosedWithGoutOLS = new EverDiagnosedWithGoutOLS();
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = new DoAnyOftheFollowingAdditionalDiagnosesOLS();
        //Q2
        HowManyGoutAttacksOLS howManyGoutAttacksOLS = everDiagnosedWithGoutOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(everDiagnosedWithGoutOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowManyGoutAttacksOLS());

        //Q3
        EverTakenMedicationOLS everTakenMedicationOLS = new EverTakenMedicationOLS();
        howManyGoutAttacksOLS
                .waitForPageLoad()
                .clickOnAnswer("No gout attacks in the past year")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(howManyGoutAttacksOLS)
                .waitForPageLoad()
                .clickOnAnswer("1")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(howManyGoutAttacksOLS)
                .waitForPageLoad()
                .clickOnAnswer("2 or more")
                .clickNextButton(everTakenMedicationOLS);

        //Q4
        EverTakenFollowingMedicationsCurrentlyOrPastOLS everTakenFollowingMedicationsCurrentlyOrPastOLS = everTakenMedicationOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(everTakenMedicationOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new EverTakenFollowingMedicationsCurrentlyOrPastOLS());

        //Q5,6,7
        CurrentlyTakingUloricOLS currentlyTakingUloriOLSC = new CurrentlyTakingUloricOLS();
        PastThreeMonthsTakenKrystexxaOLS pastThreeMonthsTakenKrystexxaOLS = everTakenFollowingMedicationsCurrentlyOrPastOLS
                .waitForPageLoad()
                .clickOnAnswers("Uloric, also called febuxostat")
                .clickNextButton(currentlyTakingUloriOLSC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(currentlyTakingUloriOLSC)
                .back(everTakenFollowingMedicationsCurrentlyOrPastOLS)
                .waitForPageLoad()
                .clickOnAnswers("Allopurinol, also called Aloprim or Zyloprim")
                .clickNextButton(currentlyTakingUloriOLSC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(currentlyTakingUloriOLSC)
                .back(everTakenFollowingMedicationsCurrentlyOrPastOLS)
                .waitForPageLoad()
                .clickOnAnswers("Uloric, also called febuxostat")
                .clickNextButton(currentlyTakingUloriOLSC)
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(currentlyTakingUloriOLSC)
                .back(everTakenFollowingMedicationsCurrentlyOrPastOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above ")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(everTakenFollowingMedicationsCurrentlyOrPastOLS)
                .waitForPageLoad()
                .clickOnAnswers("Allopurinol, also called Aloprim or Zyloprim")
                .clickNextButton(currentlyTakingUloriOLSC)
                .clickNextButton(new PastThreeMonthsTakenKrystexxaOLS());

        //Q8
        pastThreeMonthsTakenKrystexxaOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(pastThreeMonthsTakenKrystexxaOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);
    }
}
