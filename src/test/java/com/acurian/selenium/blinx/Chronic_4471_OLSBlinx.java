package com.acurian.selenium.blinx;

import com.acurian.selenium.constants.Site;
import com.acurian.selenium.pages.BaseTest;
import com.acurian.selenium.pages.blinx.ams.chronic_cough.*;
import com.acurian.selenium.pages.blinx.ams.closes.*;
import com.acurian.selenium.pages.blinx.ams.debug.DebugPageOLS;
import com.acurian.selenium.pages.blinx.ams.generalHealth.*;
import com.acurian.selenium.pages.blinx.ams.shared.DateOfBirthPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.GenderPageOLS;
import com.acurian.selenium.pages.blinx.ams.shared.ZipCodePageOLS;
import com.acurian.selenium.pages.blinx.gmega.intro.IdentificationPageOLS;
import com.acurian.utils.Properties;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Chronic_4471_OLSBlinx extends BaseTest {

    @Test()
    @Description("4471 Chronic Cough")
    public void chronicCough4471ols() {
        Site site = Site.AUT_MCC;
        String phoneNumberMIG = "AUTAMS1MCC";
        String studyName = "a chronic cough";
        String env = System.getProperty("acurian.env", "STG");
        String eMailId = "qa.acurian@gmail.com";

        DebugPageOLS debugPageOLS = new DebugPageOLS();
        DateOfBirthPageOLS dateOfBirthPageOLS = new DateOfBirthPageOLS();
        dateOfBirthPageOLS
                .openPage(env, phoneNumberMIG)
                .waitForPageLoad("a chronic cough study", "350");
        //Assert.assertEquals(dateOfBirthPageOLS.getTitleText(), dateOfBirthPageOLS.getExpectedModifiedTitle("a chronic cough study", "350"), "Title is diff");
        LessThan18YearsOldPageOLS lessThan18YearsOldPage_OLS = dateOfBirthPageOLS
                .clickOnAnswer("No")
                .getPage(new LessThan18YearsOldPageOLS());
        lessThan18YearsOldPage_OLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QSI8004", site.activeProtocols)
                .back(dateOfBirthPageOLS);

        ZipCodePageOLS zipCodePageOLS = dateOfBirthPageOLS
                .waitForPageLoad("a chronic cough study", "350")
                .clickOnAnswer("Yes")
                .getPage(new ZipCodePageOLS());

        GenderPageOLS genderPageOLS = zipCodePageOLS
                .waitForPageLoad()
                .setZipCode("19341")
                .clickNextButton(new GenderPageOLS());

        CurrentlySufferFromChronicCoughOLS currentlySufferFromChronicCoughOLS = genderPageOLS
                .waitForPageLoad()
                .setDate("10101980")
                .clickOnAnswer("Female")
                .clickNextButton(new CurrentlySufferFromChronicCoughOLS());

        HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS = currentlySufferFromChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6202", site.activeProtocols);
        debugPageOLS.back(currentlySufferFromChronicCoughOLS);

        HowLongYouHadChronicCoughOLS howLongYouHadChronicCoughOLS = currentlySufferFromChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HowLongYouHadChronicCoughOLS());

        TreatingYourChronicCoughOLS treatingYourChronicCoughOLS = howLongYouHadChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswer("Less than 6 months")
                .clickNextButton(new TreatingYourChronicCoughOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6203", site.activeProtocols);
        debugPageOLS.back(howLongYouHadChronicCoughOLS);

        howLongYouHadChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswer("1 year or longer")
                .clickNextButton(new TreatingYourChronicCoughOLS());

        HaveYouSmokedCigarettesOLS haveYouSmokedCigarettesOLS = treatingYourChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswers("No, have not treated")
                .clickNextButton(new HaveYouSmokedCigarettesOLS())
                .waitForPageLoadNew();
        haveYouSmokedCigarettesOLS.back(treatingYourChronicCoughOLS);

        DoYouStillHaveCoughOLS doYouStillHaveCoughOLS = treatingYourChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswers("Yes, with prescription", "Yes, with over the counter")
                .clickNextButton(new DoYouStillHaveCoughOLS());

        doYouStillHaveCoughOLS
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new HaveYouSmokedCigarettesOLS());

        EverDiagnosedWithFollowingConditionsOLS everDiagnosedWithFollowingConditionsOLS = haveYouSmokedCigarettesOLS
                .waitForPageLoadNew()
                .clickOnAnswers("No, I never smoked")
                .clickNextButton(new EverDiagnosedWithFollowingConditionsOLS());

        everDiagnosedWithFollowingConditionsOLS
                .waitForPageLoad()
                .back(haveYouSmokedCigarettesOLS);

        HowManyCigarettesOLS howManyCigarettesOLS = haveYouSmokedCigarettesOLS
                .waitForPageLoadNew()
                .clickOnAnswers("Yes, I currently smoke")
                .clickNextButton(new HowManyCigarettesOLS());
        howManyCigarettesOLS
                .waitForPageLoad()
                .getPage(debugPageOLS)
                .checkProtocolsContainsForQNumber("QS6206", site.activeProtocols)
                .back(haveYouSmokedCigarettesOLS);

        QuitSmokingOLS quitSmokingOLS = haveYouSmokedCigarettesOLS
                .waitForPageLoadNew()
                .clickOnAnswers("I used to smoke, but have since quit")
                .clickNextButton(new QuitSmokingOLS());

        quitSmokingOLS
                .waitForPageLoad()
                .clickOnAnswer("I quit smoking within the past year")
                .clickNextButton(new HowManyCigarettesOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6207", site.activeProtocols);
        debugPageOLS.back(quitSmokingOLS);
        quitSmokingOLS
                .waitForPageLoad()
                .clickOnAnswer("I quit smoking more than a year ago")
                .clickNextButton(new HowManyCigarettesOLS());

        howManyCigarettesOLS
                .waitForPageLoad()
                .enterYears("15")
                .howManyCigarettes("21")
                .clickNextButton(new EverDiagnosedWithFollowingConditionsOLS());

            ACEInhibitorsOLS aCEInhibitorsOLS = everDiagnosedWithFollowingConditionsOLS
                    .waitForPageLoad()
                    .clickOnAnswers("Post-Nasal Drip (Upper Airway Cough Syndrome)", "Lung Cancer", "Tuberculosis (TB)")
                    .clickNextButton(new ACEInhibitorsOLS())
                    .waitForPageLoad();
        aCEInhibitorsOLS.back(everDiagnosedWithFollowingConditionsOLS);
        everDiagnosedWithFollowingConditionsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ACEInhibitorsOLS());

        ExperienceWithYourChronicCoughOLS experienceWithYourChronicCoughOLS = aCEInhibitorsOLS
                .waitForPageLoad()
                .clickOnAnswers("Benazepril (Brand name: Lotensin)", "Captopril (Brand name: Capoten)", "Cilazapril (Brand name: Inhibace)", "Enalapril (Brand names: Vasotec, Renitec, Berlipril, Enap, Enapren)")
                .clickOnAnswers("Fosinopril (Brand names: Fositen, Monopril)", "Imidapril (Brand name: Tanatril)", "Lisinopril (Brand names: Listril, Lopril, Novatec, Prinivil, Zestril, Lisidigal)")
                .clickOnAnswers("Perindopril (Brand names: Coversyl, Coversum, Aceon)", "Quinapril (Brand name: Accupril)", "Ramipril (Brand names: Altace, Prilace, Ramace, Ramiwin, Triatec, Tritace)")
                .clickOnAnswers("Trandolapril (Brand names: Mavik, Odrik, Gopten)")
                .clickOnAnswers("Zofenopril (Brand names: Zofenil, Bifril, Zopranol)")
                .clickNextButton(new ExperienceWithYourChronicCoughOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS6211", site.activeProtocols);
        debugPageOLS.back(aCEInhibitorsOLS);
        aCEInhibitorsOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ExperienceWithYourChronicCoughOLS());

        SymptomsGetBetterOLS symptomsGetBetterOLS = experienceWithYourChronicCoughOLS
                .waitForPageLoad()
                .clickOnAnswers("A runny or stuffy nose", "Frequent throat clearing and sore throat", "Hoarseness", "Coughing up blood", "Heartburn or a sour taste in your mouth")
                .clickNextButton(new SymptomsGetBetterOLS());

        symptomsGetBetterOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS());

        WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS = haveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney disease")
                .clickNextButton(new WhichOfTheFollowingHaveRequiredForKidneyDiseaseOLS());

        DoAnyOftheFollowingAdditionalDiagnosesOLS doAnyOftheFollowingAdditionalDiagnosesOLS = whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS51", site.activeProtocols);
        debugPageOLS.back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Kidney transplant")
                .clickOnAnswers("Dialysis")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS())
                .waitForPageLoad();
        debugPageOLS.checkProtocolsContainsForQNumber("QS51", site.activeProtocols);
        debugPageOLS.back(whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS);
        whichOfTheFollowingHaveRequiredForKidneyDiseaseOLS
                .waitForPageLoad()
                .clickOnAnswers("Neither")
                .clickNextButton(new DoAnyOftheFollowingAdditionalDiagnosesOLS());

        ApproximateHeightPageOLS approximateHeightPageOLS = doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
