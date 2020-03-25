package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.WhatKindOfDiabetesPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.ZipCodePageOLS;
import com.acurian.selenium.pages.blinx.ams.vaccine.*;
import com.acurian.selenium.pages.blinx.gmega.WhatKindOfArthritisDoYouHavePageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class VACC_S10159_OLSBlinx extends BaseTest {


    @DataProvider
    public Object[][] sites() {
        return new Object[][]{
                {Site.AUT_S10159}
        };
    }

    @Test(dataProvider = "sites", enabled = true)
    @Description("VACC_S10159_BLINX FBP00004 (Sanofi Flu Vaccine)")
    public void vaccS10159BlinxTest(Site site) {
        final String phoneNumber = "AUTAMS1GSK";
        final String studyName = "a flu vaccine study";
        String env = System.getProperty("acurian.env", "STG");

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS =
                new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS();
        GenderPageOLS genderPageOLS = dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoadGMEGA(studyName, "1,100")
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS())
                .waitForPageLoad()
                .setZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());
        genderPageOLS
                .waitForPageLoad()
                .setDate("05051985")
                .clickOnAnswer("Female")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        AreYouInterestedInVaccineStudyOLS areYouInterestedInVaccineStudyOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8013", site.activeProtocols)
                .back(genderPageOLS)
                .waitForPageLoad()
                .setDate("05051965")
                .clickNextButton(new AreYouInterestedInVaccineStudyOLS());

        areYouInterestedInVaccineStudyOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6912", site.activeProtocols)
                .back(areYouInterestedInVaccineStudyOLS);

        AreYouGenerallyInGoodHealthOLS areYouGenerallyInGoodHealthOLS = areYouInterestedInVaccineStudyOLS
                .waitForPageLoad()
                .clickOnAnswers("Flu, or influenza, vaccine")
                .clickNextButton(new AreYouGenerallyInGoodHealthOLS());

        VaccineInThePast2YearsOLS vaccineInThePast2YearsOLS = areYouGenerallyInGoodHealthOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6913", site.activeProtocols)
                .back(areYouGenerallyInGoodHealthOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new VaccineInThePast2YearsOLS());

        AllergicToAnyVaccinesOLS allergicToAnyVaccinesOLS = vaccineInThePast2YearsOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new AllergicToAnyVaccinesOLS());

        CurrentlyPregnantBreastfeedingOLS currentlyPregnantBreastfeedingOLS = allergicToAnyVaccinesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6914", site.activeProtocols)
                .back(vaccineInThePast2YearsOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(allergicToAnyVaccinesOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new CurrentlyPregnantBreastfeedingOLS());

        currentlyPregnantBreastfeedingOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6910", site.activeProtocols)
                .back(allergicToAnyVaccinesOLS);

        allergicToAnyVaccinesOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(currentlyPregnantBreastfeedingOLS)
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6916", site.activeProtocols)
                .back(currentlyPregnantBreastfeedingOLS)
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        //-----------GENERAL HEALTH---------------//
        DoAnyOftheFollowingAdditionalDiagnosesOLS
                doAnyOftheFollowingAdditionalDiagnosesOLS = new DoAnyOftheFollowingAdditionalDiagnosesOLS();

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS kidneyProblemsPage = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", site.activeProtocols)
                .back(kidneyProblemsPage);
        kidneyProblemsPage
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhatKindOfDiabetesPageOLS whatKindOfDiabetesPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Diabetes (type 1 or type 2)")
                .clickNextButton(new WhatKindOfDiabetesPageOLS());

        whatKindOfDiabetesPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Type 1 diabetes (sometimes called Juvenile diabetes)")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS43", site.activeProtocols)
                .back(whatKindOfDiabetesPageOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhatKindOfArthritisDoYouHavePageOLS whatKindOfArthritisDoYouHavePageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Arthritis (osteoarthritis, rheumatoid arthritis or RA, psoriatic arthritis)")
                .clickNextButton(new WhatKindOfArthritisDoYouHavePageOLS());

        whatKindOfArthritisDoYouHavePageOLS
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back(whatKindOfArthritisDoYouHavePageOLS)
                .waitForPageLoad()
                .clickOnAnswers("Rheumatoid arthritis, a serious medical condition caused by your immune system attacking your joints")
                .clickOnAnswers("Psoriatic Arthritis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS39", site.activeProtocols)
                .back(whatKindOfArthritisDoYouHavePageOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhichOfTheFollowingSkinConditionsDoYouSufferOLS whichOfTheFollowingSkinConditionsDoYouSufferOLS =
                haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Skin problems (eczema or atopic dermatitis, psoriasis)")
                .clickNextButton(new WhichOfTheFollowingSkinConditionsDoYouSufferOLS());

        whichOfTheFollowingSkinConditionsDoYouSufferOLS
                .waitForPageLoad()
                .clickOnAnswers("Psoriasis")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS55", site.activeProtocols)
                .back(whichOfTheFollowingSkinConditionsDoYouSufferOLS)
                .waitForPageLoad()
                .back(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        WhenDiagnosedWithCancerOLS whenDiagnosedWithCancerOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cancer")
                .clickNextButton(new WhenDiagnosedWithCancerOLS());

        whenDiagnosedWithCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", site.activeProtocols)
                .back(whenDiagnosedWithCancerOLS)
                .waitForPageLoad()
                .clickOnAnswer("6 - 10 years ago")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS());
        approximateHeightPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(approximateHeightPageOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS59", site.activeProtocols)
                .back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickOnAnswers("Seizure disorder such as epilepsy")
                .clickNextButton(approximateHeightPageOLS);

        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "500")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS68", site.activeProtocols)
                .back(approximateHeightPageOLS)
                .waitForPageLoad()
                .setAll("5", "5", "150")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());

        SiteSelectionPageOLS siteSelectionPageOLS = new SiteSelectionPageOLS();

        (env.equals("STG") ? identificationPageOLS.waitForPageLoadSTG() : identificationPageOLS.waitForPageLoad2())
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS());

        QualifiedClose2PageOLS qualifiedClose2PageOLS = siteSelectionPageOLS
                .waitForPageLoad5(studyName + "!")
                .clickOnFacilityName(site.name)
                .clickNextButton(new QualifiedClose2PageOLS());
        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = qualifiedClose2PageOLS
                .waitForPageLoad3()
                .clickNextButton(new ThankYouCloseSimplePageOLS());
        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());

        if(aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .waitForPageLoad()
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }
    }
}
