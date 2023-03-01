package com.kh.gym.dao;

import com.kh.gym.util.Common;
import com.kh.gym.vo.PTDataVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//preparedStatement 를 사용해보자
// PT 조회
// ROWNUM, 회원번호, 회원이름, 트레이너이름, 날짜
// ptdatavo = mid, tid, ptdate
// 출력 클래스 생성

public class PTDataDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rSet = null;

    public List<PTDataVO> getPTInfoList() {
        List<PTDataVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PT.MEMBER_ID, M.MEMBER_NAME, T.TRAINER_NAME, PT.PT_DATE,PT.PT_REMAIN ");
            sql.append("FROM PT_DATA PT, MEMBERS M, TRAINERS T ");
            sql.append("WHERE PT.MEMBER_ID = M.MEMBER_ID AND T.TRAINER_ID = PT.TRAINER_ID");
            pstmt = conn.prepareStatement(sql.toString());
            listAddResultSet(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // 회원번호로 조회하는 것은 오버로딩 하겠습니다. 코드가 많이 겹쳐서 listAddResultSet 메서드로 만들겠습니다.
    public List<PTDataVO> getPTInfoList(int memberID) {
        List<PTDataVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PT.MEMBER_ID, M.MEMBER_NAME, T.TRAINER_NAME, PT.PT_DATE,PT.PT_REMAIN ");
            sql.append("FROM PT_DATA PT, MEMBERS M, TRAINERS T ");
            sql.append("WHERE PT.MEMBER_ID = M.MEMBER_ID AND T.TRAINER_ID = PT.TRAINER_ID AND PT.MEMBER_ID = ?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, memberID);
            listAddResultSet(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    // list에 ResultSet의 결과물을 추가해주는 메소드 입니다.
    private void listAddResultSet(List<PTDataVO> list) throws SQLException {
        rSet = pstmt.executeQuery();

        while(rSet.next()) {
            PTDataVO pt = new PTDataVO();
            pt.setRowNo(rSet.getRow());
            pt.setMemberID(rSet.getInt("MEMBER_ID"));
            pt.setMemberName(rSet.getString("MEMBER_NAME"));
            pt.setTrainerName(rSet.getString("TRAINER_NAME"));
            pt.setPtDate(rSet.getString("PT_DATE"));
            pt.setPtRemain(rSet.getInt("PT_REMAIN"));

            list.add(pt);
        }
        Common.close(rSet);
        Common.close(pstmt);
        Common.close(conn);
    }

    // 출력문
    public void PTDataView(List<PTDataVO> list) {
        System.out.println("\t번호\t회원번호\t회원이름\t트레이너\t날짜\t남은PT횟수");
        for (PTDataVO m : list) {
            System.out.println(m.getRowNo() + m.getMemberID() + m.getMemberName() + m.getTrainerName() + m.getPtDate() + m.getPtRemain());
            System.out.println("==============================");


        }
    }


    // PT 기록 시 PT_DATA에 INSERT하는 메소드
    public void PTDataInsert() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 번호 입력 : ");
        int memberID = sc.nextInt();
        System.out.print("트레이너 번호 입력 : ");
        int trainerID = sc.nextInt();
        System.out.print("날짜 입력(yyyy-mm-dd) : ");
        String ptDate = sc.next();
        // DATE 는 JAVA.SQL.DATE를 사용하는 것도?

    }

}
