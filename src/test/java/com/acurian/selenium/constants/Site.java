package com.acurian.selenium.constants;

import java.util.Arrays;

public enum Site {
    //4556
    AUT_VAC_4556M("AUT_VAC_4556M", "19901", "1R", true, false, "B7471006","B7471007","B7471008"),
    AUT_VAC_4556_Site("AUT_VAC_4556_Site", "60061", "1R", true, false, "B7471006","B7471007","B7471008"),
    //4631
    AUT_DERM_4631_Site("AUT_DERM_4631_Site", "19901", "1R", false, false, "4631", "KPL_716_C001"),
    //4691
    AUT_AKC4691_MR("AUT_AKC4691_MR", "08204", "1R", false, false, "ISIS 703802_CS2"),
    //4708
    AUT_NASH4708_site("AUT_NASH4708_site", "19901", "41C", false, false, "EDP 305_101"),
    //4742
    AUT_MIG4742_site("AUT_MIG4742_site", "08204", "1R", false, false, "3101_301_002", "3101_302_002"),
    //4814
    AUT_AD4814_site("AUT_AD4814_site", "19901", "1R", false, false, "INCB 18424_303", "INCB 18424_304"),
    AUT_AD4814S_site("AUT_AD4814S_site", "19901", "41C", false, false, "INCB 18424_303", "INCB 18424_304"),
    //4815
    AUT_DERM_4815_Site("AUT_DERM_4815_Site", "19901", "1R", false, false, "B7451029"),
    AUT_DERM_4815S_Site("AUT_DERM_4815S_Site", "19901", "41C", false, false, "B7451029"),
    //4849
    AUT_DERM_4849_Site("AUT_DERM_4849_Site", "19901", "1R", false, false, "ANB020_005"),
    //4867
    AUT_OAB_4867("AUT_OAB4867_site", "08204", "41C", false, false, "URO_901_1001"),
    //5062
    AUT_NASH5062_site("AUT_NASH5062_site", "19901", "41C", false, false, "3152_301_002"),
    //Others
    GFLR1_1234_GFLR1("GFLR1_1234_GFLR1", "08204", "", false, false); //FlareActivationCode.java

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
