package com.acurian.selenium.tests.OLS;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.OLS.Vaccine.AreYouInterestedInPneumoniaVaccineStudyOLS;
import com.acurian.selenium.pages.OLS.Vaccine.CalledPrevnarPageOLS;
import com.acurian.selenium.pages.OLS.Vaccine.DiagnosedWithAnyOfTheFollowingTypesOfCancerOLS;
import com.acurian.selenium.pages.OLS.closes.*;
import com.acurian.selenium.pages.OLS.debug.DebugPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.*;
import com.acurian.selenium.pages.OLS.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.OLS.shared.GenderPageOLS;
import com.acurian.selenium.pages.OLS.shared.ZipCodePageOLS;
import com.acurian.selenium.tests.CC.VACC_4556_CC;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.ArrayList;

public class VACC_4556_OLS extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    @Test(dataProviderClass = VACC_4556_CC.class, dataProvider = "sites", enabled = false)
    @Description("VACC_4556_OLS")
    public void vacc4556OlsTest(Site site) {
        final String phoneNumber = "AUTAMS1VAC";
        final String[] protocols = site.activeProtocols;
        final String studyName = "a pneumonia vaccine";
        DebugPageOLS debugPageOLS = new DebugPageOLS();
        String env = System.getProperty("acurian.env", "STG");

        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();

        dateOfBirthPageOLS
                .openPage(env, phoneNumber)
                .waitForPageLoad();
        Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("a pneumonia vaccine study", "170"), "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPageOLS = dateOfBirthPageOLS
                .setDate("05052005")
                .clickNextButton(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", protocols)
                .back();
        ZipCodePageOLS zipCodePageOLS = new ZipCodePageOLS();
        switch (site) {
            case AUT_VAC_4556M:
                dateOfBirthPageOLS
                        .waitForPageLoad()
                        .setDate("05011959")//65
                        .clickNextButton(zipCodePageOLS)
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QSI8004", protocols)
                        .back(dateOfBirthPageOLS)
                        .waitForPageLoad()
                        .setDate("05011954")//65
                        .clickNextButton(zipCodePageOLS);
                break;
//            case AUT_VAC_4556_Site:
//                dateOfBirthPageOLS
//                        .waitForPageLoad()
//                        .setDate("05051968")//50
//                        .clickNextButton(zipCodePageOLS)
//                        .waitForPageLoad()
//                        .getPage(debugPageOLS)
//                        .checkProtocolsContainsForQNumber("QSI8004", protocols)
//                        .back(dateOfBirthPageOLS)
//                        .waitForPageLoad()
//                        .setDate("05051969")//49
//                        .clickNextButton(zipCodePageOLS);
//                break;
            case AUT_VAC_4556_A:
                dateOfBirthPageOLS
                        .waitForPageLoad()
                        .setDate("05011940")//<80
                        .clickNextButton(zipCodePageOLS)
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QSI8004", protocols)
                        .back(dateOfBirthPageOLS)
                        .waitForPageLoad()
                        .setDate("05011939")//>=80
                        .clickNextButton(zipCodePageOLS);
        }

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .typeZipCode(site.zipCode)
                .clickNextButton(new GenderPageOLS());

        AreYouInterestedInPneumoniaVaccineStudyOLS areYouInterestedInPneumoniaVaccineStudyOLS = genderPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Female")
                .clickNextButton(new AreYouInterestedInPneumoniaVaccineStudyOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = areYouInterestedInPneumoniaVaccineStudyOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());
        haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6902", protocols)
                .back();
        CalledPrevnarPageOLS calledPrevnarPageOLS = areYouInterestedInPneumoniaVaccineStudyOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new CalledPrevnarPageOLS());

        DiagnosedWithAnyOfTheFollowingTypesOfCancerOLS diagnosedWithAnyOfTheFollowingTypesOfCancerOLS = new DiagnosedWithAnyOfTheFollowingTypesOfCancerOLS();
        switch (site) {
            case AUT_VAC_4556M:
                calledPrevnarPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No")
                        .clickNextButton(diagnosedWithAnyOfTheFollowingTypesOfCancerOLS)
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QS6907", protocols[0])
                        .back();
                break;
//            case AUT_VAC_4556_Site:
//                diagnosedWithAnyOfTheFollowingTypesOfCancerOLS
//                        .waitForPageLoad()
//                        .getPage(debugPageOLS)
//                        .checkProtocolsContainsForQNumber("QS6907", protocols)
//                        .back();
//                break;
            case AUT_VAC_4556_A:
                calledPrevnarPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("Yes")
                        .clickNextButton(diagnosedWithAnyOfTheFollowingTypesOfCancerOLS)
                        .waitForPageLoad()
                        .getPage(debugPageOLS)
                        .checkProtocolsContainsForQNumber("QS6907", protocols[0])
                        .back();
        }
        calledPrevnarPageOLS
                .waitForPageLoad()
                .clickOnAnswer("I am unsure")
                .clickNextButton(diagnosedWithAnyOfTheFollowingTypesOfCancerOLS);

        diagnosedWithAnyOfTheFollowingTypesOfCancerOLS
                .waitForPageLoad()
                .clickOnAnswer("Leukemia")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6903", protocols)
                .back(diagnosedWithAnyOfTheFollowingTypesOfCancerOLS)
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickOnAnswer("Lymphoma")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6903", protocols)
                .back(diagnosedWithAnyOfTheFollowingTypesOfCancerOLS)
                .waitForPageLoad()
                .clickOnAnswer("None of the above")
                .clickNextButton(haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS);

        OtherThanSkinCancerPageOLS otherThanSkinCancerPageOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer", "Kidney disease", "Liver disease (fatty liver disease, NASH, NAFLD, cirrhosis)",
                        "Mental or emotional health conditions (anxiety, bipolar disorder, depression, schizophrenia)"
                )
                .clickNextButton(new OtherThanSkinCancerPageOLS());

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = otherThanSkinCancerPageOLS
                .waitForPageLoad()
                .clickOnAnswer("Within the past 5 years")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS42", protocols)
                .back(otherThanSkinCancerPageOLS)
                .waitForPageLoad()
                .clickOnAnswer("Diagnosed with skin cancer only")
                .clickNextButton(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS)
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS());

        whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", protocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickOnAnswers("Kidney transplant")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS51", protocols)
                .back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS)
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS);

        FollowingMentalEmotionalHealthPageOLS followingMentalEmotionalHealthPageOLS = whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new FollowingMentalEmotionalHealthPageOLS());

        followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS52", protocols)
                .back(whichOfFollowingHaveYouDiagnosedWith_liverDiseaseOLS)
                .waitForPageLoad()
                .clickOnAnswers("Unsure which type of liver disease")
                .clickNextButton(followingMentalEmotionalHealthPageOLS);

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = followingMentalEmotionalHealthPageOLS
                .waitForPageLoad()
                .clickOnAnswers("Bipolar disorder")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", protocols)
                .back(followingMentalEmotionalHealthPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS)
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS53", protocols)
                .back(followingMentalEmotionalHealthPageOLS)
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(doAnyOftheFollowingAdditionalDiagnosesOLS);

        ArrayList<String> additionalDiagnoses = new ArrayList<>();
        ApproximateHeightPageOLS approximateHeightPageOLS = new ApproximateHeightPageOLS();
        additionalDiagnoses.add("Drug or alcohol abuse within the past year");
        additionalDiagnoses.add("Hepatitis B");
        additionalDiagnoses.add("Hepatitis C");
        additionalDiagnoses.add("HIV or AIDS");
        for (String diagnose : additionalDiagnoses) {
            doAnyOftheFollowingAdditionalDiagnosesOLS
                    .waitForPageLoad()
                    .clickOnAnswers("None of the above")
                    .clickOnAnswers(diagnose)
                    .clickNextButton(approximateHeightPageOLS)
                    .waitForPageLoad()
                    .getPage(debugPageOLS)
                    .checkProtocolsContainsForQNumber("QS59", protocols)
                    .back();
        }
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(approximateHeightPageOLS);


        //EthnicBackgroundPageOLS ethnicBackgroundPageOLS = approximateHeightPageOLS
        approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "5", "250");
        //.clickNextButton(new EthnicBackgroundPageOLS());

        SiteSelectionPageOLS siteSelectionPageOLS = approximateHeightPageOLS
                /*  .waitForPageLoad()
                  .clickOnAnswers("Prefer not to answer")*/
                .clickNextButton(new IdentificationPageOLS())
                .waitForPageLoad()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999", site.zipCode)
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName)
                .getPID();
        switch (site) {
            case AUT_VAC_4556M:
            case AUT_VAC_4556_A:
                siteSelectionPageOLS
                        .clickOnFacilityName(site.name)
//                        .clickNextButton(new HSGeneralPageOLS())
//                        .waitForPageLoadByTitle(new HSGeneralPageOLS().titleExpected4556)
                        .clickNextButton(new DoctorInformationCollectionPageOLS())
                        .waitForPageLoad()
                        .clickNextButton(new HS1PageOLS())
                        .waitForPageLoad()
                        .clickOkInPopUp()
                        .setSignature();

/*                        .getPage(new HumanAPIOLS())
                        .waitForPageLoad()
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
                        .clickNextButton(new SynexusHealthyMindsPageOLS())*/

                SynexusHealthyMindsPageOLS synexusHealthyMindsPageOLS = new SynexusHealthyMindsPageOLS();
                synexusHealthyMindsPageOLS
                        .waitForPageLoad()
                        .clickOnAnswer("No, I am not interested in receiving information")
                        .clickNextButton(new ThankYouCloseSimplePageOLS())
                        .waitForSENRPageLoad()
                        .clickNextButton(new AboutHealthPageOLS())
                        .waitForPageLoad()
                        .pidFromDbToLog(env)
                        .childPidFromDbToLog(env)
                        .dispoShouldMatch(site.dispo, site.dispo)
                        .assertGeneratedFul(env, site)
                        .queueSiteForFULCheck(site.name);
                break;
//            case AUT_VAC_4556_Site:
//                siteSelectionPageOLS
//                        .clickOnFacilityName(site.name)
//                        .clickNextButton(new QualifiedClose2PageOLS())
//                        .waitForPageLoad()
//                        .clickNextButton(new ThankYouCloseSimplePageOLS())
//                        .waitForSENRPageLoad()
//                        .clickNextButton(new AboutHealthPageOLS())
//                        .waitForPageLoad()
//                        .pidFromDbToLog(env)
//                        .childPidFromDbToLog(env)
//                        .dispoShouldMatch(site.dispo, site.dispo)
//                        .queueSiteForFULCheck(site.name);
        }
    }
}
