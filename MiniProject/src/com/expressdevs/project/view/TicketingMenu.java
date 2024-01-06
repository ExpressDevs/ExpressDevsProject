package com.expressdevs.project.view;

import com.expressdevs.project.Member.MemberManager;

import java.util.Scanner;

public class TicketingMenu {

    private Scanner sc = new Scanner(System.in);
    private MemberManager mm;

    public void MainMenu() {
        System.out.println("예매를 위해 로그인이 필요합니다.");
        System.out.println("1. 회원");
        System.out.println("2. 비회원");
        int selectLogin;
        while (true) {
            System.out.print("로그인 방식을 선택하세요 : ");
            selectLogin = sc.nextInt();
            if (selectLogin == 1 || selectLogin == 2) {
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }

        switch (selectLogin) {
            case 1 :
                mm.memberLogin();
                break;
            case 2 :
                mm.nonMemberLogin();
                break;
        }




    }







}
