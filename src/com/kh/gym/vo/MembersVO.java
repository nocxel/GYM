package com.kh.gym.vo;

public class MembersVO {
    private int memberID;
    private String memberName;
    private String birthDate;
    private String gender;
    private String phone;
    private String dueDate;
    private int lockerNo;
    private int trainerID;
    private int ptRemain;


    public MembersVO() {
        super();
    }
    public MembersVO(int memberID, String memberName, String birthDate, String gender, String phone, String dueDate, int lockerNo, int trainerID, int ptRemain) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.dueDate = dueDate;
        this.lockerNo = lockerNo;
        this.trainerID = trainerID;
        this.ptRemain = ptRemain;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getLockerNo() {
        return lockerNo;
    }

    public void setLockerNo(int lockerNo) {
        this.lockerNo = lockerNo;
    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }

    public int getPtRemain() {
        return ptRemain;
    }

    public void setPtRemain(int ptRemain) {
        this.ptRemain = ptRemain;
    }
}
