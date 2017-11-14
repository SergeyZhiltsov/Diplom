package com.acurian.selenium.utils;

public class PassPID {

    private String pidNumber = "null";

    private PassPID() {
    }

    private static class SingletonHolder{
        private final static PassPID instance = new PassPID();
    }

    public static PassPID getInstance(){
        return SingletonHolder.instance;
    }

    public void setPidNumber(String pidNumber) {
        this.pidNumber = pidNumber;
    }

    public String getPidNumber() {
        String pid = pidNumber;
        pidNumber = "null";
        return pid;
    }
}
