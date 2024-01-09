package com.expressdevs.project.train;

public class TicketDTO {

    private int adultTicketCount=0;
    private int seniorTicketCount=0;
    private int teenagerTicketCount=0;
    private int childrenTicketCount=0;
    private int total =0;

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

    @Override
    public String toString() {
        return "TicketDTO{" +
                "adultTicketCount=" + adultTicketCount +
                ", seniorTicketCount=" + seniorTicketCount +
                ", teenagerTicketCount=" + teenagerTicketCount +
                ", childrenTicketCount=" + childrenTicketCount +
                ", total=" + total +
                '}';
    }
}