package com.expressdevs.project.payment;

import com.expressdevs.project.model.DTO.MemberDTO;

import java.lang.reflect.Member;
import java.util.Scanner;


public class Payment {
    Scanner sc = new Scanner(System.in);
//    private int finalPriceCard;
//    private int inputMilege;
    private MemberDTO nowLoginMember;
    private int price;



    public void paymentMethod(int selectLogin, int sum, MemberDTO nowLoginMember) {
        this.price = sum;
        this.nowLoginMember = nowLoginMember;
        if(selectLogin == 1) {useMilege();}
        System.out.println("=============== 예매/결제 관리 =================");
        System.out.println("결제하실 금액은 " + price + "입니다.\n==============================================");
        System.out.println("1. 카드 결제");
        System.out.println("2. 현금 결제");
        System.out.print("결제 방식을 선택하세요 : ");
        int select = sc.nextInt();

        while (true) {
            switch (selectLogin) {
                case 1:
                    if (select == 1) {
                        MemberCardChoice();
                        return;
                    } else if (select == 2) {
                        MemberPayWithCash();
                        return;
                    } else {
                        System.out.println("==============================================");
                        System.out.println("번호를 잘못 누르셨습니다. 다시 선택해주세요.");
                    }
                case 2:
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

    public void useMilege() {
        while(true) {
        System.out.println("============= 마일리지 사용여부 =====================");
        System.out.println("회원님이 보유중인 마일리지는 " + nowLoginMember.getMileage() + "원입니다. 사용하시겠습니까?");
        System.out.println("1. 마일리지 사용");
        System.out.println("2. 마일리지 미사용");
        System.out.print("번호를 입력하세요. : ");
        String inputNum = sc.nextLine();

            switch (inputNum) {
                case "1":
                    System.out.println("=========================");
                    System.out.print("사용하실 마일리지 금액을 입력해 주세요 : ");
                    int inputMilege = sc.nextInt();
                    sc.nextLine();

                    if (inputMilege > nowLoginMember.getMileage()) {
                        System.out.println("고객님께서 보유하신 마일리지를 초과하였습니다. 다시 입력해주십쇼.");
                        break;
                    } else if (inputMilege <= nowLoginMember.getMileage()) {
                        System.out.println("결제 금액인 " + price + "원에 마일리지 " + inputMilege + "원을 정상적으로 사용하였습니다. 남은 금액 결제를 진행해주십쇼.");
                        price = price - inputMilege;
//                        nowLoginMember.getMileage() = nowLoginMember.getMileage() - inputMilege;
                        return;
                    } else {
                        System.out.println("번호가 입력되지 않았습니다. 다시 입력해주십쇼.");
                    }
                    break;
                case "2":
                    System.out.println("마일리지를 미사용합니다. 결제창으로 넘어갑니다.");
                    return;
            }
        }
    }

    public void MemberCardChoice() {
        PaymentCard();
//        int milege = nowLoginMember.setMileage();
//        milege = 0;
//        milege += (int)(finalPriceCard * 0.05);
//        System.out.println("적립된 마일리지 금액은 " + milege + "원 입니다.");
//        System.out.println("현재 잔여 마일리지 금액은? : " + nowLoginMember.getMileage());
    }

    public void NonMemberCardChoice() {
        PaymentCard();
        System.out.println(price + " 를 결제하겠습니다.");
        System.out.println("결제가 완료되었습니다. 즐거운 여행이 되십쇼.");

    }

    public void PaymentCard() {
        System.out.println("=============== 카드 결제를 선택하셨습니다. ===============");
        System.out.println("아래 카드사별 할인 안내표를 확인해주십쇼.");
        System.out.println("* 삼성카드 5% * 국민카드 7% * 농협카드 3% * 신한카드 1% *");
        System.out.println("1. 삼성 카드");
        System.out.println("2. 국민 카드");
        System.out.println("3. 농협 카드");
        System.out.println("4. 신한 카드");
        System.out.print("카드를 선택해 주십쇼. : ");
        int chosenCard = sc.nextInt();
        sc.nextLine();
        int finalPriceCard = (int) 0;
        int discountedPrice = (int) 0;
        switch (chosenCard) {
            case 1:
                System.out.println("=============== 삼성카드를 선택하셨습니다. ===============");
                finalPriceCard = (int) (price * 0.95);
                discountedPrice = (int) (price * 0.05);
                break;
            case 2:
                System.out.println("=============== 국민카드를 선택하셨습니다. ===============");
                finalPriceCard = (int) (price * 0.93);
                discountedPrice = (int) (price * 0.07);
                break;
            case 3:
                System.out.println("=============== 농협카드를 선택하셨습니다. ===============");
                finalPriceCard = (int) (price * 0.97);
                discountedPrice = (int) (price * 0.03);
                break;
            case 4:
                System.out.println("=============== 신한카드를 선택하셨습니다. ===============");
                finalPriceCard = (int) (price * 0.99);
                discountedPrice = (int) (price * 0.01);
                break;
            default:
                break;
        }
        System.out.println("카드 할인 적용된 금액은 " + finalPriceCard + "원 입니다. 할인된 금액은 " + (discountedPrice) + "원 입니다.\n결제 금액의 5%를 마일리지로 적립시켰습니다.");
        int milege = nowLoginMember.getMileage();
        milege = 0;
        milege += (int)(finalPriceCard * 0.05);
        System.out.println("적립된 마일리지 금액은 " + milege + "원 입니다.");
//        System.out.println("현재 잔여 마일리지 금액은? : " + nowLoginMember.getMileage());

    }

    public void PaymentCash() {
        System.out.println("=============== 현금 결제를 선택하셨습니다. ===============");
        int remainingMoney = 0;
        int num = 0;
        while (true) {
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
                        remainingMoney = price - num;
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
                        remainingMoney = price - num;
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
                        remainingMoney = price - num;
                        System.out.println("추가로 지불하셔야할 금액은 " + remainingMoney + "원 입니다.");
                        break;
                    }

            }
        }
    }

    public void MemberPayWithCash() {
        PaymentCash();
//        int milege = nowLoginMember.getMileage();
//        milege = 0;
//        milege += (int)(finalPriceCard * 0.05);
//        System.out.println("적립된 마일리지 금액은 " + milege + "원 입니다.");
//        System.out.println("현재 잔여 마일리지 금액은? : " + nowLoginMember.getMileage());
    }

    public void NonMemberPayWithCash() {
        PaymentCash();
    }
}
