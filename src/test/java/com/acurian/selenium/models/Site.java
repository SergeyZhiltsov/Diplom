package com.acurian.selenium.models;

public enum Site {
    //4815
    AUT_DERM_4815_Site("AUT_DERM_4815_Site", "19901", "1R", "B7451029"),
    AUT_DERM_4815S_Site("AUT_DERM_4815S_Site", "19901", "41C", "B7451029"),
    //4849
    AUT_DERM_4849_Site("AUT_DERM_4849_Site", "19901", "1R", "ANB020_005"),
    //4867
    AUT_OAB_4867("AUT_OAB4867_site", "08204", "41C", "URO_901_1001");

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
}
