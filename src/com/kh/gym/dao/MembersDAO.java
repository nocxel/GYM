package com.kh.gym.dao;

import com.kh.gym.util.Common;
import com.kh.gym.vo.MembersVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MembersDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rSet = null;

    // 회원 등록 메소드
    public void MembersInsert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원번호 : ");
        int memberID = sc.nextInt();
        System.out.println("회원이름 : ");
        String memberName = sc.next();
        System.out.println("생년월일 : ");
        String birthDate = sc.next();
        System.out.println("성별 : ");
        String gender = sc.next();
        System.out.println("휴대폰번호 : ");
        String phone = sc.next();
        System.out.println("만료일 : ");
        String dueDate = sc.next();
        System.out.println("락커번호 : ");
        int lockNo = sc.nextInt();
        System.out.println("트레이너번호 : ");
        int trainerID = sc.nextInt();
        System.out.println("남은 PT횟수 : ");
        int ptRemain = sc.nextInt();
        try {
            conn = Common.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO MEMBERS VALUES ");
            sql.append("( ?, ?, ?, ?, ?, ?, ?, ?, ?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, memberID);
            pstmt.setString(2, memberName);
            pstmt.setString(3, birthDate);
            pstmt.setString(4, gender);
            pstmt.setString(5, phone);
            pstmt.setString(6, dueDate);
            pstmt.setInt(7, lockNo);
            pstmt.setInt(8, trainerID);
            pstmt.setInt(9, ptRemain);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(rSet);
        Common.close(stmt);
        Common.close(pstmt);
        Common.close(conn);
    }

    // 회원정보 select 문 메소드
    public List<MembersVO> selectMemberInfo() {
        List<MembersVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM MEMBERS";
            rSet = stmt.executeQuery(sql);

            listAddResultSet(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // 오버로딩으로 회원번호 조회 구현
    public List<MembersVO> selectMemberInfo(int memberID) {
        List<MembersVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();

            String sql = "SELECT * FROM MEMBERS WEHRE MEMBER_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memberID);
            rSet = pstmt.executeQuery();
            listAddResultSet(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    private void listAddResultSet(List<MembersVO> list) {
        try {
            while (rSet.next()) {
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
        } catch (SQLException se) {
            se.printStackTrace();
        }
        Common.close(rSet);
        Common.close(stmt);
        Common.close(conn);
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
