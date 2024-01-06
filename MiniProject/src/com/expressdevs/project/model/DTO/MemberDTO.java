package com.expressdevs.project.model.DTO;

public class MemberDTO {

    private String name;
    private int age;
    private String id;
    private String psw;
    private int mileage=0;
    public MemberDTO() {
    }

    public MemberDTO(String name, int age, String id, String psw) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.psw = psw;
    }

    public MemberDTO(String name, int age, String id, String psw, int mileage) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.psw = psw;
        this.mileage = mileage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", psw='" + psw + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mileage=" + mileage +
                '}';
    }


}