//        debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
        debugPageOLS.back(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickOnAnswers("Cirrhosis")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
//        debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
        debugPageOLS.back(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis B")
                .clickOnAnswers("Drug or alcohol abuse within the past year")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
//        debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
        debugPageOLS.back(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Hepatitis C")
                .clickOnAnswers("Hepatitis B")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
//        debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
        debugPageOLS.back(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("HIV or AIDS")
                .clickOnAnswers("Hepatitis C")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
//        debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
        debugPageOLS.back(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Schizophrenia")
                .clickOnAnswers("HIV or AIDS")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
//        debugPageOLS.checkProtocolsContainsForQNumber("QS61", protocol1);
        debugPageOLS.back(doAnyOftheFollowingAdditionalDiagnosesOLS);
        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("Cancer in the past 5 years, except skin cancer")
                .clickOnAnswers("Schizophrenia")
                .clickNextButton(new ApproximateHeightPageOLS())
                .waitForPageLoad();
//        debugPageOLS.checkProtocolsContainsForQNumber("QS59", protocol1);
        debugPageOLS.back(doAnyOftheFollowingAdditionalDiagnosesOLS);

        doAnyOftheFollowingAdditionalDiagnosesOLS
                .waitForPageLoad()
                .clickOnAnswers("None of the above")
                .clickNextButton(new ApproximateHeightPageOLS());

        IdentificationPageOLS identificationPageOLS = approximateHeightPageOLS
                .waitForPageLoad()
                .setAll("5", "7", "166")
//                .clickNextButton(new EthnicBackgroundPageOLS());
//        ethnicBackgroundPageOLS
//                .waitForPageLoad()
//                .clickOnAnswers("Prefer not to answer")
                .clickNextButton(new CurrentlyParticipatingInStudyOLS())
                .waitForPageLoad()
                .clickOnAnswer("No")
                .clickNextButton(new RequirePassDrugTestOLS())
                .waitForPageLoad()
                .clickOnAnswer("Yes")
                .clickNextButton(new IdentificationPageOLS());
        HS1PageOLS hs1PageOLS = identificationPageOLS
                .waitForPageLoad2()
                .setAllFields("Acurian", "Trial", "qa.acurian@gmail.com", "9999999999")
                .setCity("Exton")
                .clickNextButton(new SiteSelectionPageOLS())
                .waitForPageLoad(studyName + " study!")
                .getPID()
                .clickOnFacilityName(site.name)
                .clickNextButton(new MedicalRecordsOptionPageOLS())
                .waitForPageLoad()
                .clickOnAnswer("Continue with medical records")
                .clickNextButton(new DoctorInformationCollectionPageOLS())
                .waitForPageLoad1()
                .clickNextButton(new HS1PageOLS());
        hs1PageOLS
                .waitForPageLoad()
                .clickOkInPopUp()
                .setSignature();
        ThankYouCloseSimplePageOLS thankYouCloseSimplePageOLS = new ThankYouCloseSimplePageOLS();

/*                //------------HUMAN API Interface in HelloSign----------------
                .getPage(new HumanAPIOLS())
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
                .clickNextButton(new ThankYouCloseSimplePageOLS())*/

        AboutHealthPageOLS aboutHealthPageOLS = thankYouCloseSimplePageOLS
                .waitForPageLoad()
                .clickNextButton(new AboutHealthPageOLS());
        aboutHealthPageOLS
                .waitForPageLoad();
        if(aboutHealthPageOLS.getHostName().equals(Properties.getHostName())) {
            aboutHealthPageOLS
                    .pidFromDbToLog(env)
                    .childPidFromDbToLog(env)
                    .assertGeneratedFul(env, site)
                    .dispoShouldMatch(site.dispo, site.dispo);
        }

}
}
