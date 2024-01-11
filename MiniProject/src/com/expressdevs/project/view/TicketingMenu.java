package com.expressdevs.project.view;

import com.expressdevs.project.member.MemberManager;
import com.expressdevs.project.model.DTO.MemberDTO;
import com.expressdevs.project.payment.Payment;
import com.expressdevs.project.train.TicketDTO;
import com.expressdevs.project.train.TicketingManager;

import java.util.Scanner;

import static com.expressdevs.project.run.Application.memberList;

public class TicketingMenu {

    private static int selectLogin = 0;
    private static MemberDTO nowLoginMember;
    private MemberDTO DH = new MemberDTO("김동환", 26 , "ehdghks", "ehdghks123", 20000);
    private MemberDTO JW = new MemberDTO("이진우", 26 , "wlsdn", "wlsdn123", 15000);
    private MemberDTO SR = new MemberDTO("이서린", 21 , "tjfls", "tjfls123", 10000);
    private MemberDTO newMember;
    private Scanner sc = new Scanner(System.in);
    private MemberManager mm = new MemberManager();
    private TicketingManager tm = new TicketingManager();
    private TicketDTO td = new TicketDTO();
    private Payment pay = new Payment();

    public void mainMenu() {
        memberList.add(DH);
        memberList.add(JW);
        memberList.add(SR);

        this.td = tm.startTicketing();
        loginMenu();
        pay.paymentMethod(selectLogin, tm.TimeSchedule(td), nowLoginMember);

        System.out.println("즐거운 여행이 되십쇼.");
    }

    public void loginMenu() {
        System.out.println("==============================================");
        System.out.println("예매를 위해 로그인이 필요합니다.");
        System.out.println("1. 회원");
        System.out.println("2. 비회원");
        System.out.println("3. 회원가입");
        int selectLogin;
        while (true) {
            System.out.print("로그인 방식을 선택해주세요 : ");
            selectLogin = sc.nextInt();
            sc.nextLine();
            if (selectLogin == 1 || selectLogin == 2 || selectLogin == 3) {
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요.");
            }
        }

        switch (selectLogin) {
            case 1 :
                nowLoginMember = mm.memberLogin();
                this.selectLogin = 1;
                break;
            case 2 :
                mm.nonMemberLogin();
                this.selectLogin = 2;
                break;
            case 3 :
                this.newMember = mm.signUp();
                memberList.add(this.newMember);
                loginMenu();
                break;
        }
    }

    public void GenerateTicket() {
        int ticketNum = (int) (Math.random() * 3);


    }

//    public String ticketChar () {
//        String str = '';
//        for(int i = 0 ; i < ticketChar.length(); i++) {
//            result += fromCharCode(getRandomInt(97,122))
//        }
//            return result;
//        }

//    }
}