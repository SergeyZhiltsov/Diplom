package com.acurian.selenium.tests.CC;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.CC.Gout.*;
import com.acurian.selenium.pages.CC.debug.DebugPageCC;
import com.acurian.selenium.pages.CC.generalHealth.DoAnyOftheFollowingAdditionalDiagnosesCC;
import com.acurian.selenium.pages.CC.shared.NonQRtransitionPageCC;
import com.acurian.selenium.pages.CC.shared.TransitionStatementCC;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CG_4960_CC extends BaseTest {
    @Description("4960 LG-GDCL002 LG Chem Gout CC")
    @Test(enabled = false)
    public void cg4960CCTest(Site site) {
        EverDiagnosedWithGoutCC everDiagnosedWithGoutCC = new EverDiagnosedWithGoutCC();
        TransitionStatementCC transitionStatementCC = new TransitionStatementCC();
        NonQRtransitionPageCC nonQRtransitionPageCC = new NonQRtransitionPageCC();
        DebugPageCC debugPageCC = new DebugPageCC();
        DoAnyOftheFollowingAdditionalDiagnosesCC doAnyOftheFollowingAdditionalDiagnosesCC = new DoAnyOftheFollowingAdditionalDiagnosesCC();

        //Q2
        HowManyGoutAttacksCC howManyGoutAttacksCC = everDiagnosedWithGoutCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(nonQRtransitionPageCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(everDiagnosedWithGoutCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowManyGoutAttacksCC());

        //Q3
        EverTakenMedicationCC everTakenMedicationCC = new EverTakenMedicationCC();
        howManyGoutAttacksCC
                .waitForPageLoad()
                .clickOnAnswer("No gout attacks in the past year")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(howManyGoutAttacksCC)
                .waitForPageLoad()
                .clickOnAnswer("1")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .waitForPageLoad()
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(howManyGoutAttacksCC)
                .waitForPageLoad()
                .clickOnAnswer("2 or more")
                .clickNextButton(everTakenMedicationCC);

        //Q4
        EverTakenFollowingMedicationsCurrentlyOrPastCC everTakenFollowingMedicationsCurrentlyOrPastCC = everTakenMedicationCC
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC)
                .waitForPageLoad(transitionStatementCC.titleROExpected)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(everTakenMedicationCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new EverTakenFollowingMedicationsCurrentlyOrPastCC());

        //Q5,6,7
        CurrentlyTakingUloricCC currentlyTakingUloricCC = new CurrentlyTakingUloricCC();
        PastThreeMonthsTakenKrystexxaCC pastThreeMonthsTakenKrystexxaCC = everTakenFollowingMedicationsCurrentlyOrPastCC
                .waitForPageLoad()
                .clickOnAnswers("Uloric, also called febuxostat")
                .clickNextButton(currentlyTakingUloricCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(currentlyTakingUloricCC)
                .back(everTakenFollowingMedicationsCurrentlyOrPastCC)
                .waitForPageLoad()
                .clickOnAnswers("Allopurinol, also called Aloprim or Zyloprim")
                .clickNextButton(currentlyTakingUloricCC)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(currentlyTakingUloricCC)
                .back(everTakenFollowingMedicationsCurrentlyOrPastCC)
                .waitForPageLoad()
                .clickOnAnswers("Uloric, also called febuxostat")
                .clickNextButton(currentlyTakingUloricCC)
                .waitForPageLoad()
                .clickOnAnswer("Unsure")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(currentlyTakingUloricCC)
                .back(everTakenFollowingMedicationsCurrentlyOrPastCC)
                .waitForPageLoad()
                .clickOnAnswers("None of the above ")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(everTakenFollowingMedicationsCurrentlyOrPastCC)
                .waitForPageLoad()
                .clickOnAnswers("Allopurinol, also called Aloprim or Zyloprim")
                .clickNextButton(currentlyTakingUloricCC)
                .clickNextButton(new PastThreeMonthsTakenKrystexxaCC());

        //Q8
        pastThreeMonthsTakenKrystexxaCC
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesCC)
                .getPage(debugPageCC)
                .checkProtocolsContainsForQNumber("", site.activeProtocols)
                .back(pastThreeMonthsTakenKrystexxaCC)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(transitionStatementCC);
    }
}
