package com.kh.gym.vo;
// ptdata출력을 위한 객체입니다.
public class PTDataVO {
    private int rowNo;
    private int memberID;
    private String memberName;
    private String trainerName;
    private String ptDate;
    private int ptRemain;

    public PTDataVO() {
        super();
    }

    public PTDataVO(int rowNo, int memberID, String memberName, String trainerName, String ptDate, int ptRemain) {
        this.rowNo = rowNo;
        this.memberID = memberID;
        this.memberName = memberName;
        this.trainerName = trainerName;
        this.ptDate = ptDate;
        this.ptRemain = ptRemain;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
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

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getPtDate() {
        return ptDate;
    }

    public void setPtDate(String ptDate) {
        this.ptDate = ptDate;
    }

    public int getPtRemain() {
        return ptRemain;
    }

    public void setPtRemain(int ptRemain) {
        this.ptRemain = ptRemain;
    }
}
