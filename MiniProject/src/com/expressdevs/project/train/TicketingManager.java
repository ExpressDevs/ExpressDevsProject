package com.expressdevs.project.train;

import com.expressdevs.project.payment.Payment;

import java.util.*;

import static com.expressdevs.project.run.Application.timeSchedule;

public class TicketingManager {

    Scanner sc = new Scanner(System.in);
    Payment pay = new Payment();
    private String startStation;
    private String endStation;


    private static ArrayList<ArrayList<Integer>> trainSeats = new ArrayList<>();

    public TicketDTO startTicketing() {

        String startStation = selectStartStation();
        String endStation = selectEndStation(startStation);
        TicketDTO td = new TicketDTO();
        td = TicketCount();
        ArrayList<Integer> seatInfo;

        String time;
        String selectedTime = "";
        while (true) {
            time = selectTime(selectedTime);

            seatInfo = generateSeatInfo();

            if (seatInfo.get(2) < td.getTotal()) {
                System.out.println("==============================================");
                System.out.println("선택하신 시간대의 남은 좌석 수 : " + seatInfo.get(2));
                System.out.println("예매 가능한 좌석의 수가 부족합니다. 다른 시간대를 선택해주세요.");
                selectedTime = time;
            } else {
                break;
            }

        }
        int remainingSeats = seatInfo.get(2);
        System.out.println("==============================================");
        System.out.println(time + "에 " + startStation + "에서 " + endStation + "로 가는 기차의 남은 좌석 수는 " + remainingSeats + "개입니다.");
        System.out.println(td.getTotal() + "개 좌석 예매 가능합니다.");

//        reserveSeat(remainingSeats, seatInfo);

        return td;

    }

    public String selectStartStation() {
        Scanner sc = new Scanner(System.in);
        String startStation = "";

        while (true) {

            System.out.println("============= 현재 예매 가능한 출발역 ============");
            System.out.println("1. 수서역\n2. 부산역\n3. 동대구역\n4. 대전역\n5. 동탄역");
            System.out.println("==============================================");
            System.out.print("출발역을 선택하세요 (번호 입력) : ");
            int startStationIndex = sc.nextInt();

            switch (startStationIndex) {
                case 1:
                    startStation = "수서역";
                    this.startStation = startStation;
                    break;
                case 2:
                    startStation = "부산역";
                    this.startStation = startStation;
                    break;
                case 3:
                    startStation = "동대구역";
                    this.startStation = startStation;
                    break;
                case 4:
                    startStation = "대전역";
                    this.startStation = startStation;
                    break;
                case 5:
                    startStation = "동탄역";
                    this.startStation = startStation;
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
        String[] stations = {"수서역", "부산역", "동대구역", "대전역", "동탄역"};
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
                this.endStation = endStation;
                return endStation;
            }
        }
    }

