package com.acurian.selenium.models;

import java.util.Arrays;

public enum Site {
    //4631
    AUT_DERM_4631_Site("AUT_DERM_4631_Site", "19901", "1R", "KPL_716_C001"),
    //4691
    AUT_AKC4691_MR("AUT_AKC4691_MR", "08204", "1R", "ISIS 703802_CS2"),
    //4708
    AUT_NASH4708_site("AUT_NASH4708_site", "19901", "41C", "EDP 305_101"),
    //4814
    AUT_AD4814_site("AUT_AD4814_site", "19901", "1R", "INCB 18424_303", "INCB 18424_304"),
    AUT_AD4814S_site("AUT_AD4814S_site", "19901", "41C", "INCB 18424_303", "INCB 18424_304"),
    //4815
    AUT_DERM_4815_Site("AUT_DERM_4815_Site", "19901", "1R", "B7451029"),
    AUT_DERM_4815S_Site("AUT_DERM_4815S_Site", "19901", "41C", "B7451029"),
    //4849
    AUT_DERM_4849_Site("AUT_DERM_4849_Site", "19901", "1R", "ANB020_005"),
    //4867
    AUT_OAB_4867("AUT_OAB4867_site", "08204", "41C", "URO_901_1001"),
    //5062
    AUT_NASH5062_site("AUT_NASH5062_site", "19901", "41C", "3152_301_002"),
    //Others
    GFLR1_1234_GFLR1("GFLR1_1234_GFLR1", "08204", "", ""); //FlareActivationCode.java

    public String name;
    public String zipCode;
    public String dispo;
    public String[] activeProtocols;

    Site(String name, String zipCode, String dispo, String... activeProtocols) {
        this.name = name;
        this.zipCode = zipCode;
        this.dispo = dispo;
        this.activeProtocols = activeProtocols;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + zipCode + ", " + dispo + ", " + Arrays.toString(activeProtocols) + "]";
    }
}
