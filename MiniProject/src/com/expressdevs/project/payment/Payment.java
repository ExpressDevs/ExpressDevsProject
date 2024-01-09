package com.expressdevs.project.payment;

import javax.swing.*;
import java.util.Scanner;

public class Payment {
    String str1 = "일시불";
    String str2 = "2개월 할부";
    String str3 = "3개월 할부";
    String str4 = "4개월 할부";
    String str5 = "5개월 할부";
    Scanner sc = new Scanner(System.in);

    /* 기차표를 선택해서 금액이 결정되면 그 정보를 가져와서 얼마 지불해야한다고 보여줘야 함. */
    public void Price() {



    }


    public void paymentMethod() {
        while (true) {
            System.out.println("================(예매/결제 관리)==================");
            System.out.println("결제 방식을 선택하세요.");
            System.out.println("1. 카드 결제");
            System.out.println("2. 현금 결제");
            System.out.print(": ");
            int result = sc.nextInt();
            if (result == 1) {
                cardChoice();
                break;
            } else if (result == 2) {
                payWithCash();
                break;



            } else {
                System.out.println("번호를 잘못 누르셨습니다. 다시 선택해주세요.");
            }
        }
    }


    public void cardChoice() {
        System.out.println("=============== 카드 결제를 선택하셨습니다. ===============");
        System.out.println("1. 삼성 카드");
        System.out.println("2. 국민 카드");
        System.out.println("3. 농협 카드");
        System.out.println("4. 신한 카드");
        System.out.println("");
        System.out.println("0. 할부 가능 카드 및 할부 개월 조회");
        int chosenCard = sc.nextInt();
        System.out.println();

        switch (chosenCard) {
            case 1:
                System.out.println("=============== 삼성카드를 선택하셨습니다. ===============");
                System.out.println("1. 일시불");
                System.out.println("2. 2개월 할부");
                System.out.println("3. 3개월 할부");

                int samsungPay = sc.nextInt();

                if (samsungPay == 1) {
                    System.out.println(str1);
                } else if (samsungPay == 2) {
                    System.out.println(str2);
                } else if (samsungPay == 3) {
                    System.out.println(str3);
                } else {
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력하세요.");
                }
                break;
            case 2:
                System.out.println("=============== 국민카드를 선택하셨습니다. ===============");
                System.out.println("1. 일시불");
                System.out.println("2. 4개월 할부");
                System.out.println("3. 5개월 할부");

                int kbPay = sc.nextInt();

                if (kbPay == 1) {
                    System.out.println(str1 + " 로 결제 진행하겠습니다.");
                } else if (kbPay == 2) {
                    System.out.println(str4 + " 로 결제 진행하겠습니다.");
                } else if (kbPay == 3) {
                    System.out.println(str5 + " 로 결제 진행하겠습니다.");
                } else {
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력하세요.");
                }
                break;
            case 3:
                System.out.println("=============== 농협카드를 선택하셨습니다. ===============");
                System.out.println("1. 일시불");

                int nhPay = sc.nextInt();

                if (nhPay == 1) {
                    System.out.println(str1 + " 로 결제 진행하겠습니다.");
                } else {
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력하세요.");
                }
                break;
            case 4:
                System.out.println("=============== 신한카드를 선택하셨습니다. ===============");
                System.out.println("1. 일시불");

                int shPay = sc.nextInt();

                if (shPay == 1) {
                    System.out.println(str1 + " 로 결제 진행하겠습니다.");
                } else {
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력하세요.");
                }
                break;
            case 0:
                System.out.println("이전 메뉴로 돌아가기를 선택하셨습니다. 이젠 메뉴로 돌아가겠습니다.");
                break;
            default:
                System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력하세요.");
                break;

        }
    }

    public void payWithCash() {
        System.out.println("=============== 현금 결제를 선택하셨습니다. ===============");
        System.out.println("1. 결제 금액에 맞게 지불하기");
        System.out.println("2. 만원");
        System.out.println("3. 오천원");
        System.out.println("4. 천원");
        System.out.println("5. 기타");
        System.out.println("9. 이전 메뉴로 돌아가기");
        int receivedCash = sc.nextInt();
        int paidAmount = 0;

    }


}