    public String selectTime(String selectedTime) {
        Scanner sc = new Scanner(System.in);
        String time = "";

        while (true) {
            int num = 1;
            System.out.println("==============================================");
            System.out.println("============= 현재 예매 가능한 시간 ============");
            if (!"8:30".equals(selectedTime)) {
                System.out.println(num + ". 8:30");
                num++;
            }
            if (!"11:30".equals(selectedTime)) {
                System.out.println(num + ". 11:30");
                num++;
            }
            if (!"14:30".equals(selectedTime)) {
                System.out.println(num + ". 14:30");
                num++;
            }
            if (!"17:30".equals(selectedTime)) {
                System.out.println(num + ". 17:30");
                num++;
            }
            if (!"20:30".equals(selectedTime)) {
                System.out.println(num + ". 20:30");
                num++;
            }
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

        int totalSeats = (int) (Math.random() * 100) + 10;
        int reservedSeats = random.nextInt(totalSeats);
        int remainingSeats = totalSeats - reservedSeats;

        ArrayList<Integer> seatInfo = new ArrayList<>();
        seatInfo.add(totalSeats);
        seatInfo.add(reservedSeats);
        seatInfo.add(remainingSeats);

        trainSeats.add(seatInfo);

        return seatInfo;
    }

//    public void reserveSeat(int remainingSeats, ArrayList<Integer> seatInfo) {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("==============================================");
//            System.out.print("예약하실 좌석 번호를 입력하세요 (1-" + remainingSeats + ") : ");
//            int seatNumber = sc.nextInt();
//            sc.nextLine();
//
//            if (seatNumber > 0 && seatNumber <= remainingSeats) {
//                remainingSeats--;
//                seatInfo.set(2, remainingSeats);
//                System.out.println("좌석 " + seatNumber + "번을 선택하셨습니다.");
//                break;
//            } else {
//                System.out.println("==============================================");
//                System.out.println("유효하지 않은 좌석 번호입니다. 다시 시도해주세요.");
//            }
//        }
//    }

    public TicketDTO TicketCount() {
        TicketDTO td = new TicketDTO();
        System.out.println("==============================================");
        System.out.print("티켓 구매를 위한 인원 정보를 입력해주십쇼. : ");

        while (true) {
            System.out.println("=================== 인원정보 ==================");
            System.out.println("1. 일반 \n2. 어린이(만 6세 ~ 12세) \n3. 영유아(만 6세 미만) \n4. 노인(만 65세 이상) \n5. 다음 단계");
            System.out.println("==============================================");
            System.out.print("번호를 선택해주세요 : ");
            int age = sc.nextInt();
            sc.nextLine();

            int count = 0;
            if (age > 0 && age < 5) {
                System.out.print("구매하실 티켓 매수를 입력해주세요 : ");
                count = sc.nextInt();
                sc.nextLine();
            } else if (age == 5) {
                if (td.getTotal() != 0) {
                    System.out.println("총 " + td.getTotal() + "매 티켓을 선택하셨습니다.");
                    return td;
                } else {
                    System.out.println("선택된 티켓이 없습니다. 구입하실 티켓 매수를 입력해주세요");
                    continue;
                }

            }

            switch (age) {
                case 1:
                    td.setAdultTicketCount(count);
                    td.setTotal(count);
                    break;
                case 2:
                    td.setSeniorTicketCount(count);
                    td.setTotal(count);
                    break;
                case 3:
                    td.setTeenagerTicketCount(count);
                    td.setTotal(count);
                    break;
                case 4:
                    td.setChildrenTicketCount(count);
                    td.setTotal(count);
                    break;

                default:
                    System.out.println("==============================================");
                    System.out.println("번호를 잘못 누르셨습니다. 다시 시도해주세요.");
            }

        }
    }


    public int TimeSchedule(TicketDTO td) {
        timeSchedule.add(new TrainDTO("수서역", "부산역", 40000));
        timeSchedule.add(new TrainDTO("수서역", "동대구역", 30000));
        timeSchedule.add(new TrainDTO("수서역", "대전역", 20000));
        timeSchedule.add(new TrainDTO("수서역", "동탄역", 10000));

        timeSchedule.add(new TrainDTO("부산역", "동대구역", 10000));
        timeSchedule.add(new TrainDTO("부산역", "대전역", 10000));
        timeSchedule.add(new TrainDTO("부산역", "동탄역", 10000));
        timeSchedule.add(new TrainDTO("부산역", "수서역", 10000));

        timeSchedule.add(new TrainDTO("동대구역", "대전역", 10000));
        timeSchedule.add(new TrainDTO("동대구역", "동탄역", 10000));
        timeSchedule.add(new TrainDTO("동대구역", "수서역", 10000));
        timeSchedule.add(new TrainDTO("동대구역", "부산역", 10000));

        timeSchedule.add(new TrainDTO("대전역", "동탄역", 10000));
        timeSchedule.add(new TrainDTO("대전역", "수서역", 10000));
        timeSchedule.add(new TrainDTO("대전역", "부산역", 10000));
        timeSchedule.add(new TrainDTO("대전역", "동대구역", 10000));

        int sum = 0;
        for (int i = 0; i < timeSchedule.size(); i++) {
            if (timeSchedule.get(i).getDeparture().equals(startStation) && timeSchedule.get(i).getArrival().equals(endStation)) {
                sum =  (timeSchedule.get(i).getPrice() * td.getAdultTicketCount()) +
                        (timeSchedule.get(i).getPrice() * td.getSeniorTicketCount()) +
                        (timeSchedule.get(i).getPrice() * td.getTeenagerTicketCount()) +
                        (timeSchedule.get(i).getPrice() * td.getChildrenTicketCount());
            }

        }

        return sum;


//        for (TrainDTO price : timeSchedule) {
//            if (price.getDeparture().equals(startStation) && price.getArrival().equals(endStation)) {
//                int sum = (price.getPrice() * td.getAdultTicketCount()) +
//                        (int) (price.getPrice() * td.getSeniorTicketCount() * 0.4) +
//                        (int) (price.getPrice() * td.getTeenagerTicketCount() * 0.5) +
//                        (int) (price.getPrice() * td.getChildrenTicketCount() * 0.25);
//                System.out.println(sum);
//                System.out.println("==============================================");
//                System.out.println("총 결제 금액은 " + price.getPrice() + "입니다. 결제를 계속 진행해주세요.");
//                pay.paymentMethod(sum);
//                break;
//            }
//        }

    }

}
