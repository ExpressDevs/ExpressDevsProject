package com.expressdevs.project.payment;

import com.expressdevs.project.train.TicketingManager;

import javax.swing.*;
import java.util.Scanner;

public class Payment {
    String str1 = "일시불";

    Scanner sc = new Scanner(System.in);

    private int price;

    public void paymentMethod(int price) {
        this.price = price;
        System.out.println("================(예매/결제 관리)==================");
        System.out.println("결제 방식을 선택하세요.");
        System.out.println("1. 카드 결제");
        System.out.println("2. 현금 결제");
        System.out.print(": ");
        int result = sc.nextInt();
        if (result == 1) {
            cardChoice();
        } else if (result == 2) {
            payWithCash();
        } else {
            System.out.println("번호를 잘못 누르셨습니다. 다시 선택해주세요.");
        }


    }


    public void cardChoice() {
        System.out.println("=============== 카드 결제를 선택하셨습니다. ===============");
        System.out.println("1. 삼성 카드");
        System.out.println("2. 국민 카드");
        System.out.println("3. 농협 카드");
        System.out.println("4. 신한 카드");
        System.out.println("");
        int chosenCard = sc.nextInt();
        System.out.println();

        switch (chosenCard) {
            case 1:
                System.out.println("=============== 삼성카드를 선택하셨습니다. ===============");
                System.out.println("1. 일시불");

                int samsungPay = sc.nextInt();

                if (samsungPay == 1) {
                    System.out.println(str1);
                } else {
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력하세요.");
                }
                break;
            case 2:
                System.out.println("=============== 국민카드를 선택하셨습니다. ===============");
                System.out.println("1. 일시불");

                int kbPay = sc.nextInt();

                if (kbPay == 1) {
                    System.out.println(str1 + " 로 결제 진행하겠습니다.");
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
            default:
                System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력하세요.");
                break;
        }
        System.out.println(price + " 를 결제하겠습니다.");
        System.out.println("승인 대기 중");
        System.out.println("승인 완료되었습니다.");

    }

    public void payWithCash() {
        System.out.println("=============== 현금 결제를 선택하셨습니다. ===============");

        int num = 0;
        while(true) {
            System.out.println("1. 결제 금액에 맞게 지불하기");
            System.out.println("2. 만원");
            System.out.println("3. 오천원");
            System.out.println("4. 천원");

            int receivedCash = sc.nextInt();
            switch (receivedCash) {
                case 1:
                    System.out.println("정상 결제되었습니다. 감사합니다.");
                    break;
                case 2:
                    num += 10000;
                    if (num > price) {
                        System.out.print("결제가 완료되었습니다. ");
                        System.out.println("거스름돈은 " + (num - price) + " 원 입니다.");
                    } else if (num == price) {
                        System.out.println("결제가 완료되었습니다.");
                        break;
                    }
                case 3:
                    num += 5000;
                    if (num > price) {
                        System.out.print("결제가 완료되었습니다. ");
                        System.out.println("거스름돈은 " + (num - price) + " 원 입니다.");
                    } else if (num == price) {
                        System.out.println("결제가 완료되었습니다.");
                        break;
                    }

                case 4:
                    num += 1000;
                    if (num > price) {
                        System.out.print("결제가 완료되었습니다. ");
                        System.out.println("거스름돈은 " + (num - price) + " 원 입니다.");
                    } else if (num == price) {
                        System.out.println("결제가 완료되었습니다.");
                        break;
                    }
            }

        }

    }

}
