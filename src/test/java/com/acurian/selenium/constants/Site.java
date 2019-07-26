package com.acurian.selenium.constants;

import java.util.Arrays;

/*
Designed to contain all sites that being used in tests.
 */
public enum Site {

    //
    AUT_RA2821_Site("AUT_RA2821_Site", "19044", "1R", false, true, "M15_925"),
    //4835
    AUT_RA_4835_Site("AUT_RA4835_Site", "19901", "1R", true, false, "M16_063"),
    //3017
    AUT_LOWT_3017S_Site("AUT_LOWT_3017S_Site", "19422", "41C", false, true, "M16_100_S"),
    AUT_LOWT_3017_Site("AUT_LOWT_3017_Site", "19901", "1R", true, true, "M16_100"),
    //3140
    AUT_CV_3140A_site("AUT_CV_3140A_site", "45205", "1R", true, false, "1002_043", "1002_043_A"),
    AUT_CV_3140_site("AUT_CV_3140_site", "19901", "41C", false, false, "1002_043", "1002_043_A"),
    //3237
    AUT_CLH_3237_Site("AUT_CLH_3237_Site", "19044", "1R", false, false, "TV48125_CNS_30056", "TV48125_CNS_30057"),
    //3264
    AUT_IBD_3264_Site("AUT_IBD_3264_Site", "19901", "1R", true, true, "M16_067"), //"M14_234"
    //3839
    AUT_IBD_3839_Site("AUT_IBD_3839_Site", "19901", "1R", false, false, "SHP647_301", "SHP647_302"),
    //3889
    AUT_CRN_3889_HS("AUT_CRN_3889_HS", "19901" , "1R", true, false, "M14_431", "M14_433", "M15_991", "M16_006"),
    //3973
    AUT_ROC_3973_site("AUT_ROC_3973_site", "19901", "1R", true, true, "WN39434"),
    //4109
    AUT_OA_4109_Site("AUT_OA_4109_Site", "60540", "1R", true, false, "R475_OA_1611", "R475_OA_1688"),
    //4241
    AUT_DIA_4241("AUT_DIA_4241", "19901", "41C", false, true, "EFC14822", "EFC14829", "EFC14893"),
    //4301
    AUT_GER_4301_Site("AUT_GER_4301_Site", "19901", "1R", true, true, "C3718_301", "C3718_302"),
    //4357
    AUT_GAST4357S_site("AUT_GAST4357S_site", "19901", "41C", false, true, "RLM_MD_01", "RLM_MD_02"),
    AUT_GAST4357_site("AUT_GAST4357_site", "08204", "1R", false, true, "RLM_MD_01", "RLM_MD_02"),
    //4385
    AUT_END_4385("AUT_END_4385", "19901", "1R", true, true, "MVT_601_3101", "MVT_601_3102"),
    //4442
    LPS_4442("LPS_4442", "08204", "1R", true, false, "I4V_MC_JAHZ", "I4V_MC_JAHZ"),
    //4450
    AUT_CV1_4450S_Syn("AUT_CV1_4450S_Syn", "19901", "41C", false, false, "EX9536_4388"),
    //4471
    AUT_MCC("AUT_MCC", "19341", "1R", false, true, "MK_7264_030"),
    //4533
    AUT_SHIRE_4533_site("AUT_SHIRE_4533_site", "19901", "1R", false, false, "SHP647_305", "SHP647_306"),
    //4556
    AUT_VAC_4556M("AUT_VAC_4556M", "19901", "1R", true, true, "B7471006"),//"B7471007"
    AUT_VAC_4556_A("AUT_VAC_4556_A", "19901", "1R", true, true, "B7471007_A"),
//    AUT_VAC_4556_Site("AUT_VAC_4556_Site", "60061", "1R", true, false, "B7471008"),//"B7471007"
    //4600
    AUT_AMS1_4600_site("AUT_AMS1_4600_site", "08204", "1R", true, false, "B7451014"),
    //7036
    AUT_AMS1_7036_Site("AUT_AMS1_7036_Site", "08204", "1R", true, false, "4083_006"),
    //4605
    AUT_OBS_4605_Site("AUT_OBS_4605_Site", "19901", "1R", true, false, "RM_493_013"),
    //4631
    AUT_DERM_4631_Site("AUT_DERM_4631_Site", "19901", "1R", true, false,  "KPL_716_C001"),
    //4656
    AUT_PSO4656("AUT_PSO4656", "19901", "1R", true, false, "CC_10004_PSOR_022"),
    //4691
    AUT_AKC4691_MR("AUT_AKC4691_MR", "08204", "1R", true, false, "ISIS 703802_CS2"),
    //4708
    AUT_NASH4708_site("AUT_NASH4708_site", "19901", "41C", false, false, "EDP 305_101"),
    //4722
    AUT_HFL_4722_Site("AUT_HFL_4722_Site", "19044", "1R", true, false, "C1973_204"),
    //4742
    AUT_MIG4742_site("AUT_MIG4742_site", "08204", "1R", false, false, "3101_301_002", "3101_302_002"),
    //4814
    AUT_AD4814_site("AUT_AD4814_site", "19901", "1R", true, false, "INCB 18424_303", "INCB 18424_304"),
    AUT_AD4814S_site("AUT_AD4814S_site", "45205", "41C", false, false, "INCB 18424_303", "INCB 18424_304"),
    //4815
    AUT_DERM_4815_Site("AUT_DERM_4815_Site", "19901", "1R", true, false, "B7451029"),
    AUT_DERM_4815S_Site("AUT_DERM_4815S_Site", "45205", "41C", false, false, "B7451029"),
    //4819
    AUT_IBS4819_site("AUT_IBS4819_site", "19901", "1R", false, false, "URO_901_2001"),
    //4831
    AUT_OA_4831_Syn("AUT_OA_4831_Syn", "19422", "41C", false, false, "R475_PN_1523_B"),
    AUT_OA_4831_site("AUT_OA_4831_site", "19901", "1R", true, false, "R475_PN_1523_B"),
    //4825
    AUT_AMS1_4825_site("AUT_AMS1_4825_site", "08204", "1R", true, false, "GS40965"),
    //4849
    AUT_DERM_4849_Site("AUT_DERM_4849_Site", "19901", "1R", true, false, "ANB020_005"),
    //4867
    AUT_OAB_4867("AUT_OAB4867_site", "08204", "41C", false, false, "URO_901_1001"),
    //4967
    AUT_AMS1_4967_site("AUT_AMS1_4967_site", "08204", "1R", false, false, "R3500_AD_1798", "R3500_AD_1805"),
    //5017
    //AUT_INS_5017S_site("AUT_INS_5017S_site", "19901", "41C", false, false, "ID_078A301", "ID_078A302"), //Not required in spec
    AUT_INS_5017_site("AUT_INS_5017_site", "08204", "1R", true, false, "ID_078A301", "ID_078A302"),
    //5019
    AUT_AMS1_5019_site("AUT_AMS1_5019_site", "19422", "1R", false, false, "BOS_589_201"),
    AUT_AMS1_5019S_site("AUT_AMS1_5019S_site", "08204", "41C", false, false, "BOS_589_201"),
    //5034
    AUT_CV_5034A_site("AUT_CV_5034A_site", "45205", "1R", true, false, "K_877_302_A"),
    AUT_CV_5034S_site("AUT_CV_5034S_site", "19901", "41C", false, false, "K_877_302_S"),
    //5044
    AUT_OA_5044_S("AUT_OA_5044_S", "19901", "41C", true, false, "R475_OA_1758"),
    //5055
    AUT_OA_5055_S("AUT_OA_5055_S", "19901", "41C", false, false, "R475_PN_1602"),
    //5062
    AUT_NASH5062_site("AUT_NASH5062_site", "19901", "41C", false, false, "3152_301_002"),
    //4483
    AUT_NASH4483_site("AUT_AMS1_4483_site", "19901", "1R", false, false, "MGL_3196_11"),
    AUT_NASH4483S_site("AUT_AMS1_4483S_site", "19422", "41C", false, false, "MGL_3196_11"),
    //Others
    AUT_GFLR1_site("AUT_GFLR1_site", "92586", "", false, false), //FlareActivationCode.java
    //Health check
    AUT_GRA1_Site("AUT_GRA1_Site", "19901", "1R", false, false),
    AUT_GRA_FUL_Site("AUT_GRA_FUL_Site", "60415", "1R", true, false),
    AUT_GRA_FULm_Site("AUT_GRA_FULm_Site", "60061", "1R", true, true),
    //Dispo sites
    AUT_GMEGA_New("AUT_GMEGA_New", "08204", "1R", true, false),
    AUT_GRA_43C_Site("AUT_GRA_43C_Site", "73159", "43C", true, false);



    public final String name;
    public final String zipCode;
    public final String dispo;
    public final boolean hasFul;
    public final boolean withMedicalRecords;
    public String[] activeProtocols;

    Site(String name, String zipCode, String dispo, boolean hasFul, boolean withMedicalRecords, String... activeProtocols) {
        this.name = name;
        this.zipCode = zipCode;
        this.dispo = dispo;
        this.hasFul = hasFul;
        this.withMedicalRecords = withMedicalRecords;
        this.activeProtocols = activeProtocols;
    }

    @Override
    public String toString() {
        return "[" + name + ", " +
                zipCode + ", " +
                dispo + ", " +
                hasFul + ", " +
                withMedicalRecords + ", " +
                Arrays.toString(activeProtocols) + "]";
    }
}
