package com.acurian.utils;

public class PassPID {

    public static ThreadLocal<String> th = new ThreadLocal();
    private String pidNumber = "null";

    private PassPID() {
    }

    private static class SingletonHolder {
        private final static PassPID instance = new PassPID();
    }

    public static PassPID getInstance() {
        return SingletonHolder.instance;
    }

    public void setPidNumber(String pidNumber) {
        th.set(pidNumber);
    }

    public String getPidNumber() {
        String pid = th.get();
        pidNumber = "null";
        th.remove();
        return pid;
    }
}
