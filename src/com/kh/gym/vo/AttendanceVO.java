package com.kh.gym.vo;

public class AttendanceVO {
    private int memberID;
    private String attType;
    private String attTime;

    public AttendanceVO(int memberID, String attType, String attTime) {
        this.memberID = memberID;
        this.attType = attType;
        this.attTime = attTime;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getAttType() {
        return attType;
    }

    public void setAttType(String attType) {
        this.attType = attType;
    }

    public String getAttTime() {
        return attTime;
    }

    public void setAttTime(String attTime) {
        this.attTime = attTime;
    }
}
