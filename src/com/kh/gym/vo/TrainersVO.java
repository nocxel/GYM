package com.kh.gym.vo;

public class TrainersVO {
    private int trainerID;
    private String trainerName;
    private String phone;
    private char gender;
    private String hireDate;


    public TrainersVO() {
        super();
    }
    public TrainersVO(int trainerID, String trainerName, String phone, char gender, String hireDate) {
        this.trainerID = trainerID;
        this.trainerName = trainerName;
        this.phone = phone;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}
