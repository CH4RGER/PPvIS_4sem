package org.bsuir.model;

public class Patient {
    private String fullName;
    private String placeOfResidence;
    private DateManager birthday;
    private DateManager dateOfReceipt;
    private String doctorsFullName;
    private String conclusion;

    public Patient(String fullName, String placeOfResidence, DateManager birthday, DateManager dateOfReceipt, String doctorsFullName, String conclusion) {
        this.fullName = fullName;
        this.placeOfResidence = placeOfResidence;
        this.birthday = birthday;
        this.dateOfReceipt = dateOfReceipt;
        this.doctorsFullName = doctorsFullName;
        this.conclusion = conclusion;
    }

    public Patient() {

    }

    public DateManager getBirthday() {
        return birthday;
    }

    public DateManager getDateOfReceipt() {
        return dateOfReceipt;
    }

    public String getConclusion() {
        return conclusion;
    }

    public String getDoctorsFullName() {
        return doctorsFullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }


    public void setBirthday(DateManager birthday) {
        this.birthday = birthday;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public void setDateOfReceipt(DateManager dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public void setDoctorsFullName(String doctorsFullName) {
        this.doctorsFullName = doctorsFullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }
}
