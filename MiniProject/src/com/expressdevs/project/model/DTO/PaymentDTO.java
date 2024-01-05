package com.expressdevs.project.model.DTO;

import java.util.Scanner;

public class PaymentDTO {

    Scanner sc = new Scanner(System.in);
    public void paidWithCard() {
        System.out.println("=============== 카드 결제를 선택하셨습니다. ===============");
        System.out.println("1. 삼성 카드");
        System.out.println("2. 국민 카드");
        System.out.println("3. 농협 카드");
        System.out.println("4. 신한 카드");
        System.out.println();


        System.out.println("동환아 우리 이제 된걸까?");

//        switch()
    }

    public void paidWithCash() {
        System.out.println("=============== 현금 결제를 선택하셨습니다. ===============");

    }

}
