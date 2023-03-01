package com.kh.gym;

import com.kh.gym.dao.PTDataDAO;
import com.kh.gym.vo.PTDataVO;
import java.util.List;
import java.util.Scanner;

public class GymMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(true) {
            System.out.println("======= 메뉴 조회 =======");
            System.out.println("[1]회원관리, [2]직원관리, [3]PT 조회, [4]회원 출석조회, [5] 상품조회, [6]종료");
            System.out.print("메뉴를 선택하세요 : ");

            int sel = sc.nextInt();
            switch(sel) {
                case 1:
                case 2:
                case 3:
                    PTDataDAO dao = new PTDataDAO();
                    System.out.println("[1]전체조회, [2]회원번호조회 [3]PT 기록");
                    System.out.print("메뉴를 선택하세요 : ");
                    sel = sc.nextInt();
                    List<PTDataVO> ptData = null;
                    switch(sel) {
                        case 1:
                            ptData = dao.getPTInfoList();
                            
                            break;
                        case 2:
                            System.out.print("회원번호 입력 : ");
                            int memberID = sc.nextInt();
                            ptData = dao.getPTInfoList(memberID);
                    }
                    dao.PTDataView(ptData);
                    break;
            }
        }
    }
}
