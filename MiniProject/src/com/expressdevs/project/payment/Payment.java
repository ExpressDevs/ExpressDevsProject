package com.expressdevs.project.payment;

import java.util.Scanner;

public class Payment {
    Scanner sc = new Scanner(System.in);

    public void paidWithCard() {
        System.out.println("=============== 카드 결제를 선택하셨습니다. ===============");
        System.out.println("1. 삼성 카드");
        System.out.println("2. 국민 카드");
        System.out.println("3. 농협 카드");
        System.out.println("4. 신한 카드");
        int receivedNum = sc.nextInt();
        System.out.println();




        switch(receivedNum) {
            case 1: break;
            case 2: break;
            case 3: break;
            case 4: break;
            default:
                break;

        }
    }

    public void paidWithCash() {
        System.out.println("=============== 현금 결제를 선택하셨습니다. ===============");
        System.out.println("1. 결제 금액에 맞게 지불하기");
        System.out.println("2. 만원");
        System.out.println("3. 오천원");
        System.out.println("4. 천원");
        System.out.println("5. 기타");
        System.out.println("6. ");


    }

}
