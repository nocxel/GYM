package com.kh.gym.vo;

public class LockerVO {
    private int lockerNo;
    private String startDate;
    private String endDate;
    private String desc;

    public LockerVO(int lockerNo, String startDate, String endDate, String desc) {
        this.lockerNo = lockerNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.desc = desc;
    }

    public int getlockerNo() {
        return lockerNo;
    }

    public void setlockerNo(int lockerNo) {
        this.lockerNo = lockerNo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
