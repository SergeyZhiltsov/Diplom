package com.acurian.selenium.constants;

public enum Version {
     CC ("CC"),
     OLS ("OLS");

     private String version;

    Version(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return version;
    }
}
