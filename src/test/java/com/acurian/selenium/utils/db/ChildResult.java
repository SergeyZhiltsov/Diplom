package com.acurian.selenium.utils.db;

public class ChildResult {
    private String dispoCd;
    private String applicantStatus;
    private String phoneNumber;

    public String getChildPid() {
        return childPid;
    }

    public void setChildPid(String childPid) {
        this.childPid = childPid;
    }

    private String childPid;

    public String getDispoCd() {
        return dispoCd;
    }

    public void setDispoCd(String dispoCd) {
        this.dispoCd = dispoCd;
    }

    public String getApplicantStatus() {
        return applicantStatus;
    }

    public void setApplicantStatus(String applicantStatus) {
        this.applicantStatus = applicantStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
