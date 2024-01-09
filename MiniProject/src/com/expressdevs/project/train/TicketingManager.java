package com.expressdevs.project.train;

import java.util.*;

public class TicketingManager {

    private static ArrayList<ArrayList<Integer>> trainSeats = new ArrayList<>();


    public void startTicketing() {
        String startStation = selectStartStation();
        String endStation = selectEndStation(startStation);
        String time = selectTime();
        ArrayList<Integer> seatInfo = generateSeatInfo();

        int remainingSeats = seatInfo.get(2);
        System.out.println(time + "에 " + startStation + "에서 " + endStation + "로 가는 기차의 남은 좌석 수는 " + remainingSeats + "개입니다.");

        reserveSeat(remainingSeats, seatInfo);
    }

    public String selectStartStation() {
        Scanner sc = new Scanner(System.in);
        String startStation = "";
        String[] stations = {"수서", "부산", "동대구", "대전", "동탄"};



        while (true) {

            System.out.println("============= 현재 예매 가능한 출박역 ============");
            System.out.println("1. 수서\n2. 부산\n3. 동대구\n4. 대전\n5. 동탄");
            System.out.println("==============================================");
            System.out.print("출발역을 선택하세요 (번호 입력) : ");
            int startStationIndex = sc.nextInt();

            switch (startStationIndex) {
                case 1:
                    startStation = "수서";
                    break;
                case 2:
                    startStation = "부산";

                break;
                case 3:
                    startStation = "동대구";

                break;
                case 4:
                    startStation = "대전";

                break;
                case 5:
                    startStation = "동탄";

                break;
                default:
                    System.out.println("==============================================");
                    System.out.println("유효하지 않은 역입니다. 다시 시도해주세요.");
                    continue;
            }
            return startStation;
        }
    }

    public String selectEndStation(String startStation) {
        Scanner sc = new Scanner(System.in);
        String endStation = "";
        String[] stations = {"수서", "부산", "동대구", "대전", "동탄"};
        List<String> remainingStations = new ArrayList<>(Arrays.asList(stations));

        remainingStations.remove(startStation);

        while (true) {
            System.out.println("=============== 선택 가능한 도착역 ==============");
            for (int i = 0; i < remainingStations.size(); i++) {
                System.out.println((i + 1) + ". " + remainingStations.get(i));
            }
            System.out.println("==============================================");
            System.out.print("도착역을 선택하세요  : ");
            int endStationIndex = sc.nextInt();
            if (endStationIndex < 1 || endStationIndex > remainingStations.size()) {
                System.out.println("==============================================");
                System.out.println("유효하지 않은 역입니다. 다시 시도해주세요.");
            } else {
                endStation = remainingStations.get(endStationIndex - 1);
                return endStation;
            }
        }
    }

    public String selectTime() {
        Scanner sc = new Scanner(System.in);
        String time = "";

        while (true) {
            System.out.println("============= 현재 예매 가능한 시간 ============");
            System.out.println("1. 8:30\n2. 11:30\n3. 14:30\n4. 17:30\n5. 20:30");
            System.out.println("==============================================");
            System.out.print("시간을 입력하세요 (번호 입력) : ");
            int inputTimeNo = sc.nextInt();

            switch (inputTimeNo) {
                case 1:
                    time = "8:30";
                    break;
                case 2:
                    time = "11:30";
                    break;
                case 3:
                    time = "14:30";
                    break;
                case 4:
                    time = "17:30";
                    break;
                case 5:
                    time = "20:30";
                    break;
                default:
                    System.out.println("==============================================");
                    System.out.println("유효하지 않은 시간입니다. 다시 시도해주세요.");
                    continue;
            }
            return time;
        }
    }

    public ArrayList<Integer> generateSeatInfo() {
        Random random = new Random();

        int totalSeats = random.nextInt(100);
        int reservedSeats = random.nextInt(totalSeats);
        int remainingSeats = totalSeats - reservedSeats;

        ArrayList<Integer> seatInfo = new ArrayList<>();
        seatInfo.add(totalSeats);
        seatInfo.add(reservedSeats);
        seatInfo.add(remainingSeats);

        trainSeats.add(seatInfo);

        return seatInfo;
    }

    public void reserveSeat(int remainingSeats, ArrayList<Integer> seatInfo) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==============================================");
            System.out.print("예약하실 좌석 번호를 입력하세요 (1-" + remainingSeats + ") : ");
            int seatNumber = sc.nextInt();

            if (seatNumber > 0 && seatNumber <= remainingSeats) {
                remainingSeats--;
                seatInfo.set(2, remainingSeats);
                System.out.println("좌석 " + seatNumber + "번을 선택하셨습니다.");
                break;
            } else {
                System.out.println("==============================================");
                System.out.println("유효하지 않은 좌석 번호입니다. 다시 시도해주세요.");
            }
        }
    }

}
