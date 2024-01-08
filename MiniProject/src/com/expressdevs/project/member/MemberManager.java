package com.expressdevs.project.member;

import com.expressdevs.project.model.DTO.MemberDTO;

import java.util.Scanner;

import static com.expressdevs.project.run.Application.memberList;

public class MemberManager {

    private Scanner sc = new Scanner(System.in);
    private String nonMemberPhone = "";         // 비회원 로그인에 사용되는 핸드폰번호
    private String nonMemberPsw = "";           // 비회원 로그인에 사용되는 비밀번호

    public MemberManager() {
    }

    // 회원가입 메소드
    public MemberDTO signUp(String name, int age, String id, String pwd, int mileage) {

        MemberDTO newMember = new MemberDTO(name, age, id, pwd);
        return newMember;
    }

    // 회원 로그인 메소드
    public void memberLogin() {

        System.out.println("==============================================");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("아이디를 입력하세요: ");
            String inputID = scanner.nextLine();
            System.out.println("==============================================");
            System.out.print("비밀번호를 입력하세요: ");
            String inputPsw = scanner.nextLine();

            for (MemberDTO member : memberList) {
                if (member.getId().equals(inputID) && member.getPwd().equals(inputPsw)) {
                    return;
                }
            }
            System.out.println("==============================================");
            System.out.println("로그인 정보가 일치하지 않습니다. 다시 시도해주세요.");

        }
    }

    public void nonMemberLogin() {
        System.out.println("==============================================");
        System.out.println("핸드폰 번호를 입력해주세요 : ");
        String phone = sc.nextLine();
        this.nonMemberPhone = phone;
        System.out.println("==============================================");
        System.out.println("사용하실 비밀번호를 입력해주세요 : ");
        String psw = sc.nextLine();
        this.nonMemberPsw = psw;
    }

    public void findID() {
        System.out.println("==============================================");
        while (true) {
            System.out.println("성함을 입력해주세요");
            String name = sc.nextLine();
            for (MemberDTO member : memberList) {
                if (member.getName().equals(name)) {
                    System.out.println(member.getId());
                    return;
                }
            }
            System.out.println("==============================================");
            System.out.println("일치하는 정보가 없습니다. 다시 시도해주세요.");
        }
    }

    public void findPwd() {
        System.out.println("==============================================");
        while (true) {
            System.out.println("성함을 입력해주세요.");
            String name = sc.nextLine();
            System.out.println("==============================================");
            System.out.println("ID를 입력해주세요.");
            String id = sc.nextLine();
            for (MemberDTO member : memberList) {
                if (member.getName().equals(name) && member.getId().equals(id)) {
                    System.out.println(member.getPwd());
                    return;
                }
            }
            System.out.println("==============================================");
            System.out.println("일치하는 정보가 없습니다. 다시 시도해주세요.");
        }
    }

    public void tnwjd() {

    }

}
