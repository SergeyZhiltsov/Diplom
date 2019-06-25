package com.acurian.selenium.constants;

public enum FULType {

    REGULAR("followup_call_1R___1R_NULL"),
    MEDICAL_RECORD("followup_call_1R___1R_MED"),
    BUCKET("followup_call_1R___BUCKET___33___OLS"),
    RADIANT("followup_call_1R___HOLDINGBIN___5___OLS");

    private String fulType;

    FULType(String fulType) {
        this.fulType = fulType;
    }

    @Override
    public String toString() {
        return fulType;
    }
}
