package com.acurian.selenium.utils.db;

public class RadiantResults {
    private String currentStatus;
    private String studyReference;
    private String responseMessage;

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getStudyReference() {
        return studyReference;
    }

    public void setStudyReference(String studyReference) {
        this.studyReference = studyReference;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
