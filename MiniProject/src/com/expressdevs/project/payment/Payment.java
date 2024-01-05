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



//        switch()
    }

    public void paidWithCash() {
        System.out.println("=============== 현금 결제를 선택하셨습니다. ===============");

    }

}
