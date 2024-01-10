package com.expressdevs.project.payment;

import java.util.Scanner;

public class Payment {
    Scanner sc = new Scanner(System.in);

    private int price;

    public void paymentMethod(int selectLogin,int sum) {
        this.price = sum;
        System.out.println("=============== 예매/결제 관리 =================");
        System.out.println("결제하실 총 금액은 " + price + "입니다.\n==============================================");
        System.out.println("1. 카드 결제");
        System.out.println("2. 현금 결제");
        System.out.print("결제 방식을 선택하세요 : ");
        int select = sc.nextInt();

        while (true) {
            switch (selectLogin) {
                case 1:
                    if (select == 1) {;
                        MemberCardChoice();
                        return;
                    } else if (select == 2) {
                        MemberPayWithCash();
                        return;
                    } else {
                        System.out.println("==============================================");
                        System.out.println("번호를 잘못 누르셨습니다. 다시 선택해주세요.");
                    }
                case 2 :
                    if (select == 1) {
                        NonMemberCardChoice();
                        return;
                    } else if (select == 2) {
                        NonMemberPayWithCash();
                        return;
                    } else {
                        System.out.println("==============================================");
                        System.out.println("번호를 잘못 누르셨습니다. 다시 선택해주세요.");
                    }
            }
        }
    }

    public void MemberCardChoice() {
        PaymentCard();
        System.out.println("회원님이 보유중인 마일리지는 " + "" + "입니다. 사용하시겠습니까?");
        System.out.println("==============================");
        System.out.println("1. 마일리지 사용");
        System.out.println("2. 마일리지 미사용");
        System.out.println("총 결제 금액 : " + price);
        System.out.println("회원님께서 보유중인 마일리지는 " + "" + "입니다.");

    }

    public void NonMemberCardChoice() {
        PaymentCard();
        System.out.println(price + " 를 결제하겠습니다.");
        System.out.println("승인 대기 중");
        System.out.println("승인 완료되었습니다.");

    }

    public void PaymentCard () {
        System.out.println("=============== 카드 결제를 선택하셨습니다. ===============");
        System.out.println("아래 카드사별 할인 안내표를 확인해주십쇼.");
        System.out.println("* 삼성카드 5% * 국민카드 7% * 농협카드 3% * 신한카드 1%");
        System.out.println("1. 삼성 카드");
        System.out.println("2. 국민 카드");
        System.out.println("3. 농협 카드");
        System.out.println("4. 신한 카드");
        System.out.print("카드를 선택해 주십쇼. : ");
        int chosenCard = sc.nextInt();
        System.out.println();

        switch (chosenCard) {
            case 1:
                System.out.println("=============== 삼성카드를 선택하셨습니다. ===============");
                System.out.println(price * 0.95);
                break;
            case 2:
                System.out.println("=============== 국민카드를 선택하셨습니다. ===============");
                System.out.println(price * 0.93);
                break;
            case 3:
                System.out.println("=============== 농협카드를 선택하셨습니다. ===============");
                System.out.println(price * 0.97);
                break;
            case 4:
                System.out.println("=============== 신한카드를 선택하셨습니다. ===============");
                System.out.println(price * 0.99);
                break;
            default:
                break;
        }
        System.out.println(price + " 를 결제하겠습니다.");
        System.out.println("승인 대기 중");
        System.out.println("승인 완료되었습니다.");

    }
    }

    public void MemberPayWithCash() {
        System.out.println("=============== 현금 결제를 선택하셨습니다. ===============");

        int remainingMoney = 0;
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
                    return;
                case 2:
                    num += 10000;
                    if (num > price) {
                        System.out.print("결제가 완료되었습니다. ");
                        System.out.println("거스름돈은 " + (num - price) + " 원 입니다.");
                        return;
                    } else if (num == price) {
                        System.out.println("결제가 완료되었습니다.");
                        return;
                    } else {
                        remainingMoney = price -num;
                        System.out.println("추가로 지불하셔야할 금액은 " + remainingMoney + "원 입니다.");
                        break;
                    }
                case 3:
                    num += 5000;
                    if (num > price) {
                        System.out.print("결제가 완료되었습니다. ");
                        System.out.println("거스름돈은 " + (num - price) + " 원 입니다.");
                        return;
                    } else if (num == price) {
                        System.out.println("결제가 완료되었습니다.");
                        return;
                    } else {
                        remainingMoney = price -num;
                        System.out.println("추가로 지불하셔야할 금액은 " + remainingMoney + "원 입니다.");
                        break;
                    }

                case 4:
                    num += 1000;
                    if (num > price) {
                        System.out.print("결제가 완료되었습니다. ");
                        System.out.println("거스름돈은 " + (num - price) + " 원 입니다.");
                        return;
                    } else if (num == price) {
                        System.out.println("결제가 완료되었습니다.");
                        return;
                    } else {
                        remainingMoney = price -num;
                        System.out.println("추가로 지불하셔야할 금액은 " + remainingMoney + "원 입니다.");
                        break;
                    }

            }
        }

    }
    public void NonMemberPayWithCash() {
        System.out.println("=============== 현금 결제를 선택하셨습니다. ===============");

        int remainingMoney = 0;
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
                    return;
                case 2:
                    num += 10000;
                    if (num > price) {
                        System.out.print("결제가 완료되었습니다. ");
                        System.out.println("거스름돈은 " + (num - price) + " 원 입니다.");
                        return;
                    } else if (num == price) {
                        System.out.println("결제가 완료되었습니다.");
                        return;
                    } else {
                        remainingMoney = price -num;
                        System.out.println("추가로 지불하셔야할 금액은 " + remainingMoney + "원 입니다.");
                        break;
                    }
                case 3:
                    num += 5000;
                    if (num > price) {
                        System.out.print("결제가 완료되었습니다. ");
                        System.out.println("거스름돈은 " + (num - price) + " 원 입니다.");
                        return;
                    } else if (num == price) {
                        System.out.println("결제가 완료되었습니다.");
                        return;
                    } else {
                        remainingMoney = price -num;
                        System.out.println("추가로 지불하셔야할 금액은 " + remainingMoney + "원 입니다.");
                        break;
                    }

                case 4:
                    num += 1000;
                    if (num > price) {
                        System.out.print("결제가 완료되었습니다. ");
                        System.out.println("거스름돈은 " + (num - price) + " 원 입니다.");
                        return;
                    } else if (num == price) {
                        System.out.println("결제가 완료되었습니다.");
                        return;
                    } else {
                        remainingMoney = price -num;
                        System.out.println("추가로 지불하셔야할 금액은 " + remainingMoney + "원 입니다.");
                        break;
                    }



            }
        }

    }

}
