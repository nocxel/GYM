package com.kh.gym.manager;
import java.lang.reflect.Member;
import java.util.Scanner;

public class Manager {
    Scanner sc = new Scanner(System.in);
    MemberManager memberManager = new MemberManager();


    public void adminMode() {
        while (true) {
            System.out.println("===== GYM MANAGEMENT PROGRAM =====");
            System.out.println("메뉴를 선택하세요. ");
            System.out.print("[1] 회원 관리, [2] 매출정보, [3] 라커관리, [4] 회원 출석조회, [5] 상품, [6] PT회원 관리, [7] 종료: ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1:
                    memberManager.management();
                    break;
                case 2:
            }
        }
    }
}
