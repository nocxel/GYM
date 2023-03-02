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
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rSet = null;

    public List<PTDataVO> getPTInfoList() {
        List<PTDataVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PT.MEMBER_ID, M.MEMBER_NAME, T.TRAINER_NAME, TO_CHAR( PT.PT_DATE, 'YYYY-MM-DD') AS PT_DATE, PT.PT_REMAIN ");
            sql.append("FROM PT_DATA PT, MEMBERS M, TRAINERS T ");
            sql.append("WHERE PT.MEMBER_ID = M.MEMBER_ID AND T.TRAINER_ID = PT.TRAINER_ID ");
            sql.append("ORDER BY PT.PT_DATE DESC ");
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
            sql.append("SELECT PT.MEMBER_ID, M.MEMBER_NAME, T.TRAINER_NAME, TO_CHAR(PT.PT_DATE, 'YYYY-MM-DD' AS PT_DATE, PT.PT_REMAIN ");
            sql.append("FROM PT_DATA PT, MEMBERS M, TRAINERS T ");
            sql.append("WHERE PT.MEMBER_ID = M.MEMBER_ID AND T.TRAINER_ID = PT.TRAINER_ID AND PT.MEMBER_ID = ?" );
            sql.append("ORDER BY PT.PT_DATE DESC ");
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
        System.out.println("| 번호 | 회원번호 | 회원이름 | 트레이너 | 날짜 | 남은PT횟수 |");
        System.out.println("======================================================");
        for (PTDataVO m : list) {
            StringBuilder out = new StringBuilder();
            out.append("| " + m.getRowNo() + " | ");
            out.append(m.getMemberID() + " | ");
            out.append(m.getMemberName() + " | ");
            out.append(m.getTrainerName() + " | ");
            out.append(m.getPtDate() + " | ");
            out.append(m.getPtRemain() + " |");
            System.out.println(out);
            System.out.println("==============================");


        }
    }


    // PT 기록 시 PT_DATA에 INSERT 하고 MEMBERS 의 PT_REMAIN을 1 감소시키는 메소드
    // 쿼리문을 2개 써야한다.
    public void PTDataInsert() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 번호 입력 : ");
        int memberID = sc.nextInt();
        System.out.print("트레이너 번호 입력 : ");
        int trainerID = sc.nextInt();
        System.out.print("날짜 입력(yyyy-mm-dd) : ");
        String ptDate = sc.next();
        // DATE 는 JAVA.SQL.DATE를 사용하는 것도?
        try {
            conn = Common.getConnection();
            String sql = String.format("SELECT PT_REMAIN FROM MEMBERS WHERE MEMBER_ID = %d", memberID);
            stmt = conn.createStatement();
            rSet = stmt.executeQuery(sql);
            // 에러처리가 힘들어서 PT_REMAIN값을 받아와서 체크합시다. ㅠㅠㅠ
            if (rSet.next() && rSet.getInt("PT_REMAIN") >= 1) {
                // PT_Data 테이블에 INSERT 하는 sql1
                StringBuilder sql1 = new StringBuilder();
                sql1.append("INSERT INTO PT_DATA(MEMBER_ID, TRAINER_ID, PT_DATE, PT_REMAIN) ");
                sql1.append("VALUES ( ?, ?, ?, (SELECT PT_REMAIN - 1 FROM MEMBERS WHERE MEMBER_ID = ? ))");
                pstmt = conn.prepareStatement(sql1.toString());
                pstmt.setInt(1, memberID);
                pstmt.setInt(2, trainerID);
                pstmt.setString(3, ptDate);
                pstmt.setInt(4, memberID);

                pstmt.executeUpdate();

//              MEMBERS 의 PT_REMAIN을 UPDATE 하는 sql2
                String sql2 = "UPDATE MEMBERS SET PT_REMAIN = PT_REMAIN - 1 WHERE MEMBER_ID = ?";
                pstmt = conn.prepareStatement(sql2);
                pstmt.setInt(1, memberID);
                pstmt.executeUpdate();
            } else {
                System.out.println("남은 PT횟수가 없습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(rSet);
        Common.close(stmt);
        Common.close(pstmt);
        Common.close(conn);
    }

}
