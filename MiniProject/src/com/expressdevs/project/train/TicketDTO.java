package com.expressdevs.project.train;

public class TicketDTO {

    private int adultTicketCount = 0;
    private int seniorTicketCount = 0;
    private int teenagerTicketCount = 0;
    private int childrenTicketCount = 0;
    private int total = 0;


    public TicketDTO() {
    }

    public TicketDTO(int adultTicketCount, int seniorTicketCount, int teenagerTicketCount, int childrenTicketCount) {
        this.adultTicketCount = adultTicketCount;
        this.seniorTicketCount = seniorTicketCount;
        this.teenagerTicketCount = teenagerTicketCount;
        this.childrenTicketCount = childrenTicketCount;


    }

    public int getAdultTicketCount() {
        return adultTicketCount;
    }

    public void setAdultTicketCount(int adultTicketCount) {
        this.adultTicketCount = adultTicketCount;
    }

    public int getSeniorTicketCount() {
        return seniorTicketCount;
    }

    public void setSeniorTicketCount(int seniorTicketCount) {
        this.seniorTicketCount = seniorTicketCount;
    }

    public int getTeenagerTicketCount() {
        return teenagerTicketCount;
    }

    public void setTeenagerTicketCount(int teenagerTicketCount) {
        this.teenagerTicketCount = teenagerTicketCount;
    }

    public int getChildrenTicketCount() {
        return childrenTicketCount;
    }

    public void setChildrenTicketCount(int childrenTicketCount) {
        this.childrenTicketCount = childrenTicketCount;
    }

    public void setTotal(int total) {
        this.total += total;
    }

    public int getTotal() {
        return total;
    }


    public void TicketInfo() {
        String ticketNum = "";
        int num = 1;
        while (num < 4) {
            ticketNum += (int)(Math.random() * 9 + 1);
            num++;
        }
        while (num < 7) {
            ticketNum += (char) (Math.random() * 26 + 65);
            num++;
        }

        System.out.println("==============================================");
        String ticketInfo = "============== 예매하신 티켓 내역 ==============\n";
        ticketInfo += "티켓번호 : ";
        ticketInfo += ticketNum;
        ticketInfo += "\n";


        if (adultTicketCount > 0) {
            ticketInfo += "일반 " + adultTicketCount + "장, ";
        }
        if (seniorTicketCount > 0) {
            ticketInfo += "시니어 " + seniorTicketCount + "장, ";
        }
        if (teenagerTicketCount > 0) {
            ticketInfo += "어린이 " + teenagerTicketCount + "장, ";
        }
        if (childrenTicketCount > 0) {
            ticketInfo += "영유아 " + childrenTicketCount + "장 ";
        }

        ticketInfo += "입니다.";

        System.out.println(ticketInfo);
    }


}