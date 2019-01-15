package com.acurian.selenium.models;

public class Site {
    public final String name;
    public final String zipCode;
    public final String dispo;
    public final String[] activeProtocols;

    public static class Builder {
        private final String name;
        private String zipCode;
        private String dispo;
        private String[] activeProtocols;

        public Builder(String name) {
            this.name = name;
        }

        public Builder withZipcode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder withDispo(String dispo) {
            this.dispo = dispo;
            return this;
        }

        public Builder withActiveProtocols(String... activeProtocols) {
            this.activeProtocols = activeProtocols;
            return this;
        }

        public Site build() {
            return new Site(this);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    private Site(Builder builder) {
        name = builder.name;
        zipCode = builder.zipCode;
        dispo = builder.dispo;
        activeProtocols = builder.activeProtocols;
    }
}
