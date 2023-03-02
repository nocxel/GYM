package com.kh.gym.manager;

import com.kh.gym.dao.MembersDAO;

import java.awt.*;
import java.util.Scanner;

public class MemberManager {
    Scanner sc = new Scanner(System.in);
    MembersDAO membersDAO = new MembersDAO();

    public void management() {
        while(true) {
            System.out.println("========== 회원 관리 ==========");
            System.out.println("[1]회원 등록, [2]회원 조회, [3]전체 회원 조회, [4]회원 정보 수정, [5]회원 삭제, [6]종료");
            int sel = sc.nextInt();
            switch (sel) {
                case 1:

            }
        }
    }
}
