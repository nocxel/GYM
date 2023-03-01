package com.kh.gym.dao;

import com.kh.gym.util.Common;
import com.kh.gym.vo.MembersVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembersDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rSet = null;

    // 회원정보 select 문 메소드
    public List<MembersVO> selectMemberInfo() {
        List<MembersVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM MEMBERS";
            rSet = stmt.executeQuery(sql);

            while(rSet.next()) {
                // rSet.get변수( " 실제 DB 컬럼명 ")
                int memberID = rSet.getInt("MEMBER_ID");
                String memberName = rSet.getString("MEMBER_NAME");
                String birthDate = rSet.getString("BIRTH_DATE");
                String gender = rSet.getString("GENDER");
                String phone = rSet.getString("PHONE");
                String dueDate = rSet.getString("DUE_DATE");
                int lockerNo = rSet.getInt("LOCKER_NO");
                int trainerID = rSet.getInt("TRAINER_ID");
                int ptRemain = rSet.getInt("PT_REMAIN");
                MembersVO vo = new MembersVO(memberID, memberName, birthDate, gender, phone, dueDate, lockerNo, trainerID, ptRemain);
                list.add(vo);

            }
            Common.close(rSet);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // 출력 메소드 항목 조정 가능 get 문으로
    public void memberView(List<MembersVO> list) {
        for (MembersVO m : list) {
            System.out.println("회원번호 : " + m.getMemberID());
            System.out.println("회원이름 : " + m.getMemberName());
            System.out.println("생년월일 : " + m.getBirthDate());
            System.out.println("성별 : " + m.getGender());
            System.out.println("휴대폰번호 : " + m.getPhone());
            System.out.println("만료일 : " + m.getDueDate());
            System.out.println("락커번호 : " + m.getLockerNo());
            System.out.println("트레이너번호 : " + m.getTrainerID());
            System.out.println("남은 PT횟수 : " + m.getPtRemain());
            System.out.println("==============================");
        }
    }

}
