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
    //4950 R86 OUS
    AUT_4950("AUT_4950", "19901", "1R", false, false, "201790", "201791", "202018"),
    //3017
    AUT_LOWT_3017S_Site("AUT_LOWT_3017S_Site", "19422", "41C", false, true, "M16_100_S"),
    AUT_LOWT_3017_Site("AUT_LOWT_3017_Site", "19044", "1R", true, true, "M16_100"),
    //5042
    AUT_COPD_5042S_Site("AUT_AMS1_5042S_site", "08204", "41C", false, true, "208657"),
    AUT_COPD_5042_Site("AUT_AMS1_5042_site", "19422", "1R", true, true, "208657"),
    //3140
    AUT_CV_3140A_site("AUT_CV_3140A_site", "45205", "1R", true, false, "1002_043", "1002_043_A"),
    AUT_CV_3140_site("AUT_CV_3140_site", "19901", "41C", false, false, "1002_043", "1002_043_A"),
    //3237
    AUT_CLH_3237_Site("AUT_CLH_3237_Site", "19044", "1R", false, false, "TV48125_CNS_30056", "TV48125_CNS_30057"),
    //3264
    AUT_IBD_3264_Site("AUT_IBD_3264_Site", "19901", "1R", true, true, "M16_067"), //"M14_234"
    //3839
    AUT_IBD_3839_Site("AUT_IBD_3839_Site", "19901", "1R", false, false, "SHP647_301", "SHP647_302"),
    //4818
    AUT_AMS1_4818UC_Site("AUT_AMS1_4818_Site", "19422", "1R", true, false, "3151_201_008"),
    AUT_AMS1_4818UCS_Site("AUT_AMS1_4818S_site", "08204", "41C", true, false, "3151_201_008"),
    AUT_AMS1_4818A_Site("AUT_4818A", "19422", "1R", true, false, "3150_301_008_A"),
    AUT_AMS1_4818AS_Site("AUT_4818AS", "19044", "41C", true, false, "3150_301_008_A"),
    //7193
    AUT_AMS1_7193_Site("AUT_AMS1_7193_site", "08204", "1R", true, false, "ARQ_151_212"),
    //3889
    AUT_CRN_3889_HS("AUT_CRN_3889_HS", "19901", "1R", true, false, "M14_431", "M14_433", "M15_991", "M16_006"),
    //3973
    AUT_ROC_3973_site("AUT_ROC_3973_site", "19901", "1R", true, true, "WN39434"),
    //4109
    AUT_OA_4109_Site("AUT_OA_4109_Site", "60540", "1R", true, false, "R475_OA_1611", "R475_OA_1688"),
    //4241
    AUT_DIA_4241("AUT_DIA_4241", "19901", "41C", false, true, "EFC14829", "EFC14893", "EFC15337"),

    AUT_CV1_4241_site("AUT_CV1_4241_site", "19901", "41C", false, false, "EFC14828"),
    AUT_CV1_4241_NonSynexus_site("AUT_CV1_4241_NonSynexus_site", "45205", "1R", true, false, "EFC14828"),
    //4301
    AUT_GER_4301_Site("AUT_GER_4301_Site", "19901", "1R", true, true, "C3718_301", "C3718_302"),
    //5098
    AUT_GER_5098_site("AUT_AMS1_5098_site", "19422", "1R", true, true, "EE_301, HP_301"),
    AUT_GER_5098S_site("AUT_AMS1_5098S_site", "08204", "41C", true, true, "EE_301, HP_301"),
    //4357
    AUT_GAST4357S_site("AUT_GAST4357S_site", "19901", "41C", false, true, "RLM_MD_01", "RLM_MD_02"),
    AUT_GAST4357_site("AUT_GAST4357_site", "08204", "1R", false, true, "RLM_MD_01", "RLM_MD_02"),
    AUT_GAS4357ds("Synexus - 010126 : Thunderbird- Glendale", "85244", "41C", false, true, "RLM_MD_01", "RLM_MD_02"),

    AUT_G_9279("AUT_G_9279", "78702", "1R", true, true, "TAK_906_2002"),

    AUT_GAST_7114("AUT_G_7114", "94117", "1R", true, true, "NG101_201"),
    AUT_G_7114S("AUT_G_7114S", "90007", "41C", true, true, "NG101_201"),

    //4385
    AUT_END_4385("AUT_END_4385", "19901", "1R", true, true, "MVT_601_3101", "MVT_601_3102"),
    //4442
    LPS_4442("LPS_4442", "08204", "1R", true, false, "I4V_MC_JAHZ", "I4V_MC_JAHZ"),
    //4450
    AUT_CV1_4450S_Syn("AUT_CV1_4450S_Syn", "19901", "41C", false, false, "EX9536_4388"),
    //stand alone sb
    AUT_SB_SS_site("AUT_SB_SS_site", "19901", "1R", false, false, "RA01_Generic"), // STAND ALONE SB SCREENER
    //S10560(8983)
    AUT_CV_8983("AUT_CV_8983", "19044", "1R", true, false, "20170625"),
    AUT_CV_8983S("AUT_CV_8983S", "08204", "41C", true, false, "20170625"),
    //4471
    AUT_MCC("AUT_MCC", "19341", "1R", false, true, "MK_7264_030"),
    //4533
    AUT_SHIRE_4533_site("AUT_SHIRE_4533_site", "19901", "1R", false, false, "SHP647_305", "SHP647_306"),
    //4556
    AUT_VAC_4556M("AUT_VAC_4556M", "19901", "1R", true, true, "B7471006"),//"B7471007"
    AUT_VAC_4556_A("AUT_VAC_4556_A", "19901", "1R", true, true, "B7471007_A"),
    //    AUT_VAC_4556_Site("AUT_VAC_4556_Site", "60061", "1R", true, false, "B7471008"),//"B7471007"
    AUT_AMS_JANRSV("AUT_JANRSV_site", "19901", "1R", false, false, "VAC18193RSV2001"),

    AUT_S10159("AUT_S10159", "19901", "41C", true, false, "FBP00004"),
    AUT_S10001("AUT_S10001", "19044", "41C", true, false, "VLA1553_301"),
    AUT_S10569("AUT_S10569", "19244", "41C", true, false, "VAC52416BAC1001"),

    AUT_AMS_JANRSV_Syn("AUT_JANRSVS_site", "19422", "41C", false, false, "VAC18193RSV2001"),
    JANRSV_AUT_JANDS("Synexus – 301010 : Chicago", "60602", "41C", false, false, "VAC18193RSV2001"),

    //4600
    AUT_AMS1_4600_site("AUT_AMS1_4600_site", "08204", "1R", true, false, "B7451014"),
    //7036
    AUT_AMS1_7036_Site("AUT_AMS1_7036_Site", "08204", "1R", true, false, "4083_006"),
    //4605
    AUT_OBS_4605_Site("AUT_OBS_4605_Site", "19901", "1R", true, false, "RM_493_013"),
    //4631
    AUT_DERM_4631_Site("AUT_DERM_4631_Site", "19901", "1R", true, false, "KPL_716_C001"),
    //4656
    AUT_PSO4656("AUT_PSO4656", "19901", "1R", true, false, "CC_10004_PSOR_022"),
    //7469
    AUT_S10484("AUT_S10484", "19901", "41C", true, false, "EDP1815_201"),
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
    //4684
    AUT_IBS4684_site("AUT_IBS4684_site", "19901", "1R", false, false, "OM_201"),
    //4831
    AUT_OA_4831_Syn("AUT_OA_4831_Syn", "19422", "41C", false, false, "R475_PN_1523_B"),
    AUT_OA_4831_site("AUT_OA_4831_site", "19901", "1R", true, false, "R475_PN_1523_B"),
    //4825
    AUT_AMS1_4825_site("AUT_AMS1_4825_site", "08204", "1R", true, true, "GS40965"),
    //4849
    AUT_DERM_4849_Site("AUT_DERM_4849_Site", "19901", "1R", true, false, "ANB020_005"),
    //4867
    AUT_OAB_4867("AUT_OAB4867_site", "08204", "41C", false, false, "URO_901_1001"),
    //4958
    AUT_AMS1_4958_site("AUT_AMS1_4958_site", "08204", "1R", true, false, "NYX_2925_2005"),
    AUT_AMS1_4958S_site("AUT_AMS1_4958S_site", "08204", "41C", false, false, "NYX_2925_2005"),
    //4967
    AUT_AMS1_4967_site("AUT_AMS1_4967_site", "08204", "1R", false, false, "R3500_AD_1798", "R3500_AD_1805"),
    //5017
    //AUT_INS_5017S_site("AUT_INS_5017S_site", "19901", "41C", false, false, "ID_078A301", "ID_078A302"), //Not required in spec
    AUT_INS_5017_site("AUT_INS_5017_site", "08204", "1R", true, false, "ID_078A301", "ID_078A302"),
    //5019
    AUT_AMS1_5019_site("AUT_AMS1_5019_site", "19422", "1R", false, false, "BOS_589_201"),
    AUT_AMS1_5019S_site("AUT_AMS1_5019S_site", "08204", "41C", false, false, "BOS_589_201"),
    //5034
    AUT_CV_5034A_site("AUT_CV_5034A_site", "45206", "1R", true, false, "K_877_302_A"), //45205 //Chartfill with MR receive standard email (MR is present but need to set false for email verification)
    AUT_CV_5034S_site("AUT_CV_5034S_site", "19901", "41C", false, false, "K_877_302_S"),
    //5044
    AUT_OA_5044_S("AUT_OA_5044_S", "19901", "41C", true, false, "R475_OA_1758"),
    //5055
    AUT_OA_5055_S("AUT_OA_5055_S", "19901", "41C", false, false, "R475_PN_1602"),
    //5062
    AUT_NASH5062_site("AUT_NASH5062_site", "19901", "41C", false, false, "3152_301_002"),
    //5071
    AUT_AMS1_5071_site("AUT_AMS1_5071_site", "08204", "1R", true, false, "GS_US_431_4566", "GS_US_431_4567"),
    AUT_AMS1_5071S_site("AUT_AMS1_5071S_site", "19422", "41C", true, false, "GS_US_431_4566", "GS_US_431_4567"),
    //5098
    AUT_AMS1_5098_site("AUT_AMS1_5098_site", "19422", "1R", true, false, "EE_301", "HP_301"),
    AUT_AMS1_5098S_site("AUT_AMS1_5098S_site", "08204", "41C", false, false, "EE_301", "HP_301"),
    //7069
    AUT_AMS1_7069_site("AUT_AMS1_7069_site", "19422", "1R", true, false, "BA058_05_021"),
    //4483
    AUT_NASH4483_site("AUT_AMS1_4483_site", "19901", "1R", false, false, "MGL_3196_11"),
    AUT_NASH4483S_site("AUT_AMS1_4483S_site", "19422", "41C", false, false, "MGL_3196_11"),
    //Hot Flashes
    AUT_AMS1_7119_site("AUT_AMS1_7119_site", "08204", "41C", false, false, "2693_CL_0301","2693_CL_0302","2693_CL_0304"),
    //4960
    AUT_AMS1_4960_site("AUT_AMS1_4960_site", "08204", "1R", true, false, "LG_GDCL002"),
    AUT_AMS1_4960S_site("AUT_AMS1_4960S_site", "08204", "41C", false, false, "LG_GDCL002"),
    //4912
    AUT_AMS1_4912_site("AUT_AMS1_4912_site", "19422", "41C", true, true, "I6T_MC_AMAM"),
    AUT_AMS1_4912S_site("AUT_AMS1_4912S_site", "08204", "41C", true, true, "I6T_MC_AMAM"),
    //7157
    AUT_AMS1_7157_site("AUT_AMS1_7157_site", "08204", "1R", true, true, "GBR_830_204"),
    AUT_AMS1_7157S_site("AUT_AMS1_7157S_site", "08204", "41C", true, true, "GBR_830_204"),
    //SynDiab type 2
    AUT_AMS1_DIABS_site("Synexus - 010110 : East Valley Family Physicians", "85224", "41C", false, false, "SYNType_2_Diabetes"),
    //SynMigrn
    AUT_AMS1_MIGRS_site("AUT_AMS1_MIGRS_site", "85224", "1R", false, false, "SYNMigraine"),
    //Others
    AUT_GFLR1_site("AUT_GFLR1_site", "92586", "", false, false), //FlareActivationCode.java
    //Health check
    AUT_GRA1_Site("AUT_GRA1_Site", "19901", "1R", false, false),
    AUT_GRA_FUL_Site("AUT_GRA_FUL_Site", "19901", "1R", true, false),
    AUT_GRA_FULm_Site("AUT_GRA_FULm_Site", "19901", "1R", true, true),
    //Dispo sites
    AUT_GMEGA_New("AUT_GMEGA_New", "08204", "1R", true, false), //"AUT_GMEGA_Site";//AUT_GMEGA_01
    AUT_GRA_43C_Site("AUT_GRA_43C_Site", "73159", "43C", true, false),
    AUT_DPN_5096_site("AUT_AMS1_5096_site", "08204", "1R", true, false, "NYX_2925_2008"),
    AUT_DPN_5096S_site("AUT_AMS1_5096S_site", "19422", "41C", true, false, "NYX_2925_2008"),
    AUT_AMS1_7191_site("AUT_AMS1_7191_site", "19422", "1R", true, true, "INCB_39110_210"),
    AUT_AMS1_7191S_site("AUT_AMS1_7191S_site", "08204", "41C", true, true,"INCB_39110_210"),
    //UC release 88.0
    AUT_AMS1_BI_UC_site("AUT_AMS1_BI_UC_site", "19422", "1R", true, true, "1368_0005"),
    AUT_AMS1_BI_UCS_site("AUT_AMS1_BI_UCS_site", "19044", "41C", true, true, "1368_0005"),
    AUT_S10503("AUT_S10503", "19044", "1R", true, false, "192024_093");




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
