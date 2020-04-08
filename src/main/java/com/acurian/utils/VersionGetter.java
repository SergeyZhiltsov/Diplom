package com.acurian.utils;

public class VersionGetter {

    public static ThreadLocal<String> th = new ThreadLocal();

    public VersionGetter() {
    }

    public static void setVersion(String version) {
        th.set(version);
    }

    public static void clearTh() {
        if (th.get() != null)
            th.remove();
    }

    public static String getVersion() {
        String version = th.get();
//        String versionValue = "";
        return version;
    }
}
